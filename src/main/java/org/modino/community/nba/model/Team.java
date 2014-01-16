package org.modino.community.nba.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

//import org.hibernate.annotations.DynamicInsert;
//import org.hibernate.annotations.DynamicUpdate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * 
 * @author dmodino
 *
 */

@Named("team")
@SessionScoped
@Entity
@Table(name="team")
//@DynamicInsert(false)
//Solo las columnas modificadas serán actualizadas en tiempo de ejecucion
//@DynamicUpdate(true)
//public class Team extends NBATeam implements Serializable {
public class Team implements Serializable {

	private static final long serialVersionUID = 7120245471043503643L;
	
	private static final Logger logger = LoggerFactory.getLogger(Team.class);
	
	@Id @NotNull @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="idTeam")
	private int id;
	
	@NotNull
	private String name;
	
	@Column(name="salary") @NotNull
	private double currentSalary;
	
	private int maxPlayers; //12 jugadores
	
	@Transient
	@OneToMany(cascade = CascadeType.ALL, mappedBy ="team")
	private List<Player> players;
	
	private float teamScoring;
	
	@ManyToOne @JoinColumn(name="idLeague")
	private League league;
	
	public Team() {
		super();
		this.players = new ArrayList<Player>();
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getCurrentSalary() {
		return currentSalary;
	}

	public void setCurrentSalary(double currentSalary) {
		this.currentSalary = currentSalary;
	}

	public int getMaxPlayers() {
		return maxPlayers;
	}

	public void setMaxPlayers(int maxPlayers) {
		this.maxPlayers = maxPlayers;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}
	
	public float getTeamScoring() {
		return teamScoring;
	}

	public void setTeamScoring(float teamScoring) {
		this.teamScoring = teamScoring;
	}

	public League getLeague() {
		return league;
	}

	public void setLeague(League league) {
		this.league = league;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void addPlayer(Player player){
		if(this.players == null){
			this.players = new ArrayList<Player>();
		}
		this.players.add(player);
		logger.info("One player has added to your team");
	}
	
	public void removePlayer(Player player){
		if(this.players != null){
			this.players.remove(player);
			logger.info("The player has removed from your team");
		}
		else{
			logger.info("Unable to remove the player from your team");
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(currentSalary);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + id;
		result = prime * result + ((league == null) ? 0 : league.hashCode());
		result = prime * result + maxPlayers;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((players == null) ? 0 : players.hashCode());
		result = prime * result + Float.floatToIntBits(teamScoring);
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
		Team other = (Team) obj;
		if (Double.doubleToLongBits(currentSalary) != Double
				.doubleToLongBits(other.currentSalary))
			return false;
		if (id != other.id)
			return false;
		if (league == null) {
			if (other.league != null)
				return false;
		} else if (!league.equals(other.league))
			return false;
		if (maxPlayers != other.maxPlayers)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (players == null) {
			if (other.players != null)
				return false;
		} else if (!players.equals(other.players))
			return false;
		if (Float.floatToIntBits(teamScoring) != Float
				.floatToIntBits(other.teamScoring))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Team [id=" + id + ", name=" + name + ", currentSalary="
				+ currentSalary + ", maxPlayers=" + maxPlayers + ", players="
				+ players + ", teamScoring=" + teamScoring + ", league="
				+ league + "]";
	}

	
	
}
