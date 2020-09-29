// HASH COLLISIONS: YES
// timestamp: 1.601360275E12

package main;

import com.area9innovation.flow.*;

@SuppressWarnings("unchecked")
final class Module_syntax_tree {
	final main runtime;
	Module_syntax_tree(main runtime) {
		this.runtime = runtime;
	}
	Struct f_s2ar(String as) {
		final String l0_gram = "S = plus | mult | int | var;\nws = (\" \" | \"\\t\" | \"\\n\" | \"\\r\")*;\n\nplus = ws \"(\" ws S:l ws \"+\" ws S:r ws \")\" ws {ArSum(:l,:r)};\nmult = ws \"(\" ws S:l ws \"*\" ws S:r ws \")\" ws {ArMult(:l,:r)};\n\nint = ws digit+$s ws {ArInt(s2i($s))};\nvar = ws word$s ws {ArVar($s)};\n\ndigit = '0'-'9';\nword = ('a'-'z')+ ('0'-'9')*;";
		return ((Struct)runtime.m_driver.f_parsic(runtime.m_driver.f_compilePegGrammar(l0_gram), as, runtime.m_pegaction.g_defaultPegActions));
	}
}
