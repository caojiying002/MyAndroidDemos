#include <jni.h>
#include <string>

extern "C" JNIEXPORT jstring JNICALL
Java_com_example_myndkapplication_MainActivity_stringFromJNI(
        JNIEnv *env,
        jobject /* this */) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}

//extern "C" JNIEXPORT jstring JNICALL
//short_stringFromJNI(
//        JNIEnv *env,
//        jobject /* this */) {
//    std::string hello = "Hello from D++";
//    return env->NewStringUTF(hello.c_str());
//}

extern "C" JNIEXPORT void JNICALL
nativeFoo(JNIEnv *env, jobject /* this */) {
}

extern "C" JNIEXPORT jboolean JNICALL
nativeBar(JNIEnv *env, jobject /* this */, jstring string, jint num) {
    bool b = num > 5;
    return static_cast<jboolean>(b);
}

JNIEXPORT jint JNI_OnLoad(JavaVM* vm, void* reserved) {
    JNIEnv* env;
    if (vm->GetEnv(reinterpret_cast<void**>(&env), JNI_VERSION_1_6) != JNI_OK) {
        return JNI_ERR;
    }

    // Find your class. JNI_OnLoad is called from the correct class loader context for this to work.
    jclass c = env->FindClass("com/example/myndkapplication/MainActivity");
    if (c == nullptr) return JNI_ERR;

    // Register your class' native methods.
    static const JNINativeMethod methods[] = {
            // {"stringFromJNI", "()Ljava/lang/String;", reinterpret_cast<void *>(short_stringFromJNI)},
            {"nativeFoo", "()V", reinterpret_cast<void *>(nativeFoo)},
            {"nativeBar", "(Ljava/lang/String;I)Z", reinterpret_cast<void *>(nativeBar)},
    };
    int rc = env->RegisterNatives(c, methods, sizeof(methods)/sizeof(JNINativeMethod));
    if (rc != JNI_OK) return rc;

    return JNI_VERSION_1_6;
}
