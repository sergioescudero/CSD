package scrumcourse.entity;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import scrumcourse.entity.Car.Builder;

@Entity
public class Person extends BaseEntity {

	@Id @GeneratedValue private Long id;

	// @Size(min = 1, max = 40)
	// @NotNull
	@Column(length = 50, unique = true, nullable = false) private String name;

	@Column(length = 50, unique = true, nullable = false) private String email;

	public long getId() {
		return id;
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

		private String name;
		private String email;


		public Builder name(String name) {
			this.name = name;
			return this;
		}

		public Builder email(String email) {
			this.email = email;
			return this;
		}

		public Person build() {
			Person person = new Person();
			checkNotNull(person.name = name);
			checkNotNull(person.email = email);
			return person;
		}

	}

}
