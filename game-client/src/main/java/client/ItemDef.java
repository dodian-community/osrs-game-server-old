package client;

public class ItemDef extends class206 {

	static class200 field3461 = new class200(64);
	public static class247 field3454;
	static class200 field3428 = new class200(50);
	public static class247 field3424;
	public static class200 field3429 = new class200(200);
	public static boolean field3426;
	public static class298 field3466;
	static int field3478;
	public static final int field3421 = 2;
	static final int field3430 = -1;
	static final int field3458 = -2;
	public static final int field3470 = 1;
	int maleHeadModel = -1;
	int maleModel0 = -1;
	int inventoryModel;
	int[] countObj;
	int int621 = -2;
	class197 iterableImpl1_3;
	int maleHeadModel2 = -1;
	int maleModel1 = -1;
	int maleModel2 = -1;
	public String[] interfaceOptions = new String[]{null, null, null, null, "Drop"};
	public String name = "null";
	int femaleHeadModel = -1;
	public int zoom2d = 2000;
	public int field3431;
	int femaleHeadModel2 = -1;
	int femaleModel0 = -1;
	int[] countCo;
	int femaleModel1 = -1;
	int femaleModel2 = -1;
	public int xan2d = 0;
	int int634 = 128;
	public int yan2d = 0;
	public int xof2d = 0;
	public int stackable = 0;
	int int635 = 128;
	public int yof2d = 0;
	public int zan2d = 0;
	public int cost = 1;
	int int636 = 128;
	public boolean members = false;
	short[] colorFind;
	short[] textureFind;
	int maleOffset = 0;
	public int notedTemplate = -1;
	public String[] options = new String[]{null, null, "Take", null, null};
	short[] colorReplace;
	int femaleOffset = 0;
	short[] textureReplace;
	public int int637 = 0;
	public boolean bool67 = false;
	int op140 = -1;
	public int int609 = 0;
	public int notedID = -1;
	public int team = 0;
	public int int638 = -1;
	int int639 = -1;
	public int int641 = -1;

	public static ItemDef loadItemDef(int var0) {
		ItemDef var2 = (ItemDef) field3461.method3989((long) var0);
		if (var2 != null) {
			return var2;
		} else {
			byte[] var3 = field3424.method4625(10, var0, 1401189086);
			var2 = new ItemDef();
			var2.field3431 = var0;
			if (var3 != null) {
				var2.method5090(new Stream(var3), (byte) -69);
			}

			var2.method5087(750388690);
			if (var2.notedTemplate != -1) {
				var2.method5126(loadItemDef(var2.notedTemplate), loadItemDef(var2.notedID), (byte) -109);
			}

			if (var2.op140 != -1) {
				var2.method5110(loadItemDef(var2.op140), loadItemDef(var2.int639), (byte) 0);
			}

			if (var2.int638 != -1) {
				var2.method5091(loadItemDef(var2.int638), loadItemDef(var2.int641), (byte) 8);
			}

			Custom.Items.parseItemDef(var0, var2);

			if (!field3426 && var2.members) {
				var2.name = "Members object";
				var2.bool67 = false;
				var2.options = null;
				var2.interfaceOptions = null;
				var2.int621 = -1;
				var2.team = 0;
				if (var2.iterableImpl1_3 != null) {
					boolean var4 = false;

					for (class204 var5 = var2.iterableImpl1_3.method3955(); var5 != null; var5 = var2.iterableImpl1_3.method3947()) {
						class264 var6 = class241.method4603((int) var5.field2421, (short) -21845);
						if (var6.field3332) {
							var5.unlink();
						} else {
							var4 = true;
						}
					}

					if (!var4) {
						var2.iterableImpl1_3 = null;
					}
				}
			}

			field3461.method3983(var2, (long) var0);
			return var2;
		}
	}

