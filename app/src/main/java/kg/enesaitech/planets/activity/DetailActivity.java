package kg.enesaitech.planets.activity;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.speech.tts.TextToSpeech;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Scanner;
import java.util.stream.Collectors;

import kg.enesaitech.planets.R;
import kg.enesaitech.planets.db.Database;
import kg.enesaitech.planets.db.Planets;


public class DetailActivity extends Activity {

    TextView nameTV, noteTV, descriptionTV;
    ImageView imageIV;
    Activity activity;

    int planet_id;
    String planet_name;
    Database db = new Database(this);

    //Create the Scanner Object that we need
    private static final Scanner scanner = new Scanner(System.in);
    private static final String encoding = "UTF-8";


    @TargetApi(Build.VERSION_CODES.N)
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        nameTV = findViewById(R.id.name_of_planet_detail);
        noteTV = findViewById(R.id.note_of_planet_detail);
        descriptionTV = findViewById(R.id.description_of_planet_detail);
        imageIV = findViewById(R.id.image_of_planet_detail);

        Bundle bundle = getIntent().getExtras();
        if (bundle == null) {
            Toast.makeText(DetailActivity.this, "Your bundle: " + bundle, Toast.LENGTH_LONG).show();
            finish();
            return;
        }
        planet_id = bundle.getInt("planet_id");
        planet_name = bundle.getString("planet_name");
        Planets planet = db.getPlanet(planet_id);


        boolean exit = planet_name.length() <= 1;
        Log.d("BOOLEAN EXIT is : ", String.valueOf(exit));
        //Run until exit =true
        if (!exit) {
            try {

                //Wait for user response
                System.out.println("\n\nType something that you want me to search on the internet...");
                String nextLine = scanner.nextLine();

                String searchText = nextLine + " wikipedia";
                System.out.println("Searching on the web....");
//
//                while (scanner.hasNextLine()) {
//                    String str = scanner.nextLine();
//                    //...
//                }

                //Search the google for Wikipedia Links
                Document google = Jsoup.connect("https://www.google.com/search?q=" + URLEncoder.encode(searchText, encoding)).userAgent("Mozilla/5.0").get();

                //Get the first link about Wikipedia
                String wikipediaURL = google.getElementsByTag(String.valueOf(nameTV)).get(0).text();

                //Use Wikipedia API to get JSON File
                String wikipediaApiJSON =
                        "https://www.wikipedia.org/w/api.php?format=json&action=query&prop=extracts&exintro=&explaintext=&titles="
                                + URLEncoder.encode(wikipediaURL.substring(wikipediaURL.lastIndexOf("/") + 1, wikipediaURL.length()), encoding);

                //Let's see what it found
                System.out.println("WIKIPEDIA URL ****************" + wikipediaURL);
                System.out.println("WIKIPEDIA JSON ****************" + wikipediaApiJSON);

                //"extract":" the summary of the article
                HttpURLConnection httpcon = (HttpURLConnection) new URL(wikipediaApiJSON).openConnection();
                httpcon.addRequestProperty("User-Agent", "Mozilla/5.0");
                BufferedReader in = new BufferedReader(new InputStreamReader(httpcon.getInputStream()));

                //Read line by line
                String responseSB = in.lines().collect(Collectors.joining());
                in.close();

                //Print the result for us to see
                //System.out.println(responseSB);
                String result = responseSB.split("extract\":\"")[1];
                //System.out.println(result);

                //Tell only the 150 first characters of the result
                String textToTell = result.length() > 250 ? result.substring(0, 250) : result;
                System.out.println(textToTell + "...");


            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }

        nameTV.setText(planet.getName());
        noteTV.setText(planet.getNote());
        descriptionTV.setText(planet.getDescription());
//        int id = activity.getResources().getIdentifier(planet.getImage(), "drawable", planet.getImage());
//        imageIV.setImageResource(id);

    }
}