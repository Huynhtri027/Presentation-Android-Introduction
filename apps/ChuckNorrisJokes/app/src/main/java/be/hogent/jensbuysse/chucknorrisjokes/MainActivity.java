package be.hogent.jensbuysse.chucknorrisjokes;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity implements JokeInterface {

    public static String TAG= "MainActivity";

    private IntentFilter filter;
    private BroadcastReceiver jokeReceiver;
    private ArrayList<String> jokes;
    private ArrayAdapter<String> jokeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        jokes = new ArrayList<String>();
        jokeAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,jokes);
        ListView jokeList = (ListView)findViewById(R.id.jokesList);
        jokeList.setAdapter(jokeAdapter);

        filter = new IntentFilter(JokeReceiver.ACTION_RECEIVE_JOKE);
        filter.addCategory(Intent.CATEGORY_DEFAULT);
        jokeReceiver = new JokeReceiver(this);
        registerReceiver(jokeReceiver,filter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(jokeReceiver,filter);

    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(jokeReceiver);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        Button fetchButton = (Button)findViewById(R.id.fetchButton);
        fetchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DownloadJokeTask task = new DownloadJokeTask(getApplicationContext());
                task.execute();
            }
        });
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
    public void addJoke(String joke) {
        Log.i(TAG,joke);
        jokes.add(joke);
        jokeAdapter.notifyDataSetChanged();
    }
}
