import java.util.ArrayList;
import java.util.List;

public class Solution068 {
    public List<String> fullJustify(String[] words, int maxWidth) {
        int count = words.length,left,right,space;
        List<String> result = new ArrayList<>();
        for(left=0;left<count;){
            StringBuilder str= new StringBuilder("");
            str.append(words[left]);
            right=left;space=maxWidth-words[left].length();
            while(right+1<count&&space-words[right+1].length()-1>0){
                space -=words[right+1].length()+1;
                right++;
            }
            space +=(right-left);
            if(left==right){
                left++;
                str.append(generateSpace(space));
            }else{
                int interval = space/(right-left);
                int time = space % (right-left);
                left++; //the first word has been add into the row
                while(left<=right){
                    if(right==count-1){
                        str.append(generateSpace(1));
                    }else if(time-->0){
                        str.append(generateSpace(interval+1));
                    }else
                        str.append(generateSpace(interval));
                    str.append(words[left++]);
                }
                int extra = maxWidth-str.length();
                str.append(generateSpace(extra));
            }
            result.add(str.toString());
        }
        return result;
    }
    private String generateSpace(int len){
        char s[] = new char[len];
        len--;
        while(len>=0)
            s[len--]=' ';
        return String.valueOf(s);
    }
}
