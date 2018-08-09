package com.jim.jvm.jvmstack;
public class JavaVMStackSOF {
    private static int stackLength = 1;
    public void stackLeek(){
        stackLength++;
        stackLeek();
    }

    public static void main(String[] args) {
        try {

            JavaVMStackSOF sof = new JavaVMStackSOF();
            sof.stackLeek();
        } catch (Throwable e){
            System.out.println("stack length: " + stackLength );
            throw e;
        }
    }
}
