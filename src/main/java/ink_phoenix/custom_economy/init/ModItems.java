package ink_phoenix.custom_economy.init;

import java.util.ArrayList;
import java.util.List;

import ink_phoenix.custom_economy.items.ItemBase;
import net.minecraft.item.Item;

public class ModItems 
{
	public static final List<Item> ITEMS = new ArrayList<Item>();
	
	//Items
	public static final Item currency_catalog = new ItemBase("currency_catalog");
	public static final Item price_list = new ItemBase("price_list");
}
