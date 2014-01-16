package org.modino.community.nba.model;

import java.io.Serializable;
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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * 
 * @author dmodino
 *
 */

//import org.hibernate.annotations.DynamicInsert;
//import org.hibernate.annotations.DynamicUpdate;


@Named("match")
@SessionScoped
@Entity
@Table(name="match")
//@DynamicInsert(false)
//Solo las columnas modificadas serán actualizadas en tiempo de ejecucion
//@DynamicUpdate(true)
public class Match implements Serializable{

	private static final long serialVersionUID = -3620583131121614473L;

	// Campos basicos
	//@GeneratedValue(strategy=GenerationType.IDENTITY) -> indica las claves principales para la entidad y crea una columna en la BD para ella
	@Id @NotNull @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="idMatch")
	private int id;
	
	@NotNull
	private Team homeTeam;
	
	@NotNull
	private Team visitingTeam;
	
	// fecha y hora del partido
	private Date dateHourMatch;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name="Scoring", 
	joinColumns={@JoinColumn(name="idMatch")}, inverseJoinColumns = {@JoinColumn(name="idPlayer")})
	private List<Player> players;
	
	public Match() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public Team getHomeTeam() {
		return homeTeam;
	}

	public void setHomeTeam(Team homeTeam) {
		this.homeTeam = homeTeam;
	}

	public Team getVisitingTeam() {
		return visitingTeam;
	}

	public void setVisitingTeam(Team visitingTeam) {
		this.visitingTeam = visitingTeam;
	}

	public Date getDateHourMatch() {
		return dateHourMatch;
	}

	public void setDateHourMatch(Date dateHourMatch) {
		this.dateHourMatch = dateHourMatch;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((dateHourMatch == null) ? 0 : dateHourMatch.hashCode());
		result = prime * result
				+ ((homeTeam == null) ? 0 : homeTeam.hashCode());
		result = prime * result + id;
		result = prime * result + ((players == null) ? 0 : players.hashCode());
		result = prime * result
				+ ((visitingTeam == null) ? 0 : visitingTeam.hashCode());
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
		Match other = (Match) obj;
		if (dateHourMatch == null) {
			if (other.dateHourMatch != null)
				return false;
		} else if (!dateHourMatch.equals(other.dateHourMatch))
			return false;
		if (homeTeam == null) {
			if (other.homeTeam != null)
				return false;
		} else if (!homeTeam.equals(other.homeTeam))
			return false;
		if (id != other.id)
			return false;
		if (players == null) {
			if (other.players != null)
				return false;
		} else if (!players.equals(other.players))
			return false;
		if (visitingTeam == null) {
			if (other.visitingTeam != null)
				return false;
		} else if (!visitingTeam.equals(other.visitingTeam))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Match [id=" + id + ", homeTeam=" + homeTeam + ", visitingTeam="
				+ visitingTeam + ", dateHourMatch=" + dateHourMatch
				+ ", players=" + players + "]";
	}

	
}
