/*------------------------------------------------------------------------------
 Copyright (c) CovertJaguar, 2011-2017
 http://railcraft.info

 This code is the property of CovertJaguar
 and may only be used with explicit written
 permission unless otherwise specified on the
 license page at http://railcraft.info/wiki/info:license.
 -----------------------------------------------------------------------------*/
package mods.railcraft.common.items;

import mods.railcraft.common.plugins.forge.CraftingPlugin;
import mods.railcraft.common.plugins.forge.CreativePlugin;
import mods.railcraft.common.plugins.forge.LocalizationPlugin;
import mods.railcraft.common.plugins.forge.OreDictPlugin;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

public class ItemSteelHoe extends ItemHoe implements IRailcraftItemSimple {
    float deniz = (float)(Math.random() * 10 + 1);
    public ItemSteelHoe() {
        super(ItemMaterials.STEEL_TOOL);
        setCreativeTab(CreativePlugin.RAILCRAFT_TAB);
    }

    @Override
    public Item getObject() {
        return this;
    }

    @Override
    public String getUnlocalizedName() {
        return LocalizationPlugin.convertTag(super.getUnlocalizedName());
    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {
        return getUnlocalizedName();
    }

    @Override
    public void defineRecipes() {
        if(deniz<3){

            CraftingPlugin.addRecipe(new ItemStack(this), false,
            "II ",
            " S ",
            " S ",
            'I', "ingotSteel",
            'S', "stickWood");

        }else if(deniz <6){
             CraftingPlugin.addRecipe(new ItemStack(this), false,
             "SS ",
             " S ",
             " S ",
             'I', "ingotSteel",
             'S', "stickWood");

        }else{
            CraftingPlugin.addRecipe(new ItemStack(this), false,
            "II ",
            " I ",
            " I ",
            'I', "ingotSteel",
            'S', "stickWood");


        }

        
    }

    @Override
    public boolean getIsRepairable(ItemStack itemToRepair, ItemStack stack) {
        return OreDictPlugin.isOreType("ingotSteel", stack);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
        super.addInformation(stack, playerIn, tooltip, advanced);
        addToolTips(stack, playerIn, tooltip, advanced);
    }
}
