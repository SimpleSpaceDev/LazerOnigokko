package jp.simplespace.lazeronigokko.Util;

import org.bukkit.*;

public class Lazer {
    public static void spawnParticle(World world, Location loc){
        Particle.DustOptions dust = new Particle.DustOptions(Color.RED,1.5f);
        world.spawnParticle(Particle.REDSTONE,loc,0,dust);
    }
}
