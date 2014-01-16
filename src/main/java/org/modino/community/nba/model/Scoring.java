package org.modino.community.nba.model;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * 
 * @author dmodino
 *
 */

//import org.hibernate.annotations.DynamicInsert;
//import org.hibernate.annotations.DynamicUpdate;


@Embeddable
@Named("scoring")
@SessionScoped
@Entity @IdClass(ScoringId.class)
@Table(name="scoring")
//@DynamicInsert(false)
//Solo las columnas modificadas serán actualizadas en tiempo de ejecucion
//@DynamicUpdate(true)
public class Scoring implements Serializable{
	
	private static final long serialVersionUID = 7894652533150093463L;
	
	public static enum Type {Default, Customized}
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idMatch")
	private int idMatch;
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idPlayer")
	private int idPlayer;
	
	// El tipo puede ser 'Por defecto' o 'Personalizado'
	@NotNull
	private Type type;
	
	private int assists;
	
	@Column(name="offRebounds")
	private int offensiveRebouns;
	
	@Column(name="defRebounds")
	private int defensiveRebouns;
	
	private int blocks;
	
	private int steals;
	
	private int freeThrows;
	
	private int freeThrowMakes;
	
	private int twoPointShots;
	
	private int twoPointMakes;
	
	private int threePointShots;
	
	private int threePointMakes;
	
	private int turnovers;
	
	private int personalFoul;
	
	private int technicalFoul;
	
	private int teamWin;
	
	private int teamLose;
	
	public Scoring() {
		super();
	}

	public int getIdMatch() {
		return idMatch;
	}

	public void setIdMatch(int idMatch) {
		this.idMatch = idMatch;
	}

	public int getIdPlayer() {
		return idPlayer;
	}

	public void setIdPlayer(int idPlayer) {
		this.idPlayer = idPlayer;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public int getAssists() {
		return assists;
	}

	public void setAssists(int assists) {
		this.assists = assists;
	}

	public int getOffensiveRebouns() {
		return offensiveRebouns;
	}

	public void setOffensiveRebouns(int offensiveRebouns) {
		this.offensiveRebouns = offensiveRebouns;
	}

	public int getDefensiveRebouns() {
		return defensiveRebouns;
	}

	public void setDefensiveRebouns(int defensiveRebouns) {
		this.defensiveRebouns = defensiveRebouns;
	}

	public int getBlocks() {
		return blocks;
	}

	public void setBlocks(int blocks) {
		this.blocks = blocks;
	}

	public int getSteals() {
		return steals;
	}

	public void setSteals(int steals) {
		this.steals = steals;
	}

	public int getFreeThrows() {
		return freeThrows;
	}

	public void setFreeThrows(int freeThrows) {
		this.freeThrows = freeThrows;
	}

	public int getFreeThrowMakes() {
		return freeThrowMakes;
	}

	public void setFreeThrowMakes(int freeThrowMakes) {
		this.freeThrowMakes = freeThrowMakes;
	}

	public int getTwoPointShots() {
		return twoPointShots;
	}

	public void setTwoPointShots(int twoPointShots) {
		this.twoPointShots = twoPointShots;
	}

	public int getTwoPointMakes() {
		return twoPointMakes;
	}

	public void setTwoPointMakes(int twoPointMakes) {
		this.twoPointMakes = twoPointMakes;
	}

	public int getThreePointShots() {
		return threePointShots;
	}

	public void setThreePointShots(int threePointShots) {
		this.threePointShots = threePointShots;
	}

	public int getThreePointMakes() {
		return threePointMakes;
	}

	public void setThreePointMakes(int threePointMakes) {
		this.threePointMakes = threePointMakes;
	}

	public int getTurnovers() {
		return turnovers;
	}

	public void setTurnovers(int turnovers) {
		this.turnovers = turnovers;
	}

	public int getPersonalFoul() {
		return personalFoul;
	}

	public void setPersonalFoul(int personalFoul) {
		this.personalFoul = personalFoul;
	}

	public int getTechnicalFoul() {
		return technicalFoul;
	}

	public void setTechnicalFoul(int technicalFoul) {
		this.technicalFoul = technicalFoul;
	}

	public int getTeamWin() {
		return teamWin;
	}

	public void setTeamWin(int teamWin) {
		this.teamWin = teamWin;
	}

	public int getTeamLose() {
		return teamLose;
	}

	public void setTeamLose(int teamLose) {
		this.teamLose = teamLose;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + assists;
		result = prime * result + blocks;
		result = prime * result + defensiveRebouns;
		result = prime * result + freeThrowMakes;
		result = prime * result + freeThrows;
		result = prime * result + idMatch;
		result = prime * result + idPlayer;
		result = prime * result + offensiveRebouns;
		result = prime * result + personalFoul;
		result = prime * result + steals;
		result = prime * result + teamLose;
		result = prime * result + teamWin;
		result = prime * result + technicalFoul;
		result = prime * result + threePointMakes;
		result = prime * result + threePointShots;
		result = prime * result + turnovers;
		result = prime * result + twoPointMakes;
		result = prime * result + twoPointShots;
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		Scoring other = (Scoring) obj;
		if (assists != other.assists)
			return false;
		if (blocks != other.blocks)
			return false;
		if (defensiveRebouns != other.defensiveRebouns)
			return false;
		if (freeThrowMakes != other.freeThrowMakes)
			return false;
		if (freeThrows != other.freeThrows)
			return false;
		if (idMatch != other.idMatch)
			return false;
		if (idPlayer != other.idPlayer)
			return false;
		if (offensiveRebouns != other.offensiveRebouns)
			return false;
		if (personalFoul != other.personalFoul)
			return false;
		if (steals != other.steals)
			return false;
		if (teamLose != other.teamLose)
			return false;
		if (teamWin != other.teamWin)
			return false;
		if (technicalFoul != other.technicalFoul)
			return false;
		if (threePointMakes != other.threePointMakes)
			return false;
		if (threePointShots != other.threePointShots)
			return false;
		if (turnovers != other.turnovers)
			return false;
		if (twoPointMakes != other.twoPointMakes)
			return false;
		if (twoPointShots != other.twoPointShots)
			return false;
		if (type != other.type)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Scoring [idMatch=" + idMatch + ", idPlayer=" + idPlayer
				+ ", type=" + type + ", assists=" + assists
				+ ", offensiveRebouns=" + offensiveRebouns
				+ ", defensiveRebouns=" + defensiveRebouns + ", blocks="
				+ blocks + ", steals=" + steals + ", freeThrows=" + freeThrows
				+ ", freeThrowMakes=" + freeThrowMakes + ", twoPointShots="
				+ twoPointShots + ", twoPointMakes=" + twoPointMakes
				+ ", threePointShots=" + threePointShots + ", threePointMakes="
				+ threePointMakes + ", turnovers=" + turnovers
				+ ", personalFoul=" + personalFoul + ", technicalFoul="
				+ technicalFoul + ", teamWin=" + teamWin + ", teamLose="
				+ teamLose + "]";
	}

	
}
