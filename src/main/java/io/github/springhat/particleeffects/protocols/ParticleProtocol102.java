package io.github.springhat.particleeffects.protocols;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.ProtocolManager;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.wrappers.EnumWrappers;
import io.github.springhat.particleeffects.ParticleType;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class ParticleProtocol102 {

    public static void play(ParticleType type, Location location, boolean longDistance, float speed, int amount, float offsetX, float offsetY, float offsetZ, double range) {
        play(type, location, longDistance, speed, amount, offsetX, offsetY, offsetZ, getPlayersInRange(location, range));
    }

    public static void play(ParticleType type, Location location, boolean longDistance, float speed, int amount, float offsetX, float offsetY, float offsetZ, Player... players) {
        play(type, location, longDistance, speed, amount, offsetX, offsetY, offsetZ, players);
    }

    public static void play(ParticleType type, Location location, boolean longDistance, float speed, int amount, float offsetX, float offsetY, float offsetZ, List<Player> players) {
        ProtocolManager protocolManager = ProtocolLibrary.getProtocolManager();
        PacketContainer particle = protocolManager.createPacket(PacketType.Play.Server.WORLD_PARTICLES); // Particle

        /*particle.getModifier().writeDefaults();

        for (Object o : particle.getModifier().getValues())
            System.out.println(o.getClass().getName());*/

        particle.getParticles().write(0, EnumWrappers.Particle.values()[type.getId()]); // Particle
        particle.getBooleans().write(0, longDistance); // Long Distance
        particle.getIntegers()
                .write(0, amount); // Particle Count
        particle.getFloat()
                .write(0, (float) location.getX()) // X
                .write(1, (float) location.getY()) // Y
                .write(2, (float) location.getZ()) // Z
                .write(3, offsetX) // Offset X
                .write(4, offsetY) // Offset Y
                .write(5, offsetZ) // Offset Z
                .write(6, speed); // Speed

        for (Player player : players)
            try {
                protocolManager.sendServerPacket(player, particle);
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
    }

    private static List<Player> getPlayersInRange(Location location, double range) {
        List<Player> playersInRange = new ArrayList<>();
        for (Player player : Bukkit.getOnlinePlayers())
            if (player.getLocation().distance(location) <= range)
                playersInRange.add(player);
        return playersInRange;
    }

}
