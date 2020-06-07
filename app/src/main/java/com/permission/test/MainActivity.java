package com.permission.test;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.permission.handler.Perm;
import com.permission.handler.PermissionListener;

public class MainActivity extends Activity implements PermissionListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.start_but).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                askPerm();


            }
        });
    }

    private void askPerm() {
        Perm.With(this).ACCESS_COARSE_LOCATION().Run(101);
    }

    @Override
    public void onPermissionGranted(int index) {

    }

    @Override
    public void onPermissionDenied(int index) {

    }

    @Override
    public void onPermissionRationaleShouldBeShown(int index) {

    }
}
