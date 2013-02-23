package shadows.IDW.items;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

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
}