package simple.title.data;

import simple.title.model.Title;

public interface TitleData {

    void saveData(Title title);

    Title getTitle(String titleName);
}
