package shadows.IDW.blocks;

import java.util.Random;

import shadows.IDW.items.ModItems;
import shadows.IDW.utils.Registry;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

public class CocaBlock extends TallCrop
{

	public CocaBlock(int id, int textureIndex)
	{
		super(id, textureIndex);
		this.setBlockBounds(0.0F, -0.9F, 0.0F, 1.0F , 0.1F, 1.0F);
		
		/*Causes random world ticks for this block*/
		setTickRandomly(true); 
		
		/*Allows block to be updated on random world tick*/
		setRequiresSelfNotify(); 
	}

    @Override
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
    }

    @Override
    public int idPicked (World world, int x, int y, int z)
    {
        return ModItems.coca.shiftedIndex;
    }
    
    
}