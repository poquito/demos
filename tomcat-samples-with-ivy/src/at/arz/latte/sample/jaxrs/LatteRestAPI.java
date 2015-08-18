package at.arz.latte.sample.jaxrs;

import java.util.HashSet;
import java.util.Set;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 * The main REST-API Class sets up all REST Resources which should be available
 * for API Version v1.
 * 
 * @author mrodler
 */
@ApplicationScoped
@ApplicationPath("/api/v1")
public class LatteRestAPI extends Application {

	private Set<Class<?>> applicationClasses;

	@Override
	public Set<Class<?>> getClasses() {
		if (applicationClasses == null) {
			initApplicationClasses();
		}
		return applicationClasses;
	}

	private void initApplicationClasses() {
		applicationClasses = new HashSet<Class<?>>();
		applicationClasses.add(RestServiceRootV1.class);
	}
}
