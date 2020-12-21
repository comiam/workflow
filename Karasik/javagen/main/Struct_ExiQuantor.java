// HASH COLLISIONS: YES
// timestamp: 1.608575719676E12

package main;

import com.area9innovation.flow.*;

public class Struct_ExiQuantor extends Struct {
	public String f_var;
	public Struct f_f;

	public Struct_ExiQuantor() {}
	public Struct_ExiQuantor(String a_var, Struct a_f) {
		f_var = a_var;
		f_f = a_f;
	}

	public int getTypeId() { return 33; }
	public String getTypeName() { return "ExiQuantor"; }

	private static final String[] field_names = new String[] {
		"var", "f"
	};
	private static final RuntimeType[] field_types = new RuntimeType[] {
		RuntimeType.STRING, RuntimeType.STRUCT
	};
	public String[] getFieldNames() { return field_names; }
	public RuntimeType[] getFieldTypes() { return field_types; }

	public Object[] getFields() {
		return new Object[] {
			f_var, f_f
		};
	}
	@SuppressWarnings("unchecked")
	public void setFields(Object[] values) {
		if (values.length != 2)
			throw new IndexOutOfBoundsException("Invalid field count in ExiQuantor");
		f_var = (String)values[0];
		f_f = (Struct)values[1];
	}

	public int compareTo(Struct other_gen) {
		if (other_gen == this) return 0;
		int tmp = other_gen.getTypeId();
		if (tmp != 33) return 33-tmp;
		Struct_ExiQuantor other = (Struct_ExiQuantor)other_gen;
		tmp = f_var.compareTo(other.f_var);
		if (tmp != 0) return tmp;
		tmp = f_f.compareTo(other.f_f);
		return tmp;
	}
}
