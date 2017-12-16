/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clasespersonalizadas;

import java.io.Serializable;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

/**
 *
 * @author FABAME
 */
/**
 * Clase para guardar y manipular elementos en una lista enlazada.
 *
 * @param <E> el tipo de elementos contenidos en esta colección
 */
public class ListaEnlazada<E> implements Lista<E>, Serializable {

    //Atributos de la clase ListaEnlazada
    private static final long serialVersionUID = 7579611673568763301L;

    /**
     * Listado de elementos en una listaEnlazada.
     */
    private final LinkedList<E> listadoElementos;

    //Constructores de la clase ListaEnlazada.
    /**
     * Construye una lista vacía.
     */
    public ListaEnlazada() {
        this.listadoElementos = new LinkedList<>();
    }

    /**
     * Construye una lista que contiene los elementos de la colección
     * especificada, en el orden en que el iterador de la colección los
     * devuelve.
     *
     * @param coleccion la colección cuyos elementos deben ser colocados en esta
     * lista
     */
    public ListaEnlazada(Collection<? extends E> coleccion) {
        this.listadoElementos = new LinkedList<>(coleccion);
    }

    //Métodos de la clase ListaEnlazada.
    /**
     * Devuelve un vector que contiene todos los elementos de esta lista en la
     * secuencia correcta (del primer al último elemento). El vector devuelta
     * será "seguro" ya que esta lista no mantiene ninguna referencia a ella.
     * (En otras palabras, este método debe asignar una nueva matriz). La
     * persona que llama es libre de modificar el vector devuelta.
     *
     * Este método actúa como puente entre las API basadas en vectores y basadas
     * en vectores.
     *
     * @return un vector que contiene todos los elementos en esta lista en la
     * secuencia correcta
     */
    public Object[] aVector() {
        return this.listadoElementos.toArray();
    }

    /**
     * Devuelve un vector que contiene todos los elementos de esta lista en la
     * secuencia correcta (del primer al último elemento); el tipo de tiempo de
     * ejecución de la matriz devuelta es el del vector especificado. Si la
     * lista se ajusta al vector especificado, se devuelve allí. De lo
     * contrario, se asigna un nuevo vector con el tipo de tiempo de ejecución
     * del vector especificado y el tamaño de esta lista. Si la lista cabe en el
     * vector especificado con espacio de sobra (es decir, el vector tiene más
     * elementos que la lista), el elemento en el vector inmediatamente después
     * del final de la colección se establece en nulo . (Esto es útil para
     * determinar la longitud de la lista solo si la persona que llama sabe que
     * la lista no contiene ningún elemento nulo). Al igual que el
     * aVector()método, este método actúa como puente entre las API basadas en
     * matrices y las basadas en colecciones. Además, este método permite un
     * control preciso sobre el tipo de tiempo de ejecución de la matriz de
     * salida y, en determinadas circunstancias, puede utilizarse para ahorrar
     * costos de asignación.
     *
     * Supongamos que xse sabe que una lista solo contiene cadenas. El siguiente
     * código se puede usar para volcar la lista en una matriz recién asignada
     * de String:
     *
     * String [] y = x.aVector (new String [0]); Tenga en cuenta que aVector(new
     * Object[0])es idéntica en función a aVector().
     *
     * @param <T> el tipo de elementos contenidos en este vector
     * @param vector el vector en la que se almacenarán los elementos de la
     * lista, si es lo suficientemente grande; de lo contrario, se asigna un
     * nuevo vector del mismo tipo de tiempo de ejecución para este fin
     * @return un vector que contiene los elementos de la lista
     */
    public <T> T[] aVector(T[] vector) {
        return this.listadoElementos.toArray(vector);
    }

    /**
     * Agrega el elemento especificado al final de esta lista.
     *
     * @param elemento elemento que se adjuntará a esta lista
     * @return verdadero(según lo especificado por Collection.add(E))
     */
    public boolean agregar(E elemento) {
        return this.listadoElementos.add(elemento);
    }

