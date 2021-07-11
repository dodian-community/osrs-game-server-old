package io.nozemi.runescape.fs

import io.nozemi.runescape.model.AttributeKey
import it.unimi.dsi.fastutil.objects.ObjectArrayList
import io.nozemi.runescape.model.Tile
import io.nozemi.runescape.model.World
import io.nozemi.runescape.model.entity.Player
import io.nozemi.runescape.model.map.MapObj
import java.nio.ByteBuffer
import kotlin.experimental.and

/**
 * Created by Bart on 8/11/2015.
 */
class MapDefinition(private val rx: Int, private val rz: Int) : Definition {
	
	val masks by lazy { Array<Array<IntArray>>(4, { Array<IntArray>(64, { IntArray(64) }) }) }
	val floors by lazy { Array<Array<ByteArray>>(4, { Array<ByteArray>(64, { ByteArray(64) }) }) }
	val objs by lazy { Array<Array<Array<ObjectArrayList<MapObj>?>>>(4, { Array<Array<ObjectArrayList<MapObj>?>>(64, { arrayOfNulls<ObjectArrayList<MapObj>?>(64) }) }) }
	// Only if 'all' defined in #load()
	//val overlays  by lazy {  Array<Array<ByteArray>>(4, { Array<ByteArray>(64, { ByteArray(64) }) })}
	//val underlays by lazy { Array<Array<ByteArray>>(4, { Array<ByteArray>(64, { ByteArray(64) }) })}
	//val rotations  by lazy { Array<Array<ByteArray>>(4, { Array<ByteArray>(64, { ByteArray(64) }) })}
	//val shapes  by lazy { Array<Array<ByteArray>>(4, { Array<ByteArray>(64, { ByteArray(64) }) })}
	//val calcHeight  by lazy { Array<IntArray>(64, { IntArray(64) })}
	//val heights  by lazy { Array<Array<IntArray>>(4, { Array<IntArray>(64, { IntArray(64) }) })}
	//val mapSquares by lazy { Array<Array<Array<SceneTile?>>>(4, { Array<Array<SceneTile?>>(64, { arrayOfNulls<SceneTile?>(64) }) }) }
	
	fun solidAll() {}
	
	fun load(defrepo: DefinitionRepository, map: ByteArray, objects: ByteArray, all: Boolean) {
		var buffer = ByteBuffer.wrap(map)
		val baseX = rx * 64
		val baseZ = rz * 64
		for (plane in 0..3) {
			for (x in 0..63) {
				for (y in 0..63) {
					while (true) {
						val var9 = buffer.get().toInt() and 0xFF
						if (var9 == 0) {
							break
						}
						if (var9 == 1) {
							var var8 = buffer.get().toInt()
							if (var8 == 1) {
								var8 = 0
							}
							if (all) {
								if (plane == 0) {
									//heights[0][x][y] = -var8 * 8
								} else {
									//heights[plane][x][y] = heights[plane - 1][x][y] - var8 * 8
								}
							}
							break
						}
						if (var9 <= 49) {
							if (all) {
								/*overlays[plane][x][y] = */buffer.get()
								//shapes[plane][x][y] = ((var9 - 2) / 4).toByte()
								//rotations[plane][x][y] = ((var9 - 2) and 3).toByte()
							} else {
								buffer.get()
							}
						} else if (var9 <= 81) {
							floors[plane][x][y] = (var9 - 49).toByte()
						} else if (all) {
							//underlays[plane][x][y] = (var9 - 81).toByte()
						}
					}
				}
			}
		}
		for (plane in 0..3) {
			for (x in 0..63) {
				for (y in 0..63) {
					if ((floors[plane][x][y] and 0x1) == 1.toByte()) {
						var realPlane = plane
						if ((floors[1][x][y] and 2) == 2.toByte())
							realPlane--
						if (realPlane >= 0)
							addFloor(defrepo, realPlane, x, y, true)
					}
				}
			}
		}
		if (objects.size < 5) {
			solidAll()
		}
		buffer = ByteBuffer.wrap(objects)
		buffer.position(0)
		var id = -1
		while (true) {
			val idOffset = readCompact(buffer)
			if (idOffset == 0) {
				return
			}
			id += idOffset
			var info = 0
			while (true) {
				val infoDiff = readCompact(buffer)
				if (infoDiff == 0) {
					break
				}
				info += infoDiff - 1
				val localZ = info and 63
				val localX = (info shr 6) and 63
				val level = info shr 12
				val settings = buffer.get().toInt() and 0xFF
				val type = settings shr 2
				val rotation = settings and 3
				val x = localX + 0
				val z = localZ + 0
				if (x >= 0 && z >= 0 && x < 64 && z < 64) {
					var targetLevel = level
					if ((floors[1][x][z] and 2) == 2.toByte()) {
						targetLevel = level - 1
					}
					if (targetLevel >= 0) {
						if (objs[targetLevel][x][z] == null)
							objs[targetLevel][x][z] = ObjectArrayList<MapObj>()
						objs[targetLevel][x][z]!!.add(MapObj(Tile(baseX + x, baseZ + z, targetLevel), id, type, rotation))
					}
					try {
						clip(defrepo, id, x, z, targetLevel, type, rotation, true)
					} catch (ignored: Exception) {
					}
				}
			}
		}
	}
	
