package utils.services;

import utils.ConfigProvider;

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