    /**
     * Inserta el elemento especificado en la posición especificada en esta
     * lista. Cambia el elemento actualmente en esa posición (si existe) y
     * cualquier elemento posterior a la derecha (agrega uno a sus índices).
     *
     * @param indice índice en el que se debe insertar el elemento especificado
     * @param elemento elemento a insertar
     */
    public void agregar(int indice, E elemento) {
        this.listadoElementos.add(indice, elemento);
    }

    /**
     * Inserta el elemento especificado al principio de esta lista.
     *
     * @param elemento el elemento para agregar
     */
    public void agregarPrimero(E elemento) {
        this.listadoElementos.addFirst(elemento);
    }

    /**
     * Agrega todos los elementos de la colección especificada al final de esta
     * lista, en el orden en que los devuelve el repetidor de la colección
     * especificada. El comportamiento de esta operación no está definido si la
     * colección especificada se modifica mientras la operación está en
     * progreso. (Tenga en cuenta que esto ocurrirá si la colección especificada
     * es esta lista y no está vacía).
     *
     * @param coleccion colección que contiene elementos para agregar a esta
     * lista
     * @return verdadero si esta lista cambió como resultado de la llamada
     */
    public boolean agregarTodo(Collection<? extends E> coleccion) {
        return this.listadoElementos.addAll(coleccion);
    }

    /**
     * Inserta todos los elementos en la colección especificada en esta lista,
     * comenzando en la posición especificada. Cambia el elemento actualmente en
     * esa posición (si existe) y cualquier elemento posterior a la derecha
     * (aumenta sus índices). Los nuevos elementos aparecerán en la lista en el
     * orden en que son devueltos por el iterador de la colección especificada.
     *
     * @param indice índice en el que insertar el primer elemento de la
     * colección especificada
     * @param coleccion colección que contiene elementos para agregar a esta
     * lista
     * @return verdadero si esta lista cambió como resultado de la llamada
     */
    public boolean agregarTodo(int indice, Collection<? extends E> coleccion) {
        return this.listadoElementos.addAll(indice, coleccion);
    }

    /**
     * Agrega el elemento especificado al final de esta lista.
     *
     * @param elemento el elemento para agregar
     */
    public void agregarUltimo(E elemento) {
        this.listadoElementos.addLast(elemento);
    }

    /**
     * Apila un elemento sobre la pila representada por esta lista. En otras
     * palabras, inserta el elemento al principio de esta lista.
     *
     * @param elemento el elemento para empujar
     */
    public void apilar(E elemento) {
        this.listadoElementos.push(elemento);
    }

    /**
     * Devuelve una copia superficial de esto LinkedList. (Los elementos en sí
     * mismos no están clonados).
     *
     * @return una copia superficial de esta instancia de ListaEnlazada
     */
    public Object clonar() {
        return this.listadoElementos.clone();
    }

    /**
     * Devuelve el valor del código hash para esta lista. El código hash de una
     * lista se define como el resultado del siguiente cálculo:
     *
     * int codigoHash = 1; for (E e : list) codigoHash = 31* codigoHash +
     * (e==null ? 0 : e.hashCode());
     *
     * Esto asegura que list1.equals (list2) implica que list1.codigoHash () ==
     * list2.hashCode () para dos listas, list1 y list2 , según lo requerido por
     * el contrato general de Object.hashCode().
     *
     * @return el valor del código hash para esta lista
     */
    public int codigoHash() {
        return this.listadoElementos.hashCode();
    }

    /**
     * Conserva solo los elementos en esta lista que están contenidos en la
     * colección especificada. En otras palabras, elimina de esta lista todos
     * sus elementos que no están contenidos en la colección especificada.
     *
     * @param coleccion colección que contiene elementos para ser retenidos en
     * esta lista
     * @return verdadero si esta lista cambió como resultado de la llamada
     */
    public boolean conservarTodo(Collection<?> coleccion) {
        return this.listadoElementos.retainAll(coleccion);
    }

    /**
     * Devuelve verdadero si esta lista contiene el elemento especificado. Más
     * formalmente, devuelve truesi y solo si esta lista contiene al menos un
     * elemento etal que (objeto == null? E == null: objeto.equals (e)) .
     *
     * @param objeto elemento cuya presencia en esta lista debe probarse
     * @return verdadero si esta lista contiene el elemento especificado
     */
    public boolean contiene(Object objeto) {
        return this.listadoElementos.contains(objeto);
    }

