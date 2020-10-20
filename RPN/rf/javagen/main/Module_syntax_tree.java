// HASH COLLISIONS: YES
// timestamp: 1.60311833E12

package main;

import com.area9innovation.flow.*;

@SuppressWarnings("unchecked")
final class Module_syntax_tree {
	final main runtime;
	Module_syntax_tree(main runtime) {
		this.runtime = runtime;
	}
	String f_alg2s(Struct aar) {
		Struct l0__tmp = aar;
		switch (l0__tmp.getTypeId()) {
		case 8/*AlgDiv*/: {
			final Struct_AlgDiv l1__tmp = (Struct_AlgDiv)l0__tmp;
			final Struct l2_up = l1__tmp.f_up;
			final Struct l3_down = l1__tmp.f_down;
			final Struct l4_up = l1__tmp.f_up;
			final Struct l5_down = l1__tmp.f_down;
			return runtime.m_string.f_concatStrings((new Object[] { "(", f_alg2s(l4_up), " / ", f_alg2s(l5_down), ")" }));
		}
		case 10/*AlgMin*/: {
			final Struct_AlgMin l1__tmp = (Struct_AlgMin)l0__tmp;
			final Struct l6_l = l1__tmp.f_l;
			final Struct l7_r = l1__tmp.f_r;
			final Struct l8_l = l1__tmp.f_l;
			final Struct l9_r = l1__tmp.f_r;
			return runtime.m_string.f_concatStrings((new Object[] { "(", f_alg2s(l8_l), " - ", f_alg2s(l9_r), ")" }));
		}
		case 12/*AlgSum*/: {
			final Struct_AlgSum l1__tmp = (Struct_AlgSum)l0__tmp;
			final Struct l10_l = l1__tmp.f_l;
			final Struct l11_r = l1__tmp.f_r;
			final Struct l12_l = l1__tmp.f_l;
			final Struct l13_r = l1__tmp.f_r;
			return runtime.m_string.f_concatStrings((new Object[] { "(", f_alg2s(l12_l), " + ", f_alg2s(l13_r), ")" }));
		}
		case 11/*AlgMult*/: {
			final Struct_AlgMult l1__tmp = (Struct_AlgMult)l0__tmp;
			final Struct l14_l = l1__tmp.f_l;
			final Struct l15_r = l1__tmp.f_r;
			final Struct l16_l = l1__tmp.f_l;
			final Struct l17_r = l1__tmp.f_r;
			return runtime.m_string.f_concatStrings((new Object[] { "(", f_alg2s(l16_l), " * ", f_alg2s(l17_r), ")" }));
		}
		case 9/*AlgDouble*/: {
			final Struct_AlgDouble l1__tmp = (Struct_AlgDouble)l0__tmp;
			final double l18_val = l1__tmp.f_val;
			final double l19_val = l1__tmp.f_val;
			return runtime.m_string.f_d2s(l19_val);
		}
		case 13/*AlgVar*/: {
			final Struct_AlgVar l1__tmp = (Struct_AlgVar)l0__tmp;
			final String l20_var = l1__tmp.f_var;
			final String l21_var = l1__tmp.f_var;
			return l21_var;
		}
		default:
			throw new RuntimeException("Unexpected struct in switch: "+l0__tmp.getTypeName());
		}
	}
	Struct f_s2alg(String as) {
		final String l0_gram = "S = operations | numeric;\n\nnumeric = double | negd | int | negi | var | negv;\noperations = min | divide | plus | mult;\nws = (\" \" | \"\\t\" | \"\\n\" | \"\\r\")*;\n\ndivide = ws \"(\" ws S:l ws \"/\" ws S:r ws \")\" ws {AlgDiv(:l,:r)};\nmin = ws \"(\" ws S:l ws \"-\" ws S:r ws \")\" ws {AlgMin(:l,:r)};\nplus = ws \"(\" ws S:l ws \"+\" ws S:r ws \")\" ws {AlgSum(:l,:r)};\nmult = ws \"(\" ws S:l ws \"*\" ws S:r ws \")\" ws {AlgMult(:l,:r)};\n\ndouble = ws digitD$s ws {AlgDouble(s2d($s))};\nnegd = ws (\"-\" digitD)$s ws {AlgDouble(s2d($s))};\n\nint = ws digit$s ws {AlgDouble(s2d($s))};\nnegi = ws (\"-\" digit)$s ws {AlgDouble(s2d($s))};\n\nvar = ws word$s ws {AlgVar($s)};\nnegv = ws \"-\" word$s ws {AlgMult(AlgDouble(s2d(\"-1.0\")), AlgVar($s))};\n\ndigit  = ('0'-'9')+;\ndigitD = ('0'-'9')+ \".\" ('0'-'9')+;\nword = ('a'-'z')+ ('0'-'9')*;";
		return ((Struct)runtime.m_driver.f_parsic(runtime.m_driver.f_compilePegGrammar(l0_gram), as, runtime.m_pegaction.g_defaultPegActions));
	}
}
