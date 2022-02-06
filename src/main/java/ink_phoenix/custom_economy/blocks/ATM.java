package ink_phoenix.custom_economy.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.List;

import javax.annotation.Nullable;

import com.google.common.collect.Lists;

import ink_phoenix.custom_economy.Main_Eco;

public class ATM extends BlockBase
{
	public ATM(String name, Material material, SoundType sound)
	{
		super(name, material, sound);
		
		setSoundType(SoundType.STONE);
		setHardness(2.0F);
		setResistance(2.5F);
		setHarvestLevel("pickaxe", 0);
		setCreativeTab(Main_Eco.custom_eco_tab);
		//setMaxStackSize(1); changes the max amount of stack items (default = 64)
	}
	
public static final PropertyDirection FACING = PropertyDirection.create("facing");
	
	@Override
    public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
        world.setBlockState(pos, state.withProperty(FACING, getFacingFromEntity(pos, placer)), 2);
    }

    public static EnumFacing getFacingFromEntity(BlockPos clickedBlock, EntityLivingBase entity) {
        return EnumFacing.getFacingFromVector(
             (float) (entity.posX - clickedBlock.getX()),
             (float) (entity.posY - clickedBlock.getY()),
             (float) (entity.posZ - clickedBlock.getZ()));
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        return getDefaultState().withProperty(FACING, EnumFacing.getFront(meta & 7));
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return state.getValue(FACING).getIndex();
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, FACING);
    }
    
    
	private static final AxisAlignedBB ATM_BASE = new AxisAlignedBB(0, 0, 0, 1, 0.25, 1);
	private static final AxisAlignedBB ATM_M_BASE_1 = new AxisAlignedBB(0, 0.25, 0, 0.062, 1, 1);
	private static final AxisAlignedBB MONITOR = new AxisAlignedBB(0.062, 0.25, 0.625, 0.938, 0.938, 0.688);
	private static final AxisAlignedBB ATM_M_BASE_2 = new AxisAlignedBB(0.938, 0.25, 0, 1, 1, 1);
	private static final AxisAlignedBB ATM_M_BASE_3 = new AxisAlignedBB(0.062, 0.25, 0, 0.938, 1, 0.062);
	private static final AxisAlignedBB ATM_M_BASE_4 = new AxisAlignedBB(0.062, 0.938, 0.062, 0.938, 1, 1);
	// Skipped 'Keypad', as it has rotation
	private static final AxisAlignedBB ATM_M_FRAME_1 = new AxisAlignedBB(0.062, 0.25, 0.688, 0.188, 0.938, 0.75);
	private static final AxisAlignedBB ATM_M_FRAME_2 = new AxisAlignedBB(0.812, 0.25, 0.688, 0.938, 0.938, 0.75);
	private static final AxisAlignedBB ATM_M_FRAME_3 = new AxisAlignedBB(0.188, 0.25, 0.688, 0.812, 0.5, 0.75);
	private static final AxisAlignedBB ATM_M_FRAME_4 = new AxisAlignedBB(0.188, 0.812, 0.688, 0.812, 0.938, 0.75);
	// Skipped 'Keypad_B_1', as it has rotation
	// Skipped 'Keypad_B_2', as it has rotation
	// Skipped 'Keypad_B_3', as it has rotation
	// Skipped 'Keypad_B_5', as it has rotation
	// Skipped 'Keypad_B_6', as it has rotation
	// Skipped 'Keypad_B_4', as it has rotation
	// Skipped 'Keypad_B_7', as it has rotation
	// Skipped 'Keypad_B_8', as it has rotation
	// Skipped 'Keypad_B_9', as it has rotation
	// Skipped 'Keypad_B_10', as it has rotation
	private static final AxisAlignedBB MONITOR_B_1 = new AxisAlignedBB(0.125, 0.75, 0.688, 0.156, 0.781, 0.769);
	private static final AxisAlignedBB MONITOR_B_2 = new AxisAlignedBB(0.125, 0.688, 0.688, 0.156, 0.719, 0.769);
	private static final AxisAlignedBB MONITOR_B_3 = new AxisAlignedBB(0.125, 0.625, 0.688, 0.156, 0.656, 0.769);
	private static final AxisAlignedBB MONITOR_B_4 = new AxisAlignedBB(0.125, 0.562, 0.688, 0.156, 0.594, 0.769);
	private static final AxisAlignedBB MONITOR_B_5 = new AxisAlignedBB(0.844, 0.75, 0.688, 0.875, 0.781, 0.769);
	private static final AxisAlignedBB MONITOR_B_6 = new AxisAlignedBB(0.844, 0.688, 0.688, 0.875, 0.719, 0.769);
	private static final AxisAlignedBB MONITOR_B_7 = new AxisAlignedBB(0.844, 0.625, 0.688, 0.875, 0.656, 0.769);
	private static final AxisAlignedBB MONITOR_B_8 = new AxisAlignedBB(0.844, 0.562, 0.688, 0.875, 0.594, 0.769);
	/**
	* AxisAlignedBBs and methods getBoundingBox, collisionRayTrace, and collisionRayTrace generated using MrCrayfish's Model Creator <a href="https://mrcrayfish.com/tools?id=mc">https://mrcrayfish.com/tools?id=mc</a>
	*/
	private static final List<AxisAlignedBB> COLLISION_BOXES = Lists.newArrayList(ATM_BASE, ATM_M_BASE_1, MONITOR, ATM_M_BASE_2, ATM_M_BASE_3, ATM_M_BASE_4, ATM_M_FRAME_1, ATM_M_FRAME_2, ATM_M_FRAME_3, ATM_M_FRAME_4, MONITOR_B_1, MONITOR_B_2, MONITOR_B_3, MONITOR_B_4, MONITOR_B_5, MONITOR_B_6, MONITOR_B_7, MONITOR_B_8);
	private static final AxisAlignedBB BOUNDING_BOX = new AxisAlignedBB(0, 0, 0, 1, 1, 1);

	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
	{
	    return BOUNDING_BOX;
	}

	@Override
	public void addCollisionBoxToList(IBlockState state, World world, BlockPos pos, AxisAlignedBB entityBox, List<AxisAlignedBB> collidingBoxes, @Nullable Entity entity, boolean isActualState)
	{
	    entityBox = entityBox.offset(-pos.getX(), -pos.getY(), -pos.getZ());
	    for (AxisAlignedBB box : COLLISION_BOXES)
	    {
	        if (entityBox.intersects(box))
	            collidingBoxes.add(box.offset(pos));
	    }
	}

	@Override
	@Nullable
	public RayTraceResult collisionRayTrace(IBlockState state, World world, BlockPos pos, Vec3d start, Vec3d end)
	{
	    double distanceSq;
	    double distanceSqShortest = Double.POSITIVE_INFINITY;
	    RayTraceResult resultClosest = null;
	    RayTraceResult result;
	    start = start.subtract(pos.getX(), pos.getY(), pos.getZ());
	    end = end.subtract(pos.getX(), pos.getY(), pos.getZ());
	    for (AxisAlignedBB box : COLLISION_BOXES)
	    {
	        result = box.calculateIntercept(start, end);
	        if (result == null)
	            continue;

	        distanceSq = result.hitVec.squareDistanceTo(start);
	        if (distanceSq < distanceSqShortest)
	        {
	            distanceSqShortest = distanceSq;
	            resultClosest = result;
	        }
	    }
	    return resultClosest == null ? null : new RayTraceResult(RayTraceResult.Type.BLOCK, resultClosest.hitVec.addVector(pos.getX(), pos.getY(), pos.getZ()), resultClosest.sideHit, pos);
	}
}
