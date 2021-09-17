package com.revature.util;

import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.List;

import com.revature.annotations.Column;
import com.revature.annotations.Entity;
import com.revature.annotations.Id;

public class MetaModel<T> {

	private Class<T> clazz;
	private IdField idField;
	private List<ColumnField> columnFields;
	// private List<ForeignKeyField> foreignKeyFields
	
	//MetaModel constructor here

	
	public static <T> MetaModel<T> of(Class<T> clazz) {
		
		// first we have to check that it's marked with the Entity annotation
		if(clazz.getAnnotation(Entity.class) == null) {
			throw new IllegalStateException("Cannot create Metamodel object! Provided class " + clazz.getName() + " is not annotated with @Entity");
			
		}
		return new MetaModel<>(clazz);
	}
	
	public MetaModel(Class<T> clazz) {
		this.clazz = clazz;
		this.columnFields = new LinkedList<>();
	}
	
	// class name is com.revature.MyClass
	public String getClassName() {
		return clazz.getName();
	}
	//simple class name is just MyClass
	public String getSimpleClassName() {
		return clazz.getSimpleName();
	}
	
	//public idField getPrimaryKey() ... need to create the IdField class...
	
	//public List<ForeignKeyField> getForeignKeys()
	public IdField getPrimaryKey() throws Exception{
		Field[] fields = clazz.getDeclaredFields();//get all fields
		for (Field field : fields) {
			Id id = field.getAnnotation(Id.class);
			if (id != null) {
				idField= new IdField(field);
				return idField;
			}
		}
		throw new Exception("No primary key found for "+ clazz.getSimpleName());
	}

	public List<ColumnField> getColumns() {
		Field[] fields = clazz.getDeclaredFields();
		
		for(Field field : fields) {
			Column column = field.getAnnotation(Column.class);
			
			if(column != null) {
				columnFields.add(new ColumnField(field));
			}
		}
		return columnFields;
	}
}
