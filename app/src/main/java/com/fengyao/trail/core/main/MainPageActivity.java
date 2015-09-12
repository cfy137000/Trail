package com.fengyao.trail.core.main;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.fengyao.trail.R;
import com.fengyao.trail.base.BaseActivity;
import com.fengyao.trail.core.Mission.MissionFragment;
import com.fengyao.trail.core.chat.CharFragment;
import com.fengyao.trail.core.goal.GoalFragment;
import com.fengyao.trail.core.setting.SettingFragment;
import com.fengyao.trail.core.tomato.ToamatoFragment;
import com.fengyao.trail.util.MyToast;

/**
 * Created by Chen fengYao on 2015/9/1.
 */
public class MainPageActivity extends BaseActivity {
    private Toolbar mToolbar;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;
    private NavigationView mNavigationView;
    private int toolBarHeight;
    private LinearLayout header;
    private TextView headUsername;

    public LinearLayout getHeader() {
        return header;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        Intent intent = getIntent();//传来的意图


        mToolbar = (Toolbar) findViewById(R.id.toolbar_default);
        setSupportActionBar(mToolbar);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.drawer_open,
                R.string.drawer_close);
        mDrawerToggle.syncState();
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        mNavigationView = (NavigationView) findViewById(R.id.navigation_view);
        header = (LinearLayout) mNavigationView.findViewById(R.id.ll_navigation_header);
        headUsername = (TextView) header.findViewById(R.id.tv_main_username);
        headUsername.setText(intent.getStringExtra("userName"));
        setupDrawerContent(mNavigationView);

//toolbar上菜单的点击事件
        mToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                int id = item.getItemId();
                if (id == R.id.toolbar_char) {
                    switchToChar();
                }
                return true;
            }
        });

        switchToMain();//主页最先显示

    }

    //页面绘制完毕
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        toolBarHeight = mToolbar.getHeight();


    }

    //侧滑菜单的管理
    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        switch (menuItem.getItemId()) {
                            case R.id.navigation_item_main:
                                switchToMain();//主页
                                break;
                            case R.id.navigation_item_remind:
                                break;
                            case R.id.navigation_item_mission:
                                switchToMission();//任务界面
                                break;
                            case R.id.navigation_item_calendar:
                                break;
                            case R.id.navigation_item_tomato:
                                switchToTomatoClock();//番茄时钟
                                break;
                            case R.id.navigation_item_goal:
                                switchToGoal();//人生目标
                                break;
                            case R.id.navigation_item_setting:
                                switchToStting();//设置
                                break;
                        }
                        menuItem.setChecked(true);
                        mDrawerLayout.closeDrawers();
                        return true;
                    }
                });
    }

    //跳转到主界面
    private void switchToMain() {
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_content, new MainPageFragment()).commit();
        mToolbar.setTitle(R.string.app_name);
    }

    //跳转到番茄时钟界面
    private void switchToTomatoClock() {
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_content, new ToamatoFragment()).addToBackStack(null).commit();
        mToolbar.setTitle(R.string.navigation_tomato);
    }

    //跳转到聊天界面
    private void switchToChar() {
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_content, new CharFragment()).addToBackStack(null).commit();
        mToolbar.setTitle(R.string.tool_bar_title_char);
    }

    //跳转到设置界面
    private void switchToStting() {
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_content,
                new SettingFragment()).addToBackStack(null).commit();
        mToolbar.setTitle(R.string.setting);
    }

    //跳转到任务界面
    private void switchToMission() {
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_content,
                new MissionFragment()).addToBackStack(null).commit();
        mToolbar.setTitle(R.string.setting_notice_time_mission);
    }

    //跳转到人生目标页面
    private void switchToGoal() {
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_content,
                new GoalFragment()).addToBackStack(null).commit();
        mToolbar.setTitle(R.string.navigation_goal);
    }

    //返回ToolBar的高度
    public int getToolbarHeight() {
        return toolBarHeight;
    }

    //返回状态栏的高度
    public int getStatusBarHeight() {
        Rect rect = new Rect();
        getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        return rect.top;
    }


    //加载菜单
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_tool_bar, menu);
        return true;
    }

    public Toolbar getmToolbar() {
        return mToolbar;
    }

    public void setmToolbar(Toolbar mToolbar) {
        this.mToolbar = mToolbar;
    }

    public static void startMainPageActivity(Context context, String userName) {
        Intent intent = new Intent(context, MainPageActivity.class);
        intent.putExtra("userName", userName);
        context.startActivity(intent);
    }
}