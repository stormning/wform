package com.nway.wform;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.engine.HistoryService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.activiti.engine.test.Deployment;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class ActivitiTest {

	@Autowired
	private RuntimeService runtimeService;

	@Autowired
	private TaskService taskService;
	
	@Autowired
	private RepositoryService repositoryService;
	
	@Autowired
	private HistoryService historyService;

	@Test
	@Deployment
	public void simpleProcessTest() {
		
		Map<String,Object> var = new HashMap<String,Object>();
		
		ProcessInstance pi = runtimeService.startProcessInstanceByKey("designByExplorer");
		
		var.put("title", "check");
		
		// 草稿
		Task firstTask = taskService.createTaskQuery().processInstanceId(pi.getId()).singleResult();
		
			
		List<Task> nextTasks = handleTask(pi.getId(), firstTask.getId(), var);
		
		// 审批、核查
		for(Task task : nextTasks) {
			
			handleTask(pi.getId(), task.getId(), var);
		}
		
		// 处理
		for(Task task : nextTasks) {
			
			handleTask(pi.getId(), task.getId(), var);
		}
		
		for(Task task : nextTasks) {
			
			handleTask(pi.getId(), task.getId(), var);
		}

        HistoricProcessInstance historicProcessInstance = historyService.createHistoricProcessInstanceQuery().processInstanceId(pi.getId()).singleResult();  
        
        System.out.println("流程结束时间是: " + historicProcessInstance.getEndTime());  
	}
	
	private List<Task> handleTask(String pid, String taskId,  Map<String, Object> variables) {
		
		Task task = taskService.createTaskQuery().processInstanceId(pid).taskId(taskId).singleResult();
		
		System.out.println(task.getId() + " \t " + task.getName());
		
		if(variables != null) {
			
			taskService.complete(task.getId(), variables);
		}
		else {
			
			taskService.complete(task.getId());
		}
		
		return taskService.createTaskQuery().processInstanceId(pid).list();
	}

}
