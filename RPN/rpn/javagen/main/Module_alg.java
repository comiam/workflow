// HASH COLLISIONS: YES
// timestamp: 1.601363096E12

package main;

import com.area9innovation.flow.*;

@SuppressWarnings("unchecked")
final class Module_alg {
	final main runtime;
	Module_alg(main runtime) {
		this.runtime = runtime;
	}
	int f_calcVarRpn(Struct_ArRpn aar, Struct avars) {
		final Object[] l3_$1 = aar.f_rpn;
		final Object[] l4_$2 = (new Object[] { 0 });
		final Struct l6_vars = avars;
		final Func2<Object[],Object[], Struct> l5_$0 = new Func2<Object[],Object[],Struct>() {
			final public Object[] invoke(final Object[] aacc, final Struct arpnn) {
				final int l0_len = runtime.h_Native.length(aacc);
				if ((((int)(aacc[(l0_len-1)]))>0)) {
					return aacc;
				} else {
					Struct l1__tmp = arpnn;
					switch (l1__tmp.getTypeId()) {
					case 96/*RpnOp*/: {
						final Struct_RpnOp l2__tmp = (Struct_RpnOp)l1__tmp;
						final String l3_id = l2__tmp.f_id;
						final Func2<Integer,Integer, Integer> l4_op = l2__tmp.f_op;
						final String l5_id = l2__tmp.f_id;
						final Func2<Integer,Integer, Integer> l6_op = l2__tmp.f_op;
						if ((l5_id).equals("+")) {
							if ((l0_len<2)) {
								return runtime.h_Native.concat(runtime.m_array.f_take(aacc, (l0_len-1)), (new Object[] { 1 }));
							} else {
								return runtime.h_Native.concat((new Object[] { (((int)(aacc[0]))+((int)(aacc[1]))) }), runtime.m_array.f_tailFrom(aacc, 2));
							}
						} else {
							if ((l5_id).equals("*")) {
								if ((l0_len<2)) {
									return runtime.h_Native.concat(runtime.m_array.f_take(aacc, (l0_len-1)), (new Object[] { 1 }));
								} else {
									return runtime.h_Native.concat((new Object[] { (((int)(aacc[0]))*((int)(aacc[1]))) }), runtime.m_array.f_tailFrom(aacc, 2));
								}
							} else {
								return aacc;
							}
						}
					}
					case 95/*RpnArg*/: {
						final Struct_RpnArg l2__tmp = (Struct_RpnArg)l1__tmp;
						final int l7_val = l2__tmp.f_val;
						final int l8_val = l2__tmp.f_val;
						return runtime.h_Native.concat((new Object[] { l8_val }), aacc);
					}
					case 97/*RpnVar*/: {
						final Struct_RpnVar l2__tmp = (Struct_RpnVar)l1__tmp;
						final String l9_var = l2__tmp.f_var;
						final String l10_var = l2__tmp.f_var;
						final Struct l11_res = ((Func2<Struct,Struct, String>)(Func2)runtime.n_lookupTree).invoke(l6_vars, l10_var);
						Struct l12__tmp = l11_res;
						switch (l12__tmp.getTypeId()) {
						case 41/*None*/: {
							return runtime.h_Native.concat(runtime.m_array.f_take(aacc, (l0_len-1)), (new Object[] { 2 }));
						}
						case 104/*Some*/: {
							final Struct_Some l13__tmp = (Struct_Some)l12__tmp;
							final Object l14_value = l13__tmp.f_value;
							final int l15_value = ((int)l13__tmp.f_value);
							return runtime.h_Native.concat((new Object[] { l15_value }), aacc);
						}
						default:
							throw new RuntimeException("Unexpected struct in switch: "+l12__tmp.getTypeName());
						}
					}
					default:
						throw new RuntimeException("Unexpected struct in switch: "+l1__tmp.getTypeName());
					}
				}
			}
		};
		final Object[] l7_val = ((Object[])runtime.m_array.f_foldr(l3_$1, l4_$2, ((Func2<Object,Object, Object>)(Func2)l5_$0)));
		if ((((int)(l7_val[(runtime.h_Native.length(l7_val)-1)]))>0)) {
			runtime.h_Native.print("was something wrong during calculating: ");
			if ((((int)(l7_val[(runtime.h_Native.length(l7_val)-1)]))==1)) {
				runtime.m_runtime.f_println("error in the stack due to lack of arguments");
			} else {
				if ((((int)(l7_val[(runtime.h_Native.length(l7_val)-1)]))==2)) {
					runtime.m_runtime.f_println("unknown variables!");
				} else {
				}
			}
			return (-1);
		} else {
			return ((int)(l7_val[0]));
		}
	}
}
