package com.revature.util;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Configuration {

	//all jdbc properties needed to establish connection with the database
	
	private List<MetaModel<Class<?>>> metaModelList;
	
	// maybe some connection pooling properties
	
	//of() method takes in a class and transform it to a meta model
	
	// this is essentially what the Hibernate.cfg.xml file does
	public Configuration addAnnotatedClass(Class annotatedClass) {
		if(metaModelList == null) {
			
			metaModelList = new LinkedList<>();
			
		}
		
		metaModelList.add(MetaModel.of(annotatedClass));
		// Create the of method inside MetaModel to transform a class
		// into an appropriate data model to be transposed into a relational db object.
		
		return this;
	}
	
	public List<MetaModel<Class<?>>> getMetaModels() {
		
		return (List<MetaModel<Class<?>>>) ((metaModelList == null) ? Collections.emptyList() : metaModelList);
	}
}
