package com.fengyao.trail.core.main;

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

import com.fengyao.trail.R;
import com.fengyao.trail.base.BaseActivity;
import com.fengyao.trail.core.setting.SettingFragment;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        mToolbar = (Toolbar) findViewById(R.id.toolbar_default);
        setSupportActionBar(mToolbar);

        mToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                return false;
            }
        });

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.drawer_open,
                R.string.drawer_close);
        mDrawerToggle.syncState();
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        mNavigationView = (NavigationView) findViewById(R.id.navigation_view);
        setupDrawerContent(mNavigationView);
        //默认页面就是主页面


    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        toolBarHeight = mToolbar.getHeight();
        switchToMain();

    }

    //侧滑菜单的管理
    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        switch (menuItem.getItemId()) {
                            case R.id.navigation_item_main:
                                switchToMain();
                                break;
                            case R.id.navigation_item_remind:
                                break;
                            case R.id.navigation_item_mission:
                                break;
                            case R.id.navigation_item_calendar:
                                break;
                            case R.id.navigation_item_tomato:
                                break;
                            case R.id.navigation_item_goal:
                                break;
                            case R.id.navigation_item_setting:
                                switchToStting();
                                break;
                        }
                        menuItem.setChecked(true);
                        mDrawerLayout.closeDrawers();
                        return true;
                    }
                });
    }

    //跳转到主界面
    private void switchToMain(){
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_content, new MainPageFragment()).addToBackStack(null).commit();
        mToolbar.setTitle(R.string.app_name);
    }

//跳转到设置界面
    private void switchToStting() {
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_content, new SettingFragment()).addToBackStack(null).commit();
        mToolbar.setTitle(R.string.setting);
    }

    public int getToolbarHeight(){
        return toolBarHeight;
    }

    public int getStatusBarHeight(){
        Rect rect = new Rect();
        getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        return rect.top;
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_tool_bar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        Log.i("Sysout","asdfsadf");
        //noinspection SimplifiableIfStatement
        if (id == R.id.toolbar_char) {
            MyToast.mToast("聊天");
            Log.i("Sysout","asdfsadf");
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}