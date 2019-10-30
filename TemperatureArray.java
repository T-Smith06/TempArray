/*Class:	CSE 1323L/W01
Date:		10/17/2019  
Name:		Terrence Smith
Assgnmt Name:	TemperatureArray   
Assignment#:	Lab 4B 
Resources: 	Introduction to Java Programming and Data Structures: Comp Version 11th e, 
 		Ch. 12. Also google reading one file and writing to another file (java)*/

import java.io.*;
//import java.io.FileNotFoundException;
import java.util.*;


public class TemperatureArray {
	
	// calculates and returns highest temperature
	public static int maxTemp(int[] pastTemp) {
		int max = pastTemp[0];

		// finds largest element in array
		for (int i = 0; i < pastTemp.length; i++) {
			if (max < pastTemp[i]) {
				max = pastTemp[i];
			}
		}
		return max;
	}

	// calculates and returns lowest temperature
	public static int minTemp(int[] pastTemp) {
		int min = pastTemp[0];

		// finds smallest element in array
		for (int i = 0; i < pastTemp.length; i++) {
			if (min > pastTemp[i]) {
				min = pastTemp[i];
			}
		}
		return min;
	}

	public static int[] addDegrees(int[] pastTemp) {
		// creates and returns original array then adds 10 to each
		for (int i = 0; i < pastTemp.length; i++) {
			pastTemp[i] += 10;
		}
		return pastTemp;
	}

	public static void main(String[] args) {
		try {
		// create file object
		java.io.File file = new java.io.File("temps.txt");
		
		//create a scanner object to get input from the file - Lab4A
		Scanner input = new Scanner(file);
		
		// declares and creates the array pastTemp with 7 elements
		int[] pastTemp = new int[7];
		int count = 0;
		
		while(input.hasNext()) {
			pastTemp[count] = input.nextInt();
			count++;
		}
		
		// output to user
		System.out.println("Lowest temperature: " + minTemp(pastTemp));
		System.out.println("Highest temperature: " + maxTemp(pastTemp));
		System.out.println("\nLast weeks temperatures plus 10 degrees:");

		int[] degrees = addDegrees(pastTemp);
		
		for (int i = 0; i < 7; i++) {
			System.out.print(degrees[i] + " ");
		}
		
		input.close();
		} catch (FileNotFoundException e) {
			System.out.println("The file was not found. TRY AGAIN.");
		} 
	}

}
