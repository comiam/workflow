// HASH COLLISIONS: YES
// timestamp: 1.603191287E12

package main;

import com.area9innovation.flow.*;

@SuppressWarnings("unchecked")
final class Module_simplifier {
	final main runtime;
	Module_simplifier(main runtime) {
		this.runtime = runtime;
	}
	double f_convVals(String aop, double ad0, double ad1) {
		if ((aop).equals("+")) {
			return (ad0+ad1);
		} else {
			if ((aop).equals("-")) {
				return (ad0-ad1);
			} else {
				if ((aop).equals("*")) {
					return (ad0*ad1);
				} else {
					if ((aop).equals("/")) {
						return (ad0/ad1);
					} else {
						return ad0;
					}
				}
			}
		}
	}
	Struct f_createStruct(String aop, Struct al, Struct ar) {
		if ((aop).equals("+")) {
			return (new Struct_AlgSum(al, ar));
		} else {
			if ((aop).equals("-")) {
				return (new Struct_AlgMin(al, ar));
			} else {
				if ((aop).equals("*")) {
					return (new Struct_AlgMult(al, ar));
				} else {
					if ((aop).equals("/")) {
						return (new Struct_AlgDiv(al, ar));
					} else {
						return al;
					}
				}
			}
		}
	}
	Struct f_detectAndReplace(Struct aar, Func2<Struct,String, Struct> acondOp) {
		Struct l0__tmp = aar;
		switch (l0__tmp.getTypeId()) {
		case 9/*AlgDouble*/: {
			final Struct_AlgDouble l1__tmp = (Struct_AlgDouble)l0__tmp;
			final double l2_val = l1__tmp.f_val;
			final double l3_val = l1__tmp.f_val;
			return l1__tmp;
		}
		case 13/*AlgVar*/: {
			final Struct_AlgVar l1__tmp = (Struct_AlgVar)l0__tmp;
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
		case 8/*AlgDiv*/: {
			final Struct_AlgDiv l1__tmp = (Struct_AlgDiv)l0__tmp;
			final Struct l2_up = l1__tmp.f_up;
			final Struct l3_down = l1__tmp.f_down;
			final Struct l4_up = l1__tmp.f_up;
			final Struct l5_down = l1__tmp.f_down;
			return "/";
		}
		case 10/*AlgMin*/: {
			final Struct_AlgMin l1__tmp = (Struct_AlgMin)l0__tmp;
			final Struct l6_l = l1__tmp.f_l;
			final Struct l7_r = l1__tmp.f_r;
			final Struct l8_l = l1__tmp.f_l;
			final Struct l9_r = l1__tmp.f_r;
			return "-";
		}
		case 12/*AlgSum*/: {
			final Struct_AlgSum l1__tmp = (Struct_AlgSum)l0__tmp;
			final Struct l10_l = l1__tmp.f_l;
			final Struct l11_r = l1__tmp.f_r;
			final Struct l12_l = l1__tmp.f_l;
			final Struct l13_r = l1__tmp.f_r;
			return "+";
		}
		case 11/*AlgMult*/: {
			final Struct_AlgMult l1__tmp = (Struct_AlgMult)l0__tmp;
			final Struct l14_l = l1__tmp.f_l;
			final Struct l15_r = l1__tmp.f_r;
			final Struct l16_l = l1__tmp.f_l;
			final Struct l17_r = l1__tmp.f_r;
			return "*";
		}
		case 9/*AlgDouble*/: {
			final Struct_AlgDouble l1__tmp = (Struct_AlgDouble)l0__tmp;
			final double l18_val = l1__tmp.f_val;
			final double l19_val = l1__tmp.f_val;
			return "int";
		}
		case 13/*AlgVar*/: {
			final Struct_AlgVar l1__tmp = (Struct_AlgVar)l0__tmp;
			final String l20_var = l1__tmp.f_var;
			final String l21_var = l1__tmp.f_var;
			return "variable";
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
		case 8/*AlgDiv*/: {
			final Struct_AlgDiv l1__tmp = (Struct_AlgDiv)l0__tmp;
			final Struct l2_up = l1__tmp.f_up;
			final Struct l3_down = l1__tmp.f_down;
			final Struct l4_up = l1__tmp.f_up;
			final Struct l5_down = l1__tmp.f_down;
			return (new Object[] { l4_up, l5_down });
		}
		case 10/*AlgMin*/: {
			final Struct_AlgMin l1__tmp = (Struct_AlgMin)l0__tmp;
			final Struct l6_l = l1__tmp.f_l;
			final Struct l7_r = l1__tmp.f_r;
			final Struct l8_l = l1__tmp.f_l;
			final Struct l9_r = l1__tmp.f_r;
			return (new Object[] { l8_l, l9_r });
		}
		case 12/*AlgSum*/: {
			final Struct_AlgSum l1__tmp = (Struct_AlgSum)l0__tmp;
			final Struct l10_l = l1__tmp.f_l;
			final Struct l11_r = l1__tmp.f_r;
			final Struct l12_l = l1__tmp.f_l;
			final Struct l13_r = l1__tmp.f_r;
			return (new Object[] { l12_l, l13_r });
		}
		case 11/*AlgMult*/: {
			final Struct_AlgMult l1__tmp = (Struct_AlgMult)l0__tmp;
			final Struct l14_l = l1__tmp.f_l;
			final Struct l15_r = l1__tmp.f_r;
			final Struct l16_l = l1__tmp.f_l;
			final Struct l17_r = l1__tmp.f_r;
			return (new Object[] { l16_l, l17_r });
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
				return (new Struct_Pair((-1), (new Struct_AlgDouble(runtime.m_math.f_abs(((double)f_getD(aar).f_second))))));
			} else {
				return (new Struct_Pair(1, aar));
			}
		} else {
			final String l1_op = f_detectType(aar);
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
								return (new Struct_Pair(1, f_createStruct("+", (new Struct_AlgMult((new Struct_AlgDouble((-1.0))), ((Struct)l2_newL.f_second))), ((Struct)l3_newR.f_second))));
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
			final public Struct invoke(final String aop, final Struct amAr) {
				final Object[] l0_args = f_extractArgs(amAr);
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
								return (new Struct_AlgSum(((Struct)(l5_arg0[1])), ((Struct)(l6_arg1[0]))));
							} else {
								if (FlowRuntime.compareEqual(((Struct)(l6_arg1[1])),((Struct)(l5_arg0[1])))) {
									return (new Struct_AlgSum(((Struct)(l5_arg0[0])), ((Struct)(l6_arg1[0]))));
								} else {
									return amAr;
								}
							}
						} else {
							if (((l3_op0).equals("-")&&(l4_op1).equals("+"))) {
								if (FlowRuntime.compareEqual(((Struct)(l5_arg0[1])),((Struct)(l6_arg1[0])))) {
									return (new Struct_AlgSum(((Struct)(l5_arg0[0])), ((Struct)(l6_arg1[1]))));
								} else {
									if (FlowRuntime.compareEqual(((Struct)(l5_arg0[1])),((Struct)(l6_arg1[1])))) {
										return (new Struct_AlgSum(((Struct)(l5_arg0[0])), ((Struct)(l6_arg1[0]))));
									} else {
										return amAr;
									}
								}
							} else {
								if (((l3_op0).equals("-")&&(l4_op1).equals("-"))) {
									if (FlowRuntime.compareEqual(((Struct)(l5_arg0[0])),((Struct)(l6_arg1[1])))) {
										return (new Struct_AlgMin(((Struct)(l6_arg1[0])), ((Struct)(l5_arg0[1]))));
									} else {
										return amAr;
									}
								} else {
									if ((f_isAtom(((Struct)(l6_arg1[0])))||f_isAtom(((Struct)(l5_arg0[0]))))) {
										if (((l3_op0).equals("-")&&FlowRuntime.compareEqual(((Struct)(l5_arg0[1])),((Struct)(l6_arg1[0]))))) {
											return ((Struct)(l5_arg0[0]));
										} else {
											if (((l4_op1).equals("-")&&FlowRuntime.compareEqual(((Struct)(l6_arg1[1])),((Struct)(l5_arg0[0]))))) {
												return ((Struct)(l6_arg1[0]));
											} else {
												return amAr;
											}
										}
									} else {
										return amAr;
									}
								}
							}
						}
					} else {
						if ((aop).equals("-")) {
							if (((l3_op0).equals("+")&&(l4_op1).equals("-"))) {
								if (FlowRuntime.compareEqual(((Struct)(l6_arg1[0])),((Struct)(l5_arg0[0])))) {
									return (new Struct_AlgSum(((Struct)(l5_arg0[1])), ((Struct)(l6_arg1[1]))));
								} else {
									if (FlowRuntime.compareEqual(((Struct)(l6_arg1[0])),((Struct)(l5_arg0[1])))) {
										return (new Struct_AlgSum(((Struct)(l5_arg0[0])), ((Struct)(l6_arg1[1]))));
									} else {
										return amAr;
									}
								}
							} else {
								if (((l3_op0).equals("-")&&(l4_op1).equals("+"))) {
									if (FlowRuntime.compareEqual(((Struct)(l5_arg0[0])),((Struct)(l6_arg1[1])))) {
										return (new Struct_AlgMult((new Struct_AlgDouble((-1.0))), (new Struct_AlgSum(((Struct)(l5_arg0[1])), ((Struct)(l6_arg1[0]))))));
									} else {
										if (FlowRuntime.compareEqual(((Struct)(l5_arg0[0])),((Struct)(l6_arg1[0])))) {
											return (new Struct_AlgMult((new Struct_AlgDouble((-1.0))), (new Struct_AlgSum(((Struct)(l5_arg0[1])), ((Struct)(l6_arg1[1]))))));
										} else {
											return amAr;
										}
									}
								} else {
									if (((l3_op0).equals("-")&&(l4_op1).equals("-"))) {
										if (FlowRuntime.compareEqual(((Struct)(l5_arg0[1])),((Struct)(l6_arg1[1])))) {
											return (new Struct_AlgMin(((Struct)(l5_arg0[0])), ((Struct)(l6_arg1[0]))));
										} else {
											return amAr;
										}
									} else {
										if (((l3_op0).equals("+")&&(l4_op1).equals("+"))) {
											if (FlowRuntime.compareEqual(((Struct)(l5_arg0[0])),((Struct)(l6_arg1[1])))) {
												return (new Struct_AlgMin(((Struct)(l5_arg0[1])), ((Struct)(l6_arg1[0]))));
											} else {
												if (FlowRuntime.compareEqual(((Struct)(l5_arg0[0])),((Struct)(l6_arg1[0])))) {
													return (new Struct_AlgMin(((Struct)(l5_arg0[1])), ((Struct)(l6_arg1[1]))));
												} else {
													if (FlowRuntime.compareEqual(((Struct)(l5_arg0[1])),((Struct)(l6_arg1[1])))) {
														return (new Struct_AlgMin(((Struct)(l5_arg0[0])), ((Struct)(l6_arg1[0]))));
													} else {
														if (FlowRuntime.compareEqual(((Struct)(l5_arg0[1])),((Struct)(l6_arg1[0])))) {
															return (new Struct_AlgMin(((Struct)(l5_arg0[0])), ((Struct)(l6_arg1[1]))));
														} else {
															return amAr;
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
															return (new Struct_AlgMult((new Struct_AlgDouble((-1.0))), ((Struct)(l5_arg0[1]))));
														} else {
															if (((l4_op1).equals("+")&&FlowRuntime.compareEqual(((Struct)(l5_arg0[0])),((Struct)(l6_arg1[0]))))) {
																return (new Struct_AlgMult((new Struct_AlgDouble((-1.0))), ((Struct)(l6_arg1[1]))));
															} else {
																if (((l4_op1).equals("+")&&FlowRuntime.compareEqual(((Struct)(l5_arg0[0])),((Struct)(l6_arg1[1]))))) {
																	return (new Struct_AlgMult((new Struct_AlgDouble((-1.0))), ((Struct)(l6_arg1[0]))));
																} else {
																	if (((l4_op1).equals("-")&&FlowRuntime.compareEqual(((Struct)(l5_arg0[0])),((Struct)(l6_arg1[0]))))) {
																		return ((Struct)(l6_arg1[1]));
																	} else {
																		return amAr;
																	}
																}
															}
														}
													}
												}
											} else {
												return amAr;
											}
										}
									}
								}
							}
						} else {
							return amAr;
						}
					}
				} else {
					return amAr;
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
		runtime.m_runtime.f_println(((runtime.m_syntax_tree.f_alg2s(((Struct)l0_it.f_second))+"\n")+runtime.m_syntax_tree.f_alg2s(aar)));
		if ((runtime.m_syntax_tree.f_alg2s(((Struct)l0_it.f_second))).equals(runtime.m_syntax_tree.f_alg2s(aar))) {
			if ((((int)l0_it.f_first)==(-1))) {
				return (new Struct_AlgMult((new Struct_AlgDouble((-1.0))), ((Struct)l0_it.f_second)));
			} else {
				return ((Struct)l0_it.f_second);
			}
		} else {
			if ((((int)l0_it.f_first)==(-1))) {
				if (((boolean)f_getD(((Struct)l0_it.f_second)).f_first)) {
					return (new Struct_AlgDouble((((double)f_getD(((Struct)l0_it.f_second)).f_second)*(-1.0))));
				} else {
					if ((f_detectType(((Struct)l0_it.f_second))).equals("*")) {
						final Object[] l1_arr = f_extractArgs(((Struct)l0_it.f_second));
						if (((boolean)f_getD(((Struct)(l1_arr[0]))).f_first)) {
							if ((((double)f_getD(((Struct)(l1_arr[0]))).f_second)>0.0)) {
								{
									final Struct l2___tmp = (new Struct_AlgMult((new Struct_AlgDouble((((double)f_getD(((Struct)(l1_arr[0]))).f_second)*(-1.0)))), ((Struct)(l1_arr[1]))));
									aar = l2___tmp;
									continue TAIL_CALL;
								}
							} else {
								{
									final Struct l3___tmp = ((Struct)l0_it.f_second);
									aar = l3___tmp;
									continue TAIL_CALL;
								}
							}
						} else {
							{
								final Struct l4___tmp = (new Struct_AlgMult((new Struct_AlgDouble((-1.0))), ((Struct)l0_it.f_second)));
								aar = l4___tmp;
								continue TAIL_CALL;
							}
						}
					} else {
						{
							final Struct l5___tmp = (new Struct_AlgMult((new Struct_AlgDouble((-1.0))), ((Struct)l0_it.f_second)));
							aar = l5___tmp;
							continue TAIL_CALL;
						}
					}
				}
			} else {
				{
					final Struct l6___tmp = ((Struct)l0_it.f_second);
					aar = l6___tmp;
					continue TAIL_CALL;
				}
			}
		}
	 }
	}
	Struct_Pair f_getD(Struct aa) {
		Struct l0__tmp = aa;
		switch (l0__tmp.getTypeId()) {
		case 9/*AlgDouble*/: {
			final Struct_AlgDouble l1__tmp = (Struct_AlgDouble)l0__tmp;
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
		case 9/*AlgDouble*/: {
			final Struct_AlgDouble l1__tmp = (Struct_AlgDouble)l0__tmp;
			final double l2_val = l1__tmp.f_val;
			final double l3_val = l1__tmp.f_val;
			return true;
		}
		case 13/*AlgVar*/: {
			final Struct_AlgVar l1__tmp = (Struct_AlgVar)l0__tmp;
			final String l4_var = l1__tmp.f_var;
			final String l5_var = l1__tmp.f_var;
			return true;
		}
		default: {
			return false;
		}
		}
	}
	Struct_AlgDouble f_one() {
		return (new Struct_AlgDouble(1.0));
	}
	Struct f_removeTrivialExp(Struct aar) {
	 TAIL_CALL: for(;;) {
		final Func1<Boolean,Struct> l0_isZero = new Func1<Boolean,Struct>() {
			final public Boolean invoke(final Struct aar0) {
				return ((Boolean)(((boolean)f_getD(aar0).f_first)&&(((double)f_getD(aar0).f_second)==0.0)));
			}
		};
		final Func1<Boolean,Struct> l1_isOne = new Func1<Boolean,Struct>() {
			final public Boolean invoke(final Struct aar0) {
				return ((Boolean)(((boolean)f_getD(aar0).f_first)&&(((double)f_getD(aar0).f_second)==1.0)));
			}
		};
		final Func1<Double,Struct> l2_getVal = new Func1<Double,Struct>() {
			final public Double invoke(final Struct aar0) {
				return ((Double)f_getD(aar0).f_second);
			}
		};
		final Func2<Struct,String, Struct> l4_$3 = new Func2<Struct,String,Struct>() {
			final public Struct invoke(final String aop, final Struct amAr) {
				final Object[] l0_args = f_extractArgs(amAr);
				if ((runtime.h_Native.length(l0_args)==2)) {
					if ((((boolean)f_getD(((Struct)(l0_args[0]))).f_first)&&((boolean)f_getD(((Struct)(l0_args[1]))).f_first))) {
						return (new Struct_AlgDouble(f_convVals(aop, ((double)l2_getVal.invoke(((Struct)(l0_args[0])))), ((double)l2_getVal.invoke(((Struct)(l0_args[1])))))));
					} else {
						if ((aop).equals("*")) {
							if ((((boolean)l0_isZero.invoke(((Struct)(l0_args[1]))))||((boolean)l0_isZero.invoke(((Struct)(l0_args[0])))))) {
								return f_zero();
							} else {
								if (((boolean)l1_isOne.invoke(((Struct)(l0_args[1]))))) {
									return ((Struct)(l0_args[0]));
								} else {
									if (((boolean)l1_isOne.invoke(((Struct)(l0_args[0]))))) {
										return ((Struct)(l0_args[1]));
									} else {
										return amAr;
									}
								}
							}
						} else {
							if ((aop).equals("/")) {
								if (((boolean)l0_isZero.invoke(((Struct)(l0_args[0]))))) {
									return f_zero();
								} else {
									if (((boolean)l1_isOne.invoke(((Struct)(l0_args[1]))))) {
										return ((Struct)(l0_args[0]));
									} else {
										if (FlowRuntime.compareEqual(((Struct)(l0_args[0])),((Struct)(l0_args[1])))) {
											return f_one();
										} else {
											return amAr;
										}
									}
								}
							} else {
								if ((aop).equals("-")) {
									if (FlowRuntime.compareEqual(((Struct)(l0_args[0])),((Struct)(l0_args[1])))) {
										return f_zero();
									} else {
										if (((boolean)l0_isZero.invoke(((Struct)(l0_args[1]))))) {
											return ((Struct)(l0_args[0]));
										} else {
											return amAr;
										}
									}
								} else {
									if ((aop).equals("+")) {
										if (((boolean)l0_isZero.invoke(((Struct)(l0_args[0]))))) {
											return ((Struct)(l0_args[1]));
										} else {
											if (((boolean)l0_isZero.invoke(((Struct)(l0_args[1]))))) {
												return ((Struct)(l0_args[0]));
											} else {
												if (FlowRuntime.compareEqual(((Struct)(l0_args[0])),((Struct)(l0_args[1])))) {
													return (new Struct_AlgMult(f_two(), ((Struct)(l0_args[0]))));
												} else {
													return amAr;
												}
											}
										}
									} else {
										return amAr;
									}
								}
							}
						}
					}
				} else {
					return amAr;
				}
			}
		};
		final Struct l5_it = f_execSimplifier(aar, l4_$3);
		if (FlowRuntime.compareEqual(l5_it,aar)) {
			return l5_it;
		} else {
			{
				final Struct l6___tmp = l5_it;
				aar = l6___tmp;
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
		runtime.m_runtime.f_println("trird");
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
	Struct_AlgDouble f_two() {
		return (new Struct_AlgDouble(2.0));
	}
	Struct_AlgDouble f_zero() {
		return (new Struct_AlgDouble(0.0));
	}
}
