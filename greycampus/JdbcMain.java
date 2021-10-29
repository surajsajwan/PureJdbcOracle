package com.greycampus;

import java.util.ArrayList;
import java.util.Scanner;

public class JdbcMain {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		GetterSetter gs = new GetterSetter();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter which operation you want to perform");
		int choice = sc.nextInt();
		switch (choice) {
		case 1: {
			System.out.println("Enter employee no");
			int eno = sc.nextInt();
			System.out.println("Enter name");
			String name = sc.next();
			System.out.println("Enter salary");
			double salary = sc.nextDouble();
			System.out.println("Enter balance");
			double balance = sc.nextDouble();
			System.out.println("Who is creating it?");
			String createdby = sc.next();
			gs.setEno(eno);
			gs.setName(name);
			gs.setSalary(salary);
			gs.setBalance(balance);
			gs.setCreatedby(createdby);
			InsertToDb itb = new InsertToDb();
			itb.insert(gs);
			break;
		}
		case 2: {
			System.out.println("Who is updating it?");
			String updatedby = sc.next();
			System.out.println("Enter employee no whose value to update");
			int eno = sc.nextInt();
			gs.setUpdatedby(updatedby);
			gs.setEno(eno);
			UpdateToDb utd = new UpdateToDb();
			utd.update(gs);
			break;
		}
		case 3: {
			System.out.println("Enter Employee no whose value to delete");
			int eno = sc.nextInt();
			gs.setEno(eno);
			DeleteFromDb dfd = new DeleteFromDb();
			dfd.delete(gs);
			break;
		}
		case 4: {
			DisplayData dp = new DisplayData();
			ArrayList<GetterSetter> arl = dp.display();
			arl.forEach(b -> {
				System.out.println(b.getEno());
				System.out.println(b.getName());
				System.out.println(b.getSalary());
				System.out.println(b.getBalance());
				System.out.println(b.getCreatedby());
				System.out.println(b.getCreatedon());
				System.out.println(b.getUpdatedby());
				System.out.println(b.getUpdatedon());
			});
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + choice);
		}
	}

}
