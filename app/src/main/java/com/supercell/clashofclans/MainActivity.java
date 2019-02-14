package com.supercell.clashofclans;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.supercell.clashofclans.myapplication.R;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        TextView shield = findViewById(R.id.shield);
        shield.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                postNotification("Test coc", "Chief, our shield is about to run out");
//                Toast.makeText(MainActivity.this, "Shield", Toast.LENGTH_SHORT).show();
            }
        });
        TextView guard = findViewById(R.id.guard);
        guard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                postNotification("Test coc", "Chief, our guard is about to run out");
//                Toast.makeText(MainActivity.this, "Shield", Toast.LENGTH_SHORT).show();
            }
        });
        TextView army = findViewById(R.id.army);
        army.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                postNotification("Test coc", "Chief, our army is ready to be taken to the battle");
//                Toast.makeText(MainActivity.this, "Shield", Toast.LENGTH_SHORT).show();
            }
        });
        TextView raid = findViewById(R.id.raid);
        raid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                postNotification("Test coc", "Chief, our village is being raided by test");
//                Toast.makeText(MainActivity.this, "Shield", Toast.LENGTH_SHORT).show();
            }
        });
        TextView collectors = findViewById(R.id.collectors);
        collectors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                postNotification("Test coc", "Chief, our collectors are full and waiting");
//                Toast.makeText(MainActivity.this, "Shield", Toast.LENGTH_SHORT).show();
            }
        });
        TextView war_declared = findViewById(R.id.war_declared);
        war_declared.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                postNotification("Test coc", "War has been declared with Test clan");
//                Toast.makeText(MainActivity.this, "Shield", Toast.LENGTH_SHORT).show();
            }
        });
        TextView war_start = findViewById(R.id.war_start);
        war_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Delay 5 seconds", Toast.LENGTH_SHORT).show();
                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        postNotification("Test coc", "War has started against Test clan");
                    }
                }, 5000);
//                Toast.makeText(MainActivity.this, "Shield", Toast.LENGTH_SHORT).show();
            }
        });
        TextView war_end = findViewById(R.id.war_end);
        war_end.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Delay 5 mins", Toast.LENGTH_SHORT).show();
                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        postNotification("Test coc", "Clan war has ended");
                    }
                }, 300 * 1000);
//                Toast.makeText(MainActivity.this, "Shield", Toast.LENGTH_SHORT).show();
            }
        });
        TextView upgrade = findViewById(R.id.upgrade);
        upgrade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                postNotification("Test coc", "Clan castle upgraded to level 7");
//                Toast.makeText(MainActivity.this, "Shield", Toast.LENGTH_SHORT).show();
            }
        });
        TextView clock_tower_boost = findViewById(R.id.clock_tower_boost);
        clock_tower_boost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                postNotification("Test coc", "Clock tower boost is available");
//                Toast.makeText(MainActivity.this, "Shield", Toast.LENGTH_SHORT).show();
            }
        });
        TextView buider_base_loot = findViewById(R.id.buider_base_loot);
        buider_base_loot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                postNotification("Test coc", "Chief, more Builder Base loot is available");
//                Toast.makeText(MainActivity.this, "Shield", Toast.LENGTH_SHORT).show();
            }
        });
        TextView gem_mine_full = findViewById(R.id.gem_mine_full);
        gem_mine_full.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                postNotification("Test coc", "Chief, your Gem Mine is full of Gems!");
//                Toast.makeText(MainActivity.this, "Shield", Toast.LENGTH_SHORT).show();
            }
        });
        TextView misc = findViewById(R.id.misc);
        misc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                postNotification("Test coc", "Miscellaneous notif content here");
//                Toast.makeText(MainActivity.this, "Shield", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void postNotification(String title, String content) {
        final int notifyID = 1;
        final String CHANNEL_ID = "my_channel_01";// The id of the channel.
        CharSequence name = getString(R.string.channel_name);// The user-visible name of the channel.
        int importance = 0;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            importance = NotificationManager.IMPORTANCE_DEFAULT;
        }
        final NotificationManager mNotificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        NotificationChannel mChannel = null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            mChannel = new NotificationChannel(CHANNEL_ID, name, importance);
            mNotificationManager.createNotificationChannel(mChannel);
        }
        Notification notification;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            notification = new Notification.Builder(MainActivity.this)
                    .setContentTitle(title)
                    .setContentText(content)
                    .setSmallIcon(R.drawable.ic_launcher_background)
                    .setChannelId(CHANNEL_ID)
                    .build();
        } else {
            notification = new Notification.Builder(MainActivity.this)
                    .setContentTitle(title)
                    .setContentText(content)
                    .setSmallIcon(R.drawable.ic_launcher_background)
                    .build();
        }
        mNotificationManager.notify(notifyID, notification);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent launchIntent = getPackageManager().getLaunchIntentForPackage(getResources().getString(R.string.target_package_name));
            if (launchIntent != null) {
                startActivity(launchIntent);//null pointer check in case package name was not found
            } else {
                Toast.makeText(MainActivity.this, "App not installed", Toast.LENGTH_SHORT).show();
            }
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
