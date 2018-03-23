package com.geovanni.studioghibli.views.bussiness.interfaces;

import com.geovanni.studioghibli.views.bussiness.utils.ServicesError;
import com.geovanni.studioghibli.views.bussiness.utils.ServicesResponse;

public interface IServicesContract {
    interface View<T> {
        void showResponse(ServicesResponse<T> response);

        void showError(ServicesError broxelServicesError);
    }
}
