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
	static int fertileGrowth = 12;
	static int nonFertileGrowth = 25;
	
	public TallCrop(int id, int textureIndex, ItemSeeds seeds, Item crop )
	{
		super(id, textureIndex, seeds, crop);
		this.setBlockBounds(0.0F, -0.9F, 0.0F, 1.0F , 0.1F, 1.0F);
				
		/*Causes random world ticks for this block*/
		setTickRandomly(true); 
		
		/*Allows block to be updated on random world tick*/
		setRequiresSelfNotify(); 
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

   
    @Override
    public boolean canBlockStay (World world, int x, int y, int z)
    {
    	
    	return((world.getBlockId(x, y - 1, z) == Block.tilledField.blockID ||
    			world.getBlockId(x, y - 1, z) == this.blockID) &&
    			(world.getFullBlockLightValue(x, y, z) >= 8 || world
                .canBlockSeeTheSky(x, y, z)));
    }

}


