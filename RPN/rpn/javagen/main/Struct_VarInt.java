// HASH COLLISIONS: YES
// timestamp: 1.601659965896E12

package main;

import com.area9innovation.flow.*;

public class Struct_VarInt extends Struct {
	public String f_l;
	public int f_r;

	public Struct_VarInt() {}
	public Struct_VarInt(String a_l, int a_r) {
		f_l = a_l;
		f_r = a_r;
	}

	public int getTypeId() { return 115; }
	public String getTypeName() { return "VarInt"; }

	private static final String[] field_names = new String[] {
		"l", "r"
	};
	private static final RuntimeType[] field_types = new RuntimeType[] {
		RuntimeType.STRING, RuntimeType.INT
	};
	public String[] getFieldNames() { return field_names; }
	public RuntimeType[] getFieldTypes() { return field_types; }

	public Object[] getFields() {
		return new Object[] {
			f_l, f_r
		};
	}
	@SuppressWarnings("unchecked")
	public void setFields(Object[] values) {
		if (values.length != 2)
			throw new IndexOutOfBoundsException("Invalid field count in VarInt");
		f_l = (String)values[0];
		f_r = (Integer)values[1];
	}

	public int compareTo(Struct other_gen) {
		if (other_gen == this) return 0;
		int tmp = other_gen.getTypeId();
		if (tmp != 115) return 115-tmp;
		Struct_VarInt other = (Struct_VarInt)other_gen;
		tmp = f_l.compareTo(other.f_l);
		if (tmp != 0) return tmp;
		if (f_r != other.f_r)
			return (f_r > other.f_r) ? 1 : -1;
		return 0;
	}
}
