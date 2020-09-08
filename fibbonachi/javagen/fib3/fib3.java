// HASH COLLISIONS: YES
// timestamp: 1.599561395692E12

package fib3;

import com.area9innovation.flow.*;

@SuppressWarnings("unchecked")
public final class fib3 extends FlowRuntime {

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
	final Module_fib3 m_fib3 = new Module_fib3(this);
	public fib3(String[] args) {
		super(Structs.structList(), args);
	}

	// Wrappers

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
		m_fib3.f_main();
	}
	public static void main(String[] args) {
		fib3 runner = new fib3(args);
		runner.start(null);
	}
}
