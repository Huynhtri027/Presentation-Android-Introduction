package be.hogent.jensbuysse.helloandroid;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    /**
     * Strings indicating which method was called
     */
    private static final String RESTART_KEY = "restart";
    private static final String RESUME_KEY = "resume";
    private static final String START_KEY = "start";
    private static final String CREATE_KEY = "create";

    /*
     * String for LogCat documentation
      */
    private final static String TAG = "MainActivity";

    /**
     * Counters for the method calls
     */
    private int mCreate = 0;
    private int mRestart = 0;
    private int mStart = 0;
    private int mResume = 0;


    private TextView mTvCreate;
    private TextView mTvRestart;
    private TextView mTvStart;
    private TextView mTvResume;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find and intitalize the textviews declared in the layout file
        mTvCreate = (TextView) findViewById(R.id.create);
        mTvRestart = (TextView) findViewById(R.id.restart);
        mTvStart = (TextView) findViewById(R.id.start);
        mTvResume = (TextView) findViewById(R.id.resume);
        Button launchActivityTwoButton = (Button) findViewById(R.id.bLaunchActivityTwo);

        //Add a clicklistenter to the button which starts a new activity
        launchActivityTwoButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                try {

                    Intent activityTwoIntent = new Intent(getApplicationContext(), Activity2.class);
                    startActivity(activityTwoIntent);
                } catch (Exception e) {
                    Log.e(TAG, e.toString());
                }
            }

        });

        // Check if state was saved
        if (savedInstanceState != null) {
            mStart = savedInstanceState.getInt("mStart");
            mCreate = savedInstanceState.getInt("mCreate");
            mRestart = savedInstanceState.getInt("mRestart");
            mResume = savedInstanceState.getInt("mResume");
        }

        mCreate++;
        displayCounts();
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
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onResume() {
        super.onResume();
        // TODO: Emit LogCat message
        Log.i(TAG,"Resumed the acitivy");
        mResume++;
        displayCounts();

    }

    @Override
    public void onPause() {
        super.onPause();
        //Emit LogCat message
        Log.i(TAG,"Paused the activity");
    }

    @Override
    public void onStop() {
        super.onStop();
        // Emit LogCat message
        Log.i(TAG,"Stopped the acitivity");
    }

    @Override
    public void onRestart() {
        super.onRestart();
        // Emit LogCat message
        Log.i(TAG,"Restarted the acitivity");
        mRestart++;
        displayCounts();

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        // Emit LogCat message
        Log.i(TAG,"Destroyed Activity");

    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        // Save de state  with key-value pairs in de Bundle
        savedInstanceState.putInt("mCreate",mCreate);
        savedInstanceState.putInt("mRestart",mRestart);
        savedInstanceState.putInt("mResume",mResume);
        savedInstanceState.putInt("mStart",mStart);

    }

    // Updates de  counters
    public void displayCounts() {

        mTvCreate.setText("onCreate() calls: " + mCreate);
        mTvStart.setText("onStart() calls: " + mStart);
        mTvResume.setText("onResume() calls: " + mResume);
        mTvRestart.setText("onRestart() calls: " + mRestart);

    }

    // TODO: add functionality for the onStart method


}
