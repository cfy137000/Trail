package com.fengyao.trail.core.setting.tomato;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.fengyao.trail.R;
import com.fengyao.trail.base.BaseActivity;
import com.fengyao.trail.data.SQLTool;
import com.fengyao.trail.data.tables.SettingTomatoTable;
import com.gc.materialdesign.views.ButtonRectangle;
import com.gc.materialdesign.views.Slider;

import java.util.ArrayList;

/**
 * Created by Chen fengYao on 2015/8/30.
 * 用于番茄时钟的设置
 */
public class TomatoSettingActivity extends BaseActivity implements View.OnClickListener {
    private Toolbar tomatoSettingToolbar;
    private Slider workSlider,breakSlider;
    private TextView workTv,breakTv;
    private ButtonRectangle blockedBtn;
    private SettingTomatoTable tomatoSQL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_tomato);
        init();
    }

    //初始化各个组件
    private void init(){
        //toolBar
        tomatoSettingToolbar = (Toolbar) findViewById(R.id.toolbar_default);
        tomatoSettingToolbar.setTitle(getResources().getString(R.string.setting_tomato_title));
        tomatoSettingToolbar.setBackgroundColor(values.getToolBarColor());
        tomatoSettingToolbar.setNavigationIcon(R.mipmap.ic_back);
        //toolBar的返回事件
        setSupportActionBar(tomatoSettingToolbar);
        tomatoSettingToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        //slider
        workSlider = (Slider) findViewById(R.id.slider_setting_tomato_work);
        breakSlider = (Slider) findViewById(R.id.slider_setting_tomato_break);

        workSlider.setOnValueChangedListener(new Slider.OnValueChangedListener() {
            @Override
            public void onValueChanged(int value) {
                workTv.setText(value+"分钟");
                tomatoSQL.upDataTomatoWorkTime(value);
            }
        });
        breakSlider.setOnValueChangedListener(new Slider.OnValueChangedListener() {
            @Override
            public void onValueChanged(int value) {
                breakTv.setText(value+"分钟");
                tomatoSQL.upDataTomatoBreakTime(value);
            }
        });
        //textview
        workTv = (TextView) findViewById(R.id.tv_setting_tomato_work);
        breakTv= (TextView) findViewById(R.id.tv_setting_tomato_break);
        //底部的button
        blockedBtn = (ButtonRectangle) findViewById(R.id.btn_setting_tomato_blocked);
        blockedBtn.setOnClickListener(this);
        //番茄设置表
        tomatoSQL = (SettingTomatoTable) sqlTool.tableFactory(SQLTool.TableName.settingTomato);
        ArrayList<Integer> data = (ArrayList<Integer>) tomatoSQL.qureSettingTomato();
        breakTv.setText(data.get(0).toString());
        workTv.setText(data.get(1).toString());

        breakSlider.setValue(data.get(0));
        workSlider.setValue(data.get(1));

    }

    @Override
    public void onClick(View v) {

    }
}
