package arrays;

import java.util.Scanner;

public class OneDArray {

	public static void main(String[] args) {
		/**
		 * create 
		 */
		int arr[];
		arr = new int[5];
		System.out.println(arr[9]);
		
		int a[] = new int[5];
		System.out.println(a.length);
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();
		}
		//find sum of all values in the array
		int sum = 0;
		for (int i = 0; i < a.length; i++) {
			sum += a[i];
		}
		System.out.println(sum);
		
		// print only those numbers which are prime
		for (int i = 0; i < a.length; i++) {
			int no = a[i];// getting value from the array
			int c=0;
			
			for (int j = 1; j<=no;j++) {
				if(no%j==0)
					c++;
			}
			if(c==2)
				System.out.println(no);
		}
		
		
	}

}
