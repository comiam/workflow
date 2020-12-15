// HASH COLLISIONS: YES
// timestamp: 1.608010837E12

package main;

import com.area9innovation.flow.*;

@SuppressWarnings("unchecked")
final class Module_main {
	final main runtime;
	Module_main(main runtime) {
		this.runtime = runtime;
	}
	Object f_main() {
		final String l0_alg = runtime.n_strReplace.invoke(runtime.h_Native.readUntil("---"), "---", "");
		final Struct l1_prog = runtime.m_vmcompiler.f_compile(runtime.m_gram_engine.f_s2pseq(l0_alg));
		runtime.m_vmcompiler.f_printVM(l1_prog);
		final int l2_a = runtime.m_vmruntime.f_execVM(l1_prog);
		return null;
	}
}
