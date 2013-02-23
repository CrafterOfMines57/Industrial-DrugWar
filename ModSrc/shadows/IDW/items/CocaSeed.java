package shadows.IDW.items;

import shadows.IDW.utils.Registry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemSeeds;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class CocaSeed extends ItemSeeds {

	public CocaSeed(int id, int type, int soilID)
	{
		super(id, type, soilID);
		setIconIndex(1);
		setItemName("seeds.coca");
	}
	
	@Override
	public String getTextureFile()
	{
		return Registry.items;
	}
	
}
