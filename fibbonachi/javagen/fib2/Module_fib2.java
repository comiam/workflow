// HASH COLLISIONS: YES
// timestamp: 1.599559492E12

package fib2;

import com.area9innovation.flow.*;

@SuppressWarnings("unchecked")
final class Module_fib2 {
	final fib2 runtime;
	Module_fib2(fib2 runtime) {
		this.runtime = runtime;
	}
	Object[] f_fib(int ak) {
		if ((ak==1)) {
			return (new Object[] { 1 });
		} else {
			if ((ak==2)) {
				return (new Object[] { 1, 1 });
			} else {
				final Object[] l0_x = f_fib((ak-1));
				return runtime.h_Native.concat(l0_x, (new Object[] { (((int)(l0_x[(ak-2)]))+((int)(l0_x[(ak-3)]))) }));
			}
		}
	}
	Object f_main() {
		return runtime.m_runtime.f_println(f_fib(10));
	}
}
