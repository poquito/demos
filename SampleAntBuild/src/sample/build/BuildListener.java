package sample.build;

import sample.ModuleId;

public interface BuildListener {
	void buildScheduled(ModuleId moduleId);

	void buildStarted(ModuleId moduleId);

	void buildComplete(ModuleId moduleId);

	void buildFailed(ModuleId moduleId, String errorMessage);

	void buildCanceled(ModuleId moduleId);
}
