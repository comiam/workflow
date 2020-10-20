// HASH COLLISIONS: YES
// timestamp: 1.603106047E12

package main;

import com.area9innovation.flow.*;

@SuppressWarnings("unchecked")
final class Module_simplifier {
	final main runtime;
	Module_simplifier(main runtime) {
		this.runtime = runtime;
	}
	Object[] f_extractArgs(Struct aar) {
		Struct l0__tmp = aar;
		switch (l0__tmp.getTypeId()) {
		case 8/*AlgDiv*/: {
			final Struct_AlgDiv l1__tmp = (Struct_AlgDiv)l0__tmp;
			final Struct l2_up = l1__tmp.f_up;
			final Struct l3_down = l1__tmp.f_down;
			final Struct l4_up = l1__tmp.f_up;
			final Struct l5_down = l1__tmp.f_down;
			return (new Object[] { l4_up, l5_down });
		}
		case 10/*AlgMin*/: {
			final Struct_AlgMin l1__tmp = (Struct_AlgMin)l0__tmp;
			final Struct l6_l = l1__tmp.f_l;
			final Struct l7_r = l1__tmp.f_r;
			final Struct l8_l = l1__tmp.f_l;
			final Struct l9_r = l1__tmp.f_r;
			return (new Object[] { l8_l, l9_r });
		}
		case 13/*AlgSum*/: {
			final Struct_AlgSum l1__tmp = (Struct_AlgSum)l0__tmp;
			final Struct l10_l = l1__tmp.f_l;
			final Struct l11_r = l1__tmp.f_r;
			final Struct l12_l = l1__tmp.f_l;
			final Struct l13_r = l1__tmp.f_r;
			return (new Object[] { l12_l, l13_r });
		}
		case 11/*AlgMult*/: {
			final Struct_AlgMult l1__tmp = (Struct_AlgMult)l0__tmp;
			final Struct l14_l = l1__tmp.f_l;
			final Struct l15_r = l1__tmp.f_r;
			final Struct l16_l = l1__tmp.f_l;
			final Struct l17_r = l1__tmp.f_r;
			return (new Object[] { l16_l, l17_r });
		}
		default: {
			return (new Object[] { aar });
		}
		}
	}
}
