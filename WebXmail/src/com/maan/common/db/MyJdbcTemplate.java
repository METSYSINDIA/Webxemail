package com.maan.common.db;

import com.maan.common.util.LogUtil;
import com.maan.common.util.ResourceLocator;

import java.sql.SQLException;
import org.slf4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
/**
 * @author Raja.K
 *
 * Common Login Template
 */
public class MyJdbcTemplate {

    private static final Logger logger = LogUtil.getLogger(MyJdbcTemplate.class);
    protected JdbcTemplate mytemplate;

    public MyJdbcTemplate() {
        try {
            mytemplate = DatabaseDAO.getInstance().gettemplate();
        } catch (SQLException e) {
            logger.error("Error while getting Spring instance ", e);
        }
    }

    public JdbcTemplate getMytemplate() {
        return mytemplate;
    }

    public void setMytemplate(final JdbcTemplate mytemplate) {
        this.mytemplate = mytemplate;
    }
	
	public String getQuery(String key){
		String query;
		query=ResourceLocator.getInstance().getDBBundle().getString(key);
		return query;
		
	}
	protected void removeNull(Object []args) {
		for(int i=0;i<args.length;i++) {
			if(args[i]==null)
				args[i]="";
		}
	}
	
	public String queryFrammer(String query ,Object[] args){
		try{
			if(args != null){
				for(int i=0;i<args.length;i++){
					query = query.substring(0, query.indexOf("?")) +"'"+args[i]+"'"+ query.substring(query.indexOf("?") + 1);
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return query;
	}

}