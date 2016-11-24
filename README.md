# ParticleEffects
> ParticleEffects is a library for particle effects.

## Dependencies ##
* ProtocolLib

## Usage ##

* `play(ParticleType type, Location location, boolean longDistance, float speed, int amount, float offsetX, float offsetY, float offsetZ, double range)`
* `play(ParticleType type, Location location, boolean longDistance, float speed, int amount, float offsetX, float offsetY, float offsetZ, Player... players)`
* `play(ParticleType type, Location location, boolean longDistance, float speed, int amount, float offsetX, float offsetY, float offsetZ, List<Player> players)`

### Example ###

```java
@EventHandler
public void onPlayerJoin(PlayerJoinEvent event) {
    Player player = event.getPlayer();
  
    ParticleProtocol102.play(ParticleType.SMOKE, player.getLocation(), true, 0.3f, 5, 0.0f, 0.0f, 0.0f, 100);
}
```
