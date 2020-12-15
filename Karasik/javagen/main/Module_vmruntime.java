// HASH COLLISIONS: YES
// timestamp: 1.608014576E12

package main;

import com.area9innovation.flow.*;

@SuppressWarnings("unchecked")
final class Module_vmruntime {
	final main runtime;
	Module_vmruntime(main runtime) {
		this.runtime = runtime;
	}
	int f_execVM(Struct as) {
		if (!runtime.m_tree.f_containsKeyTree(as, 0)) {
			runtime.m_runtime.f_println("Can't find start command in program!");
			return (-1);
		} else {
			final int l0_stat = f_loopExecution(0, as, runtime.m_tree.f_makeTree());
			if ((l0_stat==(-2))) {
				runtime.m_runtime.f_println("Program executed successfully!");
				return 0;
			} else {
				if ((l0_stat==(-3))) {
					runtime.m_runtime.f_println("Cannot found tree, which can describe program!");
					return 0;
				} else {
					runtime.m_runtime.f_println(("Program was broken or failed with error "+runtime.m_string.f_i2s(l0_stat)));
					return (-1);
				}
			}
		}
	}
	Struct_Pair f_execVMCommand(Struct avmc, Struct avmState) {
		Struct l0__tmp = avmc;
		switch (l0__tmp.getTypeId()) {
		case 39/*InitVar*/: {
			final Struct_InitVar l1__tmp = (Struct_InitVar)l0__tmp;
			final String l2_v = l1__tmp.f_v;
			final Struct l3_e = l1__tmp.f_e;
			final int l4_g = l1__tmp.f_goto;
			final String l5_v = l1__tmp.f_v;
			final Struct l6_e = l1__tmp.f_e;
			final int l7_g = l1__tmp.f_goto;
			Struct l8__tmp = l6_e;
			switch (l8__tmp.getTypeId()) {
			case 130/*Sum*/: {
				final Struct_Sum l9__tmp = (Struct_Sum)l8__tmp;
				final Struct l10_val = f_toInt(l9__tmp, avmState);
				if (runtime.m_maybe.f_isNone(l10_val)) {
					runtime.m_runtime.f_println((("Initial expression value of var "+l5_v)+" is illegal!"));
					return (new Struct_Pair((new Object[] { (-1) }), avmState));
				} else {
					final Struct l11_t = ((Func3<Struct,Struct, String, Struct>)(Func3)runtime.n_setTree).invoke(avmState, l5_v, (new Struct_VMInt(f_getVal(l10_val))));
					return (new Struct_Pair((new Object[] { l7_g }), l11_t));
				}
			}
			case 60/*Min*/: {
				final Struct_Min l9__tmp = (Struct_Min)l8__tmp;
				final Struct l12_val = f_toInt(l9__tmp, avmState);
				if (runtime.m_maybe.f_isNone(l12_val)) {
					runtime.m_runtime.f_println((("Initial expression value of var "+l5_v)+" is illegal!"));
					return (new Struct_Pair((new Object[] { (-1) }), avmState));
				} else {
					final Struct l13_t = ((Func3<Struct,Struct, String, Struct>)(Func3)runtime.n_setTree).invoke(avmState, l5_v, (new Struct_VMInt(f_getVal(l12_val))));
					return (new Struct_Pair((new Object[] { l7_g }), l13_t));
				}
			}
			case 24/*Div*/: {
				final Struct_Div l9__tmp = (Struct_Div)l8__tmp;
				final Struct l14_val = f_toInt(l9__tmp, avmState);
				if (runtime.m_maybe.f_isNone(l14_val)) {
					runtime.m_runtime.f_println((("Initial expression value of var "+l5_v)+" is illegal!"));
					return (new Struct_Pair((new Object[] { (-1) }), avmState));
				} else {
					final Struct l15_t = ((Func3<Struct,Struct, String, Struct>)(Func3)runtime.n_setTree).invoke(avmState, l5_v, (new Struct_VMInt(f_getVal(l14_val))));
					return (new Struct_Pair((new Object[] { l7_g }), l15_t));
				}
			}
			case 61/*Mult*/: {
				final Struct_Mult l9__tmp = (Struct_Mult)l8__tmp;
				final Struct l16_val = f_toInt(l9__tmp, avmState);
				if (runtime.m_maybe.f_isNone(l16_val)) {
					runtime.m_runtime.f_println((("Initial expression value of var "+l5_v)+" is illegal!"));
					return (new Struct_Pair((new Object[] { (-1) }), avmState));
				} else {
					final Struct l17_t = ((Func3<Struct,Struct, String, Struct>)(Func3)runtime.n_setTree).invoke(avmState, l5_v, (new Struct_VMInt(f_getVal(l16_val))));
					return (new Struct_Pair((new Object[] { l7_g }), l17_t));
				}
			}
			case 32/*ExpInt*/: {
				final Struct_ExpInt l9__tmp = (Struct_ExpInt)l8__tmp;
				final Struct l18_val = f_toInt(l9__tmp, avmState);
				if (runtime.m_maybe.f_isNone(l18_val)) {
					runtime.m_runtime.f_println((("Initial expression value of var "+l5_v)+" is illegal!"));
					return (new Struct_Pair((new Object[] { (-1) }), avmState));
				} else {
					final Struct l19_t = ((Func3<Struct,Struct, String, Struct>)(Func3)runtime.n_setTree).invoke(avmState, l5_v, (new Struct_VMInt(f_getVal(l18_val))));
					return (new Struct_Pair((new Object[] { l7_g }), l19_t));
				}
			}
			case 33/*ExpVar*/: {
				final Struct_ExpVar l9__tmp = (Struct_ExpVar)l8__tmp;
				final Struct l20_val = f_toInt(l9__tmp, avmState);
				if (runtime.m_maybe.f_isNone(l20_val)) {
					runtime.m_runtime.f_println((("Initial expression value of var "+l5_v)+" is illegal!"));
					return (new Struct_Pair((new Object[] { (-1) }), avmState));
				} else {
					final Struct l21_t = ((Func3<Struct,Struct, String, Struct>)(Func3)runtime.n_setTree).invoke(avmState, l5_v, (new Struct_VMInt(f_getVal(l20_val))));
					return (new Struct_Pair((new Object[] { l7_g }), l21_t));
				}
			}
			case 31/*ExpArrayAccess*/: {
				final Struct_ExpArrayAccess l9__tmp = (Struct_ExpArrayAccess)l8__tmp;
				final Struct l22_val = f_toInt(l9__tmp, avmState);
				if (runtime.m_maybe.f_isNone(l22_val)) {
					runtime.m_runtime.f_println((("Initial expression value of var "+l5_v)+" is illegal!"));
					return (new Struct_Pair((new Object[] { (-1) }), avmState));
				} else {
					final Struct l23_t = ((Func3<Struct,Struct, String, Struct>)(Func3)runtime.n_setTree).invoke(avmState, l5_v, (new Struct_VMInt(f_getVal(l22_val))));
					return (new Struct_Pair((new Object[] { l7_g }), l23_t));
				}
			}
			case 137/*VMArray*/: {
				final Struct_VMArray l9__tmp = (Struct_VMArray)l8__tmp;
				final Object[] l24_arr = l9__tmp.f_a;
				final Object[] l25_arr = l9__tmp.f_a;
				final Struct l26_t = ((Func3<Struct,Struct, String, Struct>)(Func3)runtime.n_setTree).invoke(avmState, l5_v, l9__tmp);
				return (new Struct_Pair((new Object[] { l7_g }), l26_t));
			}
			default: {
				return (new Struct_Pair((new Object[] { (-1) }), avmState));
			}
			}
		}
		case 20/*Condition*/: {
			final Struct_Condition l1__tmp = (Struct_Condition)l0__tmp;
			final String l27_t = l1__tmp.f_test;
			final Struct l28_e0 = l1__tmp.f_expr0;
			final Struct l29_e1 = l1__tmp.f_expr1;
			final Object[] l30_g0 = l1__tmp.f_gotoTrue;
			final Object[] l31_g1 = l1__tmp.f_gotoFalse;
			final String l32_t = l1__tmp.f_test;
			final Struct l33_e0 = l1__tmp.f_expr0;
			final Struct l34_e1 = l1__tmp.f_expr1;
			final Object[] l35_g0 = l1__tmp.f_gotoTrue;
			final Object[] l36_g1 = l1__tmp.f_gotoFalse;
			final Struct l37_v0 = f_toInt(l33_e0, avmState);
			final Struct l38_v1 = f_toInt(l34_e1, avmState);
			if ((runtime.m_maybe.f_isNone(l37_v0)||runtime.m_maybe.f_isNone(l38_v1))) {
				return (new Struct_Pair((new Object[] { (-1) }), avmState));
			} else {
				if ((l32_t).equals("==")) {
					if ((f_getVal(l37_v0)==f_getVal(l38_v1))) {
						return (new Struct_Pair(l35_g0, avmState));
					} else {
						return (new Struct_Pair(l36_g1, avmState));
					}
				} else {
					if ((l32_t).equals("<=")) {
						if ((f_getVal(l37_v0)<=f_getVal(l38_v1))) {
							return (new Struct_Pair(l35_g0, avmState));
						} else {
							return (new Struct_Pair(l36_g1, avmState));
						}
					} else {
						if ((l32_t).equals(">=")) {
							if ((f_getVal(l37_v0)>=f_getVal(l38_v1))) {
								return (new Struct_Pair(l35_g0, avmState));
							} else {
								return (new Struct_Pair(l36_g1, avmState));
							}
						} else {
							if ((l32_t).equals("!=")) {
								if ((f_getVal(l37_v0)!=f_getVal(l38_v1))) {
									return (new Struct_Pair(l35_g0, avmState));
								} else {
									return (new Struct_Pair(l36_g1, avmState));
								}
							} else {
								if ((l32_t).equals(">")) {
									if ((f_getVal(l37_v0)>f_getVal(l38_v1))) {
										return (new Struct_Pair(l35_g0, avmState));
									} else {
										return (new Struct_Pair(l36_g1, avmState));
									}
								} else {
									if ((l32_t).equals("<")) {
										if ((f_getVal(l37_v0)<f_getVal(l38_v1))) {
											return (new Struct_Pair(l35_g0, avmState));
										} else {
											return (new Struct_Pair(l36_g1, avmState));
										}
									} else {
										runtime.m_runtime.f_println((("Unknown test: "+l32_t)+" !"));
										return (new Struct_Pair((new Object[] { (-1) }), avmState));
									}
								}
							}
						}
					}
				}
			}
		}
		case 0/*Access*/: {
			final Struct_Access l1__tmp = (Struct_Access)l0__tmp;
			final String l39_v = l1__tmp.f_var;
			final Struct l40_e = l1__tmp.f_expr;
			final int l41_g = l1__tmp.f_goto;
			final String l42_v = l1__tmp.f_var;
			final Struct l43_e = l1__tmp.f_expr;
			final int l44_g = l1__tmp.f_goto;
			if (runtime.m_tree.f_containsKeyTree(avmState, l42_v)) {
				final Struct l45_val = f_toInt(l43_e, avmState);
				if (runtime.m_maybe.f_isNone(l45_val)) {
					runtime.m_runtime.f_println((("Access expression value for var "+l42_v)+" is illegal!"));
					return (new Struct_Pair((new Object[] { (-1) }), avmState));
				} else {
					if (runtime.h_Native.isSameStructType((new Struct_VMArray(SingletonStructs.arr_empty)), l45_val)) {
						runtime.m_runtime.f_println((("Try to access array "+l42_v)+" as variable!"));
						return (new Struct_Pair((new Object[] { (-1) }), avmState));
					} else {
						final Struct l46_t = ((Func3<Struct,Struct, String, Struct>)(Func3)runtime.n_setTree).invoke(avmState, l42_v, (new Struct_VMInt(f_getVal(l45_val))));
						return (new Struct_Pair((new Object[] { l44_g }), l46_t));
					}
				}
			} else {
				runtime.m_runtime.f_println((("Variable "+l42_v)+" doesn't exists!"));
				return (new Struct_Pair((new Object[] { (-1) }), avmState));
			}
		}
		case 38/*IndexArrayAccess*/: {
			final Struct_IndexArrayAccess l1__tmp = (Struct_IndexArrayAccess)l0__tmp;
			final String l47_v = l1__tmp.f_var;
			final Struct l48_i = l1__tmp.f_index;
			final Struct l49_e = l1__tmp.f_expr;
			final int l50_g = l1__tmp.f_goto;
			final String l51_v = l1__tmp.f_var;
			final Struct l52_i = l1__tmp.f_index;
			final Struct l53_e = l1__tmp.f_expr;
			final int l54_g = l1__tmp.f_goto;
			if (runtime.m_tree.f_containsKeyTree(avmState, l51_v)) {
				final Struct l55_val = f_toInt(l53_e, avmState);
				final Struct l56_ind = f_toInt(l52_i, avmState);
				if ((runtime.m_maybe.f_isNone(l55_val)||runtime.m_maybe.f_isNone(l56_ind))) {
					runtime.m_runtime.f_println((("Access expression value for var "+l51_v)+" is illegal!"));
					return (new Struct_Pair((new Object[] { (-1) }), avmState));
				} else {
					final Object l57_var = runtime.m_maybe.f_either(((Func2<Struct,Struct, String>)(Func2)runtime.n_lookupTree).invoke(avmState, l51_v), (new Struct_VMArray(SingletonStructs.arr_empty)));
					if (!runtime.h_Native.isSameStructType((new Struct_VMArray(SingletonStructs.arr_empty)), l57_var)) {
						runtime.m_runtime.f_println((("Try to access variable "+l51_v)+" as array!"));
						return (new Struct_Pair((new Object[] { (-1) }), avmState));
					} else {
						final Struct_VMArray l58_arr = ((Struct_VMArray)((Struct)l57_var));
						final Struct_VMArray l59_arr1 = (new Struct_VMArray(runtime.h_Native.replace(l58_arr.f_a, f_getVal(l56_ind), f_getVal(l55_val))));
						final Struct l60_t = ((Func3<Struct,Struct, String, Struct>)(Func3)runtime.n_setTree).invoke(avmState, l51_v, l59_arr1);
						return (new Struct_Pair((new Object[] { l54_g }), l60_t));
					}
				}
			} else {
				runtime.m_runtime.f_println((("Variable "+l51_v)+" doesn't exists!"));
				return (new Struct_Pair((new Object[] { (-1) }), avmState));
			}
		}
		case 143/*VmPrint*/: {
			final Struct_VmPrint l1__tmp = (Struct_VmPrint)l0__tmp;
			final Struct l61_data = l1__tmp.f_data;
			final int l62_g = l1__tmp.f_goto;
			final Struct l63_data = l1__tmp.f_data;
			final int l64_g = l1__tmp.f_goto;
			Struct l65__tmp = l63_data;
			switch (l65__tmp.getTypeId()) {
			case 33/*ExpVar*/: {
				final Struct_ExpVar l66__tmp = (Struct_ExpVar)l65__tmp;
				final String l67_var = l66__tmp.f_var;
				final String l68_var = l66__tmp.f_var;
				final Struct l69_m0 = ((Func2<Struct,Struct, String>)(Func2)runtime.n_lookupTree).invoke(avmState, l68_var);
				Struct l70__tmp = l69_m0;
				switch (l70__tmp.getTypeId()) {
				case 128/*Some*/: {
					final Struct_Some l71__tmp = (Struct_Some)l70__tmp;
					final Object l72_val = l71__tmp.f_value;
					final Object l73_val = l71__tmp.f_value;
					if (runtime.h_Native.isSameStructType((new Struct_VMArray(SingletonStructs.arr_empty)), l73_val)) {
						final Object[] l74_arr = f_getArr(((Struct)l73_val));
						runtime.m_runtime.f_println(l74_arr);
						return (new Struct_Pair((new Object[] { l64_g }), avmState));
					} else {
						final Struct l75_val0 = f_toInt(l66__tmp, avmState);
						if (runtime.m_maybe.f_isNone(l75_val0)) {
							runtime.m_runtime.f_println((("Can't print value "+runtime.m_dynamic.f_toString(l66__tmp))+"!"));
							return (new Struct_Pair((new Object[] { (-1) }), avmState));
						} else {
							runtime.m_runtime.f_println(f_getVal(l75_val0));
							return (new Struct_Pair((new Object[] { l64_g }), avmState));
						}
					}
				}
				case 64/*None*/: {
					runtime.m_runtime.f_println((("Variable "+l68_var)+" doesn't exists!"));
					return (new Struct_Pair((new Object[] { (-1) }), avmState));
				}
				default:
					throw new RuntimeException("Unexpected struct in switch: "+l70__tmp.getTypeName());
				}
			}
			default: {
				final Struct l76_val = f_toInt(l63_data, avmState);
				if (runtime.m_maybe.f_isNone(l76_val)) {
					runtime.m_runtime.f_println((("Can't print value "+runtime.m_dynamic.f_toString(l63_data))+"!"));
					return (new Struct_Pair((new Object[] { (-1) }), avmState));
				} else {
					runtime.m_runtime.f_println(f_getVal(l76_val));
					return (new Struct_Pair((new Object[] { l64_g }), avmState));
				}
			}
			}
		}
		default:
			throw new RuntimeException("Unexpected struct in switch: "+l0__tmp.getTypeName());
		}
	}
	Object[] f_getArr(Struct at) {
		Struct l0__tmp = at;
		switch (l0__tmp.getTypeId()) {
		case 138/*VMInt*/: {
			final Struct_VMInt l1__tmp = (Struct_VMInt)l0__tmp;
			final int l2_i = l1__tmp.f_i;
			final int l3_i = l1__tmp.f_i;
			return SingletonStructs.arr_empty;
		}
		case 137/*VMArray*/: {
			final Struct_VMArray l1__tmp = (Struct_VMArray)l0__tmp;
			final Object[] l4_a = l1__tmp.f_a;
			final Object[] l5_a = l1__tmp.f_a;
			return l5_a;
		}
		default:
			throw new RuntimeException("Unexpected struct in switch: "+l0__tmp.getTypeName());
		}
	}
	int f_getIntVal(Struct at) {
		Struct l0__tmp = at;
		switch (l0__tmp.getTypeId()) {
		case 138/*VMInt*/: {
			final Struct_VMInt l1__tmp = (Struct_VMInt)l0__tmp;
			final int l2_i = l1__tmp.f_i;
			final int l3_i = l1__tmp.f_i;
			return l3_i;
		}
		case 137/*VMArray*/: {
			final Struct_VMArray l1__tmp = (Struct_VMArray)l0__tmp;
			final Object[] l4_a = l1__tmp.f_a;
			final Object[] l5_a = l1__tmp.f_a;
			return 0;
		}
		default:
			throw new RuntimeException("Unexpected struct in switch: "+l0__tmp.getTypeName());
		}
	}
	int f_getVal(Struct am0) {
		Struct l0__tmp = am0;
		switch (l0__tmp.getTypeId()) {
		case 128/*Some*/: {
			final Struct_Some l1__tmp = (Struct_Some)l0__tmp;
			final Object l2_i = l1__tmp.f_value;
			final int l3_i = ((int)l1__tmp.f_value);
			return l3_i;
		}
		case 64/*None*/: {
			return (-1);
		}
		default:
			throw new RuntimeException("Unexpected struct in switch: "+l0__tmp.getTypeName());
		}
	}
	int f_loopExecution(int aindex, Struct as, Struct avmState) {
		final Struct l0_gsymswitch0 = ((Func2<Struct,Struct, Integer>)(Func2)runtime.n_lookupTree).invoke(as, ((Integer)aindex));
		Struct l1__tmp = l0_gsymswitch0;
		switch (l1__tmp.getTypeId()) {
		case 64/*None*/: {
			return (-2);
		}
		case 128/*Some*/: {
			final Struct_Some l2__tmp = (Struct_Some)l1__tmp;
			final Object l3_com = l2__tmp.f_value;
			final Struct l4_com = ((Struct)l2__tmp.f_value);
			final Struct_Pair l5_status = f_execVMCommand(l4_com, avmState);
			if ((((int)(((Object[])l5_status.f_first)[0]))==(-1))) {
				runtime.m_runtime.f_println((("Execution of command with label "+runtime.m_string.f_i2s(aindex))+" ends with error!"));
				return (-1);
			} else {
				if ((((int)(((Object[])l5_status.f_first)[0]))==(-3))) {
					return (-3);
				} else {
					final Object[] l8_$7 = ((Object[])l5_status.f_first);
					final Struct l10_s = as;
					final Func2<Integer,Integer, Integer> l9_$6 = new Func2<Integer,Integer,Integer>() {
						final public Integer invoke(final Integer aacc, final Integer aval) {
							if (((((int)aacc)==(-1))||(((int)aacc)==(-2)))) {
								return aacc;
							} else {
								return ((Integer)f_loopExecution(((int)aval), l10_s, ((Struct)l5_status.f_second)));
							}
						}
					};
					return ((int)runtime.h_Native.fold(l8_$7, 0, ((Func2<Object,Object, Object>)(Func2)l9_$6)));
				}
			}
		}
		default:
			throw new RuntimeException("Unexpected struct in switch: "+l1__tmp.getTypeName());
		}
	}
	Struct f_toInt(Struct at, Struct avmState) {
		Struct l0__tmp = at;
		switch (l0__tmp.getTypeId()) {
		case 130/*Sum*/: {
			final Struct_Sum l1__tmp = (Struct_Sum)l0__tmp;
			final Struct l2_l = l1__tmp.f_l;
			final Struct l3_r = l1__tmp.f_r;
			final Struct l4_l = l1__tmp.f_l;
			final Struct l5_r = l1__tmp.f_r;
			final Struct l6_m0 = f_toInt(l4_l, avmState);
			final Struct l7_m1 = f_toInt(l5_r, avmState);
			if ((runtime.m_maybe.f_isNone(l6_m0)||runtime.m_maybe.f_isNone(l7_m1))) {
				return ((Struct)SingletonStructs.str_None);
			} else {
				return (new Struct_Some((f_getVal(l6_m0)+f_getVal(l7_m1))));
			}
		}
		case 60/*Min*/: {
			final Struct_Min l1__tmp = (Struct_Min)l0__tmp;
			final Struct l8_l = l1__tmp.f_l;
			final Struct l9_r = l1__tmp.f_r;
			final Struct l10_l = l1__tmp.f_l;
			final Struct l11_r = l1__tmp.f_r;
			final Struct l12_m0 = f_toInt(l10_l, avmState);
			final Struct l13_m1 = f_toInt(l11_r, avmState);
			if ((runtime.m_maybe.f_isNone(l12_m0)||runtime.m_maybe.f_isNone(l13_m1))) {
				return ((Struct)SingletonStructs.str_None);
			} else {
				return (new Struct_Some((f_getVal(l12_m0)-f_getVal(l13_m1))));
			}
		}
		case 24/*Div*/: {
			final Struct_Div l1__tmp = (Struct_Div)l0__tmp;
			final Struct l14_up = l1__tmp.f_up;
			final Struct l15_down = l1__tmp.f_down;
			final Struct l16_up = l1__tmp.f_up;
			final Struct l17_down = l1__tmp.f_down;
			final Struct l18_m0 = f_toInt(l16_up, avmState);
			final Struct l19_m1 = f_toInt(l17_down, avmState);
			if ((runtime.m_maybe.f_isNone(l18_m0)||runtime.m_maybe.f_isNone(l19_m1))) {
				return ((Struct)SingletonStructs.str_None);
			} else {
				return (new Struct_Some((f_getVal(l18_m0)/f_getVal(l19_m1))));
			}
		}
		case 61/*Mult*/: {
			final Struct_Mult l1__tmp = (Struct_Mult)l0__tmp;
			final Struct l20_l = l1__tmp.f_l;
			final Struct l21_r = l1__tmp.f_r;
			final Struct l22_l = l1__tmp.f_l;
			final Struct l23_r = l1__tmp.f_r;
			final Struct l24_m0 = f_toInt(l22_l, avmState);
			final Struct l25_m1 = f_toInt(l23_r, avmState);
			if ((runtime.m_maybe.f_isNone(l24_m0)||runtime.m_maybe.f_isNone(l25_m1))) {
				return ((Struct)SingletonStructs.str_None);
			} else {
				return (new Struct_Some((f_getVal(l24_m0)*f_getVal(l25_m1))));
			}
		}
		case 32/*ExpInt*/: {
			final Struct_ExpInt l1__tmp = (Struct_ExpInt)l0__tmp;
			final int l26_val = l1__tmp.f_val;
			final int l27_val = l1__tmp.f_val;
			return (new Struct_Some(l27_val));
		}
		case 33/*ExpVar*/: {
			final Struct_ExpVar l1__tmp = (Struct_ExpVar)l0__tmp;
			final String l28_var = l1__tmp.f_var;
			final String l29_var = l1__tmp.f_var;
			final Struct l30_m0 = ((Func2<Struct,Struct, String>)(Func2)runtime.n_lookupTree).invoke(avmState, l29_var);
			Struct l31__tmp = l30_m0;
			switch (l31__tmp.getTypeId()) {
			case 128/*Some*/: {
				final Struct_Some l32__tmp = (Struct_Some)l31__tmp;
				final Object l33_val = l32__tmp.f_value;
				final Object l34_val = l32__tmp.f_value;
				if (runtime.h_Native.isSameStructType((new Struct_VMArray(SingletonStructs.arr_empty)), l34_val)) {
					runtime.m_runtime.f_println((("Try to get array "+l29_var)+" as operand!"));
					return ((Struct)SingletonStructs.str_None);
				} else {
					return (new Struct_Some(f_getIntVal(((Struct)l34_val))));
				}
			}
			case 64/*None*/: {
				runtime.m_runtime.f_println((("Variable "+l29_var)+" doesn't exists!"));
				return ((Struct)SingletonStructs.str_None);
			}
			default:
				throw new RuntimeException("Unexpected struct in switch: "+l31__tmp.getTypeName());
			}
		}
		case 31/*ExpArrayAccess*/: {
			final Struct_ExpArrayAccess l1__tmp = (Struct_ExpArrayAccess)l0__tmp;
			final String l35_var = l1__tmp.f_var;
			final Struct l36_i = l1__tmp.f_index;
			final String l37_var = l1__tmp.f_var;
			final Struct l38_i = l1__tmp.f_index;
			final Struct l39_m0 = ((Func2<Struct,Struct, String>)(Func2)runtime.n_lookupTree).invoke(avmState, l37_var);
			final Struct l40_ind = f_toInt(l38_i, avmState);
			if (runtime.m_maybe.f_isNone(l40_ind)) {
				return ((Struct)SingletonStructs.str_None);
			} else {
				final int l41_indVal = f_getVal(l40_ind);
				Struct l42__tmp = l39_m0;
				switch (l42__tmp.getTypeId()) {
				case 128/*Some*/: {
					final Struct_Some l43__tmp = (Struct_Some)l42__tmp;
					final Object l44_val = l43__tmp.f_value;
					final Object l45_val = l43__tmp.f_value;
					if (runtime.h_Native.isSameStructType((new Struct_VMArray(SingletonStructs.arr_empty)), l45_val)) {
						final Object[] l46_arr = f_getArr(((Struct)l45_val));
						if (((l41_indVal>=runtime.h_Native.length(l46_arr))||(l41_indVal<0))) {
							runtime.m_runtime.f_println(((((("Index out of bounds for array "+l37_var)+": arr size ")+runtime.m_string.f_i2s(runtime.h_Native.length(l46_arr)))+" vs ")+runtime.m_string.f_i2s(l41_indVal)));
							return ((Struct)SingletonStructs.str_None);
						} else {
							return (new Struct_Some(((Integer)(l46_arr[l41_indVal]))));
						}
					} else {
						runtime.m_runtime.f_println((("Try to access to non array var "+l37_var)+"!"));
						return ((Struct)SingletonStructs.str_None);
					}
				}
				case 64/*None*/: {
					runtime.m_runtime.f_println((("Variable "+l37_var)+" doesn't exists!"));
					return ((Struct)SingletonStructs.str_None);
				}
				default:
					throw new RuntimeException("Unexpected struct in switch: "+l42__tmp.getTypeName());
				}
			}
		}
		default: {
			return ((Struct)SingletonStructs.str_None);
		}
		}
	}
}
