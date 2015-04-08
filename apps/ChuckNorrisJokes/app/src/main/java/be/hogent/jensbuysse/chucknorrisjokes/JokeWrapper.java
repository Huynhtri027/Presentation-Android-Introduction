package be.hogent.jensbuysse.chucknorrisjokes;

import com.google.gson.annotations.SerializedName;

/**
 * Created by jbuy519 on 08/04/2015.
 */
public class JokeWrapper {

    private String type;

    @SerializedName("value")
    private Joke joke;

    public Joke getJoke() {
        return joke;
    }

    public void setJoke(Joke joke) {
        this.joke = joke;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
