# CONSIGNAS PARA PRACTICAR (Parcial — Vectores y Matrices)

Resolverlas a mano/papel o en el proyecto `RepasoParcial` agregando métodos.
Las que están marcadas con ★ son las más típicas de parcial.

---

## PARTE A — VECTORES

   1. **★** Cargar N números por teclado en un vector y mostrar:
      a) el vector completo, b) el promedio, c) cuántos son mayores al promedio.


3. Cargar N números y mostrar **cuántas veces se repite** el primer elemento.

4. **★** Cargar N números y **invertirlo** (el primero pasa al final y así sucesivamente). Mostrar el vector invertido. (Pista: recorrer hasta la mitad e intercambiar `v[i]` con `v[cant-1-i]`.)

5. **★** Cargar los nombres de N alumnos y sus notas. Mostrar:
   - el promedio de notas,
   - el nombre del alumno con la nota más alta,
   - la nota más baja.

6. Cargar nombres de N países y su cantidad de habitantes. Ordenar **por habitantes de mayor a menor** (arrastrando el nombre).

7. Cargar N edades y contar cuántas personas tienen:
   - menos de 18, entre 18 y 60, más de 60.

8. **★** Cargar N números enteros y mostrar si **está ordenado** de menor a mayor (sí/no). (Pista: si en algún momento `v[i] > v[i+1]`, no está ordenado.)

---

## PARTE B — MATRICES

9. **★** Cargar una matriz de N x M y mostrar:
   - la suma de todos sus elementos,
   - el promedio.

10. **★** Cargar una matriz de N x M y mostrar la **suma de cada fila** y la **suma de cada columna**.

11. **★** Cargar una matriz cuadrada (N x N) y mostrar únicamente la **diagonal principal** y la **diagonal secundaria**.

12. Cargar una matriz de N x M y mostrar los elementos de la **primera fila**, la **última fila**, la **primera columna** y la **última columna** (el "borde" de la matriz).

13. **★** Cargar una matriz de N x M y detectar si es **simétrica** (que `m[i][j] == m[j][i]` para todos). Es decir `matriz[i][j].equals(matriz[j][i])` si son strings, o `==` si son números.

14. **★** Cargar una matriz de N x M y **contar cuántos ceros** tiene. Decir si es una "matriz cero" (todos ceros) o no.

15. Cargar una matriz de N x M y **intercambiar la primera columna con la última** (o la fila 0 con la fila N-1).

16. **★** Cargar una matriz de N x M y **transponerla**: mostrar la matriz donde las filas y columnas se invierten (el elemento `[i][j]` pasa a `[j][i]`).

17. Cargar una matriz de N x M y hallar el **producto** de todos los elementos del **último renglón**.

18. **★** Cargar una matriz de N x M y mostrar el **mayor de cada fila** (un número por cada fila).

---

## PARTE C — COMBINADO (nivel examen)

19. **★** Tienda: cargar en vectores paralelos el **nombre del producto** y su **precio** (N productos). Mostrar:
   - el producto más caro y el más barato,
   - el promedio de precios,
   - cuántos productos superan el promedio.

20. **★** Tabla de notas: una matriz de **N alumnos x M materias** (cada celda es una nota). Mostrar:
   - el promedio de cada alumno (por fila),
   - el promedio de cada materia (por columna),
   - el alumno con mejor promedio general.

21. **★** Estacionamiento: un vector con las horas que estuvo cada auto (N autos) y una tarifa por hora cargada por teclado. Calcular y mostrar cuánto debe pagar cada auto y el total recaudado.

22. **★** Vectores paralelos de pares: cargar N pares (p.ej. código y stock de un producto). Permitir **buscar un código** y mostrar su stock (o mensaje "no existe").

23. Matriz de ventas por día (filas = productos, columnas = días de la semana, 7 columnas). Mostrar:
   - cuánto se vendió de cada producto en la semana,
   - qué día se vendió más en total.

---

## Consejos para encarar el parcial
1. Leé la consigna y marcá **qué entradas** tenés (tamaños fijos o variables).
2. Decidí si es vector (1 bucle) o matriz (2 bucles).
3. Dibujá la matriz en un papel para ubicar filas/columnas antes de codear.
4. Agregá cada ejercicio como un **método** a `Vectores` o `Matrices` y un caso en el `Menu`.
5. Probá con datos chicos (2x2, 3 elementos) para validar la lógica.
