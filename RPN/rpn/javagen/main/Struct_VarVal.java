// HASH COLLISIONS: YES
// timestamp: 1.601369194144E12

package main;

import com.area9innovation.flow.*;

public class Struct_VarVal extends Struct {
	public String f_name;
	public int f_val;

	public Struct_VarVal() {}
	public Struct_VarVal(String a_name, int a_val) {
		f_name = a_name;
		f_val = a_val;
	}

	public int getTypeId() { return 111; }
	public String getTypeName() { return "VarVal"; }

	private static final String[] field_names = new String[] {
		"name", "val"
	};
	private static final RuntimeType[] field_types = new RuntimeType[] {
		RuntimeType.STRING, RuntimeType.INT
	};
	public String[] getFieldNames() { return field_names; }
	public RuntimeType[] getFieldTypes() { return field_types; }

	public Object[] getFields() {
		return new Object[] {
			f_name, f_val
		};
	}
	@SuppressWarnings("unchecked")
	public void setFields(Object[] values) {
		if (values.length != 2)
			throw new IndexOutOfBoundsException("Invalid field count in VarVal");
		f_name = (String)values[0];
		f_val = (Integer)values[1];
	}

	public int compareTo(Struct other_gen) {
		if (other_gen == this) return 0;
		int tmp = other_gen.getTypeId();
		if (tmp != 111) return 111-tmp;
		Struct_VarVal other = (Struct_VarVal)other_gen;
		tmp = f_name.compareTo(other.f_name);
		if (tmp != 0) return tmp;
		if (f_val != other.f_val)
			return (f_val > other.f_val) ? 1 : -1;
		return 0;
	}
}