	fun objByType(level: Int, x: Int, z: Int, type: Int): MapObj? {
		if (objs[level][x][z] != null) {
			for (o in objs[level][x][z]!!) {
				val obj = (o as MapObj)
				if (obj.type() == type)
					return obj
			}
		}
		return null
	}
	
	// Multiple objects on one tile, maybe ground dec, walls, wall dec, an a normal interactable object like a crate.
	fun objs(level: Int, x: Int, z: Int): ObjectArrayList<MapObj> {
		return if (objs[level][x][z] == null) ObjectArrayList(0) else objs[level][x][z]!!
	}
	
	fun objByIdWithinDistance(level: Int, x: Int, z: Int, id: Int, squareRadius: Int): MapObj? {
		for (xOffset in x - squareRadius..x + squareRadius - 1) {
			if (xOffset < 0 || xOffset > 63) {
				continue
			}
			for (zOffset in z - squareRadius..z + squareRadius - 1) {
				if (zOffset < 0 || zOffset > 63) {
					continue
				}
				if (objs[level][xOffset][zOffset] != null) {
					for (`object` in objs[level][xOffset][zOffset]!!) {
						val mapObj = `object` as MapObj
						if (mapObj.id() == id) {
							return mapObj
						}
					}
				}
			}
		}
		return null
	}
	
	fun objById(level: Int, x: Int, z: Int, id: Int): MapObj? {
		if (objs[level][x][z] != null) {
			for (o in objs[level][x][z]!!) {
				val obj = (o as MapObj)
				if (obj.id() == id)
					return obj
			}
		}
		return null
	}
	
