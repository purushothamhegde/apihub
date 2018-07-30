package com.philips.apihub.informatica.mdm;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class MDMServiceDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    
    public List<MDMJobResponse> GetMDMJobGroupResponse(String rowidBatchGroup) {
    	
    	
		String sQuery="SELECT C_REPOS_JOB_GROUP_CONTROL.ROWID_JOB_GROUP ,C_REPOS_JOB_GROUP.JOB_GROUP_NAME ,C_REPOS_JOB_CONTROL.TABLE_DISPLAY_NAME, C_REPOS_OBJ_FUNCTION_TYPE.OBJECT_FUNCTION_TYPE_DESC, ";
		sQuery=sQuery + " C_REPOS_JOB_CONTROL.STATUS_MESSAGE,C_REPOS_JOB_METRIC_TYPE.METRIC_TYPE_CODE,METRIC_TYPE_DESC,METRIC_VALUE ";
		sQuery=sQuery + " FROM C_REPOS_JOB_METRIC ,C_REPOS_JOB_METRIC_TYPE,C_REPOS_OBJ_FUNCTION_TYPE,C_REPOS_JOB_CONTROL,C_REPOS_JOB_GROUP_CONTROL,C_REPOS_JOB_GROUP ";
		sQuery=sQuery + " WHERE " ;
		sQuery=sQuery + " C_REPOS_JOB_METRIC_TYPE.METRIC_TYPE_CODE=C_REPOS_JOB_METRIC.METRIC_TYPE_CODE AND " ;
		sQuery=sQuery + " C_REPOS_JOB_METRIC.ROWID_JOB=C_REPOS_JOB_CONTROL.ROWID_JOB AND " ;
		sQuery=sQuery + " C_REPOS_JOB_CONTROL.OBJECT_FUNCTION_TYPE_CODE=C_REPOS_OBJ_FUNCTION_TYPE.OBJECT_FUNCTION_TYPE_CODE AND " ;
		sQuery=sQuery + " C_REPOS_JOB_CONTROL.ROWID_JOB_GROUP_CONTROL=C_REPOS_JOB_GROUP_CONTROL.ROWID_JOB_GROUP_CONTROL AND " ;
		sQuery=sQuery + " C_REPOS_JOB_GROUP_CONTROL.ROWID_JOB_GROUP =C_REPOS_JOB_GROUP.ROWID_JOB_GROUP AND " ;
		sQuery=sQuery + " C_REPOS_JOB_CONTROL.ROWID_JOB_GROUP_CONTROL='" +  rowidBatchGroup + "' AND METRIC_VALUE>0";
		
		return this.jdbcTemplate.query(sQuery, new RowMapper<MDMJobResponse>() {

			public MDMJobResponse mapRow(ResultSet myrs2, int rowNum) throws SQLException {
				MDMJobResponse mymdmjobres = new MDMJobResponse();
				mymdmjobres.setJobGroupName(myrs2.getString(2));
				mymdmjobres.setTableDisplayName(myrs2.getString(3));
				mymdmjobres.setJobStage(myrs2.getString(4));
				mymdmjobres.setJobStageStatus(myrs2.getString(5));
				mymdmjobres.setJobStageMetricName(myrs2.getString(7));
				mymdmjobres.setJobStageMetricValue(myrs2.getString(8));
				return mymdmjobres;
				}
			});
    		
    }
    
}
