package org.patata.android.xarine;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.os.Bundle;
import android.view.View;

import android.util.Log;

import android.provider.MediaStore;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;

import java.util.ArrayList;

import org.patata.android.xarine.entities.Audio;

public class XarineMainActivity extends AppCompatActivity
{
    private final String TAG = XarineMainActivity.class.getSimpleName();
    private ArrayList<Audio> songs;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.xarine_toolbar);
        setSupportActionBar(toolbar);
        Log.i(TAG, "Activity onCreate");

        loadAudio();
    }

    private void loadAudio() {
        Log.i(TAG, "Loading Audio files");
        ContentResolver contentResolver = getContentResolver();
        Uri uri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;

        String selection = MediaStore.Audio.Media.IS_MUSIC + "!= 0";
        String audioOrder = MediaStore.Audio.Media.TITLE + " ASC";
        Log.i(TAG, uri.toString());
        Log.i(TAG, selection);
        Log.i(TAG, audioOrder);

        Cursor cursor = contentResolver.query(uri, null, selection, null, audioOrder);
        if (cursor != null && cursor.getCount() > 0) {
            Log.i(TAG, "So, let's get started!");
            songs = new ArrayList<>();
            while (cursor.moveToNext()) {
                String title = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.TITLE));
                String artist = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.ARTIST));
                String album = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.ALBUM));
                String path = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.DATA));
                songs.add(new Audio(path, title, artist, album));
                Log.i(TAG, path);
            }
            Log.i(TAG, Integer.toString(songs.size()));
        }
        cursor.close();
    }
}
