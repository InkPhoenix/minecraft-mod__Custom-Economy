package ink_phoenix.custom_economy.tabs;

import ink_phoenix.custom_economy.init.ModBlocks;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class CustomEcoTab extends CreativeTabs
{
	public CustomEcoTab(String label)
	{
		super("custom_eco_tab");
	}
	public ItemStack getTabIconItem()
	{
		return new ItemStack(Item.getItemFromBlock(ModBlocks.ATM));
	}
}