	void readValue(Stream var1, int var2, byte var3) {
		if (var2 == 1) {
			this.inventoryModel = var1.readUShort();
		} else if (var2 == 2) {
			this.name = var1.readString();
		} else if (var2 == 4) {
			if (var3 >= 0) {
				return;
			}

			this.zoom2d = var1.readUShort();
		} else if (var2 == 5) {
			this.xan2d = var1.readUShort();
		} else if (var2 == 6) {
			this.yan2d = var1.readUShort();
		} else if (var2 == 7) {
			this.xof2d = var1.readUShort();
			if (this.xof2d > 32767) {
				this.xof2d -= 65536;
			}
		} else if (var2 == 8) {
			this.yof2d = var1.readUShort();
			if (this.yof2d > 32767) {
				if (var3 >= 0) {
					return;
				}

				this.yof2d -= 65536;
			}
		} else if (var2 == 11) {
			this.stackable = 1;
		} else if (var2 == 12) {
			this.cost = var1.readInt();
		} else if (var2 == 16) {
			if (var3 >= 0) {
				return;
			}

			this.members = true;
		} else if (var2 == 23) {
			if (var3 >= 0) {
				return;
			}

			this.maleModel0 = var1.readUShort();
			this.maleOffset = var1.readUByte();
		} else if (var2 == 24) {
			this.maleModel1 = var1.readUShort();
		} else if (var2 == 25) {
			this.femaleModel0 = var1.readUShort();
			this.femaleOffset = var1.readUByte();
		} else if (var2 == 26) {
			this.femaleModel1 = var1.readUShort();
		} else if (var2 >= 30 && var2 < 35) {
			this.options[var2 - 30] = var1.readString();
			if (this.options[var2 - 30].equalsIgnoreCase("Hidden")) {
				this.options[var2 - 30] = null;
			}
		} else {
			if (var2 >= 35) {
				if (var3 >= 0) {
					return;
				}

				if (var2 < 40) {
					this.interfaceOptions[var2 - 35] = var1.readString();
					return;
				}
			}

			int var4;
			int var5;
			if (var2 == 40) {
				var4 = var1.readUByte();
				this.colorFind = new short[var4];
				this.colorReplace = new short[var4];

				for (var5 = 0; var5 < var4; var5++) {
					this.colorFind[var5] = (short) var1.readUShort();
					this.colorReplace[var5] = (short) var1.readUShort();
				}
			} else if (var2 == 41) {
				var4 = var1.readUByte();
				this.textureFind = new short[var4];
				this.textureReplace = new short[var4];

				for (var5 = 0; var5 < var4; var5++) {

					this.textureFind[var5] = (short) var1.readUShort();
					this.textureReplace[var5] = (short) var1.readUShort();
				}
			} else if (var2 == 42) {
				this.int621 = var1.readByte();
			} else if (var2 == 65) {
				this.bool67 = true;
			} else if (var2 == 78) {
				this.maleModel2 = var1.readUShort();
			} else if (var2 == 79) {
				this.femaleModel2 = var1.readUShort();
			} else if (var2 == 90) {
				this.maleHeadModel = var1.readUShort();
			} else if (var2 == 91) {
				this.femaleHeadModel = var1.readUShort();
			} else if (var2 == 92) {
				this.maleHeadModel2 = var1.readUShort();
			} else if (var2 == 93) {
				this.femaleHeadModel2 = var1.readUShort();
			} else if (var2 == 95) {
				this.zan2d = var1.readUShort();
			} else if (var2 == 97) {
				this.notedID = var1.readUShort();
			} else if (var2 == 98) {
				this.notedTemplate = var1.readUShort();
			} else if (var2 >= 100 && var2 < 110) {
				if (this.countObj == null) {

					this.countObj = new int[10];
					this.countCo = new int[10];
				}

				this.countObj[var2 - 100] = var1.readUShort();
				this.countCo[var2 - 100] = var1.readUShort();
			} else if (var2 == 110) {
				this.int634 = var1.readUShort();
			} else if (var2 == 111) {
				this.int635 = var1.readUShort();
			} else if (var2 == 112) {
				this.int636 = var1.readUShort();
			} else if (var2 == 113) {
				this.int637 = var1.readByte();
			} else if (var2 == 114) {
				this.int609 = var1.readByte() * 5;
			} else if (var2 == 115) {
				this.team = var1.readUByte();
			} else if (var2 == 139) {
				this.int639 = var1.readUShort();
			} else if (var2 == 140) {
				this.op140 = var1.readUShort();
			} else if (var2 == 148) {
				this.int641 = var1.readUShort();
			} else if (var2 == 149) {
				this.int638 = var1.readUShort();
			} else if (var2 == 249) {
				this.iterableImpl1_3 = PacketBuilder.method691(var1, this.iterableImpl1_3);
			}
		}

	}

