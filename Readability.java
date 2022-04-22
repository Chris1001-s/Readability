import java.util.*;
import java.lang.Math;

public class Readability {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int letterCount = 0;
        int wordCount = 0;
        int sentenceCount = 0;

        // Just taking the input
        System.out.println("Please provide some text as input");
        String text = input.nextLine();

        for (int i = 0; i< text.length(); i++) {
            //checking letter
            if ((text.charAt(i)>= 'a' && text.charAt(i) <= 'z') || (text.charAt(i) >= 'A' && text.charAt(i) <= 'Z')) {

                letterCount++;
            }
            // any chars separated by space is a word
            if (text.charAt(i) == ' ' || text.charAt(i) == '\0')
            {
                wordCount++;

            }
            // when you see a . ! or ? count as sentence
            if (text.charAt(i) == '!' || text.charAt(i) == '.'|| text.charAt(i) == '?')
            {
                sentenceCount++;
            }
        }

        int readingIndex = 0;
        // calculating grade
        if (wordCount != 0){
            double averageWordsPer100 = (letterCount * 100) / wordCount;
            double averageSentencePer100 = (sentenceCount * 100) / wordCount;
            readingIndex = (int) Math.round(0.0588 * averageWordsPer100 - 0.296 * averageSentencePer100 - 15.8);
        }


        if (readingIndex < 1)
        {
            System.out.println("Before Grade 1");
        }
        else if (readingIndex > 16)
        {
            System.out.println("Grade 16");
        }
        else
        {
            System.out.printf("Grade " + readingIndex);
        }

        input.close();
    }

}
