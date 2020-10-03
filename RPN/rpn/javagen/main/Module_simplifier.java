// HASH COLLISIONS: YES
// timestamp: 1.601710118E12

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
	Struct f_detectOperands(Struct al, Struct ar) {
		Struct l0__tmp = al;
		switch (l0__tmp.getTypeId()) {
		case 9/*ArInt*/: {
			final Struct_ArInt l1__tmp = (Struct_ArInt)l0__tmp;
			final int l2_val = l1__tmp.f_val;
			final int l3_val = l1__tmp.f_val;
			Struct l4__tmp = ar;
			switch (l4__tmp.getTypeId()) {
			case 9/*ArInt*/: {
				final Struct_ArInt l5__tmp = (Struct_ArInt)l4__tmp;
				final int l6_val1 = l5__tmp.f_val;
				final int l7_val1 = l5__tmp.f_val;
				return (new Struct_IntInt(l3_val, l7_val1));
			}
			case 15/*ArVar*/: {
				final Struct_ArVar l5__tmp = (Struct_ArVar)l4__tmp;
				final String l8_var1 = l5__tmp.f_var;
				final String l9_var1 = l5__tmp.f_var;
				return (new Struct_IntVar(l3_val, l9_var1));
			}
			default: {
				return (new Struct_IntExp(l3_val, ar));
			}
			}
		}
		case 15/*ArVar*/: {
			final Struct_ArVar l1__tmp = (Struct_ArVar)l0__tmp;
			final String l10_var = l1__tmp.f_var;
			final String l11_var = l1__tmp.f_var;
			Struct l12__tmp = ar;
			switch (l12__tmp.getTypeId()) {
			case 9/*ArInt*/: {
				final Struct_ArInt l13__tmp = (Struct_ArInt)l12__tmp;
				final int l14_val1 = l13__tmp.f_val;
				final int l15_val1 = l13__tmp.f_val;
				return (new Struct_VarInt(l11_var, l15_val1));
			}
			case 15/*ArVar*/: {
				final Struct_ArVar l13__tmp = (Struct_ArVar)l12__tmp;
				final String l16_var1 = l13__tmp.f_var;
				final String l17_var1 = l13__tmp.f_var;
				return (new Struct_VarVar(l11_var, l17_var1));
			}
			default: {
				return (new Struct_VarExp(l11_var, ar));
			}
			}
		}
		default: {
			Struct l18__tmp = ar;
			switch (l18__tmp.getTypeId()) {
			case 9/*ArInt*/: {
				final Struct_ArInt l19__tmp = (Struct_ArInt)l18__tmp;
				final int l20_val1 = l19__tmp.f_val;
				final int l21_val1 = l19__tmp.f_val;
				return (new Struct_ExpInt(al, l21_val1));
			}
			case 15/*ArVar*/: {
				final Struct_ArVar l19__tmp = (Struct_ArVar)l18__tmp;
				final String l22_var1 = l19__tmp.f_var;
				final String l23_var1 = l19__tmp.f_var;
				return (new Struct_ExpVar(al, l23_var1));
			}
			default: {
				return (new Struct_ExpExp(al, ar));
			}
			}
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
	Struct f_foldEqualOperands(Struct aar, Struct aold, int aiteration) {
		if ((runtime.m_maybe.f_isNone(aold)&&(aiteration>0))) {
			return ((Struct)SingletonStructs.str_None);
		} else {
			return (new Struct_Some(aar));
		}
	}
	Struct f_removeTrivialExp(Struct aar, Struct aold, int aiteration) {
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
						final Struct l1_gsymswitch0 = f_detectOperands(l0_p.f_l, l0_p.f_pow);
						Struct l2__tmp = l1_gsymswitch0;
						switch (l2__tmp.getTypeId()) {
						case 32/*IntInt*/: {
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
						case 120/*VarInt*/: {
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
						case 27/*ExpInt*/: {
							final Struct_ExpInt l3__tmp = (Struct_ExpInt)l2__tmp;
							final Struct l12_l0 = l3__tmp.f_l;
							final int l13_r0 = l3__tmp.f_r;
							final Struct l14_l0 = l3__tmp.f_l;
							final int l15_r0 = l3__tmp.f_r;
							if ((l15_r0==0)) {
								return (new Struct_Some((new Struct_ArInt(1))));
							} else {
								if ((l15_r0==1)) {
									return (new Struct_Some(l14_l0));
								} else {
									return (new Struct_Some(aar0));
								}
							}
						}
						case 36/*IntVar*/: {
							final Struct_IntVar l3__tmp = (Struct_IntVar)l2__tmp;
							final int l16_l0 = l3__tmp.f_l;
							final String l17_r0 = l3__tmp.f_r;
							final int l18_l0 = l3__tmp.f_l;
							final String l19_r0 = l3__tmp.f_r;
							if ((l18_l0==1)) {
								return (new Struct_Some((new Struct_ArInt(1))));
							} else {
								return (new Struct_Some(aar0));
							}
						}
						case 31/*IntExp*/: {
							final Struct_IntExp l3__tmp = (Struct_IntExp)l2__tmp;
							final int l20_l0 = l3__tmp.f_l;
							final Struct l21_r0 = l3__tmp.f_r;
							final int l22_l0 = l3__tmp.f_l;
							final Struct l23_r0 = l3__tmp.f_r;
							if ((l22_l0==1)) {
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
						final Struct l1_gsymswitch1 = f_detectOperands(l0_p.f_l, l0_p.f_r);
						Struct l2__tmp = l1_gsymswitch1;
						switch (l2__tmp.getTypeId()) {
						case 32/*IntInt*/: {
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
										if ((l7_r0==(-1))) {
											return (new Struct_Some((new Struct_ArInt((-l6_l0)))));
										} else {
											if ((l6_l0==(-1))) {
												return (new Struct_Some((new Struct_ArInt((-l7_r0)))));
											} else {
												if ((l6_l0==l7_r0)) {
													return (new Struct_Some((new Struct_ArPow((new Struct_ArInt(l6_l0)), (new Struct_ArInt(2))))));
												} else {
													return (new Struct_Some(aar0));
												}
											}
										}
									}
								}
							}
						}
						case 120/*VarInt*/: {
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
						case 27/*ExpInt*/: {
							final Struct_ExpInt l3__tmp = (Struct_ExpInt)l2__tmp;
							final Struct l12_l0 = l3__tmp.f_l;
							final int l13_r0 = l3__tmp.f_r;
							final Struct l14_l0 = l3__tmp.f_l;
							final int l15_r0 = l3__tmp.f_r;
							if ((l15_r0==0)) {
								return (new Struct_Some((new Struct_ArInt(0))));
							} else {
								if ((l15_r0==1)) {
									return (new Struct_Some(l14_l0));
								} else {
									return (new Struct_Some(aar0));
								}
							}
						}
						case 36/*IntVar*/: {
							final Struct_IntVar l3__tmp = (Struct_IntVar)l2__tmp;
							final int l16_l0 = l3__tmp.f_l;
							final String l17_r0 = l3__tmp.f_r;
							final int l18_l0 = l3__tmp.f_l;
							final String l19_r0 = l3__tmp.f_r;
							if ((l18_l0==0)) {
								return (new Struct_Some((new Struct_ArInt(0))));
							} else {
								if ((l18_l0==1)) {
									return (new Struct_Some((new Struct_ArVar(l19_r0))));
								} else {
									return (new Struct_Some(aar0));
								}
							}
						}
						case 31/*IntExp*/: {
							final Struct_IntExp l3__tmp = (Struct_IntExp)l2__tmp;
							final int l20_l0 = l3__tmp.f_l;
							final Struct l21_r0 = l3__tmp.f_r;
							final int l22_l0 = l3__tmp.f_l;
							final Struct l23_r0 = l3__tmp.f_r;
							if ((l22_l0==0)) {
								return (new Struct_Some((new Struct_ArInt(0))));
							} else {
								if ((l22_l0==1)) {
									return (new Struct_Some(l23_r0));
								} else {
									return (new Struct_Some(aar0));
								}
							}
						}
						case 123/*VarVar*/: {
							final Struct_VarVar l3__tmp = (Struct_VarVar)l2__tmp;
							final String l24_l0 = l3__tmp.f_l;
							final String l25_r0 = l3__tmp.f_r;
							final String l26_l0 = l3__tmp.f_l;
							final String l27_r0 = l3__tmp.f_r;
							if ((l27_r0).equals(l26_l0)) {
								return (new Struct_Some((new Struct_ArPow((new Struct_ArVar(l26_l0)), (new Struct_ArInt(2))))));
							} else {
								return (new Struct_Some(aar0));
							}
						}
						case 26/*ExpExp*/: {
							final Struct_ExpExp l3__tmp = (Struct_ExpExp)l2__tmp;
							final Struct l28_l0 = l3__tmp.f_l;
							final Struct l29_r0 = l3__tmp.f_r;
							final Struct l30_l0 = l3__tmp.f_l;
							final Struct l31_r0 = l3__tmp.f_r;
							if (FlowRuntime.compareEqual(l31_r0,l30_l0)) {
								return (new Struct_Some((new Struct_ArPow(l30_l0, (new Struct_ArInt(2))))));
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
			final Struct l7_it1 = f_execSimplifier(l4_it0, ((Func2<Struct,String, Struct>)(Func2)l6_$5));
			final Func2<Struct,String, Struct> l9_$8 = new Func2<Struct,String,Struct>() {
				final public Struct invoke(final String aop, final Struct aar0) {
					if ((!(aop).equals("/"))) {
						return (new Struct_Some(aar0));
					} else {
						final Struct_ArDiv l0_p = ((Struct_ArDiv)aar0);
						final Struct l1_gsymswitch2 = f_detectOperands(l0_p.f_up, l0_p.f_down);
						Struct l2__tmp = l1_gsymswitch2;
						switch (l2__tmp.getTypeId()) {
						case 32/*IntInt*/: {
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
										if ((l7_r0==(-1))) {
											return (new Struct_Some((new Struct_ArInt((-l6_l0)))));
										} else {
											if ((l7_r0==l6_l0)) {
												return (new Struct_Some((new Struct_ArInt(1))));
											} else {
												if ((l7_r0==(-l6_l0))) {
													return (new Struct_Some((new Struct_ArInt((-1)))));
												} else {
													return (new Struct_Some(aar0));
												}
											}
										}
									}
								}
							}
						}
						case 120/*VarInt*/: {
							final Struct_VarInt l3__tmp = (Struct_VarInt)l2__tmp;
							final String l8_l0 = l3__tmp.f_l;
							final int l9_r0 = l3__tmp.f_r;
							final String l10_l0 = l3__tmp.f_l;
							final int l11_r0 = l3__tmp.f_r;
							if ((l11_r0==0)) {
								return ((Struct)SingletonStructs.str_None);
							} else {
								if ((l11_r0==1)) {
									return (new Struct_Some((new Struct_ArVar(l10_l0))));
								} else {
									return (new Struct_Some(aar0));
								}
							}
						}
						case 27/*ExpInt*/: {
							final Struct_ExpInt l3__tmp = (Struct_ExpInt)l2__tmp;
							final Struct l12_l0 = l3__tmp.f_l;
							final int l13_r0 = l3__tmp.f_r;
							final Struct l14_l0 = l3__tmp.f_l;
							final int l15_r0 = l3__tmp.f_r;
							if ((l15_r0==0)) {
								return ((Struct)SingletonStructs.str_None);
							} else {
								if ((l15_r0==1)) {
									return (new Struct_Some(l14_l0));
								} else {
									return (new Struct_Some(aar0));
								}
							}
						}
						case 36/*IntVar*/: {
							final Struct_IntVar l3__tmp = (Struct_IntVar)l2__tmp;
							final int l16_l0 = l3__tmp.f_l;
							final String l17_r0 = l3__tmp.f_r;
							final int l18_l0 = l3__tmp.f_l;
							final String l19_r0 = l3__tmp.f_r;
							if ((l18_l0==0)) {
								return (new Struct_Some((new Struct_ArInt(0))));
							} else {
								return (new Struct_Some(aar0));
							}
						}
						case 31/*IntExp*/: {
							final Struct_IntExp l3__tmp = (Struct_IntExp)l2__tmp;
							final int l20_l0 = l3__tmp.f_l;
							final Struct l21_r0 = l3__tmp.f_r;
							final int l22_l0 = l3__tmp.f_l;
							final Struct l23_r0 = l3__tmp.f_r;
							if ((l22_l0==0)) {
								return (new Struct_Some((new Struct_ArInt(0))));
							} else {
								return (new Struct_Some(aar0));
							}
						}
						case 123/*VarVar*/: {
							final Struct_VarVar l3__tmp = (Struct_VarVar)l2__tmp;
							final String l24_l0 = l3__tmp.f_l;
							final String l25_r0 = l3__tmp.f_r;
							final String l26_l0 = l3__tmp.f_l;
							final String l27_r0 = l3__tmp.f_r;
							if ((l26_l0).equals(l27_r0)) {
								return (new Struct_Some((new Struct_ArInt(1))));
							} else {
								return (new Struct_Some(aar0));
							}
						}
						case 26/*ExpExp*/: {
							final Struct_ExpExp l3__tmp = (Struct_ExpExp)l2__tmp;
							final Struct l28_l0 = l3__tmp.f_l;
							final Struct l29_r0 = l3__tmp.f_r;
							final Struct l30_l0 = l3__tmp.f_l;
							final Struct l31_r0 = l3__tmp.f_r;
							if (FlowRuntime.compareEqual(l30_l0,l31_r0)) {
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
			final Struct l10_it2 = f_execSimplifier(l7_it1, l9_$8);
			final Func2<Struct_Some,String, Struct> l12_$11 = new Func2<Struct_Some,String,Struct>() {
				final public Struct_Some invoke(final String aop, final Struct aar0) {
					if ((!(aop).equals("-"))) {
						return (new Struct_Some(aar0));
					} else {
						final Struct_ArMin l0_p = ((Struct_ArMin)aar0);
						final Struct l1_gsymswitch3 = f_detectOperands(l0_p.f_l, l0_p.f_r);
						Struct l2__tmp = l1_gsymswitch3;
						switch (l2__tmp.getTypeId()) {
						case 32/*IntInt*/: {
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
										if ((l7_r0==(-l6_l0))) {
											return (new Struct_Some((new Struct_ArMult((new Struct_ArInt((-2))), (new Struct_ArInt(l7_r0))))));
										} else {
											if ((l6_l0==(-l7_r0))) {
												return (new Struct_Some((new Struct_ArMult((new Struct_ArInt(2)), (new Struct_ArInt(l6_l0))))));
											} else {
												return (new Struct_Some(aar0));
											}
										}
									}
								}
							}
						}
						case 120/*VarInt*/: {
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
						case 27/*ExpInt*/: {
							final Struct_ExpInt l3__tmp = (Struct_ExpInt)l2__tmp;
							final Struct l12_l0 = l3__tmp.f_l;
							final int l13_r0 = l3__tmp.f_r;
							final Struct l14_l0 = l3__tmp.f_l;
							final int l15_r0 = l3__tmp.f_r;
							if ((l15_r0==0)) {
								return (new Struct_Some(l14_l0));
							} else {
								return (new Struct_Some(aar0));
							}
						}
						case 36/*IntVar*/: {
							final Struct_IntVar l3__tmp = (Struct_IntVar)l2__tmp;
							final int l16_l0 = l3__tmp.f_l;
							final String l17_r0 = l3__tmp.f_r;
							final int l18_l0 = l3__tmp.f_l;
							final String l19_r0 = l3__tmp.f_r;
							if ((l18_l0==0)) {
								return (new Struct_Some((new Struct_ArMult((new Struct_ArInt((-1))), (new Struct_ArVar(l19_r0))))));
							} else {
								return (new Struct_Some(aar0));
							}
						}
						case 31/*IntExp*/: {
							final Struct_IntExp l3__tmp = (Struct_IntExp)l2__tmp;
							final int l20_l0 = l3__tmp.f_l;
							final Struct l21_r0 = l3__tmp.f_r;
							final int l22_l0 = l3__tmp.f_l;
							final Struct l23_r0 = l3__tmp.f_r;
							if ((l22_l0==0)) {
								return (new Struct_Some((new Struct_ArMult((new Struct_ArInt((-1))), l23_r0))));
							} else {
								return (new Struct_Some(aar0));
							}
						}
						case 123/*VarVar*/: {
							final Struct_VarVar l3__tmp = (Struct_VarVar)l2__tmp;
							final String l24_l0 = l3__tmp.f_l;
							final String l25_r0 = l3__tmp.f_r;
							final String l26_l0 = l3__tmp.f_l;
							final String l27_r0 = l3__tmp.f_r;
							if ((l26_l0).equals(l27_r0)) {
								return (new Struct_Some((new Struct_ArInt(0))));
							} else {
								return (new Struct_Some(aar0));
							}
						}
						case 26/*ExpExp*/: {
							final Struct_ExpExp l3__tmp = (Struct_ExpExp)l2__tmp;
							final Struct l28_l0 = l3__tmp.f_l;
							final Struct l29_r0 = l3__tmp.f_r;
							final Struct l30_l0 = l3__tmp.f_l;
							final Struct l31_r0 = l3__tmp.f_r;
							if (FlowRuntime.compareEqual(l30_l0,l31_r0)) {
								return (new Struct_Some((new Struct_ArInt(0))));
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
			final Struct l13_it3 = f_execSimplifier(l10_it2, ((Func2<Struct,String, Struct>)(Func2)l12_$11));
			final Func2<Struct_Some,String, Struct> l15_$14 = new Func2<Struct_Some,String,Struct>() {
				final public Struct_Some invoke(final String aop, final Struct aar0) {
					if ((!(aop).equals("+"))) {
						return (new Struct_Some(aar0));
					} else {
						final Struct_ArSum l0_p = ((Struct_ArSum)aar0);
						final Struct l1_gsymswitch4 = f_detectOperands(l0_p.f_l, l0_p.f_r);
						Struct l2__tmp = l1_gsymswitch4;
						switch (l2__tmp.getTypeId()) {
						case 32/*IntInt*/: {
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
										if ((l7_r0==(-l6_l0))) {
											return (new Struct_Some((new Struct_ArInt(0))));
										} else {
											return (new Struct_Some(aar0));
										}
									}
								}
							}
						}
						case 120/*VarInt*/: {
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
						case 27/*ExpInt*/: {
							final Struct_ExpInt l3__tmp = (Struct_ExpInt)l2__tmp;
							final Struct l12_l0 = l3__tmp.f_l;
							final int l13_r0 = l3__tmp.f_r;
							final Struct l14_l0 = l3__tmp.f_l;
							final int l15_r0 = l3__tmp.f_r;
							if ((l15_r0==0)) {
								return (new Struct_Some(l14_l0));
							} else {
								return (new Struct_Some(aar0));
							}
						}
						case 36/*IntVar*/: {
							final Struct_IntVar l3__tmp = (Struct_IntVar)l2__tmp;
							final int l16_l0 = l3__tmp.f_l;
							final String l17_r0 = l3__tmp.f_r;
							final int l18_l0 = l3__tmp.f_l;
							final String l19_r0 = l3__tmp.f_r;
							if ((l18_l0==0)) {
								return (new Struct_Some((new Struct_ArVar(l19_r0))));
							} else {
								return (new Struct_Some(aar0));
							}
						}
						case 31/*IntExp*/: {
							final Struct_IntExp l3__tmp = (Struct_IntExp)l2__tmp;
							final int l20_l0 = l3__tmp.f_l;
							final Struct l21_r0 = l3__tmp.f_r;
							final int l22_l0 = l3__tmp.f_l;
							final Struct l23_r0 = l3__tmp.f_r;
							if ((l22_l0==0)) {
								return (new Struct_Some(l23_r0));
							} else {
								return (new Struct_Some(aar0));
							}
						}
						case 123/*VarVar*/: {
							final Struct_VarVar l3__tmp = (Struct_VarVar)l2__tmp;
							final String l24_l0 = l3__tmp.f_l;
							final String l25_r0 = l3__tmp.f_r;
							final String l26_l0 = l3__tmp.f_l;
							final String l27_r0 = l3__tmp.f_r;
							if ((l26_l0).equals(l27_r0)) {
								return (new Struct_Some((new Struct_ArMult((new Struct_ArInt(2)), (new Struct_ArVar(l26_l0))))));
							} else {
								return (new Struct_Some(aar0));
							}
						}
						case 26/*ExpExp*/: {
							final Struct_ExpExp l3__tmp = (Struct_ExpExp)l2__tmp;
							final Struct l28_l0 = l3__tmp.f_l;
							final Struct l29_r0 = l3__tmp.f_r;
							final Struct l30_l0 = l3__tmp.f_l;
							final Struct l31_r0 = l3__tmp.f_r;
							if (FlowRuntime.compareEqual(l30_l0,l31_r0)) {
								return (new Struct_Some((new Struct_ArMult((new Struct_ArInt(2)), l30_l0))));
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
	Struct f_simplifyTree(Struct aar) {
		final Struct l0_x = f_removeTrivialExp(aar, ((Struct)SingletonStructs.str_None), 0);
		Struct l1__tmp = l0_x;
		switch (l1__tmp.getTypeId()) {
		case 50/*None*/: {
			return ((Struct)SingletonStructs.str_None);
		}
		case 113/*Some*/: {
			final Struct_Some l2__tmp = (Struct_Some)l1__tmp;
			final Object l3_val = l2__tmp.f_value;
			final Struct l4_val = ((Struct)l2__tmp.f_value);
			return f_foldEqualOperands(l4_val, ((Struct)SingletonStructs.str_None), 0);
		}
		default:
			throw new RuntimeException("Unexpected struct in switch: "+l1__tmp.getTypeName());
		}
	}
}
