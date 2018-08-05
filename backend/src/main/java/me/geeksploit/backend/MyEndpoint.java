package me.geeksploit.backend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

import javax.inject.Named;

import me.geeksploit.javajokes.SillyJoker;

/**
 * An endpoint class we are exposing
 */
@Api(
        name = "myApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.geeksploit.me",
                ownerName = "backend.geeksploit.me",
                packagePath = ""
        )
)
public class MyEndpoint {

    /**
     * A simple endpoint method that takes a name and says Hi back
     */
    @ApiMethod(name = "sayHi")
    public MyBean sayHi(@Named("name") String name) {
        MyBean response = new MyBean();
        response.setData("Hi, " + name);

        return response;
    }

    /**
     * An endpoint method that tells a joke
     */
    @ApiMethod(name = "tellJoke")
    public MyBean tellJoke() {
        // TODO: could you please elaborate on why does it fail to use an interface in place of concrete implementation?
        // To reproduce the error:
        // 1. Uncomment the following line (and comment the next one).
        // 2. Do Build -> Clean.
        // 3. Notice how Run tasks fail with the 'Unable to load class ...Joker' message.
        // 4. Also notice that consequent builds also fail until you switch back to using an implementation instead of the interface.
//        Joker joker = new SillyJoker();
        SillyJoker joker = new SillyJoker();

        MyBean response = new MyBean();
        response.setData(joker.tellJoke());

        return response;
    }
}
