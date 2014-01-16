package org.modino.community.nba.services;

import java.util.List;

import org.modino.community.nba.model.Forum;
import org.modino.community.nba.model.League;
import org.modino.community.nba.model.NBATeam;
import org.modino.community.nba.model.Poll;
import org.omg.CORBA.portable.ApplicationException;

public interface HomeService {
	
	// Mostrar las ligas privadas y pœblicas
	public List<League> getAllLeagues() throws ApplicationException;
	// Mostrar las ligas privadas
	public List<League> getPrivateLeagues() throws ApplicationException;
	// Mostrar las ligas pœblicas
	public List<League> getPublicLeagues() throws ApplicationException;
	// Mostrar las encuestas pœblicas
	public List<Poll> getAllPolls() throws ApplicationException;
	// Mostrar todos los foros
	public List<Forum> getAllForums() throws ApplicationException;
	//Listar todos los equipos por Conferencia o Division
	public List<NBATeam> getAllTeams() throws ApplicationException;
}
