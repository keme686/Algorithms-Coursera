/**
 * 
 */
package com.awudima.algorithms.unionfind;

/**
 * @author Kemele M. Endris
 *
 */
public class WeightedQuickUnionUF {

	private int[] id;
	private int[] sz;
	private int count;
	
	public WeightedQuickUnionUF(int N){
		count = N;
		id = new int[N];
		sz = new int[N];
		for(int i=0; i< N; i ++){
			id[i] =i;
			sz[i] =1;
		}
	}
	
	public int getCount(){
		return count;
	}
	
	public int root(int i){
		if(i != id[i])
			i= id[i];
		return i;
	}
	
	public boolean connected(int p, int q){
		return root(p) == root(q);
	}
	
	public void union(int p, int q){
		int rp = root(p);
		int rq = root(q);
		if(rp == rq) return;
		if(sz[rp]<sz[rq]){
			id[rp] = rq;
			sz[rq] += sz[rp];
		}
		else{
			id[rq] = rp;
			sz[rp] = rq;
		}
		count --;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
