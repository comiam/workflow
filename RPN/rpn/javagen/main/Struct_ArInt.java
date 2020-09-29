// HASH COLLISIONS: YES
// timestamp: 1.601369194091E12

package main;

import com.area9innovation.flow.*;

public class Struct_ArInt extends Struct {
	public int f_val;

	public Struct_ArInt() {}
	public Struct_ArInt(int a_val) {
		f_val = a_val;
	}

	public int getTypeId() { return 8; }
	public String getTypeName() { return "ArInt"; }

	private static final String[] field_names = new String[] {
		"val"
	};
	private static final RuntimeType[] field_types = new RuntimeType[] {
		RuntimeType.INT
	};
	public String[] getFieldNames() { return field_names; }
	public RuntimeType[] getFieldTypes() { return field_types; }

	public Object[] getFields() {
		return new Object[] {
			f_val
		};
	}
	@SuppressWarnings("unchecked")
	public void setFields(Object[] values) {
		if (values.length != 1)
			throw new IndexOutOfBoundsException("Invalid field count in ArInt");
		f_val = (Integer)values[0];
	}

	public int compareTo(Struct other_gen) {
		if (other_gen == this) return 0;
		int tmp = other_gen.getTypeId();
		if (tmp != 8) return 8-tmp;
		Struct_ArInt other = (Struct_ArInt)other_gen;
		if (f_val != other.f_val)
			return (f_val > other.f_val) ? 1 : -1;
		return 0;
	}
}
