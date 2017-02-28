/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wordsorter;

import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Henrik
 */
public class WordSorter
{

    static String[] wordArray = null;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        WordSorter ws = new WordSorter();
        LoadTextFile textLoader = new LoadTextFile();

        // Here we load up our text of Shakespeare's complete works.
        wordArray = textLoader.loadText();

        Scanner sc = new Scanner(System.in);
        int choice;
        String retry = "y";
        while (retry.toLowerCase().equals("y") || retry.toLowerCase().equals("yes"))
        {
            choice = 0;

            System.out.println("Hello, please insert a number to choose an algorithm for sorting the complete works of Shakespeare."
                    + "\n\nAvailable options are: "
                    + "\n1: Merge sort.");

            while (choice < 1 || choice > 1)
            {
                try
                {

                    choice = sc.nextInt();

                    if (choice < 1)
                    {
                        System.out.println("The number you have entered is too low."
                                + "\nPlease try again.");
                    }
                    else if (choice > 1)
                    {
                        System.out.println("The number you have entered is too high."
                                + "\nPlease try again.");
                    }

                }
                catch (java.util.InputMismatchException e)
                {
                    System.out.println("Sorry, you have chosen a wrong input."
                            + "\nPlease try again.");
                    sc.nextLine();
                }
            }

            ws.sortMethods(choice);
            System.out.println("\nDo you want to try another sorting method? (y/n)");
            retry = sc.next();
        }

    }

    public void sortMethods(int choice)
    {
        WordSorter ws = new WordSorter();
        long start;
        long end;
        long elapsedTime;

        switch (choice)
        {
            case 1:

                // Let's time this
                start = System.nanoTime();
                // System.out.println("Start time: " + start);

                // Not sorted!
                System.out.println("Unsorted: " + Arrays.toString(wordArray.clone()));
                
                // Merge sort
                System.out.println("Beginning to sort text...");
                // System.out.println("Merge sort: " + Arrays.toString(ws.mergeSort(wordArray.clone())));
             
                ws.mergeSort(wordArray.clone());
                end = System.nanoTime();
                elapsedTime = end - start;
                System.out.println("This sorting method took approximately: "
                        + TimeUnit.NANOSECONDS.toSeconds(elapsedTime) + " seconds"
                        + " / "
                        + TimeUnit.NANOSECONDS.toMillis(elapsedTime) + " milliseconds"
                        + " / "
                        + elapsedTime + " nanoseconds");

                break;

            default:
                break;
        }

    }


    public String[] mergeSort(String[] words)
    {
        if (words.length != 1)
        {
            String[] left = new String[words.length / 2];
            String[] right = new String[words.length - words.length / 2];

            for (int i = 0; i < left.length; i++)
            {
                left[i] = words[i];
            }
            for (int i = 0; i < right.length; i++)
            {
                right[i] = words[i + words.length / 2];
            }

            mergeSort(left);
            mergeSort(right);

            merge(words, left, right);

        }

        return words;
    }

    public void merge(String[] result, String[] left, String[] right)
    {
        int i1 = 0;
        int i2 = 0;
        for (int i = 0; i < result.length; i++)
        {
            if (i2 >= right.length || (i1 < left.length
                    && left[i1].compareToIgnoreCase(right[i2]) < 0))
            {
                result[i] = left[i1];
                i1++;
            }
            else
            {
                result[i] = right[i2];
                i2++;
            }
        }

    }

}
