package online.fireflower.mortal_shortener;

import java.util.*;

public class KeywordReplacer {

    private Map<String, String> replacements;
    private List<String> largestToSamllestKeys;

    public KeywordReplacer(Map<String, String> replacements){
        this.replacements = replacements;
        largestToSamllestKeys = new ArrayList<>(replacements.keySet());
        Collections.sort(largestToSamllestKeys, new StringSizeComparator());
        Collections.reverse(largestToSamllestKeys);
    }

    public String replace(String msg){

        //Check longest keywords first in case one keyword is a substring of another
        for (String keyword : largestToSamllestKeys){
            msg = msg.replace(keyword, replacements.get(keyword));
        }
        return msg;
    }

}
