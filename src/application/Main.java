package application;
import entities.*;
import entities.enums.WorkerLevel;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.Locale;

public class Main {
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("********** BASIC WORKER'S DATA **********");
		System.out.print("-> Name: ");
		String name = sc.nextLine();
		System.out.print("-> Level: ");
		sc.nextLine();
		String level = sc.nextLine();
		level = level.toUpperCase();
		System.out.print("-> Base salary: ");
		Double baseSalary = sc.nextDouble();
		
		System.out.println("********** DEPARTEMENT **********");
		System.out.print("-> Depatment's name: ");
		sc.nextLine();
		String nameDepartment = sc.nextLine();
		Department department = new Department(nameDepartment);
		
		Worker worker = new Worker(name, WorkerLevel.valueOf(level), baseSalary, department);
		
		System.out.println("********** CONTRACTS **********");
		System.out.print("-> Number of contracts");
		int N = sc.nextInt();
		for(int i = 0; i < N; i++) {
			System.out.println("CONTRACT #" + i + 1);
			System.out.print("-> Date(yyyy-MM-dd): ");
			sc.hasNextLine();
			LocalDate date = LocalDate.parse(sc.nextLine());
			System.out.print("-> Value per hour: ");
			Double valuePerHour = sc.nextDouble();
			System.out.print("-> Hours: ");
			int hours = sc.nextInt();
			worker.addContract(new Contract(date, valuePerHour, hours));
		}
		
		
		
		sc.close();
	}
}
