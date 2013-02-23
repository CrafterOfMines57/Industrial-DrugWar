package shadows.IDW.items;

import shadows.IDW.utils.Registry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CocaLeaf extends Item
{
	
	public CocaLeaf(int id)
	{
		super(id);
		setIconIndex(2); //What index is this? 2?
		setItemName("Coca Leaf");
		setCreativeTab(CreativeTabs.tabMaterials);
	}
	
	@Override
	public String getTextureFile()
	{
		return Registry.items;
	}
}

