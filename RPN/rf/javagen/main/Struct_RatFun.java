// HASH COLLISIONS: YES
// timestamp: 1.603774359237E12

package main;

import com.area9innovation.flow.*;

public class Struct_RatFun extends Struct {
	public Struct_Poly f_num;
	public Struct_Poly f_denum;

	public Struct_RatFun() {}
	public Struct_RatFun(Struct_Poly a_num, Struct_Poly a_denum) {
		f_num = a_num;
		f_denum = a_denum;
	}

	public int getTypeId() { return 98; }
	public String getTypeName() { return "RatFun"; }

	private static final String[] field_names = new String[] {
		"num", "denum"
	};
	private static final RuntimeType[] field_types = new RuntimeType[] {
		RuntimeType.STRUCT, RuntimeType.STRUCT
	};
	public String[] getFieldNames() { return field_names; }
	public RuntimeType[] getFieldTypes() { return field_types; }

	public Object[] getFields() {
		return new Object[] {
			f_num, f_denum
		};
	}
	@SuppressWarnings("unchecked")
	public void setFields(Object[] values) {
		if (values.length != 2)
			throw new IndexOutOfBoundsException("Invalid field count in RatFun");
		f_num = (Struct_Poly)values[0];
		f_denum = (Struct_Poly)values[1];
	}

	public int compareTo(Struct other_gen) {
		if (other_gen == this) return 0;
		int tmp = other_gen.getTypeId();
		if (tmp != 98) return 98-tmp;
		Struct_RatFun other = (Struct_RatFun)other_gen;
		tmp = f_num.compareTo(other.f_num);
		if (tmp != 0) return tmp;
		tmp = f_denum.compareTo(other.f_denum);
		return tmp;
	}
}
