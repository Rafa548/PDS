package Ex3;

public class Main {

    public static void main(String[] args) {
        Satellite satellite = new Satellite("Hispasat");
        User emissora = new Emissora(satellite, "Emissora");
        User espectador1 = new Espectador(satellite, "Espectador 1");
        User espectador2 = new Espectador(satellite, "Espectador 2");
        User espectador3 = new Espectador(satellite, "Espectador 3");
        satellite.addUser(emissora);
        satellite.addUser(espectador1);
        satellite.addUser(espectador2);
        satellite.addUser(espectador3);
        emissora.send("Hello World!");
    }
    
}
