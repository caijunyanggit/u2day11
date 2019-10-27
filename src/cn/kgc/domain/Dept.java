package cn.kgc.domain;

public class Dept {
    private int did;
    private String dname;
    private String dtel;

    public Dept() {
    }

    public Dept(int did, String dname, String dtel) {
        this.did = did;
        this.dname = dname;
        this.dtel = dtel;
    }

    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getDtel() {
        return dtel;
    }

    public void setDtel(String dtel) {
        this.dtel = dtel;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "dname='" + dname + '\'' +
                ", dtel='" + dtel + '\'' +
                '}';
    }
}
