package be.hogent.jensbuysse.chucknorrisjokes;

import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;

import org.json.JSONObject;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by jbuy519 on 08/04/2015.
 */
public class DownloadJokeTask extends AsyncTask<Void,Void, Joke> {

    /**
     * TAG to log
     */
    private String TAG = "JokeService";
    public static final String PARAM_OUT_ID = "ID";
    public static final String PARAM_OUT_JOKE = "JOKE";

    @Override
    protected Joke doInBackground(Void... params) {
        Log.i(TAG, "Fetcing a joke");

        HttpURLConnection conn = null;
        InputStream stream = null;
        try {
            URL url = new URL("http://api.icndb.com/jokes/random?");
            Log.i(TAG,"Connecting to API ... ");
            conn = (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(10000 /* milliseconds */);
            conn.setConnectTimeout(15000 /* milliseconds */);
            conn.setRequestMethod("GET");
            conn.setDoInput(true);
            // Starts the query
            conn.connect();
            stream = conn.getInputStream();
            Gson gson = new Gson();
            Joke joke = gson.fromJson(stream.toString(), Joke.class);
            return joke;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }finally {
            try{
                conn.disconnect();
            }catch(Exception e ){
                e.printStackTrace();
            }
            try{
                stream.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void onPostExecute(Joke joke) {
        Log.i(TAG,joke.toString());
    }
}
