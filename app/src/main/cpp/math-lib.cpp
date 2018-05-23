#include <jni.h>
#include <string>

extern "C" JNIEXPORT jint JNICALL
Java_br_com_nvsistemas_parsec_Math_sum(JNIEnv *env, jobject /* this */, jint num1, jint num2) {
    return (num1+num2);
}

extern "C" JNIEXPORT jint JNICALL
Java_br_com_nvsistemas_parsec_Math_multiply(JNIEnv *env, jobject /* this */, jint num1, jint num2) {
    return (num1*num2);
}


