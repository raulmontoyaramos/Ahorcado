package ahorca2;

public class Ahorca2 {

    protected String palabraSecreta;
    private char[] letrasAdivinadas;
    private int intentosRestantes;
    
    // Creo un constructor con los argumentos "palabraSecreta" e "intentosMaximos" donde hago que tenga
    // la misma cantidad de huecos en el array de letrasAdivinadas como letras tiene la palabra a adivinar,
    // asigno que, en primera instancia los intentosRestantes sean los mismos que los intentos máximos ya que todavía
    //  no se ha usado ningún intento por último construyo el array de letrasAdivinar con un "_" por cada letra por adivinar
    public Ahorca2(String palabraSecreta, int intentosMaximos) {
        this.palabraSecreta = palabraSecreta.toUpperCase();
        this.letrasAdivinadas = new char[palabraSecreta.length()];
        this.intentosRestantes = intentosMaximos;
        for (int i = 0; i < palabraSecreta.length(); i++) {
            letrasAdivinadas[i] = '_';
        }
    }
    
    //Aquí la función que se utilizará en cada intento, paso la letra que intento adivinar a UpperCase para la comparación,
    //luego voy comparando, mediante un bucle for, char a char de la palabra secreta con la letra que intento adivinar usando
    //un boolean para que si alguna letra coincide el método modificará el array letrasAdivinadas de forma que en la/s posición/es 
    //que coincidan las letras escribirá la misma y me devuelve true y en el caso contrario me devuelva false y reste un intento.
    public boolean intentar(char letra) {
        letra = Character.toUpperCase(letra);
        boolean acierto = false;
        for (int i = 0; i < palabraSecreta.length(); i++) {
            if (palabraSecreta.charAt(i) == letra) {
                letrasAdivinadas[i] = letra;
                acierto = true;
            }
        }
        if (!acierto) {
            intentosRestantes--;
        }
        return acierto;
    }

    //Con éste método compruebo si se ha ganado la partida, es decir, si se ha adivinado la palabra secreta,
    //haciendo una comparación simple con el método ".equals" entre la palabra secreta y el conjunto de letras adivinadas
    //lo único un poco más complejo es conseguir que el array de char "letrasAdivinadas" se convierta en un String para así 
    //poder hacer ésta comparación, lo he logrado usando la clase "String" combinandola con el método ".valueOf()". Si los Strings
    //son iguales se devolverá "true" y en caso contrario se devolverá "false"
    public boolean haGanado() {
        return palabraSecreta.equals(String.valueOf(letrasAdivinadas));
    }

    //Este método sirve para comprobar de forma muy simple si se ha perdido la partida comprobando que los intentos restantes
    //sean menor o igual a 0, de todas formas los intentos restantes nunca deberían ser menor que 0 (eso significaría que tengo, al
    //menos un error en mi código). Si los intentos resantes son iguales o menor a 0 se devolverá "true" y en caso contrario se 
    //devolverá "false"
    public boolean haPerdido() {
        return intentosRestantes <= 0;
    }

    //Con éste método consigo convertir en un String el array de char "letrasAdivinadas" usando la clase "String" combinandola 
    //con el método ".valueOf()" para que luego el método lo devuelva como String siendo ésta la palabra adivinada
    public String obtenerPalabraAdivinada() {
        return String.valueOf(letrasAdivinadas);
    }

    //Éste método simplemente devuelve los intentos restantes
    public int getIntentosRestantes() {
        return intentosRestantes;
    }
    
}