	public final class119 method5093(int var1, int var2) {
		if (this.countObj != null && var1 > 1) {
			int var3 = -1;

			for (int var4 = 0; var4 < 10; var4++) {
				if (var1 >= this.countCo[var4] && this.countCo[var4] != 0) {
					var3 = this.countObj[var4];
				}
			}

			if (var3 != -1) {
				return loadItemDef(var3).method5093(1, 1104596527);
			}
		}

		class119 var6 = (class119) field3428.method3989((long) this.field3431);
		if (var6 != null) {
			return var6;
		} else {
			class113 var7 = class113.method2568(field3454, this.inventoryModel, 0);
			if (var7 == null) {
				return null;
			} else {
				if (this.int634 != 128 || this.int635 != 128 || this.int636 != 128) {
					var7.method2592(this.int634, this.int635, this.int636);
				}

				int var5;
				if (this.colorFind != null) {
					for (var5 = 0; var5 < this.colorFind.length; var5++) {
						var7.method2581(this.colorFind[var5], this.colorReplace[var5]);
					}
				}

				if (this.textureFind != null) {
					for (var5 = 0; var5 < this.textureFind.length; var5++) {
						var7.method2582(this.textureFind[var5], this.textureReplace[var5]);
					}
				}

				var6 = var7.method2589(this.int637 + 64, this.int609 + 768, -50, -10, -50);
				var6.field1603 = true;
				field3428.method3983(var6, (long) this.field3431);
				return var6;
			}
		}
	}

	public final class113 method5092(int var1, byte var2) {
		int var4;
		if (this.countObj != null && var1 > 1) {
			int var3 = -1;

			for (var4 = 0; var4 < 10; var4++) {
				if (var1 >= this.countCo[var4] && this.countCo[var4] != 0) {
					var3 = this.countObj[var4];
				}
			}

			if (var3 != -1) {
				return loadItemDef(var3).method5092(1, (byte) 25);
			}
		}

		class113 var5 = class113.method2568(field3454, this.inventoryModel, 0);
		if (var5 == null) {
			return null;
		} else {
			if (this.int634 != 128 || this.int635 != 128 || this.int636 != 128) {
				var5.method2592(this.int634, this.int635, this.int636);
			}

			if (this.colorFind != null) {
				for (var4 = 0; var4 < this.colorFind.length; var4++) {
					var5.method2581(this.colorFind[var4], this.colorReplace[var4]);
				}
			}

			if (this.textureFind != null) {
				for (var4 = 0; var4 < this.textureFind.length; var4++) {
					var5.method2582(this.textureFind[var4], this.textureReplace[var4]);
				}
			}

			return var5;
		}
	}

	void method5087(int var1) {
	}

	public final boolean method5097(boolean var1, int var2) {
		int var3 = this.maleHeadModel;
		int var4 = this.maleHeadModel2;
		if (var1) {
			var3 = this.femaleHeadModel;
			var4 = this.femaleHeadModel2;
		}

		if (var3 == -1) {
			return true;
		} else {
			boolean var5 = true;
			if (!field3454.method4696(var3, 0, (byte) 1)) {
				var5 = false;
			}

			if (var4 != -1 && !field3454.method4696(var4, 0, (byte) 1)) {
				var5 = false;
			}

			return var5;
		}
	}

