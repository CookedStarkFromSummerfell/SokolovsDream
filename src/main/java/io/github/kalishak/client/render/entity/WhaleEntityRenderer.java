package io.github.kalishak.client.render.entity;

import io.github.kalishak.SokolovsDream;
import io.github.kalishak.client.SDModelLayers;
import io.github.kalishak.client.render.entity.model.WhaleEntityModel;
import io.github.kalishak.entity.passive.WhaleEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.FrogEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import org.quiltmc.loader.api.minecraft.ClientOnly;

@ClientOnly
public class WhaleEntityRenderer extends MobEntityRenderer<WhaleEntity, WhaleEntityModel<WhaleEntity>> {
	private static final Identifier TEXTURE = SokolovsDream.tex("entity/whale.png");

	public WhaleEntityRenderer(EntityRendererFactory.Context context) {
		super(context, new WhaleEntityModel<>(context.getPart(SDModelLayers.WHALE_LAYER)), 0.7F);
	}

	@Override
	protected void scale(WhaleEntity entity, MatrixStack matrices, float amount) {
		if (!entity.isBaby()) {
			matrices.push();
			matrices.scale(10.0F, 10.0F, 10.0F);
			matrices.pop();
		} else {
			super.scale(entity, matrices, amount);
		}
	}

	@Override
	public Identifier getTexture(WhaleEntity entity) {
		return TEXTURE;
	}
}
