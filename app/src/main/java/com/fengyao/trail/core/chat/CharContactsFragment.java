package com.fengyao.trail.core.chat;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fengyao.trail.R;
import com.fengyao.trail.base.BaseFragment;

/**
 * Created by Chen fengYao on 2015/9/4.
 */
public class CharContactsFragment extends BaseFragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_char_list, null);
        return view;
    }
}
