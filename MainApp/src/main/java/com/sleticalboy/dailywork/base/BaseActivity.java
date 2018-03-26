package com.sleticalboy.dailywork.base;

import android.os.Bundle;

/**
 * Created on 18-2-1.
 *
 * @author sleticalboy
 * @version 1.0
 * @description
 */
public abstract class BaseActivity extends PermissionCheckActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        prepareWork();
        setContentView(attachLayout());
        initView();
        initData();
    }

    protected abstract int attachLayout();

    protected abstract void initView();

    protected abstract void initData();

    protected void prepareWork() {
    }

}
