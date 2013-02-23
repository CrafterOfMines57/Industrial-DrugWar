package shadows.IDW.items;

import shadows.IDW.Config;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDirt;
import net.minecraft.item.Item;

public class ModItems {

	public static Item coca;

	public static void Init() {

		ModItems.coca = (new CocaSeed(Config.cocaItemID, Config.cocaBlockID,
				Block.tilledField.blockID)).setItemName("coca").setIconIndex(0);
	}
}
