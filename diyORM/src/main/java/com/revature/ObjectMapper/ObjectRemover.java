package com.revature.ObjectMapper;

import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.revature.util.MetaModel;

public class ObjectRemover extends ObjectMapper{

	public boolean removeObjectFromDb(Object obj, Connection conn) {
		
		MetaModel<?> model = MetaModel.of(obj.getClass()); // use this to create an instance of the object
		
		
		try {
			String primaryKey = model.getPrimaryKey().getName(); // would need to implement getPrimaryKey();
			
			String sql = "Delete from " + model.getSimpleClassName() + "WHERE " + primaryKey + "= ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			// we want to grab metadata from above statement and pass it into setStatement
			
			ParameterMetaData pd = pstmt.getParameterMetaData();
			Method getter = model.getClass().getDeclaredMethod("get"+primaryKey);
			// instead of Method, maybe pass in a hash map containing info about the class
			setStatement(pstmt, pd, getter, obj, 1);
			
			//ObjectCache class....
			//get instance and remove the 
			
			pstmt.executeUpdate();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
}
