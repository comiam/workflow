// HASH COLLISIONS: YES
// timestamp: 1.603122528152E12

package main;

import com.area9innovation.flow.*;

public class Struct_AlgVar extends Struct {
	public String f_var;

	public Struct_AlgVar() {}
	public Struct_AlgVar(String a_var) {
		f_var = a_var;
	}

	public int getTypeId() { return 14; }
	public String getTypeName() { return "AlgVar"; }

	private static final String[] field_names = new String[] {
		"var"
	};
	private static final RuntimeType[] field_types = new RuntimeType[] {
		RuntimeType.STRING
	};
	public String[] getFieldNames() { return field_names; }
	public RuntimeType[] getFieldTypes() { return field_types; }

	public Object[] getFields() {
		return new Object[] {
			f_var
		};
	}
	@SuppressWarnings("unchecked")
	public void setFields(Object[] values) {
		if (values.length != 1)
			throw new IndexOutOfBoundsException("Invalid field count in AlgVar");
		f_var = (String)values[0];
	}

	public int compareTo(Struct other_gen) {
		if (other_gen == this) return 0;
		int tmp = other_gen.getTypeId();
		if (tmp != 14) return 14-tmp;
		Struct_AlgVar other = (Struct_AlgVar)other_gen;
		tmp = f_var.compareTo(other.f_var);
		return tmp;
	}
}
