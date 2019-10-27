package cn.kgc.ZuoYe;

import java.sql.Date;

public class Emp {
    private int eid;
    private String ename;
    private String esex;
    private java.sql.Date estartime;
    private double epay;
    private int did;

    public Emp() {
    }

    public Emp(int eid, String ename, String esex, java.sql.Date estartime, double epay, int did) {
        this.eid = eid;
        this.ename = ename;
        this.esex = esex;
        this.estartime = estartime;
        this.epay = epay;
        this.did = did;
    }

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getEsex() {
        return esex;
    }

    public void setEsex(String esex) {
        this.esex = esex;
    }

    public Date getEstartime() {
        return estartime;
    }

    public void setEstartime(java.sql.Date estartime) {
        this.estartime = estartime;
    }

    public double getEpay() {
        return epay;
    }

    public void setEpay(double epay) {
        this.epay = epay;
    }

    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "eid=" + eid +
                ", ename='" + ename + '\'' +
                ", esex='" + esex + '\'' +
                ", estartime=" + estartime +
                ", epay=" + epay +
                ", did=" + did +
                '}';
    }
}
