
 package quotes;

 import com.google.gson.*;
 import java.io.File;
 import java.io.FileNotFoundException;
 import java.io.FileReader;
 import java.nio.file.Path;
 import java.util.ArrayList;

public class App {


    public static void main(String[] args) {


        ArrayList<String> allQuotes = convertingJsonFile("recentquotes.json");
        System.out.println(randomQuote(allQuotes));
    }

    public static ArrayList<String> convertingJsonFile(String path){
        File file = new File(path);
        ArrayList<String> quotes= new ArrayList<String>();
        try {
            JsonElement fileQuote = JsonParser.parseReader(new FileReader(file));
            // get Json array
            JsonArray quotesArray = fileQuote.getAsJsonArray();
            //    System.out.println(quotesArray);


            // convert Json array
            for (JsonElement jsonElement : quotesArray) {

                JsonObject quoteObj = jsonElement.getAsJsonObject();

                JsonArray tagsArr = quoteObj.getAsJsonArray("tags");
                // System.out.println(tagsArr);
                ArrayList<String> tags = new ArrayList<String>();
                for (JsonElement element : tagsArr) {
                    tags.add(element.getAsString()) ;
                }
                // System.out.println(tags);

                String author = quoteObj.get("author").getAsString();
                String likes = quoteObj.get("likes").getAsString();
                String text = quoteObj.get("text").getAsString();

                //  System.out.println(author);
                Qoutes quote = new Qoutes(tags,author,likes,text);
                quotes.add(quote.toString());
            }
            //  System.out.println("Array list-Json converted : "+quotes);

        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return quotes;
    }

    public static String randomQuote(ArrayList<String> q){
        int idx = (int) (Math.random()*q.size());
//        System.out.println(q.get(idx));
        return q.get(idx);
    }
}