    /**
     * Devuelve verdadero si esta lista contiene todos los elementos de la
     * colección especificada.
     *
     * @param coleccion colección que debe verificarse para contención en esta
     * lista
     * @return verdadero si esta lista contiene todos los elementos de la
     * colección especificada
     */
    public boolean contieneTodo(Collection<?> coleccion) {
        return this.listadoElementos.containsAll(coleccion);
    }

    /**
     * Muestra un elemento de la pila representada por esta lista. En otras
     * palabras, elimina y devuelve el primer elemento de esta lista.
     *
     * @return el elemento al principio de esta lista (que es la parte superior
     * de la pila representada por esta lista)
     */
    public E desapilar() {
        return this.listadoElementos.pop();
    }

    /**
     * Recupera, pero no elimina, el encabezado (primer elemento) de esta lista.
     *
     * @return el encabezado de esta lista
     */
    public E elemento() {
        return this.listadoElementos.element();
    }

    /**
     * Recupera y elimina el encabezado (primer elemento) de esta lista.
     *
     * @return el encabezado de esta lista, o nulo si esta lista está vacía
     */
    public E encuestar() {
        return this.listadoElementos.poll();
    }

    /**
     * Recupera y elimina el primer elemento de esta lista o lo devuelve nulo si
     * esta lista está vacía.
     *
     * @return el primer elemento de esta lista, o nulo si esta lista está vacía
     */
    public E encuestarPrimero() {
        return this.listadoElementos.pollFirst();
    }

    /**
     * Recupera y elimina el último elemento de esta lista o lo devuelve nulo si
     * esta lista está vacía.
     *
     * @return el último elemento de esta lista, o nulo si esta lista está vacía
     */
    public E encuestarUltimo() {
        return this.listadoElementos.pollLast();
    }

    /**
     * Devuelve verdadero si esta lista no contiene elementos.
     *
     * @return verdadero si esta lista no contiene elementos
     */
    public boolean estaVacia() {
        return this.listadoElementos.isEmpty();
    }

    /**
     * Reemplaza el elemento en la posición especificada en esta lista con el
     * elemento especificado.
     *
     * @param indice índice del elemento a reemplazar
     * @param elemento elemento que se almacenará en la posición especificada
     * @return el elemento previamente en la posición especificada
     */
    public E establecer(int indice, E elemento) {
        return this.listadoElementos.set(indice, elemento);
    }

    /**
     * Compara el objeto especificado con esta lista para la igualdad. Devuelve
     * verdadero si y solo si el objeto especificado también es una lista, ambas
     * listas tienen el mismo tamaño y todos los pares correspondientes de
     * elementos en las dos listas son iguales . (Dos elementos e1 y e2 son
     * iguales si (e1 == nulo? E2 == nulo: e1.igual (e2)) .) En otras palabras,
     * dos listas se definen como iguales si contienen los mismos elementos en
     * el mismo orden . Esta definición asegura que el método equals funciona
     * correctamente en diferentes implementaciones de la interfaz de la Lista .
     *
     * @param objeto el objeto que se debe comparar para la igualdad con esta
     * lista
     * @return verdadero si el objeto especificado es igual a esta lista
     */
    public boolean igual(Object objeto) {
        return this.listadoElementos.equals(objeto);
    }

    /**
     *
     * @param objeto elemento para buscar
     * @return el índice de la primera aparición del elemento especificado en
     * esta lista, o -1 si esta lista no contiene el elemento
     */
    public int indiceDe(Object objeto) {
        return this.listadoElementos.indexOf(objeto);
    }

    /**
     * Devuelve un iterador sobre los elementos en esta lista en la secuencia
     * correcta.
     *
     * @return un iterador sobre los elementos en esta lista en la secuencia
     * correcta
     */
    public Iterator<E> iterador() {
        return this.listadoElementos.iterator();
    }

    /**
     * Devuelve un iterador sobre los elementos en este deque en orden
     * secuencial inverso. Los elementos serán devueltos en orden desde la
     * última (cola) hasta la primera (cabeza).
     *
     * @return un iterador sobre los elementos en este deque en secuencia
     * inversa
     */
    public Iterator<E> iteradorDescendente() {
        return this.listadoElementos.descendingIterator();
    }

