package smellytrivial;

import java.util.ArrayList;
import java.util.LinkedList;

public class Game {
    ArrayList<String> jugadores = new ArrayList<>();
    int[] posiciones = new int[6];
    int[] monederos = new int[6];
    boolean[] enCasillaCastigo = new boolean[6];

    LinkedList<String> preguntasCultura = new LinkedList<>();
    LinkedList<String> preguntasCiencias = new LinkedList<>();
    LinkedList<String> preguntasDeportes = new LinkedList<>();
    LinkedList<String> preguntasMusica = new LinkedList<>();

    int jugadorActual = 0;
    boolean estaSaliendoDeLaCarcel;

    public Game() {
        for (int i = 0; i < 50; i++) {
            preguntasCultura.addLast("Pregunta de Cultura " + i);
            preguntasCiencias.addLast(("Pregunta de Ciencias " + i));
            preguntasDeportes.addLast(("Pregunta de Deportes " + i));
            preguntasMusica.addLast(crearPreguntaMusica(i));
        }
    }

    public String crearPreguntaMusica(int index) {
        return "Pregunta de Música " + index;
    }

    public boolean esJugable() {
        if (cuantosJugadores() < 2 || cuantosJugadores() > 6) {
            System.out.println("La partida no es jugable si hay menos de dos jugadores o más de seis jugadores");
            return false;
        }
        return (cuantosJugadores() >= 2);

    }


    public boolean agregar(String playerName) {


        jugadores.add(playerName);
        posiciones[cuantosJugadores() - 1] = 0;
        monederos[cuantosJugadores() - 1] = 0;
        enCasillaCastigo[cuantosJugadores() - 1] = false;

        System.out.println(playerName + " se ha unido a la partida");
        System.out.println("Es el jugador número " + jugadores.size());
        return true;
    }

    public int cuantosJugadores() {
        return jugadores.size();
    }

    public void tirarDado(int puntosDado) {
        System.out.println(jugadores.get(jugadorActual) + " es el jugador actual");
        System.out.println("Ha sacado un " + puntosDado);

        if (enCasillaCastigo[jugadorActual]) {
            if (puntosDado % 2 != 0) {
                estaSaliendoDeLaCarcel = true;

                System.out.println(jugadores.get(jugadorActual) + " sale de la casilla de castigo");
                posiciones[jugadorActual] = posiciones[jugadorActual] + puntosDado;
                if (posiciones[jugadorActual] > 11) posiciones[jugadorActual] = posiciones[jugadorActual] - 12;

                System.out.println(nuevaPosicionJugador());
                System.out.println("La categoría es " + categoriaActual());
                hacerPregunta();
            } else {
                System.out.println(jugadores.get(jugadorActual) + " no sale de la casilla de castigo");
                estaSaliendoDeLaCarcel = false;
            }

        } else {

            posiciones[jugadorActual] = posiciones[jugadorActual] + puntosDado;
            if (posiciones[jugadorActual] > 11) posiciones[jugadorActual] = posiciones[jugadorActual] - 12;

            System.out.println(nuevaPosicionJugador());
            System.out.println("La categoría es " + categoriaActual());
            hacerPregunta();
        }

    }

    private void hacerPregunta() {
        if (categoriaActual().equals("Cultura popular"))
            System.out.println(preguntasCultura.removeFirst());
        if (categoriaActual().equals("Ciencias"))
            System.out.println(preguntasCiencias.removeFirst());
        if (categoriaActual().equals("Deportes"))
            System.out.println(preguntasDeportes.removeFirst());
        if (categoriaActual().equals("Música"))
            System.out.println(preguntasMusica.removeFirst());
    }


    private String categoriaActual() {
        if (jugador_igual_a_tamaño(posiciones[jugadorActual], 0)) return "Cultura popular";
        if (jugador_igual_a_tamaño(posiciones[jugadorActual], 4)) return "Cultura popular";
        if (jugador_igual_a_tamaño(posiciones[jugadorActual], 8)) return "Cultura popular";
        if (jugador_igual_a_tamaño(posiciones[jugadorActual], 1)) return "Ciencias";
        if (jugador_igual_a_tamaño(posiciones[jugadorActual], 5)) return "Ciencias";
        if (jugador_igual_a_tamaño(posiciones[jugadorActual], 9)) return "Ciencias";
        if (jugador_igual_a_tamaño(posiciones[jugadorActual], 2)) return "Deportes";
        if (jugador_igual_a_tamaño(posiciones[jugadorActual], 6)) return "Deportes";
        if (jugador_igual_a_tamaño(posiciones[jugadorActual], 10)) return "Deportes";
        return "Música";
    }

    public boolean fueRespuestaCorrecta() {
        if (enCasillaCastigo[jugadorActual]) {
            if (estaSaliendoDeLaCarcel) {
                System.out.println("Respuesta correcta!!!!");
                monederos[jugadorActual]++;
                System.out.println(jugadores.get(jugadorActual)
                        + " ahora tiene "
                        + monederos[jugadorActual]
                        + " monedas doradas.");

                boolean ganador = jugadorHaGanado();
                siguienteJugador();
                if (jugador_igual_a_tamaño(jugadorActual, jugadores.size())) ;

                return ganador;
            } else {
                siguienteJugador();
                if (jugador_igual_a_tamaño(jugadorActual, jugadores.size())) ;
                return true;
            }


        } else {

            System.out.println("Respuesta correcta!!!!");
            monederos[jugadorActual]++;
            System.out.println(jugadores.get(jugadorActual)
                    + " ahora tiene "
                    + monederos[jugadorActual]
                    + " monedas doradas.");

            boolean ganador = jugadorHaGanado();
            siguienteJugador();
            if (jugador_igual_a_tamaño(jugadorActual, jugadores.size())) jugadorActual = 0;

            return !ganador;
        }
    }

    private boolean jugador_igual_a_tamaño(int jugadorActual, int size) {
        return jugadorActual == size;
    }

    public boolean respuestaIncorrecta() {
        System.out.println("Respuesta incorrecta");
        System.out.println(jugadores.get(jugadorActual) + " va a la casilla de castigo");
        enCasillaCastigo[jugadorActual] = true;

        siguienteJugador();
        if (jugador_igual_a_tamaño(jugadorActual, jugadores.size())) jugadorActual = 0;
        return true;
    }

    public void siguienteJugador() {
        jugadorActual++;
    }


    public boolean jugadorHaGanado() {
        if (jugador_igual_a_tamaño(monederos[jugadorActual], 6)) {
            return true;
        }
        return false;
    }

    public String nuevaPosicionJugador() {
        return "La nueva posición de "
                + jugadores.get(jugadorActual)
                + " es "
                + posiciones[jugadorActual];
    }

    public boolean estaEnLaCarcel() {
        boolean carcel = false;
        if (respuestaIncorrecta() == true) {
            carcel = true;
        }
        return carcel;
    }
}
