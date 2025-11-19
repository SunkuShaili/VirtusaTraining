package com.java.EmployLeave.DAO;

import com.java.EmployLeave.model.EmployLeaveDetails;

import java.util.List;

public interface LeaveDAO {
    String addLeave(EmployLeaveDetails leave);
    List<EmployLeaveDetails> showLeaves();
    EmployLeaveDetails searchLeave(int leaveId);
    String updateLeave(EmployLeaveDetails leave);
    String deleteLeave(int leaveId);
}
