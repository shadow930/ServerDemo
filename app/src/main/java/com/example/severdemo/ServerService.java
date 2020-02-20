package com.example.severdemo;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;


public class ServerService extends Service {
    private MySchoolBinder mySchoolBinder;

    public ServerService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.d("schoolText",intent.getAction());
        return mySchoolBinder;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mySchoolBinder = new MySchoolBinder();
    }


    private class MySchoolBinder extends ISchool.Stub {
        @Override
        public String getSchoolName() {
            return "杨汉中学";
        }

        @Override
        public int getStudentNum() {
            return 3000;
        }

        @Override
        public Student getStudent() {
            Student student = new Student();
            student.setName("jack");
            student.setAge(18);
            return student;
        }
    }
}
