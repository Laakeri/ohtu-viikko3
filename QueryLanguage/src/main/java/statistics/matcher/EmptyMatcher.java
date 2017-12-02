package statistics.matcher;

import statistics.Player;

public class EmptyMatcher implements Matcher {
    @Override
    public boolean matches(Player p) {
        return true;
    }
}
