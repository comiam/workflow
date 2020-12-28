// HASH COLLISIONS: YES
// timestamp: 1.60918488835E12

package main;

import com.area9innovation.flow.*;

public class Struct_And extends Struct {
	public Struct f_f;
	public Struct f_s;

	public Struct_And() {}
	public Struct_And(Struct a_f, Struct a_s) {
		f_f = a_f;
		f_s = a_s;
	}

	public int getTypeId() { return 10; }
	public String getTypeName() { return "And"; }

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
			throw new IndexOutOfBoundsException("Invalid field count in And");
		f_f = (Struct)values[0];
		f_s = (Struct)values[1];
	}

	public int compareTo(Struct other_gen) {
		if (other_gen == this) return 0;
		int tmp = other_gen.getTypeId();
		if (tmp != 10) return 10-tmp;
		Struct_And other = (Struct_And)other_gen;
		tmp = f_f.compareTo(other.f_f);
		if (tmp != 0) return tmp;
		tmp = f_s.compareTo(other.f_s);
		return tmp;
	}
}
