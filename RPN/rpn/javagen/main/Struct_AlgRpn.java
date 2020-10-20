// HASH COLLISIONS: YES
// timestamp: 1.603122528152E12

package main;

import com.area9innovation.flow.*;

public class Struct_AlgRpn extends Struct {
	public Object[] f_rpn;

	public Struct_AlgRpn() {}
	public Struct_AlgRpn(Object[] a_rpn) {
		f_rpn = a_rpn;
	}

	public int getTypeId() { return 12; }
	public String getTypeName() { return "AlgRpn"; }

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
			throw new IndexOutOfBoundsException("Invalid field count in AlgRpn");
		f_rpn = (Object[])values[0];
	}

	public int compareTo(Struct other_gen) {
		if (other_gen == this) return 0;
		int tmp = other_gen.getTypeId();
		if (tmp != 12) return 12-tmp;
		Struct_AlgRpn other = (Struct_AlgRpn)other_gen;
		tmp = FlowRuntime.compareByValue(f_rpn, other.f_rpn);
		return tmp;
	}
}
