package com.geovanni.studioghibli.views.bussiness.utils;

import android.content.Context;
import android.content.Intent;

/**
 * Created by gabri
 */

public class NavigationUtil {

    public static <T> void openActivity(Context context, Class<T> classTarget) {
        Intent intent = new Intent(context, classTarget);
        context.startActivity(intent);
    }
}
