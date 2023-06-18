package utils.services;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import utils.ConfigProvider;

public abstract class BaseService {

    private static final String BASE_URL = ConfigProvider.URL;
    protected RequestSpecification REQUEST_SPECIFICATION;

    public BaseService() {
        REQUEST_SPECIFICATION = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setBaseUri(BASE_URL)
                .setBasePath(getBasePath())
                .build();
    }

    protected abstract String getBasePath();

    protected RequestSpecification buildRequestSpecificationById(int id) {
        return REQUEST_SPECIFICATION.basePath(getBasePath() + "/" + id);
    }
}
