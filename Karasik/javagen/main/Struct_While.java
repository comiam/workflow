// HASH COLLISIONS: YES
// timestamp: 1.608021993776E12

package main;

import com.area9innovation.flow.*;

public class Struct_While extends Struct {
	public Struct_Test f_test;
	public Struct f_a;
	public Struct f_invariant;

	public Struct_While() {}
	public Struct_While(Struct_Test a_test, Struct a_a, Struct a_invariant) {
		f_test = a_test;
		f_a = a_a;
		f_invariant = a_invariant;
	}

	public int getTypeId() { return 144; }
	public String getTypeName() { return "While"; }

	private static final String[] field_names = new String[] {
		"test", "a", "invariant"
	};
	private static final RuntimeType[] field_types = new RuntimeType[] {
		RuntimeType.STRUCT, RuntimeType.STRUCT, RuntimeType.STRUCT
	};
	public String[] getFieldNames() { return field_names; }
	public RuntimeType[] getFieldTypes() { return field_types; }

	public Object[] getFields() {
		return new Object[] {
			f_test, f_a, f_invariant
		};
	}
	@SuppressWarnings("unchecked")
	public void setFields(Object[] values) {
		if (values.length != 3)
			throw new IndexOutOfBoundsException("Invalid field count in While");
		f_test = (Struct_Test)values[0];
		f_a = (Struct)values[1];
		f_invariant = (Struct)values[2];
	}

	public int compareTo(Struct other_gen) {
		if (other_gen == this) return 0;
		int tmp = other_gen.getTypeId();
		if (tmp != 144) return 144-tmp;
		Struct_While other = (Struct_While)other_gen;
		tmp = f_test.compareTo(other.f_test);
		if (tmp != 0) return tmp;
		tmp = f_a.compareTo(other.f_a);
		if (tmp != 0) return tmp;
		tmp = f_invariant.compareTo(other.f_invariant);
		return tmp;
	}
}
