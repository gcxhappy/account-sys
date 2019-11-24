package com.accaetc.gcx.account.domain;


import java.math.BigDecimal;
import java.time.LocalDate;

public class AccountRecord {
    private AccountType accountType;
    private String contentType;
    private String Note;
    private BigDecimal Amount;
    private LocalDate RecordingTime;


    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getNote() {
        return Note;
    }

    public void setNote(String note) {
        Note = note;
    }

    public BigDecimal getAmount() {
        return Amount;
    }

    public void setAmount(BigDecimal amount) {
        Amount = amount;
    }

    public LocalDate getRecordingTime() {
        return RecordingTime;
    }

    public void setRecordingTime(LocalDate recordingTime) {
        RecordingTime = recordingTime;
    }

    @Override
    public String toString() {
        return "AccountRecord{" +
                ", accountType=" + accountType +
                ", contentType='" + contentType + '\'' +
                ", Note='" + Note + '\'' +
                ", Amount=" + Amount +
                ", RecordingTime=" + RecordingTime +
                '}';
    }
}
