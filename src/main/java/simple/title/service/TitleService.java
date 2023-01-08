package simple.title.service;

import org.bukkit.permissions.Permission;

public interface TitleService {

    void create(String name);

    void setDisplayName(String name, String displayName);

    void setDescription(String name, String description);

    void addPermission(String name, Permission permission);
}
