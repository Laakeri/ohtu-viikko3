package ohtu;

public class CourseInfo {
    private String name;
    private String term;
    private int[] exercises;
    
    public String getName() {
        return name;
    }
    
    public String getTerm() {
        return term;
    }
    
    public int getExerciseMax(int week) {
        return exercises[week - 1];
    }
}
