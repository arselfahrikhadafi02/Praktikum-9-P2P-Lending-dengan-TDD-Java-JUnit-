package com.p2p.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.math.BigDecimal;
import com.p2p.domain.*;

public class LoanServiceTest {
@Test
void shouldRejectLoanWhenBorrowerNotVerified() {
//=====================================================
// SCENARIO:
// Borrower tidak terverifikasi (KYC = false)
// Ketika borrower mengajukan pinjaman
// Maka sistem harus menolak dengan melempar exception
// =====================================================
// =========================
// Arrange (Initial Condition)
// =========================
// Borrower belum lolos proses KYC
Borrower borrower = new Borrower(false, 700);
// Service untuk pengajuan loan
LoanService loanService = new LoanService();

// Jumlah pinjaman valid
BigDecimal amount = BigDecimal.valueOf(1000);
BigDecimal invalidamount = BigDecimal.valueOf(-1);
// =========================
// Act (Action)
// =========================
// Borrower mencoba mengajukan loan
// =========================
// Assert (Expected Result)
// =========================
    assertThrows(IllegalArgumentException.class, () -> {
    loanService.createLoan(borrower, invalidamount);
    });
    }

    @Test
    void shouldApproveLoanWhenCreditScoreHigh(){
    Borrower borrower = new Borrower(true, 700);
    LoanService loanService = new LoanService();
    BigDecimal validamount = BigDecimal.valueOf(1000);

    Loan loan = loanService.createLoan(borrower, validamount);
    assertEquals(Loan.Status.APPROVED, loan.getStatus());
    }

    @Test
    void shouldRejectLoanWhenCreditScoreLow(){
        Borrower borrower = new Borrower(true, 500);
        LoanService loanService = new LoanService();
        BigDecimal valiamount = BigDecimal.valueOf(1000);

        Loan loan = loanService.createLoan(borrower, valiamount);
        assertEquals(Loan.Status.REJECTED, loan.getStatus());
    }
}