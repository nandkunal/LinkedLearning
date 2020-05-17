package com.learning.collections;



public class CustomMap {

	public static void main(String[] args) {
		
		CustomHashMap map = new CustomHashMap();
		map.put("Kunal",1);
		map.put("Himanshu",2);
		
		for (CustomHashMap.Entry e : map.entrySet()) {
			System.out.println(e.getKey());
		}
		
		
		

	}

}


class CustomHashMap {
	
	static class Entry{
		private String key;
		public String getKey() {
			return key;
		}
		public void setKey(String key) {
			this.key = key;
		}
		public String getValue() {
			return value;
		}
		public void setValue(String value) {
			this.value = value;
		}
		private String value;
	}
	
	
	private Entry[] entry;

	public void put(String string, int i) {
		
	}
	
	
	public int get(String key) {
		return 0;
	}
	
	public Entry[] entrySet(){
		return entry;
	}
}