    /**
     * Devuelve un iterador de lista sobre los elementos en esta lista (en la
     * secuencia correcta).
     *
     * @return un iterador de lista sobre los elementos en esta lista (en la
     * secuencia correcta)
     */
    public ListIterator<E> iteradorLista() {
        return this.listadoElementos.listIterator();
    }

    /**
     * Devuelve un iterador de lista de los elementos en esta lista (en la
     * secuencia correcta), comenzando en la posición especificada en la lista.
     * Obedece el contrato general de List.listIterator(int). El iterador de
     * lista no funciona : si la lista se modifica estructuralmente en cualquier
     * momento después de que se crea el iterador, de cualquier forma, excepto a
     * través de los métodos propios removeo del iterador de lista, el iterador
     * de addlista arrojará un ConcurrentModificationException. Por lo tanto,
     * frente a la modificación concurrente, el iterador falla rápida y
     * limpiamente, en lugar de arriesgarse a un comportamiento arbitrario y no
     * determinista en un tiempo indeterminado en el futuro.
     *
     * @param indice índice del primer elemento a devolver desde el iterador de
     * lista (por una llamada al siguiente)
     * @return un iterador de lista de los elementos en esta lista (en la
     * secuencia apropiada), comenzando en la posición especificada en la lista
     */
    public ListIterator<E> iteradorLista(int indice) {
        return this.listadoElementos.listIterator(indice);
    }

    /**
     * Crea un enlace tardío y falla IteradorSpl en los elementos de esta lista.
     * Los Spliteratorinformes Spliterator.SIZED, Spliterator.SUBSIZEDy
     * Spliterator.ORDERED. Las implementaciones prioritarias deben documentar
     * el informe de valores característicos adicionales.
     *
     * @return un IteradrorSpl los elementos en esta lista
     */
    public Spliterator<E> iteradorSpl() {
        return this.listadoElementos.spliterator();
    }

    /**
     * Elimina todos los elementos de esta lista. La lista estará vacía después
     * de que regrese esta llamada.
     */
    public void limpiar() {
        this.listadoElementos.clear();
    }

    /**
     * Recupera, pero no elimina, el encabezado (primer elemento) de esta lista.
     *
     * @return el encabezado de esta lista, o nulo si esta lista está vacía
     */
    public E mirar() {
        return this.listadoElementos.peek();
    }

    /**
     * Recupera, pero no elimina, el primer elemento de esta lista, o lo
     * devuelve nulo si esta lista está vacía.
     *
     * @return el primer elemento de esta lista, o nulo si esta lista está vacía
     */
    public E mirarPrimero() {
        return this.listadoElementos.peekFirst();
    }

    /**
     * Recupera, pero no elimina, el último elemento de esta lista, o lo
     * devuelve nulo si esta lista está vacía.
     *
     * @return el último elemento de esta lista, o nulo si esta lista está vacía
     */
    public E mirarUltimo() {
        return this.listadoElementos.peekLast();
    }

    /**
     * Agrega el elemento especificado como la cola (último elemento) de esta
     * lista.
     *
     * @param elemento el elemento para agregar
     * @return verdadero(según lo especificado por Queue.offer(E))
     */
    public boolean ofrecer(E elemento) {
        return this.listadoElementos.offer(elemento);
    }

    /**
     * Inserta el elemento especificado al principio de esta lista.
     *
     * @param elemento el elemento para insertar
     * @return verdadero(según lo especificado por Deque.offerFirst(E))
     */
    public boolean ofrecerPrimero(E elemento) {
        return this.listadoElementos.offerFirst(elemento);
    }

    /**
     * Inserta el elemento especificado al final de esta lista.
     *
     * @param elemento el elemento para insertar
     * @return verdadero(según lo especificado por Deque.offerFirst(E))
     */
    public boolean ofrecerUltimo(E elemento) {
        return this.listadoElementos.offerLast(elemento);
    }

