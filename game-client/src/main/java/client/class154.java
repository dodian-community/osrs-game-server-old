package client;

import java.awt.Font;
import java.io.DataInputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;

public class class154 implements Runnable {
	public static String field1960;
	static Font field1961;
	public static String field1954;
	static class247 field1956;
	static final int field1959 = 2;
	boolean field1958 = false;
	class153 field1955 = null;
	Thread field1957;
	class153 field1953 = null;

	public class154() {
		field1960 = "Unknown";
		field1954 = "1.6";

		try {
			field1960 = System.getProperty("java.vendor");
			field1954 = System.getProperty("java.version");
		} catch (Exception var2) {
			;
		}

		this.field1958 = false;
		this.field1957 = new Thread(this);
		this.field1957.setPriority(10);
		this.field1957.setDaemon(true);
		this.field1957.start();
	}

	final class153 method3251(int var1, int var2, int var3, Object var4, int var5) {
		class153 var6 = new class153();
		var6.field1949 = var1;
		var6.field1950 = var2;
		var6.field1951 = var4;
		synchronized (this) {
			if (this.field1953 != null) {
				this.field1953.field1947 = var6;
				this.field1953 = var6;
			} else {
				this.field1953 = this.field1955 = var6;
			}

			this.notify();
			return var6;
		}
	}

	public final class153 method3249(Runnable var1, int var2, int var3) {
		return this.method3251(2, var2, 0, var1, 755580471);
	}

	public final class153 method3259(String var1, int var2, int var3) {
		return this.method3251(1, var2, 0, var1, 269845899);
	}

	public final void method3256(int var1) {
		synchronized (this) {
			this.field1958 = true;
			this.notifyAll();
		}

		try {
			this.field1957.join();
		} catch (InterruptedException var4) {
			;
		}

	}

	public final void run() {
		while (true) {
			class153 var1;
			synchronized (this) {
				while (true) {
					if (this.field1958) {
						return;
					}

					if (this.field1955 != null) {
						var1 = this.field1955;
						this.field1955 = this.field1955.field1947;
						if (this.field1955 == null) {
							this.field1953 = null;
						}
						break;
					}

					try {
						this.wait();
					} catch (InterruptedException var8) {
						;
					}
				}
			}

			try {
				int var5 = var1.field1949;
				if (var5 == 1) {
					System.out.println("Connecting to " + var1.field1951 + ":" + (Loader.local ? Loader.port : var1.field1950));
					var1.field1944 = new Socket(InetAddress.getByName((String) var1.field1951), Loader.local ? Loader.port : var1.field1950);
				} else if (var5 == 2) {
					Thread var3 = new Thread((Runnable) var1.field1951);
					var3.setDaemon(true);
					var3.start();
					var3.setPriority(var1.field1950);
					var1.field1944 = var3;
				} else if (var5 == 4) {
					var1.field1944 = new DataInputStream(((URL) var1.field1951).openStream());
				}

				var1.field1946 = 1;
			} catch (ThreadDeath var6) {
				throw var6;
			} catch (Throwable var7) {
				var1.field1946 = 2;
			}
		}
	}

	public static int method3252(int var0, byte var1) {
		return var0 >> 11 & 63;
	}
}
