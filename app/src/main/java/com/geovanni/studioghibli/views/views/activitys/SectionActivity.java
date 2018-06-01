package com.geovanni.studioghibli.views.views.activitys;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.widget.RelativeLayout;

import com.geovanni.studioghibli.R;
import com.geovanni.studioghibli.views.views.base.BaseActivity;
import com.geovanni.studioghibli.views.views.fragments.FilmsFragment;

import butterknife.BindView;

public class SectionActivity extends BaseActivity {

    private int section;

    @BindView(R.id.rdbFragment)
    RelativeLayout rdbFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_section);

        if (getIntent() != null) {
            section = getIntent().getIntExtra("_Section", 0);
        }

        initViews();
        ReplaceMainFragment();
    }

    @Override
    protected void initViews() {
        super.initViews();
    }

    private void ReplaceMainFragment() {

        Fragment fragment = new Fragment();
        String titleFragment = "";
        String tagFragment = "";

        switch (section) {
            case 0:
                fragment = FilmsFragment.newInstance();
                titleFragment = getString(R.string.films);
                tagFragment = FilmsFragment.TAG;
                break;
            case 1:
                fragment = FilmsFragment.newInstance();
                titleFragment = getString(R.string.people);
                tagFragment = FilmsFragment.TAG;
                break;
            case 2:
                fragment = FilmsFragment.newInstance();
                titleFragment = getString(R.string.locations);
                tagFragment = FilmsFragment.TAG;
                break;
            case 3:
                fragment = FilmsFragment.newInstance();
                titleFragment = getString(R.string.species);
                tagFragment = FilmsFragment.TAG;
                break;
            case 4:
                fragment = FilmsFragment.newInstance();
                titleFragment = getString(R.string.vehicles);
                tagFragment = FilmsFragment.TAG;
                break;
            default:
                break;
        }

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(rdbFragment.getId(), fragment, tagFragment);
        fragmentTransaction.addToBackStack(fragment.toString());
        fragmentTransaction.commit();
    }

}
