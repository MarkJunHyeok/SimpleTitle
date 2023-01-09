package simple.title.data;

import simple.title.model.Title;

import java.util.List;

public interface TitleData {

    void saveData(Title title);

    Title getTitle(String titleName);

    List<Title> getTitles();
}
