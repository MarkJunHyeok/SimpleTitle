package simple.support;


import be.seeseemelk.mockbukkit.MockBukkit;
import be.seeseemelk.mockbukkit.ServerMock;
import be.seeseemelk.mockbukkit.entity.PlayerMock;
import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import simple.title.PluginMain;
import simple.title.utils.BasicModule;

public class SetUpTest {


    protected PluginMain plugin;
    protected ServerMock server;
    protected PlayerMock player;
    protected Injector injector = Guice.createInjector(new BasicModule());

    @BeforeEach
    public void setUp() {
        server = MockBukkit.mock();
        plugin = MockBukkit.load(PluginMain.class);
        player = server.addPlayer();

        injector.injectMembers(this);
    }

    @AfterEach
    public void tearDown() {
        MockBukkit.unmock();
    }

}
