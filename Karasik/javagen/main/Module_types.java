// HASH COLLISIONS: YES
// timestamp: 1.608561838E12

package main;

import com.area9innovation.flow.*;

@SuppressWarnings("unchecked")
final class Module_types {
	final main runtime;
	Module_types(main runtime) {
		this.runtime = runtime;
	}
	Struct_Test f_invertTest(Struct_Test at) {
		if ((at.f_test).equals("==")) {
			return (new Struct_Test("!=", at.f_f, at.f_s));
		} else {
			if ((at.f_test).equals("<=")) {
				return (new Struct_Test(">", at.f_f, at.f_s));
			} else {
				if ((at.f_test).equals(">=")) {
					return (new Struct_Test("<", at.f_f, at.f_s));
				} else {
					if ((at.f_test).equals("!=")) {
						return (new Struct_Test("==", at.f_f, at.f_s));
					} else {
						if ((at.f_test).equals(">")) {
							return (new Struct_Test("<=", at.f_f, at.f_s));
						} else {
							if ((at.f_test).equals("<")) {
								return (new Struct_Test(">=", at.f_f, at.f_s));
							} else {
								runtime.m_runtime.f_println((("Unknown test: "+at.f_test)+" !"));
								return at;
							}
						}
					}
				}
			}
		}
	}
}
