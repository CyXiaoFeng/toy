#include <toys.h>
void start() {
	LOGI("Java_com_toys_sdk_NativeGame_start");
}
void init() {
	LOGI("Java_com_toys_sdk_NativeGame_init");
}

static void initGame(JNIEnv* env, jobject jobj, jobject webview) {
	LOGI("Java_com_toys_sdk_NativeGame_initGame");
//	char* js = "function checkInit(){ if (!window.init) requestAnimationFrame(checkInit); else window.init(); start();} checkInit();";
	jclass cls = env->GetObjectClass(webview);
	jmethodID mthd = env->GetMethodID(cls, "loadUrl", "(Ljava/lang/String;)V");
	if(mthd == 0 || NULL == webview) {
		LOGE("jmethodID native_str1 error");
		return;
	}
	const char* js = CONST_JS.data();
	LOGE("%s", js);
	jstring url = env->NewStringUTF(js);
	env->CallVoidMethod(webview,mthd,url);

}

void startGame(JNIEnv* env, jobject jobj, jobject thiz) {

	//jclass rela = env->GetObjectClass(thiz);
	jclass native_clazz = env->FindClass("com/toys/example/R$id");

	jfieldID fieldID_webview = env->GetStaticFieldID(native_clazz, "att_wv", "I");
	jint str1 = env->GetStaticIntField(native_clazz, fieldID_webview);

	LOGI("str is %d", str1);
	jclass native_str1_1 = env->GetObjectClass(thiz);//env->FindClass("android/app/Activity");
	if (native_str1_1 == 0) {
		LOGI("FindClass native_str1 error");
		return;
	}



	jmethodID methodID_manager = env->GetMethodID(native_str1_1, "getFragmentManager",
				"()Landroid/app/FragmentManager;");


	if(methodID_manager == 0) {
		LOGI("GetMethodID methodID_manager error");
		return;
	}

	jobject manager_obj = env->CallObjectMethod(thiz, methodID_manager);


	if(manager_obj == 0) {
		LOGI("GetMethodID methodID_manager error");
		return;
	}

	jclass frag_class = env->FindClass("android/app/FragmentManager");

	jmethodID methodID_mana = env->GetMethodID(frag_class, "findFragmentByTag",
					"(Ljava/lang/String;)Landroid/app/Fragment;");

	jstring frgtag =  env->NewStringUTF("frg");
	if(methodID_mana == 0) {
		LOGI("GetMethodID methodID_mana error");
				return;
	}

	jobject frg_view = env->CallObjectMethod(manager_obj, methodID_mana, frgtag);

	if(frg_view == 0) {
		LOGI("GetMethodID frg_view error");
				return;
	}
	jclass frag_in_class = env->FindClass("android/app/Fragment");

	jmethodID frg_in_viewID = env->GetMethodID(frag_in_class, "getView",
						"()Landroid/view/View;");

	jobject frg_in_view = env->CallObjectMethod(frg_view, frg_in_viewID);

	if(frg_in_view == NULL) {
		LOGI("GetMethodID methodID_func error");
				return;
	}

	jclass view_class = env->FindClass("android/view/View");

	jmethodID methodID_str1 = env->GetMethodID(view_class, "findViewById",
			"(I)Landroid/view/View;");


	if (methodID_str1 == 0) {
		LOGI("GetMethodID methodID_func error");
		return;
	}

	jclass native_WebView = env->FindClass("android/webkit/WebView");

	jmethodID methodID_WebView = env->GetMethodID(native_WebView,
			"loadUrl","(Ljava/lang/String;)V");

	if (methodID_WebView == 0) {
		LOGI("GetMethodID methodID_func error");
		return;
	}

	jobject webview_obj = env->CallObjectMethod(frg_in_view, methodID_str1, str1);
	if (webview_obj == 0) {
		LOGI("FindClass native_WebView error");
		return;
	}
	/*jstring url = env->NewStringUTF("http://www.baidu.com");
	env->CallVoidMethod(webview_obj, methodID_WebView, url);*/


}
#ifdef __cplusplus
extern "C" {
#endif
	JNINativeMethod const nativeMethod[] {
			{"init", "()V", (void*)init},
			{"start", "()V", (void*)start},
			{"initGame", "(Landroid/webkit/WebView;)V", (void*)initGame},
			{"startGame", "(Landroid/content/Context;)V", (void*)startGame}
	};

	JNIEXPORT jint JNICALL JNI_OnLoad(JavaVM *jvm, void *reserved) {
		LOGE("JNI_OnLoad");
		JNIEnv* env;
		if (jvm->GetEnv((void**) &env, JNI_VERSION_1_4) != JNI_OK) {
		   return -1;

		}
		env->RegisterNatives(env->FindClass(JNIREG_CLASS), nativeMethod,
				sizeof(nativeMethod)/sizeof(nativeMethod[0]));
		return JNI_VERSION_1_4;


	}
}

/*
#ifdef __cplusplus
extern "C" {
#endif

  JNIEXPORT void JNICALL Java_com_toys_sdk_NativeGame_start(JNIEnv *jenv, jclass jcls) {

	  LOGI("Java_com_toys_sdk_NativeGame_start");
  }

  JNIEXPORT void JNICALL Java_com_toys_sdk_NativeGame_init(
  	        JNIEnv* env, jobject jobj) {
  	LOGI("Java_com_toys_sdk_NativeGame_init");

  }
}*/

