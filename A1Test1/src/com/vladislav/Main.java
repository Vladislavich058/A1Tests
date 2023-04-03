package com.vladislav;

import com.vladislav.task.Task1;

public class Main {
	public static void main(String[] args) {
		Task1 task1 = new Task1();
		System.out.println("First variant");
		System.out.println("Example of convert IP address 128.32.10.0 -> " + task1.convertToLong("128.32.10.0"));
		System.out.println("Example of convert 2149583360 to IP -> " + task1.convertToIpV4(2149583360L));
		System.out.println("Example of convert IP address 0.0.0.255 -> " + task1.convertToLong("0.0.0.255"));
		System.out.println("Example of convert 255 to IP -> " + task1.convertToIpV4(255L));
		System.out.println();
		System.out.println("Second variant");
		System.out.println("Example of convert IP address 128.32.10.0 -> " + task1.convertToInt("128.32.10.0"));
		System.out.println("Example of convert -2145383936 to IP -> " + task1.convertToIp(-2145383936));
		System.out.println("Example of convert IP address 0.0.0.255 -> " + task1.convertToInt("0.0.0.255"));
		System.out.println("Example of convert 255 to IP -> " + task1.convertToIp(255));
	}
}
