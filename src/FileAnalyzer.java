import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/*  Metoden readString() i klassen Files läser in ALLA karaktärer från en fil på en gång och returnerar
    dom som en sträng. Vilket kändes passande för uppgiften.
    Metoden har som in-argument ett objekt av typen "Path". Genom att använda metoden "Path.of()"som konverterar
    strängar till path objekt kunde jag använda mig av readString() metoden.
    Resultatet sparade jag i en strängvariabel "content" och använde metoden .length() för att få längden
    och därmed antal karaktärer i filen.
*/
public class FileAnalyzer {
    public static int countMyFile(String filename) throws IOException {

      Path path = Path.of("./" + filename);
      String content = Files.readString(path);

      return content.length();
    }
}