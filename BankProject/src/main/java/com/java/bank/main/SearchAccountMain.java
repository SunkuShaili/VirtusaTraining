package com.java.bank.main;

import com.java.bank.dao.BankDao;
import com.java.bank.dao.BankDaoImpl;
import com.java.bank.model.Accounts;

import java.sql.SQLException;
import java.util.Scanner;

public class SearchAccountMain {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter Account Number");
    int accountNo = sc.nextInt();
    BankDao dao = new BankDaoImpl();
    try {
      Accounts account = dao.searchAccount(accountNo);
      if (account != null && account.getStatus().equals("active")) {
        System.out.println(account);
      } else {
        System.out.println("Account not found or your account has been disabled.......");
      }
    }catch (SQLException | ClassNotFoundException e) {
      throw new RuntimeException(e);
    }


  }
}
