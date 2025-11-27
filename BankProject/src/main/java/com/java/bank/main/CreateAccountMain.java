package com.java.bank.main;

import com.java.bank.dao.BankDao;
import com.java.bank.dao.BankDaoImpl;
import com.java.bank.model.Accounts;

import java.sql.SQLException;
import java.util.Scanner;

public class CreateAccountMain {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    BankDao dao= new BankDaoImpl();
    Accounts account = new Accounts();

    System.out.println("Enter First Name:");
    account.setFirstName(sc.nextLine());
    System.out.println("Enter Last Name:");
    account.setLastName(sc.nextLine());
    System.out.println("Enter City");
    account.setCity(sc.next());
    System.out.println("Enter State");
    account.setState(sc.next());
    System.out.println("Enter Amount");
    account.setAmount(sc.nextDouble());
    System.out.println("Enter Cheque Facil (YES/NO)  ");
    account.setCheqFacil(sc.next());
    System.out.println("Enter Account Type (SAVINGS/CURRENT) ");
    account.setAccountType(sc.next());

    try {
      System.out.println(dao.createAccount(account));
    } catch (SQLException | ClassNotFoundException e) {
      throw new RuntimeException(e);
    }

  }
}
