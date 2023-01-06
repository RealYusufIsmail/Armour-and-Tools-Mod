package io.github.realyusufismail.armourandtoolsmod;

import io.github.realyusufismail.armourandtoolsmod.core.itemgroup.ArmourAndToolsGroup;
import io.github.realyusufismail.armourandtoolsmod.datagen.DataGenerators;
import io.github.realyusufismail.realyusufismailcore.RealYusufIsmailCore;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(ArmourAndToolsMod.MOD_ID)
@Mod.EventBusSubscriber(modid = ArmourAndToolsMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ArmourAndToolsMod {
    public static final Logger logger = LogManager.getLogger();
    public static final String MOD_ID = "armourandtoolsmod";

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, MOD_ID);

    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, MOD_ID);

    public ArmourAndToolsMod() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        ITEMS.register(bus);
        BLOCKS.register(bus);

        // Register the item to a creative tab
        bus.addListener(ArmourAndToolsGroup::registerCreativeTab);
        // Register the data generators
        bus.addListener(DataGenerators::gatherData);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        logger.info("Loaded Armour and Item Mod");
    }
}