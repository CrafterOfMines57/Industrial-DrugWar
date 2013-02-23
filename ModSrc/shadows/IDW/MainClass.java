package shadows.IDW;

import java.util.logging.Logger;

import shadows.IDW.blocks.ModBlocks;
import shadows.IDW.items.ModItems;
import shadows.IDW.sided.ServerProxy;
import shadows.IDW.utils.Handler;
import shadows.IDW.utils.Registry;
import shadows.IDW.Config;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;

@Mod(modid = Registry.id, name = Registry.name, version = Registry.ver, useMetadata = true/*, dependencies = "required-after:IC2; after:GregTech_Addon"*/)
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class MainClass {

	public static Logger log;

	@Instance(Registry.id)
	public static MainClass instance;

	@SidedProxy(clientSide = Registry.ClientProxy, serverSide = Registry.ServerProxy)
	public static ServerProxy proxy;

	@PreInit
	public void preInit(FMLPreInitializationEvent event) {

		boolean var1 = Handler.isModLoaded();
		
		if (var1 == false) {
			Config.init(event);
			Handler.LoadMod();
		}
	}

	@Init
	public void init(FMLInitializationEvent event) {

		proxy.init();

		ModItems.init();
		ModBlocks.init();
		Handler.init();

	}

	@PostInit
	public static void postInit(FMLPostInitializationEvent event) {
	}
}