    /**
     * Ordena esta lista según el orden inducido por el especificado Comparador.
     * Todos los elementos en esta lista deben ser mutuamente comparables usando
     * el comparador especificado (es decir, comparador.compare(e1, e2)no debe
     * arrojar un ClassCastExceptionpara ningún elemento e1ni e2 en la lista).
     *
     * Si el comparador especificado es nullentonces todos los elementos en esta
     * lista deben implementar la Comparableinterfaz y se debe usar el orden
     * natural de los elementos .
     *
     * Esta lista debe ser modificable, pero no es necesario cambiar el tamaño.
     *
     * @param comparador el Comparador usado para comparar elementos de lista.
     * Un valor nulo indica que se debe usar el orden natural de los elementos
     */
    public void ordenar(Comparator<? super E> comparador) {
        this.listadoElementos.sort(comparador);
    }

    /**
     * Realiza la acción dada para cada elemento de la Iterable hasta que todos
     * los elementos hayan sido procesados ​​o la acción arroje una excepción.
     *
     * @param accion la acción a realizar para cada elemento
     */
    public void paraCada(Consumer<? super E> accion) {
        this.listadoElementos.forEach(accion);
    }

    /**
     * Devuelve el elemento en la posición especificada en esta lista.
     *
     * @param indice índice del elemento a devolver
     * @return el elemento en la posición especificada en esta lista
     */
    public E obtener(int indice) {
        return this.listadoElementos.get(indice);
    }

    /**
     * Devuelve el primer elemento en esta lista.
     *
     * @return el primer elemento en esta lista
     */
    public E obtenerPrimero() {
        return this.listadoElementos.getFirst();
    }

    /**
     * Devuelve el último elemento en esta lista.
     *
     * @return el último elemento en esta lista
     */
    public E obtenerUltimo() {
        return this.listadoElementos.getLast();
    }

    /**
     * Reemplaza cada elemento de esta lista con el resultado de aplicar el
     * operador a ese elemento. Los errores o excepciones de tiempo de ejecución
     * lanzados por el operador se transmiten a la persona que llama.
     *
     * @param operador el operador para aplicar a cada elemento
     */
    public void reemplazarTodo(UnaryOperator<E> operador) {
        this.listadoElementos.replaceAll(operador);
    }

    /**
     * Recupera y elimina el encabezado (primer elemento) de esta lista.
     *
     * @return el encabezado de esta lista
     */
    public E remover() {
        return this.listadoElementos.remove();
    }

    /**
     * Quita el elemento en la posición especificada en esta lista. Cambia
     * cualquier elemento posterior a la izquierda (resta uno de sus índices).
     * Devuelve el elemento que se eliminó de la lista.
     *
     * @param indice el índice del elemento a eliminar
     * @return el elemento previamente en la posición especificada
     */
    public E remover(int indice) {
        return this.listadoElementos.remove(indice);
    }

    /**
     * Elimina la primera aparición del elemento especificado de esta lista, si
     * está presente. Si esta lista no contiene el elemento, no se modifica. Más
     * formalmente, elimina el elemento con el índice más bajo de imodo que
     * (objeto == null? Get (i) == null: objeto.equals (get (i))) (si tal
     * elemento existe). Devuelve verdadero si esta lista contenía el elemento
     * especificado (o de manera equivalente, si esta lista cambió como
     * resultado de la llamada). Especificado por:
     *
     * @param objeto elemento que se eliminará de esta lista, si está presente
     * @return verdadero si esta lista contenía el elemento especificado
     */
    public boolean remover(Object objeto) {
        return this.listadoElementos.remove(objeto);
    }

    /**
     * Elimina la primera aparición del elemento especificado en esta lista (al
     * atravesar la lista de la cabeza a la cola). Si la lista no contiene el
     * elemento, no se modifica.
     *
     * @param objeto elemento que se eliminará de esta lista, si está presente
     * @return verdadero si la lista contenía el elemento especificado
     */
    public boolean removerPrimeraAparicion(Object objeto) {
        return this.listadoElementos.removeFirstOccurrence(objeto);
    }

    /**
     * Elimina y devuelve el primer elemento de esta lista.
     *
     * @return el primer elemento de esta lista
     */
    public E removerPrimero() {
        return this.listadoElementos.removeFirst();
    }

