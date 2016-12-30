package sample;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;

public class DependencyManager {
	private Map<ModuleId, List<ModuleId>> moduleDependencies;

	public DependencyManager(Map<ModuleId, List<ModuleId>> moduleDependencies) {
		Objects.requireNonNull(moduleDependencies, "moduleDependencies required");
		this.moduleDependencies = moduleDependencies;
	}

	public List<ModuleId> upstreamDependencies(ModuleId moduleId) {
		List<ModuleId> resolved = new ArrayList<>();
		resolveUpstream(moduleId, resolved);
		return resolved;
	}

	public List<ModuleId> downstreamDependencies(ModuleId moduleId) {
		List<ModuleId> resolved = new ArrayList<>();
		resolveDownstream(moduleId, resolved);
		return resolved;
	}

	private void resolveUpstream(ModuleId moduleId, List<ModuleId> resolved) {
		for (ModuleId module : directModuleDependencies(moduleId)) {
			if (resolved.contains(module)) {
				continue;
			}
			resolved.add(module);
			resolveUpstream(module, resolved);
		}
	}

	private void resolveDownstream(ModuleId moduleId, List<ModuleId> resolved) {
		for (ModuleId module : directModuleDependants(moduleId)) {
			if (resolved.contains(module)) {
				continue;
			}
			resolved.add(module);
			resolveDownstream(module, resolved);
		}
	}

	public List<ModuleId> directModuleDependencies(ModuleId moduleId) {
		List<ModuleId> dependencies = moduleDependencies.get(moduleId);
		if (dependencies == null) {
			throw new IllegalStateException("unknown module:" + moduleId);
		}
		return Collections.unmodifiableList(dependencies);
	}

	public List<ModuleId> directModuleDependants(ModuleId moduleId) {
		List<ModuleId> result = new ArrayList<>();
		Set<Entry<ModuleId, List<ModuleId>>> entrySet = moduleDependencies.entrySet();
		for (Entry<ModuleId, List<ModuleId>> entry : entrySet) {
			if (entry.getValue().contains(moduleId)) {
				result.add(entry.getKey());
			}
		}
		return Collections.unmodifiableList(result);
	}

}
