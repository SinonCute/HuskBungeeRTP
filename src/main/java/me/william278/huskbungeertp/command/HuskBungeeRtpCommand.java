package me.william278.huskbungeertp.command;

import me.william278.huskbungeertp.HuskBungeeRTP;
import me.william278.huskbungeertp.MessageManager;
import me.william278.huskbungeertp.config.Group;
import me.william278.huskbungeertp.config.Settings;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.event.HoverEvent;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.util.StringUtil;

import java.util.*;

public class HuskBungeeRtpCommand implements CommandExecutor {

    private static final HuskBungeeRTP plugin = HuskBungeeRTP.getInstance();
    private static final TextComponent PLUGIN_INFORMATION = Component
            .text("[BungeeRTP]", TextColor.color(0x00fb9a), TextDecoration.BOLD)
            .append(Component.text(" | Version " + plugin.getServer().getVersion(), TextColor.color(0x00fb9a)))
            .append(Component.text(" | Developed by SinonCute", TextColor.color(0x00fb9a)));


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 1) {
            switch (args[0].toLowerCase()) {
                case "about", "info" -> {
                    sender.sendMessage(PLUGIN_INFORMATION);
                }
                case "groups" -> {
                    sender.sendMessage(
                            Component.text("Available groups:", TextColor.color(0x00fb9a), TextDecoration.BOLD)
                    );
                    HashSet<Group> groups = HuskBungeeRTP.getSettings().getGroups();
                    if (groups.isEmpty()) {
                        sender.sendMessage(
                                Component.text("[Error:]", TextColor.color(0xff3300))
                                .append(Component.text(" [There are no RTP destination groups currently configured!]", TextColor.color(0xff7e5e)))
                        );
                        return true;
                    }
                    for (Group group : groups) {
                        StringJoiner joiner = new StringJoiner("\n");
                        for (Group.Server server : group.getServers()) {
                            StringJoiner worldJoiner = new StringJoiner(", ");
                            for (String worldName : server.getWorlds()) {
                                worldJoiner.add(worldName);
                            }
                            joiner.add("&f• &7" + server.getName() + "\\(" + worldJoiner + "\\)");
                        }
                        Component message = Component.text()
                                .append(Component.text(group.groupId(), NamedTextColor.AQUA)
                                        .hoverEvent(HoverEvent.showText(Component.text("Group ID", NamedTextColor.AQUA))))
                                .append(Component.text(" • ", NamedTextColor.DARK_GRAY))
                                .append(Component.text(group.getGroupDatabaseTableName(), NamedTextColor.GRAY)
                                        .hoverEvent(HoverEvent.showText(Component.text("Group database table name", NamedTextColor.AQUA))))
                                .append(Component.text(" • ", NamedTextColor.DARK_GRAY))
                                .append(Component.text("⌚" + group.getCoolDownTimeMinutes() + "m", NamedTextColor.GRAY)
                                        .hoverEvent(HoverEvent.showText(Component.text("Group cooldown time", NamedTextColor.AQUA))))
                                .append(Component.text(" • ", NamedTextColor.DARK_GRAY))
                                .append(Component.text("ⓘ Servers", NamedTextColor.WHITE)
                                        .hoverEvent(HoverEvent.showText(Component.text("Servers & worlds:\n" + joiner, NamedTextColor.AQUA))))
                                .build();

                        sender.sendMessage(message);
                    }
                }
//                case "plan" -> {
//                    if (PlanDataManager.usePlanIntegration()) {
//                        HashMap<String, Long> planPlayTimes = PlanDataManager.getPlanPlayTimes();
//                        if (planPlayTimes == null) {
//                            sender.sendMessage(Component.text("[Error:]", NamedTextColor.RED)
//                                    .append(Component.text(" [Failed to retrieve the Plan play times.]", NamedTextColor.DARK_RED)));
//                            return true;
//                        }
//                        if (planPlayTimes.isEmpty()) {
//                            sender.sendMessage(Component.text("[Error:]", NamedTextColor.RED)
//                                    .append(Component.text(" [Could not find any servers correctly configured with Plan!]", NamedTextColor.DARK_RED)));
//                            return true;
//                        }
//
//                        sender.sendMessage(Component.text("[HuskBungeeRTP]", NamedTextColor.AQUA, TextDecoration.BOLD)
//                                .append(Component.text(" | Total Plan play times for servers (in ticks, over " + HuskBungeeRTP.getSettings().getPlanAveragePlayerCountDays() + "d):", NamedTextColor.AQUA)));
//                        for (String serverId : planPlayTimes.keySet()) {
//                            long playTime = planPlayTimes.get(serverId);
//                            sender.sendMessage(Component.text("• ", NamedTextColor.DARK_GRAY)
//                                    .append(Component.text(serverId + ":", NamedTextColor.AQUA)
//                                            .hoverEvent(HoverEvent.showText(Component.text("ID of the server", NamedTextColor.AQUA))))
//                                    .append(Component.text(" ⌚" + playTime + " ticks", NamedTextColor.WHITE)
//                                            .hoverEvent(HoverEvent.showText(Component.text("The total play time, in ticks, according to the Plan database", NamedTextColor.AQUA)))));
//                        }
//                    } else {
//                        sender.sendMessage(Component.text("[Error:]", NamedTextColor.RED)
//                                .append(Component.text(" [The Player Analytics (Plan) integration is currently disabled.]", NamedTextColor.DARK_RED)));
//                    }
//                }
                case "playercounts" -> {
                    if (HuskBungeeRTP.getSettings().getLoadBalancingMethod() == Settings.LoadBalancingMethod.PLAYER_COUNTS) {
                        HashMap<String,Integer> playerCounts = HuskBungeeRTP.serverPlayerCounts;
                        if (playerCounts == null) {
                            sender.sendMessage(Component.text("[Error:]", NamedTextColor.RED)
                                    .append(Component.text(" [Failed to retrieve the player counts.]", NamedTextColor.DARK_RED)));
                            return true;
                        }
                        if (playerCounts.isEmpty()) {
                            sender.sendMessage(Component.text("[Error:]", NamedTextColor.RED)
                                    .append(Component.text(" [Could not find any servers; are your groups setup in your config?]", NamedTextColor.DARK_RED)));
                            return true;
                        }
                        sender.sendMessage(Component.text("[HuskBungeeRTP]", NamedTextColor.AQUA, TextDecoration.BOLD)
                                .append(Component.text(" | Current player counts on your network):", NamedTextColor.AQUA)));
                        for (String serverId : playerCounts.keySet()) {
                            int playerCount = playerCounts.get(serverId);
                            sender.sendMessage(Component.text("• ", NamedTextColor.DARK_GRAY)
                                    .append(Component.text(serverId + ":", NamedTextColor.AQUA)
                                            .hoverEvent(HoverEvent.showText(Component.text("ID of the server", NamedTextColor.AQUA))))
                                    .append(Component.text(" ☻" + playerCount + " players", NamedTextColor.WHITE)
                                            .hoverEvent(HoverEvent.showText(Component.text("The number of players on this server", NamedTextColor.AQUA)))));
                        }
                    } else {
                        sender.sendMessage(Component.text("[Error:]", NamedTextColor.RED)
                                .append(Component.text(" [You do not have player count mode set for the load balancer]", NamedTextColor.DARK_RED)));
                    }
                }
                case "reload" -> {
                    HuskBungeeRTP.reloadConfigFile();
                    sender.sendMessage(Component.text("[HuskBungeeRTP]", TextColor.color(0x00fb9a), TextDecoration.BOLD)
                            .append(Component.text(" | Reloaded config and message files.", TextColor.color(0x00fb9a))));
                }
            }
        } else {
            MessageManager.sendMessage(sender, "error_invalid_syntax", command.getUsage());
        }
        return true;
    }

    public static class HuskBungeeRtpTabCompleter implements TabCompleter {

        private static final String[] commandTabArgs = {"about", "groups", "plan", "playercounts", "reload"};

        @Override
        public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
            if (command.getPermission() != null) {
                if (!sender.hasPermission(command.getPermission())) {
                    return Collections.emptyList();
                }
            }
            if (args.length == 0 || args.length == 1) {
                final List<String> tabCompletions = new ArrayList<>();
                StringUtil.copyPartialMatches(args[0], Arrays.asList(commandTabArgs), tabCompletions);
                Collections.sort(tabCompletions);
                return tabCompletions;
            }
            return Collections.emptyList();
        }
    }
}
