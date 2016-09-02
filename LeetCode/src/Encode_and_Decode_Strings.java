import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode
 * 271. Encode and Decode Strings
 * @author lorreina
 *
 */
public class Encode_and_Decode_Strings {
	public class Codec {

	    // Encodes a list of strings to a single string.
	    public String encode(List<String> strs) {
	        if (strs == null || strs.size() == 0) {
	            return "0=";
	        }
	        
	        StringBuilder res = new StringBuilder();
	        res.append(strs.size());
	        StringBuilder s = new StringBuilder();
	        
	        for (int i = 0; i < strs.size(); i++) {
	            res.append(",");
	            res.append(strs.get(i).length());
	            s.append(strs.get(i));
	        }
	        
	        res.append("=");
	        res.append(s);
	        
	        return res.toString();
	    }

	    // Decodes a single string to a list of strings.
	    public List<String> decode(String s) {
	        List<String> res = new ArrayList<String> ();
	        int index = s.indexOf("=");
	        String[] len = s.substring(0, index).split(",");
	        int size = Integer.parseInt(len[0]);
	        if (size == 0) {
	            return res;
	        }
	        
	        index++;
	        for (int i = 0; i < size; i++) {
	            int strLen =Integer.parseInt(len[i + 1]);
	            String str = s.substring(index,  index + strLen);
	            res.add(str);
	            index += strLen;
	        }
	        
	        return res;
	    }
	}

	// Your Codec object will be instantiated and called as such:
	// Codec codec = new Codec();
	// codec.decode(codec.encode(strs));
}
