package com.example.chapter3.homework;


import android.animation.Animator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.airbnb.lottie.LottieAnimationView;


/**
 * A simple {@link Fragment} subclass.
 */
public class UsersFragment extends Fragment {

    private ListView listView;

    private LottieAnimationView animationView;


    public UsersFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_users, container, false);
        listView = view.findViewById(R.id.lv_users);
        animationView = view.findViewById(R.id.animation_view4start);

        listView.setAdapter(new ListViewAdapter(getActivity()));

        listView.setAlpha(0f);
        listView.setVisibility(View.VISIBLE);

        System.out.println("Fragment  "+"onCreateView-----------------");
        animationView.playAnimation();

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getView().postDelayed(new Runnable() {
            @Override
            public void run() {
                listView.animate()
                        .alpha(1f)
                        .setDuration(1000);

                animationView.animate()
                        .alpha(0f)
                        .setDuration(1000)
                        .setListener(new Animator.AnimatorListener() {
                            @Override
                            public void onAnimationStart(Animator animation) { }
                            @Override
                            public void onAnimationEnd(Animator animation) {
                                animationView.setVisibility(View.GONE);
                            }
                            @Override
                            public void onAnimationCancel(Animator animation) { }
                            @Override
                            public void onAnimationRepeat(Animator animation) { }
                        });

            }
        },2000);
    }
}
