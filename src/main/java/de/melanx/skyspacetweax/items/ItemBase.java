package de.melanx.skyspacetweax.items;

import de.melanx.skyspacetweax.SkyspaceTweaX;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemBase extends Item {

    protected String name;

    public ItemBase(String name) {
        this.name = name;
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(SkyspaceTweaX.creativeTab);
    }

    public void registerItemModel() {
        SkyspaceTweaX.proxy.registerItemRenderer(this, 0, name);
    }

    @Override
    public ItemBase setCreativeTab(CreativeTabs tab) {
        super.setCreativeTab(tab);
        return this;
    }

}
