package rs.aleph.android.example12.fragments;

import android.app.Fragment;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;

import rs.aleph.android.example12.R;
import rs.aleph.android.example12.provider.JeloProvider;

/**
 * Created by user on 8.2.2017..
 */

public class DetailFragment extends Fragment {
    private int position;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if (savedInstanceState != null) {
            position = savedInstanceState.getInt("position", 0);
        }

        fillContent(position);
    }

    @Override
    public void onSaveInstanceState (Bundle outState) {
        super. onSaveInstanceState(outState);
        outState.putInt("position", position);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstancetate){
        View view = inflater.inflate(R.layout.fragment_detail, container, false);

        return view;
    }

    private void fillContent(final int position) {
        ImageView ivImage = (ImageView) getView().findViewById(R.id.iv_image);
        InputStream is = null;
        try {
            is = getActivity().getAssets().open(JeloProvider.getJeloById(position).getSlika());
            Drawable drawable = Drawable.createFromStream(is, null);
            ivImage.setImageDrawable(drawable);
        }catch (IOException e) {
            e.printStackTrace();
        }


    }



}
