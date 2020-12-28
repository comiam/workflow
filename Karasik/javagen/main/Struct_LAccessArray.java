// HASH COLLISIONS: YES
// timestamp: 1.609184888355E12

package main;

import com.area9innovation.flow.*;

public class Struct_LAccessArray extends Struct {
	public Struct f_name;
	public Struct f_index;

	public Struct_LAccessArray() {}
	public Struct_LAccessArray(Struct a_name, Struct a_index) {
		f_name = a_name;
		f_index = a_index;
	}

	public int getTypeId() { return 56; }
	public String getTypeName() { return "LAccessArray"; }

	private static final String[] field_names = new String[] {
		"name", "index"
	};
	private static final RuntimeType[] field_types = new RuntimeType[] {
		RuntimeType.STRUCT, RuntimeType.STRUCT
	};
	public String[] getFieldNames() { return field_names; }
	public RuntimeType[] getFieldTypes() { return field_types; }

	public Object[] getFields() {
		return new Object[] {
			f_name, f_index
		};
	}
	@SuppressWarnings("unchecked")
	public void setFields(Object[] values) {
		if (values.length != 2)
			throw new IndexOutOfBoundsException("Invalid field count in LAccessArray");
		f_name = (Struct)values[0];
		f_index = (Struct)values[1];
	}

	public int compareTo(Struct other_gen) {
		if (other_gen == this) return 0;
		int tmp = other_gen.getTypeId();
		if (tmp != 56) return 56-tmp;
		Struct_LAccessArray other = (Struct_LAccessArray)other_gen;
		tmp = f_name.compareTo(other.f_name);
		if (tmp != 0) return tmp;
		tmp = f_index.compareTo(other.f_index);
		return tmp;
	}
}
