package net.dodian.runescape.util

import com.google.gson.Gson
import com.google.gson.GsonBuilder

object JGson {
	
	@JvmStatic
	@JvmOverloads
	fun get(prettyPrinting: Boolean = true): Gson {
		return when (prettyPrinting) {
			true -> GsonBuilder().registerTypeAdapterFactory(GsonPropertyValidator()).setPrettyPrinting().create()
			else -> GsonBuilder().registerTypeAdapterFactory(GsonPropertyValidator()).setPrettyPrinting().create()
		}
	}
	
}
