// HASH COLLISIONS: YES
// timestamp: 1.602429433E12

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
		case 12/*ArPow*/: {
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
		case 10/*ArMin*/: {
			final Struct_ArMin l1__tmp = (Struct_ArMin)l0__tmp;
			final Struct l10_l = l1__tmp.f_l;
			final Struct l11_r = l1__tmp.f_r;
			final Struct l12_l = l1__tmp.f_l;
			final Struct l13_r = l1__tmp.f_r;
			return runtime.m_string.f_concatStrings((new Object[] { "(", f_ar2s(l12_l), " - ", f_ar2s(l13_r), ")" }));
		}
		case 14/*ArSum*/: {
			final Struct_ArSum l1__tmp = (Struct_ArSum)l0__tmp;
			final Struct l14_l = l1__tmp.f_l;
			final Struct l15_r = l1__tmp.f_r;
			final Struct l16_l = l1__tmp.f_l;
			final Struct l17_r = l1__tmp.f_r;
			return runtime.m_string.f_concatStrings((new Object[] { "(", f_ar2s(l16_l), " + ", f_ar2s(l17_r), ")" }));
		}
		case 11/*ArMult*/: {
			final Struct_ArMult l1__tmp = (Struct_ArMult)l0__tmp;
			final Struct l18_l = l1__tmp.f_l;
			final Struct l19_r = l1__tmp.f_r;
			final Struct l20_l = l1__tmp.f_l;
			final Struct l21_r = l1__tmp.f_r;
			return runtime.m_string.f_concatStrings((new Object[] { "(", f_ar2s(l20_l), " * ", f_ar2s(l21_r), ")" }));
		}
		case 9/*ArInt*/: {
			final Struct_ArInt l1__tmp = (Struct_ArInt)l0__tmp;
			final int l22_val = l1__tmp.f_val;
			final int l23_val = l1__tmp.f_val;
			return runtime.m_string.f_i2s(l23_val);
		}
		case 15/*ArVar*/: {
			final Struct_ArVar l1__tmp = (Struct_ArVar)l0__tmp;
			final String l24_var = l1__tmp.f_var;
			final String l25_var = l1__tmp.f_var;
			return l25_var;
		}
		default:
			throw new RuntimeException("Unexpected struct in switch: "+l0__tmp.getTypeName());
		}
	}
	Struct f_s2ar(String as) {
		final String l0_gram = "S = min | divide | power | plus | mult | int | var;\nws = (\" \" | \"\\t\" | \"\\n\" | \"\\r\")*;\n\npower = ws \"(\" ws S:l \"^\" S:r ws \")\" ws {ArPow(:l,:r)};\ndivide = ws \"(\" ws S:l ws \"/\" ws S:r ws \")\" ws {ArDiv(:l,:r)};\nmin = ws \"(\" ws S:l ws \"-\" ws S:r ws \")\" ws {ArMin(:l,:r)};\nplus = ws \"(\" ws S:l ws \"+\" ws S:r ws \")\" ws {ArSum(:l,:r)};\nmult = ws \"(\" ws S:l ws \"*\" ws S:r ws \")\" ws {ArMult(:l,:r)};\n\nint = ws digit+$s ws {ArInt(s2i($s))};\nvar = ws word$s ws {ArVar($s)};\n\ndigit = '0'-'9';\nword = ('a'-'z')+ ('0'-'9')*;";
		return ((Struct)runtime.m_driver.f_parsic(runtime.m_driver.f_compilePegGrammar(l0_gram), as, runtime.m_pegaction.g_defaultPegActions));
	}
}
