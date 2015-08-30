package com.fengyao.trail.core.setting.personalCenter;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.fengyao.trail.R;
import com.fengyao.trail.base.BaseActivity;

import org.angmarch.views.NiceSpinner;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Chen fengYao on 2015/8/29.
 */
public class PersonalCenterActivity extends BaseActivity implements View.OnClickListener, DatePickerDialog.OnDateSetListener {
    private LinearLayout nickNameLl, birthLl, sexLl;
    private int year,monthOfYear,dayOfMonth;
    private DatePickerDialog dataPickerDialog;
    private TextView nickNameTv;
    private Toolbar personalToolBar;
    private Dialog setNickDialog;
    private AppCompatEditText nickNameInTv;
    private NiceSpinner setTv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_center);
        init();
    }

    //初始化组件
    @SuppressLint("ResourceAsColor")
    private void init() {
        //toolBar
        personalToolBar = (Toolbar) findViewById(R.id.toolbar_default);
        personalToolBar.setTitle(getResources().getString(R.string.setting_personal_center_title));
        personalToolBar.setBackgroundColor(values.getToolBarColor());
        personalToolBar.setNavigationIcon(R.mipmap.ic_back);
        //toolBar的返回事件
        setSupportActionBar(personalToolBar);
        personalToolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        //三项点击事件
        nickNameLl = (LinearLayout) findViewById(R.id.ll_setting_nick_name);
        birthLl = (LinearLayout) findViewById(R.id.ll_setting_birth);
        sexLl = (LinearLayout) findViewById(R.id.ll_setting_sex);

        nickNameLl.setOnClickListener(this);
        birthLl.setOnClickListener(this);
        sexLl.setOnClickListener(this);
        //日历弹出框
        dataPickerDialog = new DatePickerDialog(this, this, 2015, 0, 1);
//设置昵称
        nickNameTv = (TextView) findViewById(R.id.tv_setting_personal_center_nick);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View view = LayoutInflater.from(this).inflate(R.layout.dialog_set_nick_name,null);
        nickNameInTv = (AppCompatEditText) view.findViewById(R.id.et_set_nick_name);
        builder.setView(view);
        builder.setTitle("请输入昵称");
        builder.setNegativeButton("取消", null);
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (nickNameInTv.getText() != null) {
                    nickNameTv.setText(nickNameInTv.getText().toString());
                }
            }
        });
        setNickDialog = builder.create();

        setTv = (NiceSpinner) findViewById(R.id.tv_sex);
      //  setTv.setTintColor(R.color.);
        ArrayList<String> dataset = new ArrayList<>(Arrays.asList("男", "女"));
        setTv.attachDataSource(dataset);

    }

    //点击事件
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ll_setting_nick_name:
                setNickDialog.show();
                break;
            case R.id.ll_setting_birth:
                dataPickerDialog.show();
                break;
            case R.id.ll_setting_sex:

                break;
        }
    }

    @Override
    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
        this.year = year;
        this.monthOfYear = monthOfYear+1;
        this.dayOfMonth = dayOfMonth;
        nickNameTv.setText(this.year+"-"+this.monthOfYear+"-"+this.dayOfMonth);
    }
}
