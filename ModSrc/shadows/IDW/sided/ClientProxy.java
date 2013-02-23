package shadows.IDW.sided;

import net.minecraftforge.client.MinecraftForgeClient;
import shadows.IDW.sided.ServerProxy;
import shadows.IDW.utils.Registry;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends ServerProxy {

	public void init() {
		super.init();
		MinecraftForgeClient.preloadTexture(Registry.items);
	}

	public int addArmor(String var1) {
		return RenderingRegistry.addNewArmourRendererPrefix(var1);
	}
}
