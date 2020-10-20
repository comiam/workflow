// HASH COLLISIONS: YES
// timestamp: 1.603122528151E12

package main;

import com.area9innovation.flow.*;

public class Struct_AlgDouble extends Struct {
	public double f_val;

	public Struct_AlgDouble() {}
	public Struct_AlgDouble(double a_val) {
		f_val = a_val;
	}

	public int getTypeId() { return 9; }
	public String getTypeName() { return "AlgDouble"; }

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
			throw new IndexOutOfBoundsException("Invalid field count in AlgDouble");
		f_val = (Double)values[0];
	}

	public int compareTo(Struct other_gen) {
		if (other_gen == this) return 0;
		int tmp = other_gen.getTypeId();
		if (tmp != 9) return 9-tmp;
		Struct_AlgDouble other = (Struct_AlgDouble)other_gen;
		if (f_val != other.f_val)
			return (f_val > other.f_val) ? 1 : -1;
		return 0;
	}
}
