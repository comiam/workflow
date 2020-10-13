// HASH COLLISIONS: YES
// timestamp: 1.602568357E12

package main;

import com.area9innovation.flow.*;

@SuppressWarnings("unchecked")
final class Module_syntax_tree {
	final main runtime;
	Module_syntax_tree(main runtime) {
		this.runtime = runtime;
	}
	String f_ar2s(Struct aar) {
		Struct l0__tmp = aar;
		switch (l0__tmp.getTypeId()) {
		case 13/*ArPow*/: {
			final Struct_ArPow l1__tmp = (Struct_ArPow)l0__tmp;
			final Struct l2_l = l1__tmp.f_l;
			final Struct l3_power = l1__tmp.f_pow;
			final Struct l4_l = l1__tmp.f_l;
			final Struct l5_power = l1__tmp.f_pow;
			return runtime.m_string.f_concatStrings((new Object[] { "(", f_ar2s(l4_l), "^", f_ar2s(l5_power), ")" }));
		}
		case 8/*ArDiv*/: {
			final Struct_ArDiv l1__tmp = (Struct_ArDiv)l0__tmp;
			final Struct l6_up = l1__tmp.f_up;
			final Struct l7_down = l1__tmp.f_down;
			final Struct l8_up = l1__tmp.f_up;
			final Struct l9_down = l1__tmp.f_down;
			return runtime.m_string.f_concatStrings((new Object[] { "(", f_ar2s(l8_up), " / ", f_ar2s(l9_down), ")" }));
		}
		case 11/*ArMin*/: {
			final Struct_ArMin l1__tmp = (Struct_ArMin)l0__tmp;
			final Struct l10_l = l1__tmp.f_l;
			final Struct l11_r = l1__tmp.f_r;
			final Struct l12_l = l1__tmp.f_l;
			final Struct l13_r = l1__tmp.f_r;
			return runtime.m_string.f_concatStrings((new Object[] { "(", f_ar2s(l12_l), " - ", f_ar2s(l13_r), ")" }));
		}
		case 15/*ArSum*/: {
			final Struct_ArSum l1__tmp = (Struct_ArSum)l0__tmp;
			final Struct l14_l = l1__tmp.f_l;
			final Struct l15_r = l1__tmp.f_r;
			final Struct l16_l = l1__tmp.f_l;
			final Struct l17_r = l1__tmp.f_r;
			return runtime.m_string.f_concatStrings((new Object[] { "(", f_ar2s(l16_l), " + ", f_ar2s(l17_r), ")" }));
		}
		case 12/*ArMult*/: {
			final Struct_ArMult l1__tmp = (Struct_ArMult)l0__tmp;
			final Struct l18_l = l1__tmp.f_l;
			final Struct l19_r = l1__tmp.f_r;
			final Struct l20_l = l1__tmp.f_l;
			final Struct l21_r = l1__tmp.f_r;
			return runtime.m_string.f_concatStrings((new Object[] { "(", f_ar2s(l20_l), " * ", f_ar2s(l21_r), ")" }));
		}
		case 10/*ArLn*/: {
			final Struct_ArLn l1__tmp = (Struct_ArLn)l0__tmp;
			final Struct l22_v = l1__tmp.f_l;
			final Struct l23_v = l1__tmp.f_l;
			return runtime.m_string.f_concatStrings((new Object[] { "ln(", f_ar2s(l23_v), ")" }));
		}
		case 9/*ArDouble*/: {
			final Struct_ArDouble l1__tmp = (Struct_ArDouble)l0__tmp;
			final double l24_val = l1__tmp.f_val;
			final double l25_val = l1__tmp.f_val;
			return runtime.m_string.f_d2s(l25_val);
		}
		case 16/*ArVar*/: {
			final Struct_ArVar l1__tmp = (Struct_ArVar)l0__tmp;
			final String l26_var = l1__tmp.f_var;
			final String l27_var = l1__tmp.f_var;
			return l27_var;
		}
		default:
			throw new RuntimeException("Unexpected struct in switch: "+l0__tmp.getTypeName());
		}
	}
	Struct f_s2ar(String as) {
		final String l0_gram = "S = operations | numeric;\n\nnumeric = double | negd | int | negi | var | negv;\noperations = min | divide | power | plus | mult;\nws = (\" \" | \"\\t\" | \"\\n\" | \"\\r\")*;\n\npower = ws \"(\" ws S:l \"^\" S:r ws \")\" ws {ArPow(:l,:r)};\ndivide = ws \"(\" ws S:l ws \"/\" ws S:r ws \")\" ws {ArDiv(:l,:r)};\nmin = ws \"(\" ws S:l ws \"-\" ws S:r ws \")\" ws {ArMin(:l,:r)};\nplus = ws \"(\" ws S:l ws \"+\" ws S:r ws \")\" ws {ArSum(:l,:r)};\nmult = ws \"(\" ws S:l ws \"*\" ws S:r ws \")\" ws {ArMult(:l,:r)};\n\ndouble = ws digitD$s ws {ArDouble(s2d($s))};\nnegd = ws (\"-\" digitD)$s ws {ArDouble(s2d($s))};\n\nint = ws digit$s ws {ArDouble(s2d($s))};\nnegi = ws (\"-\" digit)$s ws {ArDouble(s2d($s))};\n\nvar = ws word$s ws {ArVar($s)};\nnegv = ws \"-\" word$s ws {ArMult(ArDouble(s2d(\"-1.0\")), ArVar($s))};\n\ndigit  = ('0'-'9')+;\ndigitD = ('0'-'9')+ \".\" ('0'-'9')+;\nword = ('a'-'z')+ ('0'-'9')*;";
		return ((Struct)runtime.m_driver.f_parsic(runtime.m_driver.f_compilePegGrammar(l0_gram), as, runtime.m_pegaction.g_defaultPegActions));
	}
}
