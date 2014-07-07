/**
 * 
 */
package com.awudima.algorithms.dynmaicconnectivity;

/**
 * @author Kemele M. Endris
 *
 */
public class QuickUnionUF {

	/**
	 * list of integer ids
	 */
	private int[] id;
	
	/**
	 * creates a list of ids and initializes it from 0 to N
	 * @param N - number of items a list contains
	 */
	public QuickUnionUF(int N){
		id = new int[N];
		for(int i=0; i< N; i++){
			id[i] = i;
		}
	}
	
	/**
	 * finds the root of an item in position i
	 * @param i - an item that we want to find the root of it inside the list
	 * @return the root of the item
	 */
	private int root(int i){
		if(i <0 || i > id.length)
			return 0; //TODO: find some other solution instead of setting 0 as root
		
		while(i != id[i])
			i = id[i];
		return i;
	}
	
	/**
	 *  checks the connectivity between two items in the list, p and q
	 * @param p - first element within the list
	 * @param q - second element within the list
	 * @return
	 */
	public boolean connected(int p, int q){
		if(p >= id.length || p< 0 || q < 0 || q >= id.length)
			return false;
		return root(p) == root(q);
	}
	
	/**
	 * connects two elements in the list, p and q
	 * @param p - first element within the list
	 * @param q - second element within the list
	 */
	public void union(int p, int q){
		if(p >= id.length || p< 0 || q < 0 || q >= id.length)
			return;
		int i = id[p];
		int j = id[q];
		id[i] = j;
	}
	/**
	 * test client
	 * @param args
	 */
	public static void main(String[] args) {
		QuickUnionUF union = new QuickUnionUF(10);
		
		union.union(2,  9);
		union.union(1, 3);
		union.union(4, 5);
		union.union(3, 9);
		
		System.out.println(union.connected(4,  3));
	}

}
