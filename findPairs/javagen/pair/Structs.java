// HASH COLLISIONS: YES
// timestamp: 1.60015230215E12

package pair;

import com.area9innovation.flow.*;

@SuppressWarnings("unchecked")
public final class Structs {

	// Structs array
	static final private Struct[] struct_list = {
			new Struct_Cons(),
			SingletonStructs.str_EmptyList,
			SingletonStructs.str_IllegalStruct,
			new Struct_KeyValue(),
			SingletonStructs.str_None,
			new Struct_OWASP(),
			new Struct_Pair(),
			new Struct_Quadruple(),
			new Struct_Some(),
			new Struct_Triple()
	};
	static final Struct[] structList() {
		return struct_list;
	}
}
