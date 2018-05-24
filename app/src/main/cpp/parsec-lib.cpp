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
    return ans;
}

extern "C" JNIEXPORT jstring JNICALL
Java_br_com_nvsistemas_parsec_Parsec_nativeEval(JNIEnv *env, jobject /* this */, jstring input) {
    const char *inputChars = env->GetStringUTFChars(input, NULL);

    Value ans = Calc(string(inputChars));
    return env->NewStringUTF(ans.AsString().c_str());
}


