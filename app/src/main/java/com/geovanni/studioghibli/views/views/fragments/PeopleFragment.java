package com.geovanni.studioghibli.views.views.fragments;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.geovanni.studioghibli.R;
import com.geovanni.studioghibli.views.bussiness.interfaces.IProgressLayout;
import com.geovanni.studioghibli.views.bussiness.interfaces.IServicesContract;
import com.geovanni.studioghibli.views.bussiness.models.ServicePeopleResponse;
import com.geovanni.studioghibli.views.bussiness.presenters.RootPresenter;
import com.geovanni.studioghibli.views.bussiness.utils.ServicesError;
import com.geovanni.studioghibli.views.bussiness.utils.ServicesResponse;
import com.geovanni.studioghibli.views.views.adapters.PeopleAdapter;
import com.geovanni.studioghibli.views.views.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class PeopleFragment extends BaseFragment implements IServicesContract.View {

    public static final String TAG = PeopleFragment.class.getSimpleName();
    private RootPresenter rootPresenter;
    private List<ServicePeopleResponse> people;
    private IProgressLayout iProgressLayout;
    private PeopleAdapter peopleAdapter;

    @BindView(R.id.rvGeneralData)
    RecyclerView rvPeople;

    public static PeopleFragment newInstance() {
        PeopleFragment fragment = new PeopleFragment();
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Activity activity = null;
        if (context instanceof Activity) {
            activity = (Activity) context;
        }
        iProgressLayout = (IProgressLayout) activity;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        rootPresenter = new RootPresenter(getContext(), this);
        people = new ArrayList<>();
        peopleAdapter = new PeopleAdapter(getContext());
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        showProgress();
        setupRecyclerView();
        showToolbarDefaultMode();

        if (people != null && people.size() == 0) {
            rootPresenter.requestPeople();
        } else {
            peopleAdapter.replaceData(people);
            hideProgress();
        }
    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.fragment_general_list;
    }

    @Override
    protected String getCustomTag() {
        return TAG;
    }

    private void setupRecyclerView() {
        rvPeople.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        rvPeople.setAdapter(peopleAdapter);
    }

    @Override
    public void showResponse(ServicesResponse response) {
        try {
            List<ServicePeopleResponse> listResponse = (List<ServicePeopleResponse>) response.getResponse();
            peopleAdapter.replaceData(listResponse);

        } catch (Exception e) {
        }
    }

    @Override
    public void showError(ServicesError broxelServicesError) {
        getActivity().onBackPressed();
    }

    @Override
    public void showProgress() {
        iProgressLayout.getProgress().setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        iProgressLayout.getProgress().setVisibility(View.GONE);
    }

    private void showToolbarDefaultMode() {
        updateToolbar("People", R.drawable.ic_people);
    }
}
