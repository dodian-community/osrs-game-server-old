package io.nozemi.runescape.service.logging;

import io.nozemi.runescape.service.Service;
import org.springframework.stereotype.Component;

@Component
public interface LoggingService extends Service {
    void logNpcKill(int playerId, int npc, int kills);
    void logPlayerKill(int playerId, int targetId);
    void logPublicChat(int playerId, int world, int x, int y, int z, String message);
    void logPrivateMessage(int fromPlayerId, int toPlayer, int fromWorld, int toWorld, int x, int y, int z, String message);
    void logLogin(int playerId, int x, int y, int z);
    void logLogout(int playerId, int x, int y, int z);
}
