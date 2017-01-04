package com.mingzz.code;

public class TestNative {
	// 首先在java类中声明一个native方法
	public native void sayHello();
	// 然后使用javah命令生成一个包含native方法定义的c/c++头文件 javah com.mingzz.code.TestNative
	// 按照生成的c/c++头文件来编写c/c+=代码
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.loadLibrary("JNI_SayHello");
		TestNative tn = new TestNative();
		tn.sayHello();
	}

}
