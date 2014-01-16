package org.modino.community.nba.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.hibernate.annotations.DynamicInsert;
//import org.hibernate.annotations.DynamicUpdate;
/**
 * 
 * @author dmodino
 *
 */

@Named("user")
@SessionScoped
@Entity
@Table(name="user")
//@DynamicInsert(false)
//Solo las columnas modificadas serán actualizadas en tiempo de ejecucion
//@DynamicUpdate(true)
public class User implements Serializable{

	private static final long serialVersionUID = 3323664210787119963L;
	private static final Logger logger = LoggerFactory.getLogger(User.class);
	
	public static enum Type {User, Admin};
	public static enum Gender {Male, Female};
	
	@Id @NotNull @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="idUser")
	private int id;
	
	//tipo User o Administrator
	@NotNull
	private Type type;
	
	//Campos obligatorios
	@NotNull
	private String username;
	
	@NotNull @Size(max = 255) 
	private String password;
	
	private String salt;
	
	@Transient
	private String repassword;
	
	@Email @NotNull
	private String email;
	
	/**
		Make the Country required for the User
	    Specify the Country must be also fetched when obtaining the User
	    Specify a foreign key column in the User table that references the Country table
	 */
	@OneToOne(optional=false,fetch=FetchType.EAGER)
	@JoinColumn(name="idCountry")
	private Country country;
	
	/**
	 * TODO: guardar cuando se accede a la web 'publica' el idioma elegido por el usuario se debe guardara
	 *  en una cookie y luego recogerla @CookieValue(value="SMSESSION") String token
	 */
	/**
		Make the PreferredLanguage required for the User
	    Specify the PreferredLanguage must be also fetched when obtaining the User
	    Specify a foreign key column in the User table that references the PreferredLanguage table
	 */
	@OneToOne(optional=false,fetch=FetchType.EAGER)
	@JoinColumn(name="idPrefLanguage")
	private PreferredLanguage preferredLanguage;
	
	//Campos opcionales
	private String avatar;
	
	private String firstName;
	
	private String lastName;
	
	private Date birthday;
	
	private Gender gender;
		
	
	// @Transient -> Se relaciona con este objeto pero no se añaden sus campos como columnas en la tabla de BD  
	@Transient
	@OneToMany(cascade = CascadeType.ALL, mappedBy ="user")
	private List<League> leagues;
	
	@ManyToMany(mappedBy ="users")
	private List<Poll> polls;
	
	@ManyToMany(mappedBy ="users")
	private List<Forum> forums;
	
	
	public User() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRepassword() {
		return repassword;
	}

	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public List<League> getLeagues() {
		return leagues;
	}

	public void setLeagues(List<League> leagues) {
		this.leagues = leagues;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}	
	
	public List<Poll> getPolls() {
		return polls;
	}

	public void setPolls(List<Poll> polls) {
		this.polls = polls;
	}

	public List<Forum> getForums() {
		return forums;
	}

	public void setForums(List<Forum> forums) {
		this.forums = forums;
	}	
	
	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}
	
	public PreferredLanguage getPreferredLanguage() {
		return preferredLanguage;
	}

	public void setPreferredLanguage(PreferredLanguage preferredLanguage) {
		this.preferredLanguage = preferredLanguage;
	}

	public void addLeague(League league){
		if(this.leagues == null){
			this.leagues = new ArrayList<League>();
		}
		this.leagues.add(league);
		logger.info("One league has added to your user");
	}
	
	public void removeTeam(League team){
		if(this.leagues != null){
			this.leagues.remove(team);
			logger.info("The league has removed from your user");
		}
		else{
			logger.info("Unable to remove the league from your user");
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((avatar == null) ? 0 : avatar.hashCode());
		result = prime * result
				+ ((birthday == null) ? 0 : birthday.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result
				+ ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((forums == null) ? 0 : forums.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + id;
		result = prime * result
				+ ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((leagues == null) ? 0 : leagues.hashCode());
		result = prime * result
				+ ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((polls == null) ? 0 : polls.hashCode());
		result = prime
				* result
				+ ((preferredLanguage == null) ? 0 : preferredLanguage
						.hashCode());
		result = prime * result
				+ ((repassword == null) ? 0 : repassword.hashCode());
		result = prime * result + ((salt == null) ? 0 : salt.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result
				+ ((username == null) ? 0 : username.hashCode());
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
		if (avatar == null) {
			if (other.avatar != null)
				return false;
		} else if (!avatar.equals(other.avatar))
			return false;
		if (birthday == null) {
			if (other.birthday != null)
				return false;
		} else if (!birthday.equals(other.birthday))
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (forums == null) {
			if (other.forums != null)
				return false;
		} else if (!forums.equals(other.forums))
			return false;
		if (gender != other.gender)
			return false;
		if (id != other.id)
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (leagues == null) {
			if (other.leagues != null)
				return false;
		} else if (!leagues.equals(other.leagues))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (polls == null) {
			if (other.polls != null)
				return false;
		} else if (!polls.equals(other.polls))
			return false;
		if (preferredLanguage == null) {
			if (other.preferredLanguage != null)
				return false;
		} else if (!preferredLanguage.equals(other.preferredLanguage))
			return false;
		if (repassword == null) {
			if (other.repassword != null)
				return false;
		} else if (!repassword.equals(other.repassword))
			return false;
		if (salt == null) {
			if (other.salt != null)
				return false;
		} else if (!salt.equals(other.salt))
			return false;
		if (type != other.type)
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", type=" + type + ", username=" + username
				+ ", password=" + password + ", salt=" + salt + ", repassword="
				+ repassword + ", email=" + email + ", country=" + country
				+ ", preferredLanguage=" + preferredLanguage + ", avatar="
				+ avatar + ", firstName=" + firstName + ", lastName="
				+ lastName + ", birthday=" + birthday + ", gender=" + gender
				+ ", leagues=" + leagues + ", polls=" + polls + ", forums="
				+ forums + "]";
	}
	
	
	
}
