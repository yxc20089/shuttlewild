package com.clzbj.www.shuttlewild;

import android.app.TabActivity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.PopupMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.TextView;

public class MainActivity extends TabActivity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }

    };
    PopupMenu userMenu;
    PopupMenu settingMenu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TabHost tabhost = getTabHost();
        tabhost.addTab(tabhost.newTabSpec("tab1").setIndicator("Campus").setContent(R.id.campus));
        tabhost.addTab(tabhost.newTabSpec("tab2").setIndicator("Wild").setContent(R.id.wild));
        TabWidget tabWidget = getTabWidget();
        for (int i = 0; i < tabWidget.getChildCount(); i++) {
            TextView tView = (TextView) tabWidget.getChildAt(i).findViewById(
                    android.R.id.title);
            tabWidget.getChildAt(i).setBackgroundResource(
                    R.drawable.tab_background);
            tView.setAllCaps(false);
        }

        userMenu = new PopupMenu(this, findViewById(R.id.user));
        Menu menu = userMenu.getMenu();
        getMenuInflater().inflate(R.menu.user,menu);

        settingMenu = new PopupMenu(this, findViewById(R.id.setting));
        getMenuInflater().inflate(R.menu.setting,settingMenu.getMenu());

    }

    public void popUserMenu(View view){
        userMenu.show();
    }

    public void popSettingMenu(View view){
        settingMenu.show();
    }

}
