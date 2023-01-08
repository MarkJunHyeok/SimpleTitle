package simple.title;

import com.google.inject.Guice;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.java.JavaPluginLoader;
import simple.title.utils.BasicModule;

import java.io.File;

public final class PluginMain extends JavaPlugin {

    @Override
    public void onEnable() {
        Guice.createInjector(new BasicModule());
    }

    @Override
    public void onDisable() {
    }

    public PluginMain() {
        super();
    }

    protected PluginMain(JavaPluginLoader loader, PluginDescriptionFile description, File dataFolder, File file) {
        super(loader, description, dataFolder, file);
    }
}
