package arrays;

import java.util.Scanner;

public class StudentMarks {


	public void m1() {

	}
	public void m1(int s) {

	}



	public static void main(String[] args) {

		
		Scanner sc = new Scanner(System.in);
		int marks[][]=new int[5][4];
		for(int i=0;i<5;i++)
		{
			System.out.println("Enter marks for student "+i);
			for(int j=0;j<4;j++)
			{

				marks[i][j]= sc.nextInt();
			}
		}
		// Display data
		for(int i=0;i<5;i++)
		{

			for(int j=0;j<4;j++)
			{

				System.out.print(marks[i][j]+" ");
			}
			System.out.println();
		}
		// Max marks in subject per student
		for(int i=0;i<5;i++)
		{
			int max=0;
			for(int j=0;j<4;j++)
			{
				if(marks[i][j] > max) {
					max = marks[i][j];
				}
			}
			System.out.println("Max marks for student "+i + " : "+max);
		}


	}

}
