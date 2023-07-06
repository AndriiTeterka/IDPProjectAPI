package utils.services;

import utils.ConfigProvider;

public abstract class SoapService extends BaseService {

    @Override
    public String getBaseUri() {
        return ConfigProvider.SOAP_URL;
    }

    @Override
    public String getContentType() {
        return "text/xml; charset=utf-8";
    }
}
