package com.geovanni.studioghibli.views.views.base;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.geovanni.studioghibli.views.bussiness.interfaces.IItemListener;

public class ViewHolderItem<T> extends RecyclerView.ViewHolder {

    private T item;
    protected IItemListener adapterCallback;
    private int mode;

    public ViewHolderItem(View itemView) {
        super(itemView);
    }

    public void bindItem(T item) {
        this.item = item;
    }

    public void bindItem(T item, int mode) {
        this.item = item;
        this.mode = mode;
    }

    public T getItem() {
        return item;
    }

    public int getMode() {
        return mode;
    }
}
