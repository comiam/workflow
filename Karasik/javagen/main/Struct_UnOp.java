// HASH COLLISIONS: YES
// timestamp: 1.608575719687E12

package main;

import com.area9innovation.flow.*;

public class Struct_UnOp extends Struct {
	public String f_op;
	public Struct f_u;

	public Struct_UnOp() {}
	public Struct_UnOp(String a_op, Struct a_u) {
		f_op = a_op;
		f_u = a_u;
	}

	public int getTypeId() { return 139; }
	public String getTypeName() { return "UnOp"; }

	private static final String[] field_names = new String[] {
		"op", "u"
	};
	private static final RuntimeType[] field_types = new RuntimeType[] {
		RuntimeType.STRING, RuntimeType.STRUCT
	};
	public String[] getFieldNames() { return field_names; }
	public RuntimeType[] getFieldTypes() { return field_types; }

	public Object[] getFields() {
		return new Object[] {
			f_op, f_u
		};
	}
	@SuppressWarnings("unchecked")
	public void setFields(Object[] values) {
		if (values.length != 2)
			throw new IndexOutOfBoundsException("Invalid field count in UnOp");
		f_op = (String)values[0];
		f_u = (Struct)values[1];
	}

	public int compareTo(Struct other_gen) {
		if (other_gen == this) return 0;
		int tmp = other_gen.getTypeId();
		if (tmp != 139) return 139-tmp;
		Struct_UnOp other = (Struct_UnOp)other_gen;
		tmp = f_op.compareTo(other.f_op);
		if (tmp != 0) return tmp;
		tmp = f_u.compareTo(other.f_u);
		return tmp;
	}
}
