package com.gxg.demojiuxi6.mydemo6.materialviewpager.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.NestedScrollView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.florent37.materialviewpager.MaterialViewPagerHelper;
import com.gxg.demojiuxi6.mydemo6.R;

//import com.github.florent37.materialviewpager.sample.R;

//import butterknife.BindView;
import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by florentchampigny on 24/04/15.
 */
public class ScrollFragment extends Fragment {

    @Bind(R.id.scrollView)
    NestedScrollView mScrollView;

//    public static ScrollFragment newInstance() {
//        return new ScrollFragment();
//    }

   List<String> list= new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_scroll, container, false);


    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);



        MaterialViewPagerHelper.registerScrollView(getActivity(), mScrollView);
    }
}
