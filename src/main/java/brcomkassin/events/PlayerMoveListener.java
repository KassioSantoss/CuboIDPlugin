package brcomkassin.events;

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

        if (cuboIDMananger.getCuboID("teste").hasPlayer(player)) {
            player.sendMessage("contem player!");
            cuboIDMananger.handlePlayerEnterExitCubo(player,"Bem vindo a área!", "Volte sempre a essa área!");
        }
    }

}
