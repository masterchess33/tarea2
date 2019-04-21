package Paquetes;


public class Polera {
    
    private String talla;
    private String material;
    private boolean estanpado;
    private int serial;
    
    public Polera(String Talla, String Material, boolean Estanpado,int Serial){
        talla=Talla;
        material=Material;
        estanpado=Estanpado;
        serial=Serial;
    }

    public String getTalla() {
        return talla;
    }

    public String getMaterial() {
        return material;
    }

    public boolean getEstanpado() {
        return estanpado;
    }

    public int getSerial() {
        return serial;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public void setEstanpado(boolean estanpado) {
        this.estanpado = estanpado;
    }

    public void setSerial(int serial) {
        this.serial = serial;
    }
    
    
    
}
