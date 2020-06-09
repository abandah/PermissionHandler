package com.permission.handler;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;

import androidx.annotation.RequiresPermission;
import androidx.core.content.ContextCompat;

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
        }
        else if(listener instanceof androidx.fragment.app.Fragment){
            Perm p = new Perm(((androidx.fragment.app.Fragment)listener).getActivity());
            p.setPermissionListener(listener);
            return p;
        }
        else if(listener instanceof android.app.Fragment){
            Perm p = new Perm(((android.app.Fragment)listener).getActivity());
            p.setPermissionListener(listener);
            return p;
        }
        return  null;

    }
    public Perm withPermission(String accessCoarseLocation) {
        this.setAccessCoarseLocation(accessCoarseLocation);
        return this;
    }
    @RequiresPermission(Manifest.permission.ACCESS_COARSE_LOCATION)
    public Perm ACCESS_COARSE_LOCATION() {
        this.setAccessCoarseLocation(Manifest.permission.ACCESS_COARSE_LOCATION);
        return this;
    }
    @RequiresPermission(Manifest.permission.ACCESS_FINE_LOCATION)
    public Perm ACCESS_FINE_LOCATION() {
        this.setAccessCoarseLocation(Manifest.permission.ACCESS_FINE_LOCATION);
        return this;
    }
    @RequiresPermission(Manifest.permission.ADD_VOICEMAIL)
    public Perm ADD_VOICEMAIL() {
        this.setAccessCoarseLocation(Manifest.permission.ADD_VOICEMAIL);
        return this;
    }
    @RequiresPermission(Manifest.permission.BODY_SENSORS)
    public Perm BODY_SENSORS() {
        this.setAccessCoarseLocation(Manifest.permission.BODY_SENSORS);
        return this;
    }
    @RequiresPermission(Manifest.permission.CALL_PHONE)
    public Perm CALL_PHONE() {
        this.setAccessCoarseLocation(Manifest.permission.CALL_PHONE);
        return this;
    }
    @RequiresPermission(Manifest.permission.CAMERA)
    public Perm CAMERA() {
        this.setAccessCoarseLocation(Manifest.permission.CAMERA);
        return this;
    }
    @RequiresPermission(Manifest.permission.GET_ACCOUNTS)
    public Perm GET_ACCOUNTS() {
        this.setAccessCoarseLocation(Manifest.permission.GET_ACCOUNTS);
        return this;
    }
    @RequiresPermission(Manifest.permission.PROCESS_OUTGOING_CALLS)
    public Perm PROCESS_OUTGOING_CALLS() {
        this.setAccessCoarseLocation(Manifest.permission.PROCESS_OUTGOING_CALLS);
        return this;
    }
    @RequiresPermission(Manifest.permission.READ_CALENDAR)
    public Perm READ_CALENDAR() {
        this.setAccessCoarseLocation(Manifest.permission.READ_CALENDAR);
        return this;
    }
    @RequiresPermission(Manifest.permission.READ_CALL_LOG)
    public Perm READ_CALL_LOG() {
        this.setAccessCoarseLocation(Manifest.permission.READ_CALL_LOG);
        return this;
    }
    @RequiresPermission(Manifest.permission.READ_CONTACTS)
    public Perm READ_CONTACTS() {
        this.setAccessCoarseLocation(Manifest.permission.READ_CONTACTS);
        return this;
    }
    @RequiresPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
    public Perm READ_EXTERNAL_STORAGE() {
        this.setAccessCoarseLocation(Manifest.permission.READ_EXTERNAL_STORAGE);
        return this;
    }
    @RequiresPermission(Manifest.permission.READ_SMS)
    public Perm READ_SMS() {
        this.setAccessCoarseLocation(Manifest.permission.READ_SMS);
        return this;
    }
    @RequiresPermission(Manifest.permission.RECEIVE_MMS)
    public Perm RECEIVE_MMS() {
        this.setAccessCoarseLocation(Manifest.permission.RECEIVE_MMS);
        return this;
    }
    @RequiresPermission(Manifest.permission.RECEIVE_SMS)
    public Perm RECEIVE_SMS() {
        this.setAccessCoarseLocation(Manifest.permission.RECEIVE_SMS);
        return this;
    }
    @RequiresPermission(Manifest.permission.RECEIVE_WAP_PUSH)
    public Perm RECEIVE_WAP_PUSH() {
        this.setAccessCoarseLocation(Manifest.permission.RECEIVE_WAP_PUSH);
        return this;
    }
    @RequiresPermission(Manifest.permission.RECORD_AUDIO)
    public Perm RECORD_AUDIO() {
        this.setAccessCoarseLocation(Manifest.permission.RECORD_AUDIO);
        return this;
    }
    @RequiresPermission(Manifest.permission.READ_PHONE_STATE)
    public Perm READ_PHONE_STATE() {
        this.setAccessCoarseLocation(Manifest.permission.READ_PHONE_STATE);
        return this;
    }
    @RequiresPermission(Manifest.permission.SEND_SMS)
    public Perm SEND_SMS() {
        this.setAccessCoarseLocation(Manifest.permission.SEND_SMS);
        return this;
    }
    @RequiresPermission(Manifest.permission.USE_SIP)
    public Perm USE_SIP() {
        this.setAccessCoarseLocation(Manifest.permission.USE_SIP);
        return this;
    }
    @RequiresPermission(Manifest.permission.WRITE_CALENDAR)
    public Perm WRITE_CALENDAR() {
        this.setAccessCoarseLocation(Manifest.permission.WRITE_CALENDAR);
        return this;
    }
    @RequiresPermission(Manifest.permission.WRITE_CALL_LOG)
    public Perm WRITE_CALL_LOG() {
        this.setAccessCoarseLocation(Manifest.permission.WRITE_CALL_LOG);
        return this;
    }
    @RequiresPermission(Manifest.permission.WRITE_CONTACTS)
    public Perm WRITE_CONTACTS() {
        this.setAccessCoarseLocation(Manifest.permission.WRITE_CONTACTS);
        return this;
    }
    @RequiresPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)
    public Perm WRITE_EXTERNAL_STORAGE() {
        this.setAccessCoarseLocation(Manifest.permission.WRITE_EXTERNAL_STORAGE);
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
