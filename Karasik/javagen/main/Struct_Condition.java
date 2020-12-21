// HASH COLLISIONS: YES
// timestamp: 1.608575990792E12

package main;

import com.area9innovation.flow.*;

public class Struct_Condition extends Struct {
	public String f_test;
	public Struct f_expr0;
	public Struct f_expr1;
	public Object[] f_gotoTrue;
	public Object[] f_gotoFalse;

	public Struct_Condition() {}
	public Struct_Condition(String a_test, Struct a_expr0, Struct a_expr1, Object[] a_gotoTrue, Object[] a_gotoFalse) {
		f_test = a_test;
		f_expr0 = a_expr0;
		f_expr1 = a_expr1;
		f_gotoTrue = a_gotoTrue;
		f_gotoFalse = a_gotoFalse;
	}

	public int getTypeId() { return 21; }
	public String getTypeName() { return "Condition"; }

	private static final String[] field_names = new String[] {
		"test", "expr0", "expr1", "gotoTrue", "gotoFalse"
	};
	private static final RuntimeType[] field_types = new RuntimeType[] {
		RuntimeType.STRING, RuntimeType.STRUCT, RuntimeType.STRUCT, RuntimeType.ARRAY, RuntimeType.ARRAY
	};
	public String[] getFieldNames() { return field_names; }
	public RuntimeType[] getFieldTypes() { return field_types; }

	public Object[] getFields() {
		return new Object[] {
			f_test, f_expr0, f_expr1, f_gotoTrue, f_gotoFalse
		};
	}
	@SuppressWarnings("unchecked")
	public void setFields(Object[] values) {
		if (values.length != 5)
			throw new IndexOutOfBoundsException("Invalid field count in Condition");
		f_test = (String)values[0];
		f_expr0 = (Struct)values[1];
		f_expr1 = (Struct)values[2];
		f_gotoTrue = (Object[])values[3];
		f_gotoFalse = (Object[])values[4];
	}

	public int compareTo(Struct other_gen) {
		if (other_gen == this) return 0;
		int tmp = other_gen.getTypeId();
		if (tmp != 21) return 21-tmp;
		Struct_Condition other = (Struct_Condition)other_gen;
		tmp = f_test.compareTo(other.f_test);
		if (tmp != 0) return tmp;
		tmp = f_expr0.compareTo(other.f_expr0);
		if (tmp != 0) return tmp;
		tmp = f_expr1.compareTo(other.f_expr1);
		if (tmp != 0) return tmp;
		tmp = FlowRuntime.compareByValue(f_gotoTrue, other.f_gotoTrue);
		if (tmp != 0) return tmp;
		tmp = FlowRuntime.compareByValue(f_gotoFalse, other.f_gotoFalse);
		return tmp;
	}
}
