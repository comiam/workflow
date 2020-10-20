// HASH COLLISIONS: YES
// timestamp: 1.603105743214E12

package main;

import com.area9innovation.flow.*;

public class Struct_RpnArg extends Struct {
	public double f_val;

	public Struct_RpnArg() {}
	public Struct_RpnArg(double a_val) {
		f_val = a_val;
	}

	public int getTypeId() { return 97; }
	public String getTypeName() { return "RpnArg"; }

	private static final String[] field_names = new String[] {
		"val"
	};
	private static final RuntimeType[] field_types = new RuntimeType[] {
		RuntimeType.DOUBLE
	};
	public String[] getFieldNames() { return field_names; }
	public RuntimeType[] getFieldTypes() { return field_types; }

	public Object[] getFields() {
		return new Object[] {
			f_val
		};
	}
	@SuppressWarnings("unchecked")
	public void setFields(Object[] values) {
		if (values.length != 1)
			throw new IndexOutOfBoundsException("Invalid field count in RpnArg");
		f_val = (Double)values[0];
	}

	public int compareTo(Struct other_gen) {
		if (other_gen == this) return 0;
		int tmp = other_gen.getTypeId();
		if (tmp != 97) return 97-tmp;
		Struct_RpnArg other = (Struct_RpnArg)other_gen;
		if (f_val != other.f_val)
			return (f_val > other.f_val) ? 1 : -1;
		return 0;
	}
}
