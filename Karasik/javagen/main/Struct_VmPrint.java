// HASH COLLISIONS: YES
// timestamp: 1.608021993775E12

package main;

import com.area9innovation.flow.*;

public class Struct_VmPrint extends Struct {
	public Struct f_data;
	public int f_goto;

	public Struct_VmPrint() {}
	public Struct_VmPrint(Struct a_data, int a_goto) {
		f_data = a_data;
		f_goto = a_goto;
	}

	public int getTypeId() { return 143; }
	public String getTypeName() { return "VmPrint"; }

	private static final String[] field_names = new String[] {
		"data", "goto"
	};
	private static final RuntimeType[] field_types = new RuntimeType[] {
		RuntimeType.STRUCT, RuntimeType.INT
	};
	public String[] getFieldNames() { return field_names; }
	public RuntimeType[] getFieldTypes() { return field_types; }

	public Object[] getFields() {
		return new Object[] {
			f_data, f_goto
		};
	}
	@SuppressWarnings("unchecked")
	public void setFields(Object[] values) {
		if (values.length != 2)
			throw new IndexOutOfBoundsException("Invalid field count in VmPrint");
		f_data = (Struct)values[0];
		f_goto = (Integer)values[1];
	}

	public int compareTo(Struct other_gen) {
		if (other_gen == this) return 0;
		int tmp = other_gen.getTypeId();
		if (tmp != 143) return 143-tmp;
		Struct_VmPrint other = (Struct_VmPrint)other_gen;
		tmp = f_data.compareTo(other.f_data);
		if (tmp != 0) return tmp;
		if (f_goto != other.f_goto)
			return (f_goto > other.f_goto) ? 1 : -1;
		return 0;
	}
}
