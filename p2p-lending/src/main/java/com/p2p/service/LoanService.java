package com.p2p.service;
import com.p2p.domain.*;
import java.math.BigDecimal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoanService {
    private static final Logger logger = LoggerFactory.getLogger(LoanService.class);
    public Loan createLoan(Borrower borrower, BigDecimal amount) {
            logger.info("Starting loan creation for borrower with credit score: {}", borrower.getCreditScore());
            validateBorrower(borrower);
            Loan loan = new Loan();
            if (borrower.getCreditScore() >= 600) {
                logger.info("Pinjaman disetujui untuk borrower dengan credit score: {}", borrower.getCreditScore());
                loan.approve();
                } else {
                logger.warn("Pinjaman ditolak untuk borrower dengan credit score: {}", borrower.getCreditScore());
                loan.reject();
            }
            logger.debug("Pinjaman telah selesai dengan status: {}", loan.getStatus());
        return loan;
        }

        private void validateBorrower(Borrower borrower) {
            logger.debug("Validasi borrower");
            if (!borrower.canApplyLoan()) {
            logger.error("Borrower validasi kesalahan: Borrower tidak terverifikasi");
            throw new IllegalArgumentException("Borrower tidak terverifikasi");
            }
            logger.debug("Borrower lolos validasi");
        }
}