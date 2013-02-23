package shadows.IDW.blocks;

import net.minecraft.block.Block;
import shadows.IDW.Config;

public class ModBlocks {

	public static Block coca;

	public static void init() {
		ModBlocks.coca = (new CocaBlock(Config.cocaBlockID, 0))
				.setBlockName("coca");
	}
}