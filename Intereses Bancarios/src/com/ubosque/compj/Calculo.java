package com.ubosque.compj;

public class Calculo {

	final static int NUMEROBANCOS = 3;
	final static int CANTIDADINVERTIR = 3;
	static int matriz[][] = new int[NUMEROBANCOS][CANTIDADINVERTIR];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int f[][] = new int[NUMEROBANCOS][CANTIDADINVERTIR];
		for (int i = 0; i < NUMEROBANCOS; i++) {
			for (int j = 0; j < CANTIDADINVERTIR; j++) {
				f[i][j]= i+j;
			}
		}
		System.out.println( intereses(f, matriz));
	}
	
	public static int intereses(int F[][],int I [][]){
		int i = 1,j = 1;
		for (; i < NUMEROBANCOS; i++)
			I[i][0]=0;
		for(;j < CANTIDADINVERTIR;j++)
			I[1][j]=F[1][j];
		for (i = 2; i < NUMEROBANCOS; i++) {
			for (j = 1; j < CANTIDADINVERTIR; j++) {
				I[i][j]=maxx(I,F,i,j);
			}
		}
		return I[i-1][j-1];
	}
	public static int maxx(int I[][],int F[][],int i,int j){
		int max,t;
		max=I[i-1][j] + F[i][0];
		for (t = 1; t < j; t++) {
			max=max2(max,I[i-1][j-t]+F[i][t]);
		}
		return max;
	}
	
	public static int max2(int max,int m){
		if (max>m) {
			return max;
		} else {
			return m;
		}
	}

}
