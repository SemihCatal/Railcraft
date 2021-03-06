/*------------------------------------------------------------------------------
 Copyright (c) CovertJaguar, 2011-2017
 http://railcraft.info

 This code is the property of CovertJaguar
 and may only be used with explicit written
 permission unless otherwise specified on the
 license page at http://railcraft.info/wiki/info:license.
 -----------------------------------------------------------------------------*/
package mods.railcraft.common.blocks;

import mods.railcraft.common.plugins.color.ColorPlugin;
import mods.railcraft.common.plugins.color.EnumColor;
import mods.railcraft.common.plugins.forge.LocalizationPlugin;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import org.jetbrains.annotations.Nullable;
import java.util.List;

/**
 * @author CovertJaguar <http://www.railcraft.info/>
 */
public class ItemBlockRailcraft extends ItemBlock implements ColorPlugin.IColoredItem, IRailcraftItemBlock {

    public ItemBlockRailcraft(Block block) {
        super(block);
    }

    @Override
    public void finalizeDefinition() {
        if (block instanceof ColorPlugin.IColoredBlock)
            ColorPlugin.instance.register(this, this);
    }

    @Override
    public ItemBlockRailcraft getObject() {
        return this;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IItemColor colorHandler() {
        return (stack, tintIndex) -> EnumColor.fromItemStack(stack).getHexColor();
    }

    @Override
    public String getTranslationKey() {
        return LocalizationPlugin.convertTag(super.getTranslationKey());
    }

    @Override
    public String getTranslationKey(ItemStack stack) {
        return getTranslationKey();
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World world, List<String> tooltip, ITooltipFlag flag) {
        super.addInformation(stack, world, tooltip, flag);
        addToolTips(stack, world, tooltip, flag);
    }
}
