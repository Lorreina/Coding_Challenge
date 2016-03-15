import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Data_Structure_Iterator {
	public class DataItem{
		boolean isInt;
		ArrayList<DataItem> list;
		int x;
		
		public DataItem(int x) {
			this.x = x;
			isInt = true;
		}
		
		public DataItem(ArrayList<DataItem> list) {
			this.list = new ArrayList<DataItem> (list);
			isInt = false;
		}
		
		public void add(int num) {
			if (isInt) {
				isInt = false;
				list = new ArrayList<DataItem> ();
				list.add(new DataItem(this.x));
			}
			list.add(new DataItem(num));
		}
		
		public void add(DataItem data) {
			if (isInt) {
				isInt = false;
				list = new ArrayList<DataItem> ();
				list.add(new DataItem(this.x));
			}
			list.add(data);
		}
		
		public DataItem get(int index) {
			if (isInt) {
				if (index >= 1) {
					throw new NoSuchElementException();
				}
				return this;
			} else {
				if (index >= list.size()) {
					throw new NoSuchElementException();
				}
				return list.get(index);
			}
		}
		
		public Iterator<DataItem> iterator() {
	        return new DataItemIterator();
	    }
		
		private class DataItemIterator implements Iterator<DataItem> {
			private int index;
			
			DataItemIterator() {
				index = 0;
			}
			@Override
			public boolean hasNext() {
				if (isInt) {
					if (index > 0) {
						return false;
					}
				} else {
					if (index >= list.size()) {
						return false;
					}
				}
				return true;
			}

			@Override
			public DataItem next() {
				if (!hasNext()) {
	                throw new NoSuchElementException();
	            }
				if (isInt) {
					return DataItem.this;
				}
				
				return list.get(index);
			}
			
		}
	}
}
