package io.kalishak.sokolovsdream.client.render.entity.model;

import io.kalishak.sokolovsdream.client.render.entity.animations.WhaleAnimations;
import io.kalishak.sokolovsdream.entity.passive.WhaleEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.entity.model.EntityModelPartNames;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import org.quiltmc.loader.api.minecraft.ClientOnly;

@ClientOnly
public class WhaleEntityModel <T extends WhaleEntity> extends SinglePartEntityModel<T> {
	private final ModelPart tail;
	private final ModelPart head;
	private final ModelPart rightFin;
	private final ModelPart body;
	private final ModelPart tailFin;
	private final ModelPart leftFin;
	private final ModelPart root;

	public WhaleEntityModel(ModelPart root) {
		this.tail = root.getChild(EntityModelPartNames.TAIL);
		this.head = root.getChild(EntityModelPartNames.HEAD);
		this.rightFin = root.getChild(EntityModelPartNames.RIGHT_FIN);
		this.body = root.getChild(EntityModelPartNames.BODY);
		this.tailFin = root.getChild(EntityModelPartNames.TAIL_FIN);
		this.leftFin = root.getChild(EntityModelPartNames.LEFT_FIN);
		this.root = root.getChild(EntityModelPartNames.ROOT);
	}

	public static TexturedModelData createBodyLayer() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();

		modelPartData.addChild(EntityModelPartNames.TAIL_FIN, ModelPartBuilder.create().uv(0, 34).cuboid(6.0F, -5.0F, -4.0F, 12.0F, 5.0F, 8.0F), ModelTransform.pivot(0.0F, 24.0F, 0.0F));
		modelPartData.addChild(EntityModelPartNames.HEAD, ModelPartBuilder.create().uv(34, 15).cuboid(-15.0F, -2.0F, -5.0F, 9.0F, 2.0F, 10.0F), ModelTransform.pivot(0.0F, 24.0F, 0.0F));
		modelPartData.addChild(EntityModelPartNames.RIGHT_FIN, ModelPartBuilder.create().uv(0, 5).cuboid(-3.0F, -1.0F, 5.0F, 4.0F, 1.0F, 4.0F), ModelTransform.pivot(0.0F, 24.0F, 0.0F));
		modelPartData.addChild(EntityModelPartNames.BODY, ModelPartBuilder.create().uv(0, 18).cuboid(-6.0F, -6.0F, -5.0F, 12.0F, 6.0F, 10.0F), ModelTransform.pivot(0.0F, 24.0F, 0.0F));
		modelPartData.addChild(EntityModelPartNames.TAIL_FIN, ModelPartBuilder.create().uv(0, 0).cuboid(18.0F, -3.0F, -8.0F, 6.0F, 2.0F, 16.0F), ModelTransform.pivot(0.0F, 24.0F, 0.0F));
		modelPartData.addChild(EntityModelPartNames.LEFT_FIN, ModelPartBuilder.create().uv(0, 0).cuboid(-3.0F, -1.0F, -9.0F, 4.0F, 1.0F, 4.0F), ModelTransform.pivot(0.0F, 24.0F, 0.0F));
		modelPartData.addChild(EntityModelPartNames.ROOT, ModelPartBuilder.create().uv(28, 0).cuboid(-15.0F, -7.0F, -5.0F, 9.0F, 5.0F, 10.0F), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		return TexturedModelData.of(modelData, 128, 128);
	}

	@Override
	public ModelPart getPart() {
		return this.root;
	}

	@Override
	public void setAngles(T entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
		getPart().traverse().forEach(ModelPart::resetTransform);
		animate(entity.swimAnimationState, WhaleAnimations.SWIM, animationProgress);
		animate(entity.idleAnimationState, WhaleAnimations.IDLE, animationProgress);
	}
}
