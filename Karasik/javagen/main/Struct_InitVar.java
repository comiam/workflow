// HASH COLLISIONS: YES
// timestamp: 1.608575990794E12

package main;

import com.area9innovation.flow.*;

public class Struct_InitVar extends Struct {
	public String f_v;
	public Struct f_e;
	public int f_goto;

	public Struct_InitVar() {}
	public Struct_InitVar(String a_v, Struct a_e, int a_goto) {
		f_v = a_v;
		f_e = a_e;
		f_goto = a_goto;
	}

	public int getTypeId() { return 42; }
	public String getTypeName() { return "InitVar"; }

	private static final String[] field_names = new String[] {
		"v", "e", "goto"
	};
	private static final RuntimeType[] field_types = new RuntimeType[] {
		RuntimeType.STRING, RuntimeType.STRUCT, RuntimeType.INT
	};
	public String[] getFieldNames() { return field_names; }
	public RuntimeType[] getFieldTypes() { return field_types; }

	public Object[] getFields() {
		return new Object[] {
			f_v, f_e, f_goto
		};
	}
	@SuppressWarnings("unchecked")
	public void setFields(Object[] values) {
		if (values.length != 3)
			throw new IndexOutOfBoundsException("Invalid field count in InitVar");
		f_v = (String)values[0];
		f_e = (Struct)values[1];
		f_goto = (Integer)values[2];
	}

	public int compareTo(Struct other_gen) {
		if (other_gen == this) return 0;
		int tmp = other_gen.getTypeId();
		if (tmp != 42) return 42-tmp;
		Struct_InitVar other = (Struct_InitVar)other_gen;
		tmp = f_v.compareTo(other.f_v);
		if (tmp != 0) return tmp;
		tmp = f_e.compareTo(other.f_e);
		if (tmp != 0) return tmp;
		if (f_goto != other.f_goto)
			return (f_goto > other.f_goto) ? 1 : -1;
		return 0;
	}
}
