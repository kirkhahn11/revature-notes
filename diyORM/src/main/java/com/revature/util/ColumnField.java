package com.revature.util;

import java.lang.reflect.Field;

import com.revature.annotations.Column;

public class ColumnField {

	//how do i determine if this is a VARCHAR or NUMERIC or SERIAL PRIMARY KEY...
	
	private Field fields; 
	
	public ColumnField(Field fields) {
		
		//if the field object that we pass through DOESN'T have teh column annotation, then it returns null
		if(fields.getAnnotation(Column.class) == null) {
			throw new IllegalStateException("Cannot create ColumnField Object! Provided field " + getName() + " is not annotated with @Column");
			//throws an exception
		} 
		this.fields = fields;
	}
	
	public String getName() {
		return fields.getName();
	}
	
	public Class<?> getType() {
		return fields.getType();
	}
	
	public String getColumnName() {
		return fields.getAnnotation(Column.class).columnName();
	}
}
