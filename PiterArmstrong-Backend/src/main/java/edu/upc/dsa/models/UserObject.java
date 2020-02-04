package edu.upc.dsa.models;

public class UserObject {   //relaciona los usuarios con los objetos

    int iduser;
    int idobject;

    public UserObject(int iduser, int idobject) {

        this.iduser = iduser;
        this.idobject = idobject;
    }

    public UserObject() {
    }

    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    public int getIdobject() {
        return idobject;
    }

    public void setIdobject(int idobject) {
        this.idobject = idobject;
    }
}
