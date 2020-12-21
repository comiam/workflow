// HASH COLLISIONS: YES
// timestamp: 1.608575716E12

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
		final Struct_ProgramSequence l1_prog = runtime.m_gram_engine.f_s2pseq(l0_alg);
		runtime.m_runtime.f_println("VC AC");
		runtime.m_runtime.f_println(runtime.m_formule_compiler.f_formulesToStr(runtime.m_formule_compiler.f_getACVCConditions(l1_prog)));
		runtime.m_runtime.f_println("\nZ3 code");
		return runtime.m_runtime.f_println(runtime.m_formule_compiler.f_generateZ3(l1_prog));
	}
}
