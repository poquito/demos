package sample.build;

import sample.ProjectName;

public interface ProjectListener {
	void projectModified(ProjectName projectName);
	void projectRemoved(ProjectName projectName);
	void projectAdded(ProjectName projectName);
}
