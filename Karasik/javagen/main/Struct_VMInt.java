// HASH COLLISIONS: YES
// timestamp: 1.608575719688E12

package main;

import com.area9innovation.flow.*;

public class Struct_VMInt extends Struct {
	public int f_i;

	public Struct_VMInt() {}
	public Struct_VMInt(int a_i) {
		f_i = a_i;
	}

	public int getTypeId() { return 141; }
	public String getTypeName() { return "VMInt"; }

	private static final String[] field_names = new String[] {
		"i"
	};
	private static final RuntimeType[] field_types = new RuntimeType[] {
		RuntimeType.INT
	};
	public String[] getFieldNames() { return field_names; }
	public RuntimeType[] getFieldTypes() { return field_types; }

	public Object[] getFields() {
		return new Object[] {
			f_i
		};
	}
	@SuppressWarnings("unchecked")
	public void setFields(Object[] values) {
		if (values.length != 1)
			throw new IndexOutOfBoundsException("Invalid field count in VMInt");
		f_i = (Integer)values[0];
	}

	public int compareTo(Struct other_gen) {
		if (other_gen == this) return 0;
		int tmp = other_gen.getTypeId();
		if (tmp != 141) return 141-tmp;
		Struct_VMInt other = (Struct_VMInt)other_gen;
		if (f_i != other.f_i)
			return (f_i > other.f_i) ? 1 : -1;
		return 0;
	}
}
