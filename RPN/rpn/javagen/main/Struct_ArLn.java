// HASH COLLISIONS: YES
// timestamp: 1.602567278202E12

package main;

import com.area9innovation.flow.*;

public class Struct_ArLn extends Struct {
	public Struct f_l;

	public Struct_ArLn() {}
	public Struct_ArLn(Struct a_l) {
		f_l = a_l;
	}

	public int getTypeId() { return 10; }
	public String getTypeName() { return "ArLn"; }

	private static final String[] field_names = new String[] {
		"l"
	};
	private static final RuntimeType[] field_types = new RuntimeType[] {
		RuntimeType.STRUCT
	};
	public String[] getFieldNames() { return field_names; }
	public RuntimeType[] getFieldTypes() { return field_types; }

	public Object[] getFields() {
		return new Object[] {
			f_l
		};
	}
	@SuppressWarnings("unchecked")
	public void setFields(Object[] values) {
		if (values.length != 1)
			throw new IndexOutOfBoundsException("Invalid field count in ArLn");
		f_l = (Struct)values[0];
	}

	public int compareTo(Struct other_gen) {
		if (other_gen == this) return 0;
		int tmp = other_gen.getTypeId();
		if (tmp != 10) return 10-tmp;
		Struct_ArLn other = (Struct_ArLn)other_gen;
		tmp = f_l.compareTo(other.f_l);
		return tmp;
	}
}
