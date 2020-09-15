// HASH COLLISIONS: YES
// timestamp: 1.599535537E12

package pair2;

import com.area9innovation.flow.*;

@SuppressWarnings("unchecked")
final class Module_set {
	final pair2 runtime;
	Module_set(pair2 runtime) {
		this.runtime = runtime;
	}
	Struct_Set f_buildSet(Object[] axs) {
		return ((Struct_Set)runtime.h_Native.fold(axs, f_makeSet(), ((Func2<Object,Object, Object>)(Func2)runtime.gfw_insertSet)));
	}
	boolean f_containsSet(Struct_Set as, Object avalue) {
		return runtime.m_tree.f_containsKeyTree(as.f_tree, avalue);
	}
	Struct_Set f_insertSet(Struct_Set as, Object avalue) {
		return (new Struct_Set(((Func3<Struct,Struct, Object, Boolean>)(Func3)runtime.n_setTree).invoke(as.f_tree, avalue, ((Boolean)true))));
	}
	Struct_Set f_makeSet() {
		return (new Struct_Set(runtime.m_tree.f_makeTree()));
	}
	Object[] f_set2array(Struct_Set as) {
		return runtime.m_tree.f_getTreeKeys(as.f_tree);
	}
}
