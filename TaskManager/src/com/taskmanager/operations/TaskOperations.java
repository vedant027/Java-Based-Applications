package com.taskmanager.operations;

import java.time.LocalDate;

import com.taskmanager.core.TASKSTATUS;
import com.taskmanager.custom_exceptions.TaskException;

public interface TaskOperations {
	void addTask(String taskName, String taskDesc, String taskDate);
	
	void displayTask();
	
	void deleteTask(int taskid) throws TaskException;
	
	void updateStatus(int taskid,String newStatus) throws TaskException;
	
	void pendingTask();
	
	void pendingTaskToday();
	
	void sortByTaskDate();
	
	
}
