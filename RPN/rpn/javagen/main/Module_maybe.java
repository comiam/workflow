// HASH COLLISIONS: YES
// timestamp: 1.599279091E12

package main;

import com.area9innovation.flow.*;

@SuppressWarnings("unchecked")
final class Module_maybe {
	final main runtime;
	Module_maybe(main runtime) {
		this.runtime = runtime;
	}
	Object f_either(Struct am, Object aalternative) {
		Struct l0__tmp = am;
		switch (l0__tmp.getTypeId()) {
		case 50/*None*/: {
			return aalternative;
		}
		case 113/*Some*/: {
			final Struct_Some l1__tmp = (Struct_Some)l0__tmp;
			final Object l2_v = l1__tmp.f_value;
			final Object l3_v = l1__tmp.f_value;
			return l3_v;
		}
		default:
			throw new RuntimeException("Unexpected struct in switch: "+l0__tmp.getTypeName());
		}
	}
	Object f_eitherFn(Struct am, Func1<Object,Object> afn, Func0<Object> aalternativeFn) {
		Struct l0__tmp = am;
		switch (l0__tmp.getTypeId()) {
		case 50/*None*/: {
			return aalternativeFn.invoke();
		}
		case 113/*Some*/: {
			final Struct_Some l1__tmp = (Struct_Some)l0__tmp;
			final Object l2_v = l1__tmp.f_value;
			final Object l3_v = l1__tmp.f_value;
			return afn.invoke(l3_v);
		}
		default:
			throw new RuntimeException("Unexpected struct in switch: "+l0__tmp.getTypeName());
		}
	}
	Object f_eitherMap(Struct am, Func1<Object,Object> afn, Object aalternative) {
		Struct l0__tmp = am;
		switch (l0__tmp.getTypeId()) {
		case 50/*None*/: {
			return aalternative;
		}
		case 113/*Some*/: {
			final Struct_Some l1__tmp = (Struct_Some)l0__tmp;
			final Object l2_v = l1__tmp.f_value;
			final Object l3_v = l1__tmp.f_value;
			return afn.invoke(l3_v);
		}
		default:
			throw new RuntimeException("Unexpected struct in switch: "+l0__tmp.getTypeName());
		}
	}
	boolean f_isNone(Struct am) {
		Struct l0__tmp = am;
		switch (l0__tmp.getTypeId()) {
		case 50/*None*/: {
			return true;
		}
		case 113/*Some*/: {
			final Struct_Some l1__tmp = (Struct_Some)l0__tmp;
			final Object l2___ = l1__tmp.f_value;
			return false;
		}
		default:
			throw new RuntimeException("Unexpected struct in switch: "+l0__tmp.getTypeName());
		}
	}
}
