package com.thethtun.beta.yawthamamew.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import com.thethtun.beta.yawthamamew.R;
import com.thethtun.beta.yawthamamew.adapters.UnitConverterViewPagerAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link UnitConverterFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link UnitConverterFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class UnitConverterFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    @BindView(R.id.view_pager)
    ViewPager viewPager;

    @BindView(R.id.tabLayout)
    TabLayout tabLayout;

    private UnitConverterViewPagerAdapter unitConverterFragmentAdapter;

    private Unbinder unbinder;

    public UnitConverterFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment UnitConverterFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static UnitConverterFragment newInstance(String param1, String param2) {
        UnitConverterFragment fragment = new UnitConverterFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        unitConverterFragmentAdapter = new UnitConverterViewPagerAdapter(getActivity().getSupportFragmentManager());
        unitConverterFragmentAdapter.addTab(new LengthAreaWeightVolumeFragment(), "Tab One");
        unitConverterFragmentAdapter.addTab(new UnitConverterFragment(), "Tab Two");

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_unit_converter, container, false);

        ButterKnife.bind(this, rootView);

        viewPager.setAdapter(unitConverterFragmentAdapter);
        tabLayout.setupWithViewPager(viewPager);
        return rootView;
    }

}
