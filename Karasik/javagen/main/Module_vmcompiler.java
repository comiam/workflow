// HASH COLLISIONS: YES
// timestamp: 1.608021666E12

package main;

import com.area9innovation.flow.*;

@SuppressWarnings("unchecked")
final class Module_vmcompiler {
	final main runtime;
	Module_vmcompiler(main runtime) {
		this.runtime = runtime;
	}
	Struct f_compile(Struct_ProgramSequence aps) {
		final Struct_Pair l0_p = runtime.m_validator.f_checkStructure(aps);
		if (!((boolean)l0_p.f_first)) {
			runtime.m_runtime.f_println(l0_p.f_second);
			return runtime.m_tree.f_makeTree();
		} else {
			return f_translateToVMCode(aps);
		}
	}
	Struct_VMArray f_createArray(Struct_Array aa, Object[] aacc) {
	 TAIL_CALL: for(;;) {
		if ((runtime.h_Native.length(aacc)==aa.f_size)) {
			return (new Struct_VMArray(aacc));
		} else {
			{
				final Object[] l0___tmp = runtime.h_Native.concat(aacc, (new Object[] { 0 }));
				aacc = l0___tmp;
				continue TAIL_CALL;
			}
		}
	 }
	}
	String f_expr2s(Struct ae) {
		Struct l0__tmp = ae;
		switch (l0__tmp.getTypeId()) {
		case 24/*Div*/: {
			final Struct_Div l1__tmp = (Struct_Div)l0__tmp;
			final Struct l2_up = l1__tmp.f_up;
			final Struct l3_down = l1__tmp.f_down;
			final Struct l4_up = l1__tmp.f_up;
			final Struct l5_down = l1__tmp.f_down;
			return runtime.m_string.f_concatStrings((new Object[] { "(", f_expr2s(l4_up), " / ", f_expr2s(l5_down), ")" }));
		}
		case 60/*Min*/: {
			final Struct_Min l1__tmp = (Struct_Min)l0__tmp;
			final Struct l6_l = l1__tmp.f_l;
			final Struct l7_r = l1__tmp.f_r;
			final Struct l8_l = l1__tmp.f_l;
			final Struct l9_r = l1__tmp.f_r;
			return runtime.m_string.f_concatStrings((new Object[] { "(", f_expr2s(l8_l), " - ", f_expr2s(l9_r), ")" }));
		}
		case 130/*Sum*/: {
			final Struct_Sum l1__tmp = (Struct_Sum)l0__tmp;
			final Struct l10_l = l1__tmp.f_l;
			final Struct l11_r = l1__tmp.f_r;
			final Struct l12_l = l1__tmp.f_l;
			final Struct l13_r = l1__tmp.f_r;
			return runtime.m_string.f_concatStrings((new Object[] { "(", f_expr2s(l12_l), " + ", f_expr2s(l13_r), ")" }));
		}
		case 61/*Mult*/: {
			final Struct_Mult l1__tmp = (Struct_Mult)l0__tmp;
			final Struct l14_l = l1__tmp.f_l;
			final Struct l15_r = l1__tmp.f_r;
			final Struct l16_l = l1__tmp.f_l;
			final Struct l17_r = l1__tmp.f_r;
			return runtime.m_string.f_concatStrings((new Object[] { "(", f_expr2s(l16_l), " * ", f_expr2s(l17_r), ")" }));
		}
		case 32/*ExpInt*/: {
			final Struct_ExpInt l1__tmp = (Struct_ExpInt)l0__tmp;
			final int l18_val = l1__tmp.f_val;
			final int l19_val = l1__tmp.f_val;
			return runtime.m_string.f_i2s(l19_val);
		}
		case 33/*ExpVar*/: {
			final Struct_ExpVar l1__tmp = (Struct_ExpVar)l0__tmp;
			final String l20_var = l1__tmp.f_var;
			final String l21_var = l1__tmp.f_var;
			return l21_var;
		}
		case 31/*ExpArrayAccess*/: {
			final Struct_ExpArrayAccess l1__tmp = (Struct_ExpArrayAccess)l0__tmp;
			final String l22_arr = l1__tmp.f_var;
			final Struct l23_ind = l1__tmp.f_index;
			final String l24_arr = l1__tmp.f_var;
			final Struct l25_ind = l1__tmp.f_index;
			return runtime.m_string.f_concatStrings((new Object[] { l24_arr, "[", f_expr2s(l25_ind), "]" }));
		}
		default:
			throw new RuntimeException("Unexpected struct in switch: "+l0__tmp.getTypeName());
		}
	}
	int f_findMaxStamp(Struct avm) {
		Struct l0__tmp = avm;
		switch (l0__tmp.getTypeId()) {
		case 39/*InitVar*/: {
			final Struct_InitVar l1__tmp = (Struct_InitVar)l0__tmp;
			final String l2_v = l1__tmp.f_v;
			final Struct l3_e = l1__tmp.f_e;
			final int l4_goto = l1__tmp.f_goto;
			final String l5_v = l1__tmp.f_v;
			final Struct l6_e = l1__tmp.f_e;
			final int l7_goto = l1__tmp.f_goto;
			return l7_goto;
		}
		case 0/*Access*/: {
			final Struct_Access l1__tmp = (Struct_Access)l0__tmp;
			final String l8_var = l1__tmp.f_var;
			final Struct l9_expr = l1__tmp.f_expr;
			final int l10_goto = l1__tmp.f_goto;
			final String l11_var = l1__tmp.f_var;
			final Struct l12_expr = l1__tmp.f_expr;
			final int l13_goto = l1__tmp.f_goto;
			return l13_goto;
		}
		case 38/*IndexArrayAccess*/: {
			final Struct_IndexArrayAccess l1__tmp = (Struct_IndexArrayAccess)l0__tmp;
			final String l14_var = l1__tmp.f_var;
			final Struct l15_index = l1__tmp.f_index;
			final Struct l16_val = l1__tmp.f_expr;
			final int l17_goto = l1__tmp.f_goto;
			final String l18_var = l1__tmp.f_var;
			final Struct l19_index = l1__tmp.f_index;
			final Struct l20_val = l1__tmp.f_expr;
			final int l21_goto = l1__tmp.f_goto;
			return l21_goto;
		}
		case 20/*Condition*/: {
			final Struct_Condition l1__tmp = (Struct_Condition)l0__tmp;
			final String l22_test = l1__tmp.f_test;
			final Struct l23_expr0 = l1__tmp.f_expr0;
			final Struct l24_expr1 = l1__tmp.f_expr1;
			final Object[] l25_gotoTrue = l1__tmp.f_gotoTrue;
			final Object[] l26_gotoFalse = l1__tmp.f_gotoFalse;
			final String l27_test = l1__tmp.f_test;
			final Struct l28_expr0 = l1__tmp.f_expr0;
			final Struct l29_expr1 = l1__tmp.f_expr1;
			final Object[] l30_gotoTrue = l1__tmp.f_gotoTrue;
			final Object[] l31_gotoFalse = l1__tmp.f_gotoFalse;
			if ((runtime.h_Native.length(l30_gotoTrue)==2)) {
				return ((int)((Func2<Integer,Integer, Integer>)(Func2)runtime.n_max).invoke(((Func2<Integer,Integer, Integer>)(Func2)runtime.n_max).invoke(((Integer)(l30_gotoTrue[0])), ((Integer)(l30_gotoTrue[1]))), ((Integer)(l31_gotoFalse[0]))));
			} else {
				return ((int)((Func2<Integer,Integer, Integer>)(Func2)runtime.n_max).invoke(((Integer)(l30_gotoTrue[0])), ((Integer)(l31_gotoFalse[0]))));
			}
		}
		case 143/*VmPrint*/: {
			final Struct_VmPrint l1__tmp = (Struct_VmPrint)l0__tmp;
			final Struct l32_data = l1__tmp.f_data;
			final int l33_goto = l1__tmp.f_goto;
			final Struct l34_data = l1__tmp.f_data;
			final int l35_goto = l1__tmp.f_goto;
			return l35_goto;
		}
		default:
			throw new RuntimeException("Unexpected struct in switch: "+l0__tmp.getTypeName());
		}
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
	String f_obj2s(Struct ao) {
		Struct l0__tmp = ao;
		switch (l0__tmp.getTypeId()) {
		case 137/*VMArray*/: {
			final Struct_VMArray l1__tmp = (Struct_VMArray)l0__tmp;
			final Object[] l2_a = l1__tmp.f_a;
			final Object[] l3_a = l1__tmp.f_a;
			return "[int]";
		}
		case 138/*VMInt*/: {
			final Struct_VMInt l1__tmp = (Struct_VMInt)l0__tmp;
			final int l4_i = l1__tmp.f_i;
			final int l5_i = l1__tmp.f_i;
			return "int";
		}
		case 130/*Sum*/: {
			final Struct_Sum l1__tmp = (Struct_Sum)l0__tmp;
			return f_expr2s(l1__tmp);
		}
		case 60/*Min*/: {
			final Struct_Min l1__tmp = (Struct_Min)l0__tmp;
			return f_expr2s(l1__tmp);
		}
		case 24/*Div*/: {
			final Struct_Div l1__tmp = (Struct_Div)l0__tmp;
			return f_expr2s(l1__tmp);
		}
		case 61/*Mult*/: {
			final Struct_Mult l1__tmp = (Struct_Mult)l0__tmp;
			return f_expr2s(l1__tmp);
		}
		case 32/*ExpInt*/: {
			final Struct_ExpInt l1__tmp = (Struct_ExpInt)l0__tmp;
			return f_expr2s(l1__tmp);
		}
		case 33/*ExpVar*/: {
			final Struct_ExpVar l1__tmp = (Struct_ExpVar)l0__tmp;
			return f_expr2s(l1__tmp);
		}
		case 31/*ExpArrayAccess*/: {
			final Struct_ExpArrayAccess l1__tmp = (Struct_ExpArrayAccess)l0__tmp;
			return f_expr2s(l1__tmp);
		}
		default:
			throw new RuntimeException("Unexpected struct in switch: "+l0__tmp.getTypeName());
		}
	}
	Struct f_plusStamp(Struct avm, int aval) {
		Struct l0__tmp = avm;
		switch (l0__tmp.getTypeId()) {
		case 39/*InitVar*/: {
			final Struct_InitVar l1__tmp = (Struct_InitVar)l0__tmp;
			final String l2_v = l1__tmp.f_v;
			final Struct l3_e = l1__tmp.f_e;
			final int l4_goto = l1__tmp.f_goto;
			final String l5_v = l1__tmp.f_v;
			final Struct l6_e = l1__tmp.f_e;
			final int l7_goto = l1__tmp.f_goto;
			return (new Struct_InitVar(l5_v, l6_e, (l7_goto+aval)));
		}
		case 0/*Access*/: {
			final Struct_Access l1__tmp = (Struct_Access)l0__tmp;
			final String l8_var = l1__tmp.f_var;
			final Struct l9_expr = l1__tmp.f_expr;
			final int l10_goto = l1__tmp.f_goto;
			final String l11_var = l1__tmp.f_var;
			final Struct l12_expr = l1__tmp.f_expr;
			final int l13_goto = l1__tmp.f_goto;
			return (new Struct_Access(l11_var, l12_expr, (l13_goto+aval)));
		}
		case 38/*IndexArrayAccess*/: {
			final Struct_IndexArrayAccess l1__tmp = (Struct_IndexArrayAccess)l0__tmp;
			final String l14_var = l1__tmp.f_var;
			final Struct l15_index = l1__tmp.f_index;
			final Struct l16_val0 = l1__tmp.f_expr;
			final int l17_goto = l1__tmp.f_goto;
			final String l18_var = l1__tmp.f_var;
			final Struct l19_index = l1__tmp.f_index;
			final Struct l20_val0 = l1__tmp.f_expr;
			final int l21_goto = l1__tmp.f_goto;
			return (new Struct_IndexArrayAccess(l18_var, l19_index, l20_val0, (l21_goto+aval)));
		}
		case 20/*Condition*/: {
			final Struct_Condition l1__tmp = (Struct_Condition)l0__tmp;
			final String l22_test = l1__tmp.f_test;
			final Struct l23_expr0 = l1__tmp.f_expr0;
			final Struct l24_expr1 = l1__tmp.f_expr1;
			final Object[] l25_gotoTrue = l1__tmp.f_gotoTrue;
			final Object[] l26_gotoFalse = l1__tmp.f_gotoFalse;
			final String l27_test = l1__tmp.f_test;
			final Struct l28_expr0 = l1__tmp.f_expr0;
			final Struct l29_expr1 = l1__tmp.f_expr1;
			final Object[] l30_gotoTrue = l1__tmp.f_gotoTrue;
			final Object[] l31_gotoFalse = l1__tmp.f_gotoFalse;
			final int l34_val = aval;
			final Func1<Integer,Integer> l33_$32 = new Func1<Integer,Integer>() {
				final public Integer invoke(final Integer av) {
					return ((Integer)(((int)av)+l34_val));
				}
			};
			return (new Struct_Condition(l27_test, l28_expr0, l29_expr1, runtime.h_Native.map(l30_gotoTrue, ((Func1<Object,Object>)(Func1)l33_$32)), l31_gotoFalse));
		}
		case 143/*VmPrint*/: {
			final Struct_VmPrint l1__tmp = (Struct_VmPrint)l0__tmp;
			final Struct l35_data = l1__tmp.f_data;
			final int l36_goto = l1__tmp.f_goto;
			final Struct l37_data = l1__tmp.f_data;
			final int l38_goto = l1__tmp.f_goto;
			return (new Struct_VmPrint(l37_data, (l38_goto+aval)));
		}
		default:
			throw new RuntimeException("Unexpected struct in switch: "+l0__tmp.getTypeName());
		}
	}
	Object f_printVM(Struct aprog) {
		final Func3<Integer,Integer, Struct, Integer> l1_$0 = new Func3<Integer,Integer,Struct,Integer>() {
			final public Integer invoke(final Integer aval, final Struct akey, final Integer aacc) {
				Struct l0__tmp = akey;
				switch (l0__tmp.getTypeId()) {
				case 39/*InitVar*/: {
					final Struct_InitVar l1__tmp = (Struct_InitVar)l0__tmp;
					final String l2_v = l1__tmp.f_v;
					final Struct l3_e = l1__tmp.f_e;
					final int l4_goto = l1__tmp.f_goto;
					final String l5_v = l1__tmp.f_v;
					final Struct l6_e = l1__tmp.f_e;
					final int l7_goto = l1__tmp.f_goto;
					runtime.m_runtime.f_println((((((((runtime.m_string.f_i2s(((int)aval))+": ")+"init_var ")+l5_v)+" = ")+f_obj2s(l6_e))+" goto ")+runtime.m_string.f_i2s(l7_goto)));
					break;
				}
				case 0/*Access*/: {
					final Struct_Access l1__tmp = (Struct_Access)l0__tmp;
					final String l8_var = l1__tmp.f_var;
					final Struct l9_expr = l1__tmp.f_expr;
					final int l10_goto = l1__tmp.f_goto;
					final String l11_var = l1__tmp.f_var;
					final Struct l12_expr = l1__tmp.f_expr;
					final int l13_goto = l1__tmp.f_goto;
					runtime.m_runtime.f_println(((((((runtime.m_string.f_i2s(((int)aval))+": ")+l11_var)+" = ")+f_obj2s(l12_expr))+" goto ")+runtime.m_string.f_i2s(l13_goto)));
					break;
				}
				case 38/*IndexArrayAccess*/: {
					final Struct_IndexArrayAccess l1__tmp = (Struct_IndexArrayAccess)l0__tmp;
					final String l14_var = l1__tmp.f_var;
					final Struct l15_index = l1__tmp.f_index;
					final Struct l16_expr = l1__tmp.f_expr;
					final int l17_goto = l1__tmp.f_goto;
					final String l18_var = l1__tmp.f_var;
					final Struct l19_index = l1__tmp.f_index;
					final Struct l20_expr = l1__tmp.f_expr;
					final int l21_goto = l1__tmp.f_goto;
					runtime.m_runtime.f_println(((((((((runtime.m_string.f_i2s(((int)aval))+": ")+l18_var)+"[")+f_obj2s(l19_index))+"] = ")+f_obj2s(l20_expr))+" goto ")+runtime.m_string.f_i2s(l21_goto)));
					break;
				}
				case 20/*Condition*/: {
					final Struct_Condition l1__tmp = (Struct_Condition)l0__tmp;
					final String l22_test = l1__tmp.f_test;
					final Struct l23_expr0 = l1__tmp.f_expr0;
					final Struct l24_expr1 = l1__tmp.f_expr1;
					final Object[] l25_gotoTrue = l1__tmp.f_gotoTrue;
					final Object[] l26_gotoFalse = l1__tmp.f_gotoFalse;
					final String l27_test = l1__tmp.f_test;
					final Struct l28_expr0 = l1__tmp.f_expr0;
					final Struct l29_expr1 = l1__tmp.f_expr1;
					final Object[] l30_gotoTrue = l1__tmp.f_gotoTrue;
					final Object[] l31_gotoFalse = l1__tmp.f_gotoFalse;
					runtime.m_runtime.f_println(((((((((((runtime.m_string.f_i2s(((int)aval))+": if(")+f_obj2s(l28_expr0))+" ")+l27_test)+" ")+f_obj2s(l29_expr1))+") then goto ")+runtime.m_dynamic.f_toString(l30_gotoTrue))+" else ")+runtime.m_dynamic.f_toString(l31_gotoFalse)));
					break;
				}
				case 143/*VmPrint*/: {
					final Struct_VmPrint l1__tmp = (Struct_VmPrint)l0__tmp;
					final Struct l32_data = l1__tmp.f_data;
					final int l33_goto = l1__tmp.f_goto;
					final Struct l34_data = l1__tmp.f_data;
					final int l35_goto = l1__tmp.f_goto;
					runtime.m_runtime.f_println(((((runtime.m_string.f_i2s(((int)aval))+": print(")+f_obj2s(l34_data))+") goto ")+runtime.m_string.f_i2s(l35_goto)));
					break;
				}
				default:
					throw new RuntimeException("Unexpected struct in switch: "+l0__tmp.getTypeName());
				}
				return ((Integer)0);
			}
		};
		final int l2_ind = ((int)runtime.m_tree.f_foldTree(aprog, 0, ((Func3<Object,Object, Object, Object>)(Func3)l1_$0)));
		return null;
	}
	Struct f_replaceStampInCommand(Struct avm, int afindSt, int arepl) {
		Struct l0__tmp = avm;
		switch (l0__tmp.getTypeId()) {
		case 39/*InitVar*/: {
			final Struct_InitVar l1__tmp = (Struct_InitVar)l0__tmp;
			final String l2_v = l1__tmp.f_v;
			final Struct l3_e = l1__tmp.f_e;
			final int l4_goto = l1__tmp.f_goto;
			final String l5_v = l1__tmp.f_v;
			final Struct l6_e = l1__tmp.f_e;
			final int l7_goto = l1__tmp.f_goto;
			if ((l7_goto==afindSt)) {
				return (new Struct_InitVar(l5_v, l6_e, arepl));
			} else {
				return l1__tmp;
			}
		}
		case 0/*Access*/: {
			final Struct_Access l1__tmp = (Struct_Access)l0__tmp;
			final String l8_var = l1__tmp.f_var;
			final Struct l9_expr = l1__tmp.f_expr;
			final int l10_goto = l1__tmp.f_goto;
			final String l11_var = l1__tmp.f_var;
			final Struct l12_expr = l1__tmp.f_expr;
			final int l13_goto = l1__tmp.f_goto;
			if ((l13_goto==afindSt)) {
				return (new Struct_Access(l11_var, l12_expr, arepl));
			} else {
				return l1__tmp;
			}
		}
		case 38/*IndexArrayAccess*/: {
			final Struct_IndexArrayAccess l1__tmp = (Struct_IndexArrayAccess)l0__tmp;
			final String l14_var = l1__tmp.f_var;
			final Struct l15_index = l1__tmp.f_index;
			final Struct l16_val = l1__tmp.f_expr;
			final int l17_goto = l1__tmp.f_goto;
			final String l18_var = l1__tmp.f_var;
			final Struct l19_index = l1__tmp.f_index;
			final Struct l20_val = l1__tmp.f_expr;
			final int l21_goto = l1__tmp.f_goto;
			if ((l21_goto==afindSt)) {
				return (new Struct_IndexArrayAccess(l18_var, l19_index, l20_val, arepl));
			} else {
				return l1__tmp;
			}
		}
		case 20/*Condition*/: {
			final Struct_Condition l1__tmp = (Struct_Condition)l0__tmp;
			final String l22_test = l1__tmp.f_test;
			final Struct l23_expr0 = l1__tmp.f_expr0;
			final Struct l24_expr1 = l1__tmp.f_expr1;
			final Object[] l25_gotoTrue = l1__tmp.f_gotoTrue;
			final Object[] l26_gotoFalse = l1__tmp.f_gotoFalse;
			final String l27_test = l1__tmp.f_test;
			final Struct l28_expr0 = l1__tmp.f_expr0;
			final Struct l29_expr1 = l1__tmp.f_expr1;
			final Object[] l30_gotoTrue = l1__tmp.f_gotoTrue;
			final Object[] l31_gotoFalse = l1__tmp.f_gotoFalse;
			final int l36_findSt = afindSt;
			final int l37_repl = arepl;
			final Func1<Integer,Integer> l35_$32 = new Func1<Integer,Integer>() {
				final public Integer invoke(final Integer av) {
					if ((((int)av)==l36_findSt)) {
						return ((Integer)l37_repl);
					} else {
						return av;
					}
				}
			};
			final Object[] l38_$34 = runtime.h_Native.map(l30_gotoTrue, ((Func1<Object,Object>)(Func1)l35_$32));
			final int l40_findSt = afindSt;
			final int l41_repl = arepl;
			final Func1<Integer,Integer> l39_$33 = new Func1<Integer,Integer>() {
				final public Integer invoke(final Integer av) {
					if ((((int)av)==l40_findSt)) {
						return ((Integer)l41_repl);
					} else {
						return av;
					}
				}
			};
			return (new Struct_Condition(l27_test, l28_expr0, l29_expr1, l38_$34, runtime.h_Native.map(l31_gotoFalse, ((Func1<Object,Object>)(Func1)l39_$33))));
		}
		case 143/*VmPrint*/: {
			final Struct_VmPrint l1__tmp = (Struct_VmPrint)l0__tmp;
			final Struct l42_data = l1__tmp.f_data;
			final int l43_goto = l1__tmp.f_goto;
			final Struct l44_data = l1__tmp.f_data;
			final int l45_goto = l1__tmp.f_goto;
			if ((l45_goto==afindSt)) {
				return (new Struct_VmPrint(l44_data, arepl));
			} else {
				return l1__tmp;
			}
		}
		default:
			throw new RuntimeException("Unexpected struct in switch: "+l0__tmp.getTypeName());
		}
	}
	Struct f_translateCommand(Struct acom) {
	 TAIL_CALL: for(;;) {
		final Func1<Integer,Struct> l0_selectMax = new Func1<Integer,Struct>() {
			final public Integer invoke(final Struct atr) {
				final Func3<Integer,Integer, Struct, Integer> l1_$0 = new Func3<Integer,Integer,Struct,Integer>() {
					final public Integer invoke(final Integer astamp, final Struct aval, final Integer aacc) {
						if ((((int)((Func2<Integer,Integer, Integer>)(Func2)runtime.n_max).invoke(((Integer)f_findMaxStamp(aval)), astamp))>((int)aacc))) {
							return ((Func2<Integer,Integer, Integer>)(Func2)runtime.n_max).invoke(((Integer)f_findMaxStamp(aval)), astamp);
						} else {
							return aacc;
						}
					}
				};
				return ((Integer)runtime.m_tree.f_foldTree(atr, runtime.m_math.g_intMin, ((Func3<Object,Object, Object, Object>)(Func3)l1_$0)));
			}
		};
		final Func2<Struct,Struct, Integer> l1_plusSet = new Func2<Struct,Struct,Integer>() {
			final public Struct invoke(final Struct atr, final Integer avalPlus) {
				final Struct l2_$1 = runtime.m_tree.f_makeTree();
				final Func3<Struct,Integer, Struct, Struct> l3_$0 = new Func3<Struct,Integer,Struct,Struct>() {
					final public Struct invoke(final Integer astamp, final Struct av, final Struct aacc) {
						return ((Func3<Struct,Struct, Integer, Struct>)(Func3)runtime.n_setTree).invoke(aacc, ((Integer)(((int)astamp)+((int)avalPlus))), f_plusStamp(av, ((int)avalPlus)));
					}
				};
				return ((Struct)runtime.m_tree.f_foldTree(atr, l2_$1, ((Func3<Object,Object, Object, Object>)(Func3)l3_$0)));
			}
		};
		final Func3<Struct,Struct, Integer, Integer> l2_replaceStamp = new Func3<Struct,Struct,Integer,Integer>() {
			final public Struct invoke(final Struct atr, final Integer af, final Integer arepl) {
				final Struct l2_$1 = runtime.m_tree.f_makeTree();
				final Func3<Struct,Integer, Struct, Struct> l3_$0 = new Func3<Struct,Integer,Struct,Struct>() {
					final public Struct invoke(final Integer astamp, final Struct av, final Struct aacc) {
						final Struct l0_newv = f_replaceStampInCommand(av, ((int)af), ((int)arepl));
						if ((((int)af)==((int)astamp))) {
							return ((Func3<Struct,Struct, Integer, Struct>)(Func3)runtime.n_setTree).invoke(aacc, arepl, l0_newv);
						} else {
							return ((Func3<Struct,Struct, Integer, Struct>)(Func3)runtime.n_setTree).invoke(aacc, astamp, l0_newv);
						}
					}
				};
				return ((Struct)runtime.m_tree.f_foldTree(atr, l2_$1, ((Func3<Object,Object, Object, Object>)(Func3)l3_$0)));
			}
		};
		Struct l3__tmp = acom;
		switch (l3__tmp.getTypeId()) {
		case 141/*VarRedefine*/: {
			final Struct_VarRedefine l4__tmp = (Struct_VarRedefine)l3__tmp;
			final String l5_name = l4__tmp.f_name;
			final Struct l6_value = l4__tmp.f_value;
			final String l7_name = l4__tmp.f_name;
			final Struct l8_value = l4__tmp.f_value;
			return runtime.m_tree.f_makeTree1(0, (new Struct_Access(l7_name, f_tv2vme(l8_value), 1)));
		}
		case 139/*VarArrayRedefine*/: {
			final Struct_VarArrayRedefine l4__tmp = (Struct_VarArrayRedefine)l3__tmp;
			final String l9_name = l4__tmp.f_name;
			final Struct l10_index = l4__tmp.f_index;
			final Struct l11_value = l4__tmp.f_value;
			final String l12_name = l4__tmp.f_name;
			final Struct l13_index = l4__tmp.f_index;
			final Struct l14_value = l4__tmp.f_value;
			return runtime.m_tree.f_makeTree1(0, (new Struct_IndexArrayAccess(l12_name, f_tv2vme(l13_index), f_tv2vme(l14_value), 1)));
		}
		case 132/*Test*/: {
			final Struct_Test l4__tmp = (Struct_Test)l3__tmp;
			final String l15_test = l4__tmp.f_test;
			final Struct l16_f = l4__tmp.f_f;
			final Struct l17_s = l4__tmp.f_s;
			final String l18_test = l4__tmp.f_test;
			final Struct l19_f = l4__tmp.f_f;
			final Struct l20_s = l4__tmp.f_s;
			return runtime.m_tree.f_makeTree1(0, (new Struct_Condition(l18_test, f_tv2vme(l19_f), f_tv2vme(l20_s), (new Object[] { 1 }), (new Object[] { runtime.m_vmtypes.g_emptyTree }))));
		}
		case 117/*Print*/: {
			final Struct_Print l4__tmp = (Struct_Print)l3__tmp;
			final Struct l21_data = l4__tmp.f_data;
			final Struct l22_data = l4__tmp.f_data;
			return runtime.m_tree.f_makeTree1(0, (new Struct_VmPrint(f_tv2vme(l22_data), 1)));
		}
		case 125/*Sequence*/: {
			final Struct_Sequence l4__tmp = (Struct_Sequence)l3__tmp;
			final Struct l23_f = l4__tmp.f_f;
			final Struct l24_s = l4__tmp.f_s;
			final Struct l25_f = l4__tmp.f_f;
			final Struct l26_s = l4__tmp.f_s;
			final Struct l27_tr0 = f_translateCommand(l25_f);
			final int l28_max0 = ((int)l0_selectMax.invoke(l27_tr0));
			final Struct l29_tr1 = l1_plusSet.invoke(f_translateCommand(l26_s), ((Integer)l28_max0));
			return runtime.m_tree.f_mergeTree(l27_tr0, l29_tr1);
		}
		case 18/*Choice*/: {
			final Struct_Choice l4__tmp = (Struct_Choice)l3__tmp;
			final Struct l30_f = l4__tmp.f_f;
			final Struct l31_s = l4__tmp.f_s;
			final Struct l32_f = l4__tmp.f_f;
			final Struct l33_s = l4__tmp.f_s;
			final Struct l34_tr0 = l1_plusSet.invoke(f_translateCommand(l32_f), ((Integer)1));
			final int l35_max0 = ((int)l0_selectMax.invoke(l34_tr0));
			final Struct l36_tr1 = l1_plusSet.invoke(f_translateCommand(l33_s), ((Integer)l35_max0));
			final int l37_max1 = ((int)l0_selectMax.invoke(l36_tr1));
			final Struct_TreeNode l38_trIf = runtime.m_tree.f_makeTree1(0, (new Struct_Condition("==", (new Struct_ExpInt(1)), (new Struct_ExpInt(1)), (new Object[] { 1, l35_max0 }), (new Object[] { runtime.m_vmtypes.g_emptyTree }))));
			return runtime.m_tree.f_mergeTree(runtime.m_tree.f_mergeTree(l38_trIf, l36_tr1), l2_replaceStamp.invoke(l34_tr0, ((Integer)l35_max0), ((Integer)l37_max1)));
		}
		case 59/*Loop*/: {
			final Struct_Loop l4__tmp = (Struct_Loop)l3__tmp;
			final Struct l39_f = l4__tmp.f_f;
			final Struct l40_a = l4__tmp.f_invariant;
			final Struct l41_f = l4__tmp.f_f;
			final Struct l42_a = l4__tmp.f_invariant;
			final Struct l43_tr0 = l1_plusSet.invoke(f_translateCommand(l41_f), ((Integer)1));
			final int l44_max0 = ((int)l0_selectMax.invoke(l43_tr0));
			final Struct_TreeNode l45_trIf = runtime.m_tree.f_makeTree1(0, (new Struct_Condition("==", (new Struct_ExpInt(1)), (new Struct_ExpInt(1)), (new Object[] { 1, l44_max0 }), (new Object[] { runtime.m_vmtypes.g_emptyTree }))));
			return runtime.m_tree.f_mergeTree(l45_trIf, l2_replaceStamp.invoke(l43_tr0, ((Integer)l44_max0), ((Integer)0)));
		}
		case 35/*If*/: {
			final Struct_If l4__tmp = (Struct_If)l3__tmp;
			final Struct_Test l46_t = l4__tmp.f_test;
			final Struct l47_f = l4__tmp.f_a;
			final Struct l48_s = l4__tmp.f_b;
			final Struct_Test l49_t = l4__tmp.f_test;
			final Struct l50_f = l4__tmp.f_a;
			final Struct l51_s = l4__tmp.f_b;
			{
				final Struct l52___tmp = (new Struct_Choice((new Struct_Sequence(l49_t, l50_f)), (new Struct_Sequence(f_invertTest(l49_t), l51_s))));
				acom = l52___tmp;
				continue TAIL_CALL;
			}
		}
		case 144/*While*/: {
			final Struct_While l4__tmp = (Struct_While)l3__tmp;
			final Struct_Test l53_t = l4__tmp.f_test;
			final Struct l54_a = l4__tmp.f_a;
			final Struct l55_ann = l4__tmp.f_invariant;
			final Struct_Test l56_t = l4__tmp.f_test;
			final Struct l57_a = l4__tmp.f_a;
			final Struct l58_ann = l4__tmp.f_invariant;
			{
				final Struct l59___tmp = (new Struct_Sequence((new Struct_Loop((new Struct_Sequence(l56_t, l57_a)), l58_ann)), f_invertTest(l56_t)));
				acom = l59___tmp;
				continue TAIL_CALL;
			}
		}
		default:
			throw new RuntimeException("Unexpected struct in switch: "+l3__tmp.getTypeName());
		}
	 }
	}
	Struct f_translateToVMCode(Struct_ProgramSequence aps) {
	 TAIL_CALL: for(;;) {
		final Func2<Struct,Struct, Integer> l0_plusSet = new Func2<Struct,Struct,Integer>() {
			final public Struct invoke(final Struct atr, final Integer avalPlus) {
				final Struct l2_$1 = runtime.m_tree.f_makeTree();
				final Func3<Struct,Integer, Struct, Struct> l3_$0 = new Func3<Struct,Integer,Struct,Struct>() {
					final public Struct invoke(final Integer astamp, final Struct av, final Struct aacc) {
						return ((Func3<Struct,Struct, Integer, Struct>)(Func3)runtime.n_setTree).invoke(aacc, ((Integer)(((int)astamp)+((int)avalPlus))), f_plusStamp(av, ((int)avalPlus)));
					}
				};
				return ((Struct)runtime.m_tree.f_foldTree(atr, l2_$1, ((Func3<Object,Object, Object, Object>)(Func3)l3_$0)));
			}
		};
		final Func1<Integer,Struct> l1_selectMax = new Func1<Integer,Struct>() {
			final public Integer invoke(final Struct atr) {
				final Func3<Integer,Integer, Struct, Integer> l1_$0 = new Func3<Integer,Integer,Struct,Integer>() {
					final public Integer invoke(final Integer astamp, final Struct aval, final Integer aacc) {
						if ((((int)((Func2<Integer,Integer, Integer>)(Func2)runtime.n_max).invoke(((Integer)f_findMaxStamp(aval)), astamp))>((int)aacc))) {
							return ((Func2<Integer,Integer, Integer>)(Func2)runtime.n_max).invoke(((Integer)f_findMaxStamp(aval)), astamp);
						} else {
							return aacc;
						}
					}
				};
				return ((Integer)runtime.m_tree.f_foldTree(atr, runtime.m_math.g_intMin, ((Func3<Object,Object, Object, Object>)(Func3)l1_$0)));
			}
		};
		final Struct l2_gsymswitch0 = aps.f_op;
		Struct l3__tmp = l2_gsymswitch0;
		switch (l3__tmp.getTypeId()) {
		case 140/*VarDefine*/: {
			final Struct_VarDefine l4__tmp = (Struct_VarDefine)l3__tmp;
			final String l5_name = l4__tmp.f_name;
			final Struct l6_type = l4__tmp.f_type;
			final Struct l7_value = l4__tmp.f_value;
			final String l8_name = l4__tmp.f_name;
			final Struct l9_type = l4__tmp.f_type;
			final Struct l10_value = l4__tmp.f_value;
			if (runtime.h_Native.isSameStructType((new Struct_Array(0)), l9_type)) {
				final Struct_Array l11_ar = ((Struct_Array)l9_type);
				final Struct_TreeNode l12_tr0 = runtime.m_tree.f_makeTree1(0, (new Struct_InitVar(l8_name, f_createArray(l11_ar, SingletonStructs.arr_empty), 1)));
				final Struct l13_gsymswitch2 = aps.f_next;
				Struct l14__tmp = l13_gsymswitch2;
				switch (l14__tmp.getTypeId()) {
				case 128/*Some*/: {
					final Struct_Some l15__tmp = (Struct_Some)l14__tmp;
					final Object l16_ps1 = l15__tmp.f_value;
					final Struct_ProgramSequence l17_ps1 = ((Struct_ProgramSequence)l15__tmp.f_value);
					return runtime.m_tree.f_mergeTree(l12_tr0, l0_plusSet.invoke(f_translateToVMCode(l17_ps1), ((Integer)1)));
				}
				case 64/*None*/: {
					return l12_tr0;
				}
				default:
					throw new RuntimeException("Unexpected struct in switch: "+l14__tmp.getTypeName());
				}
			} else {
				final Struct_TreeNode l18_tr0 = runtime.m_tree.f_makeTree1(0, (new Struct_InitVar(l8_name, f_tv2vme(l10_value), 1)));
				final Struct l19_gsymswitch1 = aps.f_next;
				Struct l20__tmp = l19_gsymswitch1;
				switch (l20__tmp.getTypeId()) {
				case 128/*Some*/: {
					final Struct_Some l21__tmp = (Struct_Some)l20__tmp;
					final Object l22_ps1 = l21__tmp.f_value;
					final Struct_ProgramSequence l23_ps1 = ((Struct_ProgramSequence)l21__tmp.f_value);
					return runtime.m_tree.f_mergeTree(l18_tr0, l0_plusSet.invoke(f_translateToVMCode(l23_ps1), ((Integer)1)));
				}
				case 64/*None*/: {
					return l18_tr0;
				}
				default:
					throw new RuntimeException("Unexpected struct in switch: "+l20__tmp.getTypeName());
				}
			}
		}
		case 35/*If*/: {
			final Struct_If l4__tmp = (Struct_If)l3__tmp;
			final Struct l24_tr0 = f_translateCommand(aps.f_op);
			final Struct l25_gsymswitch3 = aps.f_next;
			Struct l26__tmp = l25_gsymswitch3;
			switch (l26__tmp.getTypeId()) {
			case 128/*Some*/: {
				final Struct_Some l27__tmp = (Struct_Some)l26__tmp;
				final Object l28_ps1 = l27__tmp.f_value;
				final Struct_ProgramSequence l29_ps1 = ((Struct_ProgramSequence)l27__tmp.f_value);
				return runtime.m_tree.f_mergeTree(l24_tr0, l0_plusSet.invoke(f_translateToVMCode(l29_ps1), l1_selectMax.invoke(l24_tr0)));
			}
			case 64/*None*/: {
				return l24_tr0;
			}
			default:
				throw new RuntimeException("Unexpected struct in switch: "+l26__tmp.getTypeName());
			}
		}
		case 144/*While*/: {
			final Struct_While l4__tmp = (Struct_While)l3__tmp;
			final Struct l30_tr0 = f_translateCommand(aps.f_op);
			final Struct l31_gsymswitch3 = aps.f_next;
			Struct l32__tmp = l31_gsymswitch3;
			switch (l32__tmp.getTypeId()) {
			case 128/*Some*/: {
				final Struct_Some l33__tmp = (Struct_Some)l32__tmp;
				final Object l34_ps1 = l33__tmp.f_value;
				final Struct_ProgramSequence l35_ps1 = ((Struct_ProgramSequence)l33__tmp.f_value);
				return runtime.m_tree.f_mergeTree(l30_tr0, l0_plusSet.invoke(f_translateToVMCode(l35_ps1), l1_selectMax.invoke(l30_tr0)));
			}
			case 64/*None*/: {
				return l30_tr0;
			}
			default:
				throw new RuntimeException("Unexpected struct in switch: "+l32__tmp.getTypeName());
			}
		}
		case 132/*Test*/: {
			final Struct_Test l4__tmp = (Struct_Test)l3__tmp;
			final Struct l36_tr0 = f_translateCommand(aps.f_op);
			final Struct l37_gsymswitch3 = aps.f_next;
			Struct l38__tmp = l37_gsymswitch3;
			switch (l38__tmp.getTypeId()) {
			case 128/*Some*/: {
				final Struct_Some l39__tmp = (Struct_Some)l38__tmp;
				final Object l40_ps1 = l39__tmp.f_value;
				final Struct_ProgramSequence l41_ps1 = ((Struct_ProgramSequence)l39__tmp.f_value);
				return runtime.m_tree.f_mergeTree(l36_tr0, l0_plusSet.invoke(f_translateToVMCode(l41_ps1), l1_selectMax.invoke(l36_tr0)));
			}
			case 64/*None*/: {
				return l36_tr0;
			}
			default:
				throw new RuntimeException("Unexpected struct in switch: "+l38__tmp.getTypeName());
			}
		}
		case 125/*Sequence*/: {
			final Struct_Sequence l4__tmp = (Struct_Sequence)l3__tmp;
			final Struct l42_tr0 = f_translateCommand(aps.f_op);
			final Struct l43_gsymswitch3 = aps.f_next;
			Struct l44__tmp = l43_gsymswitch3;
			switch (l44__tmp.getTypeId()) {
			case 128/*Some*/: {
				final Struct_Some l45__tmp = (Struct_Some)l44__tmp;
				final Object l46_ps1 = l45__tmp.f_value;
				final Struct_ProgramSequence l47_ps1 = ((Struct_ProgramSequence)l45__tmp.f_value);
				return runtime.m_tree.f_mergeTree(l42_tr0, l0_plusSet.invoke(f_translateToVMCode(l47_ps1), l1_selectMax.invoke(l42_tr0)));
			}
			case 64/*None*/: {
				return l42_tr0;
			}
			default:
				throw new RuntimeException("Unexpected struct in switch: "+l44__tmp.getTypeName());
			}
		}
		case 18/*Choice*/: {
			final Struct_Choice l4__tmp = (Struct_Choice)l3__tmp;
			final Struct l48_tr0 = f_translateCommand(aps.f_op);
			final Struct l49_gsymswitch3 = aps.f_next;
			Struct l50__tmp = l49_gsymswitch3;
			switch (l50__tmp.getTypeId()) {
			case 128/*Some*/: {
				final Struct_Some l51__tmp = (Struct_Some)l50__tmp;
				final Object l52_ps1 = l51__tmp.f_value;
				final Struct_ProgramSequence l53_ps1 = ((Struct_ProgramSequence)l51__tmp.f_value);
				return runtime.m_tree.f_mergeTree(l48_tr0, l0_plusSet.invoke(f_translateToVMCode(l53_ps1), l1_selectMax.invoke(l48_tr0)));
			}
			case 64/*None*/: {
				return l48_tr0;
			}
			default:
				throw new RuntimeException("Unexpected struct in switch: "+l50__tmp.getTypeName());
			}
		}
		case 59/*Loop*/: {
			final Struct_Loop l4__tmp = (Struct_Loop)l3__tmp;
			final Struct l54_tr0 = f_translateCommand(aps.f_op);
			final Struct l55_gsymswitch3 = aps.f_next;
			Struct l56__tmp = l55_gsymswitch3;
			switch (l56__tmp.getTypeId()) {
			case 128/*Some*/: {
				final Struct_Some l57__tmp = (Struct_Some)l56__tmp;
				final Object l58_ps1 = l57__tmp.f_value;
				final Struct_ProgramSequence l59_ps1 = ((Struct_ProgramSequence)l57__tmp.f_value);
				return runtime.m_tree.f_mergeTree(l54_tr0, l0_plusSet.invoke(f_translateToVMCode(l59_ps1), l1_selectMax.invoke(l54_tr0)));
			}
			case 64/*None*/: {
				return l54_tr0;
			}
			default:
				throw new RuntimeException("Unexpected struct in switch: "+l56__tmp.getTypeName());
			}
		}
		case 141/*VarRedefine*/: {
			final Struct_VarRedefine l4__tmp = (Struct_VarRedefine)l3__tmp;
			final Struct l60_tr0 = f_translateCommand(aps.f_op);
			final Struct l61_gsymswitch3 = aps.f_next;
			Struct l62__tmp = l61_gsymswitch3;
			switch (l62__tmp.getTypeId()) {
			case 128/*Some*/: {
				final Struct_Some l63__tmp = (Struct_Some)l62__tmp;
				final Object l64_ps1 = l63__tmp.f_value;
				final Struct_ProgramSequence l65_ps1 = ((Struct_ProgramSequence)l63__tmp.f_value);
				return runtime.m_tree.f_mergeTree(l60_tr0, l0_plusSet.invoke(f_translateToVMCode(l65_ps1), l1_selectMax.invoke(l60_tr0)));
			}
			case 64/*None*/: {
				return l60_tr0;
			}
			default:
				throw new RuntimeException("Unexpected struct in switch: "+l62__tmp.getTypeName());
			}
		}
		case 139/*VarArrayRedefine*/: {
			final Struct_VarArrayRedefine l4__tmp = (Struct_VarArrayRedefine)l3__tmp;
			final Struct l66_tr0 = f_translateCommand(aps.f_op);
			final Struct l67_gsymswitch3 = aps.f_next;
			Struct l68__tmp = l67_gsymswitch3;
			switch (l68__tmp.getTypeId()) {
			case 128/*Some*/: {
				final Struct_Some l69__tmp = (Struct_Some)l68__tmp;
				final Object l70_ps1 = l69__tmp.f_value;
				final Struct_ProgramSequence l71_ps1 = ((Struct_ProgramSequence)l69__tmp.f_value);
				return runtime.m_tree.f_mergeTree(l66_tr0, l0_plusSet.invoke(f_translateToVMCode(l71_ps1), l1_selectMax.invoke(l66_tr0)));
			}
			case 64/*None*/: {
				return l66_tr0;
			}
			default:
				throw new RuntimeException("Unexpected struct in switch: "+l68__tmp.getTypeName());
			}
		}
		case 117/*Print*/: {
			final Struct_Print l4__tmp = (Struct_Print)l3__tmp;
			final Struct l72_tr0 = f_translateCommand(aps.f_op);
			final Struct l73_gsymswitch3 = aps.f_next;
			Struct l74__tmp = l73_gsymswitch3;
			switch (l74__tmp.getTypeId()) {
			case 128/*Some*/: {
				final Struct_Some l75__tmp = (Struct_Some)l74__tmp;
				final Object l76_ps1 = l75__tmp.f_value;
				final Struct_ProgramSequence l77_ps1 = ((Struct_ProgramSequence)l75__tmp.f_value);
				return runtime.m_tree.f_mergeTree(l72_tr0, l0_plusSet.invoke(f_translateToVMCode(l77_ps1), l1_selectMax.invoke(l72_tr0)));
			}
			case 64/*None*/: {
				return l72_tr0;
			}
			default:
				throw new RuntimeException("Unexpected struct in switch: "+l74__tmp.getTypeName());
			}
		}
		case 10/*Annotation*/: {
			final Struct_Annotation l4__tmp = (Struct_Annotation)l3__tmp;
			final Struct l78_formule = l4__tmp.f_formule;
			final Struct l79_formule = l4__tmp.f_formule;
			final Struct l80_gsymswitch4 = aps.f_next;
			Struct l81__tmp = l80_gsymswitch4;
			switch (l81__tmp.getTypeId()) {
			case 128/*Some*/: {
				final Struct_Some l82__tmp = (Struct_Some)l81__tmp;
				final Object l83_ps1 = l82__tmp.f_value;
				final Struct_ProgramSequence l84_ps1 = ((Struct_ProgramSequence)l82__tmp.f_value);
				{
					final Struct_ProgramSequence l85___tmp = l84_ps1;
					aps = l85___tmp;
					continue TAIL_CALL;
				}
			}
			case 64/*None*/: {
				return runtime.m_tree.f_makeTree();
			}
			default:
				throw new RuntimeException("Unexpected struct in switch: "+l81__tmp.getTypeName());
			}
		}
		case 26/*EmptyOp*/: {
			return runtime.m_tree.f_makeTree();
		}
		default:
			throw new RuntimeException("Unexpected struct in switch: "+l3__tmp.getTypeName());
		}
	 }
	}
	Struct f_tv2vme(Struct at) {
		Struct l0__tmp = at;
		switch (l0__tmp.getTypeId()) {
		case 40/*Int*/: {
			final Struct_Int l1__tmp = (Struct_Int)l0__tmp;
			final int l2_val = l1__tmp.f_v;
			final int l3_val = l1__tmp.f_v;
			return (new Struct_ExpInt(l3_val));
		}
		case 142/*Variable*/: {
			final Struct_Variable l1__tmp = (Struct_Variable)l0__tmp;
			final String l4_var = l1__tmp.f_name;
			final String l5_var = l1__tmp.f_name;
			return (new Struct_ExpVar(l5_var));
		}
		case 14/*BinOp*/: {
			final Struct_BinOp l1__tmp = (Struct_BinOp)l0__tmp;
			final String l6_op = l1__tmp.f_op;
			final Struct l7_f = l1__tmp.f_f;
			final Struct l8_s = l1__tmp.f_s;
			final String l9_op = l1__tmp.f_op;
			final Struct l10_f = l1__tmp.f_f;
			final Struct l11_s = l1__tmp.f_s;
			final Struct l12_t0 = f_tv2vme(l10_f);
			final Struct l13_t1 = f_tv2vme(l11_s);
			if ((l9_op).equals("+")) {
				return (new Struct_Sum(l12_t0, l13_t1));
			} else {
				if ((l9_op).equals("-")) {
					return (new Struct_Min(l12_t0, l13_t1));
				} else {
					if ((l9_op).equals("*")) {
						return (new Struct_Mult(l12_t0, l13_t1));
					} else {
						if ((l9_op).equals("/")) {
							return (new Struct_Div(l12_t0, l13_t1));
						} else {
							runtime.m_runtime.f_println("oops..");
							return (new Struct_ExpInt((-1)));
						}
					}
				}
			}
		}
		case 136/*UnOp*/: {
			final Struct_UnOp l1__tmp = (Struct_UnOp)l0__tmp;
			final String l14_op = l1__tmp.f_op;
			final Struct l15_f = l1__tmp.f_u;
			final String l16_op = l1__tmp.f_op;
			final Struct l17_f = l1__tmp.f_u;
			if ((l16_op).equals("--")) {
				return (new Struct_Min(f_tv2vme(l17_f), (new Struct_ExpInt(1))));
			} else {
				return (new Struct_Sum(f_tv2vme(l17_f), (new Struct_ExpInt(1))));
			}
		}
		case 12/*ArrayAccess*/: {
			final Struct_ArrayAccess l1__tmp = (Struct_ArrayAccess)l0__tmp;
			final Struct_Variable l18_var = l1__tmp.f_var;
			final Struct l19_ind = l1__tmp.f_ind;
			final Struct_Variable l20_var = l1__tmp.f_var;
			final Struct l21_ind = l1__tmp.f_ind;
			return (new Struct_ExpArrayAccess(l20_var.f_name, f_tv2vme(l21_ind)));
		}
		default: {
			return (new Struct_ExpInt(0));
		}
		}
	}
}
