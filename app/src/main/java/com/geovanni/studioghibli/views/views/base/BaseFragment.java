package com.geovanni.studioghibli.views.views.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.geovanni.studioghibli.views.bussiness.interfaces.IToolbarListener;

import butterknife.ButterKnife;

public abstract class BaseFragment extends Fragment {

    private View rootView;
    private Context context;
    private IToolbarListener toolbarListener;

    protected abstract int getLayoutResourceId();

    protected abstract String getCustomTag();

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
        try {
            toolbarListener = (IToolbarListener) context;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(getLayoutResourceId(), container, false);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    protected void updateToolbar(String title, int imageResource) {
        if (toolbarListener != null) {
            toolbarListener.updateToolbar(title, imageResource);
        }
    }
}
