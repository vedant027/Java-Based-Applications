package com.taskmanager.core;

import java.time.LocalDate;

public class TaskManager {
	private int taskId;
	private static int idGenerator=1;
	private String taskName;
	private String taskDesc;
	private LocalDate taskDate;
	private TASKSTATUS status;
	private boolean active;

	public TaskManager(String taskName, String taskDesc, LocalDate taskDate, TASKSTATUS status,
			boolean active) {
		super();
		this.taskId = idGenerator++;
		this.taskName = taskName;
		this.taskDesc = taskDesc;
		this.taskDate = taskDate;
		this.status = status;
		this.active = active;
	}
	@Override
	public String toString() {
		return "TaskManager [taskId=" + taskId + ", taskName=" + taskName + ", taskDesc=" + taskDesc + ", taskDate="
				+ taskDate + ", status=" + status + ", active=" + active + "]";
	}
	public int getTaskId() {
		return taskId;
	}
	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	public String getTaskDesc() {
		return taskDesc;
	}
	public void setTaskDesc(String taskDesc) {
		this.taskDesc = taskDesc;
	}
	public LocalDate getTaskDate() {
		return taskDate;
	}
	public void setTaskDate(LocalDate taskDate) {
		this.taskDate = taskDate;
	}
	public TASKSTATUS getStatus() {
		return status;
	}
	public void setStatus(TASKSTATUS status) {
		this.status = status;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	
	

	
	
	
}
