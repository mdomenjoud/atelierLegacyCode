package com.octo.training.legacy;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.sql.SQLException;

import org.junit.Test;

public class UTestAjoutFormationCtrl {
	
	@Test
	public void dummyTest() throws SQLException{
		AjoutFormationCtrl controller = new AjoutFormationCtrl();
    	SessionContainer scc = new SessionContainer();
		
    	CtrlAttributesEnregistrer attributes = new CtrlAttributesEnregistrer();
    	attributes.param_f_formation1_diplome = "Master";
    	attributes.param_f_formation1_lieu = "Paris";
    	attributes.param_f_niveau_formation = 5L;
    	
		for(int i=0;i<21;i++){
			controller.doEnregistrer(null, scc, attributes);
		}
		
		CV retrieved = CVFactory.getTableauBord(scc.getInternaute().getIntId());
		
		assertThat(retrieved.getCuvPourcentFormation(), is(100));
	}

}
