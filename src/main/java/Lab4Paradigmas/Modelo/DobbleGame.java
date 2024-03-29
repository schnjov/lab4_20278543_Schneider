package main.java.Lab4Paradigmas.Modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Clase que representa un juego
 */
public class DobbleGame implements Juego {
    List<Player> jugadores;
    int gameMode;
    int cantidadJugadores = 0;
    Dobble cardsSet;
    int turno = 1; //Es el ID del jugador
    List<Card> mazo;
    List<Card> area;

    /**
     * Constructor de la instancia de clase
     */
    public DobbleGame(){
        cardsSet = null;
        this.jugadores = new ArrayList<Player>();
        this.mazo = new ArrayList<>();
    }

    /**
     * Implementacion de metodo de interface
     */
    @Override
    public void registrarJugador(String nombre) {
        Player jugador = new Player(nombre);
        jugador.setID(this.cantidadJugadores+1);
        this.jugadores.add(jugador);
        this.cantidadJugadores+=1;
    }

    /**
     * Implementacion de metodo de interface
     */

    @Override
    public void cambiarTurno() {
        if (this.turno == this.cantidadJugadores)
            this.turno = 1;
        else
            this.turno+=1;
    }

    /**
     * Implementacion de metodo de interface
     */
    @Override
    public String verTurno() {
        for(Player p: this.jugadores){
            if(p.ID == this.turno)
                return p.nombre;
        }
        return "No hay un turno establecido";
    }

    /**
     * Implementacion de metodo de interface
     */
    @Override
    public void generarMazo(int cantidad){
        //Para revolver las cartas
        this.cardsSet.shufle();
        for(Card carta: this.getCardsSet().getCartas()){
            this.mazo.add(carta);
        }
        for (int i = 0; i < cantidad; i++) {
            for (int j = 0; j < this.getCantidadJugadores(); j++) {
                this.mazo.remove(0);
            }
        }
    }

    /**
     * Representa la clase en un string entendible para un usuario
     * @return la representacion de la clase
     */
    @Override
    public String toString() {
        return "DobbleGame{" +
                "jugadores=" + jugadores.toString() +
                ", cantidadJugadores=" + cantidadJugadores +
                ", cardsSet=" + cardsSet.toString() +
                ", mazo=" + mazo.toString() +
                '}';
    }


    /**
     * Verifica si una instancia es igual a otro objeto
     * @param o objeto con el que se desea comparar
     * @return true o false
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DobbleGame that = (DobbleGame) o;
        return cantidadJugadores == that.cantidadJugadores && turno == that.turno &&
                Objects.equals(jugadores, that.jugadores) && Objects.equals(cardsSet, that.cardsSet)
                && Objects.equals(mazo, that.mazo);
    }

    /**
     * ------------Getters y Setters----------------
     */
    public List<Player> getJugadores() {
        return jugadores;
    }

    public int getCantidadJugadores() {
        return cantidadJugadores;
    }

    public Dobble getCardsSet() {
        return cardsSet;
    }

    public void setCardsSet(Dobble cardsSet) {
        this.cardsSet = cardsSet;
    }

    public int getGameMode() {
        return gameMode;
    }

    public void setMazo(List<Card> mazo) {
        this.mazo = mazo;
    }

    public List<Card> getArea() {
        return area;
    }

    public void setArea(List<Card> area) {
        this.area = area;
    }

    public void setGameMode(int gameMode) {
        this.gameMode = gameMode;
    }

    public List<Card> getMazo() {
        return mazo;
    }

    public int getTurno() {
        return turno;
    }

    public void setTurno(int turno) {
        this.turno = turno;
    }
}
