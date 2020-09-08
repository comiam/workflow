// HASH COLLISIONS: YES
// timestamp: 1.599559355352E12

package fib;

import com.area9innovation.flow.*;

@SuppressWarnings("unchecked")
public final class fib extends FlowRuntime {

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
	final Module_fib m_fib = new Module_fib(this);
	public fib(String[] args) {
		super(Structs.structList(), args);
	}

	// Wrappers
	final Func1<Integer,Integer> gfw_fib = new Func1<Integer,Integer>() {
		final public Integer invoke(Integer a0) {
			return m_fib.f_fib(a0);
		}
	};

	// Native Wrappers

	// Init function
	Native h_Native;

	// Init hosts
	final private void init_hosts() {
		h_Native = super.getNativeHost(Native.class);
	}

	// Init code
	final private void init_code() {
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
		m_fib.f_main();
	}
	public static void main(String[] args) {
		fib runner = new fib(args);
		runner.start(null);
	}
}
