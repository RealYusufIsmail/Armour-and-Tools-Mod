/*
 * Copyright 2022 RealYusufIsmail.
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
package io.github.realyusufismail.armourandtoolsmod.core.init

import io.github.realyusufismail.armourandtoolsmod.ArmourAndToolsMod
import net.minecraft.core.registries.Registries
import net.minecraft.network.chat.Component
import net.minecraft.world.item.CreativeModeTab
import net.minecraft.world.item.Item
import net.minecraft.world.item.ItemStack
import net.minecraft.world.level.block.Block
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.RegistryObject

object CreativeModeTabInit {
    val CREATIVE_MODE_TAB: DeferredRegister<CreativeModeTab> =
        DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ArmourAndToolsMod.MOD_ID)

    val ARMOUR_AND_TOOLS_GROUP: RegistryObject<CreativeModeTab> =
        CREATIVE_MODE_TAB.register("armour_and_tools_tab") {
            CreativeModeTab.builder()
                .displayItems {
                    _: CreativeModeTab.ItemDisplayParameters,
                    output: CreativeModeTab.Output ->
                    ItemInit.ITEMS.entries
                        .stream()
                        .map { item: RegistryObject<Item> -> item.get().asItem() }
                        .forEach { pItem: Item -> output.accept(pItem) }

                    BlockInit.BLOCKS.entries
                        .stream()
                        .map { item: RegistryObject<Block> -> item.get().asItem() }
                        .forEach { pItem: Item -> output.accept(pItem) }
                }
                .icon { ItemStack(ItemInit.AQUMARINE.get()) }
                .title(Component.translatable("creativetab.armourandtoolsmod"))
                .build()
        }
}
