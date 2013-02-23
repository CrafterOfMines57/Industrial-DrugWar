package shadows.IDW.items;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSeeds;
import shadows.IDW.Config;
import shadows.IDW.utils.Handler;

public class ModItems {

	public static ItemSeeds cocaSeed;
	public static Item cocaLeaf;

	public static void init() {

		ModItems.cocaSeed = (new CocaSeed(Config.cocaSeedID,
				Config.cocaBlockID, Block.tilledField.blockID));

		Handler.AddItemLanguage(cocaSeed, "Coca Seed");

		ModItems.cocaLeaf = (new CocaLeaf(Config.cocaLeafItemID));

		Handler.AddItemLanguage(cocaLeaf, "Coca Leaf");
	}
}
