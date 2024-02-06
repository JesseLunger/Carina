package com.carina.methods.api;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.RequestTemplatePath;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import com.zebrunner.carina.utils.config.Configuration;

@Endpoint(url = "${base_url}/api/v1/create", methodType = HttpMethodType.POST)
@RequestTemplatePath(path = "api/employee/_post/rq.json")
@ResponseTemplatePath(path = "api/employee/_post/rs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class PostEmployeeMethod extends AbstractApiMethodV2 {

    public PostEmployeeMethod() {
        super("api/employee/_post/rq.json", "api/employee/_post/rs.json", "api/employee/employee.properties");
        replaceUrlPlaceholder("base_url", Configuration.getRequired("api_url"));
    }
}
