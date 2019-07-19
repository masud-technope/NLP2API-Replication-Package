import java.security.SecureRandom;
import java.util.Arrays;
import java.util.stream.IntStream;
/*from w ww .  j  a  va 2 s  .c  om*/
public class Main {

    public static void main(String[] args) {
        SecureRandom secureRandom = new SecureRandom(new byte[]{1, 3, 3, 7});
        int[] randoms = IntStream.generate(secureRandom::nextInt)
                .filter(n -> n > 0)
                .limit(10)
                .toArray();
        System.out.println(Arrays.toString(randoms));


        int[] nums = IntStream.iterate(1, n -> n * 2)
                .limit(11)
                .toArray();
        System.out.println(Arrays.toString(nums));
    }
}