    /**
     * Elimina todos los elementos de esta colección que satisfacen el predicado
     * dado. Los errores o las excepciones de tiempo de ejecución lanzadas
     * durante la iteración o por el predicado se transmiten a la persona que
     * llama.
     *
     * @param filtro un predicado que devuelve elementos verdaderos que se
     * eliminarán
     * @return verdadero si se eliminó algún elemento
     */
    public boolean removerSi(Predicate<? super E> filtro) {
        return this.listadoElementos.removeIf(filtro);
    }

    /**
     * Elimina de esta lista todos sus elementos que están contenidos en la
     * colección especificada.
     *
     * @param coleccion colección que contiene elementos para eliminar de esta
     * lista
     * @return verdadero si esta lista cambió como resultado de la llamada
     */
    public boolean removerTodo(Collection<?> coleccion) {
        return this.listadoElementos.removeAll(coleccion);
    }

    /**
     * Elimina la última aparición del elemento especificado en esta lista (al
     * atravesar la lista de la cabeza a la cola). Si la lista no contiene el
     * elemento, no se modifica.
     *
     * @param objeto elemento que se eliminará de esta lista, si está presente
     * @return verdadero si la lista contenía el elemento especificado
     */
    public boolean removerUltimaAparicion(Object objeto) {
        return this.listadoElementos.removeLastOccurrence(objeto);
    }

    /**
     * Elimina y devuelve el último elemento de esta lista.
     *
     * @return el último elemento de esta lista
     */
    public E removerUltimo() {
        return this.listadoElementos.removeLast();
    }

    /**
     * Devuelve una vista de la porción de esta lista entre el especificado
     * desdeIndice, inclusivo y hastaIndiceexclusivo. (Si fromIndexy toIndexson
     * iguales, la lista devuelta está vacía.) La lista devuelta está respaldada
     * por esta lista, por lo que los cambios no estructurales en la lista
     * devuelta se reflejan en esta lista, y viceversa. La lista devuelta admite
     * todas las operaciones de lista opcionales. Este método elimina la
     * necesidad de operaciones de rango explícitas (del tipo que comúnmente
     * existe para las matrices). Cualquier operación que espera una lista se
     * puede usar como una operación de rango al pasar una vista sublista en
     * lugar de una lista completa. Por ejemplo, el siguiente modismo elimina un
     * rango de elementos de una lista:
     *
     * list.subList (de, a) .clear ();
     *
     * Se pueden construir expresiones idiomáticas similares para
     * indiceDe(Object)y ultimoIndiceDe(Object), y todos los algoritmos de la
     * Collections clase se pueden aplicar a una sublista. La semántica de la
     * lista devuelta por este método queda indefinida si la lista de respaldo
     * (es decir, esta lista) se modifica estructuralmente de cualquier manera
     * que no sea a través de la lista devuelta. (Las modificaciones
     * estructurales son aquellas que cambian el tamaño de esta lista o la
     * perturban de tal manera que las iteraciones en progreso pueden arrojar
     * resultados incorrectos).
     *
     * Especificado por:
     *
     * @param desdeIndice punto final bajo (inclusive) de la sublista
     * @param hastaIndice punto final alto (exclusivo) de la sublista
     * @return una vista del rango especificado dentro de esta lista
     */
    public List<E> subLista(int desdeIndice, int hastaIndice) {
        return this.listadoElementos.subList(hastaIndice, hastaIndice);
    }

    /**
     * Devuelve la cantidad de elementos en esta lista.
     *
     * @return la cantidad de elementos en esta lista
     */
    public int tamanio() {
        return this.listadoElementos.size();
    }

    /**
     * Devuelve el índice de la última aparición del elemento especificado en
     * esta lista, o -1 si esta lista no contiene el elemento. Más formalmente,
     * devuelve el índice más alto de imodo que (objeto == null? Get (i) ==
     * null: objeto.equals (get (i))) , o -1 si no hay tal índice.
     *
     * @param objeto elemento para buscar
     * @return el índice de la última aparición del elemento especificado en
     * esta lista, o -1 si esta lista no contiene el elemento
     */
    public int ultimoIndiceDe(Object objeto) {
        return this.listadoElementos.lastIndexOf(objeto);
    }

}
