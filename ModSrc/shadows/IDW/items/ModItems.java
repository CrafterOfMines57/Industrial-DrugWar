package shadows.IDW.items;

import shadows.IDW.Config;
import shadows.IDW.utils.Registry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDirt;
import net.minecraft.item.ItemSeeds;

public class ModItems {

	public static ItemSeeds coca;

	public static void init() {

		ModItems.coca = (new CocaSeed(Config.cocaItemID, Config.cocaBlockID,
				Block.tilledField.blockID));
	}
}
