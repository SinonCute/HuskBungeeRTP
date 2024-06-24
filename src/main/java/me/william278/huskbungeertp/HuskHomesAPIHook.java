package me.william278.huskbungeertp;

import net.william278.huskhomes.api.HuskHomesAPI;
import net.william278.huskhomes.position.Position;
import net.william278.huskhomes.teleport.Teleport;
import net.william278.huskhomes.teleport.TeleportBuilder;
import net.william278.huskhomes.user.OnlineUser;
import org.bukkit.entity.Player;

public class HuskHomesAPIHook {
    private final HuskHomesAPI huskHomesAPI;

    public HuskHomesAPIHook() {
        this.huskHomesAPI = HuskHomesAPI.getInstance();
    }

    public void teleportPlayer(Player player, Position position) {
        OnlineUser onlineUser = huskHomesAPI.adaptUser(player);

        huskHomesAPI.teleportBuilder()
                .teleporter(onlineUser)
                .target(position)
                .toTeleport()
                .execute();
    }
}