	private fun clip(defrepo: DefinitionRepository, `object`: Int, x: Int, y: Int, plane: Int, type: Int, rotation: Int, add: Boolean) {
		// ObjectDefinition objectDefinition =
		// ObjectDefinition.get(CatanaiRS3.ds, object); // load
		//long l = System.currentTimeMillis();
		
		val objectDefinition = defrepo.get(ObjectDefinition::class.java, `object`) ?: return
		//boolean bank = objectDefinition.name != null && (objectDefinition.name.toLowerCase().startsWith("counter") || objectDefinition.name.toLowerCase().startsWith("bank")) || object == 11763;
		if (if (type == 22) objectDefinition.clipType != 1 else objectDefinition.clipType == 0) {
			return
		}
		if (type >= 0 && type <= 3) {
			// if (!objectDefinition.ignoreClipOnAlternativeRoute ||
			// objectDefinition.projectileClipped)
			//if (objectDefinition.sizeX > 1 || objectDefinition.sizeY > 1)
			//	System.out.println("wall at " + x + ", " + y + " rotated " + rotation);
			//if (rx == 12084 >> 8 && ry == (12084 & 0xFF)) {
			//}
			
			// TODO support sized walls!
			addWall(defrepo, plane, x, y, type, rotation, objectDefinition.projectileClipped, !objectDefinition.unclipped, add)
		} else if (type >= 9 && type <= 21/* || type == 4 */) {
			val sizeX: Int
			val sizeY: Int
			if (rotation != 1 && rotation != 3) {
				sizeX = objectDefinition.sizeX
				sizeY = objectDefinition.sizeY
			} else {
				sizeX = objectDefinition.sizeY
				sizeY = objectDefinition.sizeX
			}
			// System.out.println("x="+sizeX + ", y=" + sizeY);
			addObject(defrepo, plane, x, y, sizeX, sizeY, objectDefinition.projectileClipped, !objectDefinition.unclipped, add)
			// if (objectDefinition.isProjectileCliped())// TODO same as aove i
			// am black
			// addObject(plane, x, y, sizeX, sizeY,
			// objectDefinition.isProjectileCliped(),
			// !objectDefinition.ignoreClipOnAlternativeRoute);
		} else if (type == 22) {
			addFloor(defrepo, plane, x, y, add)
		}
	}
	
	fun clip(world: World, obj: MapObj) {
		clip(world.definitions(), obj.id(), obj.tile().x and 63, obj.tile().z and 63, obj.tile().level, obj.type(), obj.rot(), true)
	}
	
	fun unclip(world: World, obj: MapObj) {
		clip(world.definitions(), obj.id(), obj.tile().x and 63, obj.tile().z and 63, obj.tile().level, obj.type(), obj.rot(), false)
	}

	fun clipTile(repo: DefinitionRepository, plane: Int, x: Int, y: Int, add: Boolean) {
		addMask(repo, plane, x, y, 2097152, add)
	}

	fun addFloor(repository: DefinitionRepository, plane: Int, x: Int, y: Int, add: Boolean) {
		addMask(repository, plane, x, y, 0x40000, add)
	}
	
	fun removeFloor(plane: Int, x: Int, y: Int) {
		removeMask(plane, x, y, 262144)
	}
	
	fun addObject(repository: DefinitionRepository, plane: Int, x: Int, y: Int, sizeX: Int, sizeY: Int, solid: Boolean, notAlternative: Boolean, add: Boolean) {
		var mask = 256
		if (solid) {
			mask = mask or 0x20000
		}
		if (notAlternative) {
			mask = mask or 0x40000000
		}
		for (tileX in x..x + sizeX - 1) {
			for (tileY in y..y + sizeY - 1) {
				addMask(repository, plane, tileX, tileY, mask, add)
			}
		}
	}
	
	fun removeObject(plane: Int, x: Int, y: Int, sizeX: Int, sizeY: Int, solid: Boolean, notAlternative: Boolean) {
		var mask = 256
		if (solid)
			mask = mask or 131072
		if (notAlternative)
			mask = mask or 1073741824
		for (tileX in x..x + sizeX - 1) {
			for (tileY in y..y + sizeY - 1) {
				removeMask(plane, tileX, tileY, mask)
			}
		}
	}
	
