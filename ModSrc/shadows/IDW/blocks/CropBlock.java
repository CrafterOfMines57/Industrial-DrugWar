package shadows.IDW.blocks;

import java.util.Random;

import net.minecraft.block.BlockCrops;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSeeds;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenDesert;
import shadows.IDW.utils.Registry;

public class CropBlock extends BlockCrops {

	// 1 for testing, should be 12
	private int fertilized = 1;
	// 1 for testing, should be 25
	private int notFertilized = 1;
	// Seed Item
	private ItemSeeds Seed;
	// Crop Item
	private Item Crop;

	public CropBlock(int id, int textureIndex, ItemSeeds seed, Item crop) {
		super(id, textureIndex);
		this.Seed = seed;
		this.Crop = crop;
	}

	@Override
	public int getBlockTextureFromSideAndMetadata(int side, int metadata) {
		return 32 + metadata;
	}

	@Override
	public void updateTick(World world, int x, int y, int z, Random random) {
		if (isSunVisible(world, x, y, z)) {
			/** Determines when Block stops growing (3 in this case) */
			if (world.getBlockMetadata(x, y, z) == 3) {
				return;
			}

			/**
			 * Checks to see if the plant will grow, if it's hydrated 1/12
			 * chance, if it's not hydrated, 1/25 chance
			 */
			if (random.nextInt(isFertile(world, x, y - 1, z) ? fertilized
					: notFertilized) != 0) {
				return;
			}

			// Updates the Block
			world.setBlockMetadataWithNotify(x, y, z,
					world.getBlockMetadata(x, y, z) + 1);
		}
	}

	@Override
	public int idPicked(World world, int x, int y, int z) {
		return Seed.shiftedIndex;
	}

	/**
	 * Returns the ID of the items to drop on destruction.
	 */
	@Override
	public int idDropped(int par1, Random par2Random, int par3) {
		return par1 == 3 ? this.getCropItem() : this.getSeedItem();
	}

	/**
	 * Apply bonemeal to the crops.
	 */
	@Override
	public void fertilize(World world, int xCoord, int yCoord, int zCoord) {
		// checks if the sun is visible
		if (isSunVisible(world, xCoord, yCoord, zCoord))
			world.setBlockMetadataWithNotify(xCoord, yCoord, zCoord, 3);
	}

	/**
	 * Generate a seed ItemStack for this crop.
	 */
	protected int getSeedItem() {
		return Seed.shiftedIndex;
	}

	/**
	 * Generate a crop produce ItemStack for this crop.
	 */
	protected int getCropItem() {
		return Crop.shiftedIndex;
	}

	@Override
	public String getTextureFile() {
		return Registry.blocks;
	}

	// *************************View of the sun***************************

	public static boolean isSunVisible(World world, int xCoord, int yCoord,
			int zCoord) {
		return world.isDaytime()
				&& !world.provider.hasNoSky
				&& world.canBlockSeeTheSky(xCoord, yCoord, zCoord)
				&& (world.getWorldChunkManager().getBiomeGenAt(xCoord, zCoord) instanceof BiomeGenDesert || !world
						.isRaining() && !world.isThundering());
	}
}