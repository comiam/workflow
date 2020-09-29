// HASH COLLISIONS: YES
// timestamp: 1.601360342E12

package main;

import com.area9innovation.flow.*;

@SuppressWarnings("unchecked")
final class Module_rpn {
	final main runtime;
	Module_rpn(main runtime) {
		this.runtime = runtime;
	}
	Struct_ArRpn f_ar2rpn(Struct aar) {
		Struct l0__tmp = aar;
		switch (l0__tmp.getTypeId()) {
		case 11/*ArSum*/: {
			final Struct_ArSum l1__tmp = (Struct_ArSum)l0__tmp;
			final Struct l2_l = l1__tmp.f_l;
			final Struct l3_r = l1__tmp.f_r;
			final Struct l4_l = l1__tmp.f_l;
			final Struct l5_r = l1__tmp.f_r;
			final Func2<Integer,Integer, Integer> l7_$6 = new Func2<Integer,Integer,Integer>() {
				final public Integer invoke(final Integer ai, final Integer ai2) {
					return ((Integer)(((int)ai)+((int)ai2)));
				}
			};
			return (new Struct_ArRpn(runtime.h_Native.concat((new Object[] { (new Struct_RpnOp("+", l7_$6)) }), runtime.h_Native.concat(f_ar2rpn(l5_r).f_rpn, f_ar2rpn(l4_l).f_rpn))));
		}
		case 9/*ArMult*/: {
			final Struct_ArMult l1__tmp = (Struct_ArMult)l0__tmp;
			final Struct l8_l = l1__tmp.f_l;
			final Struct l9_r = l1__tmp.f_r;
			final Struct l10_l = l1__tmp.f_l;
			final Struct l11_r = l1__tmp.f_r;
			final Func2<Integer,Integer, Integer> l13_$12 = new Func2<Integer,Integer,Integer>() {
				final public Integer invoke(final Integer ai, final Integer ai2) {
					return ((Integer)(((int)ai)*((int)ai2)));
				}
			};
			return (new Struct_ArRpn(runtime.h_Native.concat((new Object[] { (new Struct_RpnOp("*", l13_$12)) }), runtime.h_Native.concat(f_ar2rpn(l11_r).f_rpn, f_ar2rpn(l10_l).f_rpn))));
		}
		case 8/*ArInt*/: {
			final Struct_ArInt l1__tmp = (Struct_ArInt)l0__tmp;
			final int l14_val = l1__tmp.f_val;
			final int l15_val = l1__tmp.f_val;
			return (new Struct_ArRpn((new Object[] { (new Struct_RpnArg(l15_val)) })));
		}
		case 12/*ArVar*/: {
			final Struct_ArVar l1__tmp = (Struct_ArVar)l0__tmp;
			final String l16_var = l1__tmp.f_var;
			final String l17_var = l1__tmp.f_var;
			return (new Struct_ArRpn((new Object[] { (new Struct_RpnVar(l17_var)) })));
		}
		default:
			throw new RuntimeException("Unexpected struct in switch: "+l0__tmp.getTypeName());
		}
	}
	Struct_ArRpn f_s2rpn(String as) {
		return f_ar2rpn(runtime.m_syntax_tree.f_s2ar(as));
	}
}
