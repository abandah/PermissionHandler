package com.permission.handler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;

import com.permission.handler.PermissionListener;

public class PermisstionActivity extends AppCompatActivity {
    public static PermissionListener permissionListener;
    String accessCoarseLocation;
    private int index;

    public static  void setPermissionListener(PermissionListener permissionListener2) {
        permissionListener = permissionListener2;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permisstion);

        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                accessCoarseLocation= null;
            } else {
                accessCoarseLocation= extras.getString("access");
                index= extras.getInt("index");
            }
        } else {
            accessCoarseLocation= (String) savedInstanceState.getSerializable("access");
            index= (int) savedInstanceState.getSerializable("index");
        }
        int MyVersion = Build.VERSION.SDK_INT;
        if (MyVersion > Build.VERSION_CODES.LOLLIPOP_MR1) {
            if (!checkIfAlreadyhavePermission()) {
                requestForSpecificPermission();
            }else{
                permissionListener.onPermissionGranted(index);
            }
        }
    }
    private boolean checkIfAlreadyhavePermission() {
        int result = ContextCompat.checkSelfPermission(this, accessCoarseLocation);
        if (result == PackageManager.PERMISSION_GRANTED) {
            return true;
        } else {
            return false;
        }
    }
    private void requestForSpecificPermission() {
        ActivityCompat.requestPermissions(this, new String[]{accessCoarseLocation}, index);
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case 101:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    permissionListener.onPermissionGranted(index);
                    //granted
                } else {
                    permissionListener.onPermissionDenied(index);
                    //not granted
                }
                break;
            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
        finish();
    }
    @Override
    public void onBackPressed() {
    }


}
