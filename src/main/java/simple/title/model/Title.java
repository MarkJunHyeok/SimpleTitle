package simple.title.model;

import lombok.Getter;
import org.bukkit.permissions.Permission;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Strings.isNullOrEmpty;

@Getter
public class Title {

    private final List<Permission> permissions = new ArrayList<>();
    private String name;
    private String description;

    private Title(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public static Title create(String name, String description) {
        checkArgument(!isNullOrEmpty(name));
        checkArgument(!isNullOrEmpty(description));

        return new Title(name, description);
    }

    public void changeName(String name) {
        checkArgument(!isNullOrEmpty(name));

        this.name = name;
    }

    public void changeDescription(String description) {
        checkArgument(!isNullOrEmpty(description));

        this.description = description;
    }

    public void addPermission(Permission permission) {
        this.permissions.forEach(it ->
                checkArgument(!it.getName().equals(permission.getName()))
        );

        this.permissions.add(permission);
    }
}
