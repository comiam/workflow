// HASH COLLISIONS: YES
// timestamp: 1.601659965864E12

package main;

import com.area9innovation.flow.*;

public class Struct_ArPow extends Struct {
	public Struct f_l;
	public Struct f_pow;

	public Struct_ArPow() {}
	public Struct_ArPow(Struct a_l, Struct a_pow) {
		f_l = a_l;
		f_pow = a_pow;
	}

	public int getTypeId() { return 12; }
	public String getTypeName() { return "ArPow"; }

	private static final String[] field_names = new String[] {
		"l", "pow"
	};
	private static final RuntimeType[] field_types = new RuntimeType[] {
		RuntimeType.STRUCT, RuntimeType.STRUCT
	};
	public String[] getFieldNames() { return field_names; }
	public RuntimeType[] getFieldTypes() { return field_types; }

	public Object[] getFields() {
		return new Object[] {
			f_l, f_pow
		};
	}
	@SuppressWarnings("unchecked")
	public void setFields(Object[] values) {
		if (values.length != 2)
			throw new IndexOutOfBoundsException("Invalid field count in ArPow");
		f_l = (Struct)values[0];
		f_pow = (Struct)values[1];
	}

	public int compareTo(Struct other_gen) {
		if (other_gen == this) return 0;
		int tmp = other_gen.getTypeId();
		if (tmp != 12) return 12-tmp;
		Struct_ArPow other = (Struct_ArPow)other_gen;
		tmp = f_l.compareTo(other.f_l);
		if (tmp != 0) return tmp;
		tmp = f_pow.compareTo(other.f_pow);
		return tmp;
	}
}
