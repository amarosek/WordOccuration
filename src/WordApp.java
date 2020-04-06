import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class WordApp {

    String text;
    String word;

    public WordApp() throws Exception {
        displayOptions();
    }

    public void displayOptions() throws Exception {
        final StringBuilder sb;
        sb = new StringBuilder();
        sb.append("Choose one of the options: ")
                .append("\n1. Read from file,")
                .append("\n2. Paste your text.")
                .append("\n3. Exit program");

        System.out.println(sb.toString());

        Scanner in = new Scanner(System.in);
        int command = in.nextInt();

        switch (command) {
            case 1:
                readFile();
                countExactWords();
            case 2:
                pasteText();
                countExactWords();
            case 3:
                System.exit(0);
        }
    }

    public void readFile() throws Exception {

        System.out.println("Enter your file path: ");
        Scanner in = new Scanner(System.in);
        String path = in.nextLine();

        File file = new File(path);

        BufferedReader br = new BufferedReader(new FileReader(file));

        int countOfTokens;

        text = br.readLine();

        if (text != null) {
            System.out.println(text);
            countOfTokens = new StringTokenizer(text).countTokens();
            System.out.println("Your text has " + countOfTokens + " words.");

        } else {
            System.out.println("File is empty, try again.");
            System.exit(0);
        }
    }


    public void pasteText() {
        System.out.println("Paste in your text: ");
        Scanner sc = new Scanner(System.in);
        text = sc.nextLine();

        int countOfTokens = new StringTokenizer(text).countTokens();

        System.out.println("Your text has " + countOfTokens + " words.");
    }

    public void countExactWords() {

        System.out.println("Type word you want to find: ");
        Scanner sc = new Scanner(System.in);
        word = sc.nextLine();

        String temp[] = text.toLowerCase().split(" ");
        int count = 0;
        for (int i = 0; i < temp.length; i++) {
            if (word.toLowerCase().equals(temp[i]))
                count++;
        }
        System.out.println("The word " + word + " occurs " + count + " times in your text");
    }
}

