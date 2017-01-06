package org.patata.android.xarine;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.os.Bundle;

import android.util.Log;

public class XarineMainActivity extends AppCompatActivity
{
    private final String TAG = XarineMainActivity.class.getSimpleName();

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.xarine_toolbar);
        setSupportActionBar(toolbar);
        Log.i(TAG, "Activity onCreate");
    }
}
