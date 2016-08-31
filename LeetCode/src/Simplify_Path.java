/**
 * 71. Simplify Path
 * @author lorreina
 *
 */
public class Simplify_Path {
    public static String simplifyPath(String path) {
        if (path == null || path.length() == 0) {
            return null;
        }
        
        String[] paths = path.split("/");
        StringBuilder res = new StringBuilder();
        int upper = 0;
        
        for (int i = paths.length - 1; i >= 0; i--) {
            if (paths[i].equals("") || paths[i].equals(".")) {
                continue;
            } else if (paths[i].equals("..")) {
                upper++;
            } else {
                if (upper > 0) {
                    upper--;
                } else {
                    res.insert(0, "/" + paths[i]);
                }
            }
        }
        
        if (res.length() == 0) {
            return "/";
        } else {
            return res.toString();
        }
    }
    
	public static void main(String[] args) {
		String s1 = "/...";
		System.out.println(simplifyPath(s1));
	}
	
	
}
