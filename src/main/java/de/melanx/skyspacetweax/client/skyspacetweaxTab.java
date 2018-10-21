package de.melanx.skyspacetweax.client;

import de.melanx.skyspacetweax.items.ModItems;
import de.melanx.skyspacetweax.lib.LibMisc;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class skyspacetweaxTab extends CreativeTabs {

    public skyspacetweaxTab() {
        super(LibMisc.MODID);
    }

    @Override
    public ItemStack getTabIconItem() {
        return new ItemStack(ModItems.weakstar);
    }

}
