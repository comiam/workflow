// HASH COLLISIONS: YES
// timestamp: 1.608021993775E12

package main;

import com.area9innovation.flow.*;

public class Struct_VarRedefine extends Struct {
	public String f_name;
	public Struct f_value;

	public Struct_VarRedefine() {}
	public Struct_VarRedefine(String a_name, Struct a_value) {
		f_name = a_name;
		f_value = a_value;
	}

	public int getTypeId() { return 141; }
	public String getTypeName() { return "VarRedefine"; }

	private static final String[] field_names = new String[] {
		"name", "value"
	};
	private static final RuntimeType[] field_types = new RuntimeType[] {
		RuntimeType.STRING, RuntimeType.STRUCT
	};
	public String[] getFieldNames() { return field_names; }
	public RuntimeType[] getFieldTypes() { return field_types; }

	public Object[] getFields() {
		return new Object[] {
			f_name, f_value
		};
	}
	@SuppressWarnings("unchecked")
	public void setFields(Object[] values) {
		if (values.length != 2)
			throw new IndexOutOfBoundsException("Invalid field count in VarRedefine");
		f_name = (String)values[0];
		f_value = (Struct)values[1];
	}

	public int compareTo(Struct other_gen) {
		if (other_gen == this) return 0;
		int tmp = other_gen.getTypeId();
		if (tmp != 141) return 141-tmp;
		Struct_VarRedefine other = (Struct_VarRedefine)other_gen;
		tmp = f_name.compareTo(other.f_name);
		if (tmp != 0) return tmp;
		tmp = f_value.compareTo(other.f_value);
		return tmp;
	}
}
