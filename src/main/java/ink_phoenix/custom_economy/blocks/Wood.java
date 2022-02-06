package ink_phoenix.custom_economy.blocks;

import ink_phoenix.custom_economy.Main_Eco;
import ink_phoenix.custom_economy.init.ModBlocks;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;

public class Wood extends BlockBase
{
	public Wood(String name, Material material, SoundType sound)
	{
		super(name, material, sound);
		
		setSoundType(SoundType.WOOD);
		setHardness(2F);
		setResistance(2F);
		setHarvestLevel("axe", 0);
		setCreativeTab(Main_Eco.custom_eco_tab);
		
		//burning properties
		Blocks.FIRE.setFireInfo(ModBlocks.WOOD_OAK, 5, 5);
		Blocks.FIRE.setFireInfo(ModBlocks.WOOD_SPRUCE, 5, 5);
	}
}
