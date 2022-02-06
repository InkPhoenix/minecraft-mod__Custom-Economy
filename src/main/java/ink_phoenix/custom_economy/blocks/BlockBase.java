package ink_phoenix.custom_economy.blocks;

import ink_phoenix.custom_economy.Main_Eco;
import ink_phoenix.custom_economy.init.ModBlocks;
import ink_phoenix.custom_economy.init.ModItems;
import ink_phoenix.custom_economy.util.IHasModel;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class BlockBase extends Block implements IHasModel
{
	public BlockBase(String name, Material material, SoundType sound)
	{
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
		setSoundType(sound);
		
		ModBlocks.BLOCKS.add(this);
		ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}

	@Override
	public void registerModels()
	{
		Main_Eco.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
	}
}
