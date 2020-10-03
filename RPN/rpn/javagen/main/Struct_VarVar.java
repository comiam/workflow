// HASH COLLISIONS: YES
// timestamp: 1.601710122763E12

package main;

import com.area9innovation.flow.*;

public class Struct_VarVar extends Struct {
	public String f_l;
	public String f_r;

	public Struct_VarVar() {}
	public Struct_VarVar(String a_l, String a_r) {
		f_l = a_l;
		f_r = a_r;
	}

	public int getTypeId() { return 123; }
	public String getTypeName() { return "VarVar"; }

	private static final String[] field_names = new String[] {
		"l", "r"
	};
	private static final RuntimeType[] field_types = new RuntimeType[] {
		RuntimeType.STRING, RuntimeType.STRING
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
			throw new IndexOutOfBoundsException("Invalid field count in VarVar");
		f_l = (String)values[0];
		f_r = (String)values[1];
	}

	public int compareTo(Struct other_gen) {
		if (other_gen == this) return 0;
		int tmp = other_gen.getTypeId();
		if (tmp != 123) return 123-tmp;
		Struct_VarVar other = (Struct_VarVar)other_gen;
		tmp = f_l.compareTo(other.f_l);
		if (tmp != 0) return tmp;
		tmp = f_r.compareTo(other.f_r);
		return tmp;
	}
}
