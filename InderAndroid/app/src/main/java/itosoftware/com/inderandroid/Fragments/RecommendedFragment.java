package itosoftware.com.inderandroid.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import itosoftware.com.inderandroid.R;

public class RecommendedFragment extends Fragment {
    View rootView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_recommended, container, false);

        Log.d("Aqui", "ingresa");

        return rootView;
    }
}