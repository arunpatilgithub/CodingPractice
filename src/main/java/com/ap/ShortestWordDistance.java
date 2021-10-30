package com.ap;

public class ShortestWordDistance
{
    public static void main(String[] args)
    {
        String[] wordsDict = { "practice", "makes", "perfect", "coding", "makes" };

        //System.out.println(shortestDistance(wordsDict, "coding", "practice"));
        //System.out.println(shortestDistance(wordsDict, "makes", "coding"));

        System.out.println(shortestDistanceOptimal(wordsDict, "coding", "practice"));
        System.out.println(shortestDistanceOptimal(wordsDict, "makes", "coding"));
    }

    public static int shortestDistance(String[] wordsDict, String word1, String word2)
    {

        int minDiff = Integer.MAX_VALUE;

        for (int i = 0; i < wordsDict.length; i++)
        {
            for (int j = i + 1; j < wordsDict.length; j++)
            {
                if (( wordsDict[i].equals(word1) && wordsDict[j].equals(word2) ) ||
                    ( wordsDict[j].equals(word1) && wordsDict[i].equals(word2) ))
                {
                    minDiff = Math.min(minDiff, j - i);
                }
            }
        }

        //Big(O) = n^2.

        return minDiff;
    }

    /**
     * Input: wordsDict = ["practice", "makes", "perfect", "coding", "makes"]
     * word1 = "coding",
     * word2 = "practice"
     * Output: 3
     */
    public static int shortestDistanceOptimal(String[] wordsDict, String word1, String word2)
    {

        int minDiff = Integer.MAX_VALUE;

        int word1Index = -1;
        int word2Index = -1;

        for (int i = 0; i < wordsDict.length; i++)
        {
            if (word1.equals(wordsDict[i]))
            {
                word1Index = i; //3
            }
            else if (word2.equals(wordsDict[i]))
            {
                word2Index = i; //0
            }

            if (word1Index != -1 && word2Index != -1)
            {
                minDiff = Math.min(Math.abs(word1Index - word2Index), minDiff);
            }
        }

        //Big(O) = n.
        return minDiff;
    }
}
