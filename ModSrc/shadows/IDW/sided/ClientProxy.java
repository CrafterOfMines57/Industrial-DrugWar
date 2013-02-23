package shadows.IDW.sided;

import net.minecraftforge.client.MinecraftForgeClient;
import shadows.IDW.utils.Registry;

public class ClientProxy extends ServerProxy {

	public void init() {
		super.init();
		MinecraftForgeClient.preloadTexture(Registry.items);
		MinecraftForgeClient.preloadTexture(Registry.blocks);
	}
}
