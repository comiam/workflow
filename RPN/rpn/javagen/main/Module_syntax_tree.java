// HASH COLLISIONS: YES
// timestamp: 1.601703077E12

package main;

import com.area9innovation.flow.*;

@SuppressWarnings("unchecked")
final class Module_syntax_tree {
	final main runtime;
	Module_syntax_tree(main runtime) {
		this.runtime = runtime;
	}
	String f_ar2s(Struct aar) {
		if (runtime.m_maybe.f_isNone(aar)) {
			return "error tree!!!";
		} else {
			final Struct l0_gsymswitch0 = ((Struct)runtime.m_maybe.f_either(aar, (new Struct_ArInt(0))));
			Struct l1__tmp = l0_gsymswitch0;
			switch (l1__tmp.getTypeId()) {
			case 12/*ArPow*/: {
				final Struct_ArPow l2__tmp = (Struct_ArPow)l1__tmp;
				final Struct l3_l = l2__tmp.f_l;
				final Struct l4_power = l2__tmp.f_pow;
				final Struct l5_l = l2__tmp.f_l;
				final Struct l6_power = l2__tmp.f_pow;
				return runtime.m_string.f_concatStrings((new Object[] { "(", f_ar2s((new Struct_Some(l5_l))), "^", f_ar2s((new Struct_Some(l6_power))), ")" }));
			}
			case 8/*ArDiv*/: {
				final Struct_ArDiv l2__tmp = (Struct_ArDiv)l1__tmp;
				final Struct l7_up = l2__tmp.f_up;
				final Struct l8_down = l2__tmp.f_down;
				final Struct l9_up = l2__tmp.f_up;
				final Struct l10_down = l2__tmp.f_down;
				return runtime.m_string.f_concatStrings((new Object[] { "(", f_ar2s((new Struct_Some(l9_up))), " / ", f_ar2s((new Struct_Some(l10_down))), ")" }));
			}
			case 10/*ArMin*/: {
				final Struct_ArMin l2__tmp = (Struct_ArMin)l1__tmp;
				final Struct l11_l = l2__tmp.f_l;
				final Struct l12_r = l2__tmp.f_r;
				final Struct l13_l = l2__tmp.f_l;
				final Struct l14_r = l2__tmp.f_r;
				return runtime.m_string.f_concatStrings((new Object[] { "(", f_ar2s((new Struct_Some(l13_l))), " - ", f_ar2s((new Struct_Some(l14_r))), ")" }));
			}
			case 14/*ArSum*/: {
				final Struct_ArSum l2__tmp = (Struct_ArSum)l1__tmp;
				final Struct l15_l = l2__tmp.f_l;
				final Struct l16_r = l2__tmp.f_r;
				final Struct l17_l = l2__tmp.f_l;
				final Struct l18_r = l2__tmp.f_r;
				return runtime.m_string.f_concatStrings((new Object[] { "(", f_ar2s((new Struct_Some(l17_l))), " + ", f_ar2s((new Struct_Some(l18_r))), ")" }));
			}
			case 11/*ArMult*/: {
				final Struct_ArMult l2__tmp = (Struct_ArMult)l1__tmp;
				final Struct l19_l = l2__tmp.f_l;
				final Struct l20_r = l2__tmp.f_r;
				final Struct l21_l = l2__tmp.f_l;
				final Struct l22_r = l2__tmp.f_r;
				return runtime.m_string.f_concatStrings((new Object[] { "(", f_ar2s((new Struct_Some(l21_l))), " * ", f_ar2s((new Struct_Some(l22_r))), ")" }));
			}
			case 9/*ArInt*/: {
				final Struct_ArInt l2__tmp = (Struct_ArInt)l1__tmp;
				final int l23_val = l2__tmp.f_val;
				final int l24_val = l2__tmp.f_val;
				return runtime.m_string.f_i2s(l24_val);
			}
			case 15/*ArVar*/: {
				final Struct_ArVar l2__tmp = (Struct_ArVar)l1__tmp;
				final String l25_var = l2__tmp.f_var;
				final String l26_var = l2__tmp.f_var;
				return l26_var;
			}
			default:
				throw new RuntimeException("Unexpected struct in switch: "+l1__tmp.getTypeName());
			}
		}
	}
	Struct f_s2ar(String as) {
		final String l0_gram = "S = min | divide | power | plus | mult | int | var;\nws = (\" \" | \"\\t\" | \"\\n\" | \"\\r\")*;\n\npower = ws \"(\" ws S:l \"^\" S:r ws \")\" ws {ArPow(:l,:r)};\ndivide = ws \"(\" ws S:l ws \"/\" ws S:r ws \")\" ws {ArDiv(:l,:r)};\nmin = ws \"(\" ws S:l ws \"-\" ws S:r ws \")\" ws {ArMin(:l,:r)};\nplus = ws \"(\" ws S:l ws \"+\" ws S:r ws \")\" ws {ArSum(:l,:r)};\nmult = ws \"(\" ws S:l ws \"*\" ws S:r ws \")\" ws {ArMult(:l,:r)};\n\nint = ws digit+$s ws {ArInt(s2i($s))};\nvar = ws word$s ws {ArVar($s)};\n\ndigit = '0'-'9';\nword = ('a'-'z')+ ('0'-'9')*;";
		return ((Struct)runtime.m_driver.f_parsic(runtime.m_driver.f_compilePegGrammar(l0_gram), as, runtime.m_pegaction.g_defaultPegActions));
	}
}
