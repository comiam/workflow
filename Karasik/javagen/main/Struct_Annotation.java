// HASH COLLISIONS: YES
// timestamp: 1.608021993761E12

package main;

import com.area9innovation.flow.*;

public class Struct_Annotation extends Struct {
	public Struct f_formule;

	public Struct_Annotation() {}
	public Struct_Annotation(Struct a_formule) {
		f_formule = a_formule;
	}

	public int getTypeId() { return 10; }
	public String getTypeName() { return "Annotation"; }

	private static final String[] field_names = new String[] {
		"formule"
	};
	private static final RuntimeType[] field_types = new RuntimeType[] {
		RuntimeType.STRUCT
	};
	public String[] getFieldNames() { return field_names; }
	public RuntimeType[] getFieldTypes() { return field_types; }

	public Object[] getFields() {
		return new Object[] {
			f_formule
		};
	}
	@SuppressWarnings("unchecked")
	public void setFields(Object[] values) {
		if (values.length != 1)
			throw new IndexOutOfBoundsException("Invalid field count in Annotation");
		f_formule = (Struct)values[0];
	}

	public int compareTo(Struct other_gen) {
		if (other_gen == this) return 0;
		int tmp = other_gen.getTypeId();
		if (tmp != 10) return 10-tmp;
		Struct_Annotation other = (Struct_Annotation)other_gen;
		tmp = f_formule.compareTo(other.f_formule);
		return tmp;
	}
}
