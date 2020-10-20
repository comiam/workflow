// HASH COLLISIONS: YES
// timestamp: 1.603122528155E12

package main;

import com.area9innovation.flow.*;

public class Struct_Mono extends Struct {
	public Struct f_prod;

	public Struct_Mono() {}
	public Struct_Mono(Struct a_prod) {
		f_prod = a_prod;
	}

	public int getTypeId() { return 42; }
	public String getTypeName() { return "Mono"; }

	private static final String[] field_names = new String[] {
		"prod"
	};
	private static final RuntimeType[] field_types = new RuntimeType[] {
		RuntimeType.STRUCT
	};
	public String[] getFieldNames() { return field_names; }
	public RuntimeType[] getFieldTypes() { return field_types; }

	public Object[] getFields() {
		return new Object[] {
			f_prod
		};
	}
	@SuppressWarnings("unchecked")
	public void setFields(Object[] values) {
		if (values.length != 1)
			throw new IndexOutOfBoundsException("Invalid field count in Mono");
		f_prod = (Struct)values[0];
	}

	public int compareTo(Struct other_gen) {
		if (other_gen == this) return 0;
		int tmp = other_gen.getTypeId();
		if (tmp != 42) return 42-tmp;
		Struct_Mono other = (Struct_Mono)other_gen;
		tmp = f_prod.compareTo(other.f_prod);
		return tmp;
	}
}
