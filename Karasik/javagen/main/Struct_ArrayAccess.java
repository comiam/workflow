// HASH COLLISIONS: YES
// timestamp: 1.608575719674E12

package main;

import com.area9innovation.flow.*;

public class Struct_ArrayAccess extends Struct {
	public Struct_Variable f_var;
	public Struct f_ind;

	public Struct_ArrayAccess() {}
	public Struct_ArrayAccess(Struct_Variable a_var, Struct a_ind) {
		f_var = a_var;
		f_ind = a_ind;
	}

	public int getTypeId() { return 13; }
	public String getTypeName() { return "ArrayAccess"; }

	private static final String[] field_names = new String[] {
		"var", "ind"
	};
	private static final RuntimeType[] field_types = new RuntimeType[] {
		RuntimeType.STRUCT, RuntimeType.STRUCT
	};
	public String[] getFieldNames() { return field_names; }
	public RuntimeType[] getFieldTypes() { return field_types; }

	public Object[] getFields() {
		return new Object[] {
			f_var, f_ind
		};
	}
	@SuppressWarnings("unchecked")
	public void setFields(Object[] values) {
		if (values.length != 2)
			throw new IndexOutOfBoundsException("Invalid field count in ArrayAccess");
		f_var = (Struct_Variable)values[0];
		f_ind = (Struct)values[1];
	}

	public int compareTo(Struct other_gen) {
		if (other_gen == this) return 0;
		int tmp = other_gen.getTypeId();
		if (tmp != 13) return 13-tmp;
		Struct_ArrayAccess other = (Struct_ArrayAccess)other_gen;
		tmp = f_var.compareTo(other.f_var);
		if (tmp != 0) return tmp;
		tmp = f_ind.compareTo(other.f_ind);
		return tmp;
	}
}
