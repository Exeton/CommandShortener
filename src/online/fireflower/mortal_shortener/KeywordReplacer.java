package online.fireflower.mortal_shortener;

import java.util.Map;

public class KeywordReplacer {
    private Map<String, String> replacements;

    public KeywordReplacer(Map<String, String> replacements){
        this.replacements = replacements;
    }

    public String replace(String msg){
        for (String keyword : replacements.keySet()){
            msg = msg.replace(keyword, replacements.get(keyword));
        }
        return msg;
    }

}
