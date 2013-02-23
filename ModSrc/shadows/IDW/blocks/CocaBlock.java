package shadows.IDW.blocks;

import shadows.IDW.items.ModItems;
import shadows.IDW.utils.Registry;

public class CocaBlock extends CropBlock {

	public CocaBlock(int id, int textureIndex) {
		super(id, textureIndex, ModItems.cocaSeed, ModItems.cocaLeaf);
	}

	@Override
	public String getTextureFile() {
		return Registry.blocks;
	}

}