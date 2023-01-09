package simple.title.command;

import com.google.inject.Inject;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import simple.title.model.Title;
import simple.title.service.TitleService;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class TitleCommand implements CommandExecutor {

    public static final String COMMAND_NAME = "칭호";
    public static final String TITLE_CREATE_COMMAND = "추가";
    public static final String TITLE_LIST_COMMAND = "목록";

    public static final String TITLE_SET_DISPLAY_NAME_COMMAND = "모습";

    public static final String SEND_MESSAGE_PREFIX = "&a&l" + "[ ! ] " + "&f";

    @Inject
    private TitleService titleService;

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (command.getName().equalsIgnoreCase(COMMAND_NAME)) {
            createCommand(args);
            listCommand((Player) sender, args);
            setDisplayNameCommand(args);
            return true;
        }
        return false;
    }

    private void createCommand(String[] args) {
        if (args[0].equalsIgnoreCase(TITLE_CREATE_COMMAND)) {
            String titleName = args[1];

            titleService.create(titleName);
        }
    }

    private void listCommand(Player player, String[] args) {
        if (args[0].equalsIgnoreCase(TITLE_LIST_COMMAND)) {
            List<Title> titles = titleService.getTitles();

            titles.forEach(title -> player.sendMessage(SEND_MESSAGE_PREFIX + title.getName()));
        }
    }

    private void setDisplayNameCommand(String[] args) {
        if (args[0].equalsIgnoreCase(TITLE_SET_DISPLAY_NAME_COMMAND)) {
            String titleName = args[1];
            String displayName = Arrays.stream(args)
                    .filter(it -> !it.equals(TITLE_SET_DISPLAY_NAME_COMMAND))
                    .filter(it -> !it.equals(titleName))
                    .collect(Collectors.joining());

            titleService.setDisplayName(titleName, displayName);
        }
    }
}
