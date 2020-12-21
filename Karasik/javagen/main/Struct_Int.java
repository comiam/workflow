// HASH COLLISIONS: YES
// timestamp: 1.608575990794E12

package main;

import com.area9innovation.flow.*;

public class Struct_Int extends Struct {
	public int f_v;

	public Struct_Int() {}
	public Struct_Int(int a_v) {
		f_v = a_v;
	}

	public int getTypeId() { return 43; }
	public String getTypeName() { return "Int"; }

	private static final String[] field_names = new String[] {
		"v"
	};
	private static final RuntimeType[] field_types = new RuntimeType[] {
		RuntimeType.INT
	};
	public String[] getFieldNames() { return field_names; }
	public RuntimeType[] getFieldTypes() { return field_types; }

	public Object[] getFields() {
		return new Object[] {
			f_v
		};
	}
	@SuppressWarnings("unchecked")
	public void setFields(Object[] values) {
		if (values.length != 1)
			throw new IndexOutOfBoundsException("Invalid field count in Int");
		f_v = (Integer)values[0];
	}

	public int compareTo(Struct other_gen) {
		if (other_gen == this) return 0;
		int tmp = other_gen.getTypeId();
		if (tmp != 43) return 43-tmp;
		Struct_Int other = (Struct_Int)other_gen;
		if (f_v != other.f_v)
			return (f_v > other.f_v) ? 1 : -1;
		return 0;
	}
}
