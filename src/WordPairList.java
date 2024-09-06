import java.util.*;
public class WordPairList {
    private ArrayList<WordPair> allPairs;
    public WordPairList(String[] words) {
        allPairs = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            for (int j = i+1; j < words.length; j++) {
                allPairs.add(new WordPair(words[i], words[j]));
            }
        }
    }
    public int numMatches() {
        int cnt = 0;
        ArrayList<WordPair> copy = allPairs;

        for (int i = 0; i < copy.size(); i++) {
            int x = 0;

            for (int j = 0; j < copy.size(); j++) {        // checks for duplicate pairs
                if (copy.get(i).getFirst().equals(copy.get(j).getFirst())) {
                    if (copy.get(i).getSecond().equals(copy.get(j).getSecond())) x++;
                }
            }

            if (x > 1) {
                cnt++;

                for (int k = 0; k < copy.size(); k++) {     // removes all duplicate pairs from temp arraylist
                    if (copy.get(i).getFirst().equals(copy.get(k).getFirst())) {
                        if (copy.get(i).getSecond().equals(copy.get(k).getSecond())) copy.remove(copy.get(k));
                    }
                }
            }
        }

        return cnt;
    }
    public ArrayList<WordPair> getAllPairs() {
        return allPairs;
    }
    public void setAllPairs(ArrayList<WordPair> allPairs) {
        this.allPairs = allPairs;
    }
}
