package simple.title.service;

import org.bukkit.permissions.Permission;
import simple.title.model.Title;

import java.util.List;

public interface TitleService {

    void create(String name);

    void setDisplayName(String name, String displayName);

    void setDescription(String name, String description);

    void addPermission(String name, Permission permission);

    List<Title> getTitles();
}
