package com.carina.tests;

import java.lang.invoke.MethodHandles;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.atomic.AtomicInteger;

import org.skyscreamer.jsonassert.JSONCompareMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import com.zebrunner.carina.core.IAbstractTest;
import com.carina.demo.api.DeleteUserMethod;
import com.carina.demo.api.GetUserMethods;
import com.carina.demo.api.PostUserMethod;
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
        PostUserMethod api = new PostUserMethod();
        api.setProperties("api/users/user.properties");

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
        PostUserMethod api = new PostUserMethod();
        api.setProperties("api/users/user.properties");
        api.callAPIExpectSuccess();
        api.validateResponse();
    }

    @Test()
    @MethodOwner(owner = "qpsdemo")
    public void testGetEmployees() {
        GetUserMethods getUsersMethods = new GetUserMethods();
        getUsersMethods.callAPIExpectSuccess();
        getUsersMethods.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
        getUsersMethods.validateResponseAgainstSchema("api/users/_get/rs.schema");
    }

    @Test()
    @MethodOwner(owner = "suiteOwner")
    @TestPriority(Priority.P1)
    public void testDeleteEmployee() {
        DeleteUserMethod deleteUserMethod = new DeleteUserMethod();
        deleteUserMethod.setProperties("api/users/user.properties");
        deleteUserMethod.callAPIExpectSuccess();
        deleteUserMethod.validateResponse();
    }

    @Test()
    @MethodOwner(owner = "suiteOwner")
    @TestPriority(Priority.P1)
    public void testUpdateEmployee() {
        PostUserMethod postUserMethod = new PostUserMethod();
        postUserMethod.setProperties("api/users/user.properties");
        postUserMethod.setRequestTemplate("api/users/_put/rq.json");
        postUserMethod.setResponseTemplate("api/users/_put/rs.json");
        postUserMethod.callAPIExpectSuccess();
        postUserMethod.validateResponse();
    }
}
