package com.example.fishcompatibility;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FishFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FishFragment extends Fragment implements View.OnClickListener {

    // the fragment initialization parameters
    private static final String ARG_FISH = "fish";
    private static final String ARG_IS_TANK = "isTank";
    private Fish mFish;
    private int mCounter = 1;
    private boolean mIsTank = false;
    private TextView mCounterText;
    private TextView mPopText;

    public Fish getShownFish() {
        return mFish;
    }

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
            mIsTank = getArguments().getBoolean(ARG_IS_TANK);
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
            LinearLayout counterLayout = (LinearLayout) inflatedView
                    .findViewById(R.id.counterLayout);
            counterLayout.setVisibility(View.VISIBLE);

            mCounterText = (TextView) inflatedView.findViewById(R.id.counter);
            mCounterText.setText(String.valueOf(mCounter));

            Button mPlusButton = (Button) inflatedView.findViewById(R.id.plusButton);
            mPlusButton.setOnClickListener(this);
            Button mMinusButton = (Button) inflatedView.findViewById(R.id.minusButton);
            mMinusButton.setOnClickListener(this);

            mPopText = (TextView) inflatedView.findViewById(R.id.popError);
            checkPopulation();
        }

        return inflatedView;
    }

    @Override
    public void onClick(View view) {
        mPopText.setVisibility(View.INVISIBLE);

        switch (view.getId()) {
            case R.id.plusButton:
                mCounter++;
                mCounterText.setText(String.valueOf(mCounter));
                break;
            case R.id.minusButton:
                mCounter--;

                if (mCounter == 0) {
                    ((TankActivity) getActivity())
                            .removeFragment(getParentFragmentManager(), getId());
                } else {
                    mCounterText.setText(String.valueOf(mCounter));
                }

                break;
            default:
                break;
        }

        checkPopulation();
    }

    /**
     *  Checks if counter is within the population range
     */
    private void checkPopulation() {
        if (mCounter != 0 && mCounter < mFish.getMinPop()) {
            mPopText.setText("Not enough of this fish in the tank");
            mPopText.setVisibility(View.VISIBLE);
        } else if (mFish.getMaxPop() != 0 && mCounter > mFish.getMaxPop()) {
            mPopText.setText("Too many of this fish in the tank");
            mPopText.setVisibility(View.VISIBLE);
        }
    }
}