# Trivial

## Problema 0

Extraemos el código que estaba duplicado a un nuevo método único ("nuevaPosicionJugador"), al que llamamos desde ambos.
sitios.

Creamos el test unitario "si_al_principio_saco_un_1_voy_a_la_casilla_1".

## Problema 1
Editamos el código del método esJugable() para que cuando haya menos de dos jugadores en la partida, nos avise de que no puede ser jugable.

Creamos un test siempre_hay_2_jugadores_minimo() (para comprobar que se detecta bien el número de jugadores que hay).
Otro test la_partida_es_jugable() (para saber si hay más de dos jugadpres y por lo tanto la partida es jugable). Y el test la_partida_no_es_jugable()(para saber si hay menos de dos jugadores y por lo tanto la partida no es jugable).

## Problema 2
Editamos el método de agregar para que funcione bien a la hora de detectar los seis jugadores de la partida que habrá como máximo.

Creamos el test hay_como_maximo_6_juagdores() para comprobar que efectivamente si añadimos 6 jugadores a la partida ya es jugabley no salta el error.

## Problema 4
Editamos el método que detecta cuando un jugador ha ganado y también el que detecta cuando una respuesta ha sido respondida correctamente y por lo tanto nos otorgará una moneda dorada.

Creamos el test de si_alguien_tiene_6_monedas_ha_ganado() y el de si_alguien_no_tiene_6_monedas_no_ha_ganado() para comprobar que efectivamente las personas ganan al acumular la cantidad de monedas justas (6), o no ganan si no las tienen

## Problema 5
Editamos el método jugadorActual++ que estaba repetido en varios sitios, y lo extraemos a un nuevo método llamado siguienteJugador++ el cual devuelve el jugadorActual++.

Creamos un test pasar_al_siguiente_jugador() para comprobar que al usar ese método extraído, sigue funcionando perfectamente el hecho de pasar al siguiente jugador.

## Problema 6
Editamos el método fueRespuestaCorrecta extrayendo el código duplicado, en mi caso, la condicional que decía que el jugador actual es igual al tamaño de jugadores.

Creamos un test respuesta_correcta() para comprobar que extrayendo ese código duplicado sigue funcionando perfectamente el método de fueRespuestaCorrecta().