package com.octo.training.legacy;

import java.sql.*;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;



public class CVFactory {

	private static Log logger = LogFactory.getLog(CVFactory.class);

	public static void insertFormation(CV cv) throws SQLException {
		Database.cvTable.put(cv.getIntId(), cv);
        logger.info("inserting CV :" + cv.toString());
	}

    public static CV getTableauBord(Long intId) {
        return Database.cvTable.get(intId);
    }

    
}