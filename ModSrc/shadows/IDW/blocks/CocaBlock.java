package shadows.IDW.blocks;

import java.util.Random;

import shadows.IDW.items.ModItems;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

public class CocaBlock extends Block{

	public CocaBlock(int id, int textureIndex) {
		super(id, textureIndex, Material.plants);
		// TODO Auto-generated constructor stub.
		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F , 1.5F, 1.0F);
	}
	
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z) {
        return null;
    }
       
    public int getRenderType() {
        return 6; // Magic number.
    }
   
    public boolean isOpaqueCube() {
        return false;
    }
    @Override
    public int getBlockTextureFromSideAndMetadata (int side, int metadata) {
        return 32 + metadata;
    }

    @Override
    public void updateTick (World world, int x, int y, int z, Random random) {
        if (world.getBlockMetadata(x, y, z) == 1) {
            return;
        }

        if (random.nextInt(isFertile(world, x, y - 1, z) ? 12 : 25) != 0) {
            return;
        }

        world.setBlockMetadataWithNotify(x, y, z, 1);
    }

    @Override
    public void onNeighborBlockChange (World world, int x, int y, int z,
            int neighborId) {
        if (!canBlockStay(world, x, y, z)) {
            dropBlockAsItem(world, x, y, z, world.getBlockMetadata(x, y, z), 0);
            world.setBlockWithNotify(x, y, z, 0);
        }
    }

    @Override
    public boolean canBlockStay (World world, int x, int y, int z) {
        Block soil = blocksList[world.getBlockId(x, y - 1, z)];
        return (world.getFullBlockLightValue(x, y, z) >= 8 || world
                .canBlockSeeTheSky(x, y, z))
                && (soil != null && soil.canSustainPlant(world, x, y - 1, z,
                        ForgeDirection.UP, ModItems.coca));
    }

    @Override
    public int idDropped (int metadata, Random random, int par2) {
        switch (metadata) {
        case 0:
            return ModItems.coca.shiftedIndex;
        case 1:
            return ModItems.coca.shiftedIndex;
        default:
            // Error case!
            return -1; // air
        }
    }

    @Override
    public int idPicked (World world, int x, int y, int z) {
        return ModItems.coca.shiftedIndex;
    }
}