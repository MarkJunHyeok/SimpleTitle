package simple.fixture;

import be.seeseemelk.mockbukkit.block.BlockMock;
import org.bukkit.Material;
import org.bukkit.block.Block;

import static org.bukkit.Material.EMERALD_BLOCK;

public class BlockFixture {

    public static Block getBlock() {
        return new BlockMock(EMERALD_BLOCK);
    }

    public static Block getBlock(Material material) {
        return new BlockMock(material);
    }
}
