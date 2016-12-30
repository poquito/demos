package sample;

import java.util.HashMap;
import java.util.Map;

public class ProjectContainer {
	private Map<ProjectName, Project> projects;

	public ProjectContainer() {
		projects=new HashMap<ProjectName, Project>();
	}
	
}
