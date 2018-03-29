package com.application;



import android.app.Application;

public class AppCtx extends Application{
	private static AppCtx mAppCtx=null;
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		

        //mDefaultHandler = Thread.getDefaultUncaughtExceptionHandler();
     //  Thread.setDefaultUncaughtExceptionHandler(CrashHandler.getInstance(this, mDefaultHandler));
		mAppCtx=this;
	}
	public static AppCtx getInstance() {
		return mAppCtx;
	}
	

	
	
}
