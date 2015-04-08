package be.hogent.jensbuysse.chucknorrisjokes;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by jbuy519 on 08/04/2015.
 */
public class JokeReceiver extends BroadcastReceiver {

    private JokeInterface jokeInterface;

    public static String ACTION_RECEIVE_JOKE = "be.hogent.jensbuysse.chucknorrisjokes.ACTION_RECEIVE_JOKE";

    public JokeReceiver(JokeInterface jokeInterface) {
        this.jokeInterface = jokeInterface;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        String jokeString = intent.getStringExtra(DownloadJokeTask.PARAM_OUT_JOKE);
        jokeInterface.addJoke(jokeString);
    }
}
