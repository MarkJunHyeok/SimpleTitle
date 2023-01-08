package simple.title.command;

import com.google.inject.Inject;
import org.junit.jupiter.api.Test;
import simple.support.SetUpTest;
import simple.title.data.TitleData;
import simple.title.model.Title;

import static org.assertj.core.api.Assertions.assertThat;
import static simple.title.command.TitleCommand.COMMAND_NAME;
import static simple.title.command.TitleCommand.TITLE_CREATE_COMMAND;

class TitleCommandTest extends SetUpTest {

    @Inject
    private TitleData titleData;

    @Test
    void 칭호_생성() {
        String titleName = "TEST";

        String commandLine = COMMAND_NAME + " " + TITLE_CREATE_COMMAND + " " + titleName;

        player.performCommand(commandLine);

        Title title = titleData.getTitle(titleName);

        assertThat(title.getName()).isEqualTo("TEST");
    }
}