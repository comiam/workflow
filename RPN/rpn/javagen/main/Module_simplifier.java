// HASH COLLISIONS: YES
// timestamp: 1.602567275E12

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
		case 9/*ArDouble*/: {
			final Struct_ArDouble l1__tmp = (Struct_ArDouble)l0__tmp;
			final double l2_val = l1__tmp.f_val;
			final double l3_val = l1__tmp.f_val;
			return l1__tmp;
		}
		case 16/*ArVar*/: {
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
		case 13/*ArPow*/: {
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
		case 11/*ArMin*/: {
			final Struct_ArMin l1__tmp = (Struct_ArMin)l0__tmp;
			final Struct l10_l = l1__tmp.f_l;
			final Struct l11_r = l1__tmp.f_r;
			final Struct l12_l = l1__tmp.f_l;
			final Struct l13_r = l1__tmp.f_r;
			return "-";
		}
		case 15/*ArSum*/: {
			final Struct_ArSum l1__tmp = (Struct_ArSum)l0__tmp;
			final Struct l14_l = l1__tmp.f_l;
			final Struct l15_r = l1__tmp.f_r;
			final Struct l16_l = l1__tmp.f_l;
			final Struct l17_r = l1__tmp.f_r;
			return "+";
		}
		case 12/*ArMult*/: {
			final Struct_ArMult l1__tmp = (Struct_ArMult)l0__tmp;
			final Struct l18_l = l1__tmp.f_l;
			final Struct l19_r = l1__tmp.f_r;
			final Struct l20_l = l1__tmp.f_l;
			final Struct l21_r = l1__tmp.f_r;
			return "*";
		}
		case 9/*ArDouble*/: {
			final Struct_ArDouble l1__tmp = (Struct_ArDouble)l0__tmp;
			final double l22_val = l1__tmp.f_val;
			final double l23_val = l1__tmp.f_val;
			return "int";
		}
		case 16/*ArVar*/: {
			final Struct_ArVar l1__tmp = (Struct_ArVar)l0__tmp;
			final String l24_var = l1__tmp.f_var;
			final String l25_var = l1__tmp.f_var;
			return "variable";
		}
		case 10/*ArLn*/: {
			final Struct_ArLn l1__tmp = (Struct_ArLn)l0__tmp;
			final Struct l26_v = l1__tmp.f_l;
			final Struct l27_v = l1__tmp.f_l;
			return "ln";
		}
		default:
			throw new RuntimeException("Unexpected struct in switch: "+l0__tmp.getTypeName());
		}
	}
	Struct f_execSimplifier(Struct am, Func2<Struct,String, Struct> acondOp) {
		final Object[] l0_arr = f_extractArgs(am);
		if ((runtime.h_Native.length(l0_arr)<2)) {
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
		case 13/*ArPow*/: {
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
		case 11/*ArMin*/: {
			final Struct_ArMin l1__tmp = (Struct_ArMin)l0__tmp;
			final Struct l10_l = l1__tmp.f_l;
			final Struct l11_r = l1__tmp.f_r;
			final Struct l12_l = l1__tmp.f_l;
			final Struct l13_r = l1__tmp.f_r;
			return (new Object[] { l12_l, l13_r });
		}
		case 15/*ArSum*/: {
			final Struct_ArSum l1__tmp = (Struct_ArSum)l0__tmp;
			final Struct l14_l = l1__tmp.f_l;
			final Struct l15_r = l1__tmp.f_r;
			final Struct l16_l = l1__tmp.f_l;
			final Struct l17_r = l1__tmp.f_r;
			return (new Object[] { l16_l, l17_r });
		}
		case 12/*ArMult*/: {
			final Struct_ArMult l1__tmp = (Struct_ArMult)l0__tmp;
			final Struct l18_l = l1__tmp.f_l;
			final Struct l19_r = l1__tmp.f_r;
			final Struct l20_l = l1__tmp.f_l;
			final Struct l21_r = l1__tmp.f_r;
			return (new Object[] { l20_l, l21_r });
		}
		case 10/*ArLn*/: {
			final Struct_ArLn l1__tmp = (Struct_ArLn)l0__tmp;
			final Struct l22_v = l1__tmp.f_l;
			final Struct l23_v = l1__tmp.f_l;
			return (new Object[] { l23_v, (new Struct_ArDouble(0.0)) });
		}
		default: {
			return (new Object[] { aar });
		}
		}
	}
	Struct_Pair f_extractSign(Struct aar) {
		final Object[] l0_arr = f_extractArgs(aar);
		if ((runtime.h_Native.length(l0_arr)<2)) {
			if ((((boolean)f_getD(aar).f_first)&&(((double)f_getD(aar).f_second)<0.0))) {
				return (new Struct_Pair((-1), (new Struct_ArDouble(runtime.m_math.f_abs(((double)f_getD(aar).f_second))))));
			} else {
				return (new Struct_Pair(1, aar));
			}
		} else {
			final String l1_op = f_detectType(aar);
			runtime.m_runtime.f_println(l1_op);
			runtime.m_runtime.f_println(aar);
			final Struct_Pair l2_newL = f_extractSign(((Struct)(l0_arr[0])));
			final Struct_Pair l3_newR = f_extractSign(((Struct)(l0_arr[1])));
			final Func2<Integer,Integer, Integer> l4_signMul = new Func2<Integer,Integer,Integer>() {
				final public Integer invoke(final Integer al, final Integer ar) {
					if (((((int)al)*((int)ar))>0)) {
						return ((Integer)1);
					} else {
						return ((Integer)(-1));
					}
				}
			};
			if (((l1_op).equals("*")||(l1_op).equals("/"))) {
				return (new Struct_Pair(l4_signMul.invoke(((Integer)l2_newL.f_first), ((Integer)l3_newR.f_first)), f_createStruct(l1_op, ((Struct)l2_newL.f_second), ((Struct)l3_newR.f_second))));
			} else {
				if ((l1_op).equals("-")) {
					if (((((int)l2_newL.f_first)<0)&&(((int)l3_newR.f_first)>0))) {
						return (new Struct_Pair((-1), f_createStruct("+", ((Struct)l2_newL.f_second), ((Struct)l3_newR.f_second))));
					} else {
						if (((((int)l2_newL.f_first)>0)&&(((int)l3_newR.f_first)<0))) {
							return (new Struct_Pair(1, f_createStruct("+", ((Struct)l2_newL.f_second), ((Struct)l3_newR.f_second))));
						} else {
							if (((((int)l2_newL.f_first)<0)&&(((int)l3_newR.f_first)<0))) {
								return (new Struct_Pair(1, f_createStruct("+", (new Struct_ArMult((new Struct_ArDouble((-1.0))), ((Struct)l2_newL.f_second))), ((Struct)l3_newR.f_second))));
							} else {
								return (new Struct_Pair(1, f_createStruct(l1_op, ((Struct)l2_newL.f_second), ((Struct)l3_newR.f_second))));
							}
						}
					}
				} else {
					if ((l1_op).equals("+")) {
						if (((((int)l2_newL.f_first)<0)&&(((int)l3_newR.f_first)<0))) {
							return (new Struct_Pair((-1), f_createStruct("+", ((Struct)l2_newL.f_second), ((Struct)l3_newR.f_second))));
						} else {
							if (((((int)l2_newL.f_first)>0)&&(((int)l3_newR.f_first)<0))) {
								return (new Struct_Pair(1, f_createStruct("-", ((Struct)l2_newL.f_second), ((Struct)l3_newR.f_second))));
							} else {
								if (((((int)l2_newL.f_first)<0)&&(((int)l3_newR.f_first)>0))) {
									return (new Struct_Pair(1, f_createStruct("-", ((Struct)l3_newR.f_second), ((Struct)l2_newL.f_second))));
								} else {
									return (new Struct_Pair(1, f_createStruct(l1_op, ((Struct)l2_newL.f_second), ((Struct)l3_newR.f_second))));
								}
							}
						}
					} else {
						return (new Struct_Pair(1, f_createStruct(l1_op, ((Struct)l2_newL.f_second), ((Struct)l3_newR.f_second))));
					}
				}
			}
		}
	}
	Struct f_foldExpressions(Struct aar) {
	 TAIL_CALL: for(;;) {
		final Func2<Struct,String, Struct> l1_$0 = new Func2<Struct,String,Struct>() {
			final public Struct invoke(final String aop, final Struct aar0) {
				final Object[] l0_args = f_extractArgs(aar0);
				if ((runtime.h_Native.length(l0_args)==2)) {
					final Struct l1_p0 = f_foldSigns(((Struct)(l0_args[0])));
					final Struct l2_p1 = f_foldSigns(((Struct)(l0_args[1])));
					final String l3_op0 = f_detectType(l1_p0);
					final String l4_op1 = f_detectType(l2_p1);
					final Object[] l5_arg0 = f_extractArgs(l1_p0);
					final Object[] l6_arg1 = f_extractArgs(l2_p1);
					if ((aop).equals("+")) {
						if (((l3_op0).equals("+")&&(l4_op1).equals("-"))) {
							if (FlowRuntime.compareEqual(((Struct)(l6_arg1[1])),((Struct)(l5_arg0[0])))) {
								return (new Struct_ArSum(((Struct)(l5_arg0[1])), ((Struct)(l6_arg1[0]))));
							} else {
								if (FlowRuntime.compareEqual(((Struct)(l6_arg1[1])),((Struct)(l5_arg0[1])))) {
									return (new Struct_ArSum(((Struct)(l5_arg0[0])), ((Struct)(l6_arg1[0]))));
								} else {
									return aar0;
								}
							}
						} else {
							if (((l3_op0).equals("-")&&(l4_op1).equals("+"))) {
								if (FlowRuntime.compareEqual(((Struct)(l5_arg0[1])),((Struct)(l6_arg1[0])))) {
									return (new Struct_ArSum(((Struct)(l5_arg0[0])), ((Struct)(l6_arg1[1]))));
								} else {
									if (FlowRuntime.compareEqual(((Struct)(l5_arg0[1])),((Struct)(l6_arg1[1])))) {
										return (new Struct_ArSum(((Struct)(l5_arg0[0])), ((Struct)(l6_arg1[0]))));
									} else {
										return aar0;
									}
								}
							} else {
								if (((l3_op0).equals("-")&&(l4_op1).equals("-"))) {
									if (FlowRuntime.compareEqual(((Struct)(l5_arg0[0])),((Struct)(l6_arg1[1])))) {
										return (new Struct_ArMin(((Struct)(l6_arg1[0])), ((Struct)(l5_arg0[1]))));
									} else {
										return aar0;
									}
								} else {
									if ((f_isAtom(((Struct)(l6_arg1[0])))||f_isAtom(((Struct)(l5_arg0[0]))))) {
										if (((l3_op0).equals("-")&&FlowRuntime.compareEqual(((Struct)(l5_arg0[1])),((Struct)(l6_arg1[0]))))) {
											return ((Struct)(l5_arg0[0]));
										} else {
											if (((l4_op1).equals("-")&&FlowRuntime.compareEqual(((Struct)(l6_arg1[1])),((Struct)(l5_arg0[0]))))) {
												return ((Struct)(l6_arg1[0]));
											} else {
												return aar0;
											}
										}
									} else {
										return aar0;
									}
								}
							}
						}
					} else {
						if ((aop).equals("-")) {
							if (((l3_op0).equals("+")&&(l4_op1).equals("-"))) {
								if (FlowRuntime.compareEqual(((Struct)(l6_arg1[0])),((Struct)(l5_arg0[0])))) {
									return (new Struct_ArSum(((Struct)(l5_arg0[1])), ((Struct)(l6_arg1[1]))));
								} else {
									if (FlowRuntime.compareEqual(((Struct)(l6_arg1[0])),((Struct)(l5_arg0[1])))) {
										return (new Struct_ArSum(((Struct)(l5_arg0[0])), ((Struct)(l6_arg1[1]))));
									} else {
										return aar0;
									}
								}
							} else {
								if (((l3_op0).equals("-")&&(l4_op1).equals("+"))) {
									if (FlowRuntime.compareEqual(((Struct)(l5_arg0[0])),((Struct)(l6_arg1[1])))) {
										return (new Struct_ArMult((new Struct_ArDouble((-1.0))), (new Struct_ArSum(((Struct)(l5_arg0[1])), ((Struct)(l6_arg1[0]))))));
									} else {
										if (FlowRuntime.compareEqual(((Struct)(l5_arg0[0])),((Struct)(l6_arg1[0])))) {
											return (new Struct_ArMult((new Struct_ArDouble((-1.0))), (new Struct_ArSum(((Struct)(l5_arg0[1])), ((Struct)(l6_arg1[1]))))));
										} else {
											return aar0;
										}
									}
								} else {
									if (((l3_op0).equals("-")&&(l4_op1).equals("-"))) {
										if (FlowRuntime.compareEqual(((Struct)(l5_arg0[1])),((Struct)(l6_arg1[1])))) {
											return (new Struct_ArMin(((Struct)(l5_arg0[0])), ((Struct)(l6_arg1[0]))));
										} else {
											return aar0;
										}
									} else {
										if (((l3_op0).equals("+")&&(l4_op1).equals("+"))) {
											if (FlowRuntime.compareEqual(((Struct)(l5_arg0[0])),((Struct)(l6_arg1[1])))) {
												return (new Struct_ArMin(((Struct)(l5_arg0[1])), ((Struct)(l6_arg1[0]))));
											} else {
												if (FlowRuntime.compareEqual(((Struct)(l5_arg0[0])),((Struct)(l6_arg1[0])))) {
													return (new Struct_ArMin(((Struct)(l5_arg0[1])), ((Struct)(l6_arg1[1]))));
												} else {
													if (FlowRuntime.compareEqual(((Struct)(l5_arg0[1])),((Struct)(l6_arg1[1])))) {
														return (new Struct_ArMin(((Struct)(l5_arg0[0])), ((Struct)(l6_arg1[0]))));
													} else {
														if (FlowRuntime.compareEqual(((Struct)(l5_arg0[1])),((Struct)(l6_arg1[0])))) {
															return (new Struct_ArMin(((Struct)(l5_arg0[0])), ((Struct)(l6_arg1[1]))));
														} else {
															return aar0;
														}
													}
												}
											}
										} else {
											if ((f_isAtom(((Struct)(l6_arg1[0])))||f_isAtom(((Struct)(l5_arg0[0]))))) {
												if (((l3_op0).equals("+")&&FlowRuntime.compareEqual(((Struct)(l5_arg0[1])),((Struct)(l6_arg1[0]))))) {
													return ((Struct)(l5_arg0[0]));
												} else {
													if (((l3_op0).equals("+")&&FlowRuntime.compareEqual(((Struct)(l5_arg0[0])),((Struct)(l6_arg1[0]))))) {
														return ((Struct)(l5_arg0[1]));
													} else {
														if (((l3_op0).equals("-")&&FlowRuntime.compareEqual(((Struct)(l5_arg0[0])),((Struct)(l6_arg1[0]))))) {
															return (new Struct_ArMult((new Struct_ArDouble((-1.0))), ((Struct)(l5_arg0[1]))));
														} else {
															if (((l4_op1).equals("+")&&FlowRuntime.compareEqual(((Struct)(l5_arg0[0])),((Struct)(l6_arg1[0]))))) {
																return (new Struct_ArMult((new Struct_ArDouble((-1.0))), ((Struct)(l6_arg1[1]))));
															} else {
																if (((l4_op1).equals("+")&&FlowRuntime.compareEqual(((Struct)(l5_arg0[0])),((Struct)(l6_arg1[1]))))) {
																	return (new Struct_ArMult((new Struct_ArDouble((-1.0))), ((Struct)(l6_arg1[0]))));
																} else {
																	if (((l4_op1).equals("-")&&FlowRuntime.compareEqual(((Struct)(l5_arg0[0])),((Struct)(l6_arg1[0]))))) {
																		return ((Struct)(l6_arg1[1]));
																	} else {
																		return aar0;
																	}
																}
															}
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
				} else {
					return aar0;
				}
			}
		};
		final Struct l2_it = f_execSimplifier(aar, l1_$0);
		if (FlowRuntime.compareEqual(l2_it,aar)) {
			return l2_it;
		} else {
			{
				final Struct l3___tmp = l2_it;
				aar = l3___tmp;
				continue TAIL_CALL;
			}
		}
	 }
	}
	Struct f_foldSigns(Struct aar) {
	 TAIL_CALL: for(;;) {
		final Struct_Pair l0_it = f_extractSign(aar);
		if (FlowRuntime.compareEqual(l0_it.f_second,aar)) {
			if ((((int)l0_it.f_first)==(-1))) {
				return (new Struct_ArMult((new Struct_ArDouble((-1.0))), ((Struct)l0_it.f_second)));
			} else {
				return ((Struct)l0_it.f_second);
			}
		} else {
			if ((((int)l0_it.f_first)==(-1))) {
				{
					final Struct l1___tmp = (new Struct_ArMult((new Struct_ArDouble((-1.0))), ((Struct)l0_it.f_second)));
					aar = l1___tmp;
					continue TAIL_CALL;
				}
			} else {
				{
					final Struct l2___tmp = ((Struct)l0_it.f_second);
					aar = l2___tmp;
					continue TAIL_CALL;
				}
			}
		}
	 }
	}
	Struct_Pair f_getD(Struct aa) {
		Struct l0__tmp = aa;
		switch (l0__tmp.getTypeId()) {
		case 9/*ArDouble*/: {
			final Struct_ArDouble l1__tmp = (Struct_ArDouble)l0__tmp;
			final double l2_val = l1__tmp.f_val;
			final double l3_val = l1__tmp.f_val;
			return (new Struct_Pair(true, l3_val));
		}
		default: {
			return (new Struct_Pair(false, 5.0));
		}
		}
	}
	boolean f_isAtom(Struct aa) {
		Struct l0__tmp = aa;
		switch (l0__tmp.getTypeId()) {
		case 9/*ArDouble*/: {
			final Struct_ArDouble l1__tmp = (Struct_ArDouble)l0__tmp;
			final double l2_val = l1__tmp.f_val;
			final double l3_val = l1__tmp.f_val;
			return true;
		}
		case 16/*ArVar*/: {
			final Struct_ArVar l1__tmp = (Struct_ArVar)l0__tmp;
			final String l4_var = l1__tmp.f_var;
			final String l5_var = l1__tmp.f_var;
			return true;
		}
		default: {
			return false;
		}
		}
	}
	Struct f_removeTrivialExp(Struct aar) {
	 TAIL_CALL: for(;;) {
		final Func2<Struct,String, Struct> l1_$0 = new Func2<Struct,String,Struct>() {
			final public Struct invoke(final String aop, final Struct aar0) {
				final Object[] l0_args = f_extractArgs(aar0);
				if ((runtime.h_Native.length(l0_args)==2)) {
					final boolean l1_flag0 = ((boolean)f_getD(((Struct)(l0_args[0]))).f_first);
					final boolean l2_flag1 = ((boolean)f_getD(((Struct)(l0_args[1]))).f_first);
					final double l3_l0 = ((double)f_getD(((Struct)(l0_args[0]))).f_second);
					final double l4_r0 = ((double)f_getD(((Struct)(l0_args[1]))).f_second);
					if ((aop).equals("^")) {
						if ((l4_r0==0.0)) {
							return (new Struct_ArDouble(1.0));
						} else {
							if ((l4_r0==0.1)) {
								return ((Struct)(l0_args[0]));
							} else {
								if ((l3_l0==0.1)) {
									return (new Struct_ArDouble(1.0));
								} else {
									if ((((l3_l0==0.0)&&((boolean)f_getD(((Struct)(l0_args[1]))).f_first))&&(l4_r0!=0.1))) {
										return (new Struct_ArDouble(0.0));
									} else {
										if ((l1_flag0&&l2_flag1)) {
											return (new Struct_ArDouble(runtime.m_math.f_dpow(l3_l0, l4_r0)));
										} else {
											return aar0;
										}
									}
								}
							}
						}
					} else {
						if ((aop).equals("*")) {
							if (((l4_r0==0.0)||(l3_l0==0.0))) {
								return (new Struct_ArDouble(0.0));
							} else {
								if ((l4_r0==1.0)) {
									return ((Struct)(l0_args[0]));
								} else {
									if ((l3_l0==1.0)) {
										return ((Struct)(l0_args[1]));
									} else {
										if (FlowRuntime.compareEqual(((Struct)(l0_args[0])),((Struct)(l0_args[1])))) {
											return (new Struct_ArPow(((Struct)(l0_args[0])), (new Struct_ArDouble(2.0))));
										} else {
											if ((l1_flag0&&l2_flag1)) {
												return (new Struct_ArDouble((l3_l0*l4_r0)));
											} else {
												return aar0;
											}
										}
									}
								}
							}
						} else {
							if ((aop).equals("/")) {
								if ((l3_l0==0.0)) {
									return (new Struct_ArDouble(0.0));
								} else {
									if ((l4_r0==1.0)) {
										return ((Struct)(l0_args[0]));
									} else {
										if (FlowRuntime.compareEqual(((Struct)(l0_args[0])),((Struct)(l0_args[1])))) {
											return (new Struct_ArDouble(1.0));
										} else {
											if ((l1_flag0&&l2_flag1)) {
												return (new Struct_ArDouble((l3_l0/l4_r0)));
											} else {
												return aar0;
											}
										}
									}
								}
							} else {
								if ((aop).equals("-")) {
									if (FlowRuntime.compareEqual(((Struct)(l0_args[0])),((Struct)(l0_args[1])))) {
										return (new Struct_ArDouble(0.0));
									} else {
										if ((l4_r0==0.0)) {
											return ((Struct)(l0_args[0]));
										} else {
											if ((l1_flag0&&l2_flag1)) {
												return (new Struct_ArDouble((l3_l0-l4_r0)));
											} else {
												return aar0;
											}
										}
									}
								} else {
									if ((aop).equals("+")) {
										if ((l3_l0==0.0)) {
											return ((Struct)(l0_args[1]));
										} else {
											if ((l4_r0==0.0)) {
												return ((Struct)(l0_args[0]));
											} else {
												if (FlowRuntime.compareEqual(((Struct)(l0_args[0])),((Struct)(l0_args[1])))) {
													return (new Struct_ArMult((new Struct_ArDouble(2.0)), ((Struct)(l0_args[0]))));
												} else {
													if ((l1_flag0&&l2_flag1)) {
														return (new Struct_ArDouble((l3_l0+l4_r0)));
													} else {
														return aar0;
													}
												}
											}
										}
									} else {
										if ((aop).equals("ln")) {
											if ((l3_l0==1.0)) {
												return (new Struct_ArDouble(0.0));
											} else {
												if ((l3_l0==runtime.m_math.g_E_CONST)) {
													return (new Struct_ArDouble(1.0));
												} else {
													return aar0;
												}
											}
										} else {
											return aar0;
										}
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
		final Struct l2_it = f_execSimplifier(aar, l1_$0);
		if (FlowRuntime.compareEqual(l2_it,aar)) {
			return l2_it;
		} else {
			{
				final Struct l3___tmp = l2_it;
				aar = l3___tmp;
				continue TAIL_CALL;
			}
		}
	 }
	}
	Struct f_simplifyTree(Struct aar) {
	 TAIL_CALL: for(;;) {
		final Struct l0_it0 = f_foldSigns(aar);
		final Struct l1_it1 = f_removeTrivialExp(l0_it0);
		final Struct l2_it2 = f_foldSigns(l1_it1);
		final Struct l3_it3 = f_foldExpressions(l2_it2);
		if (FlowRuntime.compareEqual(aar,l3_it3)) {
			return aar;
		} else {
			{
				final Struct l4___tmp = l3_it3;
				aar = l4___tmp;
				continue TAIL_CALL;
			}
		}
	 }
	}
}
