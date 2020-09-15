// HASH COLLISIONS: YES
// timestamp: 1.60015213E12

package pair;

import com.area9innovation.flow.*;

@SuppressWarnings("unchecked")
final class Module_pair {
	final pair runtime;
	Module_pair(pair runtime) {
		this.runtime = runtime;
	}
	Object[] f_findPair(int am, Object[] aarr) {
		final Object[] l2_$1 = SingletonStructs.arr_empty;
		final int l4_m = am;
		final Object[] l5_arr = aarr;
		final Func2<Object[],Object[], Integer> l3_$0 = new Func2<Object[],Object[],Integer>() {
			final public Object[] invoke(final Object[] aacc, final Integer ax) {
				final Func2<Object[],Object[], Integer> l1_$0 = new Func2<Object[],Object[],Integer>() {
					final public Object[] invoke(final Object[] aacc2, final Integer ay) {
						if ((((((int)ax)+((int)ay))==l4_m)&&(((int)ax)<=((int)ay)))) {
							return runtime.h_Native.concat(aacc2, (new Object[] { (new Struct_Pair(ax, ay)) }));
						} else {
							return aacc2;
						}
					}
				};
				return ((Object[])runtime.h_Native.fold(l5_arr, aacc, ((Func2<Object,Object, Object>)(Func2)l1_$0)));
			}
		};
		return ((Object[])runtime.h_Native.fold(aarr, l2_$1, ((Func2<Object,Object, Object>)(Func2)l3_$0)));
	}
	Object f_main() {
		return runtime.m_runtime.f_println(f_findPair(10, (new Object[] { 5, 5, 4, 6, 2, 8, 13, (-3), 0, 10 })));
	}
}
