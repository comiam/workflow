// HASH COLLISIONS: YES
// timestamp: 1.599558099E12

package fib;

import com.area9innovation.flow.*;

@SuppressWarnings("unchecked")
final class Module_fib {
	final fib runtime;
	Module_fib(fib runtime) {
		this.runtime = runtime;
	}
	int f_fib(int ak) {
		if ((ak<=2)) {
			return 1;
		} else {
			return (f_fib((ak-1))+f_fib((ak-2)));
		}
	}
	Object[] f_fibArr(int ak) {
		return runtime.h_Native.map(runtime.h_Native.enumFromTo(1, ak), ((Func1<Object,Object>)(Func1)runtime.gfw_fib));
	}
	Object f_main() {
		return runtime.m_runtime.f_println(f_fibArr(10));
	}
}
