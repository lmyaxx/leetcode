package solution201_400;

import Common.WordDictionary;
import org.junit.Test;

/**
 * @Author : Chad li
 * @Date : 2020/3/11 10:02
 * @Version 1.0
 */
public class Solution211 {

    @Test
    public void test(){
        WordDictionary wordDictionary = new WordDictionary();
        //["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
        //[[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        wordDictionary.addWord("pad");
        wordDictionary.addWord("bad");
        wordDictionary.search(".ad");
        wordDictionary.search("b..");
    }
}
