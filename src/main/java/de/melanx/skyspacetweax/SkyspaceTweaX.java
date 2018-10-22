package de.melanx.skyspacetweax;

import de.melanx.skyspacetweax.client.skyspacetweaxTab;
import de.melanx.skyspacetweax.items.ModItems;
import de.melanx.skyspacetweax.lib.LibMisc;
import de.melanx.skyspacetweax.proxy.CommonProxy;
import de.melanx.skyspacetweax.world.biome.BiomeTweak;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = LibMisc.MODID, name = LibMisc.NAME, version = LibMisc.VERSION, updateJSON = LibMisc.UPDATE)

public class SkyspaceTweaX {

    public static final skyspacetweaxTab creativeTab = new skyspacetweaxTab();

    @SidedProxy(clientSide = LibMisc.PROXY_CLIENT, serverSide = LibMisc.PROXY_SERVER)
    public static CommonProxy proxy;

    @Mod.EventBusSubscriber
    public static class RegistrationHandler {

        @SubscribeEvent
        public static void registerBlocks(RegistryEvent.Register<Block> event) {
            // Nothing here yet
        }

        @SubscribeEvent
        public static void registerItems(RegistryEvent.Register<Item> event) {
            ModItems.register(event.getRegistry());
        }

        @SubscribeEvent
        public static void registerModels(ModelRegistryEvent event) {
            ModItems.registerModels();
        }
    }

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        System.out.println(LibMisc.MODID + " is loading");
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        GameRegistry.registerWorldGenerator(new BiomeTweak(), 0);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        System.out.println(LibMisc.MODID + " is finished.");
    }

}
