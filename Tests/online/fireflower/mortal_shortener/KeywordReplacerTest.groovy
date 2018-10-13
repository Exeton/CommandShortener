package online.fireflower.mortal_shortener

import org.junit.Assert
import org.junit.Test

class KeywordReplacerTest extends GroovyTestCase {

    @Test
    void testReplace() throws Exception{

        HashMap<String, String> replacements = new HashMap<>();
        replacements.put("#hacks", "for hacking");
        KeywordReplacer keywordReplacer = new KeywordReplacer(replacements);


        String message = "/ban Notch #hacks";
        String expected = "/ban Notch for hacking";
        Assert.assertEquals(expected, keywordReplacer.replace(message))
    }

    @Test
    void testReplacementSubstrings() throws Exception{

        HashMap<String, String> replacements = new HashMap<>();
        replacements.put("#reason", "lol");
        replacements.put("#reasonA", "for being a big noob");//This one must follow "reasons"
        KeywordReplacer keywordReplacer = new KeywordReplacer(replacements);

        String message = "/ban Notch #reasonA";
        Assert.assertEquals("/ban Notch for being a big noob", keywordReplacer.replace(message));
    }
}
