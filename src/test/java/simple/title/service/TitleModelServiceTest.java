package simple.title.service;

import com.google.inject.Inject;
import org.bukkit.permissions.Permission;
import org.junit.jupiter.api.Test;
import simple.support.SetUpTest;
import simple.title.data.TitleData;
import simple.title.model.Title;

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
}
