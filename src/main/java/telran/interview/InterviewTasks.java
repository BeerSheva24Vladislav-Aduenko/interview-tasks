package telran.interview;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Set;
import java.util.List;
import java.util.TreeMap;

public class InterviewTasks {
    /**
     * 
     * @param array
     * @param sum
     * @return true if a given array comprises of two number,
     *  summing of which gives the value equaled to a given "sum" value
     */
    static public boolean hasSumTwo(int [] array, int sum) {
        HashSet<Integer> helpers = new HashSet<>();
        int index = 0;
        while(index < array.length && !helpers.contains(sum - array[index])) {
            helpers.add(array[index++]);
        }
        return index < array.length;
    }
    static public int getMaxWithNegativePresentation(int [] array) {
     Set<Integer> helper = new HashSet<>();
     int res = -1;
     for (int i = 0; i < array.length; i++) {
        if(helper.contains(-array[i])) {
            res = Math.max(res, Math.abs(array[i]));
        }
        helper.add(array[i]);
     }
     return res;
    }

    public static List<DateRole> assignRoleDates(List<DateRole> rolesHistory,
		List<LocalDate> dates) {
        TreeMap<LocalDate, String> history = new TreeMap<>();
        rolesHistory.forEach(dateRole -> history.put(dateRole.date(), dateRole.role()));

        List<DateRole> roles = dates.stream().map(date -> {
            LocalDate floorKey = history.floorKey(date);
            String role = floorKey != null ? history.get(floorKey) : null;
            return new DateRole(date, role);
        }).toList();
    
        return roles;
}
public static boolean isAnagram(String word, String anagram) {
    return word.length() == anagram.length() && !word.equals(anagram) && compareLetters(word, anagram);
}

private static boolean compareLetters(String word, String anagram) {
    HashMap<Character, Integer> WordbyLetter = getWordByLetter(word);
    boolean res = true;
    int i = 0;
    while (res && i < anagram.length()) {
        char letter = anagram.charAt(i);
        int countInWord = WordbyLetter.getOrDefault(letter, 0);
        if (countInWord == 0) {
            res=false; 
        }
            WordbyLetter.put(letter, countInWord -1);
            i++;
    }
    return res;
}

private static HashMap<Character, Integer> getWordByLetter(String word) {
    HashMap<Character, Integer> WordbyLetter = new HashMap<>();
    for (int i = 0; i < word.length(); i++) {
        WordbyLetter.merge(word.charAt(i), 1, Integer::sum);
    }
    return WordbyLetter;
}

}