package com.java.EmployLeave.DAO;

import com.java.EmployLeave.model.EmployLeaveDetails;

import java.util.ArrayList;
import java.util.List;

public class LeaveDAOImpl implements LeaveDAO {

    static List<EmployLeaveDetails> leaveList = new ArrayList<>();

    @Override
    public String addLeave(EmployLeaveDetails leave) {
        leaveList.add(leave);
        return "successfully added leave...";

    }

    @Override
    public List<EmployLeaveDetails> showLeaves() {
        return leaveList;
    }

    @Override
    public EmployLeaveDetails searchLeave(int leaveId) {
        return leaveList.stream()
                .filter(x->x.getLeaveId()==leaveId).findFirst().orElse(null);
    }

    @Override
    public String updateLeave(EmployLeaveDetails leave) {
        EmployLeaveDetails found = searchLeave(leave.getLeaveId());
        if (found != null) {

            found.setEmpId(leave.getEmpId());
            found.setLeaveStartDate(leave.getLeaveStartDate());
            found.setLeaveEndDate(leave.getLeaveEndDate());
            found.setNoOfDays(leave.getNoOfDays());
            found.setAppliedOn(leave.getAppliedOn());
            found.setLeaveReason(leave.getLeaveReason());

            return "Leave Record is Updated Successfully...";
        }
        return "Leave Record Not Found...";
    }

    @Override
    public String deleteLeave(int leaveId) {
            EmployLeaveDetails eld = searchLeave(leaveId);
            if (eld != null) {
                leaveList.remove(eld);
                return "Leave Record Deleted";
            }
            return "Leave Record Not Found";
    }
}
