package com.permission.test;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.permission.handler.Perm;
import com.permission.handler.PermissionListener;


public class BlankFragment extends Fragment implements PermissionListener {

    public BlankFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_blank, container, false);
        v.findViewById(R.id.start_but).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                askPerm();


            }
        });
        return v;
    }

    private void askPerm() {
        Perm.With(this).ACCESS_COARSE_LOCATION().Run(101);
    }

    @Override
    public void onPermissionGranted(int index) {
        Toast.makeText(getActivity(), "Fragment  onPermissionGranted", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPermissionDenied(int index) {
        Toast.makeText(getActivity(), "Fragment  onPermissionDenied", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onPermissionRationaleShouldBeShown(int index) {
        Toast.makeText(getActivity(), "Fragment  onPermissionRationaleShouldBeShown", Toast.LENGTH_SHORT).show();
    }
}


