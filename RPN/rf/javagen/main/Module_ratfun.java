// HASH COLLISIONS: YES
// timestamp: 1.603774356E12

package main;

import com.area9innovation.flow.*;

@SuppressWarnings("unchecked")
final class Module_ratfun {
	final main runtime;
	Module_ratfun(main runtime) {
		this.runtime = runtime;
	}
	Struct_Poly f_alg2poly(Struct aar) {
		Struct l0__tmp = aar;
		switch (l0__tmp.getTypeId()) {
		case 10/*AlgMin*/: {
			final Struct_AlgMin l1__tmp = (Struct_AlgMin)l0__tmp;
			final Struct l2_l = l1__tmp.f_l;
			final Struct l3_r = l1__tmp.f_r;
			final Struct l4_l = l1__tmp.f_l;
			final Struct l5_r = l1__tmp.f_r;
			final Struct l9_$7 = f_alg2poly(l4_l).f_sum;
			final Struct l10_$8 = f_negPoly(f_alg2poly(l5_r)).f_sum;
			final Func3<Double,Struct_Mono, Double, Double> l11_$6 = new Func3<Double,Struct_Mono,Double,Double>() {
				final public Double invoke(final Struct_Mono avar, final Double acoeff0, final Double acoeff1) {
					return ((Double)(((double)acoeff1)+((double)acoeff0)));
				}
			};
			return (new Struct_Poly(runtime.m_tree.f_mergeTreeCustom(l9_$7, l10_$8, ((Func3<Object,Object, Object, Object>)(Func3)l11_$6))));
		}
		case 12/*AlgSum*/: {
			final Struct_AlgSum l1__tmp = (Struct_AlgSum)l0__tmp;
			final Struct l12_l = l1__tmp.f_l;
			final Struct l13_r = l1__tmp.f_r;
			final Struct l14_l = l1__tmp.f_l;
			final Struct l15_r = l1__tmp.f_r;
			final Struct l19_$17 = f_alg2poly(l14_l).f_sum;
			final Struct l20_$18 = f_alg2poly(l15_r).f_sum;
			final Func3<Double,Struct_Mono, Double, Double> l21_$16 = new Func3<Double,Struct_Mono,Double,Double>() {
				final public Double invoke(final Struct_Mono avar, final Double acoeff0, final Double acoeff1) {
					return ((Double)(((double)acoeff1)+((double)acoeff0)));
				}
			};
			return (new Struct_Poly(runtime.m_tree.f_mergeTreeCustom(l19_$17, l20_$18, ((Func3<Object,Object, Object, Object>)(Func3)l21_$16))));
		}
		case 11/*AlgMult*/: {
			final Struct_AlgMult l1__tmp = (Struct_AlgMult)l0__tmp;
			final Struct l22_l = l1__tmp.f_l;
			final Struct l23_r = l1__tmp.f_r;
			final Struct l24_l = l1__tmp.f_l;
			final Struct l25_r = l1__tmp.f_r;
			return f_multiplePolynoms(f_alg2poly(l24_l), f_alg2poly(l25_r));
		}
		case 9/*AlgDouble*/: {
			final Struct_AlgDouble l1__tmp = (Struct_AlgDouble)l0__tmp;
			final double l26_val = l1__tmp.f_val;
			final double l27_val = l1__tmp.f_val;
			return (new Struct_Poly(runtime.m_tree.f_makeTree1((new Struct_Mono(runtime.m_tree.f_makeTree1("1.0", 1.0))), l27_val)));
		}
		case 13/*AlgVar*/: {
			final Struct_AlgVar l1__tmp = (Struct_AlgVar)l0__tmp;
			final String l28_var = l1__tmp.f_var;
			final String l29_var = l1__tmp.f_var;
			return (new Struct_Poly(runtime.m_tree.f_makeTree1((new Struct_Mono(runtime.m_tree.f_makeTree1(l29_var, 1.0))), 1.0)));
		}
		default: {
			return (new Struct_Poly(runtime.m_tree.f_makeTree()));
		}
		}
	}
	Struct_RatFun f_alg2rf(Struct aar) {
		final Struct l0_div = f_ar2CommonDenum(aar);
		if (f_isDiv(l0_div)) {
			final Object[] l1_args = runtime.m_simplifier.f_extractArgs(l0_div);
			final Struct_Poly l2_p0 = f_simplifyPoly(f_alg2poly(((Struct)(l1_args[0]))));
			final Struct_Poly l3_p1 = f_simplifyPoly(f_alg2poly(((Struct)(l1_args[1]))));
			return f_tryDivideRF((new Struct_RatFun(l2_p0, l3_p1)));
		} else {
			final Struct_Poly l4_p0 = f_simplifyPoly(f_alg2poly(l0_div));
			return (new Struct_RatFun(l4_p0, f_polyOne()));
		}
	}
	Struct f_ar2CommonDenum(Struct aar) {
		final Object[] l0_arr = runtime.m_simplifier.f_extractArgs(aar);
		if ((runtime.h_Native.length(l0_arr)==1)) {
			return aar;
		} else {
			final Struct l1_newL = f_ar2CommonDenum(((Struct)(l0_arr[0])));
			final Struct l2_newR = f_ar2CommonDenum(((Struct)(l0_arr[1])));
			final Object[] l3_args0 = runtime.m_simplifier.f_extractArgs(l1_newL);
			final Object[] l4_args1 = runtime.m_simplifier.f_extractArgs(l2_newR);
			Struct l5__tmp = aar;
			switch (l5__tmp.getTypeId()) {
			case 10/*AlgMin*/: {
				final Struct_AlgMin l6__tmp = (Struct_AlgMin)l5__tmp;
				final Struct l7_l = l6__tmp.f_l;
				final Struct l8_r = l6__tmp.f_r;
				final Struct l9_l = l6__tmp.f_l;
				final Struct l10_r = l6__tmp.f_r;
				if (f_isDiv(l1_newL)) {
					if (f_isDiv(l2_newR)) {
						return (new Struct_AlgDiv((new Struct_AlgMin((new Struct_AlgMult(((Struct)(l3_args0[0])), ((Struct)(l4_args1[1])))), (new Struct_AlgMult(((Struct)(l4_args1[0])), ((Struct)(l3_args0[1])))))), (new Struct_AlgMult(((Struct)(l3_args0[1])), ((Struct)(l4_args1[1]))))));
					} else {
						return (new Struct_AlgDiv((new Struct_AlgMin(((Struct)(l3_args0[0])), (new Struct_AlgMult(l2_newR, ((Struct)(l3_args0[1])))))), ((Struct)(l3_args0[1]))));
					}
				} else {
					if (f_isDiv(l2_newR)) {
						return (new Struct_AlgDiv((new Struct_AlgMin((new Struct_AlgMult(l1_newL, ((Struct)(l4_args1[1])))), ((Struct)(l4_args1[0])))), ((Struct)(l4_args1[1]))));
					} else {
						return l6__tmp;
					}
				}
			}
			case 12/*AlgSum*/: {
				final Struct_AlgSum l6__tmp = (Struct_AlgSum)l5__tmp;
				final Struct l11_l = l6__tmp.f_l;
				final Struct l12_r = l6__tmp.f_r;
				final Struct l13_l = l6__tmp.f_l;
				final Struct l14_r = l6__tmp.f_r;
				if (f_isDiv(l1_newL)) {
					if (f_isDiv(l2_newR)) {
						return (new Struct_AlgDiv((new Struct_AlgSum((new Struct_AlgMult(((Struct)(l3_args0[0])), ((Struct)(l4_args1[1])))), (new Struct_AlgMult(((Struct)(l4_args1[0])), ((Struct)(l3_args0[1])))))), (new Struct_AlgMult(((Struct)(l3_args0[1])), ((Struct)(l4_args1[1]))))));
					} else {
						return (new Struct_AlgDiv((new Struct_AlgSum(((Struct)(l3_args0[0])), (new Struct_AlgMult(l2_newR, ((Struct)(l3_args0[1])))))), ((Struct)(l3_args0[1]))));
					}
				} else {
					if (f_isDiv(l2_newR)) {
						return (new Struct_AlgDiv((new Struct_AlgSum((new Struct_AlgMult(l1_newL, ((Struct)(l4_args1[1])))), ((Struct)(l4_args1[0])))), ((Struct)(l4_args1[1]))));
					} else {
						return l6__tmp;
					}
				}
			}
			case 11/*AlgMult*/: {
				final Struct_AlgMult l6__tmp = (Struct_AlgMult)l5__tmp;
				final Struct l15_l = l6__tmp.f_l;
				final Struct l16_r = l6__tmp.f_r;
				final Struct l17_l = l6__tmp.f_l;
				final Struct l18_r = l6__tmp.f_r;
				if (f_isDiv(l1_newL)) {
					if (f_isDiv(l2_newR)) {
						return (new Struct_AlgDiv((new Struct_AlgMult(((Struct)(l3_args0[0])), ((Struct)(l4_args1[0])))), (new Struct_AlgMult(((Struct)(l3_args0[1])), ((Struct)(l4_args1[1]))))));
					} else {
						return (new Struct_AlgDiv((new Struct_AlgMult(((Struct)(l3_args0[0])), l2_newR)), ((Struct)(l3_args0[1]))));
					}
				} else {
					if (f_isDiv(l2_newR)) {
						return (new Struct_AlgDiv((new Struct_AlgMult(((Struct)(l4_args1[0])), l1_newL)), ((Struct)(l4_args1[1]))));
					} else {
						return l6__tmp;
					}
				}
			}
			default: {
				return aar;
			}
			}
		}
	}
	Struct_Mono f_differenceMonos(Struct_Mono aa, Struct_Mono ab) {
		final Struct l2_$1 = aa.f_prod;
		final Struct_Mono l4_b = ab;
		final Func2<Double,String, Double> l3_$0 = new Func2<Double,String,Double>() {
			final public Double invoke(final String avar, final Double adeg0) {
				if (runtime.m_tree.f_containsKeyTree(l4_b.f_prod, avar)) {
					return ((Double)(((double)adeg0)-((double)runtime.m_maybe.f_either(((Func2<Struct,Struct, String>)(Func2)runtime.n_lookupTree).invoke(l4_b.f_prod, avar), (-1.0)))));
				} else {
					return adeg0;
				}
			}
		};
		final Struct_Mono l5_m = (new Struct_Mono(runtime.m_tree.f_mapTree2(l2_$1, ((Func2<Object,Object, Object>)(Func2)l3_$0))));
		if (runtime.m_tree.f_isEmptyTree(l5_m.f_prod)) {
			return (new Struct_Mono(runtime.m_tree.f_makeTree1("1.0", 1.0)));
		} else {
			return l5_m;
		}
	}
	Struct_Poly f_dividePoly(Struct_Poly apoly, Struct_Mono asub, double asubCoeff) {
		final Struct l3_$1 = apoly.f_sum;
		final Struct l4_$2 = runtime.m_tree.f_makeTree();
		final Struct_Mono l6_sub = asub;
		final double l7_subCoeff = asubCoeff;
		final Func3<Struct,Struct_Mono, Double, Struct> l5_$0 = new Func3<Struct,Struct_Mono,Double,Struct>() {
			final public Struct invoke(final Struct_Mono amonom, final Double acoeff, final Struct aacc0) {
				if (f_intersectMonos(amonom, l6_sub)) {
					return ((Func3<Struct,Struct, Struct_Mono, Double>)(Func3)runtime.n_setTree).invoke(aacc0, f_differenceMonos(amonom, l6_sub), ((Double)(((double)acoeff)/l7_subCoeff)));
				} else {
					return aacc0;
				}
			}
		};
		return (new Struct_Poly(((Struct)runtime.m_tree.f_foldTree(l3_$1, l4_$2, ((Func3<Object,Object, Object, Object>)(Func3)l5_$0)))));
	}
	Struct f_foldDegree(Struct aar, int adeg) {
		if ((adeg==0)) {
			return (new Struct_AlgDouble(1.0));
		} else {
			if ((adeg==1)) {
				return aar;
			} else {
				return (new Struct_AlgMult(aar, f_foldDegree(aar, (adeg-1))));
			}
		}
	}
	Struct f_getAllVariablesWithMinDegree(Struct_Poly ap) {
		final Struct l3_$1 = ap.f_sum;
		final Struct l4_$2 = runtime.m_tree.f_makeTree();
		final Func3<Struct,Struct_Mono, Double, Struct> l5_$0 = new Func3<Struct,Struct_Mono,Double,Struct>() {
			final public Struct invoke(final Struct_Mono amonom, final Double acoeff, final Struct aacc0) {
				final Struct l2_$1 = amonom.f_prod;
				final Func3<Struct,String, Double, Struct> l3_$0 = new Func3<Struct,String,Double,Struct>() {
					final public Struct invoke(final String avar, final Double adeg, final Struct aacc1) {
						return ((Func3<Struct,Struct, String, Double>)(Func3)runtime.n_setTree).invoke(aacc1, avar, ((Double)runtime.m_math.f_min3(runtime.m_math.g_doubleMax, runtime.m_maybe.f_either(((Func2<Struct,Struct, String>)(Func2)runtime.n_lookupTree).invoke(aacc1, avar), runtime.m_math.g_doubleMax), adeg)));
					}
				};
				return ((Struct)runtime.m_tree.f_foldTree(l2_$1, aacc0, ((Func3<Object,Object, Object, Object>)(Func3)l3_$0)));
			}
		};
		return ((Struct)runtime.m_tree.f_foldTree(l3_$1, l4_$2, ((Func3<Object,Object, Object, Object>)(Func3)l5_$0)));
	}
	Struct_Pair f_getCommonMultiplier(Struct_Poly ap) {
		final Struct l3_$1 = ap.f_sum;
		final Struct_Pair l4_$2 = (new Struct_Pair(0, 0));
		final Func3<Struct_Pair,Struct_Mono, Double, Struct_Pair> l5_$0 = new Func3<Struct_Pair,Struct_Mono,Double,Struct_Pair>() {
			final public Struct_Pair invoke(final Struct_Mono amonom, final Double acoeff, final Struct_Pair aacc0) {
				if (((((int)aacc0.f_first)==0)&&(((int)aacc0.f_second)==0))) {
					return (new Struct_Pair(runtime.m_math.f_ceil(((double)acoeff)), 1));
				} else {
					return (new Struct_Pair(runtime.m_math.f_gcd(((int)aacc0.f_first), runtime.m_math.f_ceil(((double)acoeff))), 1));
				}
			}
		};
		final Struct_Pair l6_gcd0 = ((Struct_Pair)runtime.m_tree.f_foldTree(l3_$1, l4_$2, ((Func3<Object,Object, Object, Object>)(Func3)l5_$0)));
		final Struct l10_$8 = ap.f_sum;
		final Struct l11_$9 = f_getAllVariablesWithMinDegree(ap);
		final Func3<Struct,Struct_Mono, Double, Struct> l12_$7 = new Func3<Struct,Struct_Mono,Double,Struct>() {
			final public Struct invoke(final Struct_Mono amonom, final Double acoeff, final Struct aacc0) {
				final Struct l2_$1 = runtime.m_tree.f_makeTree();
				final Func3<Struct,String, Double, Struct> l3_$0 = new Func3<Struct,String,Double,Struct>() {
					final public Struct invoke(final String avar, final Double adeg, final Struct aacc1) {
						if ((((double)runtime.m_maybe.f_either(((Func2<Struct,Struct, String>)(Func2)runtime.n_lookupTree).invoke(amonom.f_prod, avar), (-1.0)))>=((double)adeg))) {
							return ((Func3<Struct,Struct, String, Double>)(Func3)runtime.n_setTree).invoke(aacc1, avar, adeg);
						} else {
							return aacc1;
						}
					}
				};
				return ((Struct)runtime.m_tree.f_foldTree(aacc0, l2_$1, ((Func3<Object,Object, Object, Object>)(Func3)l3_$0)));
			}
		};
		final Struct l13_varGCD = ((Struct)runtime.m_tree.f_foldTree(l10_$8, l11_$9, ((Func3<Object,Object, Object, Object>)(Func3)l12_$7)));
		return (new Struct_Pair(l6_gcd0.f_first, l13_varGCD));
	}
	Struct_Poly f_getIntersection(Struct_Poly apoly, Struct_Mono asub, double asubCoeff) {
		final Struct l3_$1 = apoly.f_sum;
		final Struct l4_$2 = runtime.m_tree.f_makeTree();
		final Struct_Mono l6_sub = asub;
		final double l7_subCoeff = asubCoeff;
		final Func3<Struct,Struct_Mono, Double, Struct> l5_$0 = new Func3<Struct,Struct_Mono,Double,Struct>() {
			final public Struct invoke(final Struct_Mono amonom, final Double acoeff, final Struct aacc0) {
				if (f_intersectMonos(amonom, l6_sub)) {
					return ((Func3<Struct,Struct, Struct_Mono, Double>)(Func3)runtime.n_setTree).invoke(aacc0, f_differenceMonos(amonom, l6_sub), ((Double)(((double)acoeff)/l7_subCoeff)));
				} else {
					return aacc0;
				}
			}
		};
		return (new Struct_Poly(((Struct)runtime.m_tree.f_foldTree(l3_$1, l4_$2, ((Func3<Object,Object, Object, Object>)(Func3)l5_$0)))));
	}
	boolean f_intersectMonos(Struct_Mono aa, Struct_Mono asub) {
		final Struct l2_$1 = asub.f_prod;
		final Struct_Mono l4_a = aa;
		final Func3<Boolean,String, Double, Boolean> l3_$0 = new Func3<Boolean,String,Double,Boolean>() {
			final public Boolean invoke(final String avar, final Double adeg0, final Boolean aacc0) {
				if (!((boolean)aacc0)) {
					return aacc0;
				} else {
					if ((runtime.m_tree.f_containsKeyTree(l4_a.f_prod, avar)&&(((double)runtime.m_maybe.f_either(((Func2<Struct,Struct, String>)(Func2)runtime.n_lookupTree).invoke(l4_a.f_prod, avar), (-1.0)))>=((double)adeg0)))) {
						return ((Boolean)true);
					} else {
						return ((Boolean)false);
					}
				}
			}
		};
		return ((boolean)runtime.m_tree.f_foldTree(l2_$1, true, ((Func3<Object,Object, Object, Object>)(Func3)l3_$0)));
	}
	boolean f_isDiv(Struct aar) {
		Struct l0__tmp = aar;
		switch (l0__tmp.getTypeId()) {
		case 8/*AlgDiv*/: {
			final Struct_AlgDiv l1__tmp = (Struct_AlgDiv)l0__tmp;
			final Struct l2_up = l1__tmp.f_up;
			final Struct l3_down = l1__tmp.f_down;
			final Struct l4_up = l1__tmp.f_up;
			final Struct l5_down = l1__tmp.f_down;
			return true;
		}
		default: {
			return false;
		}
		}
	}
	Struct_Mono f_mergeMonoms(Struct_Mono aa, Struct_Mono ab) {
		final Struct l3_$1 = aa.f_prod;
		final Struct l4_$2 = ab.f_prod;
		final Func3<Double,String, Double, Double> l5_$0 = new Func3<Double,String,Double,Double>() {
			final public Double invoke(final String av, final Double adeg0, final Double adeg1) {
				if ((!(av).equals("1.0"))) {
					return ((Double)(((double)adeg0)+((double)adeg1)));
				} else {
					return ((Double)1.0);
				}
			}
		};
		return (new Struct_Mono(runtime.m_tree.f_mergeTreeCustom(l3_$1, l4_$2, ((Func3<Object,Object, Object, Object>)(Func3)l5_$0))));
	}
	Struct f_mono2alg(Struct_Mono am) {
		final Struct l3_$1 = am.f_prod;
		final Struct_AlgDouble l4_$2 = (new Struct_AlgDouble(1.0));
		final Func3<Struct_AlgMult,String, Double, Struct> l5_$0 = new Func3<Struct_AlgMult,String,Double,Struct>() {
			final public Struct_AlgMult invoke(final String avar, final Double adeg, final Struct aacc) {
				if (runtime.m_string.f_isDouble(avar)) {
					return (new Struct_AlgMult(aacc, (new Struct_AlgDouble(runtime.m_math.f_dpow(runtime.m_math.f_s2d(avar), ((double)adeg))))));
				} else {
					return (new Struct_AlgMult(aacc, f_foldDegree((new Struct_AlgVar(avar)), runtime.m_math.f_floor(((double)adeg)))));
				}
			}
		};
		return ((Struct)runtime.m_tree.f_foldTree(l3_$1, l4_$2, ((Func3<Object,Object, Object, Object>)(Func3)l5_$0)));
	}
	Struct_Poly f_multiplePolynoms(Struct_Poly aa, Struct_Poly ab) {
		final Struct l0_tr0 = aa.f_sum;
		final Struct l1_tr1 = ab.f_sum;
		final Struct l4_$3 = runtime.m_tree.f_makeTree();
		final Func3<Struct,Struct_Mono, Double, Struct> l5_$2 = new Func3<Struct,Struct_Mono,Double,Struct>() {
			final public Struct invoke(final Struct_Mono amono0, final Double acoeff0, final Struct aacc0) {
				final Func3<Struct,Struct_Mono, Double, Struct> l1_$0 = new Func3<Struct,Struct_Mono,Double,Struct>() {
					final public Struct invoke(final Struct_Mono amono1, final Double acoeff1, final Struct aacc1) {
						final Struct_TreeNode l2_$1 = runtime.m_tree.f_makeTree1(f_mergeMonoms(amono0, amono1), (((double)acoeff0)*((double)acoeff1)));
						final Func3<Double,Struct_Mono, Double, Double> l3_$0 = new Func3<Double,Struct_Mono,Double,Double>() {
							final public Double invoke(final Struct_Mono av, final Double ac0, final Double ac1) {
								return ((Double)(((double)ac0)+((double)ac1)));
							}
						};
						return runtime.m_tree.f_mergeTreeCustom(aacc1, l2_$1, ((Func3<Object,Object, Object, Object>)(Func3)l3_$0));
					}
				};
				return ((Struct)runtime.m_tree.f_foldTree(l1_tr1, aacc0, ((Func3<Object,Object, Object, Object>)(Func3)l1_$0)));
			}
		};
		final Struct_Poly l6_p = (new Struct_Poly(((Struct)runtime.m_tree.f_foldTree(l0_tr0, l4_$3, ((Func3<Object,Object, Object, Object>)(Func3)l5_$2)))));
		return l6_p;
	}
	Struct_Poly f_negPoly(Struct_Poly aa) {
		final Struct l2_$1 = aa.f_sum;
		final Func1<Double,Double> l3_$0 = new Func1<Double,Double>() {
			final public Double invoke(final Double av) {
				return ((Double)((-1.0)*((double)av)));
			}
		};
		return (new Struct_Poly(runtime.m_tree.f_mapTree(l2_$1, ((Func1<Object,Object>)(Func1)l3_$0))));
	}
	Struct f_poly2alg(Struct_Poly apoly) {
		final Struct l3_$1 = apoly.f_sum;
		final Struct_AlgDouble l4_$2 = (new Struct_AlgDouble(0.0));
		final Func3<Struct_AlgSum,Struct_Mono, Double, Struct> l5_$0 = new Func3<Struct_AlgSum,Struct_Mono,Double,Struct>() {
			final public Struct_AlgSum invoke(final Struct_Mono amono, final Double acoeff, final Struct aacc) {
				return (new Struct_AlgSum(aacc, (new Struct_AlgMult(f_mono2alg(amono), (new Struct_AlgDouble(((double)acoeff)))))));
			}
		};
		return ((Struct)runtime.m_tree.f_foldTree(l3_$1, l4_$2, ((Func3<Object,Object, Object, Object>)(Func3)l5_$0)));
	}
	String f_poly2s(Struct_Poly apoly) {
		final Struct l2_$1 = apoly.f_sum;
		final Func3<String,Struct_Mono, Double, String> l3_$0 = new Func3<String,Struct_Mono,Double,String>() {
			final public String invoke(final Struct_Mono amono, final Double acoeff, final String aacc) {
				final Struct l2_$1 = amono.f_prod;
				final Func3<String,String, Double, String> l3_$0 = new Func3<String,String,Double,String>() {
					final public String invoke(final String avar, final Double adeg, final String aacc1) {
						if ((((double)adeg)!=1.0)) {
							return runtime.m_string.f_concatStrings((new Object[] { aacc1, avar, "^", runtime.m_string.f_d2s(((double)adeg)) }));
						} else {
							return runtime.m_string.f_concatStrings((new Object[] { aacc1, avar }));
						}
					}
				};
				final String l4_mons = ((String)runtime.m_tree.f_foldTree(l2_$1, "", ((Func3<Object,Object, Object, Object>)(Func3)l3_$0)));
				if ((aacc).equals("")) {
					if ((((double)acoeff)==1.0)) {
						return runtime.m_string.f_concatStrings((new Object[] { l4_mons }));
					} else {
						if ((((double)acoeff)==(-1.0))) {
							return runtime.m_string.f_concatStrings((new Object[] { "(-", l4_mons, ")" }));
						} else {
							if ((((double)acoeff)<0.0)) {
								return runtime.m_string.f_concatStrings((new Object[] { "(", runtime.m_string.f_d2s(((double)acoeff)), "*", l4_mons, ")" }));
							} else {
								return runtime.m_string.f_concatStrings((new Object[] { runtime.m_string.f_d2s(((double)acoeff)), "*", l4_mons }));
							}
						}
					}
				} else {
					if ((((double)acoeff)==1.0)) {
						return runtime.m_string.f_concatStrings((new Object[] { l4_mons, "+", aacc }));
					} else {
						if ((((double)acoeff)==(-1.0))) {
							return runtime.m_string.f_concatStrings((new Object[] { "(-", l4_mons, ")+", aacc }));
						} else {
							if ((((double)acoeff)<0.0)) {
								return runtime.m_string.f_concatStrings((new Object[] { "(", runtime.m_string.f_d2s(((double)acoeff)), "*", l4_mons, ")+", aacc }));
							} else {
								return runtime.m_string.f_concatStrings((new Object[] { runtime.m_string.f_d2s(((double)acoeff)), "*", l4_mons, "+", aacc }));
							}
						}
					}
				}
			}
		};
		return ((String)runtime.m_tree.f_foldTree(l2_$1, "", ((Func3<Object,Object, Object, Object>)(Func3)l3_$0)));
	}
	boolean f_polyEquals(Struct_Poly ap0, Struct_Poly ap1) {
		final Struct l2_$1 = ap0.f_sum;
		final Struct_Poly l4_p1 = ap1;
		final Func3<Boolean,Struct_Mono, Double, Boolean> l3_$0 = new Func3<Boolean,Struct_Mono,Double,Boolean>() {
			final public Boolean invoke(final Struct_Mono amonom0, final Double acoeff0, final Boolean aacc0) {
				if (!((boolean)aacc0)) {
					return ((Boolean)false);
				} else {
					final Struct l2_$1 = l4_p1.f_sum;
					final Func3<Boolean,Struct_Mono, Double, Boolean> l3_$0 = new Func3<Boolean,Struct_Mono,Double,Boolean>() {
						final public Boolean invoke(final Struct_Mono amonom1, final Double acoeff1, final Boolean aacc1) {
							if (((boolean)aacc1)) {
								return ((Boolean)true);
							} else {
								return ((Boolean)((((double)acoeff0)==((double)acoeff1))&&runtime.m_tree.f_equalTrees(amonom0.f_prod, amonom1.f_prod)));
							}
						}
					};
					return ((Boolean)runtime.m_tree.f_foldTree(l2_$1, false, ((Func3<Object,Object, Object, Object>)(Func3)l3_$0)));
				}
			}
		};
		return ((boolean)runtime.m_tree.f_foldTree(l2_$1, true, ((Func3<Object,Object, Object, Object>)(Func3)l3_$0)));
	}
	Struct_Poly f_polyOne() {
		return (new Struct_Poly(runtime.m_tree.f_makeTree1((new Struct_Mono(runtime.m_tree.f_makeTree1("1.0", 1.0))), 1.0)));
	}
	Struct_Pair f_removeCommonVars(Struct_Mono am0, Struct_Mono am1) {
		return (new Struct_Pair(f_differenceMonos(am0, am1), f_differenceMonos(am1, am0)));
	}
	Struct f_rf2alg(Struct_RatFun arf) {
		return runtime.m_simplifier.f_simplifyTree((new Struct_AlgDiv(f_poly2alg(arf.f_num), f_poly2alg(arf.f_denum))));
	}
	String f_rf2s(Struct_RatFun arf) {
		final String l0_nums = f_poly2s(arf.f_num);
		final String l1_denums = f_poly2s(arf.f_denum);
		if ((l1_denums).equals("1.0")) {
			return l0_nums;
		} else {
			return (((("("+l0_nums)+")/(")+l1_denums)+")");
		}
	}
	Struct f_simplifyMono(Struct aa) {
	 TAIL_CALL: for(;;) {
		Struct l0__tmp = aa;
		switch (l0__tmp.getTypeId()) {
		case 105/*Some*/: {
			final Struct_Some l1__tmp = (Struct_Some)l0__tmp;
			final Object l2_mono = l1__tmp.f_value;
			final Struct_Mono l3_mono = ((Struct_Mono)l1__tmp.f_value);
			final Struct l7_$5 = l3_mono.f_prod;
			final Struct l8_$6 = runtime.m_tree.f_makeTree();
			final Func3<Struct,String, Double, Struct> l9_$4 = new Func3<Struct,String,Double,Struct>() {
				final public Struct invoke(final String av, final Double ak, final Struct aacc) {
					if ((((double)ak)==0.0)) {
						return ((Func3<Struct,Struct, String, Double>)(Func3)runtime.n_setTree).invoke(aacc, "1.0", ((Double)1.0));
					} else {
						return ((Func3<Struct,Struct, String, Double>)(Func3)runtime.n_setTree).invoke(aacc, av, ak);
					}
				}
			};
			final Struct l10_it0 = ((Struct)runtime.m_tree.f_foldTree(l7_$5, l8_$6, ((Func3<Object,Object, Object, Object>)(Func3)l9_$4)));
			if (runtime.m_tree.f_containsKeyTree(l10_it0, "0.0")) {
				return ((Struct)SingletonStructs.str_None);
			} else {
				if ((runtime.m_tree.f_containsKeyTree(l10_it0, "1.0")&&(runtime.m_tree.f_sizeTree(l10_it0)!=1))) {
					final Struct l11_tr1 = runtime.m_tree.f_removeFromTree(l10_it0, "1.0");
					if (!runtime.m_tree.f_equalTrees(l11_tr1, l3_mono.f_prod)) {
						{
							final Struct l12___tmp = (new Struct_Some((new Struct_Mono(l11_tr1))));
							aa = l12___tmp;
							continue TAIL_CALL;
						}
					} else {
						return (new Struct_Some(l3_mono));
					}
				} else {
					if (!runtime.m_tree.f_equalTrees(l10_it0, l3_mono.f_prod)) {
						{
							final Struct l13___tmp = (new Struct_Some((new Struct_Mono(l10_it0))));
							aa = l13___tmp;
							continue TAIL_CALL;
						}
					} else {
						return (new Struct_Some(l3_mono));
					}
				}
			}
		}
		case 43/*None*/: {
			return ((Struct)SingletonStructs.str_None);
		}
		default:
			throw new RuntimeException("Unexpected struct in switch: "+l0__tmp.getTypeName());
		}
	 }
	}
	Struct_Poly f_simplifyPoly(Struct_Poly apoly) {
	 TAIL_CALL: for(;;) {
		final Struct l3_$1 = apoly.f_sum;
		final Struct l4_$2 = runtime.m_tree.f_makeTree();
		final Func3<Struct,Struct_Mono, Double, Struct> l5_$0 = new Func3<Struct,Struct_Mono,Double,Struct>() {
			final public Struct invoke(final Struct_Mono amono, final Double acoeff, final Struct aacc) {
				if ((((double)acoeff)!=0.0)) {
					final Struct l0_gsymswitch0 = f_simplifyMono((new Struct_Some(amono)));
					Struct l1__tmp = l0_gsymswitch0;
					switch (l1__tmp.getTypeId()) {
					case 105/*Some*/: {
						final Struct_Some l2__tmp = (Struct_Some)l1__tmp;
						final Object l3_val = l2__tmp.f_value;
						final Struct_Mono l4_val = ((Struct_Mono)l2__tmp.f_value);
						final Struct_TreeNode l7_$6 = runtime.m_tree.f_makeTree1(l4_val, acoeff);
						final Func3<Double,Struct_Mono, Double, Double> l8_$5 = new Func3<Double,Struct_Mono,Double,Double>() {
							final public Double invoke(final Struct_Mono av, final Double acoeff0, final Double acoeff1) {
								return ((Double)(((double)acoeff1)+((double)acoeff0)));
							}
						};
						return runtime.m_tree.f_mergeTreeCustom(aacc, l7_$6, ((Func3<Object,Object, Object, Object>)(Func3)l8_$5));
					}
					default: {
						return aacc;
					}
					}
				} else {
					return aacc;
				}
			}
		};
		final Struct_Poly l6_it0 = (new Struct_Poly(((Struct)runtime.m_tree.f_foldTree(l3_$1, l4_$2, ((Func3<Object,Object, Object, Object>)(Func3)l5_$0)))));
		if ((!FlowRuntime.compareEqual(l6_it0,apoly))) {
			{
				final Struct_Poly l7___tmp = l6_it0;
				apoly = l7___tmp;
				continue TAIL_CALL;
			}
		} else {
			return apoly;
		}
	 }
	}
	Struct_RatFun f_tryDivideRF(Struct_RatFun arf) {
		final Struct_Poly l0_num = arf.f_num;
		final Struct_Poly l1_denum = arf.f_denum;
		if ((runtime.m_tree.f_sizeTree(l1_denum.f_sum)!=1)) {
			final Struct_Pair l2_cm0 = f_getCommonMultiplier(l0_num);
			final Struct_Pair l3_cm1 = f_getCommonMultiplier(l1_denum);
			final int l4_gcd0 = runtime.m_math.f_gcd(((int)l2_cm0.f_first), ((int)l3_cm1.f_first));
			final Func4<Boolean,Struct_Poly, Struct_Poly, Struct_Pair, Struct_Pair> l5_pEq = new Func4<Boolean,Struct_Poly,Struct_Poly,Struct_Pair,Struct_Pair>() {
				final public Boolean invoke(final Struct_Poly ap0, final Struct_Poly ap1, final Struct_Pair ac0, final Struct_Pair ac1) {
					return ((Boolean)f_polyEquals(f_dividePoly(ap0, (new Struct_Mono(((Struct)ac0.f_second))), runtime.m_math.f_i2d(((int)ac0.f_first))), f_dividePoly(ap1, (new Struct_Mono(((Struct)ac1.f_second))), runtime.m_math.f_i2d(((int)ac1.f_first)))));
				}
			};
			if (((boolean)l5_pEq.invoke(l0_num, l1_denum, l2_cm0, l3_cm1))) {
				return (new Struct_RatFun((new Struct_Poly(runtime.m_tree.f_makeTree1(f_differenceMonos((new Struct_Mono(((Struct)l2_cm0.f_second))), (new Struct_Mono(((Struct)l3_cm1.f_second)))), (runtime.m_math.f_i2d(((int)l2_cm0.f_first))/runtime.m_math.f_i2d(((int)l3_cm1.f_first)))))), f_polyOne()));
			} else {
				final Struct_Pair l6_newMult = f_removeCommonVars((new Struct_Mono(((Struct)l2_cm0.f_second))), (new Struct_Mono(((Struct)l3_cm1.f_second))));
				return (new Struct_RatFun(f_multiplePolynoms(f_dividePoly(l0_num, (new Struct_Mono(((Struct)l2_cm0.f_second))), runtime.m_math.f_i2d(((int)l2_cm0.f_first))), (new Struct_Poly(runtime.m_tree.f_makeTree1(l6_newMult.f_first, (runtime.m_math.f_i2d(((int)l2_cm0.f_first))/runtime.m_math.f_i2d(((int)l3_cm1.f_first))))))), f_multiplePolynoms(f_dividePoly(l1_denum, (new Struct_Mono(((Struct)l3_cm1.f_second))), runtime.m_math.f_i2d(((int)l3_cm1.f_first))), (new Struct_Poly(runtime.m_tree.f_makeTree1(l6_newMult.f_second, 1.0))))));
			}
		} else {
			final Struct_Mono l7_oneMono = ((Struct_Mono)((Struct_Pair)(runtime.m_tree.f_tree2pairs(l1_denum.f_sum)[0])).f_first);
			final double l8_oneCoeff = ((double)((Struct_Pair)(runtime.m_tree.f_tree2pairs(l1_denum.f_sum)[0])).f_second);
			if ((runtime.m_tree.f_sizeTree(f_getIntersection(l0_num, l7_oneMono, l8_oneCoeff).f_sum)==runtime.m_tree.f_sizeTree(l0_num.f_sum))) {
				return (new Struct_RatFun(f_simplifyPoly(f_dividePoly(l0_num, l7_oneMono, l8_oneCoeff)), f_polyOne()));
			} else {
				return arf;
			}
		}
	}
}
