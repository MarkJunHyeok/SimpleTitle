package simple.title;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.java.JavaPluginLoader;
import simple.title.command.TitleCommand;
import simple.title.utils.BasicModule;

import java.io.File;

public final class PluginMain extends JavaPlugin {

    @Inject
    private TitleCommand titleCommand;

    @Override
    public void onEnable() {
        Injector injector = Guice.createInjector(new BasicModule());
        injector.injectMembers(this);

        getCommand("칭호").setExecutor(titleCommand);
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
