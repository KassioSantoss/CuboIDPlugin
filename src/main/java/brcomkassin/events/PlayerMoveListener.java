package brcomkassin.events;

import brcomkassin.cuboid.CuboID;
import brcomkassin.cuboid.CuboIDMananger;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public final class PlayerMoveListener implements Listener {
    private final CuboIDMananger cuboIDMananger = CuboIDMananger.getInstance();

    @EventHandler
    public void onMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();

        CuboID cuboID = cuboIDMananger.getCuboID("teste");

        if (cuboID.hasPlayer(player)) {
            cuboID.handlePlayerEnterCubo();
            return;
        }
        cuboID.handlePlayerExitCubo();
    }

}
