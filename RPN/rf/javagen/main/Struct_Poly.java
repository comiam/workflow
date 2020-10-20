// HASH COLLISIONS: YES
// timestamp: 1.603167929063E12

package main;

import com.area9innovation.flow.*;

public class Struct_Poly extends Struct {
	public Struct f_sum;

	public Struct_Poly() {}
	public Struct_Poly(Struct a_sum) {
		f_sum = a_sum;
	}

	public int getTypeId() { return 93; }
	public String getTypeName() { return "Poly"; }

	private static final String[] field_names = new String[] {
		"sum"
	};
	private static final RuntimeType[] field_types = new RuntimeType[] {
		RuntimeType.STRUCT
	};
	public String[] getFieldNames() { return field_names; }
	public RuntimeType[] getFieldTypes() { return field_types; }

	public Object[] getFields() {
		return new Object[] {
			f_sum
		};
	}
	@SuppressWarnings("unchecked")
	public void setFields(Object[] values) {
		if (values.length != 1)
			throw new IndexOutOfBoundsException("Invalid field count in Poly");
		f_sum = (Struct)values[0];
	}

	public int compareTo(Struct other_gen) {
		if (other_gen == this) return 0;
		int tmp = other_gen.getTypeId();
		if (tmp != 93) return 93-tmp;
		Struct_Poly other = (Struct_Poly)other_gen;
		tmp = f_sum.compareTo(other.f_sum);
		return tmp;
	}
}
