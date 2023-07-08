package utils.services;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

/**
 * This abstract class provides the base functionality for service classes.
 * It defines the REQUEST_SPECIFICATION used for sending requests.
 * It also defines abstract methods for retrieving the content type, base URI, and base path.
 * Service classes that extend the BaseService class should implement the abstract methods
 * to provide the specific details for the service.
 * Note: The BaseService class uses the RequestSpecBuilder and RequestSpecification classes from RestAssured
 * to build and configure the request specification.
 * The REQUEST_SPECIFICATION is defined as a protected member variable.
 * The constructor initializes the REQUEST_SPECIFICATION with the provided values for content type, base URI, and base path.
 */
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
