package com.fengyao.trail.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.fengyao.trail.R;
import com.fengyao.trail.data.SQLTool;
import com.fengyao.trail.util.Values;

/**
 * Created by Chen fengYao on 2015/8/27.
 * 这是所有Activity的基类
 */
public class BaseActivity extends AppCompatActivity{
    public Values values = Values.getValues();
    public SQLTool sqlTool;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sqlTool = new SQLTool();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        setContentView(R.layout.blank_layout);
    }
}
