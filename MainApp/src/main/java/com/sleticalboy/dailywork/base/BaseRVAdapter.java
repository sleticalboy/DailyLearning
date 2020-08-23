package com.sleticalboy.dailywork.base;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created on 20-8-23.
 *
 * @author binlee sleticalboy@gmail.com
 */
public abstract class BaseRVAdapter<DATA> extends RecyclerView.Adapter<BaseRVHolder<DATA>> {

    protected final List<DATA> mData;

    public BaseRVAdapter() {
        this(new ArrayList<>());
    }

    public BaseRVAdapter(final List<DATA> data) {
        mData = data == null ? new ArrayList<>() : data;
    }

    public BaseRVAdapter(final DATA[] data) {
        this(data == null ? new ArrayList<>() : new ArrayList<>(Arrays.asList(data)));
    }

    @NonNull
    @Override
    public abstract BaseRVHolder<DATA> onCreateViewHolder(@NonNull final ViewGroup parent, final int viewType);

    @Override
    public final void onBindViewHolder(@NonNull final BaseRVHolder holder, final int position) {
        holder.bindData(getData(position), position);
    }

    private DATA getData(final int position) {
        if (position >= mData.size()) {
            throw new IllegalArgumentException("position >= mData.size(): " + position);
        }
        return mData.get(position);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
}
