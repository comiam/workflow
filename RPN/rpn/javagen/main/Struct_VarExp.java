// HASH COLLISIONS: YES
// timestamp: 1.601710122762E12

package main;

import com.area9innovation.flow.*;

public class Struct_VarExp extends Struct {
	public String f_l;
	public Struct f_r;

	public Struct_VarExp() {}
	public Struct_VarExp(String a_l, Struct a_r) {
		f_l = a_l;
		f_r = a_r;
	}

	public int getTypeId() { return 119; }
	public String getTypeName() { return "VarExp"; }

	private static final String[] field_names = new String[] {
		"l", "r"
	};
	private static final RuntimeType[] field_types = new RuntimeType[] {
		RuntimeType.STRING, RuntimeType.STRUCT
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
			throw new IndexOutOfBoundsException("Invalid field count in VarExp");
		f_l = (String)values[0];
		f_r = (Struct)values[1];
	}

	public int compareTo(Struct other_gen) {
		if (other_gen == this) return 0;
		int tmp = other_gen.getTypeId();
		if (tmp != 119) return 119-tmp;
		Struct_VarExp other = (Struct_VarExp)other_gen;
		tmp = f_l.compareTo(other.f_l);
		if (tmp != 0) return tmp;
		tmp = f_r.compareTo(other.f_r);
		return tmp;
	}
}
