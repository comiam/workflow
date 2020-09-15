// HASH COLLISIONS: YES
// timestamp: 1.600152621684E12

package pair2;

import com.area9innovation.flow.*;

@SuppressWarnings("unchecked")
public final class Structs {

	// Structs array
	static final private Struct[] struct_list = {
			new Struct_Cons(),
			SingletonStructs.str_EmptyList,
			SingletonStructs.str_EmptyPopResult,
			SingletonStructs.str_IllegalStruct,
			new Struct_KeyValue(),
			SingletonStructs.str_None,
			new Struct_OWASP(),
			new Struct_Pair(),
			new Struct_PopResult(),
			new Struct_PopSetResult(),
			new Struct_Quadruple(),
			new Struct_Set(),
			new Struct_Some(),
			SingletonStructs.str_TreeEmpty,
			new Struct_TreeNode(),
			new Struct_Triple()
	};
	static final Struct[] structList() {
		return struct_list;
	}
}
