// HASH COLLISIONS: YES
// timestamp: 1.599535537E12

package fib2;

import com.area9innovation.flow.*;

@SuppressWarnings("unchecked")
final class Module_flowstructs {
	final fib2 runtime;
	Module_flowstructs(fib2 runtime) {
		this.runtime = runtime;
	}
	Object f_extractStruct(Object[] aa, Object ae) {
		final Func2<Object,Object, Object> l1_$0 = new Func2<Object,Object,Object>() {
			final public Object invoke(final Object aacc, final Object ael) {
				if (runtime.h_Native.isSameStructType(aacc, ael)) {
					final Object l0_t = ((Object)runtime.m_dynamic.f_flow(ael));
					return l0_t;
				} else {
					return aacc;
				}
			}
		};
		return runtime.h_Native.fold(aa, ae, l1_$0);
	}
}
