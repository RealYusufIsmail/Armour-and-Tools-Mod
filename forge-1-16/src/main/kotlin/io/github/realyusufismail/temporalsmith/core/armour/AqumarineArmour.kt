/*
 * Copyright 2023 RealYusufIsmail.
 *
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *
 * you may not use this file except in compliance with the License.
 *
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */ 
package io.github.realyusufismail.temporalsmith.core.armour

import net.minecraft.entity.player.PlayerEntity
import net.minecraft.inventory.EquipmentSlotType
import net.minecraft.item.ArmorItem
import net.minecraft.item.IArmorMaterial
import net.minecraft.item.ItemStack
import net.minecraft.potion.EffectInstance
import net.minecraft.potion.Effects
import net.minecraft.world.World

class AqumarineArmour(
    materialIn: IArmorMaterial,
    armourType: EquipmentSlotType,
    builder: Properties
) : ArmorItem(materialIn, armourType, builder) {

    override fun isFoil(stack: ItemStack): Boolean {
        return false
    }

    override fun onArmorTick(stack: ItemStack, world: World, player: PlayerEntity) {
        if (player.isInWater) {
            player.addEffect(EffectInstance(Effects.DOLPHINS_GRACE, 20, 0, false, false))
            player.addEffect(EffectInstance(Effects.WATER_BREATHING, 20, 0, false, false))
        }
    }
}