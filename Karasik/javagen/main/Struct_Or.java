// HASH COLLISIONS: YES
// timestamp: 1.608575990797E12

package main;

import com.area9innovation.flow.*;

public class Struct_Or extends Struct {
	public Struct f_f;
	public Struct f_s;

	public Struct_Or() {}
	public Struct_Or(Struct a_f, Struct a_s) {
		f_f = a_f;
		f_s = a_s;
	}

	public int getTypeId() { return 70; }
	public String getTypeName() { return "Or"; }

	private static final String[] field_names = new String[] {
		"f", "s"
	};
	private static final RuntimeType[] field_types = new RuntimeType[] {
		RuntimeType.STRUCT, RuntimeType.STRUCT
	};
	public String[] getFieldNames() { return field_names; }
	public RuntimeType[] getFieldTypes() { return field_types; }

	public Object[] getFields() {
		return new Object[] {
			f_f, f_s
		};
	}
	@SuppressWarnings("unchecked")
	public void setFields(Object[] values) {
		if (values.length != 2)
			throw new IndexOutOfBoundsException("Invalid field count in Or");
		f_f = (Struct)values[0];
		f_s = (Struct)values[1];
	}

	public int compareTo(Struct other_gen) {
		if (other_gen == this) return 0;
		int tmp = other_gen.getTypeId();
		if (tmp != 70) return 70-tmp;
		Struct_Or other = (Struct_Or)other_gen;
		tmp = f_f.compareTo(other.f_f);
		if (tmp != 0) return tmp;
		tmp = f_s.compareTo(other.f_s);
		return tmp;
	}
}
