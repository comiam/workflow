// HASH COLLISIONS: YES
// timestamp: 1.602569743648E12

package main;

import com.area9innovation.flow.*;

public class Struct_ArDiv extends Struct {
	public Struct f_up;
	public Struct f_down;

	public Struct_ArDiv() {}
	public Struct_ArDiv(Struct a_up, Struct a_down) {
		f_up = a_up;
		f_down = a_down;
	}

	public int getTypeId() { return 8; }
	public String getTypeName() { return "ArDiv"; }

	private static final String[] field_names = new String[] {
		"up", "down"
	};
	private static final RuntimeType[] field_types = new RuntimeType[] {
		RuntimeType.STRUCT, RuntimeType.STRUCT
	};
	public String[] getFieldNames() { return field_names; }
	public RuntimeType[] getFieldTypes() { return field_types; }

	public Object[] getFields() {
		return new Object[] {
			f_up, f_down
		};
	}
	@SuppressWarnings("unchecked")
	public void setFields(Object[] values) {
		if (values.length != 2)
			throw new IndexOutOfBoundsException("Invalid field count in ArDiv");
		f_up = (Struct)values[0];
		f_down = (Struct)values[1];
	}

	public int compareTo(Struct other_gen) {
		if (other_gen == this) return 0;
		int tmp = other_gen.getTypeId();
		if (tmp != 8) return 8-tmp;
		Struct_ArDiv other = (Struct_ArDiv)other_gen;
		tmp = f_up.compareTo(other.f_up);
		if (tmp != 0) return tmp;
		tmp = f_down.compareTo(other.f_down);
		return tmp;
	}
}
