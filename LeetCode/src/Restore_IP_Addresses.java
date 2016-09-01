import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode
 * 93. Restore IP Addresses
 * @author lorreina
 *
 */
public class Restore_IP_Addresses {
    public static List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<String> ();
        if (s == null || s.length() < 4) {
            return res;
        }
        String ip = "";
        dfs(res, ip, s, 0, 4);
        
        return res;
    }

    private static void dfs(List<String> res, String ip, String s, int start, int k) {
        if (s.length() - start < k || s.length() - start > 3 * k) {
            return;
        }
        if (k == 1) {
            if (s.charAt(start) == '0') {
                if (start == s.length() - 1) {
                    res.add(ip + "0");
                }
                return;
            }
            String sub = s.substring(start, s.length());
            if (Integer.parseInt(sub) <= 255) {
                ip = ip + sub;
                res.add(ip);
            }
            return;
        } 
        
        if (s.charAt(start) == '0') {
            dfs(res, ip + "0.", s, start + 1, k - 1);
            return;
        }
        int maxLen = Math.min(s.length() - start - k + 1, 3);
        for (int i = 1; i <= maxLen; i++) {
            String sub = s.substring(start, start + i);
            if (i < 3 || Integer.parseInt(sub) <= 255) {
                String newIp = ip + sub + ".";
                dfs(res, newIp, s, start + i, k - 1);
            }
        }
        
        return;
    }
    
	public static void main(String[] args) {
		String s = "0000";
		List<String> res = restoreIpAddresses(s);
		
		for (int i = 0; i < res.size(); i++) {
			System.out.println(res.get(i));
		}
	}
}
