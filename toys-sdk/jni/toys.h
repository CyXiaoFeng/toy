#include <jni.h>
#include <string.h>
#include <stdio.h>
#include <android/log.h>
#include <string>
#include <js.h>
#define  TAG    "NativeGame"
#define LOGI(...) __android_log_print(ANDROID_LOG_INFO,TAG,__VA_ARGS__)
// ����debug��Ϣ
#define LOGD(...) __android_log_print(ANDROID_LOG_DEBUG, TAG, __VA_ARGS__)
// ����error��Ϣ
#define LOGE(...) __android_log_print(ANDROID_LOG_ERROR,TAG,__VA_ARGS__)
#define JNIREG_CLASS "com/toys/sdk/NativeGame"//ָ��Ҫע�����

