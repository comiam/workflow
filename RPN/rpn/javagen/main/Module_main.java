// HASH COLLISIONS: YES
// timestamp: 1.602565979E12

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
		return runtime.m_runtime.f_println(runtime.m_syntax_tree.f_ar2s(runtime.m_simplifier.f_simplifyTree(runtime.m_syntax_tree.f_s2ar(l0_alg))));
	}
}
