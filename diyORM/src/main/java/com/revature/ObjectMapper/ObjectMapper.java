package com.revature.ObjectMapper;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public abstract class ObjectMapper {

	
	protected void setStatement(PreparedStatement pstmt, ParameterMetaData pd, Method getter, Object obj, int index) {
		
		try {
			setPreparedStatementByType(pstmt, pd.getParameterTypeName(index), String.valueOf(getter.invoke(obj)), index);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * @param PreparedStatement to set
	 * @param parameter type
	 * @param input that represents the value to be placed in the prepared statement
	 * @param index to place the value at
	 */
	protected void setPreparedStatementByType(PreparedStatement pstmt, String type, String input, int index) {
		
		// find some way to evaluate the Java type of the type param
		
		try {
			switch(type) {
			case "text": 
			case "String":
			case "varchar": 
			pstmt.setString(index, input);
			break;
			case "int":
				pstmt.setInt(index, Integer.parseInt(input));
				break;
			case "double":
				// can account for more types
				pstmt.setDouble(index, Double.parseDouble(input));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
