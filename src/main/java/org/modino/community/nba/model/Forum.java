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
@Named("forum")
@SessionScoped
@Entity
@Table(name="forum")
public class Forum implements Serializable{

	private static final long serialVersionUID = -7947530531027102771L;

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="idForum") @NotNull
	private int id;
	
	@NotNull
	private String topic;
	
	private int posts;
	
	private int visits;
	
	private Date lastPost;
	
    // mappedBy -> to indicate the entity that owns the relationship.
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name="PostForum", 
	joinColumns={@JoinColumn(name="idForum")}, inverseJoinColumns = {@JoinColumn(name="idUser")})
    private List<User> users;

	public Forum() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public int getPosts() {
		return posts;
	}

	public void setPosts(int posts) {
		this.posts = posts;
	}

	public int getVisits() {
		return visits;
	}

	public void setVisits(int visits) {
		this.visits = visits;
	}

	public Date getLastPost() {
		return lastPost;
	}

	public void setLastPost(Date lastPost) {
		this.lastPost = lastPost;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result
				+ ((lastPost == null) ? 0 : lastPost.hashCode());
		result = prime * result + posts;
		result = prime * result + ((topic == null) ? 0 : topic.hashCode());
		result = prime * result + ((users == null) ? 0 : users.hashCode());
		result = prime * result + visits;
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
		Forum other = (Forum) obj;
		if (id != other.id)
			return false;
		if (lastPost == null) {
			if (other.lastPost != null)
				return false;
		} else if (!lastPost.equals(other.lastPost))
			return false;
		if (posts != other.posts)
			return false;
		if (topic == null) {
			if (other.topic != null)
				return false;
		} else if (!topic.equals(other.topic))
			return false;
		if (users == null) {
			if (other.users != null)
				return false;
		} else if (!users.equals(other.users))
			return false;
		if (visits != other.visits)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Forum [id=" + id + ", topic=" + topic + ", posts=" + posts
				+ ", visits=" + visits + ", lastPost=" + lastPost + ", users="
				+ users + "]";
	}
	
}
