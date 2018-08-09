package biz.llmall;
public class JavaCallC {
    public native void hellC();
    static {
        System.load("/Users/jim/Work/github/springboot-samples/java-call-C-sample/src/main/java/libhello.so");
    }
    public static void main(String[] args) {
        new JavaCallC().hellC();
    }
}
