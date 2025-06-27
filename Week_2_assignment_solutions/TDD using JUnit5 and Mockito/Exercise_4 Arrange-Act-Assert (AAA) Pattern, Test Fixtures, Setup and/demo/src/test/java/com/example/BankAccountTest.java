package com.example;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    BankAccount account;

    @BeforeEach
    void setUp() {
        // Arrange: Initialize a fresh account before each test
        account = new BankAccount(100.0);
        System.out.println(">> Setup done");
    }

    @AfterEach
    void tearDown() {
        System.out.println(">> Test finished\n");
    }

    @Test
    void testDeposit() {
        // Act
        account.deposit(50.0);

        // Assert
        assertEquals(150.0, account.getBalance(), "Balance should be 150 after deposit");
    }

    @Test
    void testWithdraw() {
        // Act
        account.withdraw(30.0);

        // Assert
        assertEquals(70.0, account.getBalance(), "Balance should be 70 after withdrawal");
    }

    @Test
    void testWithdrawMoreThanBalance() {
        // Act
        account.withdraw(200.0);

        // Assert
        assertEquals(100.0, account.getBalance(), "Balance should remain unchanged");
    }
}
