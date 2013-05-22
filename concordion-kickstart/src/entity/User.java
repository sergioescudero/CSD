package entity;


public class User extends Entity {

	private String userId;

	private String name;

	private String email;

	@Override public boolean isValid() {
		throw new RuntimeException("Not implemented yet");
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
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
		User other = (User) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	public static class Builder {
		private String userId;
		private String name;
		private String email;

		public Builder userId(String userId) {
			this.userId = userId;
			return this;
		}
		
		public Builder name(String name){
			this.name=name;
			return this;
		}

		public Builder email(String email){
			this.email=email;
			return this;
		}

		public  User build() {
			User usuario = new User();
			usuario.userId = userId;
			usuario.name = name;
			usuario.email = email;
			return usuario;
		}

	}


}
