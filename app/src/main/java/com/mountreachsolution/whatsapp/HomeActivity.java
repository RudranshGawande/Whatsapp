package com.mountreachsolution.whatsapp;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.mountreachsolution.whatsapp.fragment.CallsFragment;
import com.mountreachsolution.whatsapp.fragment.CommunitiesFragment;
import com.mountreachsolution.whatsapp.fragment.UpdatesFragment;
import androidx.fragment.app.Fragment;
import com.mountreachsolution.whatsapp.fragment.ChatsFragment;

public class HomeActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);

        // Load default fragment (Chats)
        if (savedInstanceState == null) {
            loadFragment(new ChatsFragment());
        }

        bottomNavigationView.setOnItemSelectedListener(item -> {
            Fragment fragment = null;
            int itemId = item.getItemId();

            if (itemId == R.id.menu_chats) {
                fragment = new ChatsFragment();
            } else if (itemId == R.id.menu_updates) {
                fragment = new UpdatesFragment();
            } else if (itemId == R.id.menu_communities) {
                fragment = new CommunitiesFragment();
            } else if (itemId == R.id.menu_calls) {
                fragment = new CallsFragment();
            }

            return loadFragment(fragment);
        });
    }

    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragmentContainer, fragment)
                    .commit();
            return true;
        }
        return false;
    }
}
