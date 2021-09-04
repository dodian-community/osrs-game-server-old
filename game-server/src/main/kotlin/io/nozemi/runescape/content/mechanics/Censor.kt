package io.nozemi.runescape.content.mechanics

import io.nozemi.runescape.model.AttributeKey
import io.nozemi.runescape.model.entity.Player
import io.nozemi.runescape.util.Misc

object Censor {

    @JvmStatic var damperedWords = mutableListOf("havoc", "runite")

    @JvmStatic var baddies = mutableListOf("nigger", "jew")

    /**
     * Flag if the message will be dampered, so the speaker will see his public chat but it won't be broadcast to others.
     */
    @JvmStatic fun dampered(player: Player, text: String): Boolean {
        var repeatSpamTimes: ArrayList<Long>? = player.attribOr(AttributeKey.SPAM_HISTORY, null)
        val bad = text.toLowerCase() in damperedWords
        if (bad) {
            if (repeatSpamTimes == null) {
                repeatSpamTimes = arrayListOf(System.currentTimeMillis())
                player.putattrib(AttributeKey.SPAM_HISTORY, repeatSpamTimes)
            } else {
                repeatSpamTimes.removeIf { t -> Misc.secsSince(t) > 60 }
                repeatSpamTimes.add(System.currentTimeMillis())
            }
            // Three occurrences in last 60 seconds
            return repeatSpamTimes.size >= 3
        }
        return false
    }

    /**
     * Replaces bad words with *****
     */
    @JvmStatic fun starred(text: String): String {
        baddies.forEach { bad ->
            if (text.contains(bad)) {
                return text.replace(bad, "*".repeat(bad.length))
            }
        }
        return "" // no replacement
    }
}