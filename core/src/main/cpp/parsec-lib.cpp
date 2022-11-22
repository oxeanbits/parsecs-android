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

void replaceAll(std::string& source, const std::string& from, const std::string& to) {
    std::string newString;
    newString.reserve(source.length());  // avoids a few memory allocations

    std::string::size_type lastPos = 0;
    std::string::size_type findPos;

    while(std::string::npos != (findPos = source.find(from, lastPos)))
    {
        newString.append(source, lastPos, findPos - lastPos);
        newString += to;
        lastPos = findPos + from.length();
    }

    // Care for the rest after last occurrence
    newString += source.substr(lastPos);

    source.swap(newString);
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

        std::string ansString = ans.ToString();

        replaceAll(ansString, "\"", "\\\"");

        ss << _T("\"val\": \"") << ansString << _T("\"");
        ss << _T(",\"type\": \"") << ans.GetType() << _T("\"");
    }
    catch(ParserError &e)
    {
        if (e.GetPos() != -1) {
            string_type error = e.GetMsg();
            ss << _T("\"error\": \"") << error << _T("\"");
        }
    }
    catch(std::runtime_error &)
    {
        string_type error = "Error: Runtime error";
        ss << _T("\"error\": \"") << error << _T("\"");
    }

    ss << _T("}");

    return env->NewStringUTF(ss.str().c_str());
}

jobjectArray CalcJsonArray(JNIEnv *env, jobjectArray input) {
    int len = env->GetArrayLength(input);
    jobjectArray result = env->NewObjectArray(len, env->FindClass("java/lang/String"), nullptr);

    for(int i = 0; i < len; i++) {
        auto inputString = (jstring) env->GetObjectArrayElement(input, i);
        jstring resultString = CalcJson(env, env->GetStringUTFChars(inputString, nullptr));
        env->SetObjectArrayElement(result, i, resultString);
    }

    return result;
}

extern "C" JNIEXPORT jstring JNICALL
Java_br_com_nvsistemas_parsec_Parsec_nativeEval(JNIEnv *env, jobject /* this */, jstring input) {
    const char *inputChars = env->GetStringUTFChars(input, NULL);

    Value ans = Calc(string(inputChars));
    return env->NewStringUTF(ans.ToString().c_str());
}

extern "C" JNIEXPORT jstring JNICALL
Java_br_com_nvsistemas_parsec_Parsec_nativeEvalJson(JNIEnv *env, jobject /* this */, jstring input) {
    const char *inputChars = env->GetStringUTFChars(input, NULL);
    return CalcJson(env, string(inputChars));
}

extern "C" JNIEXPORT jobjectArray JNICALL
Java_br_com_nvsistemas_parsec_Parsec_nativeEvalJsonArray(JNIEnv *env, jobject /* this */, jobjectArray input) {
    return CalcJsonArray(env, input);
}


