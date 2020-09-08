// HASH COLLISIONS: YES
// timestamp: 1.599561381E12

package fib3;

import com.area9innovation.flow.*;

@SuppressWarnings("unchecked")
final class Module_fib3 {
	final fib3 runtime;
	Module_fib3(fib3 runtime) {
		this.runtime = runtime;
	}
	Object[] f_fib(int ak, Object[] aacc) {
	 TAIL_CALL: for(;;) {
		final int l0_len = runtime.h_Native.length(aacc);
		if ((l0_len<ak)) {
			if ((l0_len<2)) {
				{
					final Object[] l1___tmp = runtime.h_Native.concat(aacc, (new Object[] { 1 }));
					aacc = l1___tmp;
					continue TAIL_CALL;
				}
			} else {
				{
					final Object[] l2___tmp = runtime.h_Native.concat(aacc, (new Object[] { (((int)(aacc[(l0_len-1)]))+((int)(aacc[(l0_len-2)]))) }));
					aacc = l2___tmp;
					continue TAIL_CALL;
				}
			}
		} else {
			return aacc;
		}
	 }
	}
	Object f_main() {
		return runtime.m_runtime.f_println(f_fib(10, SingletonStructs.arr_empty));
	}
}
