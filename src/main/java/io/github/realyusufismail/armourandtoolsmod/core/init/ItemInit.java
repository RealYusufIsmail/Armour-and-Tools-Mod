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
package io.github.realyusufismail.armourandtoolsmod.core.init;

import io.github.realyusufismail.armourandtoolsmod.core.armour.*;
import io.github.realyusufismail.armourandtoolsmod.core.material.ArmourMaterialInit;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static io.github.realyusufismail.armourandtoolsmod.ArmourAndToolsMod.MOD_ID;

public class ItemInit {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, MOD_ID);

    // ore item
    public static final RegistryObject<Item> RUBY =
            ITEMS.register("ruby", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAINBOW =
            ITEMS.register("rainbow", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SAPPHIRE =
            ITEMS.register("sapphire", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> GRAPHITE =
            ITEMS.register("graphite", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> AQUMARINE =
            ITEMS.register("aqumarine", () -> new Item(new Item.Properties()));

    // raw ore item
    public static final RegistryObject<Item> RAW_RUBY =
            ITEMS.register("raw_ruby", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_RAINBOW =
            ITEMS.register("raw_rainbow", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_SAPPHIRE =
            ITEMS.register("raw_sapphire", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_GRAPHITE =
            ITEMS.register("raw_graphite", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_AQUMARINE =
            ITEMS.register("raw_aqumarine", () -> new Item(new Item.Properties()));

    // armour
    public static final RegistryObject<Item> AMETHYST_HELMET =
            ITEMS.register("amethyst_helmet", () -> new AmethystArmour(ArmourMaterialInit.AMETHYST,
                    EquipmentSlot.HEAD, new Item.Properties()));
    public static final RegistryObject<Item> AMETHYST_CHESTPLATE = ITEMS
        .register("amethyst_chestplate", () -> new AmethystArmour(ArmourMaterialInit.AMETHYST,
                EquipmentSlot.CHEST, new Item.Properties()));
    public static final RegistryObject<Item> AMETHYST_LEGGINGS = ITEMS.register("amethyst_leggings",
            () -> new AmethystArmour(ArmourMaterialInit.AMETHYST, EquipmentSlot.LEGS,
                    new Item.Properties()));
    public static final RegistryObject<Item> AMETHYST_BOOTS =
            ITEMS.register("amethyst_boots", () -> new AmethystArmour(ArmourMaterialInit.AMETHYST,
                    EquipmentSlot.FEET, new Item.Properties()));

    public static final RegistryObject<Item> RUBY_HELMET =
            ITEMS.register("ruby_helmet", () -> new RubyArmour(ArmourMaterialInit.RUBY,
                    EquipmentSlot.HEAD, new Item.Properties()));
    public static final RegistryObject<Item> RUBY_CHESTPLATE =
            ITEMS.register("ruby_chestplate", () -> new RubyArmour(ArmourMaterialInit.RUBY,
                    EquipmentSlot.CHEST, new Item.Properties()));
    public static final RegistryObject<Item> RUBY_LEGGINGS =
            ITEMS.register("ruby_leggings", () -> new RubyArmour(ArmourMaterialInit.RUBY,
                    EquipmentSlot.LEGS, new Item.Properties()));
    public static final RegistryObject<Item> RUBY_BOOTS =
            ITEMS.register("ruby_boots", () -> new RubyArmour(ArmourMaterialInit.RUBY,
                    EquipmentSlot.FEET, new Item.Properties()));

    public static final RegistryObject<Item> RAINBOW_HELMET =
            ITEMS.register("rainbow_helmet", () -> new RainbowArmour(ArmourMaterialInit.RAINBOW,
                    EquipmentSlot.HEAD, new Item.Properties()));
    public static final RegistryObject<Item> RAINBOW_CHESTPLATE =
            ITEMS.register("rainbow_chestplate", () -> new RainbowArmour(ArmourMaterialInit.RAINBOW,
                    EquipmentSlot.CHEST, new Item.Properties()));
    public static final RegistryObject<Item> RAINBOW_LEGGINGS =
            ITEMS.register("rainbow_leggings", () -> new RainbowArmour(ArmourMaterialInit.RAINBOW,
                    EquipmentSlot.LEGS, new Item.Properties()));
    public static final RegistryObject<Item> RAINBOW_BOOTS =
            ITEMS.register("rainbow_boots", () -> new RainbowArmour(ArmourMaterialInit.RAINBOW,
                    EquipmentSlot.FEET, new Item.Properties()));

    public static final RegistryObject<Item> SAPPHIRE_HELMET =
            ITEMS.register("sapphire_helmet", () -> new SapphireArmour(ArmourMaterialInit.SAPPHIRE,
                    EquipmentSlot.HEAD, new Item.Properties()));
    public static final RegistryObject<Item> SAPPHIRE_CHESTPLATE = ITEMS
        .register("sapphire_chestplate", () -> new SapphireArmour(ArmourMaterialInit.SAPPHIRE,
                EquipmentSlot.CHEST, new Item.Properties()));
    public static final RegistryObject<Item> SAPPHIRE_LEGGINGS = ITEMS.register("sapphire_leggings",
            () -> new SapphireArmour(ArmourMaterialInit.SAPPHIRE, EquipmentSlot.LEGS,
                    new Item.Properties()));
    public static final RegistryObject<Item> SAPPHIRE_BOOTS =
            ITEMS.register("sapphire_boots", () -> new SapphireArmour(ArmourMaterialInit.SAPPHIRE,
                    EquipmentSlot.FEET, new Item.Properties()));

    public static final RegistryObject<Item> GRAPHITE_HELMET =
            ITEMS.register("graphite_helmet", () -> new GraphiteArmour(ArmourMaterialInit.GRAPHITE,
                    EquipmentSlot.HEAD, new Item.Properties()));
    public static final RegistryObject<Item> GRAPHITE_CHESTPLATE = ITEMS
        .register("graphite_chestplate", () -> new GraphiteArmour(ArmourMaterialInit.GRAPHITE,
                EquipmentSlot.CHEST, new Item.Properties()));
    public static final RegistryObject<Item> GRAPHITE_LEGGINGS = ITEMS.register("graphite_leggings",
            () -> new GraphiteArmour(ArmourMaterialInit.GRAPHITE, EquipmentSlot.LEGS,
                    new Item.Properties()));
    public static final RegistryObject<Item> GRAPHITE_BOOTS =
            ITEMS.register("graphite_boots", () -> new GraphiteArmour(ArmourMaterialInit.GRAPHITE,
                    EquipmentSlot.FEET, new Item.Properties()));

    public static final RegistryObject<Item> AQUMARINE_HELMET = ITEMS.register("aqumarine_helmet",
            () -> new AqumarineArmour(ArmourMaterialInit.AQUMARINE, EquipmentSlot.HEAD,
                    new Item.Properties()));
    public static final RegistryObject<Item> AQUMARINE_CHESTPLATE = ITEMS
        .register("aqumarine_chestplate", () -> new AqumarineArmour(ArmourMaterialInit.AQUMARINE,
                EquipmentSlot.CHEST, new Item.Properties()));
    public static final RegistryObject<Item> AQUMARINE_LEGGINGS = ITEMS
        .register("aqumarine_leggings", () -> new AqumarineArmour(ArmourMaterialInit.AQUMARINE,
                EquipmentSlot.LEGS, new Item.Properties()));
    public static final RegistryObject<Item> AQUMARINE_BOOTS = ITEMS.register("aqumarine_boots",
            () -> new AqumarineArmour(ArmourMaterialInit.AQUMARINE, EquipmentSlot.FEET,
                    new Item.Properties()));

    // TODO: Add tools and weapons including tridents. Maybe custom shields?
}