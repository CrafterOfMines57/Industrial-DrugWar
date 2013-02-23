package shadows.IDW.blocks;

import net.minecraft.block.Block;
import shadows.IDW.Config;
import shadows.IDW.utils.Handler;

public class ModBlocks {

	public static Block coca;

	public static void init() {
		ModBlocks.coca = (new CocaBlock(Config.cocaBlockID, 1))
				.setBlockName("coca");
	}
}
