// HASH COLLISIONS: YES
// timestamp: 1.603774359242E12

package main;

import com.area9innovation.flow.*;

@SuppressWarnings("unchecked")
public final class Structs {

	// Structs array
	static final private Struct[] struct_list = {
			new Struct_Action(),
			new Struct_Action2(),
			new Struct_ActionCall(),
			new Struct_ActionCallDebug(),
			new Struct_ActionConstantInt(),
			new Struct_ActionConstantString(),
			SingletonStructs.str_ActionIndex,
			new Struct_ActionVar(),
			new Struct_AlgDiv(),
			new Struct_AlgDouble(),
			new Struct_AlgMin(),
			new Struct_AlgMult(),
			new Struct_AlgSum(),
			new Struct_AlgVar(),
			new Struct_BindMatched(),
			new Struct_BindResult(),
			new Struct_CharRange(),
			new Struct_Choices(),
			new Struct_Cons(),
			new Struct_CutDown(),
			new Struct_CutUp(),
			SingletonStructs.str_EmptyList,
			SingletonStructs.str_EmptyPopResult,
			SingletonStructs.str_Epsilon,
			new Struct_Grammar(),
			SingletonStructs.str_IllegalStruct,
			new Struct_IntTreeNode(),
			SingletonStructs.str_IntTreeNone,
			new Struct_IntTreeValue(),
			new Struct_JsonArray(),
			new Struct_JsonBool(),
			new Struct_JsonDouble(),
			SingletonStructs.str_JsonFieldIgnoreCase,
			new Struct_JsonFieldTreatAsPath(),
			SingletonStructs.str_JsonNull,
			new Struct_JsonObject(),
			new Struct_JsonString(),
			new Struct_KeyValue(),
			new Struct_LineColumn(),
			new Struct_LineResolver(),
			new Struct_LingoValue(),
			new Struct_Mono(),
			new Struct_Negation(),
			SingletonStructs.str_None,
			new Struct_OWASP(),
			new Struct_Opt(),
			new Struct_Pair(),
			new Struct_ParseConstants(),
			new Struct_ParseResult(),
			new Struct_PegAction(),
			new Struct_PegAction2(),
			SingletonStructs.str_PegActionIndex,
			new Struct_PegArray(),
			new Struct_PegBindIndex(),
			new Struct_PegBindString(),
			new Struct_PegBindValue(),
			SingletonStructs.str_PegBool,
			new Struct_PegCacheCall(),
			new Struct_PegCall(),
			SingletonStructs.str_PegCaptureList,
			SingletonStructs.str_PegCaptureStartList,
			new Struct_PegCaptureStringStart(),
			new Struct_PegChoice(),
			SingletonStructs.str_PegClearCache,
			new Struct_PegCodeConst(),
			new Struct_PegCommit(),
			SingletonStructs.str_PegDouble,
			SingletonStructs.str_PegDrop,
			SingletonStructs.str_PegEnd,
			new Struct_PegEnv(),
			new Struct_PegError(),
			SingletonStructs.str_PegFail,
			SingletonStructs.str_PegInt,
			new Struct_PegJump(),
			new Struct_PegRange(),
			new Struct_PegRangeChoice(),
			SingletonStructs.str_PegReturn,
			new Struct_PegRuleType(),
			new Struct_PegStackChoice(),
			new Struct_PegStackPc(),
			new Struct_PegStackPcCache(),
			SingletonStructs.str_PegStartCaptureList,
			SingletonStructs.str_PegStartString,
			new Struct_PegString(),
			new Struct_PegStringChoice(),
			SingletonStructs.str_PegStringType,
			new Struct_PegStruct(),
			new Struct_PegUnion(),
			SingletonStructs.str_PegUnknown,
			new Struct_PegVmCache(),
			new Struct_PegVmCacheItem(),
			SingletonStructs.str_PegVoid,
			new Struct_Plus(),
			new Struct_Poly(),
			new Struct_PopResult(),
			new Struct_PopSetResult(),
			new Struct_Production(),
			new Struct_Quadruple(),
			new Struct_RatFun(),
			new Struct_Rule(),
			new Struct_RuleResult(),
			new Struct_SemanticActions(),
			new Struct_Seq(),
			new Struct_Set(),
			new Struct_ShareAcc(),
			new Struct_Some(),
			new Struct_Star(),
			new Struct_Term(),
			SingletonStructs.str_TreeEmpty,
			new Struct_TreeNode(),
			new Struct_Triple(),
			new Struct_iRule()
	};
	static final Struct[] structList() {
		return struct_list;
	}
}
