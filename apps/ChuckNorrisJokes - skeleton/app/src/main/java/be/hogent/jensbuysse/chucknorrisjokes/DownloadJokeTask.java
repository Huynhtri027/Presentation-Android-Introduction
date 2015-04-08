package be.hogent.jensbuysse.chucknorrisjokes;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by jbuy519 on 08/04/2015.
 */
public class DownloadJokeTask extends AsyncTask<Void, Void, JokeWrapper> {

    private Context context;

    public DownloadJokeTask(Context context) {
        this.context = context;
    }

    /**
     * TAG to log
     */
    private String TAG = "JokeService";
    public static final String PARAM_OUT_JOKE = "JOKE";

    @Override
    protected JokeWrapper doInBackground(Void... params) {
        throw new UnsupportedOperationException("Operation is not yet supported");
    }

    @Override
    protected void onPostExecute(JokeWrapper jokeWrapper) {
        throw new UnsupportedOperationException("Operation is not yet supported");

    }

    private InputStream retrieveStream(String url) {
        DefaultHttpClient client = new DefaultHttpClient();
        HttpGet getRequest;
        try {
            getRequest = new HttpGet(url);
            try {
                HttpResponse getResponse = client.execute(getRequest);
                final int statusCode = getResponse.getStatusLine().getStatusCode();
                if (statusCode != HttpStatus.SC_OK) {
                    Log.w(TAG, "Error " + statusCode + " for URL " + url);
                    return null;
                }
                HttpEntity getResponseEntity = getResponse.getEntity();
                try {
                    return getResponseEntity.getContent();
                } catch (IllegalStateException e) {
                    getRequest.abort();
                    Log.w(TAG, "Error for URL " + url, e);
                    return null;
                } catch (IOException e) {
                    getRequest.abort();
                    Log.w(TAG, "Error for URL " + url, e);
                    return null;
                }
            } catch (ClientProtocolException e) {
                getRequest.abort();
                Log.w(TAG, "Error for URL " + url, e);
            } catch (IOException e) {
                getRequest.abort();
                Log.w(TAG, "Error for URL " + url, e);
            }
        } catch (IllegalArgumentException e) {
            Log.w(TAG, "Error for URL " + url, e);
        }
        return null;
    }
}
