package com.maan.common.util;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Vector;
import com.maan.common.db.DatabaseDAO;
public class runner
{
	
	
	public static String multipleInsertion(String q,String[] cols)
	{
		String result=new String();
		PreparedStatement pre=null;
		Connection con=null;
		try
		{
			con=DatabaseDAO.getInstance().getDBConnection();
			pre	=con.prepareStatement(q);
			System.out.println("s...........s.............."+cols.length);
			for(int i=0;i<cols.length;i++)
			{
				System.out.println("pre.setString("+i+",'"+cols[i]+"')");
				pre.setString(i+1,cols[i]);
			}
			pre.executeUpdate();
			con.commit();
			result="INSERTED";
		}
		catch(Exception e)
		{
			System.out.println("Query......."+q);
			System.out.println("Error in runner 80....."+e.toString());e.printStackTrace();
			result="DIDN'T INSERTED  "+e.toString();
		}
		finally
		{
			try
			{
				if(pre!=null)
					pre.close();
				if(con!=null)
					con.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		return result;
	}	


	public static String[][] multipleSelection(String q,String cols[])
	{
			String[][] finalResult = null;
			PreparedStatement pre = null;
			Connection con =null;
			ResultSet rs = null;
			try
			{
				con = DatabaseDAO.getInstance().getDBConnection();
				pre	= con.prepareStatement(q);
				System.out.println("multipleSelection...qry is..."+q);
				for(int i=0;i<cols.length;i++)
				{
					pre.setString(i+1,cols[i]);
					System.out.println("pre.setString("+i+",'"+cols[i]+"')");
				}
				rs=pre.executeQuery();
				ResultSetMetaData rsmd = rs.getMetaData();
				Vector result = new Vector();
				int col = rsmd.getColumnCount();
				// untill the records in the result set, get the fields and add into the Vector.
				
				while(rs.next())
				{
					String record[] = new String[col];
					for(int i=0; i < col; i++)
					{
						record[i] = rs.getString(i+1);
						
					}
					result.addElement(record);
				}
				rs.close();
				// convert the vector into two dimension string array and return the array.
				finalResult = new String[result.size()][col];
				for(int i=0; i < result.size(); i++)
				{
					finalResult[i] = (String[])result.elementAt(i);
				}
			}
			catch(Exception e)
			{
				finalResult = new String[0][0];
				System.out.println("Query is ..."+q);
				System.out.println("Error in runner multipleSelection preparedstatement ..."+e.toString());
				e.printStackTrace();
			}
			finally
			{
				try
				{
					if(pre!=null)
						pre.close();
					if(con!=null)
						con.close();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
			return finalResult;
	}

	public static String singleSelection(String q,String[] cols)
	{
			String result=new String();
			PreparedStatement pre=null;
			ResultSet rs=null;
			Connection con=null;
			try
			{
				con = DatabaseDAO.getInstance().getDBConnection();
				pre	= con.prepareStatement(q);
				System.out.println("singleSelection Query is ..."+q);
				for(int i=0;i<cols.length;i++)
				{
					pre.setString(i+1,cols[i]);
					System.out.println("pre.setString("+i+",'"+cols[i]+"')");
				}
				rs=pre.executeQuery();
				if(rs.next())
					result=rs.getString(1);

			}
			catch(Exception e)
			{
				System.out.println("query....."+q);
				System.out.println("Error in runner 21 ..."+e.toString());e.printStackTrace();
				result="";

			}
			finally
			{
				try
				{
					if(rs!=null)
						rs.close();
					if(pre!=null)
						pre.close();
					if(con!=null)
						con.close();
				}
				catch(Exception e)
				{
					System.out.println("ERROR in singleSelection prepared statement...."+e.toString());e.printStackTrace();
				}
			}
		return result;
	}

	
}