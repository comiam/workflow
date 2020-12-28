// HASH COLLISIONS: YES
// timestamp: 1.609183283E12

package main;

import com.area9innovation.flow.*;

@SuppressWarnings("unchecked")
final class Module_formule_compiler {
	final main runtime;
	Module_formule_compiler(main runtime) {
		this.runtime = runtime;
	}
	String f_declToZ3(Struct_VarDefine adecl) {
		return (((("(declare-const "+adecl.f_name)+" ")+f_type2Z3(adecl.f_type))+")");
	}
	Struct_Annotation f_emptyAnnotation() {
		return (new Struct_Annotation((new Struct_Atom("==", (new Struct_LVariable("var")), (new Struct_LVariable("var2"))))));
	}
	Struct_ProgramSequence f_emptyPS() {
		return (new Struct_ProgramSequence(((Struct)SingletonStructs.str_EmptyOp), ((Struct)SingletonStructs.str_None)));
	}
	Object[] f_extractDecl(Struct_ProgramSequence ap) {
		final Struct l0_p1 = ap.f_op;
		if (runtime.m_maybe.f_isNone(ap.f_next)) {
			return f_getDecl(l0_p1);
		} else {
			return runtime.h_Native.concat(f_getDecl(l0_p1), f_extractDecl(f_getNextOp(ap)));
		}
	}
	String f_formuleToZ3(Struct af) {
		Struct l0__tmp = af;
		switch (l0__tmp.getTypeId()) {
		case 14/*Atom*/: {
			final Struct_Atom l1__tmp = (Struct_Atom)l0__tmp;
			final String l2_test = l1__tmp.f_test;
			final Struct l3_f1 = l1__tmp.f_f;
			final Struct l4_s = l1__tmp.f_s;
			final String l5_test = l1__tmp.f_test;
			final Struct l6_f1 = l1__tmp.f_f;
			final Struct l7_s = l1__tmp.f_s;
			if ((l5_test).equals("!=")) {
				return (((("(not (= "+f_lt2z3(l6_f1))+" ")+f_lt2z3(l7_s))+"))");
			} else {
				if ((l5_test).equals("==")) {
					return (((("(= "+f_lt2z3(l6_f1))+" ")+f_lt2z3(l7_s))+")");
				} else {
					return (((((("("+l5_test)+" ")+f_lt2z3(l6_f1))+" ")+f_lt2z3(l7_s))+")");
				}
			}
		}
		case 26/*EmptyAtom*/: {
			return "";
		}
		case 72/*Or*/: {
			final Struct_Or l1__tmp = (Struct_Or)l0__tmp;
			final Struct l8_f1 = l1__tmp.f_f;
			final Struct l9_s = l1__tmp.f_s;
			final Struct l10_f1 = l1__tmp.f_f;
			final Struct l11_s = l1__tmp.f_s;
			return (((("(or "+f_formuleToZ3(l10_f1))+" ")+f_formuleToZ3(l11_s))+")");
		}
		case 10/*And*/: {
			final Struct_And l1__tmp = (Struct_And)l0__tmp;
			final Struct l12_f1 = l1__tmp.f_f;
			final Struct l13_s = l1__tmp.f_s;
			final Struct l14_f1 = l1__tmp.f_f;
			final Struct l15_s = l1__tmp.f_s;
			return (((("(and "+f_formuleToZ3(l14_f1))+" ")+f_formuleToZ3(l15_s))+")");
		}
		case 67/*Neg*/: {
			final Struct_Neg l1__tmp = (Struct_Neg)l0__tmp;
			final Struct l16_f1 = l1__tmp.f_f;
			final Struct l17_f1 = l1__tmp.f_f;
			return (("(not "+f_formuleToZ3(l17_f1))+")");
		}
		case 40/*Implication*/: {
			final Struct_Implication l1__tmp = (Struct_Implication)l0__tmp;
			final Struct l18_f1 = l1__tmp.f_f;
			final Struct l19_s = l1__tmp.f_s;
			final Struct l20_f1 = l1__tmp.f_f;
			final Struct l21_s = l1__tmp.f_s;
			return (((("(=> "+f_formuleToZ3(l20_f1))+" ")+f_formuleToZ3(l21_s))+")");
		}
		case 9/*AllQuantor*/: {
			final Struct_AllQuantor l1__tmp = (Struct_AllQuantor)l0__tmp;
			final String l22_var = l1__tmp.f_var;
			final Struct l23_f1 = l1__tmp.f_f;
			final String l24_var = l1__tmp.f_var;
			final Struct l25_f1 = l1__tmp.f_f;
			return (((("(forall (("+l24_var)+" Int)) ")+f_formuleToZ3(l25_f1))+")");
		}
		case 33/*ExiQuantor*/: {
			final Struct_ExiQuantor l1__tmp = (Struct_ExiQuantor)l0__tmp;
			final String l26_var = l1__tmp.f_var;
			final Struct l27_f1 = l1__tmp.f_f;
			final String l28_var = l1__tmp.f_var;
			final Struct l29_f1 = l1__tmp.f_f;
			return (((("(exists (("+l28_var)+" Int)) ")+f_formuleToZ3(l29_f1))+")");
		}
		default:
			throw new RuntimeException("Unexpected struct in switch: "+l0__tmp.getTypeName());
		}
	}
	Struct f_foundPostCond(Struct_ProgramSequence ap) {
	 TAIL_CALL: for(;;) {
		if (!runtime.h_Native.isSameStructType(ap.f_op, f_emptyAnnotation())) {
			{
				final Struct_ProgramSequence l0___tmp = f_getNextPS(ap);
				ap = l0___tmp;
				continue TAIL_CALL;
			}
		} else {
			return ((Struct_Annotation)ap.f_op).f_formule;
		}
	 }
	}
	Struct f_generateAC(Struct_ProgramSequence ap, Struct apostCond) {
		final Struct l0_p1 = ap.f_op;
		final Struct_ProgramSequence l1_p2 = f_getNextOp(ap);
		if (runtime.m_maybe.f_isNone(ap.f_next)) {
			return f_operationToAC(l0_p1, apostCond);
		} else {
			return f_operationToAC(l0_p1, f_generateAC(l1_p2, apostCond));
		}
	}
	Object[] f_generateVC(Struct_ProgramSequence ap, Struct apostCond) {
		final Struct l0_p1 = ap.f_op;
		final Struct_ProgramSequence l1_p2 = f_getNextOp(ap);
		if (runtime.m_maybe.f_isNone(ap.f_next)) {
			return f_operationToVC(l0_p1, apostCond);
		} else {
			return runtime.h_Native.concat(f_operationToVC(l0_p1, f_generateAC(l1_p2, apostCond)), f_generateVC(l1_p2, apostCond));
		}
	}
	String f_generateZ3(Struct_ProgramSequence aps) {
		final Object[] l0_formules = f_getACVCConditions(aps);
		if (((Object[])l0_formules).length == 0) {
			return "";
		} else {
			return f_translateToZ3(aps, l0_formules);
		}
	}
	Object[] f_getACVCConditions(Struct_ProgramSequence aps) {
		final Struct_Pair l0_p = runtime.m_validator.f_checkStructure(aps);
		if (!((boolean)l0_p.f_first)) {
			runtime.m_runtime.f_println(l0_p.f_second);
			return SingletonStructs.arr_empty;
		} else {
			if (!runtime.h_Native.isSameStructType(aps.f_op, f_emptyAnnotation())) {
				runtime.m_runtime.f_println("Program not annotated!");
				return SingletonStructs.arr_empty;
			} else {
				final Struct l1_f0 = ((Struct_Annotation)aps.f_op).f_formule;
				final Struct l2_f1 = f_foundPostCond(f_getNextPS(aps));
				final Struct l3_ac = f_generateAC(f_getNextPS(aps), l2_f1);
				final Object[] l4_vc = f_generateVC(f_getNextPS(aps), l2_f1);
				return runtime.h_Native.concat(l4_vc, (new Object[] { (new Struct_Implication(l1_f0, l3_ac)) }));
			}
		}
	}
	Object[] f_getDecl(Struct aop) {
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
			return (new Object[] { l1__tmp });
		}
		default: {
			return SingletonStructs.arr_empty;
		}
		}
	}
	Struct f_getInv(Struct ai) {
		return ((Struct_Annotation)runtime.m_maybe.f_either(ai, f_emptyAnnotation())).f_formule;
	}
	Struct_ProgramSequence f_getNextOp(Struct_ProgramSequence ap) {
		final Struct l0_gsymswitch0 = ap.f_next;
		Struct l1__tmp = l0_gsymswitch0;
		switch (l1__tmp.getTypeId()) {
		case 133/*Some*/: {
			final Struct_Some l2__tmp = (Struct_Some)l1__tmp;
			final Object l3_val = l2__tmp.f_value;
			final Struct_ProgramSequence l4_val = ((Struct_ProgramSequence)l2__tmp.f_value);
			return l4_val;
		}
		case 69/*None*/: {
			return f_emptyPS();
		}
		default:
			throw new RuntimeException("Unexpected struct in switch: "+l1__tmp.getTypeName());
		}
	}
	Struct_ProgramSequence f_getNextPS(Struct_ProgramSequence ap) {
		return ((Struct_ProgramSequence)runtime.m_maybe.f_either(ap.f_next, f_emptyPS()));
	}
	String f_lt2z3(Struct alt) {
		Struct l0__tmp = alt;
		switch (l0__tmp.getTypeId()) {
		case 60/*LVariable*/: {
			final Struct_LVariable l1__tmp = (Struct_LVariable)l0__tmp;
			final String l2_name = l1__tmp.f_name;
			final String l3_name = l1__tmp.f_name;
			return l3_name;
		}
		case 58/*LInt*/: {
			final Struct_LInt l1__tmp = (Struct_LInt)l0__tmp;
			final int l4_v = l1__tmp.f_v;
			final int l5_v = l1__tmp.f_v;
			return runtime.m_string.f_i2s(l5_v);
		}
		case 57/*LBinOp*/: {
			final Struct_LBinOp l1__tmp = (Struct_LBinOp)l0__tmp;
			final String l6_op = l1__tmp.f_op;
			final Struct l7_f = l1__tmp.f_f;
			final Struct l8_s = l1__tmp.f_s;
			final String l9_op = l1__tmp.f_op;
			final Struct l10_f = l1__tmp.f_f;
			final Struct l11_s = l1__tmp.f_s;
			return (((((("("+l9_op)+" ")+f_lt2z3(l10_f))+" ")+f_lt2z3(l11_s))+")");
		}
		case 56/*LAccessArray*/: {
			final Struct_LAccessArray l1__tmp = (Struct_LAccessArray)l0__tmp;
			final Struct l12_name = l1__tmp.f_name;
			final Struct l13_index = l1__tmp.f_index;
			final Struct l14_name = l1__tmp.f_name;
			final Struct l15_index = l1__tmp.f_index;
			return (((("(select "+f_lt2z3(l14_name))+" ")+f_lt2z3(l15_index))+")");
		}
		case 59/*LRedefineArray*/: {
			final Struct_LRedefineArray l1__tmp = (Struct_LRedefineArray)l0__tmp;
			final Struct l16_name = l1__tmp.f_name;
			final Struct l17_index = l1__tmp.f_index;
			final Struct l18_value = l1__tmp.f_value;
			final Struct l19_name = l1__tmp.f_name;
			final Struct l20_index = l1__tmp.f_index;
			final Struct l21_value = l1__tmp.f_value;
			return (((((("(store "+f_lt2z3(l19_name))+" ")+f_lt2z3(l20_index))+" ")+f_lt2z3(l20_index))+")");
		}
		default:
			throw new RuntimeException("Unexpected struct in switch: "+l0__tmp.getTypeName());
		}
	}
	Struct f_operationToAC(Struct aop, Struct apostCond) {
	 TAIL_CALL: for(;;) {
		Struct l0__tmp = aop;
		switch (l0__tmp.getTypeId()) {
		case 38/*If*/: {
			final Struct_If l1__tmp = (Struct_If)l0__tmp;
			final Struct_Test l2_t = l1__tmp.f_test;
			final Struct l3_f = l1__tmp.f_a;
			final Struct l4_s = l1__tmp.f_b;
			final Struct_Test l5_t = l1__tmp.f_test;
			final Struct l6_f = l1__tmp.f_a;
			final Struct l7_s = l1__tmp.f_b;
			{
				final Struct l8___tmp = (new Struct_Choice((new Struct_Sequence(l5_t, l6_f)), (new Struct_Sequence(runtime.m_types.f_invertTest(l5_t), l7_s))));
				aop = l8___tmp;
				continue TAIL_CALL;
			}
		}
		case 149/*While*/: {
			final Struct_While l1__tmp = (Struct_While)l0__tmp;
			final Struct_Test l9_test = l1__tmp.f_test;
			final Struct l10_a = l1__tmp.f_a;
			final Struct l11_invariant = l1__tmp.f_invariant;
			final Struct_Test l12_test = l1__tmp.f_test;
			final Struct l13_a = l1__tmp.f_a;
			final Struct l14_invariant = l1__tmp.f_invariant;
			return f_getInv(l14_invariant);
		}
		case 137/*Test*/: {
			final Struct_Test l1__tmp = (Struct_Test)l0__tmp;
			final String l15_test = l1__tmp.f_test;
			final Struct l16_f = l1__tmp.f_f;
			final Struct l17_s = l1__tmp.f_s;
			final String l18_test = l1__tmp.f_test;
			final Struct l19_f = l1__tmp.f_f;
			final Struct l20_s = l1__tmp.f_s;
			return (new Struct_Implication((new Struct_Atom(l18_test, f_tv2ltv(l19_f), f_tv2ltv(l20_s))), apostCond));
		}
		case 130/*Sequence*/: {
			final Struct_Sequence l1__tmp = (Struct_Sequence)l0__tmp;
			final Struct l21_f = l1__tmp.f_f;
			final Struct l22_s = l1__tmp.f_s;
			final Struct l23_f = l1__tmp.f_f;
			final Struct l24_s = l1__tmp.f_s;
			{
				final Struct l25___tmp = l23_f;
				final Struct l26___tmp = f_operationToAC(l24_s, apostCond);
				aop = l25___tmp;
				apostCond = l26___tmp;
				continue TAIL_CALL;
			}
		}
		case 19/*Choice*/: {
			final Struct_Choice l1__tmp = (Struct_Choice)l0__tmp;
			final Struct l27_f = l1__tmp.f_f;
			final Struct l28_s = l1__tmp.f_s;
			final Struct l29_f = l1__tmp.f_f;
			final Struct l30_s = l1__tmp.f_s;
			return (new Struct_And(f_operationToAC(l29_f, apostCond), f_operationToAC(l30_s, apostCond)));
		}
		case 64/*Loop*/: {
			final Struct_Loop l1__tmp = (Struct_Loop)l0__tmp;
			final Struct l31_f = l1__tmp.f_f;
			final Struct l32_invariant = l1__tmp.f_invariant;
			final Struct l33_f = l1__tmp.f_f;
			final Struct l34_invariant = l1__tmp.f_invariant;
			return f_getInv(l34_invariant);
		}
		case 146/*VarRedefine*/: {
			final Struct_VarRedefine l1__tmp = (Struct_VarRedefine)l0__tmp;
			final String l35_name = l1__tmp.f_name;
			final Struct l36_value = l1__tmp.f_value;
			final String l37_name = l1__tmp.f_name;
			final Struct l38_value = l1__tmp.f_value;
			return f_replaceFormules(apostCond, (new Struct_LVariable(l37_name)), f_tv2ltv(l38_value));
		}
		case 144/*VarArrayRedefine*/: {
			final Struct_VarArrayRedefine l1__tmp = (Struct_VarArrayRedefine)l0__tmp;
			final String l39_name = l1__tmp.f_name;
			final Struct l40_index = l1__tmp.f_index;
			final Struct l41_value = l1__tmp.f_value;
			final String l42_name = l1__tmp.f_name;
			final Struct l43_index = l1__tmp.f_index;
			final Struct l44_value = l1__tmp.f_value;
			return f_replaceFormules(apostCond, (new Struct_LVariable(l42_name)), (new Struct_LRedefineArray((new Struct_LVariable(l42_name)), f_tv2ltv(l43_index), f_tv2ltv(l44_value))));
		}
		default: {
			return apostCond;
		}
		}
	 }
	}
	Object[] f_operationToVC(Struct aop, Struct apostCond) {
	 TAIL_CALL: for(;;) {
		Struct l0__tmp = aop;
		switch (l0__tmp.getTypeId()) {
		case 38/*If*/: {
			final Struct_If l1__tmp = (Struct_If)l0__tmp;
			final Struct_Test l2_t = l1__tmp.f_test;
			final Struct l3_f = l1__tmp.f_a;
			final Struct l4_s = l1__tmp.f_b;
			final Struct_Test l5_t = l1__tmp.f_test;
			final Struct l6_f = l1__tmp.f_a;
			final Struct l7_s = l1__tmp.f_b;
			return runtime.h_Native.concat(f_operationToVC(l6_f, apostCond), f_operationToVC(l7_s, apostCond));
		}
		case 149/*While*/: {
			final Struct_While l1__tmp = (Struct_While)l0__tmp;
			final Struct_Test l8_t = l1__tmp.f_test;
			final Struct l9_a = l1__tmp.f_a;
			final Struct l10_invariant = l1__tmp.f_invariant;
			final Struct_Test l11_t = l1__tmp.f_test;
			final Struct l12_a = l1__tmp.f_a;
			final Struct l13_invariant = l1__tmp.f_invariant;
			{
				final Struct l14___tmp = (new Struct_Sequence((new Struct_Loop((new Struct_Sequence(l11_t, l12_a)), l13_invariant)), runtime.m_types.f_invertTest(l11_t)));
				aop = l14___tmp;
				continue TAIL_CALL;
			}
		}
		case 130/*Sequence*/: {
			final Struct_Sequence l1__tmp = (Struct_Sequence)l0__tmp;
			final Struct l15_f = l1__tmp.f_f;
			final Struct l16_s = l1__tmp.f_s;
			final Struct l17_f = l1__tmp.f_f;
			final Struct l18_s = l1__tmp.f_s;
			return runtime.h_Native.concat(f_operationToVC(l17_f, f_operationToAC(l18_s, apostCond)), f_operationToVC(l18_s, apostCond));
		}
		case 19/*Choice*/: {
			final Struct_Choice l1__tmp = (Struct_Choice)l0__tmp;
			final Struct l19_f = l1__tmp.f_f;
			final Struct l20_s = l1__tmp.f_s;
			final Struct l21_f = l1__tmp.f_f;
			final Struct l22_s = l1__tmp.f_s;
			return runtime.h_Native.concat(f_operationToVC(l21_f, apostCond), f_operationToVC(l22_s, apostCond));
		}
		case 64/*Loop*/: {
			final Struct_Loop l1__tmp = (Struct_Loop)l0__tmp;
			final Struct l23_f = l1__tmp.f_f;
			final Struct l24_invariant = l1__tmp.f_invariant;
			final Struct l25_f = l1__tmp.f_f;
			final Struct l26_invariant = l1__tmp.f_invariant;
			return runtime.h_Native.concat(f_operationToVC(l25_f, f_getInv(l26_invariant)), (new Object[] { (new Struct_Implication(f_getInv(l26_invariant), apostCond)) }));
		}
		default: {
			return SingletonStructs.arr_empty;
		}
		}
	 }
	}
	String f_proveConditions(Object[] aformules) {
		final Func2<String,Integer, Struct> l3_$0 = new Func2<String,Integer,Struct>() {
			final public String invoke(final Integer ai, final Struct af) {
				final String l0_name = ("cond"+runtime.m_string.f_i2s(((int)ai)));
				return (((((((("(push)\n"+"(define-fun ")+l0_name)+"() Bool ")+f_formuleToZ3(af))+")\n")+"(assert (not ")+l0_name)+"))\n");
			}
		};
		final String l4_$2 = runtime.m_string.f_strGlue(runtime.h_Native.mapi(aformules, ((Func2<Object,Integer, Object>)(Func2)l3_$0)), "\n");
		final Func2<String,Integer, Struct> l5_$1 = new Func2<String,Integer,Struct>() {
			final public String invoke(final Integer ai, final Struct af) {
				return ("(check-sat)\n"+"(pop)");
			}
		};
		return (l4_$2+runtime.m_string.f_strGlue(runtime.h_Native.mapi(aformules, ((Func2<Object,Integer, Object>)(Func2)l5_$1)), "\n"));
	}
	Struct f_replaceFormules(Struct af, Struct aoldSt, Struct anewSt) {
		Struct l0__tmp = af;
		switch (l0__tmp.getTypeId()) {
		case 14/*Atom*/: {
			final Struct_Atom l1__tmp = (Struct_Atom)l0__tmp;
			final String l2_test = l1__tmp.f_test;
			final Struct l3_f1 = l1__tmp.f_f;
			final Struct l4_s = l1__tmp.f_s;
			final String l5_test = l1__tmp.f_test;
			final Struct l6_f1 = l1__tmp.f_f;
			final Struct l7_s = l1__tmp.f_s;
			return (new Struct_Atom(l5_test, f_replaceInLTypes(l6_f1, aoldSt, anewSt), f_replaceInLTypes(l7_s, aoldSt, anewSt)));
		}
		case 26/*EmptyAtom*/: {
			return ((Struct)SingletonStructs.str_EmptyAtom);
		}
		case 72/*Or*/: {
			final Struct_Or l1__tmp = (Struct_Or)l0__tmp;
			final Struct l8_f1 = l1__tmp.f_f;
			final Struct l9_s = l1__tmp.f_s;
			final Struct l10_f1 = l1__tmp.f_f;
			final Struct l11_s = l1__tmp.f_s;
			return (new Struct_Or(f_replaceFormules(l10_f1, aoldSt, anewSt), f_replaceFormules(l11_s, aoldSt, anewSt)));
		}
		case 10/*And*/: {
			final Struct_And l1__tmp = (Struct_And)l0__tmp;
			final Struct l12_f1 = l1__tmp.f_f;
			final Struct l13_s = l1__tmp.f_s;
			final Struct l14_f1 = l1__tmp.f_f;
			final Struct l15_s = l1__tmp.f_s;
			return (new Struct_And(f_replaceFormules(l14_f1, aoldSt, anewSt), f_replaceFormules(l15_s, aoldSt, anewSt)));
		}
		case 67/*Neg*/: {
			final Struct_Neg l1__tmp = (Struct_Neg)l0__tmp;
			final Struct l16_f1 = l1__tmp.f_f;
			final Struct l17_f1 = l1__tmp.f_f;
			return (new Struct_Neg(f_replaceFormules(l17_f1, aoldSt, anewSt)));
		}
		case 40/*Implication*/: {
			final Struct_Implication l1__tmp = (Struct_Implication)l0__tmp;
			final Struct l18_f1 = l1__tmp.f_f;
			final Struct l19_s = l1__tmp.f_s;
			final Struct l20_f1 = l1__tmp.f_f;
			final Struct l21_s = l1__tmp.f_s;
			return (new Struct_Implication(f_replaceFormules(l20_f1, aoldSt, anewSt), f_replaceFormules(l21_s, aoldSt, anewSt)));
		}
		case 9/*AllQuantor*/: {
			final Struct_AllQuantor l1__tmp = (Struct_AllQuantor)l0__tmp;
			final String l22_var = l1__tmp.f_var;
			final Struct l23_f1 = l1__tmp.f_f;
			final String l24_var = l1__tmp.f_var;
			final Struct l25_f1 = l1__tmp.f_f;
			return (new Struct_AllQuantor(l24_var, f_replaceFormules(l25_f1, aoldSt, anewSt)));
		}
		case 33/*ExiQuantor*/: {
			final Struct_ExiQuantor l1__tmp = (Struct_ExiQuantor)l0__tmp;
			final String l26_var = l1__tmp.f_var;
			final Struct l27_f1 = l1__tmp.f_f;
			final String l28_var = l1__tmp.f_var;
			final Struct l29_f1 = l1__tmp.f_f;
			return (new Struct_ExiQuantor(l28_var, f_replaceFormules(l29_f1, aoldSt, anewSt)));
		}
		default:
			throw new RuntimeException("Unexpected struct in switch: "+l0__tmp.getTypeName());
		}
	}
	Struct f_replaceInLTypes(Struct acurrent, Struct aold, Struct anew) {
		if (FlowRuntime.compareEqual(aold,acurrent)) {
			return anew;
		} else {
			Struct l0__tmp = acurrent;
			switch (l0__tmp.getTypeId()) {
			case 57/*LBinOp*/: {
				final Struct_LBinOp l1__tmp = (Struct_LBinOp)l0__tmp;
				final String l2_op = l1__tmp.f_op;
				final Struct l3_f = l1__tmp.f_f;
				final Struct l4_s = l1__tmp.f_s;
				final String l5_op = l1__tmp.f_op;
				final Struct l6_f = l1__tmp.f_f;
				final Struct l7_s = l1__tmp.f_s;
				return (new Struct_LBinOp(l5_op, f_replaceInLTypes(l6_f, aold, anew), f_replaceInLTypes(l7_s, aold, anew)));
			}
			case 56/*LAccessArray*/: {
				final Struct_LAccessArray l1__tmp = (Struct_LAccessArray)l0__tmp;
				final Struct l8_name = l1__tmp.f_name;
				final Struct l9_index = l1__tmp.f_index;
				final Struct l10_name = l1__tmp.f_name;
				final Struct l11_index = l1__tmp.f_index;
				return (new Struct_LAccessArray(f_replaceInLTypes(l10_name, aold, anew), f_replaceInLTypes(l11_index, aold, anew)));
			}
			default: {
				return acurrent;
			}
			}
		}
	}
	String f_translateToZ3(Struct_ProgramSequence ap, Object[] aformules) {
		return ((runtime.m_string.f_strGlue(runtime.h_Native.map(f_extractDecl(ap), ((Func1<Object,Object>)(Func1)runtime.gfw_declToZ3)), "\n")+"\n")+f_proveConditions(aformules));
	}
	Struct f_tv2ltv(Struct atv) {
	 TAIL_CALL: for(;;) {
		Struct l0__tmp = atv;
		switch (l0__tmp.getTypeId()) {
		case 43/*Int*/: {
			final Struct_Int l1__tmp = (Struct_Int)l0__tmp;
			final int l2_val = l1__tmp.f_v;
			final int l3_val = l1__tmp.f_v;
			return (new Struct_LInt(l3_val));
		}
		case 147/*Variable*/: {
			final Struct_Variable l1__tmp = (Struct_Variable)l0__tmp;
			final String l4_var = l1__tmp.f_name;
			final String l5_var = l1__tmp.f_name;
			return (new Struct_LVariable(l5_var));
		}
		case 15/*BinOp*/: {
			final Struct_BinOp l1__tmp = (Struct_BinOp)l0__tmp;
			final String l6_op = l1__tmp.f_op;
			final Struct l7_f = l1__tmp.f_f;
			final Struct l8_s = l1__tmp.f_s;
			final String l9_op = l1__tmp.f_op;
			final Struct l10_f = l1__tmp.f_f;
			final Struct l11_s = l1__tmp.f_s;
			final Struct l12_t0 = f_tv2ltv(l10_f);
			final Struct l13_t1 = f_tv2ltv(l11_s);
			return (new Struct_LBinOp(l9_op, l12_t0, l13_t1));
		}
		case 141/*UnOp*/: {
			final Struct_UnOp l1__tmp = (Struct_UnOp)l0__tmp;
			final String l14_op = l1__tmp.f_op;
			final Struct l15_f = l1__tmp.f_u;
			final String l16_op = l1__tmp.f_op;
			final Struct l17_f = l1__tmp.f_u;
			if ((l16_op).equals("--")) {
				{
					final Struct l18___tmp = (new Struct_BinOp("-", l17_f, (new Struct_Int(1))));
					atv = l18___tmp;
					continue TAIL_CALL;
				}
			} else {
				{
					final Struct l19___tmp = (new Struct_BinOp("+", l17_f, (new Struct_Int(1))));
					atv = l19___tmp;
					continue TAIL_CALL;
				}
			}
		}
		case 13/*ArrayAccess*/: {
			final Struct_ArrayAccess l1__tmp = (Struct_ArrayAccess)l0__tmp;
			final Struct_Variable l20_name = l1__tmp.f_var;
			final Struct l21_index = l1__tmp.f_ind;
			final Struct_Variable l22_name = l1__tmp.f_var;
			final Struct l23_index = l1__tmp.f_ind;
			return (new Struct_LAccessArray((new Struct_LVariable(l22_name.f_name)), f_tv2ltv(l23_index)));
		}
		default: {
			return (new Struct_LInt(0));
		}
		}
	 }
	}
	String f_type2Z3(Struct atype) {
		Struct l0__tmp = atype;
		switch (l0__tmp.getTypeId()) {
		case 12/*Array*/: {
			final Struct_Array l1__tmp = (Struct_Array)l0__tmp;
			final int l2_s = l1__tmp.f_size;
			final int l3_s = l1__tmp.f_size;
			return "(Array Int Int)";
		}
		case 43/*Int*/: {
			final Struct_Int l1__tmp = (Struct_Int)l0__tmp;
			final int l4_v = l1__tmp.f_v;
			final int l5_v = l1__tmp.f_v;
			return "Int";
		}
		default: {
			return "";
		}
		}
	}
}
