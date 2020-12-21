// HASH COLLISIONS: YES
// timestamp: 1.608575990793E12

package main;

import com.area9innovation.flow.*;

public class Struct_ExpArrayAccess extends Struct {
	public String f_var;
	public Struct f_index;

	public Struct_ExpArrayAccess() {}
	public Struct_ExpArrayAccess(String a_var, Struct a_index) {
		f_var = a_var;
		f_index = a_index;
	}

	public int getTypeId() { return 34; }
	public String getTypeName() { return "ExpArrayAccess"; }

	private static final String[] field_names = new String[] {
		"var", "index"
	};
	private static final RuntimeType[] field_types = new RuntimeType[] {
		RuntimeType.STRING, RuntimeType.STRUCT
	};
	public String[] getFieldNames() { return field_names; }
	public RuntimeType[] getFieldTypes() { return field_types; }

	public Object[] getFields() {
		return new Object[] {
			f_var, f_index
		};
	}
	@SuppressWarnings("unchecked")
	public void setFields(Object[] values) {
		if (values.length != 2)
			throw new IndexOutOfBoundsException("Invalid field count in ExpArrayAccess");
		f_var = (String)values[0];
		f_index = (Struct)values[1];
	}

	public int compareTo(Struct other_gen) {
		if (other_gen == this) return 0;
		int tmp = other_gen.getTypeId();
		if (tmp != 34) return 34-tmp;
		Struct_ExpArrayAccess other = (Struct_ExpArrayAccess)other_gen;
		tmp = f_var.compareTo(other.f_var);
		if (tmp != 0) return tmp;
		tmp = f_index.compareTo(other.f_index);
		return tmp;
	}
}
