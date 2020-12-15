// HASH COLLISIONS: YES
// timestamp: 1.599279091E12

package main;

import com.area9innovation.flow.*;

@SuppressWarnings("unchecked")
final class Module_url {
	final main runtime;
	Module_url(main runtime) {
		this.runtime = runtime;
	}
	public Reference<Func2<Object,String, Func1<Object,String>>> g_redirectAdditionalFn;
	public void init_redirectAdditionalFn() {
		final Func2<Object,String, Func1<Object,String>> l1_$0 = new Func2<Object,String,Func1<Object,String>>() {
			final public Object invoke(final String aurl, final Func1<Object,String> afn) {
				return afn.invoke(aurl);
			}
		};
		g_redirectAdditionalFn=((Reference<Func2<Object,String, Func1<Object,String>>>)(new Reference(l1_$0)));
	}
}
