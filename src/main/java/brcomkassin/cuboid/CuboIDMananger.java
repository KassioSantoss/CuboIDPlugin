package brcomkassin.cuboid;

import lombok.*;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import java.util.*;

@Getter(value = AccessLevel.PRIVATE)
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
        if (pos1 == null) {
            player.sendMessage("Por favor, selecione uma posição primeiro!");
            return;
        }
        if (pos2 == null) {
            player.sendMessage("Por favor, selecione a segunda posição primeiro!");
            return;
        }

        if (CUBO_ID_MAP.containsKey(cuboidName)) {
            player.sendMessage("Já existe um cuboid com esse nome!");
            return;
        }

        this.cuboidName = cuboidName;
        CUBO_ID_MAP.put(cuboidName, new CuboID(pos1, pos2));
        player.sendMessage("Área criada!");
    }

    public CuboID getCuboID(String nameCuboid) {
        return CUBO_ID_MAP.get(nameCuboid);
    }

}
