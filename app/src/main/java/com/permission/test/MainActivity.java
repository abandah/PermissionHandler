package com.permission.test;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;


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
        Fragment f = new BlankFragment();
       getFragmentManager().beginTransaction().replace(R.id.FragmentContainer, f).commit();

    }

    private void askPerm() {
        Perm.With(this).ACCESS_COARSE_LOCATION().Run(101);
    }

    @Override
    public void onPermissionGranted(int index) {
        Toast.makeText(this, "MainActivity  onPermissionGranted", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPermissionDenied(int index) {
        Toast.makeText(this, "MainActivity  onPermissionDenied", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onPermissionRationaleShouldBeShown(int index) {
        Toast.makeText(this, "MainActivity  onPermissionRationaleShouldBeShown", Toast.LENGTH_SHORT).show();
    }
}
