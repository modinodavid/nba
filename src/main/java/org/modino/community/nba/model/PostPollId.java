package org.modino.community.nba.model;

import java.io.Serializable;

public class PostPollId implements Serializable{

	private static final long serialVersionUID = -8194590580961109660L;

	private int idUser;
	
	private int idPoll;

	public PostPollId() {
		super();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idPoll;
		result = prime * result + idUser;
		return result;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public int getIdPoll() {
		return idPoll;
	}

	public void setIdPoll(int idPoll) {
		this.idPoll = idPoll;
	}

	@Override
	public String toString() {
		return "DailyPollId [idUser=" + idUser + ", idPoll=" + idPoll + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PostPollId other = (PostPollId) obj;
		if (idPoll != other.idPoll)
			return false;
		if (idUser != other.idUser)
			return false;
		return true;
	}
	
	
	
}
