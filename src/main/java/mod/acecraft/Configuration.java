package mod.acecraft;

import net.minecraftforge.common.ForgeConfigSpec;

@SuppressWarnings("unused")
public class Configuration {
	
	public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
	
	public static final ConfigFoundry FOUNDRY   = new ConfigFoundry(BUILDER);
	
	public static class ConfigFoundry {
		public final ForgeConfigSpec.BooleanValue dummy;
		
		ConfigFoundry(ForgeConfigSpec.Builder builder) {
			builder.push("FOUNDRY SETTINGS");
			dummy = builder.define("DummyEntry", true);
			builder.pop();
		}
	}
	
	public static final ForgeConfigSpec spec = BUILDER.build();
	
}