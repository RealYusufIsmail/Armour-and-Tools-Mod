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
package io.github.realyusufismail.temporalsmith.core.init

import io.github.realyusufismail.temporalsmith.TemporalSmith
import net.minecraft.core.registries.Registries
import net.minecraft.world.entity.ai.village.poi.PoiType
import net.neoforged.neoforge.registries.DeferredHolder
import net.neoforged.neoforge.registries.DeferredRegister

object POIInit {
    val POI: DeferredRegister<PoiType> =
        DeferredRegister.create(Registries.POINT_OF_INTEREST_TYPE, TemporalSmith.MOD_ID)

    @JvmField
    val ENDERITE_PORTAL_FRAME: DeferredHolder<PoiType, PoiType> =
        POI.register("enderite_portal_frame") { ->
            PoiType(setOf(BlockInit.ENDERITE_PORTAL_FRAME.get().defaultBlockState()), 0, 1)
        }
}
