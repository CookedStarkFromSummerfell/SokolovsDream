package io.github.kalishak.client.render.entity.animations;

import net.minecraft.client.render.animation.Animation;
import net.minecraft.client.render.animation.AnimationKeyframe;
import net.minecraft.client.render.animation.Animator;
import net.minecraft.client.render.animation.PartAnimation;
import net.minecraft.client.render.entity.model.EntityModelPartNames;
import org.quiltmc.loader.api.minecraft.ClientOnly;

@ClientOnly
public class WhaleAnimations  {
	public static final Animation SWIM = Animation.Builder.withLength(1.0F)
		.addPartAnimation(EntityModelPartNames.TAIL, new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0F, Animator.rotate(0.0F, 0.0F, 5.0F), PartAnimation.Interpolations.LINEAR),
			new AnimationKeyframe(0.25F, Animator.rotate(0.0F, 0.0F, -5.0F), PartAnimation.Interpolations.LINEAR),
			new AnimationKeyframe(0.5F, Animator.rotate(0.0F, 0.0F, 2.5F), PartAnimation.Interpolations.LINEAR),
			new AnimationKeyframe(0.75F, Animator.rotate(0.0F, 0.0F, 7.5F), PartAnimation.Interpolations.LINEAR),
			new AnimationKeyframe(1.0F, Animator.rotate(0.0F, 0.0F, 0.0F), PartAnimation.Interpolations.LINEAR)
		))
		.addPartAnimation(EntityModelPartNames.RIGHT_FIN, new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0F, Animator.rotate(0.0F, 0.0F, 0.0F), PartAnimation.Interpolations.LINEAR),
			new AnimationKeyframe(0.125F, Animator.rotate(-5.0F, 0.0F, 0.0F), PartAnimation.Interpolations.LINEAR),
			new AnimationKeyframe(0.375F, Animator.rotate(5.0F, 0.0F, 0.0F), PartAnimation.Interpolations.LINEAR),
			new AnimationKeyframe(0.625F, Animator.rotate(-7.5F, 0.0F, 0.0F), PartAnimation.Interpolations.LINEAR),
			new AnimationKeyframe(0.875F, Animator.rotate(2.5F, 0.0F, 0.0F), PartAnimation.Interpolations.LINEAR)
		))
		.addPartAnimation(EntityModelPartNames.BODY, new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0F, Animator.rotate(0.0F, 0.0F, 5.0F), PartAnimation.Interpolations.LINEAR),
			new AnimationKeyframe(0.25F, Animator.rotate(0.0F, 0.0F, -5.0F), PartAnimation.Interpolations.LINEAR),
			new AnimationKeyframe(0.5F, Animator.rotate(0.0F, 0.0F, 5.0F), PartAnimation.Interpolations.LINEAR),
			new AnimationKeyframe(0.75F, Animator.rotate(0.0F, 0.0F, 12.5F), PartAnimation.Interpolations.LINEAR),
			new AnimationKeyframe(1.0F, Animator.rotate(0.0F, 0.0F, 2.5F), PartAnimation.Interpolations.LINEAR)
		))
		.addPartAnimation(EntityModelPartNames.TAIL_FIN, new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0F, Animator.rotate(0.0F, 0.0F, 5.0F), PartAnimation.Interpolations.LINEAR),
			new AnimationKeyframe(0.25F, Animator.rotate(0.0F, 0.0F, -5.0F), PartAnimation.Interpolations.LINEAR),
			new AnimationKeyframe(0.5F, Animator.rotate(0.0F, 0.0F, 5.0F), PartAnimation.Interpolations.LINEAR),
			new AnimationKeyframe(0.75F, Animator.rotate(0.0F, 0.0F, 12.5F), PartAnimation.Interpolations.LINEAR),
			new AnimationKeyframe(1.0F, Animator.rotate(0.0F, 0.0F, 0.0F), PartAnimation.Interpolations.LINEAR)
		))
		.addPartAnimation(EntityModelPartNames.LEFT_FIN, new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0F, Animator.rotate(0.0F, 0.0F, 0.0F), PartAnimation.Interpolations.LINEAR),
			new AnimationKeyframe(0.125F, Animator.rotate(-5.0F, 0.0F, 0.0F), PartAnimation.Interpolations.LINEAR),
			new AnimationKeyframe(0.375F, Animator.rotate(-10.0F, 0.0F, 0.0F), PartAnimation.Interpolations.LINEAR),
			new AnimationKeyframe(0.625F, Animator.rotate(10.0F, 0.0F, 0.0F), PartAnimation.Interpolations.LINEAR),
			new AnimationKeyframe(0.875F, Animator.rotate(0.0F, 0.0F, 0.0F), PartAnimation.Interpolations.LINEAR)
		))
		.build();

	public static final Animation IDLE = Animation.Builder.withLength(0.25F)
		.addPartAnimation("head", new PartAnimation(PartAnimation.AnimationTargets.ROTATE,
			new AnimationKeyframe(0.0F, Animator.rotate(0.0F, 0.0F, -2.5F), PartAnimation.Interpolations.LINEAR),
			new AnimationKeyframe(0.0417F, Animator.rotate(0.0F, 0.0F, -5.0F), PartAnimation.Interpolations.LINEAR),
			new AnimationKeyframe(0.125F, Animator.rotate(0.0F, 0.0F, -7.5F), PartAnimation.Interpolations.LINEAR),
			new AnimationKeyframe(0.1667F, Animator.rotate(0.0F, 0.0F, -5.0F), PartAnimation.Interpolations.LINEAR),
			new AnimationKeyframe(0.2083F, Animator.rotate(0.0F, 0.0F, -2.5F), PartAnimation.Interpolations.LINEAR),
			new AnimationKeyframe(0.25F, Animator.rotate(0.0F, 0.0F, 0.0F), PartAnimation.Interpolations.LINEAR)
		))
		.build();
}
