package com.autovw.advancednetherite;

import com.autovw.advancednetherite.core.ModItems;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

/**
 * Author: Autovw
 */
public class AdvancedNetheriteTab extends ItemGroup {

    // Creative inventory tab
    public AdvancedNetheriteTab(String name) {
        super(name);
    }

    @Override
    public ItemStack makeIcon() {
        return ModItems.NETHERITE_GOLD_INGOT.get().getDefaultInstance();
    }

    @Override
    public void fillItemList(NonNullList<ItemStack> items) {
        super.fillItemList(items);
    }
}