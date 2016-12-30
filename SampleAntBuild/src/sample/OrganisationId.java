package sample;

import java.util.Objects;

public class OrganisationId {
	private String value;

	public OrganisationId(String value) {
		Objects.requireNonNull(value, "value is required");
		this.value = value;
	}

	@Override
	public int hashCode() {
		return value.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrganisationId other = (OrganisationId) obj;
		return value.equals(other.value);
	}

	@Override
	public String toString() {
		return value;
	}

}
