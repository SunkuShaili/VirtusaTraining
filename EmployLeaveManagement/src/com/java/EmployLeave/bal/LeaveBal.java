package com.java.EmployLeave.bal;

import com.java.EmployLeave.DAO.LeaveDAO;
import com.java.EmployLeave.DAO.LeaveDAOImpl;
import com.java.EmployLeave.exception.EmployException;
import com.java.EmployLeave.model.EmployLeaveDetails;

import java.util.Date;
import java.util.List;

public class LeaveBal {

    static StringBuilder sb;
    static LeaveDAO dao;
    static{
        sb = new StringBuilder();
        dao = new LeaveDAOImpl();

    }
    //static LeaveDAO dao = new LeaveDAOImpl();

    public List<EmployLeaveDetails> showLeaves() {
        return dao.showLeaves();
    }


    public String addLeave(EmployLeaveDetails leave) throws EmployException {

        if (validateLeave(leave) == true) {

            calculateNoOfDays(leave);
            leave.setAppliedOn(new Date());

            return dao.addLeave(leave);
        }
        throw new EmployException(sb.toString());
    }

    public String updateLeaveBal(EmployLeaveDetails leave) throws EmployException {

        if (validateLeave(leave) == true) {

            calculateNoOfDays(leave);
            leave.setAppliedOn(new Date());

            return dao.updateLeave(leave);
        }
        throw new EmployException(sb.toString());
    }

    public EmployLeaveDetails searchLeaveBal(int leaveId) {
        return dao.searchLeave(leaveId);
    }

    public String deleteLeaveBal(int leaveId) {
        return dao.deleteLeave(leaveId);
    }

    // ---------------- Leave Validation Code -------------------

    public boolean validateLeave(EmployLeaveDetails leave) {
        boolean isValid = true;
        sb = new StringBuilder();

        Date today = new Date();

        if (leave.getLeaveStartDate().before(today)) {
            sb.append("Leave Start Date cannot be yesterday or past...\n");
            isValid = false;
        }

        if (leave.getLeaveEndDate().before(today)) {
            sb.append("Leave End Date cannot be yesterday or past...\n");
            isValid = false;
        }

        if (leave.getLeaveStartDate().after(leave.getLeaveEndDate())) {
            sb.append("Leave Start Date cannot be > End Date...\n");
            isValid = false;
        }

        if (leave.getLeaveReason().length() < 3) {
            sb.append("Leave Reason must be at least 3 chars...\n");
            isValid = false;
        }

        return isValid;
    }

    // --------------- Calculation of Days------------------------

    private void calculateNoOfDays(EmployLeaveDetails leave) {
        long diff = leave.getLeaveEndDate().getTime() - leave.getLeaveStartDate().getTime();
        int days = (int) (diff / (1000 * 60 * 60 * 24)) + 1;
        leave.setNoOfDays(days);
    }

}
