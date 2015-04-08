package be.hogent.jensbuysse.helloandroid;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class Activity2 extends ActionBarActivity {

    private static final String RESTART_KEY = "restart";
    private static final String RESUME_KEY = "resume";
    private static final String START_KEY = "start";
    private static final String CREATE_KEY = "create";

    // String for LogCat documentation
    private final static String TAG = "Activity_2";


    private int mCreate = 0;
    private int mRestart = 0;
    private int mStart = 0;
    private int mResume = 0;


    // mTvCreate, etc.
    private TextView mTvCreate;
    private TextView mTvRestart;
    private TextView mTvStart;
    private TextView mTvResume;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity2);

        mTvCreate = (TextView) findViewById(R.id.create);
        mTvRestart = (TextView) findViewById(R.id.restart);
        mTvStart = (TextView) findViewById(R.id.start);
        mTvResume = (TextView) findViewById(R.id.resume);

        Button closeButton = (Button) findViewById(R.id.bClose);
        closeButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                finish();
            }
        });

        // Check for previously saved state
        if (savedInstanceState != null) {
            mStart = savedInstanceState.getInt("mStart");
            mCreate = savedInstanceState.getInt("mCreate");
            mRestart = savedInstanceState.getInt("mRestart");
            mResume = savedInstanceState.getInt("mResume");
        }

        displayCounts();


    }

    // Lifecycle callback methods overrides

    @Override
    public void onStart() {
        super.onStart();

        Log.i(TAG, "Start has been called");

        mStart++;
        displayCounts();

    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i(TAG,"On resume has been called");
        mResume++;
        displayCounts();


    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i(TAG,"Pause has been called");


    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i(TAG,"Application has been stopped");


    }

    @Override
    public void onRestart() {
        super.onRestart();
        Log.i(TAG,"Application has been restarted");
        mRestart++;
        displayCounts();

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG,"Destroy has been called");
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putInt("mCreate",mCreate);
        savedInstanceState.putInt("mRestart",mRestart);
        savedInstanceState.putInt("mResume",mResume);
        savedInstanceState.putInt("mStart",mStart);


    }

    public void displayCounts() {

        mTvCreate.setText("onCreate() calls: " + mCreate);
        mTvStart.setText("onStart() calls: " + mStart);
        mTvResume.setText("onResume() calls: " + mResume);
        mTvRestart.setText("onRestart() calls: " + mRestart);

    }
}
