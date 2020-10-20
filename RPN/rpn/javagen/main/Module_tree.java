// HASH COLLISIONS: YES
// timestamp: 1.599279091E12

package main;

import com.area9innovation.flow.*;

@SuppressWarnings("unchecked")
final class Module_tree {
	final main runtime;
	Module_tree(main runtime) {
		this.runtime = runtime;
	}
	Struct nf_lookupTree(Struct aset, Object akey) {
	 TAIL_CALL: for(;;) {
		Struct l0__tmp = aset;
		switch (l0__tmp.getTypeId()) {
		case 113/*TreeNode*/: {
			final Struct_TreeNode l1__tmp = (Struct_TreeNode)l0__tmp;
			final Object l2_k = l1__tmp.f_key;
			final Object l3_v = l1__tmp.f_value;
			final Struct l4_l = l1__tmp.f_left;
			final Struct l5_r = l1__tmp.f_right;
			final int l6_depth = l1__tmp.f_depth;
			final Object l7_k = l1__tmp.f_key;
			final Object l8_v = l1__tmp.f_value;
			final Struct l9_l = l1__tmp.f_left;
			final Struct l10_r = l1__tmp.f_right;
			final int l11_depth = l1__tmp.f_depth;
			if ((FlowRuntime.compareByValue(akey,l7_k)<0)) {
				{
					final Struct l12___tmp = l9_l;
					aset = l12___tmp;
					continue TAIL_CALL;
				}
			} else {
				if (FlowRuntime.compareEqual(akey,l7_k)) {
					return (new Struct_Some(l8_v));
				} else {
					{
						final Struct l13___tmp = l10_r;
						aset = l13___tmp;
						continue TAIL_CALL;
					}
				}
			}
		}
		case 112/*TreeEmpty*/: {
			return ((Struct)SingletonStructs.str_None);
		}
		default:
			throw new RuntimeException("Unexpected struct in switch: "+l0__tmp.getTypeName());
		}
	 }
	}
	Struct nf_setTree(Struct aset, Object akey, Object avalue) {
		Struct l0__tmp = aset;
		switch (l0__tmp.getTypeId()) {
		case 113/*TreeNode*/: {
			final Struct_TreeNode l1__tmp = (Struct_TreeNode)l0__tmp;
			final Object l2_k = l1__tmp.f_key;
			final Object l3_v = l1__tmp.f_value;
			final Struct l4_left = l1__tmp.f_left;
			final Struct l5_right = l1__tmp.f_right;
			final int l6_depth = l1__tmp.f_depth;
			final Object l7_k = l1__tmp.f_key;
			final Object l8_v = l1__tmp.f_value;
			final Struct l9_left = l1__tmp.f_left;
			final Struct l10_right = l1__tmp.f_right;
			final int l11_depth = l1__tmp.f_depth;
			if ((FlowRuntime.compareByValue(akey,l7_k)<0)) {
				return f_rebalancedTree(l7_k, l8_v, runtime.n_setTree.invoke(l9_left, akey, avalue), l10_right);
			} else {
				if (FlowRuntime.compareEqual(akey,l7_k)) {
					return (new Struct_TreeNode(l7_k, avalue, l9_left, l10_right, l11_depth));
				} else {
					return f_rebalancedTree(l7_k, l8_v, l9_left, runtime.n_setTree.invoke(l10_right, akey, avalue));
				}
			}
		}
		case 112/*TreeEmpty*/: {
			return (new Struct_TreeNode(akey, avalue, ((Struct)SingletonStructs.str_TreeEmpty), ((Struct)SingletonStructs.str_TreeEmpty), 1));
		}
		default:
			throw new RuntimeException("Unexpected struct in switch: "+l0__tmp.getTypeName());
		}
	}
	boolean f_containsKeyTree(Struct atree, Object akey) {
		return runtime.m_maybe.f_isSome(runtime.n_lookupTree.invoke(atree, akey));
	}
	boolean f_equalTrees(Struct at1, Struct at2) {
		boolean l3_$2;
		if (FlowRuntime.compareEqual(at1,at2)) {
			l3_$2=true;
		} else {
			boolean l6_$5;
			if ((f_sizeTree(at1)==f_sizeTree(at2))) {
				final Struct l9_t2 = at2;
				final Func3<Boolean,Object, Object, Boolean> l8_$7 = new Func3<Boolean,Object,Object,Boolean>() {
					final public Boolean invoke(final Object ak1, final Object av1, final Boolean aacc) {
						return ((Boolean)(((boolean)aacc)&&((boolean)runtime.m_maybe.f_eitherMap(runtime.n_lookupTree.invoke(l9_t2, ak1), ((Func1<Object,Object>)(Func1)runtime.m_runtime.f_eq(av1)), false))));
					}
				};
				l6_$5=((boolean)f_foldTree(at1, true, ((Func3<Object,Object, Object, Object>)(Func3)l8_$7)));
			} else {
				l6_$5=false;
			}
			l3_$2=l6_$5;
		}
		return l3_$2;
	}
	Object f_foldTree(Struct atree, Object aacc, Func3<Object,Object, Object, Object> af) {
	 TAIL_CALL: for(;;) {
		Struct l0__tmp = atree;
		switch (l0__tmp.getTypeId()) {
		case 112/*TreeEmpty*/: {
			return aacc;
		}
		case 113/*TreeNode*/: {
			final Struct_TreeNode l1__tmp = (Struct_TreeNode)l0__tmp;
			final Object l2_k = l1__tmp.f_key;
			final Object l3_v = l1__tmp.f_value;
			final Struct l4_left = l1__tmp.f_left;
			final Struct l5_right = l1__tmp.f_right;
			final int l6_depth = l1__tmp.f_depth;
			final Object l7_k = l1__tmp.f_key;
			final Object l8_v = l1__tmp.f_value;
			final Struct l9_left = l1__tmp.f_left;
			final Struct l10_right = l1__tmp.f_right;
			final int l11_depth = l1__tmp.f_depth;
			final Object l12_acc1 = f_foldTree(l9_left, aacc, af);
			final Object l13_acc2 = af.invoke(l7_k, l8_v, l12_acc1);
			{
				final Struct l14___tmp = l10_right;
				final Object l15___tmp = l13_acc2;
				atree = l14___tmp;
				aacc = l15___tmp;
				continue TAIL_CALL;
			}
		}
		default:
			throw new RuntimeException("Unexpected struct in switch: "+l0__tmp.getTypeName());
		}
	 }
	}
	Object[] f_getTreeValues(Struct atree) {
		Struct l0__tmp = atree;
		switch (l0__tmp.getTypeId()) {
		case 112/*TreeEmpty*/: {
			return SingletonStructs.arr_empty;
		}
		case 113/*TreeNode*/: {
			final Struct_TreeNode l1__tmp = (Struct_TreeNode)l0__tmp;
			final Object l2_k = l1__tmp.f_key;
			final Object l3_v = l1__tmp.f_value;
			final Struct l4_left = l1__tmp.f_left;
			final Struct l5_right = l1__tmp.f_right;
			final int l6_depth = l1__tmp.f_depth;
			final Object l7_k = l1__tmp.f_key;
			final Object l8_v = l1__tmp.f_value;
			final Struct l9_left = l1__tmp.f_left;
			final Struct l10_right = l1__tmp.f_right;
			final int l11_depth = l1__tmp.f_depth;
			return runtime.m_array.f_concat3(f_getTreeValues(l9_left), (new Object[] { l8_v }), f_getTreeValues(l10_right));
		}
		default:
			throw new RuntimeException("Unexpected struct in switch: "+l0__tmp.getTypeName());
		}
	}
	Struct f_lookupTree(Struct aset, Object akey) {
	 TAIL_CALL: for(;;) {
		Struct l0__tmp = aset;
		switch (l0__tmp.getTypeId()) {
		case 113/*TreeNode*/: {
			final Struct_TreeNode l1__tmp = (Struct_TreeNode)l0__tmp;
			final Object l2_k = l1__tmp.f_key;
			final Object l3_v = l1__tmp.f_value;
			final Struct l4_l = l1__tmp.f_left;
			final Struct l5_r = l1__tmp.f_right;
			final int l6_depth = l1__tmp.f_depth;
			final Object l7_k = l1__tmp.f_key;
			final Object l8_v = l1__tmp.f_value;
			final Struct l9_l = l1__tmp.f_left;
			final Struct l10_r = l1__tmp.f_right;
			final int l11_depth = l1__tmp.f_depth;
			if ((FlowRuntime.compareByValue(akey,l7_k)<0)) {
				{
					final Struct l12___tmp = l9_l;
					aset = l12___tmp;
					continue TAIL_CALL;
				}
			} else {
				if (FlowRuntime.compareEqual(akey,l7_k)) {
					return (new Struct_Some(l8_v));
				} else {
					{
						final Struct l13___tmp = l10_r;
						aset = l13___tmp;
						continue TAIL_CALL;
					}
				}
			}
		}
		case 112/*TreeEmpty*/: {
			return ((Struct)SingletonStructs.str_None);
		}
		default:
			throw new RuntimeException("Unexpected struct in switch: "+l0__tmp.getTypeName());
		}
	 }
	}
	Object f_lookupTreeDef(Struct ax, Object akey, Object adefaultValue) {
		return runtime.m_maybe.f_either(runtime.n_lookupTree.invoke(ax, akey), adefaultValue);
	}
	Struct f_makeTree() {
		return ((Struct)SingletonStructs.str_TreeEmpty);
	}
	Struct_TreeNode f_makeTree1(Object akey, Object avalue) {
		return (new Struct_TreeNode(akey, avalue, ((Struct)SingletonStructs.str_TreeEmpty), ((Struct)SingletonStructs.str_TreeEmpty), 1));
	}
	Struct f_mapTree(Struct atree, Func1<Object,Object> af) {
		Struct l0__tmp = atree;
		switch (l0__tmp.getTypeId()) {
		case 112/*TreeEmpty*/: {
			return ((Struct)SingletonStructs.str_TreeEmpty);
		}
		case 113/*TreeNode*/: {
			final Struct_TreeNode l1__tmp = (Struct_TreeNode)l0__tmp;
			final Object l2_k = l1__tmp.f_key;
			final Object l3_v = l1__tmp.f_value;
			final Struct l4_left = l1__tmp.f_left;
			final Struct l5_right = l1__tmp.f_right;
			final int l6_depth = l1__tmp.f_depth;
			final Object l7_k = l1__tmp.f_key;
			final Object l8_v = l1__tmp.f_value;
			final Struct l9_left = l1__tmp.f_left;
			final Struct l10_right = l1__tmp.f_right;
			final int l11_depth = l1__tmp.f_depth;
			return (new Struct_TreeNode(l7_k, af.invoke(l8_v), f_mapTree(l9_left, af), f_mapTree(l10_right, af), l11_depth));
		}
		default:
			throw new RuntimeException("Unexpected struct in switch: "+l0__tmp.getTypeName());
		}
	}
	Struct f_mergeTreeCustom(Struct at1, Struct at2, Func3<Object,Object, Object, Object> afn) {
		final Func3<Object,Object, Object, Object> l2_fn = afn;
		final Func3<Struct,Object, Object, Struct> l1_$0 = new Func3<Struct,Object,Object,Struct>() {
			final public Struct invoke(final Object ak, final Object av, final Struct aacc) {
				final Struct l2_$1 = runtime.n_lookupTree.invoke(aacc, ak);
				final Func1<Object,Object> l3_$0 = new Func1<Object,Object>() {
					final public Object invoke(final Object av2) {
						return l2_fn.invoke(ak, av, av2);
					}
				};
				final Object l4_vv = runtime.m_maybe.f_eitherMap(l2_$1, l3_$0, av);
				return runtime.n_setTree.invoke(aacc, ak, l4_vv);
			}
		};
		return ((Struct)f_foldTree(at2, at1, ((Func3<Object,Object, Object, Object>)(Func3)l1_$0)));
	}
	Struct f_mergeTreeInternal(Struct at1, Struct at2) {
		Struct l0__tmp = at1;
		switch (l0__tmp.getTypeId()) {
		case 112/*TreeEmpty*/: {
			return at2;
		}
		case 113/*TreeNode*/: {
			final Struct_TreeNode l1__tmp = (Struct_TreeNode)l0__tmp;
			final Object l2_k1 = l1__tmp.f_key;
			final Object l3_v1 = l1__tmp.f_value;
			final Struct l4_l1 = l1__tmp.f_left;
			final Struct l5_r1 = l1__tmp.f_right;
			final int l6_d1 = l1__tmp.f_depth;
			final Object l7_k1 = l1__tmp.f_key;
			final Object l8_v1 = l1__tmp.f_value;
			final Struct l9_l1 = l1__tmp.f_left;
			final Struct l10_r1 = l1__tmp.f_right;
			final int l11_d1 = l1__tmp.f_depth;
			Struct l12__tmp = at2;
			switch (l12__tmp.getTypeId()) {
			case 112/*TreeEmpty*/: {
				return l1__tmp;
			}
			case 113/*TreeNode*/: {
				final Struct_TreeNode l13__tmp = (Struct_TreeNode)l12__tmp;
				final Object l14_k2 = l13__tmp.f_key;
				final Object l15_v2 = l13__tmp.f_value;
				final Struct l16_l2 = l13__tmp.f_left;
				final Struct l17_r2 = l13__tmp.f_right;
				final int l18_d2 = l13__tmp.f_depth;
				final Object l19_k2 = l13__tmp.f_key;
				final Object l20_v2 = l13__tmp.f_value;
				final Struct l21_l2 = l13__tmp.f_left;
				final Struct l22_r2 = l13__tmp.f_right;
				final int l23_d2 = l13__tmp.f_depth;
				final Struct l24_p = f_popmax(l1__tmp);
				Struct l25__tmp = l24_p;
				switch (l25__tmp.getTypeId()) {
				case 23/*EmptyPopResult*/: {
					return l1__tmp;
				}
				case 95/*PopResult*/: {
					final Struct_PopResult l26__tmp = (Struct_PopResult)l25__tmp;
					final Object l27_mk = l26__tmp.f_k;
					final Object l28_mv = l26__tmp.f_v;
					final Struct l29_mrest = l26__tmp.f_rest;
					final Object l30_mk = l26__tmp.f_k;
					final Object l31_mv = l26__tmp.f_v;
					final Struct l32_mrest = l26__tmp.f_rest;
					return f_mkTreeNode(l30_mk, l31_mv, l32_mrest, l13__tmp);
				}
				default:
					throw new RuntimeException("Unexpected struct in switch: "+l25__tmp.getTypeName());
				}
			}
			default:
				throw new RuntimeException("Unexpected struct in switch: "+l12__tmp.getTypeName());
			}
		}
		default:
			throw new RuntimeException("Unexpected struct in switch: "+l0__tmp.getTypeName());
		}
	}
	Struct_TreeNode f_mkTreeNode(Object ak, Object av, Struct aleft, Struct aright) {
		return (new Struct_TreeNode(ak, av, aleft, aright, (((int)((Func2<Integer,Integer, Integer>)(Func2)runtime.n_max).invoke(((Integer)f_treeDepth(aleft)), ((Integer)f_treeDepth(aright))))+1)));
	}
	Struct f_popmax(Struct at) {
		Struct l0__tmp = at;
		switch (l0__tmp.getTypeId()) {
		case 112/*TreeEmpty*/: {
			return ((Struct)SingletonStructs.str_EmptyPopResult);
		}
		case 113/*TreeNode*/: {
			final Struct_TreeNode l1__tmp = (Struct_TreeNode)l0__tmp;
			final Object l2_k = l1__tmp.f_key;
			final Object l3_v = l1__tmp.f_value;
			final Struct l4_l = l1__tmp.f_left;
			final Struct l5_r = l1__tmp.f_right;
			final int l6_d = l1__tmp.f_depth;
			final Object l7_k = l1__tmp.f_key;
			final Object l8_v = l1__tmp.f_value;
			final Struct l9_l = l1__tmp.f_left;
			final Struct l10_r = l1__tmp.f_right;
			final int l11_d = l1__tmp.f_depth;
			Struct l12__tmp = l10_r;
			switch (l12__tmp.getTypeId()) {
			case 112/*TreeEmpty*/: {
				return (new Struct_PopResult(l7_k, l8_v, l9_l));
			}
			case 113/*TreeNode*/: {
				final Struct_TreeNode l13__tmp = (Struct_TreeNode)l12__tmp;
				final Object l14_k1 = l13__tmp.f_key;
				final Object l15_v1 = l13__tmp.f_value;
				final Struct l16_l1 = l13__tmp.f_left;
				final Struct l17_r1 = l13__tmp.f_right;
				final int l18_d1 = l13__tmp.f_depth;
				final Object l19_k1 = l13__tmp.f_key;
				final Object l20_v1 = l13__tmp.f_value;
				final Struct l21_l1 = l13__tmp.f_left;
				final Struct l22_r1 = l13__tmp.f_right;
				final int l23_d1 = l13__tmp.f_depth;
				final Struct l24_p = f_popmax(l13__tmp);
				Struct l25__tmp = l24_p;
				switch (l25__tmp.getTypeId()) {
				case 23/*EmptyPopResult*/: {
					return l24_p;
				}
				case 95/*PopResult*/: {
					final Struct_PopResult l26__tmp = (Struct_PopResult)l25__tmp;
					final Object l27_mk = l26__tmp.f_k;
					final Object l28_mv = l26__tmp.f_v;
					final Struct l29_mrest = l26__tmp.f_rest;
					final Object l30_mk = l26__tmp.f_k;
					final Object l31_mv = l26__tmp.f_v;
					final Struct l32_mrest = l26__tmp.f_rest;
					return (new Struct_PopResult(l30_mk, l31_mv, f_mkTreeNode(l7_k, l8_v, l9_l, l32_mrest)));
				}
				default:
					throw new RuntimeException("Unexpected struct in switch: "+l25__tmp.getTypeName());
				}
			}
			default:
				throw new RuntimeException("Unexpected struct in switch: "+l12__tmp.getTypeName());
			}
		}
		default:
			throw new RuntimeException("Unexpected struct in switch: "+l0__tmp.getTypeName());
		}
	}
	Struct f_rebalancedTree(Object ak, Object av, Struct aleft, Struct aright) {
		final int l0_leftDepth = f_treeDepth(aleft);
		final int l1_rightDepth = f_treeDepth(aright);
		final int l2_balance = (l0_leftDepth-l1_rightDepth);
		final Struct_TreeNode l3_composed = (new Struct_TreeNode(ak, av, aleft, aright, (((int)((Func2<Integer,Integer, Integer>)(Func2)runtime.n_max).invoke(((Integer)l0_leftDepth), ((Integer)l1_rightDepth)))+1)));
		if ((((l2_balance==(-1))||(l2_balance==0))||(l2_balance==1))) {
			return l3_composed;
		} else {
			if ((l2_balance<0)) {
				Struct l4__tmp = aright;
				switch (l4__tmp.getTypeId()) {
				case 112/*TreeEmpty*/: {
					return l3_composed;
				}
				case 113/*TreeNode*/: {
					final Struct_TreeNode l5__tmp = (Struct_TreeNode)l4__tmp;
					final Object l6_rk = l5__tmp.f_key;
					final Object l7_rv = l5__tmp.f_value;
					final Struct l8_rl = l5__tmp.f_left;
					final Struct l9_rr = l5__tmp.f_right;
					final int l10_rdepth = l5__tmp.f_depth;
					final Object l11_rk = l5__tmp.f_key;
					final Object l12_rv = l5__tmp.f_value;
					final Struct l13_rl = l5__tmp.f_left;
					final Struct l14_rr = l5__tmp.f_right;
					final int l15_rdepth = l5__tmp.f_depth;
					return f_treeLeftRotation(((f_treeDepth(l13_rl)<f_treeDepth(l14_rr))?l3_composed:f_mkTreeNode(ak, av, aleft, f_treeRightRotation(l5__tmp))));
				}
				default:
					throw new RuntimeException("Unexpected struct in switch: "+l4__tmp.getTypeName());
				}
			} else {
				Struct l16__tmp = aleft;
				switch (l16__tmp.getTypeId()) {
				case 112/*TreeEmpty*/: {
					return l3_composed;
				}
				case 113/*TreeNode*/: {
					final Struct_TreeNode l17__tmp = (Struct_TreeNode)l16__tmp;
					final Object l18_lk = l17__tmp.f_key;
					final Object l19_lv = l17__tmp.f_value;
					final Struct l20_ll = l17__tmp.f_left;
					final Struct l21_lr = l17__tmp.f_right;
					final int l22_ldepth = l17__tmp.f_depth;
					final Object l23_lk = l17__tmp.f_key;
					final Object l24_lv = l17__tmp.f_value;
					final Struct l25_ll = l17__tmp.f_left;
					final Struct l26_lr = l17__tmp.f_right;
					final int l27_ldepth = l17__tmp.f_depth;
					return f_treeRightRotation(((f_treeDepth(l25_ll)<f_treeDepth(l26_lr))?f_mkTreeNode(ak, av, f_treeLeftRotation(l17__tmp), aright):l3_composed));
				}
				default:
					throw new RuntimeException("Unexpected struct in switch: "+l16__tmp.getTypeName());
				}
			}
		}
	}
	Struct f_removeFromTree(Struct aset, Object akey) {
		Struct l0__tmp = aset;
		switch (l0__tmp.getTypeId()) {
		case 113/*TreeNode*/: {
			final Struct_TreeNode l1__tmp = (Struct_TreeNode)l0__tmp;
			final Object l2_k = l1__tmp.f_key;
			final Object l3_v = l1__tmp.f_value;
			final Struct l4_left = l1__tmp.f_left;
			final Struct l5_right = l1__tmp.f_right;
			final int l6_depth = l1__tmp.f_depth;
			final Object l7_k = l1__tmp.f_key;
			final Object l8_v = l1__tmp.f_value;
			final Struct l9_left = l1__tmp.f_left;
			final Struct l10_right = l1__tmp.f_right;
			final int l11_depth = l1__tmp.f_depth;
			if ((FlowRuntime.compareByValue(akey,l7_k)<0)) {
				return f_mkTreeNode(l7_k, l8_v, f_removeFromTree(l9_left, akey), l10_right);
			} else {
				if (FlowRuntime.compareEqual(akey,l7_k)) {
					return f_mergeTreeInternal(l9_left, l10_right);
				} else {
					return f_mkTreeNode(l7_k, l8_v, l9_left, f_removeFromTree(l10_right, akey));
				}
			}
		}
		case 112/*TreeEmpty*/: {
			return aset;
		}
		default:
			throw new RuntimeException("Unexpected struct in switch: "+l0__tmp.getTypeName());
		}
	}
	Struct f_setTree(Struct aset, Object akey, Object avalue) {
		Struct l0__tmp = aset;
		switch (l0__tmp.getTypeId()) {
		case 113/*TreeNode*/: {
			final Struct_TreeNode l1__tmp = (Struct_TreeNode)l0__tmp;
			final Object l2_k = l1__tmp.f_key;
			final Object l3_v = l1__tmp.f_value;
			final Struct l4_left = l1__tmp.f_left;
			final Struct l5_right = l1__tmp.f_right;
			final int l6_depth = l1__tmp.f_depth;
			final Object l7_k = l1__tmp.f_key;
			final Object l8_v = l1__tmp.f_value;
			final Struct l9_left = l1__tmp.f_left;
			final Struct l10_right = l1__tmp.f_right;
			final int l11_depth = l1__tmp.f_depth;
			if ((FlowRuntime.compareByValue(akey,l7_k)<0)) {
				return f_rebalancedTree(l7_k, l8_v, runtime.n_setTree.invoke(l9_left, akey, avalue), l10_right);
			} else {
				if (FlowRuntime.compareEqual(akey,l7_k)) {
					return (new Struct_TreeNode(l7_k, avalue, l9_left, l10_right, l11_depth));
				} else {
					return f_rebalancedTree(l7_k, l8_v, l9_left, runtime.n_setTree.invoke(l10_right, akey, avalue));
				}
			}
		}
		case 112/*TreeEmpty*/: {
			return (new Struct_TreeNode(akey, avalue, ((Struct)SingletonStructs.str_TreeEmpty), ((Struct)SingletonStructs.str_TreeEmpty), 1));
		}
		default:
			throw new RuntimeException("Unexpected struct in switch: "+l0__tmp.getTypeName());
		}
	}
	int f_sizeTree(Struct at) {
		Struct l0__tmp = at;
		switch (l0__tmp.getTypeId()) {
		case 112/*TreeEmpty*/: {
			return 0;
		}
		case 113/*TreeNode*/: {
			final Struct_TreeNode l1__tmp = (Struct_TreeNode)l0__tmp;
			final Object l2_k = l1__tmp.f_key;
			final Object l3_v = l1__tmp.f_value;
			final Struct l4_l = l1__tmp.f_left;
			final Struct l5_r = l1__tmp.f_right;
			final int l6_depth = l1__tmp.f_depth;
			final Object l7_k = l1__tmp.f_key;
			final Object l8_v = l1__tmp.f_value;
			final Struct l9_l = l1__tmp.f_left;
			final Struct l10_r = l1__tmp.f_right;
			final int l11_depth = l1__tmp.f_depth;
			return ((1+f_sizeTree(l9_l))+f_sizeTree(l10_r));
		}
		default:
			throw new RuntimeException("Unexpected struct in switch: "+l0__tmp.getTypeName());
		}
	}
	Object f_traverseInOrder(Struct atree, Func2<Object,Object, Object> afn) {
	 TAIL_CALL: for(;;) {
		Struct l0__tmp = atree;
		switch (l0__tmp.getTypeId()) {
		case 112/*TreeEmpty*/: {
			return null;
		}
		case 113/*TreeNode*/: {
			final Struct_TreeNode l1__tmp = (Struct_TreeNode)l0__tmp;
			final Object l2_k = l1__tmp.f_key;
			final Object l3_v = l1__tmp.f_value;
			final Struct l4_left = l1__tmp.f_left;
			final Struct l5_right = l1__tmp.f_right;
			final int l6_depth = l1__tmp.f_depth;
			final Object l7_k = l1__tmp.f_key;
			final Object l8_v = l1__tmp.f_value;
			final Struct l9_left = l1__tmp.f_left;
			final Struct l10_right = l1__tmp.f_right;
			final int l11_depth = l1__tmp.f_depth;
			f_traverseInOrder(l9_left, afn);
			afn.invoke(l7_k, l8_v);
			{
				final Struct l12___tmp = l10_right;
				atree = l12___tmp;
				continue TAIL_CALL;
			}
		}
		default:
			throw new RuntimeException("Unexpected struct in switch: "+l0__tmp.getTypeName());
		}
	 }
	}
	int f_treeDepth(Struct atree) {
		Struct l0__tmp = atree;
		switch (l0__tmp.getTypeId()) {
		case 112/*TreeEmpty*/: {
			return 0;
		}
		case 113/*TreeNode*/: {
			final Struct_TreeNode l1__tmp = (Struct_TreeNode)l0__tmp;
			final int l2_depth = l1__tmp.f_depth;
			final Object l3___ = l1__tmp.f_key;
			final Object l4___ = l1__tmp.f_value;
			final Struct l5___ = l1__tmp.f_left;
			final Struct l6___ = l1__tmp.f_right;
			final int l7_depth = l1__tmp.f_depth;
			return l7_depth;
		}
		default:
			throw new RuntimeException("Unexpected struct in switch: "+l0__tmp.getTypeName());
		}
	}
	Struct f_treeLeftRotation(Struct atree) {
		Struct l0__tmp = atree;
		switch (l0__tmp.getTypeId()) {
		case 112/*TreeEmpty*/: {
			return atree;
		}
		case 113/*TreeNode*/: {
			final Struct_TreeNode l1__tmp = (Struct_TreeNode)l0__tmp;
			final Object l2_k = l1__tmp.f_key;
			final Object l3_v = l1__tmp.f_value;
			final Struct l4_left = l1__tmp.f_left;
			final Struct l5_right = l1__tmp.f_right;
			final int l6_depth = l1__tmp.f_depth;
			final Object l7_k = l1__tmp.f_key;
			final Object l8_v = l1__tmp.f_value;
			final Struct l9_left = l1__tmp.f_left;
			final Struct l10_right = l1__tmp.f_right;
			final int l11_depth = l1__tmp.f_depth;
			Struct l12__tmp = l10_right;
			switch (l12__tmp.getTypeId()) {
			case 112/*TreeEmpty*/: {
				return l1__tmp;
			}
			case 113/*TreeNode*/: {
				final Struct_TreeNode l13__tmp = (Struct_TreeNode)l12__tmp;
				final Object l14_ck = l13__tmp.f_key;
				final Object l15_cv = l13__tmp.f_value;
				final Struct l16_cleft = l13__tmp.f_left;
				final Struct l17_cright = l13__tmp.f_right;
				final int l18_cdepth = l13__tmp.f_depth;
				final Object l19_ck = l13__tmp.f_key;
				final Object l20_cv = l13__tmp.f_value;
				final Struct l21_cleft = l13__tmp.f_left;
				final Struct l22_cright = l13__tmp.f_right;
				final int l23_cdepth = l13__tmp.f_depth;
				return f_mkTreeNode(l19_ck, l20_cv, f_mkTreeNode(l7_k, l8_v, l9_left, l21_cleft), l22_cright);
			}
			default:
				throw new RuntimeException("Unexpected struct in switch: "+l12__tmp.getTypeName());
			}
		}
		default:
			throw new RuntimeException("Unexpected struct in switch: "+l0__tmp.getTypeName());
		}
	}
	Struct f_treeRightRotation(Struct atree) {
		Struct l0__tmp = atree;
		switch (l0__tmp.getTypeId()) {
		case 112/*TreeEmpty*/: {
			return atree;
		}
		case 113/*TreeNode*/: {
			final Struct_TreeNode l1__tmp = (Struct_TreeNode)l0__tmp;
			final Object l2_k = l1__tmp.f_key;
			final Object l3_v = l1__tmp.f_value;
			final Struct l4_left = l1__tmp.f_left;
			final Struct l5_right = l1__tmp.f_right;
			final int l6_depth = l1__tmp.f_depth;
			final Object l7_k = l1__tmp.f_key;
			final Object l8_v = l1__tmp.f_value;
			final Struct l9_left = l1__tmp.f_left;
			final Struct l10_right = l1__tmp.f_right;
			final int l11_depth = l1__tmp.f_depth;
			Struct l12__tmp = l9_left;
			switch (l12__tmp.getTypeId()) {
			case 112/*TreeEmpty*/: {
				return l1__tmp;
			}
			case 113/*TreeNode*/: {
				final Struct_TreeNode l13__tmp = (Struct_TreeNode)l12__tmp;
				final Object l14_ck = l13__tmp.f_key;
				final Object l15_cv = l13__tmp.f_value;
				final Struct l16_cleft = l13__tmp.f_left;
				final Struct l17_cright = l13__tmp.f_right;
				final int l18_cdepth = l13__tmp.f_depth;
				final Object l19_ck = l13__tmp.f_key;
				final Object l20_cv = l13__tmp.f_value;
				final Struct l21_cleft = l13__tmp.f_left;
				final Struct l22_cright = l13__tmp.f_right;
				final int l23_cdepth = l13__tmp.f_depth;
				return f_mkTreeNode(l19_ck, l20_cv, l21_cleft, f_mkTreeNode(l7_k, l8_v, l22_cright, l10_right));
			}
			default:
				throw new RuntimeException("Unexpected struct in switch: "+l12__tmp.getTypeName());
			}
		}
		default:
			throw new RuntimeException("Unexpected struct in switch: "+l0__tmp.getTypeName());
		}
	}
}
