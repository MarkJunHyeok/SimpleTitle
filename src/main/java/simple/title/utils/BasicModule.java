package simple.title.utils;

import com.google.inject.AbstractModule;
import simple.title.data.TitleData;
import simple.title.data.TitleMemoryData;
import simple.title.service.TitleModelService;
import simple.title.service.TitleService;

public class BasicModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(TitleData.class).to(TitleMemoryData.class).asEagerSingleton();
        bind(TitleService.class).to(TitleModelService.class).asEagerSingleton();
    }
}
