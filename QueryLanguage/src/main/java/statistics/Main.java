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
          
        QueryBuilder query = new QueryBuilder();

        Matcher m1 = query.playsIn("NYR")
                         .hasAtLeast(10, "goals")
                         .hasFewerThan(25, "assists").build();

        tryMatcher(stats, m1);

        Matcher m2 = query.playsIn("PHI")
                      .hasAtLeast(10, "goals")
                      .hasFewerThan(20, "assists").build();

        Matcher m3 = query.playsIn("EDM")
                          .hasAtLeast(60, "points").build();

        Matcher m4 = query.oneOf(m2, m3).build();
        
        tryMatcher(stats, m4);
    }
}
