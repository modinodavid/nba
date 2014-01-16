package org.modino.community.nba.model;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
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


@Named("player")
@SessionScoped
@Entity
@Table(name="player")
//@DynamicInsert(false)
//Solo las columnas modificadas serán actualizadas en tiempo de ejecucion
//@DynamicUpdate(true)
public class Player implements Serializable{
//public class Player extends NBAPlayer implements Serializable{
	
	private static final long serialVersionUID = 7896864865958680111L;
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="idPlayer") @NotNull
	private int id;
	
	// Puntuación de la temporada
	private float scoring;
	
	// Promedio de puntos en la temporada
	private float averageScoring;
	
	@ManyToOne @JoinColumn(name="idTeam")
	private Team team;
	
	@Transient
	private NBAPlayer nbaPlayer; 
	
	@ManyToMany(mappedBy ="players")
	private List<Match> matches;
	
	
	public Player() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getScoring() {
		return scoring;
	}

	public void setScoring(float scoring) {
		this.scoring = scoring;
	}

	public float getAverageScoring() {
		return averageScoring;
	}

	public void setAverageScoring(float averageScoring) {
		this.averageScoring = averageScoring;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public NBAPlayer getNbaPlayer() {
		return nbaPlayer;
	}

	public void setNbaPlayer(NBAPlayer nbaPlayer) {
		this.nbaPlayer = nbaPlayer;
	}

	public List<Match> getMatches() {
		return matches;
	}

	public void setMatches(List<Match> matches) {
		this.matches = matches;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(averageScoring);
		result = prime * result + id;
		result = prime * result + ((matches == null) ? 0 : matches.hashCode());
		result = prime * result
				+ ((nbaPlayer == null) ? 0 : nbaPlayer.hashCode());
		result = prime * result + Float.floatToIntBits(scoring);
		result = prime * result + ((team == null) ? 0 : team.hashCode());
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
		Player other = (Player) obj;
		if (Float.floatToIntBits(averageScoring) != Float
				.floatToIntBits(other.averageScoring))
			return false;
		if (id != other.id)
			return false;
		if (matches == null) {
			if (other.matches != null)
				return false;
		} else if (!matches.equals(other.matches))
			return false;
		if (nbaPlayer == null) {
			if (other.nbaPlayer != null)
				return false;
		} else if (!nbaPlayer.equals(other.nbaPlayer))
			return false;
		if (Float.floatToIntBits(scoring) != Float
				.floatToIntBits(other.scoring))
			return false;
		if (team == null) {
			if (other.team != null)
				return false;
		} else if (!team.equals(other.team))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Player [id=" + id + ", scoring=" + scoring
				+ ", averageScoring=" + averageScoring + ", team=" + team
				+ ", nbaPlayer=" + nbaPlayer + ", matches=" + matches + "]";
	}

	
}
