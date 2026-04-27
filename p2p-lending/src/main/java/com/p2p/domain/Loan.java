package com.p2p.domain;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Loan {
    private static final Logger logger = LoggerFactory.getLogger(Loan.class);
    // Enum untuk status loan
    public enum Status {
        PENDING, APPROVED, REJECTED
    }

    private Status status;

    // Saat loan dibuat, status awal adalah PENDING
    public Loan() {
        this.status = Status.PENDING;
    }

    // Setter untuk mengubah status loan
    public void setStatus(Status status) {
        this.status = status;
    }

    // Getter untuk membaca status loan
    public Status getStatus() {
        return status;
    }
    // =========================
    // DOMAIN BEHAVIOR
    // =========================
    public void approve() {
        logger.info("Loan disetujui");
        this.status = Status.APPROVED;
    }
    public void reject() {
        logger.warn("Loan ditolak");
        this.status = Status.REJECTED;
    }
}
