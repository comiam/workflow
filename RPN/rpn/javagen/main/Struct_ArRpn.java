// HASH COLLISIONS: YES
// timestamp: 1.601369194092E12

package main;

import com.area9innovation.flow.*;

public class Struct_ArRpn extends Struct {
	public Object[] f_rpn;

	public Struct_ArRpn() {}
	public Struct_ArRpn(Object[] a_rpn) {
		f_rpn = a_rpn;
	}

	public int getTypeId() { return 10; }
	public String getTypeName() { return "ArRpn"; }

	private static final String[] field_names = new String[] {
		"rpn"
	};
	private static final RuntimeType[] field_types = new RuntimeType[] {
		RuntimeType.ARRAY
	};
	public String[] getFieldNames() { return field_names; }
	public RuntimeType[] getFieldTypes() { return field_types; }

	public Object[] getFields() {
		return new Object[] {
			f_rpn
		};
	}
	@SuppressWarnings("unchecked")
	public void setFields(Object[] values) {
		if (values.length != 1)
			throw new IndexOutOfBoundsException("Invalid field count in ArRpn");
		f_rpn = (Object[])values[0];
	}

	public int compareTo(Struct other_gen) {
		if (other_gen == this) return 0;
		int tmp = other_gen.getTypeId();
		if (tmp != 10) return 10-tmp;
		Struct_ArRpn other = (Struct_ArRpn)other_gen;
		tmp = FlowRuntime.compareByValue(f_rpn, other.f_rpn);
		return tmp;
	}
}
