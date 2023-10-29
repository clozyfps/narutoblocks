
package net.mcreator.narutoblocks.network;

import net.mcreator.narutoblocks.NarutoblocksMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class HandsignTwoBindMessage {

	int type, pressedms;

	public HandsignTwoBindMessage(int type, int pressedms) {
		this.type = type;
		this.pressedms = pressedms;
	}

	public HandsignTwoBindMessage(FriendlyByteBuf buffer) {
		this.type = buffer.readInt();
		this.pressedms = buffer.readInt();
	}

	public static void buffer(HandsignTwoBindMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.type);
		buffer.writeInt(message.pressedms);
	}

	public static void handler(HandsignTwoBindMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
		NetworkEvent.Context context = contextSupplier.get();
		context.enqueueWork(() -> {
			pressAction(context.getSender(), message.type, message.pressedms);
		});
		context.setPacketHandled(true);
	}

	public static void pressAction(Player entity, int type, int pressedms) {
		Level world = entity.level;
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();

		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(entity.blockPosition()))
			return;

		if (type == 0) {

			HandsignTwoPressedProcedure.execute(entity);
		}

	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		NarutoblocksMod.addNetworkMessage(HandsignTwoBindMessage.class, HandsignTwoBindMessage::buffer, HandsignTwoBindMessage::new, HandsignTwoBindMessage::handler);
	}

}
