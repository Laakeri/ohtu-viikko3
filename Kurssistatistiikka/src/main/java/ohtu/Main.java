package ohtu;

import com.google.gson.Gson;
import java.io.IOException;
import org.apache.http.client.fluent.Request;

public class Main {
    
    private static <T> T getFromUrl(String url, Class<T> classOfT) throws IOException {
        String bodyText = Request.Get(url).execute().returnContent().asString();
        Gson mapper = new Gson();
        return mapper.fromJson(bodyText, classOfT);
    }
    
    private static Submission[] getSubmissions(String studentNr) throws IOException {
        String url = "https://studies.cs.helsinki.fi/ohtustats/students/"+studentNr+"/submissions";
        return getFromUrl(url, Submission[].class);
    }
    
    private static CourseInfo getCourseInfo() throws IOException {
        String url = "https://studies.cs.helsinki.fi/ohtustats/courseinfo";
        return getFromUrl(url, CourseInfo.class);
    }

    public static void main(String[] args) throws IOException {
        // vaihda oma opiskelijanumerosi seuraavaan, ÄLÄ kuitenkaan laita githubiin omaa opiskelijanumeroasi
        String studentNr = "xxx";
        if ( args.length>0) {
            studentNr = args[0];
        }

        Submission[] subs = getSubmissions(studentNr);
        CourseInfo courseInfo = getCourseInfo();
        
        System.out.print("Kurssi: " + courseInfo.getName() + ", " + courseInfo.getTerm() + "\n\n");
        
        System.out.print("opiskelijanumero: " + studentNr + "\n\n");
        
        int totalExercises = 0;
        int totalHours = 0;
        
        for (Submission sub : subs) {
            System.out.print("viikko " + sub.getWeek() + ":\n");
            System.out.print("  tehtyjä tehtäviä yhteensä: " + sub.getExercises().size());
            System.out.print(" (maksimi " + courseInfo.getExerciseMax(sub.getWeek()) + ")");
            System.out.print(", aikaa kului " + sub.getHours() + " tuntia");
            System.out.print(", tehdyt tehtävät:");
            for (Integer e : sub.getExercises()) {
                System.out.print(" " + e);
            }
            System.out.print("\n");
            
            totalExercises += sub.getExercises().size();
            totalHours += sub.getHours();
        }
        System.out.print("\nyhteensä: " + totalExercises + " tehtävää " + totalHours + " tuntia\n");
    }
}