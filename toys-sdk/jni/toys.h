#include <jni.h>
#include <string.h>
#include <stdio.h>
#include <android/log.h>
#include <string>
#include <js.h>
#define  TAG    "NativeGame"
#define LOGI(...) __android_log_print(ANDROID_LOG_INFO,TAG,__VA_ARGS__)
// 定义debug信息
#define LOGD(...) __android_log_print(ANDROID_LOG_DEBUG, TAG, __VA_ARGS__)
// 定义error信息
#define LOGE(...) __android_log_print(ANDROID_LOG_ERROR,TAG,__VA_ARGS__)
#define JNIREG_CLASS "com/toys/sdk/NativeGame"//指定要注册的类

