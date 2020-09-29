// HASH COLLISIONS: YES
// timestamp: 1.60136919E12

package main;

import com.area9innovation.flow.*;

@SuppressWarnings("unchecked")
final class Module_var_parse {
	final main runtime;
	Module_var_parse(main runtime) {
		this.runtime = runtime;
	}
	Struct f_fillTree(Struct avars, Struct atree) {
	 TAIL_CALL: for(;;) {
		Struct l0__tmp = avars;
		switch (l0__tmp.getTypeId()) {
		case 41/*None*/: {
			return atree;
		}
		case 104/*Some*/: {
			final Struct_Some l1__tmp = (Struct_Some)l0__tmp;
			final Object l2_value = l1__tmp.f_value;
			final Struct l3_value = ((Struct)l1__tmp.f_value);
			Struct l4__tmp = l3_value;
			switch (l4__tmp.getTypeId()) {
			case 110/*VarPair*/: {
				final Struct_VarPair l5__tmp = (Struct_VarPair)l4__tmp;
				final Struct l6_first = l5__tmp.f_first;
				final Struct l7_second = l5__tmp.f_second;
				final Struct l8_first = l5__tmp.f_first;
				final Struct l9_second = l5__tmp.f_second;
				final Struct_VarVal l10_a = ((Struct_VarVal)runtime.m_maybe.f_either(l8_first, (new Struct_VarVal("", (-1)))));
				{
					final Struct l11___tmp = l5__tmp.f_second;
					final Struct l12___tmp = ((Func3<Struct,Struct, String, Integer>)(Func3)runtime.n_setTree).invoke(atree, l10_a.f_name, ((Integer)l10_a.f_val));
					avars = l11___tmp;
					atree = l12___tmp;
					continue TAIL_CALL;
				}
			}
			case 111/*VarVal*/: {
				final Struct_VarVal l5__tmp = (Struct_VarVal)l4__tmp;
				final String l13_name = l5__tmp.f_name;
				final int l14_val = l5__tmp.f_val;
				final String l15_name = l5__tmp.f_name;
				final int l16_val = l5__tmp.f_val;
				return ((Func3<Struct,Struct, String, Integer>)(Func3)runtime.n_setTree).invoke(atree, l15_name, ((Integer)l16_val));
			}
			default:
				throw new RuntimeException("Unexpected struct in switch: "+l4__tmp.getTypeName());
			}
		}
		default:
			throw new RuntimeException("Unexpected struct in switch: "+l0__tmp.getTypeName());
		}
	 }
	}
	Struct f_s2vars(String as) {
		final String l0_gram = "S = pair | var | empty;\nws = (\" \" | \"\\t\" | \"\\n\" | \"\\r\")*;\nempWs = (\" \" | \"\\t\" | \"\\r\")*;\n\npair = ws var:v ws \";\" ws S:r ws      {Some(VarPair(:v, :r))};\nvar = ws word$d ws '=' ws digit+$s ws {Some(VarVal($d, s2i($s)))};\n\nempty = empWs \"\\n\" \t\t\t\t\t  {None()};\nword = ('a'-'z')+ digit*;\ndigit = '0'-'9';";
		final Object l1_vars = runtime.m_driver.f_parsic(runtime.m_driver.f_compilePegGrammar(l0_gram), as, runtime.m_pegaction.g_defaultPegActions);
		final Struct l2_tr = runtime.m_tree.f_makeTree();
		if (runtime.m_maybe.f_isNone(((Struct)l1_vars))) {
			return l2_tr;
		} else {
			return f_fillTree(((Struct)l1_vars), l2_tr);
		}
	}
}
