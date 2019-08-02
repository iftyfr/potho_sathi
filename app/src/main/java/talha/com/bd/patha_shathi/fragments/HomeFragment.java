package talha.com.bd.patha_shathi.fragments;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import talha.com.bd.patha_shathi.R;
import talha.com.bd.patha_shathi.activities.AvailablePsActivity;
import talha.com.bd.patha_shathi.activities.HarassmentActivity;
import talha.com.bd.patha_shathi.activities.MyPathasathis;
import talha.com.bd.patha_shathi.activities.UserImageCaptureActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    ImageView camera, myPathasathi, anyOneThere, help;


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        camera = view.findViewById(R.id.camera);
        myPathasathi = view.findViewById(R.id.myPathasathi);
        anyOneThere = view.findViewById(R.id.anyOneThere);
        help = view.findViewById(R.id.help);


        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), UserImageCaptureActivity.class));
            }
        });

        myPathasathi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), MyPathasathis.class));
            }
        });

        anyOneThere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), AvailablePsActivity.class));
            }
        });

        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), HarassmentActivity.class));
            }
        });

        return view;
    }



}
