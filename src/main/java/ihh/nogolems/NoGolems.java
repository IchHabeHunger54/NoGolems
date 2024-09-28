package ihh.nogolems;

import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;

@Mod(NoGolems.MOD_ID)
public class NoGolems {
    public static final String MOD_ID = "nogolems";

    public NoGolems(ModContainer container) {
        container.registerConfig(ModConfig.Type.SERVER, Config.SPEC);
        container.registerExtensionPoint(IConfigScreenFactory.class, ConfigurationScreen::new);
    }
}