	fun addWall(repository: DefinitionRepository, plane: Int, x: Int, y: Int, type: Int, rotation: Int, solid: Boolean, notAlternative: Boolean, add: Boolean) {
		if (type == 0) {
			if (rotation == 0) {
				addMask(repository, plane, x, y, 128, add)
				addMask(repository, plane, x - 1, y, 8, add)
			} else if (rotation == 1) {
				addMask(repository, plane, x, y, 2, add)
				addMask(repository, plane, x, 1 + y, 32, add)
			} else if (rotation == 2) {
				addMask(repository, plane, x, y, 8, add)
				addMask(repository, plane, 1 + x, y, 128, add)
			} else if (rotation == 3) {
				addMask(repository, plane, x, y, 32, add)
				addMask(repository, plane, x, -1 + y, 2, add)
			}
		} else if (type == 1 || type == 3) {
			if (rotation == 0) {
				addMask(repository, plane, x, y, 1, add)
				addMask(repository, plane, -1 + x, 1 + y, 16, add)
			} else if (rotation == 1) {
				addMask(repository, plane, x, y, 4, add)
				addMask(repository, plane, 1 + x, 1 + y, 64, add)
			} else if (rotation == 2) {
				addMask(repository, plane, x, y, 16, add)
				addMask(repository, plane, x + 1, -1 + y, 1, add)
			} else if (rotation == 3) {
				addMask(repository, plane, x, y, 64, add)
				addMask(repository, plane, x - 1, -1 + y, 4, add)
			}
		} else if (type == 2) {
			if (rotation == 0) {
				addMask(repository, plane, x, y, 130, add)
				addMask(repository, plane, -1 + x, y, 8, add)
				addMask(repository, plane, x, y + 1, 32, add)
			} else if (rotation == 1) {
				addMask(repository, plane, x, y, 10, add)
				addMask(repository, plane, x, 1 + y, 32, add)
				addMask(repository, plane, 1 + x, y, 128, add)
			} else if (rotation == 2) {
				addMask(repository, plane, x, y, 40, add)
				addMask(repository, plane, 1 + x, y, 128, add)
				addMask(repository, plane, x, -1 + y, 2, add)
			} else if (rotation == 3) {
				addMask(repository, plane, x, y, 160, add)
				addMask(repository, plane, x, -1 + y, 2, add)
				addMask(repository, plane, -1 + x, y, 8, add)
			}
		}
		if (solid) {
			if (type == 0) {
				if (rotation == 0) {
					addMask(repository, plane, x, y, 0x10000, add)
					addMask(repository, plane, x - 1, y, 4096, add)
				} else if (rotation == 1) {
					addMask(repository, plane, x, y, 1024, add)
					addMask(repository, plane, x, 1 + y, 16384, add)
				} else if (rotation == 2) {
					addMask(repository, plane, x, y, 4096, add)
					addMask(repository, plane, x + 1, y, 0x10000, add)
				} else if (rotation == 3) {
					addMask(repository, plane, x, y, 16384, add)
					addMask(repository, plane, x, -1 + y, 1024, add)
				}
			} else if (type == 1 || type == 3) {
				if (rotation == 0) {
					addMask(repository, plane, x, y, 512, add)
					addMask(repository, plane, x - 1, y + 1, 8192, add)
				} else if (rotation == 1) {
					addMask(repository, plane, x, y, 2048, add)
					addMask(repository, plane, x + 1, 1 + y, 32768, add)
				} else if (rotation == 2) {
					addMask(repository, plane, x, y, 8192, add)
					addMask(repository, plane, x + 1, y - 1, 512, add)
				} else if (rotation == 3) {
					addMask(repository, plane, x, y, 32768, add)
					addMask(repository, plane, x - 1, -1 + y, 2048, add)
				}
			} else if (type == 2) {
				if (rotation == 0) {
					addMask(repository, plane, x, y, 0x10400, add)
					addMask(repository, plane, -1 + x, y, 4096, add)
					addMask(repository, plane, x, y + 1, 16384, add)
				} else if (rotation == 1) {
					addMask(repository, plane, x, y, 5120, add)
					addMask(repository, plane, x, y + 1, 16384, add)
					addMask(repository, plane, 1 + x, y, 0x10000, add)
				} else if (rotation == 2) {
					addMask(repository, plane, x, y, 20480, add)
					addMask(repository, plane, x + 1, y, 0x10000, add)
					addMask(repository, plane, x, y - 1, 1024, add)
				} else if (rotation == 3) {
					addMask(repository, plane, x, y, 0x14000, add)
					addMask(repository, plane, x, -1 + y, 1024, add)
					addMask(repository, plane, x - 1, y, 4096, add)
				}
			}
		}
		if (notAlternative) {
			if (type == 0) {
				if (rotation == 0) {
					addMask(repository, plane, x, y, 0x20000000, add)
					addMask(repository, plane, x - 1, y, 0x2000000, add)
				} else if (rotation == 1) {
					addMask(repository, plane, x, y, 0x800000, add)
					addMask(repository, plane, x, y + 1, 0x8000000, add)
				} else if (rotation == 2) {
					addMask(repository, plane, x, y, 0x2000000, add)
					addMask(repository, plane, x + 1, y, 0x20000000, add)
				} else if (rotation == 3) {
					addMask(repository, plane, x, y, 0x8000000, add)
					addMask(repository, plane, x, y - 1, 0x800000, add)
				}
			} else if (type == 1 || type == 3) {
				if (rotation == 0) {
					addMask(repository, plane, x, y, 0x400000, add)
					addMask(repository, plane, x - 1, y + 1, 0x4000000, add)
				} else if (rotation == 1) {
					addMask(repository, plane, x, y, 0x1000000, add)
					addMask(repository, plane, 1 + x, 1 + y, 0x10000000, add)
				} else if (rotation == 2) {
					addMask(repository, plane, x, y, 0x4000000, add)
					addMask(repository, plane, x + 1, -1 + y, 0x400000, add)
				} else if (rotation == 3) {
					addMask(repository, plane, x, y, 0x10000000, add)
					addMask(repository, plane, -1 + x, y - 1, 0x1000000, add)
				}
			} else if (type == 2) {
				if (rotation == 0) {
					addMask(repository, plane, x, y, 0x20800000, add)
					addMask(repository, plane, -1 + x, y, 0x2000000, add)
					addMask(repository, plane, x, 1 + y, 0x8000000, add)
				} else if (rotation == 1) {
					addMask(repository, plane, x, y, 0x2800000, add)
					addMask(repository, plane, x, 1 + y, 0x8000000, add)
					addMask(repository, plane, x + 1, y, 0x20000000, add)
				} else if (rotation == 2) {
					addMask(repository, plane, x, y, 0xa000000, add)
					addMask(repository, plane, 1 + x, y, 0x20000000, add)
					addMask(repository, plane, x, y - 1, 0x800000, add)
				} else if (rotation == 3) {
					addMask(repository, plane, x, y, 0x28000000, add)
					addMask(repository, plane, x, y - 1, 0x800000, add)
					addMask(repository, plane, -1 + x, y, 0x2000000, add)
				}
			}
		}
	}
	
