package talha.com.bd.patha_shathi.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import talha.com.bd.patha_shathi.R;
import talha.com.bd.patha_shathi.fragments.HomeFragment;
import talha.com.bd.patha_shathi.fragments.NotificationFragment;

import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private HomeFragment homeFragment;
    private NotificationFragment notificationFragment;
    private Toolbar mToolbar;
    private TextView toolbarText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        homeFragment = new HomeFragment();
        notificationFragment = new NotificationFragment();

        bottomNavigationView  = findViewById(R.id.bottom_navigation);
        mToolbar = findViewById(R.id.mainToolbar);
        toolbarText = findViewById(R.id.toolbarText);

        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("");
        mToolbar.setBackgroundColor(Color.parseColor("#ffffff"));

        replaceFragment(homeFragment);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.nav_home:
                        replaceFragment(homeFragment);
                        return true;
                    case R.id.nav_user:
                        // selectedFragment = new PathasathiScarchingFragment();
                        return true;
                    case R.id.nav_notification:
                        toolbarText.setText("Notifications");
                        replaceFragment(notificationFragment);
                        return true;
                    case R.id.nav_pathasathi:
                        // selectedFragment = new SettingFragment();
                        return true;
                    case R.id.nav_move:
                        // selectedFragment = new SettingFragment();
                        return true;
                    default:
                        return false;
                }
            }
        });

    }



    //Just replace the one fragment to another fragment
    private void replaceFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_container, fragment);
        fragmentTransaction.commit();
    }
}
