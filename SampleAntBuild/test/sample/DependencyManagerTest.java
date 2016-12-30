package sample;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class DependencyManagerTest {
	private static final OrganisationId SAMPLE = new OrganisationId("sample");
	private ModuleId runtime;
	private ModuleId framework;
	private ModuleId module_a;
	private ModuleId module_b;
	private ModuleId module_x;
	private ModuleId application;
	private DependencyManager dependencyManager;

	public DependencyManagerTest() {
		runtime = new ModuleId(SAMPLE, "runtime");
		framework = new ModuleId(SAMPLE, "framework");
		module_a = new ModuleId(SAMPLE, "module_a");
		module_b = new ModuleId(SAMPLE, "module_b");
		module_x = new ModuleId(SAMPLE, "module_x");
		application = new ModuleId(SAMPLE, "app");
	}

	@Test
	public void all_modules_but_framework_depend_on_runtime() {
		List<ModuleId> dependencies = dependencyManager.downstreamDependencies(runtime);
		assertTrue(dependencies.size() == 4);
		assertThat(dependencies, hasItems(module_a, module_b, module_x, application));
		assertThat(dependencies, not(hasItems(runtime)));
	}
	
	@Test
	public void no_module_depends_on_application() {
		List<ModuleId> dependencies = dependencyManager.downstreamDependencies(application);
		assertTrue(dependencies.isEmpty());
	}
	
	@Test
	public void runtime_has_no_dependencies() {
		List<ModuleId> dependencies = dependencyManager.upstreamDependencies(runtime);
		assertTrue(dependencies.isEmpty());
	}

	@Test
	public void application_depends_on_all_modules() {
		List<ModuleId> dependencies = dependencyManager.upstreamDependencies(application);
		assertTrue(dependencies.size() == 5);
		assertThat(dependencies, hasItems(framework, module_a, module_b, module_x, runtime));
		assertThat(dependencies, not(hasItems(application)));
	}

	@Before
	public void setup() {
		HashMap<ModuleId, List<ModuleId>> dependencies = new HashMap<ModuleId, List<ModuleId>>();
		dependencies.put(runtime, dependsOn());
		dependencies.put(framework, dependsOn());
		dependencies.put(module_a, dependsOn(runtime, framework));
		dependencies.put(module_b, dependsOn(runtime, framework));
		dependencies.put(module_x, dependsOn(module_b));
		dependencies.put(application, dependsOn(module_a, module_x));
		dependencyManager = new DependencyManager(dependencies);
	}

	private List<ModuleId> dependsOn(ModuleId... modules) {
		return Arrays.asList(modules);
	}

}