	fun removeWall(repository: DefinitionRepository, plane: Int, x: Int, y: Int, type: Int, rotation: Int, solid: Boolean, notAlternative: Boolean) {
		if (type == 0) {
			if (rotation == 0) {
				removeMask(plane, x, y, 128)
				removeMask(plane, x - 1, y, 8)
			}
			if (rotation == 1) {
				removeMask(plane, x, y, 2)
				removeMask(plane, x, 1 + y, 32)
			}
			if (rotation == 2) {
				removeMask(plane, x, y, 8)
				removeMask(plane, 1 + x, y, 128)
			}
			if (rotation == 3) {
				removeMask(plane, x, y, 32)
				removeMask(plane, x, -1 + y, 2)
			}
		}
		if (type == 1 || type == 3) {
			if (rotation == 0) {
				removeMask(plane, x, y, 1)
				removeMask(plane, -1 + x, 1 + y, 16)
			}
			if (rotation == 1) {
				removeMask(plane, x, y, 4)
				removeMask(plane, 1 + x, 1 + y, 64)
			}
			if (rotation == 2) {
				removeMask(plane, x, y, 16)
				removeMask(plane, x + 1, -1 + y, 1)
			}
			if (rotation == 3) {
				removeMask(plane, x, y, 64)
				removeMask(plane, x - 1, -1 + y, 4)
			}
		}
		if (type == 2) {
			if (rotation == 0) {
				addMask(repository, plane, x, y, 130, true)
				removeMask(plane, -1 + x, y, 8)
				removeMask(plane, x, y + 1, 32)
			}
			if (rotation == 1) {
				removeMask(plane, x, y, 10)
				removeMask(plane, x, 1 + y, 32)
				removeMask(plane, 1 + x, y, 128)
			}
			if (rotation == 2) {
				removeMask(plane, x, y, 40)
				removeMask(plane, 1 + x, y, 128)
				removeMask(plane, x, -1 + y, 2)
			}
			if (rotation == 3) {
				removeMask(plane, x, y, 160)
				removeMask(plane, x, -1 + y, 2)
				removeMask(plane, -1 + x, y, 8)
			}
		}
		if (solid) {
			if (type == 0) {
				if (rotation == 0) {
					removeMask(plane, x, y, 0x10000)
					removeMask(plane, x - 1, y, 4096)
				}
				if (rotation == 1) {
					removeMask(plane, x, y, 1024)
					removeMask(plane, x, 1 + y, 16384)
				}
				if (rotation == 2) {
					removeMask(plane, x, y, 4096)
					removeMask(plane, x + 1, y, 0x10000)
				}
				if (rotation == 3) {
					removeMask(plane, x, y, 16384)
					removeMask(plane, x, -1 + y, 1024)
				}
			}
			if (type == 1 || type == 3) {
				if (rotation == 0) {
					removeMask(plane, x, y, 512)
					removeMask(plane, x - 1, y + 1, 8192)
				}
				if (rotation == 1) {
					removeMask(plane, x, y, 2048)
					removeMask(plane, x + 1, 1 + y, 32768)
				}
				if (rotation == 2) {
					removeMask(plane, x, y, 8192)
					removeMask(plane, x + 1, y - 1, 512)
				}
				if (rotation == 3) {
					removeMask(plane, x, y, 32768)
					removeMask(plane, x - 1, -1 + y, 2048)
				}
			}
			if (type == 2) {
				if (rotation == 0) {
					removeMask(plane, x, y, 0x10400)
					removeMask(plane, -1 + x, y, 4096)
					removeMask(plane, x, y + 1, 16384)
				}
				if (rotation == 1) {
					removeMask(plane, x, y, 5120)
					removeMask(plane, x, y + 1, 16384)
					removeMask(plane, 1 + x, y, 0x10000)
				}
				if (rotation == 2) {
					removeMask(plane, x, y, 20480)
					removeMask(plane, x + 1, y, 0x10000)
					removeMask(plane, x, y - 1, 1024)
				}
				if (rotation == 3) {
					removeMask(plane, x, y, 0x14000)
					removeMask(plane, x, -1 + y, 1024)
					removeMask(plane, x - 1, y, 4096)
				}
			}
		}
		if (notAlternative) {
			if (type == 0) {
				if (rotation == 0) {
					removeMask(plane, x, y, 0x20000000)
					removeMask(plane, x - 1, y, 0x2000000)
				}
				if (rotation == 1) {
					removeMask(plane, x, y, 0x800000)
					removeMask(plane, x, y + 1, 0x8000000)
				}
				if (rotation == 2) {
					removeMask(plane, x, y, 0x2000000)
					removeMask(plane, x + 1, y, 0x20000000)
				}
				if (rotation == 3) {
					removeMask(plane, x, y, 0x8000000)
					removeMask(plane, x, y - 1, 0x800000)
				}
			}
			if (type == 1 || type == 3) {
				if (rotation == 0) {
					removeMask(plane, x, y, 0x400000)
					removeMask(plane, x - 1, y + 1, 0x4000000)
				}
				if (rotation == 1) {
					removeMask(plane, x, y, 0x1000000)
					removeMask(plane, 1 + x, 1 + y, 0x10000000)
				}
				if (rotation == 2) {
					removeMask(plane, x, y, 0x4000000)
					removeMask(plane, x + 1, -1 + y, 0x400000)
				}
				if (rotation == 3) {
					removeMask(plane, x, y, 0x10000000)
					removeMask(plane, -1 + x, y - 1, 0x1000000)
				}
			}
			if (type == 2) {
				if (rotation == 0) {
					removeMask(plane, x, y, 0x20800000)
					removeMask(plane, -1 + x, y, 0x2000000)
					removeMask(plane, x, 1 + y, 0x8000000)
				}
				if (rotation == 1) {
					removeMask(plane, x, y, 0x2800000)
					removeMask(plane, x, 1 + y, 0x8000000)
					removeMask(plane, x + 1, y, 0x20000000)
				}
				if (rotation == 2) {
					removeMask(plane, x, y, 0xa000000)
					removeMask(plane, 1 + x, y, 0x20000000)
					removeMask(plane, x, y - 1, 0x800000)
				}
				if (rotation == 3) {
					removeMask(plane, x, y, 0x28000000)
					removeMask(plane, x, y - 1, 0x800000)
					removeMask(plane, -1 + x, y, 0x2000000)
				}
			}
		}
	}
	
