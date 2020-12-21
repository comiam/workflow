// HASH COLLISIONS: YES
// timestamp: 1.608575719674E12

package main;

import com.area9innovation.flow.*;

public class Struct_Array extends Struct {
	public int f_size;

	public Struct_Array() {}
	public Struct_Array(int a_size) {
		f_size = a_size;
	}

	public int getTypeId() { return 12; }
	public String getTypeName() { return "Array"; }

	private static final String[] field_names = new String[] {
		"size"
	};
	private static final RuntimeType[] field_types = new RuntimeType[] {
		RuntimeType.INT
	};
	public String[] getFieldNames() { return field_names; }
	public RuntimeType[] getFieldTypes() { return field_types; }

	public Object[] getFields() {
		return new Object[] {
			f_size
		};
	}
	@SuppressWarnings("unchecked")
	public void setFields(Object[] values) {
		if (values.length != 1)
			throw new IndexOutOfBoundsException("Invalid field count in Array");
		f_size = (Integer)values[0];
	}

	public int compareTo(Struct other_gen) {
		if (other_gen == this) return 0;
		int tmp = other_gen.getTypeId();
		if (tmp != 12) return 12-tmp;
		Struct_Array other = (Struct_Array)other_gen;
		if (f_size != other.f_size)
			return (f_size > other.f_size) ? 1 : -1;
		return 0;
	}
}
