package com.geovanni.studioghibli.views.views.activitys;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.geovanni.studioghibli.R;
import com.geovanni.studioghibli.views.bussiness.interfaces.IProgressLayout;
import com.geovanni.studioghibli.views.bussiness.interfaces.IToolbarListener;
import com.geovanni.studioghibli.views.customViews.ProgressLayout;
import com.geovanni.studioghibli.views.views.base.BaseActivity;
import com.geovanni.studioghibli.views.views.fragments.FilmsFragment;
import com.geovanni.studioghibli.views.views.fragments.PeopleFragment;

import butterknife.BindView;

public class SectionActivity extends BaseActivity implements IProgressLayout, IToolbarListener {

    private int section;

    @BindView(R.id.rdbFragment)
    FrameLayout rdbFragment;

    @BindView(R.id.tbHome)
    Toolbar tbHome;

    @BindView(R.id.imvTitleToolBar)
    ImageView imvTitleToolBar;

    @BindView(R.id.txvTitleToolBar)
    TextView txvTitleToolBar;

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
        setSupportActionBar(tbHome);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.items_toolbar, menu);
        return super.onCreateOptionsMenu(menu);
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
                fragment = PeopleFragment.newInstance();
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

    @Override
    public ProgressLayout getProgress() {
        return getProgressLayout();
    }

    @Override
    public void updateToolbar(String title, int imageResource) {
        imvTitleToolBar.setImageResource(imageResource);
        txvTitleToolBar.setText(title);
    }
}
