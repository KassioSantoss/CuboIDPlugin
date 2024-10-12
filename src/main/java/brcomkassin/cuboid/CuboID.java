package brcomkassin.cuboid;

import lombok.AccessLevel;
import lombok.Getter;
import org.bukkit.Location;
import org.bukkit.entity.Player;

@Getter(value = AccessLevel.PRIVATE)
public class CuboID {
    private final Location pos1, pos2;
    private final double xMax;
    private final double xMin;
    private final double yMax;
    private final double yMin;
    private final double zMax;
    private final double zMin;

    protected CuboID(Location pos1, Location pos2) {
        this.pos1 = pos1;
        this.pos2 = pos2;
        this.xMax = Math.max(pos1.getX(), pos2.getX());
        this.yMax = Math.max(pos1.getY(), pos2.getY());
        this.zMax = Math.max(pos1.getZ(), pos2.getZ());
        this.xMin = Math.min(pos1.getX(), pos2.getX());
        this.yMin = Math.min(pos1.getY(), pos2.getY());
        this.zMin = Math.min(pos1.getZ(), pos2.getZ());
    }

    public boolean hasPlayer(Player player) {
        Location loc = player.getLocation();
        double x = loc.getX();
        double y = loc.getY();
        double z = loc.getZ();

        return (x >= xMin && x <= xMax)
                && (y >= yMin && y <= yMax)
                && (z >= zMin && z <= zMax);
    }

}
