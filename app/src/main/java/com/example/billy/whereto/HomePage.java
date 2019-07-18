package com.example.billy.whereto;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import android.widget.TextView;
import com.google.firebase.auth.FirebaseAuth;

public class HomePage extends AppCompatActivity {

    private DrawerLayout drawLay;
    private ActionBarDrawerToggle abdt;
    private TextView mText;
    private FirebaseAuth mAuth;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page);
        drawLay = (DrawerLayout) findViewById(R.id.drawerLayout);
        abdt = new ActionBarDrawerToggle(this, drawLay, R.string.Open, R.string.Close);

        drawLay.addDrawerListener(abdt);
        abdt.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final NavigationView navView = (NavigationView) findViewById(R.id.navView);
        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if (id == R.id.home) {

                    Toast.makeText(HomePage.this, "Home", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(HomePage.this, HomePage.class);
                    startActivity(i);
                    finish();

                }

                if (id == R.id.profile) {

                    Toast.makeText(HomePage.this, "Profile", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(HomePage.this, MyProfile.class);
                    startActivity(i);
                    finish();

                }

                if (id == R.id.activities) {

                    Toast.makeText(HomePage.this, "Activities", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(HomePage.this, MyActivities.class);
                    startActivity(i);
                    finish();

                }

                if (id == R.id.custService) {

                    Toast.makeText(HomePage.this, "Customer Service", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(HomePage.this, CustService.class);
                    startActivity(i);
                    finish();

                }

                if (id == R.id.logout) {
                    mAuth.getInstance().signOut();
                    Toast.makeText(HomePage.this, "Log Out", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(HomePage.this, MainActivity.class);
                    startActivity(i);
                    finish();
                }

                return true;
            }
        });

        mText = (TextView) findViewById(R.id.firstname);
        mText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomePage.this, OrganizationPage.class);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return abdt.onOptionsItemSelected(item) || super.onOptionsItemSelected(item);
    }
}
