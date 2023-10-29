package net.mcreator.narutoblocks.network;

import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.Capability;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.nbt.Tag;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.Direction;
import net.minecraft.client.Minecraft;

import net.mcreator.narutoblocks.NarutoblocksMod;

import java.util.function.Supplier;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class NarutoblocksModVariables {
	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		NarutoblocksMod.addNetworkMessage(PlayerVariablesSyncMessage.class, PlayerVariablesSyncMessage::buffer, PlayerVariablesSyncMessage::new, PlayerVariablesSyncMessage::handler);
	}

	@SubscribeEvent
	public static void init(RegisterCapabilitiesEvent event) {
		event.register(PlayerVariables.class);
	}

	@Mod.EventBusSubscriber
	public static class EventBusVariableHandlers {
		@SubscribeEvent
		public static void onPlayerLoggedInSyncPlayerVariables(PlayerEvent.PlayerLoggedInEvent event) {
			if (!event.getEntity().level.isClientSide())
				((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void onPlayerRespawnedSyncPlayerVariables(PlayerEvent.PlayerRespawnEvent event) {
			if (!event.getEntity().level.isClientSide())
				((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void onPlayerChangedDimensionSyncPlayerVariables(PlayerEvent.PlayerChangedDimensionEvent event) {
			if (!event.getEntity().level.isClientSide())
				((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void clonePlayer(PlayerEvent.Clone event) {
			event.getOriginal().revive();
			PlayerVariables original = ((PlayerVariables) event.getOriginal().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
			PlayerVariables clone = ((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
			clone.Taijutsu = original.Taijutsu;
			clone.Agility = original.Agility;
			clone.Defense = original.Defense;
			clone.Chakra = original.Chakra;
			clone.ChakraMax = original.ChakraMax;
			clone.ChakraGainRate = original.ChakraGainRate;
			clone.JutsuMastery = original.JutsuMastery;
			clone.TaijutsuStatGain = original.TaijutsuStatGain;
			if (!event.isWasDeath()) {
				clone.LastPressed = original.LastPressed;
				clone.Combination = original.Combination;
			}
		}
	}

	public static final Capability<PlayerVariables> PLAYER_VARIABLES_CAPABILITY = CapabilityManager.get(new CapabilityToken<PlayerVariables>() {
	});

	@Mod.EventBusSubscriber
	private static class PlayerVariablesProvider implements ICapabilitySerializable<Tag> {
		@SubscribeEvent
		public static void onAttachCapabilities(AttachCapabilitiesEvent<Entity> event) {
			if (event.getObject() instanceof Player && !(event.getObject() instanceof FakePlayer))
				event.addCapability(new ResourceLocation("narutoblocks", "player_variables"), new PlayerVariablesProvider());
		}

		private final PlayerVariables playerVariables = new PlayerVariables();
		private final LazyOptional<PlayerVariables> instance = LazyOptional.of(() -> playerVariables);

		@Override
		public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
			return cap == PLAYER_VARIABLES_CAPABILITY ? instance.cast() : LazyOptional.empty();
		}

		@Override
		public Tag serializeNBT() {
			return playerVariables.writeNBT();
		}

		@Override
		public void deserializeNBT(Tag nbt) {
			playerVariables.readNBT(nbt);
		}
	}

	public static class PlayerVariables {
		public double Taijutsu = 0;
		public double Agility = 0;
		public double Defense = 0;
		public double Chakra = 0;
		public double ChakraMax = 0;
		public double ChakraGainRate = 0;
		public double JutsuMastery = 0;
		public double TaijutsuStatGain = 0;
		public String LastPressed = "";
		public String Combination = "";

		public void syncPlayerVariables(Entity entity) {
			if (entity instanceof ServerPlayer serverPlayer)
				NarutoblocksMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> serverPlayer), new PlayerVariablesSyncMessage(this));
		}

		public Tag writeNBT() {
			CompoundTag nbt = new CompoundTag();
			nbt.putDouble("Taijutsu", Taijutsu);
			nbt.putDouble("Agility", Agility);
			nbt.putDouble("Defense", Defense);
			nbt.putDouble("Chakra", Chakra);
			nbt.putDouble("ChakraMax", ChakraMax);
			nbt.putDouble("ChakraGainRate", ChakraGainRate);
			nbt.putDouble("JutsuMastery", JutsuMastery);
			nbt.putDouble("TaijutsuStatGain", TaijutsuStatGain);
			nbt.putString("LastPressed", LastPressed);
			nbt.putString("Combination", Combination);
			return nbt;
		}

		public void readNBT(Tag Tag) {
			CompoundTag nbt = (CompoundTag) Tag;
			Taijutsu = nbt.getDouble("Taijutsu");
			Agility = nbt.getDouble("Agility");
			Defense = nbt.getDouble("Defense");
			Chakra = nbt.getDouble("Chakra");
			ChakraMax = nbt.getDouble("ChakraMax");
			ChakraGainRate = nbt.getDouble("ChakraGainRate");
			JutsuMastery = nbt.getDouble("JutsuMastery");
			TaijutsuStatGain = nbt.getDouble("TaijutsuStatGain");
			LastPressed = nbt.getString("LastPressed");
			Combination = nbt.getString("Combination");
		}
	}

	public static class PlayerVariablesSyncMessage {
		public PlayerVariables data;

		public PlayerVariablesSyncMessage(FriendlyByteBuf buffer) {
			this.data = new PlayerVariables();
			this.data.readNBT(buffer.readNbt());
		}

		public PlayerVariablesSyncMessage(PlayerVariables data) {
			this.data = data;
		}

		public static void buffer(PlayerVariablesSyncMessage message, FriendlyByteBuf buffer) {
			buffer.writeNbt((CompoundTag) message.data.writeNBT());
		}

		public static void handler(PlayerVariablesSyncMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				if (!context.getDirection().getReceptionSide().isServer()) {
					PlayerVariables variables = ((PlayerVariables) Minecraft.getInstance().player.getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
					variables.Taijutsu = message.data.Taijutsu;
					variables.Agility = message.data.Agility;
					variables.Defense = message.data.Defense;
					variables.Chakra = message.data.Chakra;
					variables.ChakraMax = message.data.ChakraMax;
					variables.ChakraGainRate = message.data.ChakraGainRate;
					variables.JutsuMastery = message.data.JutsuMastery;
					variables.TaijutsuStatGain = message.data.TaijutsuStatGain;
					variables.LastPressed = message.data.LastPressed;
					variables.Combination = message.data.Combination;
				}
			});
			context.setPacketHandled(true);
		}
	}
}
