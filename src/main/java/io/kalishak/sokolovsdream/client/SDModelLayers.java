package io.kalishak.sokolovsdream.client;

import io.kalishak.sokolovsdream.SokolovsDream;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;
import org.quiltmc.loader.api.minecraft.ClientOnly;

@ClientOnly
public class SDModelLayers {
	public static final EntityModelLayer WHALE_LAYER = modelMain("whale");

	private static EntityModelLayer modelMain(String modelName) {
		return new EntityModelLayer(new Identifier(SokolovsDream.MODID, modelName), "main");
	}
}
