
package net.mcreator.narutoblocks.client.renderer;

public class TrainingLogRenderer extends MobRenderer<TrainingLogEntity, Modeltraininglog<TrainingLogEntity>> {

	public TrainingLogRenderer(EntityRendererProvider.Context context) {
		super(context, new Modeltraininglog(context.bakeLayer(Modeltraininglog.LAYER_LOCATION)), 0.5f);

	}

	@Override
	public ResourceLocation getTextureLocation(TrainingLogEntity entity) {
		return new ResourceLocation("narutoblocks:textures/entities/logtexture.png");
	}

}
