package sample;

import java.util.Objects;

public class ModuleId {
	private OrganisationId organisationId;
	private String moduleId;

	public ModuleId(OrganisationId organisationId, String moduleId) {
		Objects.requireNonNull(organisationId, "organisationId is required");
		Objects.requireNonNull(moduleId, "moduleId is required");
		this.organisationId = organisationId;
		this.moduleId = moduleId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((moduleId == null) ? 0 : moduleId.hashCode());
		result = prime * result + ((organisationId == null) ? 0 : organisationId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ModuleId other = (ModuleId) obj;
		return moduleId.equals(other.moduleId) && organisationId.equals(other.organisationId);
	}

	@Override
	public String toString() {
		return organisationId + "#" + moduleId;
	}

}
