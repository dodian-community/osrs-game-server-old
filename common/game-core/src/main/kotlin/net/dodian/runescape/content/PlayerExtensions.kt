package net.dodian.runescape.content

import net.dodian.runescape.events.Script
import net.dodian.runescape.model.entity.player.Varps

operator fun Varps.get(i: Int): Int {
	return varp(i)
}

operator fun Varps.set(i: Int, j: Int) {
	varp(i, j)
}

fun Script.clearContext() {
	setContext(1)
}

fun String.col(col: String): String {
	return StringBuilder("<col=").append(col).append(">").append(this).append("</col>").toString()
}