package shadows.IDW.items;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSeeds;
import shadows.IDW.Config;

public class ModItems {

	public static ItemSeeds cocaSeed;
	public static Item cocaLeaf;

	public static void init() {

		ModItems.cocaSeed = (new CocaSeed(Config.cocaSeedID,
				Config.cocaBlockID, Block.tilledField.blockID));

		ModItems.cocaLeaf = (new CocaLeaf(Config.cocaLeafItemID));
	}
}
