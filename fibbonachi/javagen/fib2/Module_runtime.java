// HASH COLLISIONS: YES
// timestamp: 1.599535537E12

package fib2;

import com.area9innovation.flow.*;

@SuppressWarnings("unchecked")
final class Module_runtime {
	final fib2 runtime;
	Module_runtime(fib2 runtime) {
		this.runtime = runtime;
	}
	public Reference<Boolean> g_localStorageEnabled;
	public void init_localStorageEnabled() {
		g_localStorageEnabled=((Reference<Boolean>)(new Reference(true)));
	}
	Object f_println(Object astr) {
		if (runtime.m_securitymode.f_isLoggingEnabled()) {
			return runtime.h_Native.println(((Object)astr));
		} else {
			return null;
		}
	}
}
