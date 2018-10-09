#include <jni.h>
#include <string>
#include <iostream>
#include <cmath>
#include "mpParser.h"
#include "mpDefines.h"

using namespace std;
using namespace mup;

Value Calc(string input) {
    ParserX parser(pckALL_NON_COMPLEX);

    Value ans;
    parser.DefineVar(_T("ans"), Variable(&ans));

    try
    {
        parser.SetExpr(input);
        ans = parser.Eval();

        return ans;
    }
    catch(ParserError &e)
    {
        if (e.GetPos() != -1) {
            string_type error = "Error: ";
            error.append(e.GetMsg());
            return error;
        }
    }
    catch(std::runtime_error &)
    {
        string_type error = "Error: Runtime error";
        return error;
    }
    return ans;
}

jstring CalcJson(JNIEnv *env, string input) {
    ParserX parser(pckALL_NON_COMPLEX);

    Value ans;
    parser.DefineVar(_T("ans"), Variable(&ans));

    stringstream_type ss;

    ss << _T("{");

    try
    {
        parser.SetExpr(input);
        ans = parser.Eval();

        ss << _T("\"val\": \"") << ans.AsString() << _T("\"");
        ss << _T(",\"type\": \"") << ans.GetType() << _T("\"");
    }
    catch(ParserError &e)
    {
        if (e.GetPos() != -1) {
            string_type error = e.GetMsg();
            ss << _T("\"error\": \"") << error << _T("\"");
        }
    }

    ss << _T("}");

    return env->NewStringUTF(ss.str().c_str());
}

extern "C" JNIEXPORT jstring JNICALL
Java_br_com_nvsistemas_parsec_Parsec_nativeEval(JNIEnv *env, jobject /* this */, jstring input) {
    const char *inputChars = env->GetStringUTFChars(input, NULL);

    Value ans = Calc(string(inputChars));
    return env->NewStringUTF(ans.AsString().c_str());
}

extern "C" JNIEXPORT jstring JNICALL
Java_br_com_nvsistemas_parsec_Parsec_nativeEvalJson(JNIEnv *env, jobject /* this */, jstring input) {
    const char *inputChars = env->GetStringUTFChars(input, NULL);
    return CalcJson(env, string(inputChars));
}


