package utils.services;

import io.restassured.specification.RequestSpecification;
import utils.ConfigProvider;

/**
 * This abstract class extends the BaseService class and provides the base functionality for REST service classes.
 * It sets the base URI to the URL defined in the ConfigProvider class and specifies the content type as JSON.
 * Service classes for REST operations can extend the RestService class and implement the getBasePath method
 * to provide the specific endpoint path for the REST operation.
 * The RestService class also provides a helper method, buildRequestSpecificationById, that can be used to build
 * a RequestSpecification with the base path appended with an ID value.
 * Note: The RestService class inherits the REQUEST_SPECIFICATION member variable from the BaseService class.
 * The REQUEST_SPECIFICATION is initialized with the provided values for content type, base URI, and base path.
 * The getBasePath method needs to be implemented in the extending class to provide the specific endpoint path.
 */
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
