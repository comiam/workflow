// HASH COLLISIONS: YES
// timestamp: 1.60252509E12

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
		final String l1_var = runtime.m_string.f_trim(runtime.m_string.f_rtrim2(runtime.h_Native.readUntil("\n"), "\n"));
		return runtime.m_runtime.f_println(runtime.m_syntax_tree.f_ar2s(runtime.m_derivative.f_ar2diff(runtime.m_syntax_tree.f_s2ar(l0_alg), l1_var)));
	}
}
