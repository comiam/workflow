// HASH COLLISIONS: YES
// timestamp: 1.601710122752E12

package main;

import com.area9innovation.flow.*;

public class Struct_ExpInt extends Struct {
	public Struct f_l;
	public int f_r;

	public Struct_ExpInt() {}
	public Struct_ExpInt(Struct a_l, int a_r) {
		f_l = a_l;
		f_r = a_r;
	}

	public int getTypeId() { return 27; }
	public String getTypeName() { return "ExpInt"; }

	private static final String[] field_names = new String[] {
		"l", "r"
	};
	private static final RuntimeType[] field_types = new RuntimeType[] {
		RuntimeType.STRUCT, RuntimeType.INT
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
			throw new IndexOutOfBoundsException("Invalid field count in ExpInt");
		f_l = (Struct)values[0];
		f_r = (Integer)values[1];
	}

	public int compareTo(Struct other_gen) {
		if (other_gen == this) return 0;
		int tmp = other_gen.getTypeId();
		if (tmp != 27) return 27-tmp;
		Struct_ExpInt other = (Struct_ExpInt)other_gen;
		tmp = f_l.compareTo(other.f_l);
		if (tmp != 0) return tmp;
		if (f_r != other.f_r)
			return (f_r > other.f_r) ? 1 : -1;
		return 0;
	}
}
