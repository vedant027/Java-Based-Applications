package com.taskmanager.validations;

import java.time.LocalDate;
import java.util.Map;

import com.taskmanager.core.TASKSTATUS;
import com.taskmanager.core.TaskManager;

public class TaskValidation {
	public static TASKSTATUS parseStatus(String Status) {
		return TASKSTATUS.valueOf(Status.toUpperCase());
	}
	
	public static LocalDate parseDate(String Date) {
		return LocalDate.parse(Date);
	}
	
	
}
