package com.permission.handler;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.permission.handler.PermissionListener;

/**
 * Created by Abandah on 12/9/2019.
 */
public class Perm implements PermissionListener {

    private Activity activity;
    private String accessCoarseLocation;
    private PermissionListener permissionListener;

    private Perm(Activity activity) {
        this.activity = activity;
    }

   /* public static Perm With(Activity context) {
        Perm p = new Perm((Activity) context);
        if (context instanceof PermissionListener)
            p.setPermissionListener((PermissionListener) context);


        return p;
    }*/

   /* public static Perm With(Fragment context) {
        Perm p = new Perm((Activity) context.getActivity());
        if (context instanceof PermissionListener)
            p.setPermissionListener((PermissionListener) context);
        return p;
    }*/

  /*  public static Perm With(PermissionListener listener, Fragment context) {
        Perm p = new Perm(context.getActivity());
        p.setPermissionListener(listener);
        return p;
    }*/
    public static Perm With(PermissionListener listener) {
        if(listener instanceof Activity){
            Perm p = new Perm((Activity) listener);
            p.setPermissionListener((PermissionListener) listener);
            return p;
        }if(listener instanceof Fragment){
            Perm p = new Perm(((Fragment)listener).getActivity());
            p.setPermissionListener(listener);
            return p;
        }
        return  null;

    }
    public Perm withPermission(String accessCoarseLocation) {
        this.setAccessCoarseLocation(accessCoarseLocation);
        return this;
    }

    public Perm ACCESS_COARSE_LOCATION() {
        this.setAccessCoarseLocation(Manifest.permission.ACCESS_COARSE_LOCATION);
        return this;
    }

    private void setAccessCoarseLocation(String accessCoarseLocation) {
        this.accessCoarseLocation = accessCoarseLocation;
    }

    public Perm withListener(PermissionListener permissionListener) {
        setPermissionListener(permissionListener);
        return this;
    }

    public void setPermissionListener(PermissionListener permissionListener) {
        this.permissionListener = permissionListener;
    }

    public void Run(int index) {
        if (!checkIfAlreadyhavePermission()) {
            PermisstionActivity.setPermissionListener(this);
            Intent i = new Intent(activity, PermisstionActivity.class);
            i.putExtra("access", accessCoarseLocation);
            i.putExtra("index", index);
            activity.startActivity(i);
        } else {
            if (permissionListener != null)
                permissionListener.onPermissionGranted(index);
        }
    }

    private boolean checkIfAlreadyhavePermission() {
        int result = ContextCompat.checkSelfPermission(activity, accessCoarseLocation);
        if (result == PackageManager.PERMISSION_GRANTED) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void onPermissionGranted(int index) {
        if (permissionListener != null)
            permissionListener.onPermissionGranted(index);
    }

    @Override
    public void onPermissionDenied(int index) {
        if (permissionListener != null)
            permissionListener.onPermissionDenied(index);
    }

    @Override
    public void onPermissionRationaleShouldBeShown(int index) {
        if (permissionListener != null)
            permissionListener.onPermissionRationaleShouldBeShown(index);
    }


}
