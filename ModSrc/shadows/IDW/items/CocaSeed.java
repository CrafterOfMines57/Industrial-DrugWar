package shadows.IDW.items;

import net.minecraft.item.ItemSeeds;
import shadows.IDW.utils.Registry;

public class CocaSeed extends ItemSeeds {

	public CocaSeed(int id, int type, int soilID) {
		super(id, type, soilID);
		setIconIndex(1);
		setItemName("coca.seeds");
	}

	@Override
	public String getTextureFile() {
		return Registry.items;
	}

}
