// HASH COLLISIONS: YES
// timestamp: 1.608021993775E12

package main;

import com.area9innovation.flow.*;

public class Struct_VMArray extends Struct {
	public Object[] f_a;

	public Struct_VMArray() {}
	public Struct_VMArray(Object[] a_a) {
		f_a = a_a;
	}

	public int getTypeId() { return 137; }
	public String getTypeName() { return "VMArray"; }

	private static final String[] field_names = new String[] {
		"a"
	};
	private static final RuntimeType[] field_types = new RuntimeType[] {
		RuntimeType.ARRAY
	};
	public String[] getFieldNames() { return field_names; }
	public RuntimeType[] getFieldTypes() { return field_types; }

	public Object[] getFields() {
		return new Object[] {
			f_a
		};
	}
	@SuppressWarnings("unchecked")
	public void setFields(Object[] values) {
		if (values.length != 1)
			throw new IndexOutOfBoundsException("Invalid field count in VMArray");
		f_a = (Object[])values[0];
	}

	public int compareTo(Struct other_gen) {
		if (other_gen == this) return 0;
		int tmp = other_gen.getTypeId();
		if (tmp != 137) return 137-tmp;
		Struct_VMArray other = (Struct_VMArray)other_gen;
		tmp = FlowRuntime.compareByValue(f_a, other.f_a);
		return tmp;
	}
}
