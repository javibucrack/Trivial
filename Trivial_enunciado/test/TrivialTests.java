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



}