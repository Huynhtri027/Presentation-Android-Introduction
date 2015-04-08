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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        throw new UnsupportedOperationException("Operation is not yet supported");
    }

    @Override
    protected void onResume() {
        throw new UnsupportedOperationException("Operation is not yet supported");
    }

    @Override
    protected void onPause() {
        throw new UnsupportedOperationException("Operation is not yet supported");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        throw new UnsupportedOperationException("Operation is not yet supported");

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
        throw new UnsupportedOperationException("Operation is not yet supported");
    }
}
