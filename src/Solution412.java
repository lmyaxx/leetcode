import java.util.ArrayList;
import java.util.List;

/**
 * @Author : Chad li
 * @Date : 2020/1/28 12:30
 * @Version 1.0
 */
public class Solution412 {
    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();
        for(int i=1;i<=n;i++){
            result.add(Integer.toString(i));
        }
        for(int i=3;i<=n;i+=3){
            result.set(i-1,"Fizz");
        }
        for(int i=5;i<=n;i+=5){
            result.set(i-1,"Buzz");
        }
        for(int i=15;i<=n;i+=15){
            result.set(i-1,"FizzBuzz");
        }
        return result;
    }
}
