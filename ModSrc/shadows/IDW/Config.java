package shadows.IDW;

import java.io.File;
import java.util.logging.Level;

import shadows.IDW.utils.Registry;

import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class Config {
	public static int cocaSeedID, cocaBlockID, cocaLeafItemID;

	public static void init(FMLPreInitializationEvent event) {
		File configFile = new File(event.getModConfigurationDirectory(), Registry.name + ".cfg");
		Configuration configuration = new Configuration(configFile);

		try {
			configuration.load();

			//*************************Item config's***********************

			cocaSeedID = configuration.getItem("Coca Seed", 9000 - 256, "Coca Seed Id:")
					.getInt();
			
			cocaLeafItemID = configuration.getItem("Coca Leaf", 9001 - 256, "Coca Leaf Id:")
					.getInt();
			
			
			//*************************Block config's***********************
			
			cocaBlockID = configuration.getBlock("Coca Block", 900, "Coca Block Id:")
					.getInt();

		} catch (Exception e) {
			FMLLog.log(Level.SEVERE, e, Registry.name
					+ " has had a problem loading its configuration");
		} finally {
			configuration.save();
		}
	}
}