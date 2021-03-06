package io.nozemi.runescape.service.serializers;

/**
 * Created by Bart on 4-3-2015.
 */
public enum PlayerLoadResult {
    OK(2),
	INVALID_DETAILS(3),
	BANNED(4),
	ALREADY_ONLINE(5),
	WORLD_FULL(7),
	UNREGISTERED_ACCOUNT(10),
	LOGIN_THROTTLE(16),
	CLOSED_BETA(19),
	ERROR_LOADING(24),
	ENTER_AUTH(56),
	AUTH_MISMATCH(57),
	SILENT_FAIL(-1);

    private int code;

    PlayerLoadResult(int code) {
        this.code = code;
    }

    public int code() {
        return code;
    }

}
