package com.permission.handler;

/**
 * Created by Abandah on 12/9/2019.
 */
public interface PermissionListener {
    void onPermissionGranted(int index);

    void onPermissionDenied(int index);

    void onPermissionRationaleShouldBeShown(int index);


}
