package simple.title.command;

import com.google.inject.Inject;
import org.junit.jupiter.api.Test;
import simple.support.SetUpTest;
import simple.title.data.TitleData;
import simple.title.model.Title;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static simple.title.command.TitleCommand.*;

class TitleCommandTest extends SetUpTest {

    @Inject
    private TitleData titleData;

    @Test
    void 칭호_생성() {
        simulationTitleCreateCommand("TEST");

        Title title = titleData.getTitle("TEST");

        assertThat(title.getName()).isEqualTo("TEST");
    }

    @Test
    void 칭호_목록_조회() {
        simulationTitleCreateCommand("TEST1");

        simulationTitleCreateCommand("TEST2");

        String listCommandLine = COMMAND_NAME + " " + TITLE_LIST_COMMAND;
        player.performCommand(listCommandLine);

        assertTrue(player.nextMessage().contains("TEST2"));
        assertTrue(player.nextMessage().contains("TEST1"));
    }

    private void simulationTitleCreateCommand(String titleName) {
        String commandLine = COMMAND_NAME + " " + TITLE_CREATE_COMMAND + " " + titleName;
        player.performCommand(commandLine);
    }
}
