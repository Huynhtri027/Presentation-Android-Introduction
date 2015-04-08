package be.hogent.jensbuysse.chucknorrisjokes;

/**
 * Created by jbuy519 on 08/04/2015.
 */
public class Joke {

    /**
     * The be.hogent.jensbuysse.chucknorrisjokes.Joke
     */
    private String joke;

    /**
     * An id of the joke
     */
    private int id;

    public Joke(String joke, int id) {
        this.joke = joke;
        this.id = id;
    }

    public String getJoke() {
        return joke;
    }

    public void setJoke(String joke) {
        this.joke = joke;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return joke;
    }
}
