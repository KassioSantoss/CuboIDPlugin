package brcomkassin.cuboid;

import lombok.*;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class CuboIDMananger {

    private static CuboIDMananger instance;
    private final Map<String, CuboID> CUBO_ID_MAP = new HashMap<>();
    private final Set<UUID> playersInCubo = new HashSet<>();
    private String cuboidName;

    public static CuboIDMananger getInstance() {
        if (instance == null) {
            instance = new CuboIDMananger();
        }
        return instance;
    }

    public void create(Player player, String cuboidName, Location pos1, Location pos2) {
        if (CUBO_ID_MAP.containsKey(cuboidName)) {
            player.sendMessage("Já existe um cuboid com esse nome!");
            return;
        }
        this.cuboidName = cuboidName;
        CUBO_ID_MAP.put(cuboidName, new CuboID(pos1, pos2));
        System.out.println(CUBO_ID_MAP);
        player.sendMessage("Área criada!");
    }

    public void handlePlayerEnterExitCubo(Player player, String enter, String exit) {

        if (!playersInCubo.contains(player.getUniqueId())) {
            player.sendMessage(enter);
            playersInCubo.add(player.getUniqueId());
            return;
        }
        player.sendMessage(exit);
        playersInCubo.remove(player.getUniqueId());
    }

    public CuboID getCuboID(String nameCuboid) {
        return CUBO_ID_MAP.get(nameCuboid);
    }

}
