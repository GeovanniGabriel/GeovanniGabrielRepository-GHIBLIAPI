package com.geovanni.studioghibli.views.bussiness.interfaces;

public interface IItemListener<T> {
    void onItemSelect(T item, int action, int position);
}
