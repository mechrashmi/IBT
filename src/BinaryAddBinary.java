

public class BinaryAddBinary {

    public static void main(String[] args) {
        BinaryAddBinary test = new BinaryAddBinary();
        System.out.println(test.addBinary("100", "11"));
        System.out.println(test.addBinary("100", "1"));
        System.out.println(test.addBinary("111", "111"));
        System.out.println(test.addBinary("1000", "11"));
        System.out.println(test.addBinary("1000", "1111"));
    }

    public String addBinary(String a, String b) {
        StringBuffer aBuffer = new StringBuffer(a);
        StringBuffer bBuffer = new StringBuffer(b);
        StringBuffer result = new StringBuffer();
        int len = 0;
        if(a.length() > b.length()){
            len = a.length() - b.length();
            int i = 0;
            while(len != 0){
                bBuffer.insert(i++, 0);
                len--;
            }
        }
        else{
            len = b.length() -  a.length();
            int i = 0;
            while(len != 0){
                aBuffer.insert(i++, 0);
                len--;
            }
        }
        int carry = 0;
        for(int i = aBuffer.length() - 1; i >= 0; i--){
            int c = (Character.getNumericValue(aBuffer.charAt(i)) + Character.getNumericValue(bBuffer.charAt(i)) + carry);
            result.append(c % 2);
            carry = c / 2;

        }

        if(carry == 1){
            result.append('1');
        }

        return result.reverse().toString();
    }
}
