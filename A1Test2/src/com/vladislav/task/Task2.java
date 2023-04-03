package com.vladislav.task;

import java.util.Scanner;

public class Task2 {
	
	public static void main(String[] args) {
		boolean flag = true;
        Scanner scanner = new Scanner(System.in);
  
        while (flag) {
            System.out.println("Choose operaion:");
            System.out.println("1 - Do task");
            System.out.println("2 - Exit");
            if(scanner.hasNextInt()) {
            	int choice = scanner.nextInt();
	            switch (choice) {
	            case 1: {
	                System.out.println("Please, input n: ");
	                if(scanner.hasNextInt()) {
		                int n = scanner.nextInt();
		                double un = ((double)1/factorial(n))*sum(n);
		                System.out.print("Result: ");
		                System.out.format("%.6f", un);
		                System.out.println();
	                }
	                else {
	                	System.out.println("Incorrect input");
	                }
	                break;
	            }
	            case 2: {
	            	flag=false;
	            	break;
	            }
	            default: {
	            	System.out.println("Incorrect input");
	            	break;
	            }
	            }
            }
            else {
            	System.out.println("Incorrect input");
            	scanner.nextLine();
            }
        }
        scanner.close();
    }
	
	public static long factorial(int n) {
		long result=1;
		for(int i=1; i<n+1; i++) {
			result*=i;
		}
		return result;
	}
	
	public static long sum(int n) {
		long sum = 0;
		for(int i=1;i<n+1;i++) {
			sum+=factorial(i);
		}
		return sum;
	}
}
