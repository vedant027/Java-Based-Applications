package com.taskmanager.operations;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


import com.taskmanager.core.TASKSTATUS;
import com.taskmanager.core.TaskManager;
import com.taskmanager.custom_exceptions.TaskException;

import static com.taskmanager.validations.TaskValidation.*;

public class TaskOperationsImpl implements TaskOperations {
	private Map<Integer,TaskManager> tasks;
	
	public TaskOperationsImpl() {
		tasks = new HashMap<>();
	}

	@Override
	public void addTask(String taskName, String taskDesc, String taskDate) {
		LocalDate date = parseDate(taskDate);
		TaskManager ts = new TaskManager(taskName,taskDesc,date,TASKSTATUS.PENDING,true);
		tasks.put(ts.getTaskId(), ts);
		System.out.println("Task Successfully Added!!");
	}

	@Override
	public void displayTask() {
		tasks.values().stream().forEach(s -> System.out.println(s));
		
	}
	
	

	@Override
	public void deleteTask(int taskid) throws TaskException {
		int count=0;
		Iterator<TaskManager> itr = tasks.values().iterator();
		while(itr.hasNext()) {
			TaskManager task = itr.next();
			if(task.getTaskId()==taskid) {
				itr.remove();
				System.out.println("Task Successfully Deleted!!");
				count++;
			}
		}
		if(count==0) {
			throw new TaskException("TaskId Invalid!!");
		}
		
//		tasks.values().removeIf(s->s.getTaskId()==taskid);
		
		
	}

	@Override
	public void updateStatus(int taskid,String newStatus) throws TaskException {
		TASKSTATUS status = parseStatus(newStatus);
		if(tasks.containsKey(taskid)) {
			tasks.values().stream().filter(t -> t.getTaskId()==taskid).forEach(t -> t.setStatus(status));
			System.out.println("TaskStatus Successfully Updated!!");
		}
		else {
			throw new TaskException("TaskId Invalid!!");
		}
		
	}

	@Override
	public void pendingTask() {
		System.out.println("Pending Tasks!");
		tasks.values().stream().filter(s -> s.getStatus().equals(TASKSTATUS.PENDING)).forEach(s -> System.out.println(s));
	}

	@Override
	public void pendingTaskToday() {
		System.out.println("Pending Task for Today!");
		tasks.values().stream().filter(s -> s.getStatus().equals(TASKSTATUS.PENDING) && s.getTaskDate().equals(LocalDate.now())).forEach(s -> System.out.println(s));
		
	}

	@Override
	public void sortByTaskDate() {
		System.out.println("Task Sorted by Date");
		tasks.values().stream().sorted(Comparator.comparing(TaskManager::getTaskDate)).forEach(s -> System.out.println(s));
		
	}
	
	
	
	
	
	
}
