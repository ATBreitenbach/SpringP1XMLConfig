package disburse.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;

import disburse.vo.HouseDisburseDetail;



public class JdbcHouseDisburseDAO {
	private DataSource dataSource; 
	
	public JdbcHouseDisburseDAO(DataSource dataSource) {
		this.dataSource = dataSource;
	}


	
	public List<HouseDisburseDetail> selectQuery(String bioGuideID) {
	
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<HouseDisburseDetail> hddList = new ArrayList<HouseDisburseDetail>();

		try {
			conn = dataSource.getConnection();
			ps = conn.prepareStatement("SELECT * from T_2013Q4_HOUSE_DISBURSE where BIOGUIDE_ID = ?");
			ps.setString(1, bioGuideID);
			rs = ps.executeQuery();

			while (rs.next()) {
				HouseDisburseDetail hdd = new HouseDisburseDetail();
				hdd.setBIOGUIDE_ID(rs.getString("BIOGUIDE_ID"));
				hdd.setCATEGORY(rs.getString("CATEGORY"));
				hdd.setSTART_DATE(rs.getString("START_DATE"));
				hdd.setEND_DATE(rs.getString("END_DATE"));
				hdd.setOFFICE(rs.getString("OFFICE"));
				hdd.setPURPOSE(rs.getString("PURPOSE"));
				hdd.setPAYEE(rs.getString("PAYEE"));
				hdd.setAMOUNT(Double.parseDouble(rs.getString("AMOUNT")));
				hdd.setYEAR(rs.getString("YEAR"));
				hddList.add(hdd);
			}
			if (hddList.isEmpty()) {
				// no rows returned - throw an empty result exception
				throw new EmptyResultDataAccessException(1);
			}

		} catch (SQLException sqle) {
			throw new RuntimeException("SQL exception occurred while selecting House Disburse Detail - ", sqle);
		} finally {
			if (rs != null) {
				try {
					// Close to prevent database cursor exhaustion
					rs.close();
				} catch (Exception e) {

				}
			}
			if (conn != null) {
				try {
					// Close to prevent database connection exhaustion
					conn.close();
				} catch (SQLException ex) {
				}
			}
		}
		return hddList;
	}
	public double getTotalAmountSpent() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		double totalAmount = 0;

		try {
			conn = dataSource.getConnection();
			ps = conn.prepareStatement("SELECT SUM(AMOUNT) from T_2013Q4_HOUSE_DISBURSE");
			rs = ps.executeQuery();
			
			while (rs.next()) {
				totalAmount = rs.getDouble(1);
			}
		} catch (SQLException sqle) {
			throw new RuntimeException("SQL exception occurred while selecting House Disburse Detail - ", sqle);
		} finally {
			if (rs != null) {
				try {
					// Close to prevent database cursor exhaustion
					rs.close();
				} catch (Exception e) {

				}
			}
			if (conn != null) {
				try {
					// Close to prevent database connection exhaustion
					conn.close();
				} catch (SQLException ex) {
				}
			}
		}
		return totalAmount;
	}
	
	public Map<String, Double> getTotalAmountSpentByBIOGUIDE_ID() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Map<String, Double> totalAmountSpentByID = new HashMap<String, Double>();

		try {
			conn = dataSource.getConnection();
			ps = conn.prepareStatement("SELECT BIOGUIDE_ID, SUM(AMOUNT) from T_2013Q4_HOUSE_DISBURSE GROUP BY BIOGUIDE_ID");
			rs = ps.executeQuery();
			
			while (rs.next()) {
				totalAmountSpentByID.put(rs.getString(1), rs.getDouble(2));
			}
		} catch (SQLException sqle) {
			throw new RuntimeException("SQL exception occurred while selecting House Disburse Detail - ", sqle);
		} finally {
			if (rs != null) {
				try {
					// Close to prevent database cursor exhaustion
					rs.close();
				} catch (Exception e) {

				}
			}
			if (conn != null) {
				try {
					// Close to prevent database connection exhaustion
					conn.close();
				} catch (SQLException ex) {
				}
			}
		}
		return totalAmountSpentByID;
	}
	public int getTotalRecords() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int totalRowCount = 0;

		try {
			conn = dataSource.getConnection();
			ps = conn.prepareStatement("SELECT COUNT(*) from T_2013Q4_HOUSE_DISBURSE");
			rs = ps.executeQuery();
			
			while (rs.next()) {
				totalRowCount = rs.getInt(1);
			}
		} catch (SQLException sqle) {
			throw new RuntimeException("SQL exception occurred while selecting House Disburse Detail - ", sqle);
		} finally {
			if (rs != null) {
				try {
					// Close to prevent database cursor exhaustion
					rs.close();
				} catch (Exception e) {

				}
			}
			if (conn != null) {
				try {
					// Close to prevent database connection exhaustion
					conn.close();
				} catch (SQLException ex) {
				}
			}
		}
		return totalRowCount;
	}
	public int deleteRecordsByBIOGUIDEID(String bioGuideID) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int totalRecordsDeleted = 0;

		try {
			conn = dataSource.getConnection();
			ps = conn.prepareStatement("DELETE from T_2013Q4_HOUSE_DISBURSE WHERE BIOGUIDE_ID = ?");
			ps.setString(1, bioGuideID);
			totalRecordsDeleted = ps.executeUpdate();
			
		} catch (SQLException sqle) {
			throw new RuntimeException("SQL exception occurred while selecting House Disburse Detail - ", sqle);
		} finally {
			if (rs != null) {
				try {
					// Close to prevent database cursor exhaustion
					rs.close();
				} catch (Exception e) {

				}
			}
			if (conn != null) {
				try {
					// Close to prevent database connection exhaustion
					conn.close();
				} catch (SQLException ex) {
				}
			}
		}
		return totalRecordsDeleted;
	}
}

