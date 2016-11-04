import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.impl.RepositoryServiceImpl;
import org.activiti.engine.impl.persistence.entity.ProcessDefinitionEntity;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.activiti.engine.test.ActivitiRule;
import org.activiti.engine.test.Deployment;
import org.junit.Rule;
import org.junit.Test;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertEquals;

/**
 * Developed by:    cubanguy
 * Date:            04/11/16
 * Project:         play-scala
 */
public class testAvailableTask {

    @Rule
    public ActivitiRule activitiRule = new ActivitiRule();
    @Test
    @Deployment(resources = {"srrs/VacationRequest.bpmn20.xml"})
    public void test() {
        ProcessInstance processInstance = activitiRule.getRuntimeService().startProcessInstanceByKey("vacationRequest");
        assertNotNull(processInstance);
        Task task = activitiRule.getTaskService().createTaskQuery().singleResult();
        assertEquals("Handle vacation request", task.getName());
    }



}