	fun setMask(plane: Int, x: Int, y: Int, mask: Int) {
		if (x >= 0 && x < 64 && y >= 0 && y < 64)
			masks[plane][x][y] = mask
	}
	/*public void addMask(int plane, int x, int y, int mask) {
		  if (x >= 0 && x < 64 && y >= 0 && y < 64)
			  masks[plane][x][y] |= mask;
		  else {
			  System.out.println("We had " + x + " and " + y + "...");
			  Region targ = World.getRegionAbs(rx * 64 + x, ry * 64 + y);
			  if (targ != null) {
				  int newx = (rx * 64 + x) - targ.absX;
				  int newy = (ry * 64 + y) - targ.absY;
				  System.out.println("The new locals are " + newx + " and " + newy);
				  targ.clipmap[plane][newx][newy] |= mask;
			  }
		  }
	  }*/
	
	fun addMask(repository: DefinitionRepository, plane: Int, x: Int, y: Int, mask: Int, add: Boolean) {
		if (x >= 64 || y >= 64 || x < 0 || y < 0) {
			val target = Tile(rx * 64 + x, rz * 64 + y)
			val mapDefinition = repository.get(MapDefinition::class.java, target.region())
			if (mapDefinition != null) {
				val newx = (rx * 64 + x) and 0x3f
				val newz = (rz * 64 + y) and 0x3f
				if (add) {
					mapDefinition.masks[plane][newx][newz] = mapDefinition.masks[plane][newx][newz] or mask
				} else
					mapDefinition.masks[plane][newx][newz] = mapDefinition.masks[plane][newx][newz] and (mask.inv())
			}
			return
		}
		if (add)
			masks[plane][x][y] = masks[plane][x][y] or mask
		else {
			masks[plane][x][y] = masks[plane][x][y] and (mask.inv())
		}
	}
	
	fun removeMask(plane: Int, x: Int, y: Int, mask: Int) {
		if (x >= 0 && x < 64 && y >= 0 && y < 64)
			masks[plane][x][y] = masks[plane][x][y] and (mask.inv())
	}
	
	private fun readCompact(buffer: ByteBuffer): Int {
		val i_36_ = buffer.get(buffer.position()).toInt() and 0xFF
		if (i_36_ < 128) {
			return buffer.get().toInt() and 0xFF
		}
		return (buffer.short.toInt() and 0xFFFF) - 32768
	}
}