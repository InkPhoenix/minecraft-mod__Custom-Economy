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

public class BigSafe extends BlockBase
{
	public BigSafe(String name, Material material, SoundType sound)
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
    
    
    private static final AxisAlignedBB WALL_1 = new AxisAlignedBB(0.25, 0, 2.75, 2.75, 2.75, 3);
    private static final AxisAlignedBB WALL_2 = new AxisAlignedBB(0.25, 0, 0, 2.75, 2.75, 0.25);
    private static final AxisAlignedBB WALL_3 = new AxisAlignedBB(2.75, 0, 0.25, 3, 2.75, 2.75);
    private static final AxisAlignedBB WALL_4 = new AxisAlignedBB(0, 0, 0.25, 0.25, 2.75, 2.75);
    private static final AxisAlignedBB WALL_5 = new AxisAlignedBB(0.25, 0, 0.25, 2.75, 0.25, 2.75);
    private static final AxisAlignedBB WALL_6 = new AxisAlignedBB(0.25, 2.75, 0.25, 2.75, 3, 2.75);
    private static final AxisAlignedBB KEYLOCK = new AxisAlignedBB(1.375, 1.312, 2.938, 1.625, 1.562, 3.188);
    private static final AxisAlignedBB PAIN_1 = new AxisAlignedBB(1.562, 1.5, 3.125, 1.688, 1.625, 3.25);
    private static final AxisAlignedBB PAIN_2 = new AxisAlignedBB(1.625, 1.562, 3.125, 1.75, 1.688, 3.25);
    private static final AxisAlignedBB PAIN_3 = new AxisAlignedBB(1.688, 1.625, 3.125, 1.812, 1.75, 3.25);
    private static final AxisAlignedBB PAIN_4 = new AxisAlignedBB(1.312, 1.5, 3.125, 1.438, 1.625, 3.25);
    private static final AxisAlignedBB PAIN_5 = new AxisAlignedBB(1.25, 1.562, 3.125, 1.375, 1.688, 3.25);
    private static final AxisAlignedBB PAIN_6 = new AxisAlignedBB(1.188, 1.625, 3.125, 1.312, 1.75, 3.25);
    private static final AxisAlignedBB PAIN_7 = new AxisAlignedBB(1.312, 1.25, 3.125, 1.438, 1.375, 3.25);
    private static final AxisAlignedBB PAIN_8 = new AxisAlignedBB(1.25, 1.188, 3.125, 1.375, 1.312, 3.25);
    private static final AxisAlignedBB PAIN_9 = new AxisAlignedBB(1.188, 1.125, 3.125, 1.312, 1.25, 3.25);
    private static final AxisAlignedBB PAIN_10 = new AxisAlignedBB(1.562, 1.25, 3.125, 1.688, 1.375, 3.25);
    private static final AxisAlignedBB PAIN_11 = new AxisAlignedBB(1.625, 1.188, 3.125, 1.75, 1.312, 3.25);
    private static final AxisAlignedBB PAIN_12 = new AxisAlignedBB(1.688, 1.125, 3.125, 1.812, 1.25, 3.25);
    private static final AxisAlignedBB KEYLOCK_WALL_1 = new AxisAlignedBB(1.812, 1.188, 3.125, 1.938, 1.688, 3.25);
    private static final AxisAlignedBB KEYLOCK_WALL_2 = new AxisAlignedBB(1.062, 1.188, 3.125, 1.188, 1.688, 3.25);
    private static final AxisAlignedBB KEYLOCK_WALL_3 = new AxisAlignedBB(1.25, 1.75, 3.125, 1.75, 1.875, 3.25);
    private static final AxisAlignedBB KEYLOCK_WALL_4 = new AxisAlignedBB(1.25, 1, 3.125, 1.75, 1.125, 3.25);
    private static final AxisAlignedBB EXTRA_PAIN_1 = new AxisAlignedBB(1.75, 1.688, 3.125, 1.875, 1.812, 3.25);
    private static final AxisAlignedBB EXTRA_PAIN_2 = new AxisAlignedBB(1.125, 1.688, 3.125, 1.25, 1.812, 3.25);
    private static final AxisAlignedBB EXTRA_PAIN_3 = new AxisAlignedBB(1.125, 1.062, 3.125, 1.25, 1.188, 3.25);
    private static final AxisAlignedBB EXTRA_PAIN_4 = new AxisAlignedBB(1.75, 1.062, 3.125, 1.875, 1.188, 3.25);
    private static final AxisAlignedBB LOCK_1 = new AxisAlignedBB(1.375, 1.719, 2.938, 1.625, 1.969, 3.094);
    private static final AxisAlignedBB LOCK_2 = new AxisAlignedBB(1.375, 0.906, 2.938, 1.625, 1.156, 3.094);
    private static final AxisAlignedBB LOCK_BAR_1 = new AxisAlignedBB(0.5, 1.781, 2.906, 2.5, 1.906, 3.062);
    private static final AxisAlignedBB LOCK_BAR_2 = new AxisAlignedBB(0.5, 0.969, 2.906, 2.5, 1.094, 3.062);
    private static final AxisAlignedBB LOCK_BAR_LOCK_1 = new AxisAlignedBB(0.438, 1.656, 2.938, 0.688, 2.031, 3.094);
    private static final AxisAlignedBB LOCK_BAR_LOCK_2 = new AxisAlignedBB(0.438, 0.844, 2.938, 0.688, 1.219, 3.094);
    private static final AxisAlignedBB LOCK_UH_SOMETHING_1 = new AxisAlignedBB(2.312, 1.844, 2.938, 2.562, 2.531, 3.094);
    private static final AxisAlignedBB LOCK_UH_SOMETHING_2 = new AxisAlignedBB(2.312, 0.344, 2.938, 2.562, 1.031, 3.094);
    private static final AxisAlignedBB LOCK_UH_SOMETHING_3 = new AxisAlignedBB(2.312, 1.094, 2.938, 2.562, 1.781, 3.094);
    /**
    * AxisAlignedBBs and methods getBoundingBox, collisionRayTrace, and collisionRayTrace generated using MrCrayfish's Model Creator <a href="https://mrcrayfish.com/tools?id=mc">https://mrcrayfish.com/tools?id=mc</a>
    */
    private static final List<AxisAlignedBB> COLLISION_BOXES = Lists.newArrayList(WALL_1, WALL_2, WALL_3, WALL_4, WALL_5, WALL_6, KEYLOCK, PAIN_1, PAIN_2, PAIN_3, PAIN_4, PAIN_5, PAIN_6, PAIN_7, PAIN_8, PAIN_9, PAIN_10, PAIN_11, PAIN_12, KEYLOCK_WALL_1, KEYLOCK_WALL_2, KEYLOCK_WALL_3, KEYLOCK_WALL_4, EXTRA_PAIN_1, EXTRA_PAIN_2, EXTRA_PAIN_3, EXTRA_PAIN_4, LOCK_1, LOCK_2, LOCK_BAR_1, LOCK_BAR_2, LOCK_BAR_LOCK_1, LOCK_BAR_LOCK_2, LOCK_UH_SOMETHING_1, LOCK_UH_SOMETHING_2, LOCK_UH_SOMETHING_3);
    private static final AxisAlignedBB BOUNDING_BOX = new AxisAlignedBB(0, 0, 0, 3, 3, 3.25);

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
