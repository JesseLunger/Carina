package com.carina.methods.api;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import com.zebrunner.carina.utils.config.Configuration;

@Endpoint(url = "${base_url}/api/v1/employees", methodType = HttpMethodType.GET)
@ResponseTemplatePath(path = "api/employee/_get/rs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class GetEmployeeMethods extends AbstractApiMethodV2 {

    public GetEmployeeMethods() {
        replaceUrlPlaceholder("base_url", Configuration.getRequired("api_url"));
    }
}
