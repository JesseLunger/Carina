package com.carina.tests;

import com.carina.methods.api.DeleteEmployeeMethod;
import com.carina.methods.api.GetEmployeeMethod;
import com.carina.methods.api.GetEmployeesMethod;
import com.carina.methods.api.PostEmployeeMethod;
import com.zebrunner.carina.api.apitools.validation.JsonCompareKeywords;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.core.registrar.tag.Priority;
import com.zebrunner.carina.core.registrar.tag.TestPriority;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;


public class APITest implements IAbstractTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Test()
    @MethodOwner(owner = "Jesse Lunger")
    @TestPriority(Priority.P2)
    public void testGetEmployee() throws Exception {
        GetEmployeeMethod getEmployeeMethod = new GetEmployeeMethod();
        getEmployeeMethod.callAPIExpectSuccess();
        getEmployeeMethod.validateResponse();
    }

    @Test()
    @MethodOwner(owner = "Jesse Lunger")
    @TestPriority(Priority.P2)
    public void testGetEmployees() {
        GetEmployeesMethod getUsersMethod = new GetEmployeesMethod();
        getUsersMethod.callAPIExpectSuccess();
        getUsersMethod.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
        getUsersMethod.validateResponseAgainstSchema("api/employee/_get/rs.schema");
    }

    @Test()
    @MethodOwner(owner = "Jesse Lunger")
    @TestPriority(Priority.P1)
    public void testCreateEmployee() throws Exception {
        PostEmployeeMethod postEmployeeMethod = new PostEmployeeMethod();
        postEmployeeMethod.setProperties("api/employee/employee.properties");
        postEmployeeMethod.callAPIExpectSuccess();
        postEmployeeMethod.validateResponse();
    }

    @Test()
    @MethodOwner(owner = "Jesse Lunger")
    @TestPriority(Priority.P1)
    public void testDeleteEmployee() {
        DeleteEmployeeMethod deleteEmployeeMethod = new DeleteEmployeeMethod();
        deleteEmployeeMethod.setProperties("api/employee/employee.properties");
        deleteEmployeeMethod.callAPIExpectSuccess();
        deleteEmployeeMethod.validateResponse();
    }

    @Test()
    @MethodOwner(owner = "Jesse Lunger")
    @TestPriority(Priority.P1)
    public void testUpdateEmployee() {
        PostEmployeeMethod postEmployeeMethod = new PostEmployeeMethod();
        postEmployeeMethod.setProperties("api/employee/employee.properties");
        postEmployeeMethod.setRequestTemplate("api/employee/_put/rq.json");
        postEmployeeMethod.setResponseTemplate("api/employee/_put/rs.json");
        postEmployeeMethod.callAPIExpectSuccess();
        postEmployeeMethod.validateResponse();
    }
}
