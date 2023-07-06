package utils.services;

import io.restassured.specification.RequestSpecification;
import utils.ConfigProvider;

public abstract class RestService extends BaseService {

    @Override
    public String getBaseUri() {
        return ConfigProvider.URL;
    }

    @Override
    public String getContentType() {
        return "application/json";
    }

    protected RequestSpecification buildRequestSpecificationById(int id) {
        return REQUEST_SPECIFICATION.basePath(getBasePath() + "/" + id);
    }
}
