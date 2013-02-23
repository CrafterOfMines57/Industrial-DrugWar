package shadows.IDW.blocks;

import java.util.Random;

import shadows.IDW.items.ModItems;
import shadows.IDW.utils.Registry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSeeds;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class TallCrop extends CropBlock
{
	//static boolean canFertilize;
	static int fertileGrowth = 12;
	static int nonFertileGrowth = 25;
	
	public TallCrop(int id, int textureIndex, ItemSeeds seeds, Item crop )
	{
		super(id, textureIndex, seeds, crop);
		this.setBlockBounds(0.0F, -0.9F, 0.0F, 1.0F , 0.1F, 1.0F);
		
		//canFertilize = fertilize;
		
		/*Causes random world ticks for this block*/
		setTickRandomly(true); 
		
		/*Allows block to be updated on random world tick*/
		setRequiresSelfNotify(); 
	}
	
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z)
	{
        return null;
    }
	    
    public int getRenderType()
    {
        return 6; 
    }
   
    public boolean isOpaqueCube()
    {
        return false;
    }
    
   
    @Override
    public int getBlockTextureFromSideAndMetadata (int side, int metadata)
    {
        return 32 + metadata;
    }

    @Override
    public void updateTick (World world, int x, int y, int z, Random random)
    {
    	if(world.getBlockMetadata(x, y, z) == 2)
    	{
    		if(world.isAirBlock(x, y + 1, z) && world.getBlockId(x, y - 1, z) ==
    				Block.tilledField.blockID)
    		{
    			world.setBlockAndMetadataWithNotify(x, y + 1, z, this.blockID, 0);
    		}
    		else
    		{
    			if(!world.isAirBlock(x, y + 1, z) && world.getBlockMetadata(x, y + 1, z) < 3)
    			{
    				  if (random.nextInt(isFertile(world, x, y - 1, z) ? fertileGrowth 
    	    	        		: nonFertileGrowth ) != 0)
    	    	         {
    	    	             return;
    	    	         }
    				world.setBlockMetadata(x, y + 1, z, world.getBlockMetadata(
    						x, y + 1, z) + 1);
    			}
    		}
    		return;
    	}
    	
    	if(world.getBlockMetadata(x, y, z) < 3)
    	{
    	     if (random.nextInt(isFertile(world, x, y - 1, z) ? fertileGrowth 
    	        		: nonFertileGrowth ) != 0)
    	         {
    	             return;
    	         }
    		world.setBlockMetadata(x, y, z, world.getBlockMetadata(
					x, y, z) + 1);
    	}
     }

   /* @Override
    public void onNeighborBlockChange (World world, int x, int y, int z,
            int neighborId)
    {
        if (!canBlockStay(world, x, y, z))
        {
            dropBlockAsItem(world, x, y, z, world.getBlockMetadata(x, y, z), 0);
            world.setBlockWithNotify(x, y, z, 0);
            world.notifyBlockChange(x, y, z, ModItems.coca.shiftedIndex);
        }
    }*/

    @Override
    public boolean canBlockStay (World world, int x, int y, int z)
    {
    	
    	return((world.getBlockId(x, y - 1, z) == Block.tilledField.blockID ||
    			world.getBlockId(x, y - 1, z) == this.blockID) &&
    			(world.getFullBlockLightValue(x, y, z) >= 8 || world
                .canBlockSeeTheSky(x, y, z)));
    	
        /*Block soil = blocksList[world.getBlockId(x, y - 1, z)];
        return (world.getFullBlockLightValue(x, y, z) >= 8 || world
                .canBlockSeeTheSky(x, y, z))
                && (soil != null && soil.canSustainPlant(world, x, y - 1, z,
          /*              ForgeDirection.UP, ModItems.coca));*/
    }

 /* @Override  Specified in subclass
    public int idDropped (int metadata, Random random, int par2)
    {
        switch (metadata)
        {
        case 0:
            return ModItems.coca.shiftedIndex;
        case 1:
            return ModItems.coca.shiftedIndex;
        case 2:
        	return ModItems.coca.shiftedIndex;
        case 3:
        	return ModItems.cocaLeaf.shiftedIndex;
        default:
            // Error case!
            return -1; // air
        }
    }*/

   /*@Override Specified in subclass
    public int idPicked (World world, int x, int y, int z)
    {
        return ModItems.coca.shiftedIndex;
    }*/
    
	@Override
	public String getTextureFile()
	{
		return Registry.blocks;
	}
    
}


