package me.thethingyee.brickmod.bases;

import net.minecraft.item.AxeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ToolMaterial;

public class AxeBase extends AxeItem {
    public AxeBase(ToolMaterial material) {
        super(material, -1, 1.2f, new Item.Settings().group(ItemGroup.TOOLS));
    }
}
