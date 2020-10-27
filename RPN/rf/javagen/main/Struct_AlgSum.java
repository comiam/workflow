// HASH COLLISIONS: YES
// timestamp: 1.603191290682E12

package main;

import com.area9innovation.flow.*;

public class Struct_AlgSum extends Struct {
	public Struct f_l;
	public Struct f_r;

	public Struct_AlgSum() {}
	public Struct_AlgSum(Struct a_l, Struct a_r) {
		f_l = a_l;
		f_r = a_r;
	}

	public int getTypeId() { return 12; }
	public String getTypeName() { return "AlgSum"; }

	private static final String[] field_names = new String[] {
		"l", "r"
	};
	private static final RuntimeType[] field_types = new RuntimeType[] {
		RuntimeType.STRUCT, RuntimeType.STRUCT
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
			throw new IndexOutOfBoundsException("Invalid field count in AlgSum");
		f_l = (Struct)values[0];
		f_r = (Struct)values[1];
	}

	public int compareTo(Struct other_gen) {
		if (other_gen == this) return 0;
		int tmp = other_gen.getTypeId();
		if (tmp != 12) return 12-tmp;
		Struct_AlgSum other = (Struct_AlgSum)other_gen;
		tmp = f_l.compareTo(other.f_l);
		if (tmp != 0) return tmp;
		tmp = f_r.compareTo(other.f_r);
		return tmp;
	}
}
