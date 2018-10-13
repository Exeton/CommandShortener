package online.fireflower.mortal_shortener;

import java.util.Comparator;

//Source https://stackoverflow.com/questions/8632857/sorting-string-lengths-using-comparator
public class StringSizeComparator implements Comparator<String> {
    public int compare(String o1, String o2) {
        return Integer.compare(o1.length(), o2.length());
    }
}
