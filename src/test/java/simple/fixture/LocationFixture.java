package simple.fixture;

import be.seeseemelk.mockbukkit.WorldMock;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;

import static org.bukkit.Material.AIR;

public class LocationFixture {

    public static Location getLocation() {
        WorldMock worldMock = new WorldMock(AIR, 1, 100, 100);

        return new Location(worldMock, 50, 50, 50);
    }

    public static Location getLocation(Material material) {
        WorldMock worldMock = new WorldMock(material, 1, 100, 100);

        return new Location(worldMock, 50, 50, 50);
    }

    public static Location getLocation(World world) {
        return new Location(world, 50, 50, 50);
    }
}
