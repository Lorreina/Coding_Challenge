import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Vector;

public class SuperStack {
	public static void main(String args[]) throws Exception {
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(stdin.readLine());
		PrintWriter out = new PrintWriter(System.out);
		Vector<Long> stack = new Vector<Long>();
		Vector<Long> inc = new Vector<Long>();
		int length = 0;
		for (int i = 0; i < n; i++) {
			String cmd = stdin.readLine();
			String cmds[] = cmd.split(" ");
			if (cmds[0].equals("push")) {
				Long value = Long.parseLong(cmds[1]);
				stack.add(value);
				inc.add(0L);
				out.println(value);
				length++;
			} else if (cmds[0].equals("pop")) {
				length--;
				stack.remove(length);
				if (length == 0)
					out.println("EMPTY");
				else {
					inc.set(length - 1, inc.get(length) + inc.get(length - 1));
					inc.remove(length);
					out.println(stack.get(length - 1) + inc.get(length - 1));
				}
			} else {
				int num = Integer.parseInt(cmds[1]);
				Long value = Long.parseLong(cmds[2]);
				inc.set(num - 1, inc.get(num - 1) + value);
				out.println(stack.get(length - 1) + inc.get(length - 1));
			}
		}
		out.close();
	}
}
