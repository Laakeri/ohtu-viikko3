package statistics.matcher;

// jostain syystä materiaalissa ei tehdä aina uutta querybuilder oliota mutta 
// mun mielestä se on pakollista että saadaan toiminnallisuus jossa käyttäjä ei 
// voi tehdä outoja virheitä
public class QueryBuilder {
    private final Matcher matcher;
    public QueryBuilder() {
        this.matcher = new EmptyMatcher();
    }
    
    private QueryBuilder(Matcher matcher) {
        this.matcher = matcher;
    }
    
    public QueryBuilder playsIn(String team) {
        return new QueryBuilder(new And(this.matcher, new PlaysIn(team)));
    }
    
    public QueryBuilder hasAtLeast(int n, String category) {
        return new QueryBuilder(new And(this.matcher, new HasAtLeast(n, category)));
    }
    
    public QueryBuilder hasFewerThan(int n, String category) {
        return new QueryBuilder(new And(this.matcher, new HasFewerThan(n, category)));
    }
    
    // tässä varmaan kannattais olla querybuilderit parametrinä
    public QueryBuilder oneOf(Matcher... matchers) {
        return new QueryBuilder(new Or(matchers));
    }
    
    public Matcher build() {
        return matcher;
    }
}
