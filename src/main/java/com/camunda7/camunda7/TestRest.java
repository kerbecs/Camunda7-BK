package com.camunda7.camunda7;

import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.repository.Deployment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/execute")
public class TestRest {
    @Autowired
    private ProcessEngine processEngine;
    @Autowired
    private ProcessRepository processRepository;
    @GetMapping
    public void test(){
        Process process = processRepository.findById(1L).get();
        Deployment deployment = processEngine.getRepositoryService()
                .createDeployment()
                .addString("process.bpmn", process.getXml())
                .deploy();

        processEngine.getRuntimeService().startProcessInstanceByKey("process_id");
    }
    @GetMapping("/hello")
    public void hello(){
        System.out.println("Hello from rest controller!");
    }

}
