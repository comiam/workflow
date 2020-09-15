// HASH COLLISIONS: YES
// timestamp: 1.600152621679E12

package pair2;

import com.area9innovation.flow.*;

@SuppressWarnings("unchecked")
public final class pair2 extends FlowRuntime {

	// Modules
	final Module_tuples m_tuples = new Module_tuples(this);
	final Module_dynamic m_dynamic = new Module_dynamic(this);
	final Module_maybe m_maybe = new Module_maybe(this);
	final Module_url m_url = new Module_url(this);
	final Module_list m_list = new Module_list(this);
	final Module_array m_array = new Module_array(this);
	final Module_flowstructs m_flowstructs = new Module_flowstructs(this);
	final Module_securitymode m_securitymode = new Module_securitymode(this);
	final Module_runtime m_runtime = new Module_runtime(this);
	final Module_tree m_tree = new Module_tree(this);
	final Module_string m_string = new Module_string(this);
	final Module_set m_set = new Module_set(this);
	final Module_pair2 m_pair2 = new Module_pair2(this);
	public pair2(String[] args) {
		super(Structs.structList(), args);
	}

	// Wrappers
	final Func2<Struct_Set,Struct_Set, Object> gfw_insertSet = new Func2<Struct_Set,Struct_Set, Object>() {
		final public Struct_Set invoke(Struct_Set a0, Object a1) {
			return m_set.f_insertSet(a0, a1);
		}
	};

	// Native Wrappers
	final Func2<Object,Object, Object> nw_max = new Func2<Object,Object, Object>() {
		final public Object invoke(Object a0, Object a1) {
			return m_runtime.nf_max(a0, a1);
		}
	};
	Func2<Object,Object, Object> n_max = nw_max;
	final Func2<Struct,Struct, Object> nw_lookupTree = new Func2<Struct,Struct, Object>() {
		final public Struct invoke(Struct a0, Object a1) {
			return m_tree.nf_lookupTree(a0, a1);
		}
	};
	Func2<Struct,Struct, Object> n_lookupTree = nw_lookupTree;
	final Func3<Struct,Struct, Object, Object> nw_setTree = new Func3<Struct,Struct, Object, Object>() {
		final public Struct invoke(Struct a0, Object a1, Object a2) {
			return m_tree.nf_setTree(a0, a1, a2);
		}
	};
	Func3<Struct,Struct, Object, Object> n_setTree = nw_setTree;

	// Init function
	Native h_Native;

	// Init hosts
	final private void init_hosts() {
		h_Native = super.getNativeHost(Native.class);
	}

	// Init code
	final private void init_code() {
		try {
			final java.lang.reflect.Method method = Native.class.getMethod("fast_max", Object.class, Object.class);
			n_max = new Func2<Object,Object, Object>() {
				final public Object invoke(Object a0, Object a1) {
					try { return (Object)method.invoke(h_Native, a0, a1); } catch (ReflectiveOperationException e) { throw new RuntimeException(e); }
				}
			};
		} catch (ReflectiveOperationException e) {};
		try {
			final java.lang.reflect.Method method = Native.class.getMethod("fast_lookupTree", Struct.class, Object.class);
			n_lookupTree = new Func2<Struct,Struct, Object>() {
				final public Struct invoke(Struct a0, Object a1) {
					try { return (Struct)method.invoke(h_Native, a0, a1); } catch (ReflectiveOperationException e) { throw new RuntimeException(e); }
				}
			};
		} catch (ReflectiveOperationException e) {};
		try {
			final java.lang.reflect.Method method = Native.class.getMethod("fast_setTree", Struct.class, Object.class, Object.class);
			n_setTree = new Func3<Struct,Struct, Object, Object>() {
				final public Struct invoke(Struct a0, Object a1, Object a2) {
					try { return (Struct)method.invoke(h_Native, a0, a1, a2); } catch (ReflectiveOperationException e) { throw new RuntimeException(e); }
				}
			};
		} catch (ReflectiveOperationException e) {};
		m_url.init_redirectAdditionalFn();
		m_securitymode.init_loggingEnabled();
		m_securitymode.init_securityModes();
		m_runtime.init_localStorageEnabled();
	}
	final private void init() {
		init_hosts();
		init_code();
	}
	protected void main() {
		init();
		m_pair2.f_main();
	}
	public static void main(String[] args) {
		pair2 runner = new pair2(args);
		runner.start(null);
	}
}
