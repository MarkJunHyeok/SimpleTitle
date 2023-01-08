package simple.title.command;

import com.google.inject.Inject;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;
import simple.title.service.TitleService;


public class TitleCommand implements CommandExecutor {

    public static final String COMMAND_NAME = "칭호";
    public static final String TITLE_CREATE_COMMAND = "추가";
    @Inject
    private TitleService titleService;

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (command.getName().equalsIgnoreCase(COMMAND_NAME)) {
            createCommand(args);

            return true;
        }
        return false;
    }

    private void createCommand(@NotNull String[] args) {
        if (args[0].equalsIgnoreCase(TITLE_CREATE_COMMAND)) {
            String titleName = args[1];

            titleService.create(titleName);
        }
    }
}
