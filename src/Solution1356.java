import java.util.Arrays;
import java.util.stream.Collectors;

public class Solution1356 {
    public int[] sortByBits(int[] arr) {
        return Arrays.stream(arr).boxed()
                .sorted((o1, o2) -> {
                    int b1 = Integer.bitCount(o1);
                    int b2 = Integer.bitCount(o2);
                    return b1==b2?o1-o2:b1-b2;
                })
                .collect(Collectors.toList())
                .stream().mapToInt(i->i)
                .toArray();
    }
}