	public final class113 method5098(boolean var1, int var2) {
		int var3 = this.maleHeadModel;
		int var4 = this.maleHeadModel2;
		if (var1) {
			var3 = this.femaleHeadModel;
			var4 = this.femaleHeadModel2;
		}

		if (var3 == -1) {
			return null;
		} else {
			class113 var5 = class113.method2568(field3454, var3, 0);
			if (var4 != -1) {
				class113 var6 = class113.method2568(field3454, var4, 0);
				class113[] var7 = new class113[]{var5, var6};
				var5 = new class113(var7, 2);
			}

			int var8;
			if (this.colorFind != null) {
				for (var8 = 0; var8 < this.colorFind.length; var8++) {
					var5.method2581(this.colorFind[var8], this.colorReplace[var8]);
				}
			}

			if (this.textureFind != null) {
				for (var8 = 0; var8 < this.textureFind.length; var8++) {
					var5.method2582(this.textureFind[var8], this.textureReplace[var8]);
				}
			}

			return var5;
		}
	}

	void method5090(Stream var1, byte var2) {
		while (true) {
			int var3 = var1.readUByte();
			if (var3 == 0) {
				return;
			}

			this.readValue(var1, var3, (byte) -69);
		}
	}

	public final boolean method5095(boolean var1, int var2) {
		int var3 = this.maleModel0;
		int var4 = this.maleModel1;
		int var5 = this.maleModel2;
		if (var1) {
			var3 = this.femaleModel0;
			var4 = this.femaleModel1;
			var5 = this.femaleModel2;
		}

		if (var3 == -1) {
			return true;
		} else {
			boolean var6 = true;
			if (!field3454.method4696(var3, 0, (byte) 1)) {
				var6 = false;
			}

			if (var4 != -1 && !field3454.method4696(var4, 0, (byte) 1)) {
				var6 = false;
			}

			if (var5 != -1 && !field3454.method4696(var5, 0, (byte) 1)) {
				var6 = false;
			}

			return var6;
		}
	}

	public final class113 method5128(boolean var1, byte var2) {
		int var3 = this.maleModel0;
		int var4 = this.maleModel1;
		int var5 = this.maleModel2;
		if (var1) {
			var3 = this.femaleModel0;
			var4 = this.femaleModel1;
			var5 = this.femaleModel2;
		}

		if (var3 == -1) {
			return null;
		} else {
			class113 var6 = class113.method2568(field3454, var3, 0);
			if (var4 != -1) {
				class113 var7 = class113.method2568(field3454, var4, 0);
				if (var5 != -1) {
					class113 var8 = class113.method2568(field3454, var5, 0);
					class113[] var9 = new class113[]{var6, var7, var8};
					var6 = new class113(var9, 3);
				} else {
					class113[] var11 = new class113[]{var6, var7};
					var6 = new class113(var11, 2);
				}
			}

			if (!var1 && this.maleOffset != 0) {
				var6.method2580(0, this.maleOffset, 0);
			}

			if (var1 && this.femaleOffset != 0) {
				var6.method2580(0, this.femaleOffset, 0);
			}

			int var10;
			if (this.colorFind != null) {
				for (var10 = 0; var10 < this.colorFind.length; var10++) {
					var6.method2581(this.colorFind[var10], this.colorReplace[var10]);
				}
			}

			if (this.textureFind != null) {
				for (var10 = 0; var10 < this.textureFind.length; var10++) {
					var6.method2582(this.textureFind[var10], this.textureReplace[var10]);
				}
			}

			return var6;
		}
	}

