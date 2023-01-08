package simple.title.model;

import lombok.Getter;
import org.bukkit.permissions.Permission;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Strings.isNullOrEmpty;

@Getter
public class Title {

    private final String name;
    private String displayName;
    private String description;
    private final List<Permission> permissions = new ArrayList<>();

    private Title(String name) {
        this.name = name;
    }

    public static Title create(String name) {
        checkArgument(!isNullOrEmpty(name));

        return new Title(name);
    }

    public void setDisplayName(String displayName) {
        checkArgument(!isNullOrEmpty(displayName));

        this.displayName = displayName;
    }

    public void setDescription(String description) {
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
