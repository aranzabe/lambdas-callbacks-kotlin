
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
s://www.chatgptexporter.com)