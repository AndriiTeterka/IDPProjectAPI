package utils.services;

import utils.ConfigProvider;

/**
 * This abstract class extends the BaseService class and provides the base functionality for GraphQL service classes.
 * It sets the base URI to the GraphQL URL defined in the ConfigProvider class and specifies the content type as JSON.
 * Service classes for GraphQL operations can extend the GraphQLService class and implement the getBasePath method
 * to provide the specific endpoint path for the GraphQL operation.
 * Note: The GraphQLService class inherits the REQUEST_SPECIFICATION member variable from the BaseService class.
 * The REQUEST_SPECIFICATION is initialized with the provided values for content type, base URI, and base path.
 * The getBasePath method needs to be implemented in the extending class to provide the specific endpoint path.
 */
public abstract class GraphQLService extends BaseService {

    @Override
    public String getBaseUri() {
        return ConfigProvider.GRAPHQL_URL;
    }

    @Override
    public String getContentType() {
        return "application/json";
    }
}
