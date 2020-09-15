// HASH COLLISIONS: YES
// timestamp: 1.599535537E12

package pair2;

import com.area9innovation.flow.*;

@SuppressWarnings("unchecked")
final class Module_array {
	final pair2 runtime;
	Module_array(pair2 runtime) {
		this.runtime = runtime;
	}
	Object[] f_concat3(Object[] aa1, Object[] aa2, Object[] aa3) {
		if ((runtime.h_Native.length(aa1)<runtime.h_Native.length(aa3))) {
			return runtime.h_Native.concat(runtime.h_Native.concat(aa1, aa2), aa3);
		} else {
			return runtime.h_Native.concat(aa1, runtime.h_Native.concat(aa2, aa3));
		}
	}
}
