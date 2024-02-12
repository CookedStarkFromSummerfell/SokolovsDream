/**
 * Sokolov's Dream
 * Copyright (C) 2024 Kalishak
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */
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
