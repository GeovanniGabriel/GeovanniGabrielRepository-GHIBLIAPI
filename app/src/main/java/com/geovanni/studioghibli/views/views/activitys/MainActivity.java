package com.geovanni.studioghibli.views.views.activitys;

import android.content.Intent;
import android.os.Bundle;

import com.geovanni.studioghibli.R;
import com.geovanni.studioghibli.views.bussiness.models.MenuItem;
import com.geovanni.studioghibli.views.views.base.BaseActivity;
import com.nightonke.boommenu.BoomButtons.HamButton;
import com.nightonke.boommenu.BoomButtons.OnBMClickListener;
import com.nightonke.boommenu.BoomMenuButton;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class MainActivity extends BaseActivity implements OnBMClickListener {

    @BindView(R.id.bmb)
    BoomMenuButton bmb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        initApp();
    }

    @Override
    protected void initViews() {
        super.initViews();
    }

    private void initApp() {

        List<MenuItem> menuItemList = new ArrayList<>();
        menuItemList.add(new MenuItem(R.string.films, R.drawable.ic_films_2, R.string.sub_films));
        menuItemList.add(new MenuItem(R.string.people, R.drawable.ic_people, R.string.sub_people));
        menuItemList.add(new MenuItem(R.string.locations, R.drawable.ic_locations, R.string.sub_locations));
        menuItemList.add(new MenuItem(R.string.species, R.drawable.ic_species, R.string.sub_species));
        menuItemList.add(new MenuItem(R.string.vehicles, R.drawable.ic_vehicles, R.string.sub_vehicles));

        for (int i = 0; i < bmb.getPiecePlaceEnum().pieceNumber(); i++) {
            HamButton.Builder builder = new HamButton.Builder()
                    .normalImageRes(menuItemList.get(i).getImage())
                    .normalTextRes(menuItemList.get(i).getName())
                    .subNormalTextRes(menuItemList.get(i).getDescription())
                    .shadowEffect(true)
                    .rippleEffect(true)
                    .listener(this);
            bmb.addBuilder(builder);
        }
    }

    @Override
    public void onBoomButtonClick(int index) {
        Intent intent = new Intent(MainActivity.this, SectionActivity.class);

        switch (index) {
            case 0:
                intent.putExtra("_Section", 0);
                break;
            case 1:
                intent.putExtra("_Section", 1);
                break;
            case 2:
                intent.putExtra("_Section", 2);
                break;
            case 3:
                intent.putExtra("_Section", 4);
                break;
        }
        startActivity(intent);
    }



}
