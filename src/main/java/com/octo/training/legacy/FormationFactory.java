// ----------------------------------------------------------------------------79
// SMILE
//
// @(#) $Header:
// /home/cvs/RefonteEspacePro/src/fr/cadremploi/biz/formation/FormationFactory.java,v
// 1.5 2005/12/06 17:20:09 lapag Exp $
//
// Langage : Java
//
// Description : Gestion des Formations
//
// Auteur : J�r�me Cohonner - SMILE
// Date creation : 26/02/2004
//
// Historique :
//
// ----------------------------------------------------------------------------79
package com.octo.training.legacy;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class FormationFactory {
	
	private static Log logger = LogFactory.getLog(FormationFactory.class);

	public static void insert(Formation formation) throws SQLException {
		// Warning : fake for exercise
		Long newId = Long.valueOf(Database.formationTable.size());
		Database.formationTable.put(newId, formation);
		logger.info("inserting Formation :" + formation.toString());
	}

	public static void update(Formation formation) throws SQLException {
		// Warning : fake for exercise
		if(Database.formationTable.get(formation).getFrmId() == null){
			throw new SQLException("No ROW in table FORMATION with given Identifier : "+formation.getFrmId());
		}
		Database.formationTable.put(formation.getFrmId(), formation);
		logger.info("Updating Formation :" + formation.toString());
	}

	public static Integer getPourcent(Long intId) throws SQLException {
		// Warning : fake for exercise
		CV cv = Database.cvTable.get(intId);
		return cv.getCuvPourcentFormation();
	}

	public static List<Formation> list(Long intId) {
		// Warning : fake for exercise
		return new ArrayList<Formation>(Database.formationTable.values());
	}
}
