# Lambdas y callbacks Kotlin

**User:** Fernando Aranzabe (faranzabe@cifpvirgendegracia.com)  
**Created:** 12/2/2025 18:35:59  
**Updated:** 12/2/2025 18:36:56  
**Exported:** 12/2/2025 18:42:36  
**Link:** [https://chatgpt.com/c/692f236b-528c-8333-958c-7e36f2ed00be](https://chatgpt.com/c/692f236b-528c-8333-958c-7e36f2ed00be)

## Prompt:
Tengo este ejemplo:
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

Me puedes hacer unos apuntes explicativos para mis alumnos sobre estos callbacks/lambda?

## Response:
¡Claro! Te puedo ayudar a crear unos apuntes claros y organizados para tus alumnos sobre **lambdas y callbacks en Kotlin** usando tu ejemplo como base. Aquí tienes una propuesta:

* * *

Apuntes: Lambdas y Callbacks en Kotlin
======================================

1\. ¿Qué es una lambda?
-----------------------

Una **lambda** en Kotlin es una **función sin nombre** que se puede usar como un **valor**. Esto significa que puedes definir una función en línea y:

*   Asignarla a una variable.
*   Pasarla como argumento a otra función.
*   Usarla directamente.

### Sintaxis básica:

```kotlin
{ argumentos -> cuerpo de la función }
```

*   `argumentos`: parámetros que recibe la lambda.
*   `cuerpo de la función`: código que se ejecuta cuando se llama la lambda.

### Ejemplo:

```kotlin
val suma = { a: Int, b: Int -> a + b }
println(suma(5, 4)) // 9
```

> Es equivalente a la función normal:

```kotlin
fun sumar(a: Int, b: Int): Int = a + b
```

* * *

2\. Lambdas con cuerpo
----------------------

Si necesitamos realizar varias operaciones dentro de la lambda, podemos usar un **bloque de código**:

```kotlin
val contarLetras = { cad: String, letra: Char ->
    var cant = 0
    for (le in cad) {
        if (le == letra) cant++
    }
    cant
}

println(contarLetras("Hola holita vecinillo",'o')) // 5
```

> También podríamos usar funciones de la librería como `count` para simplificar:

```kotlin
val contarLetras2 = { cad: String, letra: Char -> cad.count { it == letra } }
```

* * *

3\. Funciones de orden superior
-------------------------------

Una **función de orden superior** es una función que **recibe otra función como argumento** o **devuelve una función**.

### Ejemplo:

```kotlin
fun calculadora(x: Int, y: Int, miFuncion: (Int, Int) -> Int): Int {
    return miFuncion(x, y)
}
```

*   `miFuncion` es una lambda que recibe dos `Int` y devuelve un `Int`.
*   Podemos llamar a `calculadora` pasando cualquier lambda compatible:

```kotlin
val suma = { a: Int, b: Int -> a + b }
val resta = { a: Int, b: Int -> a - b }

println(calculadora(4, 10, { x, y -> suma(x, y) })) // 14
println(calculadora(4, 10) { x, y -> resta(x, y) }) // -6
```

> Nota: cuando la lambda es el **último argumento**, se puede poner **fuera de los paréntesis**.

* * *

4\. Uso de lambdas con colecciones
----------------------------------

Kotlin permite usar lambdas para operaciones muy comunes con listas y cadenas, por ejemplo:

```kotlin
val cadena = "buenos días a todas y todos"

// Contar letras
println(cadena.count { it == 'a' }) // 5

// Filtrar letras
val sinA = cadena.filter { it != 'a' }
println(sinA) // "buenos días  tod s y todos"

// Verificar si alguna letra cumple una condición
val hayB = cadena.any { it == 'b' }
println(hayB) // true
```

> `it` es un nombre **implícito** para el argumento cuando la lambda tiene **un solo parámetro**.

* * *

5\. Ventajas de usar lambdas
----------------------------

*   Permiten **programación funcional**, más concisa y legible.
*   Facilitan el uso de **callbacks** o funciones que se ejecutan más tarde.
*   Perfectas para trabajar con **colecciones** y **funciones de orden superior**.
*   Evitan la necesidad de declarar funciones temporales con nombre.

* * *

Si quieres, puedo hacer también un **diagrama visual** mostrando cómo fluye la **lambda → función de orden superior → resultado**, que suele ayudar mucho a los alumnos a entender los callbacks.

¿Quieres que haga ese diagrama?



---
Powered by [ChatGPT Exporter](https://www.chatgptexporter.com)