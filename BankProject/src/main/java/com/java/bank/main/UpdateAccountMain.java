package com.java.bank.main;

import com.java.bank.dao.BankDao;
import com.java.bank.dao.BankDaoImpl;

import java.sql.SQLException;
import java.util.Scanner;

public class UpdateAccountMain {
  public static void main(String[] args) {
    int accountNo;
    String city, state;
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter Account no    ");
    accountNo = sc.nextInt();
    System.out.println("Enter AccountHolder's updated city    ");
    city = sc.next();
    System.out.println("Enter AccountHolder's updated state    ");
    state = sc.next();
    BankDao bankDao = new BankDaoImpl();
    try {
      System.out.println(bankDao.updateAccount(accountNo,city,state));
    } catch (SQLException | ClassNotFoundException e) {
      throw new RuntimeException(e);
    }
  }
}
