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

public class Safe extends BlockBase
{
	public Safe(String name, Material material, SoundType sound)
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
    
    
    private static final AxisAlignedBB SAFE_BASE_1 = new AxisAlignedBB(0.062, 0, 0.062, 0.938, 0.125, 0.938);
    private static final AxisAlignedBB SAFE_BASE_2 = new AxisAlignedBB(0.062, 0.062, 0.938, 0.938, 1.5, 1);
    private static final AxisAlignedBB SAFE_BASE_3 = new AxisAlignedBB(0.062, 0.062, 0, 0.938, 1.5, 0.062);
    private static final AxisAlignedBB SAFE_BASE_4 = new AxisAlignedBB(0.938, 0.062, 0.062, 1, 1.5, 0.938);
    private static final AxisAlignedBB SAFE_BASE_5 = new AxisAlignedBB(0, 0.062, 0.062, 0.062, 1.5, 0.938);
    private static final AxisAlignedBB SAFE_BASE_6 = new AxisAlignedBB(0.062, 1.438, 0.062, 0.938, 1.562, 0.938);
    private static final AxisAlignedBB SAFE_KEYLOCK = new AxisAlignedBB(0.438, 0.688, 1, 0.562, 0.812, 1.062);
    private static final AxisAlignedBB PAIN_1 = new AxisAlignedBB(0.406, 0.781, 1.031, 0.469, 0.844, 1.094);
    private static final AxisAlignedBB PAIN_2 = new AxisAlignedBB(0.375, 0.812, 1.031, 0.438, 0.875, 1.094);
    private static final AxisAlignedBB PAIN_3 = new AxisAlignedBB(0.344, 0.844, 1.031, 0.406, 0.906, 1.094);
    private static final AxisAlignedBB PAIN_4 = new AxisAlignedBB(0.531, 0.781, 1.031, 0.594, 0.844, 1.094);
    private static final AxisAlignedBB PAIN_5 = new AxisAlignedBB(0.562, 0.812, 1.031, 0.625, 0.875, 1.094);
    private static final AxisAlignedBB PAIN_6 = new AxisAlignedBB(0.594, 0.844, 1.031, 0.656, 0.906, 1.094);
    private static final AxisAlignedBB PAIN_7 = new AxisAlignedBB(0.531, 0.656, 1.031, 0.594, 0.719, 1.094);
    private static final AxisAlignedBB PAIN_8 = new AxisAlignedBB(0.562, 0.625, 1.031, 0.625, 0.688, 1.094);
    private static final AxisAlignedBB PAIN_9 = new AxisAlignedBB(0.594, 0.594, 1.031, 0.656, 0.656, 1.094);
    private static final AxisAlignedBB PAIN_10 = new AxisAlignedBB(0.406, 0.656, 1.031, 0.469, 0.719, 1.094);
    private static final AxisAlignedBB PAIN_11 = new AxisAlignedBB(0.375, 0.625, 1.031, 0.438, 0.688, 1.094);
    private static final AxisAlignedBB PAIN_12 = new AxisAlignedBB(0.344, 0.594, 1.031, 0.406, 0.656, 1.094);
    private static final AxisAlignedBB PAIN_SIDE_1 = new AxisAlignedBB(0.25, 0.594, 1.031, 0.312, 0.906, 1.094);
    private static final AxisAlignedBB PAIN_SIDE_2 = new AxisAlignedBB(0.688, 0.594, 1.031, 0.75, 0.906, 1.094);
    private static final AxisAlignedBB PAIN_SIDE_3 = new AxisAlignedBB(0.625, 0.875, 1.031, 0.719, 0.938, 1.094);
    private static final AxisAlignedBB PAIN_SIDE_4 = new AxisAlignedBB(0.281, 0.875, 1.031, 0.375, 0.938, 1.094);
    private static final AxisAlignedBB PAIN_SIDE_5 = new AxisAlignedBB(0.344, 0.906, 1.031, 0.656, 0.969, 1.094);
    private static final AxisAlignedBB PAIN_SIDE_6 = new AxisAlignedBB(0.344, 0.531, 1.031, 0.656, 0.594, 1.094);
    private static final AxisAlignedBB PAIN_SIDE_7 = new AxisAlignedBB(0.625, 0.562, 1.031, 0.719, 0.625, 1.094);
    private static final AxisAlignedBB PAIN_SIDE_8 = new AxisAlignedBB(0.281, 0.562, 1.031, 0.375, 0.625, 1.094);
    private static final AxisAlignedBB SAFE_CODE_1 = new AxisAlignedBB(0.406, 1.125, 1, 0.469, 1.25, 1.062);
    private static final AxisAlignedBB SAFE_CODE_2 = new AxisAlignedBB(0.438, 1.219, 1, 0.562, 1.281, 1.062);
    private static final AxisAlignedBB SAFE_CODE_3 = new AxisAlignedBB(0.531, 1.125, 1, 0.594, 1.25, 1.062);
    private static final AxisAlignedBB SAFE_CODE_4 = new AxisAlignedBB(0.438, 1.094, 1, 0.562, 1.156, 1.062);
    private static final AxisAlignedBB SAFE_CODE = new AxisAlignedBB(0.438, 1.125, 1.031, 0.562, 1.25, 1.094);
    /**
    * AxisAlignedBBs and methods getBoundingBox, collisionRayTrace, and collisionRayTrace generated using MrCrayfish's Model Creator <a href="https://mrcrayfish.com/tools?id=mc">https://mrcrayfish.com/tools?id=mc</a>
    */
    private static final List<AxisAlignedBB> COLLISION_BOXES = Lists.newArrayList(SAFE_BASE_1, SAFE_BASE_2, SAFE_BASE_3, SAFE_BASE_4, SAFE_BASE_5, SAFE_BASE_6, SAFE_KEYLOCK, PAIN_1, PAIN_2, PAIN_3, PAIN_4, PAIN_5, PAIN_6, PAIN_7, PAIN_8, PAIN_9, PAIN_10, PAIN_11, PAIN_12, PAIN_SIDE_1, PAIN_SIDE_2, PAIN_SIDE_3, PAIN_SIDE_4, PAIN_SIDE_5, PAIN_SIDE_6, PAIN_SIDE_7, PAIN_SIDE_8, SAFE_CODE_1, SAFE_CODE_2, SAFE_CODE_3, SAFE_CODE_4, SAFE_CODE);
    private static final AxisAlignedBB BOUNDING_BOX = new AxisAlignedBB(0, 0, 0, 1, 1.562, 1.094);

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
