/**
 * Created by rashmimech on 2/27/17.
 *
 mming Bit Manipulation Reverse Bits

 Reverse Bits

 Reverse bits of an 32 bit unsigned integer

 Example 1:

 x = 0,

 00000000000000000000000000000000
 =>        00000000000000000000000000000000

 return 0

 Example 2:

 x = 3,

 00000000000000000000000000000011
 =>        11000000000000000000000000000000

 return 3221225472


 */
public class ReverseBits {
    public static void main(String[] args) {
        System.out.println(new ReverseBits().reverse(3));
    }

    public long reverse(long a) {
        long res = 0;
        for(int i = 0; i < 32; i++){
            res = res << 1;
            if((a & (1 << i)) != 0){
                res |= 1;
            }
        }
        return res;
    }
}
