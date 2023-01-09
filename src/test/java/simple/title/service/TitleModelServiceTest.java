package simple.title.service;

import com.google.inject.Inject;
import org.assertj.core.api.Assertions;
import org.bukkit.permissions.Permission;
import org.junit.jupiter.api.Test;
import simple.support.SetUpTest;
import simple.title.data.TitleData;
import simple.title.model.Title;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class TitleModelServiceTest extends SetUpTest {

    @Inject
    private TitleService titleService;

    @Inject
    private TitleData titleData;

    @Test
    void 칭호_생성() {
        titleService.create("name");

        Title title = titleData.getTitle("name");

        assertThat(title.getName()).isEqualTo("name");
    }

    @Test
    void 칭호_표시될_이름_적용() {
        titleService.create("name");

        titleService.setDisplayName("name", "displayName");

        Title title = titleData.getTitle("name");

        assertThat(title.getDisplayName()).isEqualTo("displayName");
    }

    @Test
    void 칭호_설명_적용() {
        titleService.create("name");

        titleService.setDescription("name", "description");

        Title title = titleData.getTitle("name");

        assertThat(title.getDescription()).isEqualTo("description");
    }

    @Test
    void 칭호_권한_추가() {
        titleService.create("name");

        Permission permission = new Permission("test.permission");

        titleService.addPermission("name", permission);

        Title title = titleData.getTitle("name");

        assertThat(title.getPermissions().get(0)).isEqualTo(permission);
    }

    @Test
    void 칭호_목록_조회() {
        titleService.create("1");
        titleService.create("2");
        titleService.create("3");

        List<Title> titles = titleService.getTitles();

        assertThat(titles.get(0).getName()).isEqualTo("1");
        assertThat(titles.get(1).getName()).isEqualTo("2");
        assertThat(titles.get(2).getName()).isEqualTo("3");
    }
}
