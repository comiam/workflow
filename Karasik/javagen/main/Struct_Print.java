// HASH COLLISIONS: YES
// timestamp: 1.608575719685E12

package main;

import com.area9innovation.flow.*;

public class Struct_Print extends Struct {
	public Struct f_data;

	public Struct_Print() {}
	public Struct_Print(Struct a_data) {
		f_data = a_data;
	}

	public int getTypeId() { return 120; }
	public String getTypeName() { return "Print"; }

	private static final String[] field_names = new String[] {
		"data"
	};
	private static final RuntimeType[] field_types = new RuntimeType[] {
		RuntimeType.STRUCT
	};
	public String[] getFieldNames() { return field_names; }
	public RuntimeType[] getFieldTypes() { return field_types; }

	public Object[] getFields() {
		return new Object[] {
			f_data
		};
	}
	@SuppressWarnings("unchecked")
	public void setFields(Object[] values) {
		if (values.length != 1)
			throw new IndexOutOfBoundsException("Invalid field count in Print");
		f_data = (Struct)values[0];
	}

	public int compareTo(Struct other_gen) {
		if (other_gen == this) return 0;
		int tmp = other_gen.getTypeId();
		if (tmp != 120) return 120-tmp;
		Struct_Print other = (Struct_Print)other_gen;
		tmp = f_data.compareTo(other.f_data);
		return tmp;
	}
}
