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
package io.github.realyusufismail.armourandtoolsmod.datagen.recipe.builder

import com.google.gson.JsonArray
import com.google.gson.JsonObject
import io.github.realyusufismail.armourandtoolsmod.core.init.RecipeSerializerInit
import java.util.*
import java.util.function.Consumer
import net.minecraft.advancements.Advancement
import net.minecraft.advancements.AdvancementRewards
import net.minecraft.advancements.RequirementsStrategy
import net.minecraft.advancements.critereon.InventoryChangeTrigger
import net.minecraft.advancements.critereon.RecipeUnlockedTrigger
import net.minecraft.data.recipes.FinishedRecipe
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.item.Item
import net.minecraft.world.item.crafting.Ingredient
import net.minecraft.world.item.crafting.RecipeSerializer
import net.minecraftforge.registries.ForgeRegistries

class IngotFusionTollEnhancerRecipeBuilder(
    private val input1: Ingredient,
    private val input2: Ingredient,
    private val input3: Ingredient,
    private val output: Item
) {
    private val advancementBuilder = Advancement.Builder.advancement()

    fun unlockedBy(
        criterionId: String,
        criterion: InventoryChangeTrigger.TriggerInstance
    ): IngotFusionTollEnhancerRecipeBuilder {
        advancementBuilder.addCriterion(criterionId, criterion)
        return this
    }

    fun save(consumer: Consumer<FinishedRecipe>, rl: ResourceLocation) {
        try {
            ensureValid(rl)
            if (advancementBuilder.criteria.isNotEmpty())
                advancementBuilder
                    .parent(ResourceLocation("recipes/root"))
                    .addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(rl))
                    .rewards(AdvancementRewards.Builder.recipe(rl))
                    .requirements(RequirementsStrategy.OR)
            consumer.accept(
                Output(
                    input1,
                    input2,
                    input3,
                    output,
                    advancementBuilder,
                    ResourceLocation(rl.namespace, "recipes/root").also { advancementId ->
                        advancementBuilder.parent(advancementId)
                    },
                    rl))
        } catch (e: IllegalStateException) {
            throw IllegalStateException("Could not create recipe: $rl", e)
        }
    }

    private fun ensureValid(rl: ResourceLocation) {
        check(advancementBuilder.criteria.isNotEmpty()) { "Can not obtain recipe: $rl" }
    }

    /**
     * Protip: The error has a string, seaching for that string will give more context
     *
     * @param input1 The first input item
     * @param input2 The second input item
     * @param input3 The third input item
     * @param output The output item
     * @param category The recipe category
     * @param advancementId The advancement id
     * @param id The recipe id
     */
    @JvmRecord
    private data class Output(
        val input1: Ingredient,
        val input2: Ingredient,
        val input3: Ingredient,
        val output: Item,
        val advancementBuilder: Advancement.Builder,
        val advancementId: ResourceLocation,
        val id: ResourceLocation
    ) : FinishedRecipe {
        override fun serializeRecipeData(json: JsonObject) {
            val jsonArray = JsonArray()
            val ingredients = arrayOf(input1, input2, input3)

            for (ingredient in ingredients) {
                jsonArray.add(ingredient.toJson())
            }

            json.add("ingredients", jsonArray)

            //TODO: Update to add new fuel slot

            val jsonObject = JsonObject()
            jsonObject.addProperty("item", ForgeRegistries.ITEMS.getKey(output).toString())
            json.add("result", jsonObject)

            println(json.toString())
        }

        override fun getId(): ResourceLocation {
            return id
        }

        override fun getType(): RecipeSerializer<*> {
            return RecipeSerializerInit.INGOT_FUSION_TOLL_ENHANCER_RECIPE.get()
        }

        override fun serializeAdvancement(): JsonObject? {
            return if (advancementBuilder.criteria.isEmpty()) advancementBuilder.serializeToJson()
            else null
        }

        override fun getAdvancementId(): ResourceLocation {
            return advancementId
        }
    }

    companion object {
        fun builder(
            input1: Item,
            input2: Item,
            input3: Item,
            output: Item
        ): IngotFusionTollEnhancerRecipeBuilder {
            return IngotFusionTollEnhancerRecipeBuilder(
                ingredient(input1), ingredient(input2), ingredient(input3), output)
        }

        private fun ingredient(entry: Item): Ingredient {
            return Ingredient.of(entry)
        }
    }
}
