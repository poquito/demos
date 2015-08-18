package at.arz.latte.sample.jaxrs;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.cxf.jaxrs.client.WebClient;

/**
 * The root resource class for latte rest api v1. 
 * 
 * @author mrodler
 *
 */
@RequestScoped
@Path("/")
public class RestServiceRootV1 {

	private static final String API_URL = "http://localhost:8080/jaxrs/api/v1";

	@Path("/call")
	@GET
	public String call() {
		WebClient client = WebClient.create(API_URL);

		ApiVersion result = client.get(ApiVersion.class);

		return result.toString();
	}

	private ApiVersion getCurrentVersion() {
		return new ApiVersion("latte rest api", "v1.0", "ARZ");
	}

	@Path("/version.json")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ApiVersion getCurrentVersionAsJSON() {
		return getCurrentVersion();
	}

	@Path("/version.xml")
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public ApiVersion getCurrentVersionAsXML() {
		return getCurrentVersion();
	}
}
