#include "com_mingzz_code_TestNative.h"
#include <stdio.h>

JNIEXPORT void JNICALL Java_com_mingzz_code_TestNative_sayHello (JNIEnv *, jobject){
	printf("hello world");
}
