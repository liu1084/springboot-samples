### 使用JNI（Java Native Interface）调用C/C++

1. 写java源代码

```java
package biz.llmall;
public class JavaCallC {
    //声明为native，准备调用C的方法
    public native void hellC();
    //加载c生成的共享库
    static {
        System.load("/Users/jim/Work/github/springboot-samples/java-call-C-sample/src/main/java/libhello.so");
    }
    public static void main(String[] args) {
        //调用
        new JavaCallC().hellC();
    }
}
```

2. 编译java源代码

```sh
javac biz/llmall/JavaCallC.java 

```

3. 根据编译好的java类生成c的header，然后根据header中的方法，写C源代码
```sh
javah biz.llmall.JavaCallC

```

```c
#include <stdio.h>
#include "jni.h"
#include "biz_llmall_JavaCallC.h"
JNIEXPORT void JNICALL Java_biz_llmall_JavaCallC_hellC
  (JNIEnv *, jobject){
    printf("hello world: from C++");
    return;
  }
```

4. 将C源代码编译为共享库

```shell
g++ -I/Library/Java/JavaVirtualMachines/jdk1.8.0_162.jdk/Contents/Home/include -I/Library/Java/JavaVirtualMachines/jdk1.8.0_162.jdk/Contents/Home/include/darwin/ -shared c.cpp -o libhello.so
```

5. 运行java代码

完成.