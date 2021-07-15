package com.example.todolito;

import java.sql.Time;
import java.time.LocalDate;
import java.util.Timer;

public class ToDo {

    private String betreff;
    private String bemerkung;
    private String zusatz;
    private String date;
    private String timestart;
    private String timeend;
    private boolean ganztaegig;

    public ToDo(String betreff) {

        this.betreff = betreff;
        this.bemerkung = "";
        this.zusatz = "";
        this.date = "";
        this.timestart = "";
        this.timeend = "";
        this.ganztaegig = false;
    }

    public boolean isGanztaegig() {
        return ganztaegig;
    }

    public void setGanztaegig(boolean ganztaegig) {
        this.ganztaegig = ganztaegig;
    }

    public String getBetreff() {
        return betreff;
    }

    public void setBetreff(String betreff) {
        this.betreff = betreff;
    }

    public String getBemerkung() {
        return bemerkung;
    }

    public void setBemerkung(String bemerkung) {
        this.bemerkung = bemerkung;
    }

    public String getZusatz() {
        return zusatz;
    }

    public void setZusatz(String zusatz) {
        this.zusatz = zusatz;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTimestart() {
        return timestart;
    }

    public void setTimestart(String time) {
        this.timestart = time;
    }

    public String getTimeend() {
        return timeend;
    }

    public void setTimeend(String timeend) {
        this.timeend = timeend;
    }
}
