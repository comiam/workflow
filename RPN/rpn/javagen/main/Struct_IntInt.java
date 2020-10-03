// HASH COLLISIONS: YES
// timestamp: 1.601710122753E12

package main;

import com.area9innovation.flow.*;

public class Struct_IntInt extends Struct {
	public int f_l;
	public int f_r;

	public Struct_IntInt() {}
	public Struct_IntInt(int a_l, int a_r) {
		f_l = a_l;
		f_r = a_r;
	}

	public int getTypeId() { return 32; }
	public String getTypeName() { return "IntInt"; }

	private static final String[] field_names = new String[] {
		"l", "r"
	};
	private static final RuntimeType[] field_types = new RuntimeType[] {
		RuntimeType.INT, RuntimeType.INT
	};
	public String[] getFieldNames() { return field_names; }
	public RuntimeType[] getFieldTypes() { return field_types; }

	public Object[] getFields() {
		return new Object[] {
			f_l, f_r
		};
	}
	@SuppressWarnings("unchecked")
	public void setFields(Object[] values) {
		if (values.length != 2)
			throw new IndexOutOfBoundsException("Invalid field count in IntInt");
		f_l = (Integer)values[0];
		f_r = (Integer)values[1];
	}

	public int compareTo(Struct other_gen) {
		if (other_gen == this) return 0;
		int tmp = other_gen.getTypeId();
		if (tmp != 32) return 32-tmp;
		Struct_IntInt other = (Struct_IntInt)other_gen;
		if (f_l != other.f_l)
			return (f_l > other.f_l) ? 1 : -1;
		if (f_r != other.f_r)
			return (f_r > other.f_r) ? 1 : -1;
		return 0;
	}
}
