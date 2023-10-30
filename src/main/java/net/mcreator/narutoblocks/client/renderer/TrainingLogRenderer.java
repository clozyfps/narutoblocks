
package net.mcreator.narutoblocks.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.narutoblocks.entity.TrainingLogEntity;
import net.mcreator.narutoblocks.client.model.Modeltraininglog;

public class TrainingLogRenderer extends MobRenderer<TrainingLogEntity, Modeltraininglog<TrainingLogEntity>> {
	public TrainingLogRenderer(EntityRendererProvider.Context context) {
		super(context, new Modeltraininglog(context.bakeLayer(Modeltraininglog.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(TrainingLogEntity entity) {
		return new ResourceLocation("narutoblocks:textures/entities/logtexture.png");
	}
}
