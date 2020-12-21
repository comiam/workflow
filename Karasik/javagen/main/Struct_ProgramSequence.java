// HASH COLLISIONS: YES
// timestamp: 1.608575990802E12

package main;

import com.area9innovation.flow.*;

public class Struct_ProgramSequence extends Struct {
	public Struct f_op;
	public Struct f_next;

	public Struct_ProgramSequence() {}
	public Struct_ProgramSequence(Struct a_op, Struct a_next) {
		f_op = a_op;
		f_next = a_next;
	}

	public int getTypeId() { return 122; }
	public String getTypeName() { return "ProgramSequence"; }

	private static final String[] field_names = new String[] {
		"op", "next"
	};
	private static final RuntimeType[] field_types = new RuntimeType[] {
		RuntimeType.STRUCT, RuntimeType.STRUCT
	};
	public String[] getFieldNames() { return field_names; }
	public RuntimeType[] getFieldTypes() { return field_types; }

	public Object[] getFields() {
		return new Object[] {
			f_op, f_next
		};
	}
	@SuppressWarnings("unchecked")
	public void setFields(Object[] values) {
		if (values.length != 2)
			throw new IndexOutOfBoundsException("Invalid field count in ProgramSequence");
		f_op = (Struct)values[0];
		f_next = (Struct)values[1];
	}

	public int compareTo(Struct other_gen) {
		if (other_gen == this) return 0;
		int tmp = other_gen.getTypeId();
		if (tmp != 122) return 122-tmp;
		Struct_ProgramSequence other = (Struct_ProgramSequence)other_gen;
		tmp = f_op.compareTo(other.f_op);
		if (tmp != 0) return tmp;
		tmp = f_next.compareTo(other.f_next);
		return tmp;
	}
}
