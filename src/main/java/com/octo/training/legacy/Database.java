package com.octo.training.legacy;

import java.util.HashMap;
import java.util.Map;

public class Database {

	static Map<Long, Formation> formationTable = new HashMap<Long, Formation>();
	static Map<Long, CV> cvTable = new HashMap<Long, CV>();
	
	static{
		CV initialCV = new CV();
		initialCV.setIntId(1L);
		initialCV.setCuvPourcentFormation(0);
		initialCV.setNivCode(2L);
		cvTable.put(1L, initialCV);
	}

}
