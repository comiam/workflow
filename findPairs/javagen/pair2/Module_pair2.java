// HASH COLLISIONS: YES
// timestamp: 1.600152615E12

package pair2;

import com.area9innovation.flow.*;

@SuppressWarnings("unchecked")
final class Module_pair2 {
	final pair2 runtime;
	Module_pair2(pair2 runtime) {
		this.runtime = runtime;
	}
	Object[] f_findPair(int am, Object[] aarr) {
		final Struct_Set l0_set = runtime.m_set.f_buildSet(aarr);
		final Struct_Set l3_$2 = runtime.m_set.f_makeSet();
		final int l5_m = am;
		final Func2<Struct_Set,Struct_Set, Integer> l4_$1 = new Func2<Struct_Set,Struct_Set,Integer>() {
			final public Struct_Set invoke(final Struct_Set asetPair, final Integer ax) {
				if (((runtime.m_set.f_containsSet(l0_set, (l5_m-((int)ax)))&&((l5_m-((int)ax))<=((int)ax)))&&!runtime.m_set.f_containsSet(asetPair, (new Struct_Pair(ax, (l5_m-((int)ax))))))) {
					return ((Func2<Struct_Set,Struct_Set, Struct_Pair>)(Func2)runtime.gfw_insertSet).invoke(asetPair, (new Struct_Pair((l5_m-((int)ax)), ax)));
				} else {
					return asetPair;
				}
			}
		};
		return runtime.m_set.f_set2array(((Struct_Set)runtime.h_Native.fold(aarr, l3_$2, ((Func2<Object,Object, Object>)(Func2)l4_$1))));
	}
	Object f_main() {
		return runtime.m_runtime.f_println(f_findPair(10, (new Object[] { 5, 5, 4, 6, 2, 8, 13, (-3), 0, 10 })));
	}
}
