
package net.mcreator.narutoblocks.client.screens;

import org.checkerframework.checker.units.qual.h;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.client.event.RenderGuiEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.Minecraft;

import net.mcreator.narutoblocks.procedures.DisplaySnakeProcedure;
import net.mcreator.narutoblocks.procedures.DisplayOxProcedure;
import net.mcreator.narutoblocks.procedures.DisplayDragonProcedure;
import net.mcreator.narutoblocks.procedures.DisplayComboProcedure;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.platform.GlStateManager;

@Mod.EventBusSubscriber({Dist.CLIENT})
public class MainHUDOverlay {
	@SubscribeEvent(priority = EventPriority.NORMAL)
	public static void eventHandler(RenderGuiEvent.Pre event) {
		int w = event.getWindow().getGuiScaledWidth();
		int h = event.getWindow().getGuiScaledHeight();
		int posX = w / 2;
		int posY = h / 2;
		Level world = null;
		double x = 0;
		double y = 0;
		double z = 0;
		Player entity = Minecraft.getInstance().player;
		if (entity != null) {
			world = entity.level;
			x = entity.getX();
			y = entity.getY();
			z = entity.getZ();
		}
		RenderSystem.disableDepthTest();
		RenderSystem.depthMask(false);
		RenderSystem.enableBlend();
		RenderSystem.setShader(GameRenderer::getPositionTexShader);
		RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
		RenderSystem.setShaderColor(1, 1, 1, 1);
		if (true) {
			if (DisplayDragonProcedure.execute(entity)) {
				RenderSystem.setShaderTexture(0, new ResourceLocation("narutoblocks:textures/screens/dragon.png"));
				Minecraft.getInstance().gui.blit(event.getPoseStack(), posX + -180, posY + 50, 0, 0, 80, 30, 80, 30);
			}
			if (DisplaySnakeProcedure.execute(entity)) {
				RenderSystem.setShaderTexture(0, new ResourceLocation("narutoblocks:textures/screens/snake.png"));
				Minecraft.getInstance().gui.blit(event.getPoseStack(), posX + -180, posY + 50, 0, 0, 80, 30, 80, 30);
			}
			if (DisplayOxProcedure.execute(entity)) {
				RenderSystem.setShaderTexture(0, new ResourceLocation("narutoblocks:textures/screens/ox.png"));
				Minecraft.getInstance().gui.blit(event.getPoseStack(), posX + -180, posY + 50, 0, 0, 80, 30, 80, 30);
			}
			Minecraft.getInstance().font.draw(event.getPoseStack(),

					DisplayComboProcedure.execute(entity), posX + 117, posY + 86, -1);
		}
		RenderSystem.depthMask(true);
		RenderSystem.defaultBlendFunc();
		RenderSystem.enableDepthTest();
		RenderSystem.disableBlend();
		RenderSystem.setShaderColor(1, 1, 1, 1);
	}
}
