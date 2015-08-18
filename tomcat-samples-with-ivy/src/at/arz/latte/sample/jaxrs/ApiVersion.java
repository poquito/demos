package at.arz.latte.sample.jaxrs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Represents the current API Version.
 * 
 * @author mrodler
 *
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ApiVersion {

	private String apiName;
	private String version;
	private String provider;

	protected ApiVersion() {
		// tool constructor
	}

	public ApiVersion(String apiName, String version, String provider) {
		this.apiName = apiName;
		this.version = version;
		this.provider = provider;
	}

	@Override
	public String toString() {
		return apiName + " (" + version + "), by " + provider;
	}

}
