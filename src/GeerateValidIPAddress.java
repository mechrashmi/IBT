import java.util.ArrayList;

/**
 * Created by rashmimech on 4/1/17.
 */
public class GeerateValidIPAddress {
    public static void main(String[] args) {
        ArrayList<String> res = new GeerateValidIPAddress().restoreIpAddresses("1101111111");

        for(String ip : res){
            System.out.println(ip);
        }
    }

    public ArrayList<String> restoreIpAddresses(String a) {
        ArrayList<String> res = new ArrayList<>();
        int dots = 0;

        StringBuilder ip = new StringBuilder(a);
        generateValidIps(ip, res, dots);

        return res;
    }

    private boolean generateValidIps(StringBuilder a, ArrayList<String> res, int dots) {

        if(dots == 3) return isValidIp(a.toString());

        int i = a.toString().lastIndexOf('.') + 2;
        int n = a.length();

        for(; i < n; i++){
            a.insert(i, '.');
            if(generateValidIps(a, res, dots + 1)){
                res.add(a.toString());
            }

            a.deleteCharAt(i);
        }

        return false;
    }

    private boolean isValidIp(String a) {
        String[] parts = a.split("\\.");
        if(parts.length != 4) return false;

        for(int i = 0; i < parts.length; i++){
            String val = parts[i];

            if(val.charAt(0) == '0' && val.length() > 1)
                return false;

            Integer intVal = Integer.parseInt(val);

            if(intVal > 255)
                return false;
        }

        return true;
    }
}
