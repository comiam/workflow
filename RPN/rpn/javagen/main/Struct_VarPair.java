// HASH COLLISIONS: YES
// timestamp: 1.601710122762E12

package main;

import com.area9innovation.flow.*;

public class Struct_VarPair extends Struct implements Field_first<Struct>, Field_second<Struct> {
	public Struct f_first;
	public Struct f_second;

	public Struct_VarPair() {}
	public Struct_VarPair(Struct a_first, Struct a_second) {
		f_first = a_first;
		f_second = a_second;
	}
	public Struct get_first() { return f_first; }
	public void set_first(Struct value) { f_first = value; }
	public Struct get_second() { return f_second; }
	public void set_second(Struct value) { f_second = value; }

	public int getTypeId() { return 121; }
	public String getTypeName() { return "VarPair"; }

	private static final String[] field_names = new String[] {
		"first", "second"
	};
	private static final RuntimeType[] field_types = new RuntimeType[] {
		RuntimeType.STRUCT, RuntimeType.STRUCT
	};
	public String[] getFieldNames() { return field_names; }
	public RuntimeType[] getFieldTypes() { return field_types; }

	public Object[] getFields() {
		return new Object[] {
			f_first, f_second
		};
	}
	@SuppressWarnings("unchecked")
	public void setFields(Object[] values) {
		if (values.length != 2)
			throw new IndexOutOfBoundsException("Invalid field count in VarPair");
		f_first = (Struct)values[0];
		f_second = (Struct)values[1];
	}

	public int compareTo(Struct other_gen) {
		if (other_gen == this) return 0;
		int tmp = other_gen.getTypeId();
		if (tmp != 121) return 121-tmp;
		Struct_VarPair other = (Struct_VarPair)other_gen;
		tmp = f_first.compareTo(other.f_first);
		if (tmp != 0) return tmp;
		tmp = f_second.compareTo(other.f_second);
		return tmp;
	}
}
