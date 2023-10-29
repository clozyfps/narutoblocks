
package net.mcreator.narutoblocks.client.screens;

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

			if (

			DisplayDragonProcedure.execute()

			) {
				RenderSystem.setShaderTexture(0, new ResourceLocation("narutoblocks:textures/screens/dragon.png"));
				Minecraft.getInstance().gui.blit(event.getPoseStack(), posX + -180, posY + 50, 0, 0, 80, 30, 80, 30);
			}
			if (

			DisplaySnakeProcedure.execute()

			) {
				RenderSystem.setShaderTexture(0, new ResourceLocation("narutoblocks:textures/screens/snake.png"));
				Minecraft.getInstance().gui.blit(event.getPoseStack(), posX + -180, posY + 50, 0, 0, 80, 30, 80, 30);
			}
			if (

			DisplayOxProcedure.execute()

			) {
				RenderSystem.setShaderTexture(0, new ResourceLocation("narutoblocks:textures/screens/ox.png"));
				Minecraft.getInstance().gui.blit(event.getPoseStack(), posX + -180, posY + 50, 0, 0, 80, 30, 80, 30);
			}

			Minecraft.getInstance().font.draw(event.getPoseStack(),

					DisplayComboProcedure.execute(), posX + 117, posY + 86, -1);

		}

		RenderSystem.depthMask(true);
		RenderSystem.defaultBlendFunc();
		RenderSystem.enableDepthTest();
		RenderSystem.disableBlend();
		RenderSystem.setShaderColor(1, 1, 1, 1);
	}

}
