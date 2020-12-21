// HASH COLLISIONS: YES
// timestamp: 1.60857571968E12

package main;

import com.area9innovation.flow.*;

public class Struct_Neg extends Struct {
	public Struct f_f;

	public Struct_Neg() {}
	public Struct_Neg(Struct a_f) {
		f_f = a_f;
	}

	public int getTypeId() { return 65; }
	public String getTypeName() { return "Neg"; }

	private static final String[] field_names = new String[] {
		"f"
	};
	private static final RuntimeType[] field_types = new RuntimeType[] {
		RuntimeType.STRUCT
	};
	public String[] getFieldNames() { return field_names; }
	public RuntimeType[] getFieldTypes() { return field_types; }

	public Object[] getFields() {
		return new Object[] {
			f_f
		};
	}
	@SuppressWarnings("unchecked")
	public void setFields(Object[] values) {
		if (values.length != 1)
			throw new IndexOutOfBoundsException("Invalid field count in Neg");
		f_f = (Struct)values[0];
	}

	public int compareTo(Struct other_gen) {
		if (other_gen == this) return 0;
		int tmp = other_gen.getTypeId();
		if (tmp != 65) return 65-tmp;
		Struct_Neg other = (Struct_Neg)other_gen;
		tmp = f_f.compareTo(other.f_f);
		return tmp;
	}
}
