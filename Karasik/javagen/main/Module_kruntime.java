// HASH COLLISIONS: YES
// timestamp: 1.605434069E12

package main;

import com.area9innovation.flow.*;

@SuppressWarnings("unchecked")
final class Module_kruntime {
	final main runtime;
	Module_kruntime(main runtime) {
		this.runtime = runtime;
	}
	int f_execProg(Struct_ProgramSequence aps) {
		final Struct_Pair l0_res = runtime.m_validator.f_checkStructure(aps);
		if (!((boolean)l0_res.f_first)) {
			runtime.m_runtime.f_println(l0_res.f_second);
			return runtime.m_error_codes.g_FALL_RUNTIME;
		} else {
			return runtime.m_error_codes.g_SUCCESS_EXECUTE;
		}
	}
	int f_parceAndExecProg(String aps) {
		return f_execProg(runtime.m_gram_engine.f_s2pseq(aps));
	}
}
