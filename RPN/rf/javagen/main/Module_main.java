// HASH COLLISIONS: YES
// timestamp: 1.603167925E12

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
		runtime.m_runtime.f_println(runtime.m_ratfun.f_rf2s(runtime.m_ratfun.f_alg2rf(runtime.m_syntax_tree.f_s2alg(l0_alg))));
		return runtime.m_runtime.f_println(runtime.m_syntax_tree.f_alg2s(runtime.m_ratfun.f_rf2alg(runtime.m_ratfun.f_alg2rf(runtime.m_syntax_tree.f_s2alg(l0_alg)))));
	}
}
