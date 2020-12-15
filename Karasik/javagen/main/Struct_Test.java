// HASH COLLISIONS: YES
// timestamp: 1.608021993774E12

package main;

import com.area9innovation.flow.*;

public class Struct_Test extends Struct {
	public String f_test;
	public Struct f_f;
	public Struct f_s;

	public Struct_Test() {}
	public Struct_Test(String a_test, Struct a_f, Struct a_s) {
		f_test = a_test;
		f_f = a_f;
		f_s = a_s;
	}

	public int getTypeId() { return 132; }
	public String getTypeName() { return "Test"; }

	private static final String[] field_names = new String[] {
		"test", "f", "s"
	};
	private static final RuntimeType[] field_types = new RuntimeType[] {
		RuntimeType.STRING, RuntimeType.STRUCT, RuntimeType.STRUCT
	};
	public String[] getFieldNames() { return field_names; }
	public RuntimeType[] getFieldTypes() { return field_types; }

	public Object[] getFields() {
		return new Object[] {
			f_test, f_f, f_s
		};
	}
	@SuppressWarnings("unchecked")
	public void setFields(Object[] values) {
		if (values.length != 3)
			throw new IndexOutOfBoundsException("Invalid field count in Test");
		f_test = (String)values[0];
		f_f = (Struct)values[1];
		f_s = (Struct)values[2];
	}

	public int compareTo(Struct other_gen) {
		if (other_gen == this) return 0;
		int tmp = other_gen.getTypeId();
		if (tmp != 132) return 132-tmp;
		Struct_Test other = (Struct_Test)other_gen;
		tmp = f_test.compareTo(other.f_test);
		if (tmp != 0) return tmp;
		tmp = f_f.compareTo(other.f_f);
		if (tmp != 0) return tmp;
		tmp = f_s.compareTo(other.f_s);
		return tmp;
	}
}
