package simple.title.data;

import simple.title.model.Title;

import java.util.HashMap;


public class TitleMemoryData implements TitleData {

    private static HashMap<String, Title> data = new HashMap<>();

    @Override
    public void saveData(Title title) {
        data.put(title.getName(), title);
    }

    @Override
    public Title getTitle(String titleName) {
        return data.get(titleName);
    }
}
