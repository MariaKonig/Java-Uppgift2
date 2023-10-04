import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class Dice {

    /*  Metoden skapar en ny fil och fyller den med 1000 randomiserade tal mellan 1-6.
        Har valt att använda FileWriter för att skapa och skriva till fil då det kräver minst kod och blir lättare att överskåda.
        Metoden skapar en ny textfil med namnet "digits". Om filen redan är skapad skriver den över den gamla filen.
        I en for-loop skapas totalt 1000 randomiserade tal mellan 1 - 6 med hjälp av klassen Random.
        I loopen skrivs talen in i den skapade filen efter varandra. Separation mellan talen sker med ett mellanrum.
    */
    public static void createFile() throws IOException {

        FileWriter file = new FileWriter("./digits.txt");

        for (int i = 0; i < 1000; i++) {
            Random random = new Random();
            int number = random.nextInt(6) + 1;
            file.write(number + " ");
        }
        file.close();
    }

    // Metoden createArray() läser textfilen "digits" och returnerar en array med alla talen från filen.
    // Vilken textfil och storlek på array är förutbestämt enl specifikation i uppgift.
    // Metoden loopar igenom den skapade arrayen och tilldelar varje index ett tal från filen med hjälp av metoden nextInt.
    // Har valt att använda Scanner-klassen för den har metoden nextInt vilket underlättar både hämtning av tal från fil
    // och tilldelning av tal till en array.
    public static int[] createArray() throws FileNotFoundException {

        Scanner file = new Scanner(new File("./digits.txt"));
        int[] array = new int[1000];

        for (int i = 0; i < array.length; i++) {
            array[i] = file.nextInt();
        }

        file.close();
        return array;
    }

    /*   Metoden analyseArray() loopar igenom hela arrayen som den fick som in-argument och returnerar en ny array med antal
         förekomster av siffrorna 1-6. Inuti loopen finns en switch-sats som jämför värdena inuti in-argument-arrayen med
         respektive siffra i casen(1-6). för varje siffra som matchar inne i loopen ökar den värdet på motsvarande plats
         inuti den nya arrayen.*/
    public static int[] analyseArray(int[] fullArray) {

        int[] chance = new int[6];

        for (int i = 0; i < fullArray.length; i++) {

            switch (fullArray[i]) {
                case 1:
                    chance[0]++;
                    break;
                case 2:
                    chance[1]++;
                    break;
                case 3:
                    chance[2]++;
                    break;
                case 4:
                    chance[3]++;
                    break;
                case 5:
                    chance[4]++;
                    break;
                case 6:
                    chance[5]++;
                    break;
            }
        }
        return chance;
    }
}