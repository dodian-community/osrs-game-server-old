package io.nozemi.runescape.util.map;

import nl.bartpelle.dawnguard.DataStore;
import io.nozemi.runescape.fs.DefinitionRepository;
import io.nozemi.runescape.fs.ObjectDefinition;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.stream.Stream;

/**
 * Created by Jak on 17/10/2016.
 */
public class FindGangplanks {
	
	public static void main(String[] args) throws IOException {
		
		DataStore ds = new DataStore("data/filestore");
		//DefinitionRepository repo = new DefinitionRepository(ds, true);
		
		// This poor method is O(n2).. :(
		
		// Find the doors we should resolve
		DataOutputStream dos = new DataOutputStream(new FileOutputStream("data/map/gangplankIds.bin"));
		/*for (int id = 0; id < repo.total(ObjectDefinition.class); id++) {
			ObjectDefinition def = repo.get(ObjectDefinition.class, id);
			if (def != null && def.name.equals("Gangplank")) {
				boolean hasOp = Stream.of(def.options).anyMatch("Cross"::equals);
				if (hasOp) {
					dos.writeInt(id);
					System.out.println("Found: " + def);
				}
			}
		}*/
		dos.close();
	}
}
