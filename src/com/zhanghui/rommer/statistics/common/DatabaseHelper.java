package com.zhanghui.rommer.statistics.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.zhanghui.rommer.domain.PopInfo;

/**
 * 数据库访问帮助类
 * 
 * @author <a href="pangkunyi@gmail.com">Calvin Pang</a>
 * 
 */
public final class DatabaseHelper {
    public final static int BATCH_SIZE=1000;
	/**
	 * 获取数据库链接
	 * 
	 * @return
	 * @throws ClassNotFoundException
	 * @throws java.sql.SQLException
	 */
	public final static Connection getDatabaseConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		return DriverManager.getConnection(Config.getProperty("mysql.url"),
				Config.getProperty("mysql.username"),
				Config.getProperty("mysql.password"));
	}

	/**
	 * 关闭数据链接
	 * 
	 * @param rs
	 * @param pstmt
	 * @param conn
	 */
	public final static void closeDatabaseComponent(ResultSet rs, PreparedStatement pstmt, Connection conn) {
		if (rs != null) {
			try {
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			rs = null;
		}
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			pstmt = null;
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			conn = null;
		}
	}

	public final static void persistToDatabase(List<PopInfo> datas) throws SQLException, ClassNotFoundException {
        if(datas==null || datas.isEmpty()){
            return;
        }
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = getDatabaseConnection();
			String sql = "INSERT INTO pop_info_bak (UUID,LANGUAGE,netType,channel,isShowAd,lastShowAdDate,country,tableName,ip,onLineTime) VALUES(?,?,?,?,?,?,?,?,?,?) ON DUPLICATE KEY UPDATE onLineTime = CONCAT(onLineTime,?)";
			pstmt = conn.prepareStatement(sql);
            int count=0;
			for (PopInfo data : datas) {
				pstmt.setString(1, data.getUuid());
				pstmt.setString(2, data.getLanguage());
				pstmt.setString(3, data.getNetType());
				pstmt.setString(4, data.getChannel());
				pstmt.setString(5, data.getIsShowAd());
				pstmt.setString(6, data.getLastShowAdDate());
				pstmt.setString(7, data.getCountry());
				pstmt.setString(8, data.getTableName());
				pstmt.setString(9, data.getIp());
				pstmt.setString(10, data.getOnLineTime());
				pstmt.setString(11, data.getOnLineTime());
				pstmt.addBatch();
                count++;
                if(count>=BATCH_SIZE){
                    pstmt.executeBatch();
                    pstmt.clearBatch();
                    count=0;
                }
			}
            if(count>0) {
                pstmt.executeBatch();
            }
		} finally {
			closeDatabaseComponent(null, pstmt, conn);
		}
	}

}
