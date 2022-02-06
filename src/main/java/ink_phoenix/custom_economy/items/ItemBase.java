package ink_phoenix.custom_economy.items;

import ink_phoenix.custom_economy.Main_Eco;
import ink_phoenix.custom_economy.init.ModItems;
import ink_phoenix.custom_economy.util.IHasModel;
import net.minecraft.item.Item;

public class ItemBase extends Item implements IHasModel{
	
	public ItemBase(String name)
	{
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Main_Eco.custom_eco_tab);
		
		ModItems.ITEMS.add(this);
	}

	@Override
	public void registerModels()
	{
		Main_Eco.proxy.registerItemRenderer(this, 0, "inventory");
	}
}
