package ihh.nogolems;

import net.neoforged.neoforge.common.ModConfigSpec;

public class Config {
    public static ModConfigSpec SPEC;
    public static ModConfigSpec.BooleanValue DISABLE_IRON_GOLEM;
    public static ModConfigSpec.BooleanValue DISABLE_SNOW_GOLEM;
    public static ModConfigSpec.BooleanValue DISABLE_WITHER;

    static {
        ModConfigSpec.Builder builder = new ModConfigSpec.Builder();
        DISABLE_IRON_GOLEM = builder.comment("Disables creation of iron golems.").define("disable_iron_golem", true);
        DISABLE_SNOW_GOLEM = builder.comment("Disables creation of snow golems.").define("disable_snow_golem", true);
        DISABLE_WITHER = builder.comment("Disables creation of withers.").define("disable_wither", true);
        SPEC = builder.build();
    }
}
