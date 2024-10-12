package brcomkassin.cuboid;

import brcomkassin.cuboid.CuboIDMananger;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.jetbrains.annotations.NotNull;
import java.util.Objects;

@Getter
@Setter
public final class CuboIDCreate implements Listener, CommandExecutor {

    private final CuboIDMananger cuboIDMananger = CuboIDMananger.getInstance();
    private Location pos1;
    private Location pos2;

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();

        if (player.getInventory().getItemInMainHand().getType() != Material.STICK) return;

        if (event.getAction().isRightClick()) {
            pos1 = Objects.requireNonNull(event.getClickedBlock()).getLocation();
            player.sendMessage("Primeira posiçao salva!");
            return;
        }

        if (event.getAction().isLeftClick()) {
            pos2 = Objects.requireNonNull(event.getClickedBlock()).getLocation();
            event.setCancelled(true);
            player.sendMessage("Segunda posiçao salva!");
        }

    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player player)) return true;

        if (pos1 == null) {
            player.sendMessage("Por favor, selecione uma posição primeiro!");
            return true;
        }
        if (pos2 == null) {
            player.sendMessage("Por favor, selecione a segunda posição primeiro!");
            return true;
        }
        if (args.length < 1) {
            player.sendMessage("Uso correto: /cuboid <nome>");
            return true;
        }

        String name = args[0];

        cuboIDMananger.create(player,name, pos1, pos2);

        return false;
    }
}
