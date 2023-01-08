package simple.title.model;

import org.bukkit.permissions.Permission;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;


class TitleTest {

    @Test
    void 칭호_생성() {
        Title title = Title.create("name");

        assertThat(title.getName()).isEqualTo("name");
    }

    @ParameterizedTest
    @NullAndEmptySource
    void 칭호_생성_실패__이름이_없음(String name) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Title.create(name);
        });
    }

    @Test
    void 칭호_표시될_이름_적용() {
        Title title = Title.create("name");

        title.setDisplayName("changeDisplayName");

        assertThat(title.getDisplayName()).isEqualTo("changeDisplayName");
    }

    @ParameterizedTest
    @NullAndEmptySource
    void 칭호_표시될_이름_적용_실패__표시될_이름이_공백(String changeDisplayName) {
        Title title = Title.create("name");

        assertThatIllegalArgumentException().isThrownBy(() -> {
            title.setDisplayName(changeDisplayName);
        });
    }

    @Test
    void 칭호_설명_적용() {
        Title title = Title.create("name");

        title.setDescription("changeDescription");

        assertThat(title.getDescription()).isEqualTo("changeDescription");
    }

    @ParameterizedTest
    @NullAndEmptySource
    void 칭호_설명_적용_실패__설명이_공백(String changeDescription) {
        Title title = Title.create("name");

        assertThatIllegalArgumentException().isThrownBy(() -> {
            title.setDescription(changeDescription);
        });
    }

    @Test
    void 칭호_전용_권한_추가() {
        Title title = Title.create("name");

        Permission permission = new Permission("test.permission");

        title.addPermission(permission);

        assertThat(title.getPermissions().get(0)).isEqualTo(permission);
    }

    @Test
    void 칭호_전용_권한_추가_실패__이미_있는_권한임() {
        Title title = Title.create("name");

        Permission permission = new Permission("test.permission");

        title.addPermission(permission);

        assertThatIllegalArgumentException().isThrownBy(() -> {
            title.addPermission(permission);
        });
    }
}
