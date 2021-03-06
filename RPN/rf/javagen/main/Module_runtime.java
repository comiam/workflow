// HASH COLLISIONS: YES
// timestamp: 1.599279091E12

package main;

import com.area9innovation.flow.*;

@SuppressWarnings("unchecked")
final class Module_runtime {
	final main runtime;
	Module_runtime(main runtime) {
		this.runtime = runtime;
	}
	public Reference<Boolean> g_localStorageEnabled;
	Object nf_max(Object aa, Object ab) {
		if ((FlowRuntime.compareByValue(aa,ab)>0)) {
			return aa;
		} else {
			return ab;
		}
	}
	public void init_localStorageEnabled() {
		g_localStorageEnabled=((Reference<Boolean>)(new Reference(true)));
	}
	boolean f_all(Object[] aa) {
		return runtime.m_array.f_forall(aa, ((Func1<Boolean,Object>)(Func1)runtime.gfw_idfn));
	}
	int f_countUntil(int astart, int amaxcount, Func1<Boolean,Integer> apredicate) {
	 TAIL_CALL: for(;;) {
		if ((astart>=amaxcount)) {
			return amaxcount;
		} else {
			if (((boolean)apredicate.invoke(((Integer)astart)))) {
				return astart;
			} else {
				{
					final int l0___tmp = (astart+1);
					astart = l0___tmp;
					continue TAIL_CALL;
				}
			}
		}
	 }
	}
	Func1<Boolean,Object> f_eq(Object av1) {
		final Object l0_v1 = av1;
		return new Func1<Boolean,Object>() {
			final public Boolean invoke(final Object av2) {
				return FlowRuntime.compareEqual(l0_v1,av2);
			}
		};
	}
	Object[] f_generate(int astart, int aend, Func1<Object,Integer> afn) {
		if ((astart>=aend)) {
			return SingletonStructs.arr_empty;
		} else {
			return runtime.h_Native.map(runtime.h_Native.enumFromTo(astart, (aend-1)), ((Func1<Object,Object>)(Func1)afn));
		}
	}
	String f_getKeyValue(String akey, String adefaultValue) {
		if (((boolean)g_localStorageEnabled.value)) {
			return runtime.h_Native.getKeyValue(akey, adefaultValue);
		} else {
			return adefaultValue;
		}
	}
	Object f_idfn(Object ax) {
		return ax;
	}
	Object f_max(Object aa, Object ab) {
		if ((FlowRuntime.compareByValue(aa,ab)>0)) {
			return aa;
		} else {
			return ab;
		}
	}
	Object f_min(Object aa, Object ab) {
		if ((FlowRuntime.compareByValue(aa,ab)<=0)) {
			return aa;
		} else {
			return ab;
		}
	}
	Object f_println(Object astr) {
		if (runtime.m_securitymode.f_isLoggingEnabled()) {
			return runtime.h_Native.println(((Object)astr));
		} else {
			return null;
		}
	}
}
