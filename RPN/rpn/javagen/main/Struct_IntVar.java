// HASH COLLISIONS: YES
// timestamp: 1.601710122753E12

package main;

import com.area9innovation.flow.*;

public class Struct_IntVar extends Struct {
	public int f_l;
	public String f_r;

	public Struct_IntVar() {}
	public Struct_IntVar(int a_l, String a_r) {
		f_l = a_l;
		f_r = a_r;
	}

	public int getTypeId() { return 36; }
	public String getTypeName() { return "IntVar"; }

	private static final String[] field_names = new String[] {
		"l", "r"
	};
	private static final RuntimeType[] field_types = new RuntimeType[] {
		RuntimeType.INT, RuntimeType.STRING
	};
	public String[] getFieldNames() { return field_names; }
	public RuntimeType[] getFieldTypes() { return field_types; }

	public Object[] getFields() {
		return new Object[] {
			f_l, f_r
		};
	}
	@SuppressWarnings("unchecked")
	public void setFields(Object[] values) {
		if (values.length != 2)
			throw new IndexOutOfBoundsException("Invalid field count in IntVar");
		f_l = (Integer)values[0];
		f_r = (String)values[1];
	}

	public int compareTo(Struct other_gen) {
		if (other_gen == this) return 0;
		int tmp = other_gen.getTypeId();
		if (tmp != 36) return 36-tmp;
		Struct_IntVar other = (Struct_IntVar)other_gen;
		if (f_l != other.f_l)
			return (f_l > other.f_l) ? 1 : -1;
		tmp = f_r.compareTo(other.f_r);
		return tmp;
	}
}
