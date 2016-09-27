import java.util.Stack;

/**
 * 71. Simplify Path
 * @author lorreina
 *
 */
public class Simplify_Path {
//    public static String simplifyPath(String path) {
//        if (path == null || path.length() == 0) {
//            return null;
//        }
//        
//        String[] paths = path.split("/");
//        StringBuilder res = new StringBuilder();
//        int upper = 0;
//        
//        for (int i = paths.length - 1; i >= 0; i--) {
//            if (paths[i].equals("") || paths[i].equals(".")) {
//                continue;
//            } else if (paths[i].equals("..")) {
//                upper++;
//            } else {
//                if (upper > 0) {
//                    upper--;
//                } else {
//                    res.insert(0, "/" + paths[i]);
//                }
//            }
//        }
//        
//        if (res.length() == 0) {
//            return "/";
//        } else {
//            return res.toString();
//        }
//    }
	
	public static String simplifyPath(String path) {
        if (path == null || path.length() == 0) {
            return "/";
        }
        
        Stack<String> stack = new Stack<String> ();
        String[] dirs = path.split("/");
        
        for (String dir : dirs) {
            if (dir.equals(".")) {
                continue;
            } else if (dir.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (dir.length() > 0) {
            	stack.push(dir);
            }
        }
        
        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) {
            res.insert(0, stack.pop());
            res.insert(0, '/');
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
