package shadows.IDW.blocks;

import shadows.IDW.Config;
import shadows.IDW.items.CocaBlock;
import net.minecraft.block.Block;

public class ModBlocks {

	public static Block coca;

	public static void init() {
		ModBlocks.coca = (new CocaBlock(Config.cocaBlockID, 1)).setBlockName("coca");
	}
}
