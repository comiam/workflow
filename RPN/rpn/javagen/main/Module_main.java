// HASH COLLISIONS: YES
// timestamp: 1.601363109E12

package main;

import com.area9innovation.flow.*;

@SuppressWarnings("unchecked")
final class Module_main {
	final main runtime;
	Module_main(main runtime) {
		this.runtime = runtime;
	}
	Object f_main() {
		final String l0_alg = runtime.h_Native.readUntil("\n");
		final String l1_vars = runtime.h_Native.readUntil("\n");
		return runtime.m_runtime.f_println(runtime.m_alg.f_calcVarRpn(runtime.m_rpn.f_s2rpn(l0_alg), runtime.m_var_parse.f_s2vars(l1_vars)));
	}
}
