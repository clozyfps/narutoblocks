
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.narutoblocks.init;

import org.lwjgl.glfw.GLFW;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.Minecraft;
import net.minecraft.client.KeyMapping;

import net.mcreator.narutoblocks.network.HandsignTwoBindMessage;
import net.mcreator.narutoblocks.network.HandsignThreeBindMessage;
import net.mcreator.narutoblocks.network.HandsignOneBindMessage;
import net.mcreator.narutoblocks.NarutoblocksMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class NarutoblocksModKeyMappings {
	public static final KeyMapping HANDSIGN_TWO_BIND = new KeyMapping("key.narutoblocks.handsign_two_bind", GLFW.GLFW_KEY_X, "key.categories.naruto") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				NarutoblocksMod.PACKET_HANDLER.sendToServer(new HandsignTwoBindMessage(0, 0));
				HandsignTwoBindMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping HANDSIGN_ONE_BIND = new KeyMapping("key.narutoblocks.handsign_one_bind", GLFW.GLFW_KEY_Z, "key.categories.naruto") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				NarutoblocksMod.PACKET_HANDLER.sendToServer(new HandsignOneBindMessage(0, 0));
				HandsignOneBindMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping HANDSIGN_THREE_BIND = new KeyMapping("key.narutoblocks.handsign_three_bind", GLFW.GLFW_KEY_C, "key.categories.naruto") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				NarutoblocksMod.PACKET_HANDLER.sendToServer(new HandsignThreeBindMessage(0, 0));
				HandsignThreeBindMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};

	@SubscribeEvent
	public static void registerKeyMappings(RegisterKeyMappingsEvent event) {
		event.register(HANDSIGN_TWO_BIND);
		event.register(HANDSIGN_ONE_BIND);
		event.register(HANDSIGN_THREE_BIND);
	}

	@Mod.EventBusSubscriber({Dist.CLIENT})
	public static class KeyEventListener {
		@SubscribeEvent
		public static void onClientTick(TickEvent.ClientTickEvent event) {
			if (Minecraft.getInstance().screen == null) {
				HANDSIGN_TWO_BIND.consumeClick();
				HANDSIGN_ONE_BIND.consumeClick();
				HANDSIGN_THREE_BIND.consumeClick();
			}
		}
	}
}
