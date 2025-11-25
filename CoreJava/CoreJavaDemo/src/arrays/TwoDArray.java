package arrays;

import java.util.Scanner;

public class TwoDArray {

	public static void main(String[] args) {
		// int varname[][] = new int[rows][columns]

		// square 2-D array
		int arr[][]= new int[3][3];
		System.out.println(arr.length);//3 : no of rows
		System.out.println(arr.length*arr.length);//3 : no of rows
		Scanner sc = new Scanner(System.in);
		for(int i=0;i<3;i++)// 3 rows
		{
			for(int j=0;j<3;j++)// 3 columns
			{
				System.out.println("Enter");
				arr[i][j] = sc.nextInt();
			}
		}

		//1. find sum of all values in the array
		int sum = 0;
		for(int i=0;i<3;i++)// 3 rows
		{
			for(int j=0;j<3;j++)// 3 columns
			{
				sum+=arr[i][j];
			}
		}
		System.out.println(sum);

		//2. sum of values rowwise
		for(int i=0;i<3;i++)// 3 rows
		{
			int s=0;
			for(int j=0;j<3;j++)// 3 columns
			{
				s+=arr[i][j];
			}
			System.out.println("Row "+i+": "+s);
		}
		//2. sum of values columnwise
		for(int i=0;i<3;i++)// 3 rows
		{
			int s=0;
			for(int j=0;j<3;j++)// 3 columns
			{
				s+=arr[j][i];
			}
			System.out.println("Column "+i+": "+s);
		}
		

		// rectangular 2-D array
		int arr1[][]= new int[5][3];
		System.out.println(arr1.length);//5 : no of rows
		System.out.println(arr1.length*arr1[0].length);//3 : no of rows

		for(int i=0;i<5;i++)// 3 rows
		{
			for(int j=0;j<3;j++)// 3 columns
			{
				System.out.println("Enter ");
				arr1[i][j]= sc.nextInt();
			}
		}

		//1. find sum of all values in the array
		int sum1 = 0;
		for(int i=0;i<5;i++)// 3 rows
		{
			for(int j=0;j<3;j++)// 3 columns
			{
				sum1+=arr[i][j];
			}
		}
		System.out.println(sum);

		//2. sum of values rowwise
		for(int i=0;i<5;i++)// 5 rows
		{
			int s=0;
			for(int j=0;j<3;j++)// 3 columns
			{
				s+=arr[i][j];
			}
			System.out.println("Row "+i+": "+s);
		}
		//2. sum of values columnwise
		for(int i=0;i<3;i++)//columns
		{
			int s=0;
			for(int j=0;j<5;j++)// rows
			{
				s+=arr[j][i];
			}
			System.out.println("Column "+i+": "+s);
		}
	}

}
