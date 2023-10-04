import java.io.FileWriter;
import java.io.IOException;


public class OneInSix {
    public static void main(String[] arg) throws IOException {

        //Metoderna anropas separat för tydlighetens skull.
        Dice.createFile();
        int[] diceArray = Dice.createArray();
        int[] frequency = Dice.analyseArray(diceArray);

        /*  I variabeln result av typen StringBuilder skapas en formaterad sammanställning över resultatet.
            Stringbuilder används för att jag tyckte det var snyggare att bygga upp en sträng inuti en loop på det här sättet.   */
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < frequency.length; i++) {
            result.append("Siffran ").append(i + 1).append(" förekom: ").append(frequency[i]).append(" ggr.\n");
        }

        /*  Använder FileWriter för att skapa en ny textfil med namnet "frequency".
            I filen sparas det färdigformaterade resultatet från variabeln result.
            "result" är av typen Stringbuilder och behövde omvandlas då FileWriter.write bara hanterar strängar.
            Slutligen görs en utskrift till terminalen och där behövde result inte omvandlas till String då
            system.out.println automatiskt tillkallar metoden String.ValueOf(). */
        FileWriter writer = new FileWriter("./frequency.txt");
        writer.write(String.valueOf(result));
        writer.close();
        System.out.println(result);

        //  Extra uppgift:
        //  Anropar metoden CountMyFile från klassen FileAnalyser som tar in en fil och returnerar antal karaktärer
        //  som finns i filen.

        int elements = FileAnalyzer.countMyFile("./testText.txt");
        System.out.println("Det finns: " + elements + " karaktärer i filen");
    }
}


/*
G-uppgiften kändes lagom och ganska kul för en G uppgift. Fick med alla momenten vi har gått igenom utan att det kändes krångligt.
VG-uppgiften hade vart otroligt krånglig utan metoden readString. I föreläsning 5 nämnde du att det gick att
läsa in allt genom File.readAll(), hade glömt vad det hette och när jag försökte googla fram den hittade jag den här metoden vilket
var ganska snarlik.
 */