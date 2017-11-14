package ohtu;

import com.google.gson.Gson;
import java.io.IOException;
import org.apache.http.client.fluent.Request;

public class Main {

    public static void main(String[] args) throws IOException {
        // vaihda oma opiskelijanumerosi seuraavaan, ÄLÄ kuitenkaan laita githubiin omaa opiskelijanumeroasi
        String studentNr = "xxx";
        if ( args.length>0) {
            studentNr = args[0];
        }

        String url = "https://studies.cs.helsinki.fi/ohtustats/students/"+studentNr+"/submissions";

        String bodyText = Request.Get(url).execute().returnContent().asString();

        Gson mapper = new Gson();
        Submission[] subs = mapper.fromJson(bodyText, Submission[].class);
        
        System.out.print("opiskelijanumero: " + studentNr + "\n\n");
        
        int totalExercises = 0;
        int totalHours = 0;
        
        for (Submission sub : subs) {
            System.out.print("viikko " + sub.getWeek() + ": ");
            System.out.print("tehtyjä tehtäviä yhteensä: " + sub.getExercises().size());
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