	void method5126(ItemDef var1, ItemDef var2, byte var3) {
		this.inventoryModel = var1.inventoryModel;
		this.zoom2d = var1.zoom2d;
		this.xan2d = var1.xan2d;
		this.yan2d = var1.yan2d;
		this.zan2d = var1.zan2d;
		this.xof2d = var1.xof2d;
		this.yof2d = var1.yof2d;
		this.colorFind = var1.colorFind;
		this.colorReplace = var1.colorReplace;
		this.textureFind = var1.textureFind;
		this.textureReplace = var1.textureReplace;
		this.name = var2.name;
		this.members = var2.members;
		this.cost = var2.cost;
		this.stackable = 1;
	}

	void method5110(ItemDef var1, ItemDef var2, byte var3) {
		this.inventoryModel = var1.inventoryModel;
		this.zoom2d = var1.zoom2d;
		this.xan2d = var1.xan2d;
		this.yan2d = var1.yan2d;
		this.zan2d = var1.zan2d;
		this.xof2d = var1.xof2d;
		this.yof2d = var1.yof2d;
		this.colorFind = var2.colorFind;
		this.colorReplace = var2.colorReplace;
		this.textureFind = var2.textureFind;
		this.textureReplace = var2.textureReplace;
		this.name = var2.name;
		this.members = var2.members;
		this.stackable = var2.stackable;
		this.maleModel0 = var2.maleModel0;
		this.maleModel1 = var2.maleModel1;
		this.maleModel2 = var2.maleModel2;
		this.femaleModel0 = var2.femaleModel0;
		this.femaleModel1 = var2.femaleModel1;
		this.femaleModel2 = var2.femaleModel2;
		this.maleHeadModel = var2.maleHeadModel;
		this.maleHeadModel2 = var2.maleHeadModel2;
		this.femaleHeadModel = var2.femaleHeadModel;
		this.femaleHeadModel2 = var2.femaleHeadModel2;
		this.team = var2.team;
		this.options = var2.options;
		this.interfaceOptions = new String[5];
		if (var2.interfaceOptions != null) {
			for (int var4 = 0; var4 < 4; var4++) {
				if (var3 != 0) {
					return;
				}

				this.interfaceOptions[var4] = var2.interfaceOptions[var4];
			}
		}

		this.interfaceOptions[4] = "Discard";
		this.cost = 0;
	}

	void method5091(ItemDef var1, ItemDef var2, byte var3) {
		this.inventoryModel = var1.inventoryModel;
		this.zoom2d = var1.zoom2d;
		this.xan2d = var1.xan2d;
		this.yan2d = var1.yan2d;
		this.zan2d = var1.zan2d;
		this.xof2d = var1.xof2d;
		this.yof2d = var1.yof2d;
		this.colorFind = var1.colorFind;
		this.colorReplace = var1.colorReplace;
		this.textureFind = var1.textureFind;
		this.textureReplace = var1.textureReplace;
		this.stackable = var1.stackable;
		this.name = var2.name;
		this.cost = 0;
		this.members = false;
		this.bool67 = false;
	}

	public ItemDef method5094(int var1) {
		if (this.countObj != null && var1 > 1) {
			int var3 = -1;

			for (int var4 = 0; var4 < 10; var4++) {
				if (var1 >= this.countCo[var4] && this.countCo[var4] != 0) {
					var3 = this.countObj[var4];
				}
			}

			if (var3 != -1) {
				return loadItemDef(var3);
			}
		}

		return this;
	}

	public int method5101(int var1) {
		return this.int621 != -1 && this.interfaceOptions != null ? (this.int621 >= 0 ? (this.interfaceOptions[this.int621] != null ? this.int621 : -1) : ("Drop".equalsIgnoreCase(this.interfaceOptions[4]) ? 4 : -1)) : -1;
	}

	public int method5099(int var1, int var2, int var3) {
		return class67.method1668(this.iterableImpl1_3, var1, var2, (short) 12570);
	}

	public String method5121(int var1, String var2, int var3) {
		return class17.method171(this.iterableImpl1_3, var1, var2, (short) 255);
	}
}
