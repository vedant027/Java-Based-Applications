package com.taskmanager.tester;

import java.util.Scanner;

import com.taskmanager.operations.TaskOperations;
import com.taskmanager.operations.TaskOperationsImpl;

public class TestTask {

	public static void main(String[] args) {

		try(Scanner sc = new Scanner(System.in)){
			TaskOperations ops = new TaskOperationsImpl();
			boolean exit=false;
			while(!exit) {
				System.out.println("Options: 1. Add New Task \n"
						+ "2. Display all tasks \n"
						+ "3. Delete a task \n"
						+ "4. Update task status \n"
						+ "5. Display all pending tasks \n"
						+ "6. Display all pending tasks for today \n"
						+ "7. Display all tasks sorted by taskDate \n"
						+ "0. Exit");
				System.out.print("Choose Option: ");
				try {
					switch(sc.nextInt()) {
					case 1: 
							System.out.println("Enter Task Details: TaskName, TaskDescription, TaskDate");
							ops.addTask(sc.next(), sc.next(), sc.next());
							break;
					case 2:
						System.out.println("Task Details");
						ops.displayTask();
						break;
					case 3:
						System.out.println("Enter TaskId: ");
						ops.deleteTask(sc.nextInt());
						break;
					case 4: 
						System.out.println("Enter TaskId & New Status");
						ops.updateStatus(sc.nextInt(), sc.next());
						break;
					case 5:
						ops.pendingTask();
						break;
					case 6:
						ops.pendingTaskToday();
						break;
					case 7:
						ops.sortByTaskDate();
						break;
					case 0:
						exit=true;
						break;
					}
				}catch(Exception e) {
					System.out.println(e);
					sc.nextLine();
				}
				
			}
		}

	}

}
