package simple.title.service;

import com.google.inject.Inject;
import org.bukkit.permissions.Permission;
import simple.title.data.TitleData;
import simple.title.model.Title;

public class TitleModelService implements TitleService {

    @Inject
    private TitleData titleData;

    @Override
    public void create(String name) {
        Title title = Title.create(name);

        titleData.saveData(title);
    }

    @Override
    public void setDisplayName(String name, String displayName) {
        Title title = titleData.getTitle(name);

        title.setDisplayName(displayName);

        titleData.saveData(title);
    }

    @Override
    public void setDescription(String name, String description) {
        Title title = titleData.getTitle(name);

        title.setDescription(description);

        titleData.saveData(title);
    }

    @Override
    public void addPermission(String name, Permission permission) {
        Title title = titleData.getTitle(name);

        title.addPermission(permission);

        titleData.saveData(title);
    }
}
