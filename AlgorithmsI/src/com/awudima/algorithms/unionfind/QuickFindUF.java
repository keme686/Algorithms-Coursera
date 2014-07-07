/**
 * 
 */
package com.awudima.algorithms.unionfind;

/**
 * @author Kemele M. Endris
 *
 */
public class QuickFindUF {
 
	/**
	 * list of integer ids
	 */
	private int[] id;
	
	/**
	 * Creates the id list and initializes it
	 * @param N - number of ids to be created 
	 */
	public QuickFindUF(int N){
		if(N<=0)
			N = 10;
		id = new int[N];
		for(int i=0; i<N; i++){
			id[i]=i;
		}
	}
	
	/**
	 * checks whether p and q are connected or not
	 * @param p - first item
	 * @param q - second item in the list
	 * @return
	 */
	public boolean connected(int p, int q){
		if(p >= id.length || p< 0 || q < 0 || q >= id.length)
			return false;
		
		return id[p]==id[q];
	}
	
	/**
	 * creates a connection between two items, p and q
	 * @param p - first item to be connected within the list
	 * @param q - second item to be connected to within the list
	 */
	public void union(int p, int q){
		if(p >= id.length || p< 0 || q < 0 || q >= id.length)
			return;
		int pid = id[p];
		int qid = id[q];
		for (int i=0; i<id.length; i++){
			if(id[i]==pid){
				id[i] = qid;
			}
		}
	}
	
	/**
	 * test client
	 * @param args
	 */
	public static void main(String[] args) {
		QuickFindUF find = new QuickFindUF(10);
		find.union(3, 5);
		find.union(2,5);
		find.union(8,2);

		System.out.println(find.connected(3, 8));
	}

}
