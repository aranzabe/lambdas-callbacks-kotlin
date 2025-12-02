fun main(args: Array<String>) {
    /*
    Las funciones lambda en Kotlin son funciones sin nombre que pueden ser utilizadas como valores.
    Esto significa que puedes definir una función en línea, sin asignarle un nombre y pasarla como argumento a otra función o u
    tilizarla directamente. La sintaxis para definir una función lambda es la siguiente:

    { argumentos -> cuerpo de la función }

    Donde los argumentos son los parámetros que recibe la función lambda y el cuerpo de la función es la expresión que se ejecuta
    cuando se llama la función.
     */
    fun sumar(a:Int, b:Int):Int =  a + b
    //Reescrita como lambda.
    val suma = { a: Int, b: Int -> a + b }
    val resta = { a: Int, b: Int -> a - b}
    println(suma(5,4))
    println(sumar(5,6))

    //Funciones Lambda con cuerpo.
    val funCuerpo = {cad: String, letra:Char ->
        var cant = 0
        //cant = cad.count { it == letra }
        for (le in cad){
            if (le == letra){
                cant++
            }
        }
        cant
    }
    println(funCuerpo("Hola holita vecinillo",'o'))

    /*
    Tratar a la funciones como pequeñas piezas de código con lambdas, te permite la flexibilidad de pasar funciones como
    argumentos de otras funciones (funciones de orden superior).
     */
    // Declaración de función de orden superior
    fun calculadora(x: Int, y: Int, miFuncion: (Int, Int) -> Int): Int {
        return miFuncion(x, y)
    }
    var x = 4
    var y = 10
    //Llamadas a las funciones de orden superior.
    println("La suma de $x y $y es: ${calculadora(x, y, {x:Int, y:Int -> suma(x,y)})}")
    println("La resta de $x y $y es: ${calculadora(x, y) { x: Int, y: Int -> resta(x,y) }}")

    //Ejemplos de uso.
    var cadena = "buenos días a todas y todos"
    println(cadena.count{letra : Char ->
        letra == 'a'
    })
    //Con el argumento 'it'
    println(cadena.count{
        it == 'a'
    })

    val cadFil = cadena.filter { it != 'a' }
    println(cadFil)

    val algunaLetrab = cadena.any { it == 'b' }
    println(algunaLetrab)


}