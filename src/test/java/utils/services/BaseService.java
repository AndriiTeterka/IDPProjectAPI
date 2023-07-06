package utils.services;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public abstract class BaseService {

    protected RequestSpecification REQUEST_SPECIFICATION;

    public BaseService() {
        REQUEST_SPECIFICATION = new RequestSpecBuilder()
                .setContentType(getContentType())
                .setBaseUri(getBaseUri())
                .setBasePath(getBasePath())
                .build();
    }

    protected abstract String getContentType();

    protected abstract String getBaseUri();

    protected abstract String getBasePath();

}
