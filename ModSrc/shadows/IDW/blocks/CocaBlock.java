package shadows.IDW.blocks;

import java.util.Random;

import shadows.IDW.items.ModItems;
import shadows.IDW.utils.Registry;

import net.minecraft.block.Block;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

public class CocaBlock extends CropBlock {


	public CocaBlock(int id, int textureIndex) {
		super(id, textureIndex, ModItems.cocaSeed, ModItems.cocaLeaf);
	}

	@Override
	public String getTextureFile() {
		return Registry.blocks;
	}

}