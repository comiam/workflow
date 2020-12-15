// HASH COLLISIONS: YES
// timestamp: 1.608026618952E12

package main;

import com.area9innovation.flow.*;

public class Struct_IndexArrayAccess extends Struct {
	public String f_var;
	public Struct f_index;
	public Struct f_expr;
	public int f_goto;

	public Struct_IndexArrayAccess() {}
	public Struct_IndexArrayAccess(String a_var, Struct a_index, Struct a_expr, int a_goto) {
		f_var = a_var;
		f_index = a_index;
		f_expr = a_expr;
		f_goto = a_goto;
	}

	public int getTypeId() { return 38; }
	public String getTypeName() { return "IndexArrayAccess"; }

	private static final String[] field_names = new String[] {
		"var", "index", "expr", "goto"
	};
	private static final RuntimeType[] field_types = new RuntimeType[] {
		RuntimeType.STRING, RuntimeType.STRUCT, RuntimeType.STRUCT, RuntimeType.INT
	};
	public String[] getFieldNames() { return field_names; }
	public RuntimeType[] getFieldTypes() { return field_types; }

	public Object[] getFields() {
		return new Object[] {
			f_var, f_index, f_expr, f_goto
		};
	}
	@SuppressWarnings("unchecked")
	public void setFields(Object[] values) {
		if (values.length != 4)
			throw new IndexOutOfBoundsException("Invalid field count in IndexArrayAccess");
		f_var = (String)values[0];
		f_index = (Struct)values[1];
		f_expr = (Struct)values[2];
		f_goto = (Integer)values[3];
	}

	public int compareTo(Struct other_gen) {
		if (other_gen == this) return 0;
		int tmp = other_gen.getTypeId();
		if (tmp != 38) return 38-tmp;
		Struct_IndexArrayAccess other = (Struct_IndexArrayAccess)other_gen;
		tmp = f_var.compareTo(other.f_var);
		if (tmp != 0) return tmp;
		tmp = f_index.compareTo(other.f_index);
		if (tmp != 0) return tmp;
		tmp = f_expr.compareTo(other.f_expr);
		if (tmp != 0) return tmp;
		if (f_goto != other.f_goto)
			return (f_goto > other.f_goto) ? 1 : -1;
		return 0;
	}
}
