package edu.upc.dsa.util;

public class QueryHelper {

    public static String createQueryINSERT(Object entity) {

        StringBuffer sb = new StringBuffer("INSERT INTO ");
        sb.append(entity.getClass().getSimpleName()).append(" ");
        sb.append("(");

        String[] fields = ObjectHelper.getFields(entity);

        sb.append("ID");
        for (String field : fields) {
            sb.append(", ").append(field);
        }

        sb.append(") VALUES (?");

        for (String field : fields) {
            sb.append(", ?");
        }

        sb.append(")");

        return sb.toString();
    }

    public static String createQueryINSERTOBJ(Object entity) {    //INSERT PARA AÑADIR ID USER E D OBJETO ACABAR

        StringBuffer sb = new StringBuffer("INSERT INTO ");
        sb.append(entity.getClass().getSimpleName()).append(" ");
        sb.append("(");

        String[] fields = ObjectHelper.getFields(entity);

        sb.append("idUser");
        sb.append(", ").append("idObject");

        sb.append(") VALUES (?");
        sb.append(", ?");
        sb.append(")");

        return sb.toString();
    }

    public static String createQueryUPDATE(Object entity) {
        StringBuffer sb = new StringBuffer();
        sb.append("UPDATE ").append(entity.getClass().getSimpleName()).append(" ").append("SET");

        String [] fields = ObjectHelper.getFields(entity);

        for(String field: fields){
            sb.append(" ").append(field);
            sb.append(" = ?,");      // recorre todos los parametros de en este caso clase employee
        }
        sb.delete(sb.length() -1, sb.length());   // borra la coma final de sb.append(" = ?,")

        sb.append(" WHERE ID = ?");

        return sb.toString();
    }
    public static String createQueryDELETE(Object entity) {
        StringBuffer sb = new StringBuffer();
        sb.append("DELETE FROM ").append(entity.getClass().getSimpleName());
        sb.append(" WHERE ID = ?");

        return sb.toString();
    }
    public static String createQuerySELECT(Class theClass) {    //obtiene datos de un objeto el cual le pasamos su ID
        StringBuffer sb = new StringBuffer();
        sb.append("SELECT * FROM ").append(theClass.getSimpleName());
        sb.append(" WHERE ID = ?");
        return sb.toString();
    }
    public static String createQuerySELECTIDuserRelacion(Class theClass) {    //obtiene datos de los objetos de un user a partir de su id
        StringBuffer sb = new StringBuffer();
        sb.append("SELECT * FROM ").append(theClass.getSimpleName());
        sb.append(" WHERE idUser = ?");
        return sb.toString();
    }

    public static String createQuerySELECTall(Class theClass) {   //obtiene todos los datos de una tabla
        StringBuffer sb = new StringBuffer();                     //sirve para public List<Object> findAll(Class theClass)
        sb.append("SELECT * FROM ").append(theClass.getSimpleName());
        return sb.toString();
    }
    public static String createQuerySELECTUser(Class theClass) {  //obtien todos los datos de la tabla con el nickname que le doy
        StringBuffer sb = new StringBuffer();
        sb.append("SELECT * FROM ").append(theClass.getSimpleName());
        sb.append(" WHERE username = ?");
        return sb.toString();
    }
    public static String createQuerySELECTIDverify(Class theClass) {
        StringBuffer sb = new StringBuffer();
        sb.append("SELECT * FROM ").append(theClass.getSimpleName());
        sb.append(" WHERE username = ?").append(" ").append("AND password = ?");
        return sb.toString();
    }
    public static String createQuerySELECTID(Class theClass) {
        StringBuffer sb = new StringBuffer();
        sb.append("SELECT * FROM ").append(theClass.getSimpleName());
        sb.append(" WHERE username = ?");

        return sb.toString();
    }
    public static String createQuerySELECTIDOBJETO(Class theClass) {
        StringBuffer sb = new StringBuffer();
        sb.append("SELECT * FROM ").append(theClass.getSimpleName());
        sb.append(" WHERE nombre = ?");

        return sb.toString();
    }
}
