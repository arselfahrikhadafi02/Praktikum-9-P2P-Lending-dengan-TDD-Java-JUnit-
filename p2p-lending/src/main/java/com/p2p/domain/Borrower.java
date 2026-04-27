package com.p2p.domain;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Borrower {
    private static final Logger logger = LoggerFactory.getLogger(Borrower.class);

// Status verifikasi KYC
private boolean verified;

// Nilai credit score borrower
private int creditScore;

// Constructor untuk inisialisasi data borrower
public Borrower(boolean verified, int creditScore) {
this.verified = verified;
this.creditScore = creditScore;
}

// Getter untuk mengecek apakah borrower sudah verified
public boolean isVerified() {
return verified;
}

// Getter untuk mengambil credit score
public int getCreditScore() {
return creditScore;
}
// =========================
// DOMAIN BEHAVIOR (NEW)
// =========================
public boolean canApplyLoan() {
    logger.debug("Mengecek apakah borrower dapat mengajukan pinjaman. Verified: {}", verified);
    return verified;
}

}
// Class ini merepresentasikan pinjaman
