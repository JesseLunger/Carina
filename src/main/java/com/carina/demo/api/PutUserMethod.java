package com.carina.demo.api;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.RequestTemplatePath;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import com.zebrunner.carina.utils.config.Configuration;

@Endpoint(url= "${base_url}/api/v1/update/1", methodType = HttpMethodType.PUT)
@RequestTemplatePath(path = "api/users/_put/rq.json")
@ResponseTemplatePath(path = "api/users/_put/rs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class PutUserMethod extends AbstractApiMethodV2 {

    public PutUserMethod(){
//        super("api/users/_put/rq.json", "api/users/_put/rs.json", "api/users/user.properties");
        replaceUrlPlaceholder("base_url", Configuration.getRequired("api_url"));
    }
}
