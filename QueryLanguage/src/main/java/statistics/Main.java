package statistics;

import statistics.matcher.*;

public class Main {
    static void tryMatcher(Statistics stats, Matcher m) {
        System.out.println("matches:");
        for (Player player : stats.matches(m)) {
            System.out.println( player );
        }
    }
    public static void main(String[] args) {
        Statistics stats = new Statistics(new PlayerReaderImpl("http://nhlstats-2013-14.herokuapp.com/players.txt"));
          
        Matcher m1 = new And( new HasAtLeast(10, "goals"),
                             new HasAtLeast(10, "assists"),
                             new PlaysIn("PHI")
        );
        
        Matcher m2 = new Not( new HasAtLeast(1, "goals") );
        
        Matcher m3 = new Or( new HasAtLeast(40, "goals"),
                            new HasAtLeast(60, "assists"),
                            new HasAtLeast(85, "points")
        );
        
        Matcher m4 = new HasFewerThan(1, "goals");
        tryMatcher(stats, m1);
        tryMatcher(stats, m2);
        tryMatcher(stats, m3);
        tryMatcher(stats, m4);
    }
}
