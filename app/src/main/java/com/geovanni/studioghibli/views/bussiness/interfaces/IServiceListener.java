package com.geovanni.studioghibli.views.bussiness.interfaces;

import com.geovanni.studioghibli.views.bussiness.utils.ServicesError;
import com.geovanni.studioghibli.views.bussiness.utils.ServicesResponse;

public interface IServiceListener<T> {

    void onResponse(ServicesResponse<T> response);

    void onError(ServicesError broxelServicesError);

}
