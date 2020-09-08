// HASH COLLISIONS: YES
// timestamp: 1.599562066E12

package fib4;

import com.area9innovation.flow.*;

@SuppressWarnings("unchecked")
final class Module_fib4 {
	final fib4 runtime;
	Module_fib4(fib4 runtime) {
		this.runtime = runtime;
	}
	Reference<Object[]> f_fib(int ak, Reference<Object[]> aacc) {
	 TAIL_CALL: for(;;) {
		final int l0_len = runtime.h_Native.length(aacc.value);
		if ((l0_len<ak)) {
			if ((l0_len<2)) {
				runtime.m_array.f_refArrayPush(aacc, 1);
			} else {
				runtime.m_array.f_refArrayPush(aacc, (((int)(aacc.value[(l0_len-1)]))+((int)(aacc.value[(l0_len-2)]))));
			}
			{
				continue TAIL_CALL;
			}
		} else {
			return aacc;
		}
	 }
	}
	Object f_main() {
		return runtime.m_runtime.f_println(f_fib(10, ((Reference<Object[]>)(new Reference(SingletonStructs.arr_empty)))).value);
	}
}
