/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package quotes;

import org.junit.Test;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class AppTest {
    @Test public void testConvertingJSONtoArray(){

        Path path = Paths.get("src","test","resources","recentquotes.json");
        String p = path.toFile().getAbsolutePath();
        ArrayList<String> tag= new ArrayList<String>();
        tag.add("attributed-no-source");
        Qoutes q = new Qoutes(tag,"Marilyn Monroe","18651 likes"," “I am good, but not an angel. I do sin, but I am not the devil. I am just a small girl in a big world trying to find someone to love.” ");
        assertEquals( q.toString(),String.valueOf(App.convertingJsonFile(p).get(0)));

    }
}
