package com.example.fishcompatibility;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FishListItemFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FishListItemFragment extends Fragment {

    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_INDEX = "index";

    private int mIndex;

    public int getShownIndex() {
        return mIndex;
    }

    public FishListItemFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param index Index of the content data to be displayed.
     * @return A new instance of fragment ListItemFragment.
     */
    public static FishListItemFragment newInstance(int index) {
        FishListItemFragment fragment = new FishListItemFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_INDEX, index);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mIndex = getArguments().getInt(ARG_INDEX);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflatedView =  inflater.inflate(R.layout.fragment_fish_list_item, container, false);

        TextView name = (TextView) inflatedView.findViewById(R.id.fishName);
        TextView scientificName = (TextView) inflatedView.findViewById(R.id.scientificName);
        TextView alias = (TextView) inflatedView.findViewById(R.id.alias);
        ImageView image = (ImageView) inflatedView.findViewById(R.id.fishImage);

        // TODO: Set the values using resource file

        return inflatedView;
    }
}