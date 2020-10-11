// HASH COLLISIONS: YES
// timestamp: 1.602429286E12

package main;

import com.area9innovation.flow.*;

@SuppressWarnings("unchecked")
final class Module_simplifier {
	final main runtime;
	Module_simplifier(main runtime) {
		this.runtime = runtime;
	}
	Struct f_createStruct(String aop, Struct al, Struct ar) {
		if ((aop).equals("+")) {
			return (new Struct_ArSum(al, ar));
		} else {
			if ((aop).equals("-")) {
				return (new Struct_ArMin(al, ar));
			} else {
				if ((aop).equals("*")) {
					return (new Struct_ArMult(al, ar));
				} else {
					if ((aop).equals("/")) {
						return (new Struct_ArDiv(al, ar));
					} else {
						if ((aop).equals("^")) {
							return (new Struct_ArPow(al, ar));
						} else {
							return al;
						}
					}
				}
			}
		}
	}
	Struct f_detectAndReplace(Struct aar, Func2<Struct,String, Struct> acondOp) {
		Struct l0__tmp = aar;
		switch (l0__tmp.getTypeId()) {
		case 9/*ArInt*/: {
			final Struct_ArInt l1__tmp = (Struct_ArInt)l0__tmp;
			final int l2_val = l1__tmp.f_val;
			final int l3_val = l1__tmp.f_val;
			return l1__tmp;
		}
		case 15/*ArVar*/: {
			final Struct_ArVar l1__tmp = (Struct_ArVar)l0__tmp;
			final String l4_var = l1__tmp.f_var;
			final String l5_var = l1__tmp.f_var;
			return l1__tmp;
		}
		default: {
			return f_execSimplifier(aar, acondOp);
		}
		}
	}
	String f_detectType(Struct aar) {
		Struct l0__tmp = aar;
		switch (l0__tmp.getTypeId()) {
		case 12/*ArPow*/: {
			final Struct_ArPow l1__tmp = (Struct_ArPow)l0__tmp;
			final Struct l2_l = l1__tmp.f_l;
			final Struct l3_power = l1__tmp.f_pow;
			final Struct l4_l = l1__tmp.f_l;
			final Struct l5_power = l1__tmp.f_pow;
			return "^";
		}
		case 8/*ArDiv*/: {
			final Struct_ArDiv l1__tmp = (Struct_ArDiv)l0__tmp;
			final Struct l6_up = l1__tmp.f_up;
			final Struct l7_down = l1__tmp.f_down;
			final Struct l8_up = l1__tmp.f_up;
			final Struct l9_down = l1__tmp.f_down;
			return "/";
		}
		case 10/*ArMin*/: {
			final Struct_ArMin l1__tmp = (Struct_ArMin)l0__tmp;
			final Struct l10_l = l1__tmp.f_l;
			final Struct l11_r = l1__tmp.f_r;
			final Struct l12_l = l1__tmp.f_l;
			final Struct l13_r = l1__tmp.f_r;
			return "-";
		}
		case 14/*ArSum*/: {
			final Struct_ArSum l1__tmp = (Struct_ArSum)l0__tmp;
			final Struct l14_l = l1__tmp.f_l;
			final Struct l15_r = l1__tmp.f_r;
			final Struct l16_l = l1__tmp.f_l;
			final Struct l17_r = l1__tmp.f_r;
			return "+";
		}
		case 11/*ArMult*/: {
			final Struct_ArMult l1__tmp = (Struct_ArMult)l0__tmp;
			final Struct l18_l = l1__tmp.f_l;
			final Struct l19_r = l1__tmp.f_r;
			final Struct l20_l = l1__tmp.f_l;
			final Struct l21_r = l1__tmp.f_r;
			return "*";
		}
		case 9/*ArInt*/: {
			final Struct_ArInt l1__tmp = (Struct_ArInt)l0__tmp;
			final int l22_val = l1__tmp.f_val;
			final int l23_val = l1__tmp.f_val;
			return "int";
		}
		case 15/*ArVar*/: {
			final Struct_ArVar l1__tmp = (Struct_ArVar)l0__tmp;
			final String l24_var = l1__tmp.f_var;
			final String l25_var = l1__tmp.f_var;
			return "variable";
		}
		default:
			throw new RuntimeException("Unexpected struct in switch: "+l0__tmp.getTypeName());
		}
	}
	Struct f_execSimplifier(Struct am, Func2<Struct,String, Struct> acondOp) {
		final Object[] l0_arr = f_extractArgs(am);
		if ((runtime.h_Native.length(l0_arr)==0)) {
			return am;
		} else {
			final Struct l1_newL = f_detectAndReplace(((Struct)(l0_arr[0])), acondOp);
			final Struct l2_newR = f_detectAndReplace(((Struct)(l0_arr[1])), acondOp);
			final String l3_op = f_detectType(am);
			return acondOp.invoke(l3_op, f_createStruct(l3_op, l1_newL, f_detectAndReplace(((Struct)(l0_arr[1])), acondOp)));
		}
	}
	Object[] f_extractArgs(Struct aar) {
		Struct l0__tmp = aar;
		switch (l0__tmp.getTypeId()) {
		case 12/*ArPow*/: {
			final Struct_ArPow l1__tmp = (Struct_ArPow)l0__tmp;
			final Struct l2_l = l1__tmp.f_l;
			final Struct l3_power = l1__tmp.f_pow;
			final Struct l4_l = l1__tmp.f_l;
			final Struct l5_power = l1__tmp.f_pow;
			return (new Object[] { l4_l, l5_power });
		}
		case 8/*ArDiv*/: {
			final Struct_ArDiv l1__tmp = (Struct_ArDiv)l0__tmp;
			final Struct l6_up = l1__tmp.f_up;
			final Struct l7_down = l1__tmp.f_down;
			final Struct l8_up = l1__tmp.f_up;
			final Struct l9_down = l1__tmp.f_down;
			return (new Object[] { l8_up, l9_down });
		}
		case 10/*ArMin*/: {
			final Struct_ArMin l1__tmp = (Struct_ArMin)l0__tmp;
			final Struct l10_l = l1__tmp.f_l;
			final Struct l11_r = l1__tmp.f_r;
			final Struct l12_l = l1__tmp.f_l;
			final Struct l13_r = l1__tmp.f_r;
			return (new Object[] { l12_l, l13_r });
		}
		case 14/*ArSum*/: {
			final Struct_ArSum l1__tmp = (Struct_ArSum)l0__tmp;
			final Struct l14_l = l1__tmp.f_l;
			final Struct l15_r = l1__tmp.f_r;
			final Struct l16_l = l1__tmp.f_l;
			final Struct l17_r = l1__tmp.f_r;
			return (new Object[] { l16_l, l17_r });
		}
		case 11/*ArMult*/: {
			final Struct_ArMult l1__tmp = (Struct_ArMult)l0__tmp;
			final Struct l18_l = l1__tmp.f_l;
			final Struct l19_r = l1__tmp.f_r;
			final Struct l20_l = l1__tmp.f_l;
			final Struct l21_r = l1__tmp.f_r;
			return (new Object[] { l20_l, l21_r });
		}
		default: {
			return SingletonStructs.arr_empty;
		}
		}
	}
	Struct f_removeTrivialExp(Struct aar) {
	 TAIL_CALL: for(;;) {
		final Func1<Struct_Pair,Struct> l0_getInt = new Func1<Struct_Pair,Struct>() {
			final public Struct_Pair invoke(final Struct aa) {
				Struct l0__tmp = aa;
				switch (l0__tmp.getTypeId()) {
				case 9/*ArInt*/: {
					final Struct_ArInt l1__tmp = (Struct_ArInt)l0__tmp;
					final int l2_val = l1__tmp.f_val;
					final int l3_val = l1__tmp.f_val;
					return (new Struct_Pair(true, l3_val));
				}
				default: {
					return (new Struct_Pair(false, 5));
				}
				}
			}
		};
		final Func2<Struct,String, Struct> l2_$1 = new Func2<Struct,String,Struct>() {
			final public Struct invoke(final String aop, final Struct aar0) {
				final Object[] l0_args = f_extractArgs(aar0);
				if ((runtime.h_Native.length(l0_args)==2)) {
					final int l1_l0 = ((int)l0_getInt.invoke(((Struct)(l0_args[0]))).f_second);
					final int l2_r0 = ((int)l0_getInt.invoke(((Struct)(l0_args[1]))).f_second);
					if ((aop).equals("^")) {
						if ((l2_r0==0)) {
							return (new Struct_ArInt(1));
						} else {
							if ((l2_r0==1)) {
								return ((Struct)(l0_args[0]));
							} else {
								if ((l1_l0==1)) {
									return (new Struct_ArInt(1));
								} else {
									if ((((l1_l0==0)&&((boolean)l0_getInt.invoke(((Struct)(l0_args[1]))).f_first))&&(l2_r0!=1))) {
										return (new Struct_ArInt(0));
									} else {
										return aar0;
									}
								}
							}
						}
					} else {
						if ((aop).equals("*")) {
							if (((l2_r0==0)||(l1_l0==0))) {
								return (new Struct_ArInt(0));
							} else {
								if ((l2_r0==1)) {
									return ((Struct)(l0_args[0]));
								} else {
									if ((l1_l0==1)) {
										return ((Struct)(l0_args[1]));
									} else {
										if (FlowRuntime.compareEqual(((Struct)(l0_args[0])),((Struct)(l0_args[1])))) {
											return (new Struct_ArPow(((Struct)(l0_args[0])), (new Struct_ArInt(2))));
										} else {
											return aar0;
										}
									}
								}
							}
						} else {
							if ((aop).equals("/")) {
								if ((l1_l0==0)) {
									return (new Struct_ArInt(0));
								} else {
									if ((l2_r0==1)) {
										return ((Struct)(l0_args[0]));
									} else {
										if (FlowRuntime.compareEqual(((Struct)(l0_args[0])),((Struct)(l0_args[1])))) {
											return (new Struct_ArInt(1));
										} else {
											return aar0;
										}
									}
								}
							} else {
								if ((aop).equals("-")) {
									if (FlowRuntime.compareEqual(((Struct)(l0_args[0])),((Struct)(l0_args[1])))) {
										return (new Struct_ArInt(0));
									} else {
										if ((l2_r0==0)) {
											return ((Struct)(l0_args[0]));
										} else {
											return aar0;
										}
									}
								} else {
									if ((aop).equals("+")) {
										if ((l1_l0==0)) {
											return ((Struct)(l0_args[1]));
										} else {
											if ((l2_r0==0)) {
												return ((Struct)(l0_args[0]));
											} else {
												if (FlowRuntime.compareEqual(((Struct)(l0_args[0])),((Struct)(l0_args[1])))) {
													return (new Struct_ArMult((new Struct_ArInt(2)), ((Struct)(l0_args[0]))));
												} else {
													return aar0;
												}
											}
										}
									} else {
										return aar0;
									}
								}
							}
						}
					}
				} else {
					return aar0;
				}
			}
		};
		final Struct l3_it = f_execSimplifier(aar, l2_$1);
		if (FlowRuntime.compareEqual(l3_it,aar)) {
			return l3_it;
		} else {
			{
				final Struct l4___tmp = l3_it;
				aar = l4___tmp;
				continue TAIL_CALL;
			}
		}
	 }
	}
	Struct f_simplifyTree(Struct aar) {
		return f_removeTrivialExp(aar);
	}
}
