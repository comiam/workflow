// HASH COLLISIONS: YES
// timestamp: 1.609184888356E12

package main;

import com.area9innovation.flow.*;

public class Struct_Loop extends Struct {
	public Struct f_f;
	public Struct f_invariant;

	public Struct_Loop() {}
	public Struct_Loop(Struct a_f, Struct a_invariant) {
		f_f = a_f;
		f_invariant = a_invariant;
	}

	public int getTypeId() { return 64; }
	public String getTypeName() { return "Loop"; }

	private static final String[] field_names = new String[] {
		"f", "invariant"
	};
	private static final RuntimeType[] field_types = new RuntimeType[] {
		RuntimeType.STRUCT, RuntimeType.STRUCT
	};
	public String[] getFieldNames() { return field_names; }
	public RuntimeType[] getFieldTypes() { return field_types; }

	public Object[] getFields() {
		return new Object[] {
			f_f, f_invariant
		};
	}
	@SuppressWarnings("unchecked")
	public void setFields(Object[] values) {
		if (values.length != 2)
			throw new IndexOutOfBoundsException("Invalid field count in Loop");
		f_f = (Struct)values[0];
		f_invariant = (Struct)values[1];
	}

	public int compareTo(Struct other_gen) {
		if (other_gen == this) return 0;
		int tmp = other_gen.getTypeId();
		if (tmp != 64) return 64-tmp;
		Struct_Loop other = (Struct_Loop)other_gen;
		tmp = f_f.compareTo(other.f_f);
		if (tmp != 0) return tmp;
		tmp = f_invariant.compareTo(other.f_invariant);
		return tmp;
	}
}
