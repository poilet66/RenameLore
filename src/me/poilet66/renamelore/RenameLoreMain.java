package me.poilet66.renamelore;

import org.bukkit.plugin.java.JavaPlugin;

public class RenameLoreMain extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("[" + getDescription().getName() + "] - Enabled");
        this.getCommand("lore").setExecutor(new LoreCommand());
        this.getCommand("rename").setExecutor(new RenameCommand());
    }

    @Override
    public void onDisable() {

    }

}
