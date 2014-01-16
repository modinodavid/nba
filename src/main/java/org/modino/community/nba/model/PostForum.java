package org.modino.community.nba.model;

import java.io.Serializable;
import java.util.Date;

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
@Embeddable
@Named("postForum")
@SessionScoped
@Entity @IdClass(PostForumId.class)
@Table(name="postForum")
public class PostForum implements Serializable{
	
	private static final long serialVersionUID = -367646609100804238L;

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idUser")
	private int idUser;
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idForum")
	private int idForum;

	@NotNull
	private Date creationDate;

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

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	
	
}
