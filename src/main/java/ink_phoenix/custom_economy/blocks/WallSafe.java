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

public class WallSafe extends BlockBase
{
	public WallSafe(String name, Material material, SoundType sound)
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
	
    
    private static final AxisAlignedBB SAFE_BOTTOM = new AxisAlignedBB(0, 0, 0.125, 1, 0.125, 0.875);
    private static final AxisAlignedBB SAFE_WALL_1 = new AxisAlignedBB(0, 0.125, 0.125, 0.125, 0.75, 0.875);
    private static final AxisAlignedBB SAFE_WALL_2 = new AxisAlignedBB(0.875, 0.125, 0.125, 1, 0.75, 0.875);
    private static final AxisAlignedBB SAFE_WALL_3 = new AxisAlignedBB(0.125, 0.125, 0.125, 0.875, 0.75, 0.25);
    private static final AxisAlignedBB SAFE_WALL_4 = new AxisAlignedBB(0.125, 0.625, 0.25, 0.875, 0.75, 0.875);
    private static final AxisAlignedBB SAFE_SHELF_1 = new AxisAlignedBB(0.125, 0.25, 0.25, 0.875, 0.312, 0.75);
    private static final AxisAlignedBB SAFE_SHELF_2 = new AxisAlignedBB(0.125, 0.438, 0.25, 0.875, 0.5, 0.75);
    private static final AxisAlignedBB SAFE_DOOR = new AxisAlignedBB(0.125, 0.125, 0.75, 0.875, 0.625, 0.812);
    private static final AxisAlignedBB SAFE_KEYPAD = new AxisAlignedBB(0.25, 0.25, 0.812, 0.625, 0.438, 0.875);
    /**
    * AxisAlignedBBs and methods getBoundingBox, collisionRayTrace, and collisionRayTrace generated using MrCrayfish's Model Creator <a href="https://mrcrayfish.com/tools?id=mc">https://mrcrayfish.com/tools?id=mc</a>
    */
    private static final List<AxisAlignedBB> COLLISION_BOXES = Lists.newArrayList(SAFE_BOTTOM, SAFE_WALL_1, SAFE_WALL_2, SAFE_WALL_3, SAFE_WALL_4, SAFE_SHELF_1, SAFE_SHELF_2, SAFE_DOOR, SAFE_KEYPAD);
    private static final AxisAlignedBB BOUNDING_BOX = new AxisAlignedBB(0, 0, 0.125, 1, 0.75, 0.875);

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
