package com.example.fishcompatibility;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.appcompat.content.res.AppCompatResources;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FishFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FishFragment extends Fragment {

    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_FISH = "fish";
    private static final String ARG_IS_TANK = "isTank";

    private Fish mFish;
    private int mCounter = 0;
    private boolean mIsTank = false;

    public Fish getShownFish() {
        return mFish;
    }
    public int getCounter() { return mCounter; }

    public FishFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param fish fish that needs to be displayed.
     * @return A new instance of fragment FishFragment.
     */
    public static FishFragment newInstance(Fish fish, boolean isTank) {
        FishFragment fragment = new FishFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_FISH, fish);
        args.putBoolean(ARG_IS_TANK, isTank);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mFish = getArguments().getParcelable(ARG_FISH);

            if (mIsTank) {
                mIsTank = getArguments().getBoolean(ARG_IS_TANK);
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflatedView = inflater.inflate(R.layout.fragment_fish, container, false);

        if (mFish != null) {
            TextView fishName = (TextView) inflatedView.findViewById(R.id.fishName);
            fishName.setText(mFish.getName());

            TextView sciName = (TextView) inflatedView.findViewById(R.id.scientificName);
            sciName.setText(mFish.getSciName());

            ImageView image = (ImageView) inflatedView.findViewById(R.id.fishImage);
            String imageUrl = mFish.getImageUrl();
            String drawableSource = "@drawable/" + imageUrl;
            int imageRes = getActivity().getResources().getIdentifier(drawableSource, null, getActivity().getPackageName());
            Drawable drawable = AppCompatResources.getDrawable(getActivity(), imageRes);
            image.setImageDrawable(drawable);
        }

        if (mIsTank) {
            // TODO: Display number of fish
            // TODO: Display + - buttons
        }

        return inflatedView;
    }

    // TODO: Create method/s to increase and decrease the counter when buttons are clicked
}