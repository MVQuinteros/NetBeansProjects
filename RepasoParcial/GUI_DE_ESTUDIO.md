# CHULETA / GUÍA DE ESTUDIO — Vectores y Matrices (Parcial)

Todo junto para repasar. Se complementa con el proyecto `RepasoParcial`
(donde está cada ejercicio hecho).

---

## 1. Vector (array de 1 dimensión)

Es una **lista** de datos del mismo tipo. Cada elemento tiene un **índice** que empieza en **0**.

```java
int[] numeros = new int[5];   // vector de 5 enteros (posiciones 0 a 4)
numeros[0] = 10;              // asigno en la primera posición
int x = numeros[2];           // leo la tercera posición
int largo = numeros.length;   // cantidad de elementos (5)
```

- Recorrer con UN solo `for`: `for (int x = 0; x < numeros.length; x++)`
- Cuidado: el último índice es `length - 1`. Si pongo `length` me salgo del vector (error).

```java
// CARGA
for (int x = 0; x < cant; x++) {
    numeros[x] = teclado.nextInt();
}

// RECORRIDO / MOSTRAR
for (int x = 0; x < cant; x++) {
    System.out.println(numeros[x]);
}
```

---

## 2. Matriz (array de 2 dimensiones)

Tabla de **filas** y **columnas**. Dos índices: `matriz[fila][columna]`.

```java
int[][] tabla = new int[3][4];   // 3 filas, 4 columnas

// CARGA / RECORRIDO (siempre DOS for, filas afuera, columnas adentro)
for (int x = 0; x < 3; x++) {          // x = fila
    for (int y = 0; y < 4; y++) {      // y = columna
        tabla[x][y] = teclado.nextInt();
    }
}

// MOSTRAR
for (int x = 0; x < 3; x++) {
    for (int y = 0; y < 4; y++) {
        System.out.print(tabla[x][y] + " | ");
    }
    System.out.println();   // salto de línea al terminar cada fila
}
```

### Recorrer sin pasar filas/columnas: usar `.length`
```java
int filas = matriz.length;        // cantidad de FILAS
int cols  = matriz[0].length;     // cantidad de COLUMNAS (largo de la primera fila)
```

### Los 4 "casos clásicos" de posición
| Qué quiero | Código |
|---|---|
| Diagonal principal | `matriz[x][x]` |
| Diagonal secundaria | `matriz[x][(col-1) - x]` |
| Última fila | `matriz[fila-1][y]` |
| Vértices | `matriz[0][0]`, `matriz[0][col-1]`, `matriz[fila-1][0]`, `matriz[fila-1][col-1]` |

---

## 3. Ordenamiento burbuja (clásico de parcial)

Dos `for` anidados + un **auxiliar** para intercambiar.

```java
int aux;
for (int x = 0; x < (cant - 1); x++) {         // pasa varias veces
    for (int y = 0; y < (cant - 1); y++) {     // compara de a pares
        if (vector[y] > vector[y + 1]) {       // menor a mayor
            aux = vector[y];
            vector[y] = vector[y + 1];
            vector[y + 1] = aux;
        }
    }
}
```

- Cambiando el `>` por `<` queda de **mayor a menor**.
- **El auxiliar es OBLIGATORIO**, si no, pisás el valor.

### Intercambiar dos posiciones (lo mismo, pero en matrices por filas)
```java
float aux = matriz[0][y];   // guardo antes de pisar
matriz[0][y] = matriz[1][y];
matriz[1][y] = aux;
```

---

## 4. Vectores paralelos

Dos (o más) vectores que se ordenan **juntos**: cuando muevo el dato,
muevo también su "compañero" (ej: nombre ↔ nota, pais ↔ habitantes).

```java
if (notas[y] < notas[y+1]) {
    int  auxNota   = notas[y];      // guardo AMBOS
    String auxNombre = nombres[y];
    notas[y]   = notas[y+1];        // muevo ambos
    nombres[y] = nombres[y+1];
    notas[y+1]   = auxNota;         // restauro ambos
    nombres[y+1] = auxNombre;
}
```
Regla de oro: **todo lo que se mueve de un vector, se mueve de TODOS los paralelos**.

---

## 5. Ordenar textos (alfabéticamente)

Se usa `compareTo`. No se usa `>` ni `<` con strings.

```java
if (paises[y].compareTo(paises[y+1]) > 0) {
    // > 0  -> el de la izquierda va después, hay que moverlo
    // = 0  -> son iguales
    // < 0  -> ya está en orden
}
```

---

## 6. Buscar el MAYOR / MENOR + posición

Técnica: **suponer que el primero es el mayor/menor** y recorrer comparando.

```java
int mayor = matriz[0][0];
int filaMayor = 0, colMayor = 0;
for (int x = 0; x < filas; x++) {
    for (int y = 0; y < cols; y++) {
        if (matriz[x][y] > mayor) {
            mayor = matriz[x][y];      // actualizo el valor
            filaMayor = x;             // Y guardo su posición
            colMayor = y;
        }
    }
}
```
Cambiando por `<` busco el **menor**. Idéntico funciona con vectores (un solo `for`).

---

## 7. Contar ocurrencias / repetidos

Llevo un contador que se suma cuando aparece lo que busco.

```java
int repetidos = 0;
for (int x = 0; x < cant; x++) {
    if (numeros[x] == numMenor) {
        repetidos++;
    }
}
```

---

## 8. Random (herramienta de práctica)

Genera datos al azar para no tipear de a mano. NO es ejercicio de parcial,
pero sirve para probar rápido.

```java
Random random = new Random();
int n = random.nextInt(100);   // 0 a 99
int m = random.nextInt(10) + 1; // 1 a 10  (le sumo 1 si no quiero el 0)
```

---

## 9. Errores típicos que te hacen perder puntos (¡conocelos!)

1. **No crear el vector/matriz** antes de usarlo (`new int[cant]`) → NullPointerException.
2. **Salir del vector** usando `x+1` cuando `x` ya es el último → error de índice.
3. **Olvidar el auxiliar** en un intercambio → se pisan valores.
4. En **vectores paralelos**, mover solo uno de los dos.
5. Usar `>` / `<` con **strings** (hay que usar `compareTo`).
6. Confundir **fila** con **columna** al imprimir/posicionar.
7. Mezclar `nextInt()` con `nextLine()` (el Enter queda "colgado") → limpiar con `teclado.nextLine()`.

---

## ¿Cómo lo hace el profe (Orientado a Objetos)?

- Método `main` **solo en una clase** (el `Menu`).
- Lógica separada en clases por tema: `Vectores`, `Matrices`.
- Cada "consigna" = un **método** dentro de su clase.
- El `Menu` solo **orquesta** (pide opción y llama al método).
- Métodos cortos, nombres descriptivos, código reutilizable (métodos de apoyo
  como `cargarMatriz`, `mostrarMatriz` sin repetir).
