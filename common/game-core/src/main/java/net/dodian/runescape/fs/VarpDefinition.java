package net.dodian.runescape.fs;

import io.netty.buffer.Unpooled;
import net.dodian.runescape.io.RSBuffer;

/**
 * Created by Jak on 03/08/2016.
 */
public class VarpDefinition implements Definition { // def16 is varp definitionfileData(12
	
	public int configType = 0;
	
	void method2845(RSBuffer var1) {
		while (true) {
			int var3 = var1.readByte();
			if (var3 == 0) {
			    /*if (var2 == 8) { // dummy from 119 bart deob
                    return;
                }*/
				
				return;
			}
			
			this.method2846(var1, var3);
		}
	}
	
	void method2846(RSBuffer var1, int var2) {
		if (var2 == 5) {
			this.configType = var1.readShort();
		}
	}
	
	public int id;
	
	public VarpDefinition(int id, byte[] data) {
		this.id = id;
		
		if (data != null && data.length > 0)
			method2845(new RSBuffer(Unpooled.wrappedBuffer(data)));
	}
}
