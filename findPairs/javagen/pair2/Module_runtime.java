// HASH COLLISIONS: YES
// timestamp: 1.599535537E12

package pair2;

import com.area9innovation.flow.*;

@SuppressWarnings("unchecked")
final class Module_runtime {
	final pair2 runtime;
	Module_runtime(pair2 runtime) {
		this.runtime = runtime;
	}
	public Reference<Boolean> g_localStorageEnabled;
	Object nf_max(Object aa, Object ab) {
		if ((FlowRuntime.compareByValue(aa,ab)>0)) {
			return aa;
		} else {
			return ab;
		}
	}
	public void init_localStorageEnabled() {
		g_localStorageEnabled=((Reference<Boolean>)(new Reference(true)));
	}
	Object f_max(Object aa, Object ab) {
		if ((FlowRuntime.compareByValue(aa,ab)>0)) {
			return aa;
		} else {
			return ab;
		}
	}
	Object f_println(Object astr) {
		if (runtime.m_securitymode.f_isLoggingEnabled()) {
			return runtime.h_Native.println(((Object)astr));
		} else {
			return null;
		}
	}
}
