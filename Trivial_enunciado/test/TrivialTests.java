import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import smellytrivial.Game;

public class TrivialTests {

    @Test
    public void crear_Game() {
        Game trivial = new Game();
    }

    @Test
    public void si_al_principio_saco_un_1_voy_a_la_casilla_1() {
        Game sut = new Game();
        sut.agregar("María");
        sut.agregar("Juan");

        sut.tirarDado(1);

        String expected = "La nueva posición de María es 1";

        String actual = sut.nuevaPosicionJugador();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void siempre_hay_2_jugadores_minimo() {
        Game game = new Game();
        game.agregar("María");
        game.agregar("Juan");

        int expected = 2;

        int actual = game.cuantosJugadores();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void hay_como_maximo_6_juagdores() {
        Game game = new Game();

        game.agregar("Juan");
        game.agregar("Maria");
        game.agregar("Antonio");
        game.agregar("Javier");
        game.agregar("Pepe");
        game.agregar("Pepa");

        int expected = 6;

        int actual = game.cuantosJugadores();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void la_partida_es_jugable() {
        Game game = new Game();
        game.agregar("Juan");
        game.agregar("Maria");

        boolean actual = game.esJugable();

        Assertions.assertTrue(actual);
    }

    @Test
    public void la_partida_no_es_jugable() {
        Game game = new Game();
        game.agregar("Juan");

        boolean actual = game.esJugable();

        Assertions.assertFalse(actual);
    }

    @Test
    public void pasar_al_siguiente_jugador() {
        Game game = new Game();
        game.agregar("Juan");
        game.agregar("Maria");

        game.siguienteJugador();

        String expected = "La nueva posición de Maria es 0";

        // Esto es porque si no usases el game.siguienteJugador() saldría la posición de Juan en lugar de la de Maria

        Assertions.assertEquals(expected, game.nuevaPosicionJugador());
    }

    @Test
    public void respuesta_correcta() {
        Game game = new Game();
        game.agregar("Juan");
        game.agregar("Maria");

        boolean respuesta = game.fueRespuestaCorrecta();

        Assertions.assertTrue(respuesta);
    }


    @Test
    public void si_alguien_tiene_6_monedas_ha_ganado() {
        Game game = new Game();

        game.agregar("Juan");
        game.fueRespuestaCorrecta();
        game.fueRespuestaCorrecta();
        game.fueRespuestaCorrecta();
        game.fueRespuestaCorrecta();
        game.fueRespuestaCorrecta();
        game.fueRespuestaCorrecta();
        game.agregar("Maria");

        boolean ganador = game.jugadorHaGanado();

        Assertions.assertTrue(ganador);
    }

    @Test
    public void si_alguien_no_tiene_6_monedas_no_ha_ganado() {
        Game game = new Game();

        game.agregar("Juan");
        game.fueRespuestaCorrecta();
        game.fueRespuestaCorrecta();
        game.fueRespuestaCorrecta();

        game.agregar("Maria");
        game.fueRespuestaCorrecta();
        game.fueRespuestaCorrecta();

        boolean ganador = game.jugadorHaGanado();

        Assertions.assertFalse(ganador);
    }

    @Test
    public void esta_en_la_carcel() {
        Game game = new Game();
        game.agregar("Juan");
        game.agregar("Maria");

        game.respuestaIncorrecta();

        boolean actual = game.estaEnLaCarcel();

        Assertions.assertTrue(actual);
    }

}