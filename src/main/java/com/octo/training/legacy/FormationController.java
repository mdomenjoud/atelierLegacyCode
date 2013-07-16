package com.octo.training.legacy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

@Controller
public class FormationController {
	
	@Autowired
	private HttpServletRequest req;

    @RequestMapping(value="/formation/list", method = RequestMethod.GET)
    public @ResponseBody String list(@RequestParam("int_id") Long intId) throws SQLException {
    	List<Formation> results = FormationFactory.list(intId) ; 
    	
    	String output = "<h1>Liste des formations</h1><table>";
    	Integer pourcent = FormationFactory.getPourcent(intId);
		output+="<h4>Pourcentage de remplissage : "+pourcent +"</h4>";
		
		output+="<tr><td>ID internaute</td><td>ID Formation</td><td> Date Début</td><td> Date Fin</td><td>Ecole"
				+"</td><td>Lieu</td><td>Specialite</td><td>Diplome</td><td>Obtenu"
				+ "</td><td>Code</td><td>Libelle</td></tr>";
    	for(Formation result : results){
    		output+=result;
    	}
    	output+="</table>";
        return output;
    }
    
    @RequestMapping(value="/formation/add", method = RequestMethod.GET)
    public ModelAndView add(@RequestParam("int_id") Long intId) {
    	ModelAndView mav = new ModelAndView("addForm");
    	mav.addObject(new CtrlAttributesEnregistrer());
    	return mav;
    }
    
    @RequestMapping(value="/formation/save", method = RequestMethod.GET)
    public String save() {
    	AjoutFormationCtrl controller = new AjoutFormationCtrl();
    	SessionContainer scc = new SessionContainer();
		
    	CtrlAttributesEnregistrer attributes = new CtrlAttributesEnregistrer();
    	attributes.param_f_formation1_diplome = "Master";
    	attributes.param_f_formation1_lieu = "Paris";
    	attributes.param_f_niveau_formation = 5L;
    	
		try{
			controller.doEnregistrer(req, scc, attributes);
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		
		return "redirect:/formation/list?int_id="+scc.getInternaute().getIntId();
    }
}
