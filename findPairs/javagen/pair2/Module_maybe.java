// HASH COLLISIONS: YES
// timestamp: 1.599535537E12

package pair2;

import com.area9innovation.flow.*;

@SuppressWarnings("unchecked")
final class Module_maybe {
	final pair2 runtime;
	Module_maybe(pair2 runtime) {
		this.runtime = runtime;
	}
	boolean f_isSome(Struct am) {
		Struct l0__tmp = am;
		switch (l0__tmp.getTypeId()) {
		case 5/*None*/: {
			return false;
		}
		case 12/*Some*/: {
			final Struct_Some l1__tmp = (Struct_Some)l0__tmp;
			final Object l2___ = l1__tmp.f_value;
			return true;
		}
		default:
			throw new RuntimeException("Unexpected struct in switch: "+l0__tmp.getTypeName());
		}
	}
}
