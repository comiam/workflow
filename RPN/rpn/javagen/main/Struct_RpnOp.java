// HASH COLLISIONS: YES
// timestamp: 1.60171012276E12

package main;

import com.area9innovation.flow.*;

public class Struct_RpnOp extends Struct {
	public String f_id;
	public Func2<Integer,Integer, Integer> f_op;

	public Struct_RpnOp() {}
	public Struct_RpnOp(String a_id, Func2<Integer,Integer, Integer> a_op) {
		f_id = a_id;
		f_op = a_op;
	}

	public int getTypeId() { return 105; }
	public String getTypeName() { return "RpnOp"; }

	private static final String[] field_names = new String[] {
		"id", "op"
	};
	private static final RuntimeType[] field_types = new RuntimeType[] {
		RuntimeType.STRING, RuntimeType.UNKNOWN
	};
	public String[] getFieldNames() { return field_names; }
	public RuntimeType[] getFieldTypes() { return field_types; }

	public Object[] getFields() {
		return new Object[] {
			f_id, f_op
		};
	}
	@SuppressWarnings("unchecked")
	public void setFields(Object[] values) {
		if (values.length != 2)
			throw new IndexOutOfBoundsException("Invalid field count in RpnOp");
		f_id = (String)values[0];
		f_op = (Func2<Integer,Integer, Integer>)values[1];
	}

	public int compareTo(Struct other_gen) {
		if (other_gen == this) return 0;
		int tmp = other_gen.getTypeId();
		if (tmp != 105) return 105-tmp;
		Struct_RpnOp other = (Struct_RpnOp)other_gen;
		tmp = f_id.compareTo(other.f_id);
		if (tmp != 0) return tmp;
		tmp = FlowRuntime.compareByValue(f_op, other.f_op);
		return tmp;
	}
}
