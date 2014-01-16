package org.modino.community.nba.model;

import java.io.Serializable;

public class PostForumId implements Serializable{

	private static final long serialVersionUID = -8194590580961109660L;

	private int idUser;
	
	private int idForum;

	public PostForumId() {
		super();
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public int getIdForum() {
		return idForum;
	}

	public void setIdForum(int idForum) {
		this.idForum = idForum;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idForum;
		result = prime * result + idUser;
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
		PostForumId other = (PostForumId) obj;
		if (idForum != other.idForum)
			return false;
		if (idUser != other.idUser)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DailyForumId [idUser=" + idUser + ", idForum=" + idForum + "]";
	}

	
}
