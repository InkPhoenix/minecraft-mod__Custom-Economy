package ink_phoenix.custom_economy.init;

import java.util.ArrayList;
import java.util.List;

import ink_phoenix.custom_economy.blocks.ATM;
import ink_phoenix.custom_economy.blocks.BigSafe;
import ink_phoenix.custom_economy.blocks.Safe;
import ink_phoenix.custom_economy.blocks.TestBlock;
import ink_phoenix.custom_economy.blocks.WallSafe;
import ink_phoenix.custom_economy.blocks.Wood;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class ModBlocks
{
	public static final List<Block> BLOCKS = new ArrayList<Block>();
	
	//Blocks
	public static final Block ATM = new ATM("atm", Material.ROCK, SoundType.STONE);
	public static final Block WALL_SAFE = new WallSafe("wall_safe", Material.ROCK, SoundType.STONE);
	public static final Block BIG_SAFE = new BigSafe("big_safe", Material.ROCK, SoundType.STONE);
	public static final Block SAFE = new Safe("safe", Material.ROCK, SoundType.STONE);
	public static final Block TEST_BLOCK = new TestBlock("test_block", Material.ROCK, SoundType.STONE);
	public static final Block WOOD_OAK = new Wood("wood_oak", Material.WOOD, SoundType.WOOD);
	public static final Block WOOD_SPRUCE = new Wood("wood_spruce", Material.WOOD, SoundType.WOOD);
}
