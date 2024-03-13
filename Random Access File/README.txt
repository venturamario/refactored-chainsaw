-El programa compila y ejecuta correctamente, si en tu caso no es asi, debe ser porque la versión de NetBeans
con la que fue hecho el programa es la 12.0. 
Si tienes la versión 8.0 / 8.2 etc... puede ser que no llegue a ejecutarse y salgan errores. Si esto ocurre,
por favor, actualiza netbeans y comprobarás que funciona perfectamente.

-Las excepciones de tipo InsercioDadesException saltan cuando se introduce un dato incorrecto, por ejemplo,
si para dar una puntuación que debe ser del 1 al 10, el numero no esta en este rango.
Sin embargo, si es el formato del dato el que es incorrecto (poner un char cuando se esta leyendo de un int p.e)
saltará la excepción NumberFormatException nativa de Java

-La gestion de excepciones se hace en el main, por lo que los otros metodos de esta clase usan un throws.
Todas las excepciones que puedan suceder se lanzaran hasta llegar al main y será ahi donde se gestionarán

Gracias de antemano :)