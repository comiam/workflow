// HASH COLLISIONS: YES
// timestamp: 1.609184888364E12

package main;

import com.area9innovation.flow.*;

public class Struct_VarDefine extends Struct {
	public String f_name;
	public Struct f_type;
	public Struct f_value;

	public Struct_VarDefine() {}
	public Struct_VarDefine(String a_name, Struct a_type, Struct a_value) {
		f_name = a_name;
		f_type = a_type;
		f_value = a_value;
	}

	public int getTypeId() { return 145; }
	public String getTypeName() { return "VarDefine"; }

	private static final String[] field_names = new String[] {
		"name", "type", "value"
	};
	private static final RuntimeType[] field_types = new RuntimeType[] {
		RuntimeType.STRING, RuntimeType.STRUCT, RuntimeType.STRUCT
	};
	public String[] getFieldNames() { return field_names; }
	public RuntimeType[] getFieldTypes() { return field_types; }

	public Object[] getFields() {
		return new Object[] {
			f_name, f_type, f_value
		};
	}
	@SuppressWarnings("unchecked")
	public void setFields(Object[] values) {
		if (values.length != 3)
			throw new IndexOutOfBoundsException("Invalid field count in VarDefine");
		f_name = (String)values[0];
		f_type = (Struct)values[1];
		f_value = (Struct)values[2];
	}

	public int compareTo(Struct other_gen) {
		if (other_gen == this) return 0;
		int tmp = other_gen.getTypeId();
		if (tmp != 145) return 145-tmp;
		Struct_VarDefine other = (Struct_VarDefine)other_gen;
		tmp = f_name.compareTo(other.f_name);
		if (tmp != 0) return tmp;
		tmp = f_type.compareTo(other.f_type);
		if (tmp != 0) return tmp;
		tmp = f_value.compareTo(other.f_value);
		return tmp;
	}
}
