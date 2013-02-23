package shadows.IDW.utils;

import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenDesert;
import shadows.IDW.items.ModItems;
import shadows.IDW.utils.*;

public class Handler {

	private static boolean IsLoaded = false;
	public boolean sunIsVisible = false;

	public static void init(){
		
		Language();
		
		Recipes();
		
	}
	
	//***************************Adding Language stuff*****************

	private static void Language() {
		// TODO Auto-generated method stub
		LanguageRegistry.addName(ModItems.cocaSeed, "Coca Seeds");
		LanguageRegistry.addName(ModItems.cocaLeaf, "Coca Leaf");
	}
	
	//****************************Adding Recipies**********************
	
	private static void Recipes() {
		// TODO Auto-generated method stub
		
	}
	
	// *******************************Mod State Check*************************

	public static boolean isModLoaded() {
		if (IsLoaded == true) {

			throw new NotMyFault(
					"Why did you install my Addon twice? Remove the second Crystalline-Enhancements-universal-"
							+ Registry.ver
							+ ".jar out of your mods-Folder, you need only one of them. And another Question: Why the Hax did Forge not detect that before me?");

		} else {
			return false;
		}
	}

	public static void LoadMod() {
		IsLoaded = true;
	}

	public static void UnLoadMod() {
		IsLoaded = false;
	}

	// **********************************************View of the sun*************************************

	public static boolean isSunVisible(World world, int xCoord, int yCoord,
			int zCoord) {
		return world.isDaytime()
				&& !world.provider.hasNoSky
				&& world.canBlockSeeTheSky(xCoord, yCoord, zCoord)
				&& (world.getWorldChunkManager().getBiomeGenAt(xCoord, zCoord) instanceof BiomeGenDesert || !world
						.isRaining() && !world.isThundering());
	}

	/*
	 * public void updateSunVisibility() { this.sunIsVisible =
	 * isSunVisible(this.worldObj, this.xCoord, this.yCoord + 1, this.zCoord); }
	 */

}
