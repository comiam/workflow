// HASH COLLISIONS: YES
// timestamp: 1.601659959E12

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
			return (new Struct_Some(l1__tmp));
		}
		case 15/*ArVar*/: {
			final Struct_ArVar l1__tmp = (Struct_ArVar)l0__tmp;
			final String l4_var = l1__tmp.f_var;
			final String l5_var = l1__tmp.f_var;
			return (new Struct_Some(l1__tmp));
		}
		default: {
			return f_execSimplifier((new Struct_Some(aar)), acondOp);
		}
		}
	}
	Struct f_detectNumOperand(Struct aar) {
		Struct l0__tmp = aar;
		switch (l0__tmp.getTypeId()) {
		case 9/*ArInt*/: {
			final Struct_ArInt l1__tmp = (Struct_ArInt)l0__tmp;
			final int l2_val = l1__tmp.f_val;
			final int l3_val = l1__tmp.f_val;
			return (new Struct_Some(l3_val));
		}
		default: {
			return ((Struct)SingletonStructs.str_None);
		}
		}
	}
	Struct f_detectOperands(Struct al, Struct ar) {
		final Struct l0_typeInt0 = f_detectNumOperand(al);
		final String l1_typeString0 = f_detectVarOperand(al);
		final Struct l2_typeInt1 = f_detectNumOperand(ar);
		final String l3_typeString1 = f_detectVarOperand(ar);
		if (runtime.m_maybe.f_isNone(l0_typeInt0)) {
			if (runtime.m_maybe.f_isNone(l2_typeInt1)) {
				return (new Struct_VarVar(l1_typeString0, l3_typeString1));
			} else {
				return (new Struct_VarInt(l1_typeString0, ((int)runtime.m_maybe.f_either(l2_typeInt1, 0))));
			}
		} else {
			if (runtime.m_maybe.f_isNone(l2_typeInt1)) {
				return (new Struct_IntVar(((int)runtime.m_maybe.f_either(l0_typeInt0, 0)), l3_typeString1));
			} else {
				return (new Struct_IntInt(((int)runtime.m_maybe.f_either(l0_typeInt0, 0)), ((int)runtime.m_maybe.f_either(l2_typeInt1, 0))));
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
	String f_detectVarOperand(Struct aar) {
		Struct l0__tmp = aar;
		switch (l0__tmp.getTypeId()) {
		case 15/*ArVar*/: {
			final Struct_ArVar l1__tmp = (Struct_ArVar)l0__tmp;
			final String l2_var = l1__tmp.f_var;
			final String l3_var = l1__tmp.f_var;
			return l3_var;
		}
		default: {
			return "";
		}
		}
	}
	Struct f_execSimplifier(Struct am, Func2<Struct,String, Struct> acondOp) {
		if (runtime.m_maybe.f_isNone(am)) {
			return ((Struct)SingletonStructs.str_None);
		} else {
			final Object[] l0_arr = f_extractArgs(((Struct)runtime.m_maybe.f_either(am, (new Struct_ArInt(0)))));
			if ((runtime.h_Native.length(l0_arr)==0)) {
				return am;
			} else {
				final Struct l1_newL = f_detectAndReplace(((Struct)(l0_arr[0])), acondOp);
				final Struct l2_newR = f_detectAndReplace(((Struct)(l0_arr[1])), acondOp);
				if ((runtime.m_maybe.f_isNone(l1_newL)||runtime.m_maybe.f_isNone(l2_newR))) {
					return ((Struct)SingletonStructs.str_None);
				} else {
					final String l3_op = f_detectType(((Struct)runtime.m_maybe.f_either(am, (new Struct_ArInt(0)))));
					return acondOp.invoke(l3_op, f_createStruct(l3_op, ((Struct)runtime.m_maybe.f_either(l1_newL, (new Struct_ArInt(0)))), ((Struct)runtime.m_maybe.f_either(l2_newR, (new Struct_ArInt(0))))));
				}
			}
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
	Struct f_removeTrivialExpIter(Struct aar, Struct aold, int aiteration) {
	 TAIL_CALL: for(;;) {
		if ((runtime.m_maybe.f_isNone(aold)&&(aiteration>0))) {
			return ((Struct)SingletonStructs.str_None);
		} else {
			final Struct_Some l2_$1 = (new Struct_Some(aar));
			final Func2<Struct_Some,String, Struct> l3_$0 = new Func2<Struct_Some,String,Struct>() {
				final public Struct_Some invoke(final String aop, final Struct aar0) {
					if ((!(aop).equals("^"))) {
						return (new Struct_Some(aar0));
					} else {
						final Struct_ArPow l0_p = ((Struct_ArPow)aar0);
						final Struct l1_gsymswitch1 = f_detectOperands(l0_p.f_l, l0_p.f_pow);
						Struct l2__tmp = l1_gsymswitch1;
						switch (l2__tmp.getTypeId()) {
						case 28/*IntInt*/: {
							final Struct_IntInt l3__tmp = (Struct_IntInt)l2__tmp;
							final int l4_l0 = l3__tmp.f_l;
							final int l5_r0 = l3__tmp.f_r;
							final int l6_l0 = l3__tmp.f_l;
							final int l7_r0 = l3__tmp.f_r;
							if ((l7_r0==0)) {
								return (new Struct_Some((new Struct_ArInt(1))));
							} else {
								if ((l7_r0==1)) {
									return (new Struct_Some((new Struct_ArInt(l6_l0))));
								} else {
									if ((l6_l0==1)) {
										return (new Struct_Some((new Struct_ArInt(1))));
									} else {
										if ((l6_l0==0)) {
											return (new Struct_Some((new Struct_ArInt(0))));
										} else {
											return (new Struct_Some(aar0));
										}
									}
								}
							}
						}
						case 115/*VarInt*/: {
							final Struct_VarInt l3__tmp = (Struct_VarInt)l2__tmp;
							final String l8_l0 = l3__tmp.f_l;
							final int l9_r0 = l3__tmp.f_r;
							final String l10_l0 = l3__tmp.f_l;
							final int l11_r0 = l3__tmp.f_r;
							if ((l11_r0==0)) {
								return (new Struct_Some((new Struct_ArInt(1))));
							} else {
								if ((l11_r0==1)) {
									return (new Struct_Some((new Struct_ArVar(l10_l0))));
								} else {
									return (new Struct_Some(aar0));
								}
							}
						}
						case 32/*IntVar*/: {
							final Struct_IntVar l3__tmp = (Struct_IntVar)l2__tmp;
							final int l12_l0 = l3__tmp.f_l;
							final String l13_r0 = l3__tmp.f_r;
							final int l14_l0 = l3__tmp.f_l;
							final String l15_r0 = l3__tmp.f_r;
							if ((l14_l0==1)) {
								return (new Struct_Some((new Struct_ArInt(1))));
							} else {
								return (new Struct_Some(aar0));
							}
						}
						default: {
							return (new Struct_Some(aar0));
						}
						}
					}
				}
			};
			final Struct l4_it0 = f_execSimplifier(l2_$1, ((Func2<Struct,String, Struct>)(Func2)l3_$0));
			final Func2<Struct_Some,String, Struct> l6_$5 = new Func2<Struct_Some,String,Struct>() {
				final public Struct_Some invoke(final String aop, final Struct aar0) {
					if ((!(aop).equals("*"))) {
						return (new Struct_Some(aar0));
					} else {
						final Struct_ArMult l0_p = ((Struct_ArMult)aar0);
						final Struct l1_gsymswitch2 = f_detectOperands(l0_p.f_l, l0_p.f_r);
						Struct l2__tmp = l1_gsymswitch2;
						switch (l2__tmp.getTypeId()) {
						case 28/*IntInt*/: {
							final Struct_IntInt l3__tmp = (Struct_IntInt)l2__tmp;
							final int l4_l0 = l3__tmp.f_l;
							final int l5_r0 = l3__tmp.f_r;
							final int l6_l0 = l3__tmp.f_l;
							final int l7_r0 = l3__tmp.f_r;
							if (((l7_r0==0)||(l6_l0==0))) {
								return (new Struct_Some((new Struct_ArInt(0))));
							} else {
								if ((l7_r0==1)) {
									return (new Struct_Some((new Struct_ArInt(l6_l0))));
								} else {
									if ((l6_l0==1)) {
										return (new Struct_Some((new Struct_ArInt(l7_r0))));
									} else {
										return (new Struct_Some(aar0));
									}
								}
							}
						}
						case 115/*VarInt*/: {
							final Struct_VarInt l3__tmp = (Struct_VarInt)l2__tmp;
							final String l8_l0 = l3__tmp.f_l;
							final int l9_r0 = l3__tmp.f_r;
							final String l10_l0 = l3__tmp.f_l;
							final int l11_r0 = l3__tmp.f_r;
							if ((l11_r0==0)) {
								return (new Struct_Some((new Struct_ArInt(0))));
							} else {
								if ((l11_r0==1)) {
									return (new Struct_Some((new Struct_ArVar(l10_l0))));
								} else {
									return (new Struct_Some(aar0));
								}
							}
						}
						case 32/*IntVar*/: {
							final Struct_IntVar l3__tmp = (Struct_IntVar)l2__tmp;
							final int l12_l0 = l3__tmp.f_l;
							final String l13_r0 = l3__tmp.f_r;
							final int l14_l0 = l3__tmp.f_l;
							final String l15_r0 = l3__tmp.f_r;
							if ((l14_l0==0)) {
								return (new Struct_Some((new Struct_ArInt(0))));
							} else {
								if ((l14_l0==1)) {
									return (new Struct_Some((new Struct_ArVar(l15_r0))));
								} else {
									return (new Struct_Some(aar0));
								}
							}
						}
						default: {
							return (new Struct_Some(aar0));
						}
						}
					}
				}
			};
			final Struct l7_it1 = f_execSimplifier(l4_it0, ((Func2<Struct,String, Struct>)(Func2)l6_$5));
			final Func2<Struct,String, Struct> l9_$8 = new Func2<Struct,String,Struct>() {
				final public Struct invoke(final String aop, final Struct aar0) {
					if ((!(aop).equals("/"))) {
						return (new Struct_Some(aar0));
					} else {
						final Struct_ArDiv l0_p = ((Struct_ArDiv)aar0);
						final Struct l1_gsymswitch3 = f_detectOperands(l0_p.f_up, l0_p.f_down);
						Struct l2__tmp = l1_gsymswitch3;
						switch (l2__tmp.getTypeId()) {
						case 28/*IntInt*/: {
							final Struct_IntInt l3__tmp = (Struct_IntInt)l2__tmp;
							final int l4_l0 = l3__tmp.f_l;
							final int l5_r0 = l3__tmp.f_r;
							final int l6_l0 = l3__tmp.f_l;
							final int l7_r0 = l3__tmp.f_r;
							if ((l6_l0==0)) {
								return (new Struct_Some((new Struct_ArInt(0))));
							} else {
								if ((l7_r0==0)) {
									return ((Struct)SingletonStructs.str_None);
								} else {
									if ((l7_r0==1)) {
										return (new Struct_Some((new Struct_ArInt(l6_l0))));
									} else {
										if ((l7_r0==l6_l0)) {
											return (new Struct_Some((new Struct_ArInt(1))));
										} else {
											return (new Struct_Some(aar0));
										}
									}
								}
							}
						}
						case 115/*VarInt*/: {
							final Struct_VarInt l3__tmp = (Struct_VarInt)l2__tmp;
							final String l8_l0 = l3__tmp.f_l;
							final int l9_r0 = l3__tmp.f_r;
							final String l10_l0 = l3__tmp.f_l;
							final int l11_r0 = l3__tmp.f_r;
							if ((l11_r0==0)) {
								return (new Struct_Some((new Struct_ArInt(0))));
							} else {
								if ((l11_r0==1)) {
									return (new Struct_Some((new Struct_ArVar(l10_l0))));
								} else {
									return (new Struct_Some(aar0));
								}
							}
						}
						case 32/*IntVar*/: {
							final Struct_IntVar l3__tmp = (Struct_IntVar)l2__tmp;
							final int l12_l0 = l3__tmp.f_l;
							final String l13_r0 = l3__tmp.f_r;
							final int l14_l0 = l3__tmp.f_l;
							final String l15_r0 = l3__tmp.f_r;
							if ((l14_l0==0)) {
								return (new Struct_Some((new Struct_ArInt(0))));
							} else {
								return (new Struct_Some(aar0));
							}
						}
						case 118/*VarVar*/: {
							final Struct_VarVar l3__tmp = (Struct_VarVar)l2__tmp;
							final String l16_l0 = l3__tmp.f_l;
							final String l17_r0 = l3__tmp.f_r;
							final String l18_l0 = l3__tmp.f_l;
							final String l19_r0 = l3__tmp.f_r;
							if ((l18_l0).equals(l19_r0)) {
								return (new Struct_Some((new Struct_ArInt(1))));
							} else {
								return (new Struct_Some(aar0));
							}
						}
						default:
							throw new RuntimeException("Unexpected struct in switch: "+l2__tmp.getTypeName());
						}
					}
				}
			};
			final Struct l10_it2 = f_execSimplifier(l7_it1, l9_$8);
			final Func2<Struct_Some,String, Struct> l12_$11 = new Func2<Struct_Some,String,Struct>() {
				final public Struct_Some invoke(final String aop, final Struct aar0) {
					if ((!(aop).equals("-"))) {
						return (new Struct_Some(aar0));
					} else {
						final Struct_ArMin l0_p = ((Struct_ArMin)aar0);
						final Struct l1_gsymswitch4 = f_detectOperands(l0_p.f_l, l0_p.f_r);
						Struct l2__tmp = l1_gsymswitch4;
						switch (l2__tmp.getTypeId()) {
						case 28/*IntInt*/: {
							final Struct_IntInt l3__tmp = (Struct_IntInt)l2__tmp;
							final int l4_l0 = l3__tmp.f_l;
							final int l5_r0 = l3__tmp.f_r;
							final int l6_l0 = l3__tmp.f_l;
							final int l7_r0 = l3__tmp.f_r;
							if ((l7_r0==l6_l0)) {
								return (new Struct_Some((new Struct_ArInt(0))));
							} else {
								if ((l6_l0==0)) {
									return (new Struct_Some((new Struct_ArInt((-l7_r0)))));
								} else {
									if ((l7_r0==0)) {
										return (new Struct_Some((new Struct_ArInt(l6_l0))));
									} else {
										return (new Struct_Some(aar0));
									}
								}
							}
						}
						case 115/*VarInt*/: {
							final Struct_VarInt l3__tmp = (Struct_VarInt)l2__tmp;
							final String l8_l0 = l3__tmp.f_l;
							final int l9_r0 = l3__tmp.f_r;
							final String l10_l0 = l3__tmp.f_l;
							final int l11_r0 = l3__tmp.f_r;
							if ((l11_r0==0)) {
								return (new Struct_Some((new Struct_ArVar(l10_l0))));
							} else {
								return (new Struct_Some(aar0));
							}
						}
						case 32/*IntVar*/: {
							final Struct_IntVar l3__tmp = (Struct_IntVar)l2__tmp;
							final int l12_l0 = l3__tmp.f_l;
							final String l13_r0 = l3__tmp.f_r;
							final int l14_l0 = l3__tmp.f_l;
							final String l15_r0 = l3__tmp.f_r;
							if ((l14_l0==0)) {
								return (new Struct_Some((new Struct_ArMult((new Struct_ArInt((-1))), (new Struct_ArVar(l15_r0))))));
							} else {
								return (new Struct_Some(aar0));
							}
						}
						case 118/*VarVar*/: {
							final Struct_VarVar l3__tmp = (Struct_VarVar)l2__tmp;
							final String l16_l0 = l3__tmp.f_l;
							final String l17_r0 = l3__tmp.f_r;
							final String l18_l0 = l3__tmp.f_l;
							final String l19_r0 = l3__tmp.f_r;
							if ((l18_l0).equals(l19_r0)) {
								return (new Struct_Some((new Struct_ArInt(0))));
							} else {
								return (new Struct_Some(aar0));
							}
						}
						default:
							throw new RuntimeException("Unexpected struct in switch: "+l2__tmp.getTypeName());
						}
					}
				}
			};
			final Struct l13_it3 = f_execSimplifier(l10_it2, ((Func2<Struct,String, Struct>)(Func2)l12_$11));
			final Func2<Struct_Some,String, Struct> l15_$14 = new Func2<Struct_Some,String,Struct>() {
				final public Struct_Some invoke(final String aop, final Struct aar0) {
					if ((!(aop).equals("+"))) {
						return (new Struct_Some(aar0));
					} else {
						final Struct_ArSum l0_p = ((Struct_ArSum)aar0);
						final Struct l1_gsymswitch5 = f_detectOperands(l0_p.f_l, l0_p.f_r);
						Struct l2__tmp = l1_gsymswitch5;
						switch (l2__tmp.getTypeId()) {
						case 28/*IntInt*/: {
							final Struct_IntInt l3__tmp = (Struct_IntInt)l2__tmp;
							final int l4_l0 = l3__tmp.f_l;
							final int l5_r0 = l3__tmp.f_r;
							final int l6_l0 = l3__tmp.f_l;
							final int l7_r0 = l3__tmp.f_r;
							if ((l6_l0==0)) {
								return (new Struct_Some((new Struct_ArInt(l7_r0))));
							} else {
								if ((l7_r0==0)) {
									return (new Struct_Some((new Struct_ArInt(l6_l0))));
								} else {
									if ((l7_r0==l6_l0)) {
										return (new Struct_Some((new Struct_ArMult((new Struct_ArInt(2)), (new Struct_ArInt(l6_l0))))));
									} else {
										return (new Struct_Some(aar0));
									}
								}
							}
						}
						case 115/*VarInt*/: {
							final Struct_VarInt l3__tmp = (Struct_VarInt)l2__tmp;
							final String l8_l0 = l3__tmp.f_l;
							final int l9_r0 = l3__tmp.f_r;
							final String l10_l0 = l3__tmp.f_l;
							final int l11_r0 = l3__tmp.f_r;
							if ((l11_r0==0)) {
								return (new Struct_Some((new Struct_ArVar(l10_l0))));
							} else {
								return (new Struct_Some(aar0));
							}
						}
						case 32/*IntVar*/: {
							final Struct_IntVar l3__tmp = (Struct_IntVar)l2__tmp;
							final int l12_l0 = l3__tmp.f_l;
							final String l13_r0 = l3__tmp.f_r;
							final int l14_l0 = l3__tmp.f_l;
							final String l15_r0 = l3__tmp.f_r;
							if ((l14_l0==0)) {
								return (new Struct_Some((new Struct_ArVar(l15_r0))));
							} else {
								return (new Struct_Some(aar0));
							}
						}
						case 118/*VarVar*/: {
							final Struct_VarVar l3__tmp = (Struct_VarVar)l2__tmp;
							final String l16_l0 = l3__tmp.f_l;
							final String l17_r0 = l3__tmp.f_r;
							final String l18_l0 = l3__tmp.f_l;
							final String l19_r0 = l3__tmp.f_r;
							if ((l18_l0).equals(l19_r0)) {
								return (new Struct_Some((new Struct_ArMult((new Struct_ArInt(2)), (new Struct_ArVar(l18_l0))))));
							} else {
								return (new Struct_Some(aar0));
							}
						}
						default:
							throw new RuntimeException("Unexpected struct in switch: "+l2__tmp.getTypeName());
						}
					}
				}
			};
			final Struct l16_it4 = f_execSimplifier(l13_it3, ((Func2<Struct,String, Struct>)(Func2)l15_$14));
			if (runtime.m_maybe.f_isNone(l16_it4)) {
				return ((Struct)SingletonStructs.str_None);
			} else {
				final Struct l17_exp_0 = ((Struct)runtime.m_maybe.f_either(l16_it4, (new Struct_ArInt(0))));
				final Struct l18_oldExp = ((Struct)runtime.m_maybe.f_either(aold, (new Struct_ArInt(0))));
				if (FlowRuntime.compareEqual(l17_exp_0,l18_oldExp)) {
					return l16_it4;
				} else {
					{
						final Struct l19___tmp = l17_exp_0;
						final Struct l20___tmp = l16_it4;
						final int l21___tmp = (aiteration+1);
						aar = l19___tmp;
						aold = l20___tmp;
						aiteration = l21___tmp;
						continue TAIL_CALL;
					}
				}
			}
		}
	 }
	}
	Struct f_s2ar(String as) {
		final String l0_gram = "S = min | divide | power | plus | mult | int | var;\nws = (\" \" | \"\\t\" | \"\\n\" | \"\\r\")*;\n\npower = ws \"(\" ws S:l \"^\" S:r ws \")\" ws {ArPow(:l,:r)};\ndivide = ws \"(\" ws S:l ws \"/\" ws S:r ws \")\" ws {ArDiv(:l,:r)};\nmin = ws \"(\" ws S:l ws \"-\" ws S:r ws \")\" ws {ArMin(:l,:r)};\nplus = ws \"(\" ws S:l ws \"+\" ws S:r ws \")\" ws {ArSum(:l,:r)};\nmult = ws \"(\" ws S:l ws \"*\" ws S:r ws \")\" ws {ArMult(:l,:r)};\n\nint = ws digit+$s ws {ArInt(s2i($s))};\nvar = ws word$s ws {ArVar($s)};\n\ndigit = '0'-'9';\nword = ('a'-'z')+ ('0'-'9')*;";
		return ((Struct)runtime.m_driver.f_parsic(runtime.m_driver.f_compilePegGrammar(l0_gram), as, runtime.m_pegaction.g_defaultPegActions));
	}
	Struct f_simplifyTree(Struct aar) {
		return f_removeTrivialExpIter(aar, ((Struct)SingletonStructs.str_None), 0);
	}
}
