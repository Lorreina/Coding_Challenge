import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;


/**
 * 有个vector<Iterator>，里面装了m个iterator，每个iterator是一个vector<int>的iterator，假设有next和hasNext接口，让你实现一个Zigzag traversal iterator
	[[1,2,3]
  	 [5,4]
  	 [6,7,8,9]]
	一直调用next会返回1,5,6,2,4,7,3,8,9，先用了O(mn)的方法，m是最长的iterator的数组的长度，又改成queue或者cycle linkedlist，复杂度是O(k), k是总元素个数
	Follow Up是，如果iterator有prev和hasPrev接口，实现Zigzag iterator的prev和hasPrev，用C++的deque和stack

 */
public class Zigzag_Iterator {
	public class ZigzagIterator {
		Deque<Iterator> itr;
		public ZigzagIterator (List<List<Integer>> list) {
			itr = new ArrayDeque();
			for (int i = 0; i < list.size(); i++) {
				if (!list.get(i).isEmpty()) {
					itr.add(list.get(i).iterator());
				}
			}
		}
		
		public boolean hasNext() {
			if (itr.isEmpty()) {
				return false;
			}
			return true;
		}
		
		public int next() {
			Iterator tmp = itr.poll();
			int result = (Integer) tmp.next();
			if (tmp.hasNext()) {
				itr.push(tmp);
			}
			
			return result;
		}
	}
	
}
