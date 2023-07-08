package utils.services;

import utils.ConfigProvider;

/**
 * This abstract class extends the BaseService class and provides the base functionality for SOAP service classes.
 * It sets the base URI to the SOAP_URL defined in the ConfigProvider class and specifies the content type as "text/xml; charset=utf-8".
 * Service classes for SOAP operations can extend the SoapService class and implement the getBasePath method
 * to provide the specific endpoint path for the SOAP operation.
 * Note: The SoapService class inherits the REQUEST_SPECIFICATION member variable from the BaseService class.
 * The REQUEST_SPECIFICATION is initialized with the provided values for content type, base URI, and base path.
 * The getBasePath method needs to be implemented in the extending class to provide the specific endpoint path.
 */
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
