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
package io.github.realyusufismail.armourandtoolsmod

import io.github.realyusufismail.armourandtoolsmod.client.ClientSetup
import io.github.realyusufismail.armourandtoolsmod.core.init.*
import io.github.realyusufismail.armourandtoolsmod.core.itemgroup.ArmourAndToolsGroup
import io.github.realyusufismail.armourandtoolsmod.datagen.DataGenerators
import java.util.*
import net.minecraft.resources.ResourceLocation
import net.minecraftforge.fml.common.Mod
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import thedarkcolour.kotlinforforge.KotlinModLoadingContext
import thedarkcolour.kotlinforforge.forge.FORGE_BUS

const val MOD_ID = "armourandtoolsmod"

@Mod(MOD_ID)
class ArmourAndToolsMod {
    init {
        val bus = KotlinModLoadingContext.get().getKEventBus()
        ItemInit.ITEMS.register(bus)
        BlockInit.BLOCKS.register(bus)
        MenuTypeInit.MENU.register(bus)
        RecipeSerializerInit.SERIALIZERS.register(bus)
        RecipeTypeInit.RECIPE_TYPES.register(bus)

        // Register the item to a creative tab
        bus.addListener(ArmourAndToolsGroup::registerCreativeTab)
        // Register the data generators
        bus.addListener(DataGenerators::gatherData)
        // adds recipe category
        bus.addListener(RecipeCategoriesInit::registerRecipeBookCategories)
        // client setup listener
        bus.addListener(ClientSetup::clientSetup)
        // register shields
        bus.addListener(ClientSetup::shieldInit)

        // Register ourselves for server and other game events we are interested in
        FORGE_BUS.register(this)
        logger.info("Loaded Armour and Item Mod")
    }

    companion object ArmorAndToolsMod {
        val logger: Logger = LoggerFactory.getLogger(ArmourAndToolsMod::class.java)

        fun getModIdAndName(name: String): ResourceLocation {
            logger.info(
                "Getting mod id and name" +
                    ResourceLocation(MOD_ID, name.lowercase(Locale.getDefault())).toDebugFileName())
            return ResourceLocation(MOD_ID, name.lowercase(Locale.getDefault()))
        }

        fun getPath(path: String): ResourceLocation {
            return ResourceLocation(MOD_ID, path)
        }
    }
}
