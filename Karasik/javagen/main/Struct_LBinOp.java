// HASH COLLISIONS: YES
// timestamp: 1.609184888355E12

package main;

import com.area9innovation.flow.*;

public class Struct_LBinOp extends Struct {
	public String f_op;
	public Struct f_f;
	public Struct f_s;

	public Struct_LBinOp() {}
	public Struct_LBinOp(String a_op, Struct a_f, Struct a_s) {
		f_op = a_op;
		f_f = a_f;
		f_s = a_s;
	}

	public int getTypeId() { return 57; }
	public String getTypeName() { return "LBinOp"; }

	private static final String[] field_names = new String[] {
		"op", "f", "s"
	};
	private static final RuntimeType[] field_types = new RuntimeType[] {
		RuntimeType.STRING, RuntimeType.STRUCT, RuntimeType.STRUCT
	};
	public String[] getFieldNames() { return field_names; }
	public RuntimeType[] getFieldTypes() { return field_types; }

	public Object[] getFields() {
		return new Object[] {
			f_op, f_f, f_s
		};
	}
	@SuppressWarnings("unchecked")
	public void setFields(Object[] values) {
		if (values.length != 3)
			throw new IndexOutOfBoundsException("Invalid field count in LBinOp");
		f_op = (String)values[0];
		f_f = (Struct)values[1];
		f_s = (Struct)values[2];
	}

	public int compareTo(Struct other_gen) {
		if (other_gen == this) return 0;
		int tmp = other_gen.getTypeId();
		if (tmp != 57) return 57-tmp;
		Struct_LBinOp other = (Struct_LBinOp)other_gen;
		tmp = f_op.compareTo(other.f_op);
		if (tmp != 0) return tmp;
		tmp = f_f.compareTo(other.f_f);
		if (tmp != 0) return tmp;
		tmp = f_s.compareTo(other.f_s);
		return tmp;
	}
}
