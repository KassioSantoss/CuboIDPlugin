package brcomkassin;

import brcomkassin.cuboid.CuboIDCreate;
import brcomkassin.events.PlayerMoveListener;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class CuboIDPlugin extends JavaPlugin {

    private final CuboIDCreate cuboIDCreate = new CuboIDCreate();

    @Override
    public void onEnable() {
        registerEvents(
                cuboIDCreate,
                new PlayerMoveListener()
        );

        registerCommands();
    }

    private void registerEvents(Listener... listeners) {
        for (Listener listener : listeners) {
            getServer().getPluginManager().registerEvents(listener, this);
        }
    }

    private void registerCommands() {
        getCommand("cuboid").setExecutor(cuboIDCreate);

    }

    public static CuboIDPlugin getInstance() {
        return CuboIDPlugin.getPlugin(CuboIDPlugin.class);
    }

}
