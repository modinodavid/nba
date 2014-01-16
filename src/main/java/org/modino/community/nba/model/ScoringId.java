package org.modino.community.nba.model;

import java.io.Serializable;
/**
 * 
 * @author dmodino
 *
 */
public class ScoringId implements Serializable{

	private static final long serialVersionUID = -5542082454296893115L;
	
	private int idMatch;
	private int idPlayer;
	
	
	public ScoringId() {
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idMatch;
		result = prime * result + idPlayer;
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
		ScoringId other = (ScoringId) obj;
		if (idMatch != other.idMatch)
			return false;
		if (idPlayer != other.idPlayer)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ScoringId [idMatch=" + idMatch + ", idPlayer=" + idPlayer + "]";
	}
	
	
	
	
}
