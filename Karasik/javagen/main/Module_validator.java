// HASH COLLISIONS: YES
// timestamp: 1.609182842E12

package main;

import com.area9innovation.flow.*;

@SuppressWarnings("unchecked")
final class Module_validator {
	final main runtime;
	Module_validator(main runtime) {
		this.runtime = runtime;
	}
	Struct_Pair f_checkAnnotations(Struct_ProgramSequence aps, int alevel, int asize, boolean acontainsAnnotation, Struct avars) {
		final Struct_Triple l0_p = f_checkFormules(aps.f_op, alevel, asize, acontainsAnnotation, avars);
		final Struct l1_gsymswitch0 = aps.f_next;
		Struct l2__tmp = l1_gsymswitch0;
		switch (l2__tmp.getTypeId()) {
		case 133/*Some*/: {
			final Struct_Some l3__tmp = (Struct_Some)l2__tmp;
			final Object l4_ps1 = l3__tmp.f_value;
			final Struct_ProgramSequence l5_ps1 = ((Struct_ProgramSequence)l3__tmp.f_value);
			final Struct_Pair l6_p1 = f_checkAnnotations(l5_ps1, (alevel+1), asize, ((boolean)l0_p.f_second), avars);
			return (new Struct_Pair((((boolean)l0_p.f_first)&&((boolean)l6_p1.f_first)), runtime.m_string.f_trim2(((((String)l0_p.f_third)+"\n")+((String)l6_p1.f_second)), "\n")));
		}
		case 69/*None*/: {
			return (new Struct_Pair(l0_p.f_first, l0_p.f_third));
		}
		default:
			throw new RuntimeException("Unexpected struct in switch: "+l2__tmp.getTypeName());
		}
	}
	Struct_Triple f_checkFormules(Struct aop, int alevel, int asize, boolean acontainsAnnotation, Struct avars) {
		Struct l0__tmp = aop;
		switch (l0__tmp.getTypeId()) {
		case 11/*Annotation*/: {
			final Struct_Annotation l1__tmp = (Struct_Annotation)l0__tmp;
			final Struct l2_formule = l1__tmp.f_formule;
			final Struct l3_formule = l1__tmp.f_formule;
			if (((alevel!=0)&&(alevel!=(asize-1)))) {
				return (new Struct_Triple(false, false, "Annotation in body of program!"));
			} else {
				if (((alevel!=0)&&!acontainsAnnotation)) {
					return (new Struct_Triple(false, false, "Have last annotation, but haven't first!"));
				} else {
					final Struct_Pair l4_p0 = f_checkVariblesOfFormules(l3_formule, avars);
					return (new Struct_Triple(l4_p0.f_first, true, l4_p0.f_second));
				}
			}
		}
		case 149/*While*/: {
			final Struct_While l1__tmp = (Struct_While)l0__tmp;
			final Struct_Test l5_t = l1__tmp.f_test;
			final Struct l6_a = l1__tmp.f_a;
			final Struct l7_i = l1__tmp.f_invariant;
			final Struct_Test l8_t = l1__tmp.f_test;
			final Struct l9_a = l1__tmp.f_a;
			final Struct l10_i = l1__tmp.f_invariant;
			Struct l11__tmp = l10_i;
			switch (l11__tmp.getTypeId()) {
			case 69/*None*/: {
				if (acontainsAnnotation) {
					return (new Struct_Triple(false, true, "I haven't invariant, but have begin annotation!"));
				} else {
					return (new Struct_Triple(true, false, ""));
				}
			}
			case 133/*Some*/: {
				final Struct_Some l12__tmp = (Struct_Some)l11__tmp;
				final Object l13_ann = l12__tmp.f_value;
				final Struct_Annotation l14_ann = ((Struct_Annotation)l12__tmp.f_value);
				if (!acontainsAnnotation) {
					return (new Struct_Triple(false, false, "I have invariant, but haven't begin annotation!"));
				} else {
					final Struct_Pair l15_p = f_checkVariblesOfFormules(l14_ann.f_formule, avars);
					return (new Struct_Triple(l15_p.f_first, true, l15_p.f_second));
				}
			}
			default:
				throw new RuntimeException("Unexpected struct in switch: "+l11__tmp.getTypeName());
			}
		}
		case 64/*Loop*/: {
			final Struct_Loop l1__tmp = (Struct_Loop)l0__tmp;
			final Struct l16_c = l1__tmp.f_f;
			final Struct l17_i = l1__tmp.f_invariant;
			final Struct l18_c = l1__tmp.f_f;
			final Struct l19_i = l1__tmp.f_invariant;
			Struct l20__tmp = l19_i;
			switch (l20__tmp.getTypeId()) {
			case 69/*None*/: {
				if (acontainsAnnotation) {
					return (new Struct_Triple(false, true, "I haven't invariant, but have begin annotation!"));
				} else {
					return (new Struct_Triple(true, false, ""));
				}
			}
			case 133/*Some*/: {
				final Struct_Some l21__tmp = (Struct_Some)l20__tmp;
				final Object l22_ann = l21__tmp.f_value;
				final Struct_Annotation l23_ann = ((Struct_Annotation)l21__tmp.f_value);
				if (!acontainsAnnotation) {
					return (new Struct_Triple(false, false, "I have invariant, but haven't begin annotation!"));
				} else {
					final Struct_Pair l24_p = f_checkVariblesOfFormules(l23_ann.f_formule, avars);
					return (new Struct_Triple(l24_p.f_first, true, l24_p.f_second));
				}
			}
			default:
				throw new RuntimeException("Unexpected struct in switch: "+l20__tmp.getTypeName());
			}
		}
		default: {
			return (new Struct_Triple(true, acontainsAnnotation, ""));
		}
		}
	}
	Struct_Pair f_checkStructure(Struct_ProgramSequence aps) {
		final Struct_Triple l0_p0 = f_checkVariables(aps, runtime.m_tree.f_makeTree());
		final Struct_Pair l1_p1 = f_checkAnnotations(aps, 0, f_getProgramDepth(aps), false, ((Struct)l0_p0.f_third));
		return (new Struct_Pair((((boolean)l0_p0.f_first)&&((boolean)l1_p1.f_first)), runtime.m_string.f_trim2(((((String)l0_p0.f_second)+"\n")+((String)l1_p1.f_second)), "\n")));
	}
	Struct_Triple f_checkVariables(Struct_ProgramSequence aps, Struct avars) {
		final Struct_Triple l0_p = f_checkVariblesOfCommands(aps.f_op, avars);
		final Struct l1_gsymswitch1 = aps.f_next;
		Struct l2__tmp = l1_gsymswitch1;
		switch (l2__tmp.getTypeId()) {
		case 133/*Some*/: {
			final Struct_Some l3__tmp = (Struct_Some)l2__tmp;
			final Object l4_ps1 = l3__tmp.f_value;
			final Struct_ProgramSequence l5_ps1 = ((Struct_ProgramSequence)l3__tmp.f_value);
			final Struct_Triple l6_p1 = f_checkVariables(l5_ps1, ((Struct)l0_p.f_third));
			return (new Struct_Triple((((boolean)l0_p.f_first)&&((boolean)l6_p1.f_first)), runtime.m_string.f_trim2(((((String)l0_p.f_second)+"\n")+((String)l6_p1.f_second)), "\n"), runtime.m_tree.f_mergeTree(((Struct)l6_p1.f_third), ((Struct)l0_p.f_third))));
		}
		case 69/*None*/: {
			return l0_p;
		}
		default:
			throw new RuntimeException("Unexpected struct in switch: "+l2__tmp.getTypeName());
		}
	}
	Struct_Pair f_checkVariablesOfLTypes(Struct at, Struct avars) {
		Struct l0__tmp = at;
		switch (l0__tmp.getTypeId()) {
		case 58/*LInt*/: {
			final Struct_LInt l1__tmp = (Struct_LInt)l0__tmp;
			final int l2_val = l1__tmp.f_v;
			final int l3_val = l1__tmp.f_v;
			return (new Struct_Pair(true, ""));
		}
		case 60/*LVariable*/: {
			final Struct_LVariable l1__tmp = (Struct_LVariable)l0__tmp;
			final String l4_var = l1__tmp.f_name;
			final String l5_var = l1__tmp.f_name;
			if (runtime.m_tree.f_containsKeyTree(avars, l5_var)) {
				return (new Struct_Pair(true, ""));
			} else {
				return (new Struct_Pair(false, (("Variable "+l5_var)+" doesnt exists!")));
			}
		}
		case 57/*LBinOp*/: {
			final Struct_LBinOp l1__tmp = (Struct_LBinOp)l0__tmp;
			final String l6_op = l1__tmp.f_op;
			final Struct l7_f = l1__tmp.f_f;
			final Struct l8_s = l1__tmp.f_s;
			final String l9_op = l1__tmp.f_op;
			final Struct l10_f = l1__tmp.f_f;
			final Struct l11_s = l1__tmp.f_s;
			final Struct_Pair l12_p0 = f_checkVariablesOfLTypes(l10_f, avars);
			final Struct_Pair l13_p1 = f_checkVariablesOfLTypes(l11_s, avars);
			return (new Struct_Pair((((boolean)l12_p0.f_first)&&((boolean)l13_p1.f_first)), runtime.m_string.f_trim2(((((String)l12_p0.f_second)+"\n")+((String)l13_p1.f_second)), "\n")));
		}
		case 56/*LAccessArray*/: {
			final Struct_LAccessArray l1__tmp = (Struct_LAccessArray)l0__tmp;
			final Struct l14_name = l1__tmp.f_name;
			final Struct l15_index = l1__tmp.f_index;
			final Struct_LVariable l16_name = ((Struct_LVariable)l1__tmp.f_name);
			final Struct l17_index = l1__tmp.f_index;
			final Struct_Pair l18_p0 = f_checkVariablesOfLTypes(l16_name, avars);
			final Struct_Pair l19_p1 = f_checkVariablesOfLTypes(l17_index, avars);
			return (new Struct_Pair((((boolean)l18_p0.f_first)&&((boolean)l19_p1.f_first)), runtime.m_string.f_trim2(((((String)l18_p0.f_second)+"\n")+((String)l19_p1.f_second)), "\n")));
		}
		case 59/*LRedefineArray*/: {
			final Struct_LRedefineArray l1__tmp = (Struct_LRedefineArray)l0__tmp;
			final Struct l20_name = l1__tmp.f_name;
			final Struct l21_index = l1__tmp.f_index;
			final Struct l22_value = l1__tmp.f_value;
			final Struct_LVariable l23_name = ((Struct_LVariable)l1__tmp.f_name);
			final Struct l24_index = l1__tmp.f_index;
			final Struct l25_value = l1__tmp.f_value;
			final Struct_Pair l26_p0 = f_checkVariablesOfLTypes(l23_name, avars);
			final Struct_Pair l27_p1 = f_checkVariablesOfLTypes(l24_index, avars);
			final Struct_Pair l28_p2 = f_checkVariablesOfLTypes(l25_value, avars);
			return (new Struct_Pair(((((boolean)l26_p0.f_first)&&((boolean)l27_p1.f_first))&&((boolean)l28_p2.f_first)), runtime.m_string.f_trim2(((((((String)l26_p0.f_second)+"\n")+((String)l27_p1.f_second))+"\n")+((String)l28_p2.f_second)), "\n")));
		}
		default:
			throw new RuntimeException("Unexpected struct in switch: "+l0__tmp.getTypeName());
		}
	}
	Struct_Pair f_checkVariablesOfTypes(Struct at, Struct avars) {
	 TAIL_CALL: for(;;) {
		Struct l0__tmp = at;
		switch (l0__tmp.getTypeId()) {
		case 43/*Int*/: {
			final Struct_Int l1__tmp = (Struct_Int)l0__tmp;
			final int l2_val = l1__tmp.f_v;
			final int l3_val = l1__tmp.f_v;
			return (new Struct_Pair(true, ""));
		}
		case 147/*Variable*/: {
			final Struct_Variable l1__tmp = (Struct_Variable)l0__tmp;
			final String l4_var = l1__tmp.f_name;
			final String l5_var = l1__tmp.f_name;
			if (runtime.m_tree.f_containsKeyTree(avars, l5_var)) {
				return (new Struct_Pair(true, ""));
			} else {
				return (new Struct_Pair(false, (("Variable "+l5_var)+" doesnt exists!")));
			}
		}
		case 12/*Array*/: {
			final Struct_Array l1__tmp = (Struct_Array)l0__tmp;
			final int l6_type = l1__tmp.f_size;
			final int l7_type = l1__tmp.f_size;
			return (new Struct_Pair(true, ""));
		}
		case 15/*BinOp*/: {
			final Struct_BinOp l1__tmp = (Struct_BinOp)l0__tmp;
			final String l8_op = l1__tmp.f_op;
			final Struct l9_f = l1__tmp.f_f;
			final Struct l10_s = l1__tmp.f_s;
			final String l11_op = l1__tmp.f_op;
			final Struct l12_f = l1__tmp.f_f;
			final Struct l13_s = l1__tmp.f_s;
			final Struct_Pair l14_p0 = f_checkVariablesOfTypes(l12_f, avars);
			final Struct_Pair l15_p1 = f_checkVariablesOfTypes(l13_s, avars);
			return (new Struct_Pair((((boolean)l14_p0.f_first)&&((boolean)l15_p1.f_first)), runtime.m_string.f_trim2(((((String)l14_p0.f_second)+"\n")+((String)l15_p1.f_second)), "\n")));
		}
		case 141/*UnOp*/: {
			final Struct_UnOp l1__tmp = (Struct_UnOp)l0__tmp;
			final String l16_op = l1__tmp.f_op;
			final Struct l17_f = l1__tmp.f_u;
			final String l18_op = l1__tmp.f_op;
			final Struct l19_f = l1__tmp.f_u;
			{
				final Struct l20___tmp = l19_f;
				at = l20___tmp;
				continue TAIL_CALL;
			}
		}
		case 13/*ArrayAccess*/: {
			final Struct_ArrayAccess l1__tmp = (Struct_ArrayAccess)l0__tmp;
			final Struct_Variable l21_var = l1__tmp.f_var;
			final Struct l22_ind = l1__tmp.f_ind;
			final Struct_Variable l23_var = l1__tmp.f_var;
			final Struct l24_ind = l1__tmp.f_ind;
			if (runtime.m_tree.f_containsKeyTree(avars, l23_var.f_name)) {
				{
					final Struct l25___tmp = l24_ind;
					at = l25___tmp;
					continue TAIL_CALL;
				}
			} else {
				return (new Struct_Pair(false, (("Variable "+l23_var.f_name)+" doesnt exists!")));
			}
		}
		case 30/*EmptyType*/: {
			return (new Struct_Pair(true, ""));
		}
		case 146/*VarRedefine*/: {
			final Struct_VarRedefine l1__tmp = (Struct_VarRedefine)l0__tmp;
			final String l26_name = l1__tmp.f_name;
			final Struct l27_val = l1__tmp.f_value;
			final String l28_name = l1__tmp.f_name;
			final Struct l29_val = l1__tmp.f_value;
			if (!runtime.m_tree.f_containsKeyTree(avars, l28_name)) {
				return (new Struct_Pair(false, (("Variable "+l28_name)+" doesn't exists!")));
			} else {
				return (new Struct_Pair(true, ""));
			}
		}
		case 144/*VarArrayRedefine*/: {
			final Struct_VarArrayRedefine l1__tmp = (Struct_VarArrayRedefine)l0__tmp;
			final String l30_name = l1__tmp.f_name;
			final Struct l31_index = l1__tmp.f_index;
			final Struct l32_val = l1__tmp.f_value;
			final String l33_name = l1__tmp.f_name;
			final Struct l34_index = l1__tmp.f_index;
			final Struct l35_val = l1__tmp.f_value;
			if (!runtime.m_tree.f_containsKeyTree(avars, l33_name)) {
				return (new Struct_Pair(false, (("Variable "+l33_name)+" doesn't exists!")));
			} else {
				if ((f_isNonEmpty(l35_val)&&f_isNonEmpty(l34_index))) {
					return (new Struct_Pair(true, ""));
				} else {
					return (new Struct_Pair(false, (("Variable "+l33_name)+" and assign val haven't same types!")));
				}
			}
		}
		default: {
			return (new Struct_Pair(false, ""));
		}
		}
	 }
	}
	Struct_Triple f_checkVariblesOfCommands(Struct aop, Struct avars) {
	 TAIL_CALL: for(;;) {
		Struct l0__tmp = aop;
		switch (l0__tmp.getTypeId()) {
		case 145/*VarDefine*/: {
			final Struct_VarDefine l1__tmp = (Struct_VarDefine)l0__tmp;
			final String l2_name = l1__tmp.f_name;
			final Struct l3_type = l1__tmp.f_type;
			final Struct l4_val = l1__tmp.f_value;
			final String l5_name = l1__tmp.f_name;
			final Struct l6_type = l1__tmp.f_type;
			final Struct l7_val = l1__tmp.f_value;
			if (runtime.m_tree.f_containsKeyTree(avars, l5_name)) {
				return (new Struct_Triple(false, (("Variable "+l5_name)+" twice init!"), avars));
			} else {
				return (new Struct_Triple(true, "", ((Func3<Struct,Struct, String, Struct>)(Func3)runtime.n_setTree).invoke(avars, l5_name, l6_type)));
			}
		}
		case 146/*VarRedefine*/: {
			final Struct_VarRedefine l1__tmp = (Struct_VarRedefine)l0__tmp;
			final String l8_name = l1__tmp.f_name;
			final Struct l9_val = l1__tmp.f_value;
			final String l10_name = l1__tmp.f_name;
			final Struct l11_val = l1__tmp.f_value;
			if (!runtime.m_tree.f_containsKeyTree(avars, l10_name)) {
				return (new Struct_Triple(false, (("Variable "+l10_name)+" doesn't exists!"), avars));
			} else {
				return (new Struct_Triple(true, "", avars));
			}
		}
		case 144/*VarArrayRedefine*/: {
			final Struct_VarArrayRedefine l1__tmp = (Struct_VarArrayRedefine)l0__tmp;
			final String l12_name = l1__tmp.f_name;
			final Struct l13_index = l1__tmp.f_index;
			final Struct l14_val = l1__tmp.f_value;
			final String l15_name = l1__tmp.f_name;
			final Struct l16_index = l1__tmp.f_index;
			final Struct l17_val = l1__tmp.f_value;
			if (!runtime.m_tree.f_containsKeyTree(avars, l15_name)) {
				return (new Struct_Triple(false, (("Variable "+l15_name)+" doesn't exists!"), avars));
			} else {
				return (new Struct_Triple(true, "", avars));
			}
		}
		case 137/*Test*/: {
			final Struct_Test l1__tmp = (Struct_Test)l0__tmp;
			final String l18_t = l1__tmp.f_test;
			final Struct l19_f = l1__tmp.f_f;
			final Struct l20_s = l1__tmp.f_s;
			final String l21_t = l1__tmp.f_test;
			final Struct l22_f = l1__tmp.f_f;
			final Struct l23_s = l1__tmp.f_s;
			final Struct_Pair l24_p0 = f_checkVariablesOfTypes(l22_f, avars);
			final Struct_Pair l25_p1 = f_checkVariablesOfTypes(l23_s, avars);
			return (new Struct_Triple((((boolean)l24_p0.f_first)&&((boolean)l25_p1.f_first)), runtime.m_string.f_trim2(((((String)l24_p0.f_second)+"\n")+((String)l25_p1.f_second)), "\n"), avars));
		}
		case 122/*Print*/: {
			final Struct_Print l1__tmp = (Struct_Print)l0__tmp;
			final Struct l26_str = l1__tmp.f_data;
			final Struct l27_str = l1__tmp.f_data;
			final Struct_Pair l28_p = f_checkVariablesOfTypes(l27_str, avars);
			return (new Struct_Triple(l28_p.f_first, l28_p.f_second, avars));
		}
		case 130/*Sequence*/: {
			final Struct_Sequence l1__tmp = (Struct_Sequence)l0__tmp;
			final Struct l29_f = l1__tmp.f_f;
			final Struct l30_s = l1__tmp.f_s;
			final Struct l31_f = l1__tmp.f_f;
			final Struct l32_s = l1__tmp.f_s;
			final Struct_Triple l33_p0 = f_checkVariblesOfCommands(l31_f, avars);
			final Struct_Triple l34_p1 = f_checkVariblesOfCommands(l32_s, avars);
			final Struct l38_$36 = ((Struct)l33_p0.f_third);
			final Struct l39_$37 = ((Struct)l34_p1.f_third);
			final Func3<SingletonStruct,String, Struct, Struct> l40_$35 = new Func3<SingletonStruct,String,Struct,Struct>() {
				final public SingletonStruct invoke(final String ak0, final Struct av0, final Struct av1) {
					return SingletonStructs.str_ErrorType;
				}
			};
			final Struct l41_tree = runtime.m_tree.f_mergeTreeCustom(l38_$36, l39_$37, ((Func3<Object,Object, Object, Object>)(Func3)l40_$35));
			if (runtime.m_tree.f_containsKeyTree(l41_tree, "err0r")) {
				return (new Struct_Triple(false, "Variable redefine in sequence!", avars));
			} else {
				return (new Struct_Triple((((boolean)l33_p0.f_first)&&((boolean)l34_p1.f_first)), runtime.m_string.f_trim2(((((String)l33_p0.f_second)+"\n")+((String)l34_p1.f_second)), "\n"), avars));
			}
		}
		case 19/*Choice*/: {
			final Struct_Choice l1__tmp = (Struct_Choice)l0__tmp;
			final Struct l42_f = l1__tmp.f_f;
			final Struct l43_s = l1__tmp.f_s;
			final Struct l44_f = l1__tmp.f_f;
			final Struct l45_s = l1__tmp.f_s;
			final Struct_Triple l46_p0 = f_checkVariblesOfCommands(l44_f, avars);
			final Struct_Triple l47_p1 = f_checkVariblesOfCommands(l45_s, avars);
			final Struct l51_$49 = ((Struct)l46_p0.f_third);
			final Struct l52_$50 = ((Struct)l47_p1.f_third);
			final Func3<SingletonStruct,String, Struct, Struct> l53_$48 = new Func3<SingletonStruct,String,Struct,Struct>() {
				final public SingletonStruct invoke(final String ak0, final Struct av0, final Struct av1) {
					return SingletonStructs.str_ErrorType;
				}
			};
			final Struct l54_tree = runtime.m_tree.f_mergeTreeCustom(l51_$49, l52_$50, ((Func3<Object,Object, Object, Object>)(Func3)l53_$48));
			if (runtime.m_tree.f_containsKeyTree(l54_tree, "err0r")) {
				return (new Struct_Triple(false, "Variable redefine in choice!", avars));
			} else {
				return (new Struct_Triple((((boolean)l46_p0.f_first)&&((boolean)l47_p1.f_first)), runtime.m_string.f_trim2(((((String)l46_p0.f_second)+"\n")+((String)l47_p1.f_second)), "\n"), avars));
			}
		}
		case 64/*Loop*/: {
			final Struct_Loop l1__tmp = (Struct_Loop)l0__tmp;
			final Struct l55_f = l1__tmp.f_f;
			final Struct l56_a = l1__tmp.f_invariant;
			final Struct l57_f = l1__tmp.f_f;
			final Struct l58_a = l1__tmp.f_invariant;
			Struct l59__tmp = l58_a;
			switch (l59__tmp.getTypeId()) {
			case 69/*None*/: {
				{
					final Struct l61___tmp = l57_f;
					aop = l61___tmp;
					continue TAIL_CALL;
				}
			}
			case 133/*Some*/: {
				final Struct_Some l60__tmp = (Struct_Some)l59__tmp;
				final Object l62_ann = l60__tmp.f_value;
				final Struct_Annotation l63_ann = ((Struct_Annotation)l60__tmp.f_value);
				final Struct_Triple l64_p0 = f_checkVariblesOfCommands(l57_f, avars);
				final Struct_Pair l65_p1 = f_checkVariblesOfFormules(l63_ann.f_formule, avars);
				return (new Struct_Triple((((boolean)l64_p0.f_first)&&((boolean)l65_p1.f_first)), runtime.m_string.f_trim2(((((String)l64_p0.f_second)+"\n")+((String)l65_p1.f_second)), "\n"), avars));
			}
			default:
				throw new RuntimeException("Unexpected struct in switch: "+l59__tmp.getTypeName());
			}
		}
		case 38/*If*/: {
			final Struct_If l1__tmp = (Struct_If)l0__tmp;
			final Struct_Test l66_t = l1__tmp.f_test;
			final Struct l67_c0 = l1__tmp.f_a;
			final Struct l68_c1 = l1__tmp.f_b;
			final Struct_Test l69_t = l1__tmp.f_test;
			final Struct l70_c0 = l1__tmp.f_a;
			final Struct l71_c1 = l1__tmp.f_b;
			final Struct_Triple l72_p0 = f_checkVariblesOfCommands(l70_c0, avars);
			final Struct_Triple l73_p1 = f_checkVariblesOfCommands(l71_c1, avars);
			return (new Struct_Triple((((boolean)l72_p0.f_first)&&((boolean)l73_p1.f_first)), runtime.m_string.f_trim2(((((String)l72_p0.f_second)+"\n")+((String)l73_p1.f_second)), "\n"), avars));
		}
		case 149/*While*/: {
			final Struct_While l1__tmp = (Struct_While)l0__tmp;
			final Struct_Test l74_t = l1__tmp.f_test;
			final Struct l75_c0 = l1__tmp.f_a;
			final Struct l76_a = l1__tmp.f_invariant;
			final Struct_Test l77_t = l1__tmp.f_test;
			final Struct l78_c0 = l1__tmp.f_a;
			final Struct l79_a = l1__tmp.f_invariant;
			{
				final Struct l80___tmp = l78_c0;
				aop = l80___tmp;
				continue TAIL_CALL;
			}
		}
		case 11/*Annotation*/: {
			final Struct_Annotation l1__tmp = (Struct_Annotation)l0__tmp;
			final Struct l81_formule = l1__tmp.f_formule;
			final Struct l82_formule = l1__tmp.f_formule;
			return (new Struct_Triple(true, "", avars));
		}
		case 28/*EmptyOp*/: {
			return (new Struct_Triple(true, "", avars));
		}
		default:
			throw new RuntimeException("Unexpected struct in switch: "+l0__tmp.getTypeName());
		}
	 }
	}
	Struct_Pair f_checkVariblesOfFormules(Struct aformule, Struct avars) {
	 TAIL_CALL: for(;;) {
		Struct l0__tmp = aformule;
		switch (l0__tmp.getTypeId()) {
		case 14/*Atom*/: {
			final Struct_Atom l1__tmp = (Struct_Atom)l0__tmp;
			final String l2_t = l1__tmp.f_test;
			final Struct l3_f = l1__tmp.f_f;
			final Struct l4_s = l1__tmp.f_s;
			final String l5_t = l1__tmp.f_test;
			final Struct l6_f = l1__tmp.f_f;
			final Struct l7_s = l1__tmp.f_s;
			final Struct_Pair l8_p0 = f_checkVariablesOfLTypes(l6_f, avars);
			final Struct_Pair l9_p1 = f_checkVariablesOfLTypes(l7_s, avars);
			return (new Struct_Pair((((boolean)l8_p0.f_first)&&((boolean)l9_p1.f_first)), runtime.m_string.f_trim2(((((String)l8_p0.f_second)+"\n")+((String)l9_p1.f_second)), "\n")));
		}
		case 72/*Or*/: {
			final Struct_Or l1__tmp = (Struct_Or)l0__tmp;
			final Struct l10_f = l1__tmp.f_f;
			final Struct l11_s = l1__tmp.f_s;
			final Struct l12_f = l1__tmp.f_f;
			final Struct l13_s = l1__tmp.f_s;
			final Struct_Pair l14_p0 = f_checkVariblesOfFormules(l12_f, avars);
			final Struct_Pair l15_p1 = f_checkVariblesOfFormules(l13_s, avars);
			return (new Struct_Pair((((boolean)l14_p0.f_first)&&((boolean)l15_p1.f_first)), runtime.m_string.f_trim2(((((String)l14_p0.f_second)+"\n")+((String)l15_p1.f_second)), "\n")));
		}
		case 10/*And*/: {
			final Struct_And l1__tmp = (Struct_And)l0__tmp;
			final Struct l16_f = l1__tmp.f_f;
			final Struct l17_s = l1__tmp.f_s;
			final Struct l18_f = l1__tmp.f_f;
			final Struct l19_s = l1__tmp.f_s;
			final Struct_Pair l20_p0 = f_checkVariblesOfFormules(l18_f, avars);
			final Struct_Pair l21_p1 = f_checkVariblesOfFormules(l19_s, avars);
			return (new Struct_Pair((((boolean)l20_p0.f_first)&&((boolean)l21_p1.f_first)), runtime.m_string.f_trim2(((((String)l20_p0.f_second)+"\n")+((String)l21_p1.f_second)), "\n")));
		}
		case 67/*Neg*/: {
			final Struct_Neg l1__tmp = (Struct_Neg)l0__tmp;
			final Struct l22_f = l1__tmp.f_f;
			final Struct l23_f = l1__tmp.f_f;
			{
				final Struct l24___tmp = l23_f;
				aformule = l24___tmp;
				continue TAIL_CALL;
			}
		}
		case 40/*Implication*/: {
			final Struct_Implication l1__tmp = (Struct_Implication)l0__tmp;
			final Struct l25_f = l1__tmp.f_f;
			final Struct l26_s = l1__tmp.f_s;
			final Struct l27_f = l1__tmp.f_f;
			final Struct l28_s = l1__tmp.f_s;
			final Struct_Pair l29_p0 = f_checkVariblesOfFormules(l27_f, avars);
			final Struct_Pair l30_p1 = f_checkVariblesOfFormules(l28_s, avars);
			return (new Struct_Pair((((boolean)l29_p0.f_first)&&((boolean)l30_p1.f_first)), runtime.m_string.f_trim2(((((String)l29_p0.f_second)+"\n")+((String)l30_p1.f_second)), "\n")));
		}
		default: {
			return (new Struct_Pair(true, ""));
		}
		}
	 }
	}
	int f_getProgramDepth(Struct_ProgramSequence aps) {
		final Struct l0_gsymswitch2 = aps.f_next;
		Struct l1__tmp = l0_gsymswitch2;
		switch (l1__tmp.getTypeId()) {
		case 133/*Some*/: {
			final Struct_Some l2__tmp = (Struct_Some)l1__tmp;
			final Object l3_p = l2__tmp.f_value;
			final Struct_ProgramSequence l4_p = ((Struct_ProgramSequence)l2__tmp.f_value);
			return (f_getProgramDepth(l4_p)+1);
		}
		case 69/*None*/: {
			return 1;
		}
		default:
			throw new RuntimeException("Unexpected struct in switch: "+l1__tmp.getTypeName());
		}
	}
	boolean f_isNonEmpty(Struct at0) {
		Struct l0__tmp = at0;
		switch (l0__tmp.getTypeId()) {
		case 30/*EmptyType*/: {
			return false;
		}
		default: {
			return true;
		}
		}
	}
}
