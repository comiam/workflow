// HASH COLLISIONS: YES
// timestamp: 1.609184888355E12

package main;

import com.area9innovation.flow.*;

public class Struct_LRedefineArray extends Struct {
	public Struct f_name;
	public Struct f_index;
	public Struct f_value;

	public Struct_LRedefineArray() {}
	public Struct_LRedefineArray(Struct a_name, Struct a_index, Struct a_value) {
		f_name = a_name;
		f_index = a_index;
		f_value = a_value;
	}

	public int getTypeId() { return 59; }
	public String getTypeName() { return "LRedefineArray"; }

	private static final String[] field_names = new String[] {
		"name", "index", "value"
	};
	private static final RuntimeType[] field_types = new RuntimeType[] {
		RuntimeType.STRUCT, RuntimeType.STRUCT, RuntimeType.STRUCT
	};
	public String[] getFieldNames() { return field_names; }
	public RuntimeType[] getFieldTypes() { return field_types; }

	public Object[] getFields() {
		return new Object[] {
			f_name, f_index, f_value
		};
	}
	@SuppressWarnings("unchecked")
	public void setFields(Object[] values) {
		if (values.length != 3)
			throw new IndexOutOfBoundsException("Invalid field count in LRedefineArray");
		f_name = (Struct)values[0];
		f_index = (Struct)values[1];
		f_value = (Struct)values[2];
	}

	public int compareTo(Struct other_gen) {
		if (other_gen == this) return 0;
		int tmp = other_gen.getTypeId();
		if (tmp != 59) return 59-tmp;
		Struct_LRedefineArray other = (Struct_LRedefineArray)other_gen;
		tmp = f_name.compareTo(other.f_name);
		if (tmp != 0) return tmp;
		tmp = f_index.compareTo(other.f_index);
		if (tmp != 0) return tmp;
		tmp = f_value.compareTo(other.f_value);
		return tmp;
	}
}
