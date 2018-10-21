package de.melanx.skyspacetweax.items;

import net.minecraft.item.Item;
import net.minecraftforge.registries.IForgeRegistry;

public class ModItems {
    public static ItemBase weakstar = new ItemBase("weak_nether_star");

    public static void register(IForgeRegistry<Item> registry) {

        registry.registerAll(
                weakstar
        );

    }

    public static void registerModels() {
        weakstar.registerItemModel();
    }

}