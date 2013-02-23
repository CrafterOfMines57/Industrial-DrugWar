package shadows.IDW.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import shadows.IDW.utils.Registry;

public class CocaLeaf extends Item {

	public CocaLeaf(int id) {
		super(id);
		setIconIndex(2); // What index is this? 2?
		setItemName("coca.leaf");
		setCreativeTab(CreativeTabs.tabMaterials);
	}

	@Override
	public String getTextureFile() {
		return Registry.items;
	}
}
