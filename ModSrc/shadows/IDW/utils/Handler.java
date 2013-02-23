package shadows.IDW.utils;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class Handler {

	private static boolean IsLoaded = false;

	public static void init() {

		Recipes();

	}

	// **********************Adding Language stuff*****************

	public static void AddItemLanguage(Item item, String name) {
		// TODO Auto-generated method stub
		LanguageRegistry.addName(item, name);
	}

	public static void AddBlockLanguage(Block block, String name) {
		// TODO Auto-generated method stub
		LanguageRegistry.addName(block, name);
	}

	// ****************************Adding Recipies**********************

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
}