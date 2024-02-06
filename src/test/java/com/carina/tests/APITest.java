package com.carina.tests;

import java.lang.invoke.MethodHandles;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.atomic.AtomicInteger;

import com.carina.methods.api.PostEmployeeMethod;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import com.zebrunner.carina.core.IAbstractTest;
import com.carina.methods.api.DeleteEmployeeMethod;
import com.carina.methods.api.GetEmployeeMethods;
import com.zebrunner.carina.api.APIMethodPoller;
import com.zebrunner.carina.api.apitools.validation.JsonCompareKeywords;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.core.registrar.tag.Priority;
import com.zebrunner.carina.core.registrar.tag.TestPriority;


public class APITest implements IAbstractTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Test()
    @MethodOwner(owner = "suiteOwner")
    public void testCreateEmployeeWithRetry() throws Exception {
        LOGGER.info("test");
        setCases("4555,54545");
        PostEmployeeMethod api = new PostEmployeeMethod();
        api.setProperties("api/employee/employee.properties");

        AtomicInteger counter = new AtomicInteger(0);

        api.callAPIWithRetry()
                .withLogStrategy(APIMethodPoller.LogStrategy.ALL)
                .peek(rs -> counter.getAndIncrement())
                .until(rs -> counter.get() == 4)
                .pollEvery(1, ChronoUnit.SECONDS)
                .stopAfter(10, ChronoUnit.SECONDS)
                .execute();
        api.validateResponse();
    }

    @Test()
    @MethodOwner(owner = "suiteOwner")
    public void testCreateEmployee() throws Exception {
        PostEmployeeMethod api = new PostEmployeeMethod();
        api.setProperties("api/employee/employee.properties");
        api.callAPIExpectSuccess();
        api.validateResponse();
    }

    @Test()
    @MethodOwner(owner = "suiteOwner")
    public void testGetEmployees() {
        GetEmployeeMethods getUsersMethods = new GetEmployeeMethods();
        getUsersMethods.callAPIExpectSuccess();
        getUsersMethods.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
        getUsersMethods.validateResponseAgainstSchema("api/employee/_get/rs.schema");
    }

    @Test()
    @MethodOwner(owner = "suiteOwner")
    @TestPriority(Priority.P1)
    public void testDeleteEmployee() {
        DeleteEmployeeMethod deleteEmployeeMethod = new DeleteEmployeeMethod();
        deleteEmployeeMethod.setProperties("api/employee/employee.properties");
        deleteEmployeeMethod.callAPIExpectSuccess();
        deleteEmployeeMethod.validateResponse();
    }

    @Test()
    @MethodOwner(owner = "suiteOwner")
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
