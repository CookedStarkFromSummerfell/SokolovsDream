package io.kalishak.sokolovsdream;

import net.minecraft.util.Identifier;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;

public class SokolovsDream implements ModInitializer {
	public static final String MODID = "sokolovsdream";

	@Override
	public void onInitialize(ModContainer mod) {

	}

	public static Identifier id(String name) {
		return new Identifier(MODID, name);
	}

	public static Identifier tex(String assetName) {
		return id(assetName).withPrefix("textures/");
	}
}
