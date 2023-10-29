
package net.mcreator.narutoblocks.network;

import net.mcreator.narutoblocks.NarutoblocksMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class HandsignThreeBindMessage {

	int type, pressedms;

	public HandsignThreeBindMessage(int type, int pressedms) {
		this.type = type;
		this.pressedms = pressedms;
	}

	public HandsignThreeBindMessage(FriendlyByteBuf buffer) {
		this.type = buffer.readInt();
		this.pressedms = buffer.readInt();
	}

	public static void buffer(HandsignThreeBindMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.type);
		buffer.writeInt(message.pressedms);
	}

	public static void handler(HandsignThreeBindMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
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

			HandsignThreePressedProcedure.execute();
		}

	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		NarutoblocksMod.addNetworkMessage(HandsignThreeBindMessage.class, HandsignThreeBindMessage::buffer, HandsignThreeBindMessage::new, HandsignThreeBindMessage::handler);
	}

}
