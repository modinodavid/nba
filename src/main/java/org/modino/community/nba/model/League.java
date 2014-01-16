package org.modino.community.nba.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
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

@Named("league")
@SessionScoped
@Entity
@Table(name="league")
//@DynamicInsert(false)
//Solo las columnas modificadas serán actualizadas en tiempo de ejecucion
//@DynamicUpdate(true)

public class League implements Serializable {

        private static final long serialVersionUID = 6871943066701739826L;
        private static final Logger logger = LoggerFactory.getLogger(League.class);
        
        // Campos basicos
        //@GeneratedValue(strategy=GenerationType.IDENTITY) -> indica las claves principales para la entidad y crea una columna en la BD para ella
        @Id @NotNull @GeneratedValue(strategy=GenerationType.AUTO)
        @Column(name="idLeague")
        private int id;
        
        @NotNull
        private String name;
        
        @Lob
        @Basic(fetch = FetchType.LAZY)
        private byte[] logo;
        
        @NotNull
        private String password;
        
        @NotNull
        private int maxTeams;
        
        // Salario inicial para todos los equipos
        @NotNull
        @Column(name= "salaryPerTeam")
        private double initialSalaryPerEachTeam;
        
        @Transient
        @OneToMany(cascade = CascadeType.ALL, mappedBy ="league")
        private List<Team> teams;
        
        // mappedBy -> to indicate the entity that owns the relationship.
        @ManyToOne @JoinColumn(name="idUser")
        private User user;
        
        public League() {
                super();
        }
        
        public int getId() {
                return id;
        }

        public void setId(int id) {
                this.id = id;
        }


        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public byte[] getLogo() {
                return logo;
        }

        public void setLogo(byte[] logo) {
                this.logo = logo;
        }

        public String getPassword() {
                return password;
        }

        public void setPassword(String password) {
                this.password = password;
        }

        public int getMaxTeams() {
                return maxTeams;
        }

        public void setMaxTeams(int maxTeams) {
                this.maxTeams = maxTeams;
        }

        public double getInitialSalaryPerEachTeam() {
                return initialSalaryPerEachTeam;
        }

        public void setInitialSalaryPerEachTeam(double initialSalaryPerEachTeam) {
                this.initialSalaryPerEachTeam = initialSalaryPerEachTeam;
        }

        public List<Team> getTeams() {
                return teams;
        }

        public void setTeams(List<Team> teams) {
                this.teams = teams;
        }
        
        public User getUser() {
                return user;
        }

        public void setUser(User user) {
                this.user = user;
        }
        
        public void addTeam(Team team){
                if(this.teams == null){
                        this.teams = new ArrayList<Team>();
                }
                this.teams.add(team);
                logger.info("One team has added to your league");
        }
        
        public void removeTeam(Team team){
                if(this.teams != null){
                        this.teams.remove(team);
                        logger.info("The team has removed from your league");
                }
                else{
                        logger.info("Unable to remove the team from your league");
                }
        }

        @Override
        public int hashCode() {
                final int prime = 31;
                int result = 1;
                result = prime * result + id;
                long temp;
                temp = Double.doubleToLongBits(initialSalaryPerEachTeam);
                result = prime * result + (int) (temp ^ (temp >>> 32));
                result = prime * result + Arrays.hashCode(logo);
                result = prime * result + maxTeams;
                result = prime * result + ((name == null) ? 0 : name.hashCode());
                result = prime * result
                                + ((password == null) ? 0 : password.hashCode());
                result = prime * result + ((teams == null) ? 0 : teams.hashCode());
                result = prime * result + ((user == null) ? 0 : user.hashCode());
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
                League other = (League) obj;
                if (id != other.id)
                        return false;
                if (Double.doubleToLongBits(initialSalaryPerEachTeam) != Double
                                .doubleToLongBits(other.initialSalaryPerEachTeam))
                        return false;
                if (!Arrays.equals(logo, other.logo))
                        return false;
                if (maxTeams != other.maxTeams)
                        return false;
                if (name == null) {
                        if (other.name != null)
                                return false;
                } else if (!name.equals(other.name))
                        return false;
                if (password == null) {
                        if (other.password != null)
                                return false;
                } else if (!password.equals(other.password))
                        return false;
                if (teams == null) {
                        if (other.teams != null)
                                return false;
                } else if (!teams.equals(other.teams))
                        return false;
                if (user == null) {
                        if (other.user != null)
                                return false;
                } else if (!user.equals(other.user))
                        return false;
                return true;
        }

        @Override
        public String toString() {
                return "League [id=" + id + ", name=" + name + ", logo="
                                + Arrays.toString(logo) + ", password=" + password
                                + ", maxTeams=" + maxTeams + ", initialSalaryPerEachTeam="
                                + initialSalaryPerEachTeam + ", teams=" + teams + ", user=" + user + "]";
        }

        
}