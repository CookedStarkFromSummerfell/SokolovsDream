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
