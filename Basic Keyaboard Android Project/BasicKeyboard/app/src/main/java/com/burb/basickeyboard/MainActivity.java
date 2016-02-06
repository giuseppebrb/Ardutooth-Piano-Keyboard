package com.burb.basickeyboard;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import com.burb.ardutooth.Ardutooth;

/**
 * @author Giuseppe Barbato
 */
public class MainActivity extends AppCompatActivity {
    private Ardutooth ard;
    private Button c, cs, d, ds, e, f, fs, g, gs,a, as, b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        c = (Button) findViewById(R.id.c);
        cs = (Button) findViewById(R.id.cs);
        d = (Button) findViewById(R.id.d);
        ds = (Button) findViewById(R.id.ds);
        e = (Button) findViewById(R.id.e);
        f = (Button) findViewById(R.id.f);
        fs = (Button) findViewById(R.id.fs);
        g = (Button) findViewById(R.id.g);
        gs = (Button) findViewById(R.id.gs);
        a = (Button) findViewById(R.id.a);
        as = (Button) findViewById(R.id.as);
        b = (Button) findViewById(R.id.b);

        ard = new Ardutooth(this);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ard.startScan(); // start discovery of bluetooth devices earby
            }
        });

        /*Note that Arduino.cc reports these frequency values to reproduce notes:
       * NOTE_C4 = 262;
       * NOTE_CS4 = 277;
       * NOTE_D4 =  294;
       * NOTE_DS4 = 311;
       * NOTE_E4 =  330;
       * NOTE_F4 = 349;
       * NOTE_FS4 = 370;
       * NOTE_G4 =  392;
       * NOTE_GS4 = 415;
       * NOTE_A4 =  440;
       * NOTE_AS4 = 466;
       * NOTE_B4 =  494;
       * NOTE_C5 =  523;
       */

        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ard.sendData("262:"); // I used ':' as escape to end a command
            }
        });

        cs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ard.sendData("277:"); // I used ':' as escape to end a command
            }
        });

        d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ard.sendData("294:"); // I used ':' as escape to end a command
            }
        });

        ds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ard.sendData("311:"); // I used ':' as escape to end a command
            }
        });

        e.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ard.sendData("330:"); // I used ':' as escape to end a command
            }
        });

        f.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ard.sendData("349:"); // I used ':' as escape to end a command
            }
        });

        fs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ard.sendData("370:"); // I used ':' as escape to end a command
            }
        });

        g.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ard.sendData("392:"); // I used ':' as escape to end a command
            }
        });

        gs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ard.sendData("415:"); // I used ':' as escape to end a command
            }
        });

        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ard.sendData("440:"); // I used ':' as escape to end a command
            }
        });

        as.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ard.sendData("466:"); // I used ':' as escape to end a command
            }
        });

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ard.sendData("494:"); // I used ':' as escape to end a command
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            ard.startScan();
        }

        return super.onOptionsItemSelected(item);
    }
}
