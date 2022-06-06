package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Employee;
import com.revature.models.Reimbursement;
import com.revature.util.ConnectionFactory;

public class ReimbursementDaoImpl implements ReimbursementDao {

	public void createReimbursement(Reimbursement r) {

		String sql = "insert into reimbursement (amount,reimbursement_type,isrequest,employee_id) values(?,?,?,?)";
		Connection connection = ConnectionFactory.getConnection();

		try (PreparedStatement ps = connection.prepareStatement(sql)) { // connection will be closed after we are done!

			ps.setInt(1, r.getAmount());
			ps.setString(2, r.getReimbursement_type());
			ps.setString(3, r.getIsRequest());
			ps.setInt(4, r.getEmployee_id());

			ps.execute(); // We use execute when we DONT expect anything back
			// ps.executeQuery(); //WE use use we DO expect something back!

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<Reimbursement> viewPastTickets(int employee_id) {
		String sql = "select * from reimbursement where employee_id = ?";
		Connection connection = ConnectionFactory.getConnection();
		List<Reimbursement> reimbursementList = new ArrayList<>();
		try (PreparedStatement ps = connection.prepareStatement(sql)) {
			ps.setInt(1, employee_id);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				        Reimbursement r = new Reimbursement(rs.getInt("reimbursement_id"),
						rs.getInt("amount"), rs.getString("reimbursement_type"), rs.getString("isrequest"),
						rs.getInt("employee_id"));
				        reimbursementList.add(r);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return reimbursementList;
	}

	@Override
	public List<Reimbursement> pendingRequest(int employee_id) {
		String sql = "select * from reimbursement where employee_id = ? and isRequest = ?";
		Connection connection = ConnectionFactory.getConnection();
		List<Reimbursement> reimbursementList = new ArrayList<>();
		try (PreparedStatement ps = connection.prepareStatement(sql)) {
			ps.setInt(1, employee_id);
			ps.setString(2,"pending");

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				        Reimbursement r = new Reimbursement(rs.getInt("reimbursement_id"),
						rs.getInt("amount"), rs.getString("reimbursement_type"), rs.getString("isrequest"),
						rs.getInt("employee_id"));
				        reimbursementList.add(r);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return reimbursementList;
	}

}
