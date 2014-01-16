package org.modino.community.nba.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

/**
 * 
 * @author dmodino
 *
 */
//import org.hibernate.annotations.DynamicInsert;
//import org.hibernate.annotations.DynamicUpdate;

@Named("nbaPlayer")
@SessionScoped
@Entity
@Table(name="nbaPlayer")
//@DynamicInsert(false)
//Solo las columnas modificadas serán actualizadas en tiempo de ejecucion
//@DynamicUpdate(true)
public class NBAPlayer implements Serializable{

	private static final long serialVersionUID = 4323437114868615675L;
	//@GeneratedValue(strategy=GenerationType.IDENTITY) -> indica las claves principales para la entidad y crea una columna en la BD para ella
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="idNbaPlayer")
	private int id;
	
	@NotNull
	private String fullName;
	
	@NotNull
	private String position;
	
	@NotNull
	private float salary;
	
	private Date birthdate;
	
	private String height;
	
	private String weight;
	
	@Lob
	@Basic(fetch = FetchType.LAZY)
	private byte[] photo;
	
	
	// Mostrar el equipo nba al que pertenece
	@ManyToOne @JoinColumn(name="idNbaTeam")
	private NBATeam nbaTeam;
	
	@Transient
	private Player player;
	
	public NBAPlayer() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	public NBATeam getNbaTeam() {
		return nbaTeam;
	}

	public void setNbaTeam(NBATeam nbaTeam) {
		this.nbaTeam = nbaTeam;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((birthdate == null) ? 0 : birthdate.hashCode());
		result = prime * result
				+ ((fullName == null) ? 0 : fullName.hashCode());
		result = prime * result + ((height == null) ? 0 : height.hashCode());
		result = prime * result + id;
		result = prime * result + ((nbaTeam == null) ? 0 : nbaTeam.hashCode());
		result = prime * result + Arrays.hashCode(photo);
		result = prime * result + ((player == null) ? 0 : player.hashCode());
		result = prime * result
				+ ((position == null) ? 0 : position.hashCode());
		result = prime * result + Float.floatToIntBits(salary);
		result = prime * result + ((weight == null) ? 0 : weight.hashCode());
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
		NBAPlayer other = (NBAPlayer) obj;
		if (birthdate == null) {
			if (other.birthdate != null)
				return false;
		} else if (!birthdate.equals(other.birthdate))
			return false;
		if (fullName == null) {
			if (other.fullName != null)
				return false;
		} else if (!fullName.equals(other.fullName))
			return false;
		if (height == null) {
			if (other.height != null)
				return false;
		} else if (!height.equals(other.height))
			return false;
		if (id != other.id)
			return false;
		if (nbaTeam == null) {
			if (other.nbaTeam != null)
				return false;
		} else if (!nbaTeam.equals(other.nbaTeam))
			return false;
		if (!Arrays.equals(photo, other.photo))
			return false;
		if (player == null) {
			if (other.player != null)
				return false;
		} else if (!player.equals(other.player))
			return false;
		if (position == null) {
			if (other.position != null)
				return false;
		} else if (!position.equals(other.position))
			return false;
		if (Float.floatToIntBits(salary) != Float.floatToIntBits(other.salary))
			return false;
		if (weight == null) {
			if (other.weight != null)
				return false;
		} else if (!weight.equals(other.weight))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "NBAPlayer [id=" + id + ", fullName=" + fullName + ", position="
				+ position + ", salary=" + salary + ", birthdate=" + birthdate
				+ ", height=" + height + ", weight=" + weight + ", photo="
				+ Arrays.toString(photo) + ", nbaTeam=" + nbaTeam + ", player="
				+ player + "]";
	}

	
}
