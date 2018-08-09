#include <stdio.h>
#include "jni.h"
#include "biz_llmall_JavaCallC.h"
JNIEXPORT void JNICALL Java_biz_llmall_JavaCallC_hellC
  (JNIEnv *, jobject){
    printf("hello world: from C++");
    return;
  }