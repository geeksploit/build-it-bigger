package me.geeksploit.javajokes;

import java.util.ArrayList;
import java.util.List;

public final class SillyJoker implements Joker {

    private List<String> jokes = new ArrayList<String>() {{
        add("Q: What goes up and down but does not move?\nA: Stairs");
        add("Q: Where should a 500 pound alien go?\nA: On a diet");
        add("Q: Why did the picture go to jail?\nA: Because it was framed.");
        add("Q: What did one wall say to the other wall?\nA: I'll meet you at the corner.");
        add("Q: What did the paper say to the pencil?\nA: Write on!");
        add("Q: What do you call a boy named Lee that no one talks to?\nA: Lonely");
        add("Q: Why do bicycles fall over?\nA: Because they are two-tired!");
        add("Q: Why do dragons sleep during the day?\nA: So they can fight knights!");
        add("Q: What did Cinderella say when her photos did not show up?\nA: Someday my prints will come!");
        add("Q: Why was everyone so tired on April 1st?\nA: They had just finished a March of 31 days.");
    }};

    public SillyJoker(List<String> jokes) {
        this.jokes = jokes;
    }

    @Override
    public String tellJoke() {
        if (jokes.isEmpty()) return null;

        int jokeId = (int) (Math.random() * jokes.size());
        return jokes.get(jokeId);
    }
}
