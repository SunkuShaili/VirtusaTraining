package com.java.EmployLeave.main;

import com.java.EmployLeave.bal.LeaveBal;
import com.java.EmployLeave.exception.EmployException;
import com.java.EmployLeave.model.EmployLeaveDetails;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

public class LeaveMain {

    static LeaveBal leaveBal;
    static SimpleDateFormat sdf;

    static {
        leaveBal = new LeaveBal();
        sdf = new SimpleDateFormat("yyyy-MM-dd");
    }

    public static void searchLeaveMain() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Leave ID: ");
        int leaveId = sc.nextInt();
        EmployLeaveDetails leave = leaveBal.searchLeaveBal(leaveId);

        if (leave != null) {
            System.out.println(leave);
        } else {
            System.out.println("Leave Record Not Found...");
        }
    }

    public static void deleteLeaveMain() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Leave ID to Delete: ");
        int leaveId = sc.nextInt();
        System.out.println(leaveBal.deleteLeaveBal(leaveId));
    }

    public static void showLeaveMain() {
        List<EmployLeaveDetails> leaveList = leaveBal.showLeaves();
        leaveList.forEach(x -> System.out.println(x));
    }

    public static void addLeaveMain() throws EmployException {
        try {
            Scanner sc = new Scanner(System.in);
            EmployLeaveDetails leave = new EmployLeaveDetails();

            System.out.println("Enter Leave ID: ");
            leave.setLeaveId(sc.nextInt());

            System.out.println("Enter Employee ID: ");
            leave.setEmpId(sc.nextInt());

            sc.nextLine(); // consume leftover newline

            System.out.println("Enter Leave Start Date (yyyy-MM-dd): ");
            leave.setLeaveStartDate(sdf.parse(sc.nextLine()));

            System.out.println("Enter Leave End Date (yyyy-MM-dd): ");
            leave.setLeaveEndDate(sdf.parse(sc.nextLine()));

            System.out.println("Enter Leave Reason: ");
            leave.setLeaveReason(sc.nextLine());

            System.out.println(leaveBal.addLeave(leave));
        } catch (ParseException e) {
            System.err.println("Invalid date format. Please use yyyy-MM-dd");
        }
    }

    public static void updateLeaveMain() throws EmployException {
        try {
            Scanner sc = new Scanner(System.in);
            EmployLeaveDetails leave = new EmployLeaveDetails();

            System.out.println("Enter Leave ID to Update: ");
            leave.setLeaveId(sc.nextInt());

            System.out.println("Enter Employee ID: ");
            leave.setEmpId(sc.nextInt());

            sc.nextLine(); // consume leftover newline

            System.out.println("Enter New Start Date (yyyy-MM-dd): ");
            leave.setLeaveStartDate(sdf.parse(sc.nextLine()));

            System.out.println("Enter New End Date (yyyy-MM-dd): ");
            leave.setLeaveEndDate(sdf.parse(sc.nextLine()));

            System.out.println("Enter New Leave Reason: ");
            leave.setLeaveReason(sc.nextLine());

            System.out.println(leaveBal.updateLeaveBal(leave));
        } catch (ParseException e) {
            System.err.println("Invalid date format. Please use yyyy-MM-dd");
        }
    }

    public static void main(String[] args) {
        int choice;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("\n Choose an option to execute");
            System.out.println("1. Add Leave");
            System.out.println("2. Show Leaves");
            System.out.println("3. Search Leave");
            System.out.println("4. Delete Leave");
            System.out.println("5. Update Leave");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    try {
                        addLeaveMain();
                    } catch (EmployException e) {
                        System.err.println(e.getMessage());
                    }
                    break;

                case 2:
                    showLeaveMain();
                    break;

                case 3:
                    searchLeaveMain();
                    break;

                case 4:
                    deleteLeaveMain();
                    break;

                case 5:
                    try {
                        updateLeaveMain();
                    } catch (EmployException e) {
                        System.err.println(e.getMessage());
                    }
                    break;

                case 6:
                    System.exit(0);
            }

        } while (choice != 6);
    }

}
