package Modelo;

public class connectionData {
    String password;
    String db;
    String ip;
    String schema;

    public connectionData(String password, String db, String ip, String schema) {
        this.password = password;
        this.db = db;
        this.ip = ip;
        this.schema = schema;
    }

    public connectionData() {
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDb() {
        return db;
    }

    public void setDb(String db) {
        this.db = db;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getSchema() {
        return schema;
    }

    public void setSchema(String schema) {
        this.schema = schema;
    }
    
    
}
