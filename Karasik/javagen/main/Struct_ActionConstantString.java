// HASH COLLISIONS: YES
// timestamp: 1.60802199376E12

package main;

import com.area9innovation.flow.*;

public class Struct_ActionConstantString extends Struct {
	public String f_s;

	public Struct_ActionConstantString() {}
	public Struct_ActionConstantString(String a_s) {
		f_s = a_s;
	}

	public int getTypeId() { return 6; }
	public String getTypeName() { return "ActionConstantString"; }

	private static final String[] field_names = new String[] {
		"s"
	};
	private static final RuntimeType[] field_types = new RuntimeType[] {
		RuntimeType.STRING
	};
	public String[] getFieldNames() { return field_names; }
	public RuntimeType[] getFieldTypes() { return field_types; }

	public Object[] getFields() {
		return new Object[] {
			f_s
		};
	}
	@SuppressWarnings("unchecked")
	public void setFields(Object[] values) {
		if (values.length != 1)
			throw new IndexOutOfBoundsException("Invalid field count in ActionConstantString");
		f_s = (String)values[0];
	}

	public int compareTo(Struct other_gen) {
		if (other_gen == this) return 0;
		int tmp = other_gen.getTypeId();
		if (tmp != 6) return 6-tmp;
		Struct_ActionConstantString other = (Struct_ActionConstantString)other_gen;
		tmp = f_s.compareTo(other.f_s);
		return tmp;
	}
}