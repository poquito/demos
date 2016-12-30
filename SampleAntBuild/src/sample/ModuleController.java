package sample;

import java.util.List;

public class ModuleController {
	
	private DependencyManager dependencyManager;
	
	public ModuleController(DependencyManager dependencyManager) {
		this.dependencyManager = dependencyManager;
	}

	public void moduleHasChanged(ModuleId moduleId){
		List<ModuleId> dependants = dependencyManager.directModuleDependants(moduleId);
		for (ModuleId moduleId2 : dependants) {
			
		}
	}
}
