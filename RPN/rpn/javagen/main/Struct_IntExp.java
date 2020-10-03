// HASH COLLISIONS: YES
// timestamp: 1.601710122752E12

package main;

import com.area9innovation.flow.*;

public class Struct_IntExp extends Struct {
	public int f_l;
	public Struct f_r;

	public Struct_IntExp() {}
	public Struct_IntExp(int a_l, Struct a_r) {
		f_l = a_l;
		f_r = a_r;
	}

	public int getTypeId() { return 31; }
	public String getTypeName() { return "IntExp"; }

	private static final String[] field_names = new String[] {
		"l", "r"
	};
	private static final RuntimeType[] field_types = new RuntimeType[] {
		RuntimeType.INT, RuntimeType.STRUCT
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
			throw new IndexOutOfBoundsException("Invalid field count in IntExp");
		f_l = (Integer)values[0];
		f_r = (Struct)values[1];
	}

	public int compareTo(Struct other_gen) {
		if (other_gen == this) return 0;
		int tmp = other_gen.getTypeId();
		if (tmp != 31) return 31-tmp;
		Struct_IntExp other = (Struct_IntExp)other_gen;
		if (f_l != other.f_l)
			return (f_l > other.f_l) ? 1 : -1;
		tmp = f_r.compareTo(other.f_r);
		return tmp;
	}
}
