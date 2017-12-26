/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clasespersonalizadas;

import java.io.Serializable;
import java.util.Collection;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Spliterator;
import java.util.Vector;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

/**
 *
 * @author FABAME
 */
/**
 * Clase para guardar y manipular componentes en una lista de vector.
 *
 * @param <E> el tipo de elementos contenidos en esta colección
 */
public class ListaVector<E> implements Lista<E>, Serializable {

    //Atributos de la clase ListaVector.
    private static final long serialVersionUID = 5663581639854647775L;

    /**
     * Listado de elementos en una lista de vector.
     */
    private final Vector<E> listadoElementos;

    //Constructores de la clase ListaVector.
    /**
     * Construye un vector vacío para que su arreglo de datos internos tenga
     * tamaño 10 y su incremento de capacidad estándar sea cero.
     */
    public ListaVector() {
        this.listadoElementos = new Vector<>();
    }

    /**
     * Construye un vector vacío con la capacidad inicial especificada y con su
     * incremento de capacidad igual a cero.
     *
     * @param capacidadInicial la capacidad inicial del vector
     */
    public ListaVector(int capacidadInicial) {
        this.listadoElementos = new Vector<>(capacidadInicial);
    }

    /**
     * Construye un vector vacío con la capacidad inicial especificada y el
     * incremento de capacidad.
     *
     * @param capacidadInicial la capacidad inicial del vector
     * @param incrementoCapacidad la cantidad por la cual la capacidad aumenta
     * cuando el vector se desborda
     */
    public ListaVector(int capacidadInicial, int incrementoCapacidad) {
        this.listadoElementos = new Vector<>(capacidadInicial, incrementoCapacidad);
    }

    /**
     * Construye un vector que contiene los elementos de la colección
     * especificada, en el orden en que el iterador de la colección los
     * devuelve.
     *
     * @param coleccion la colección cuyos elementos deben ser colocados en este
     * vector
     */
    public ListaVector(Collection<? extends E> coleccion) {
        this.listadoElementos = new Vector<>(coleccion);
    }

    //Métodos de la clase ListaVector.
    /**
     * Devuelve un arreglo que contiene todos los elementos de este Vector en el
     * orden correcto.
     *
     * @return un arreglo que contiene todos los elementos de esta colección
     */
    @Override
    public Object[] aArreglo() {
        return this.listadoElementos.toArray();
    }

    /**
     * Devuelve un arreglo que contiene todos los elementos de este Vector en el
     * orden correcto; el tipo de tiempo de ejecución de la arreglo devuelta es
     * el del arreglo especificado. Si el Vector encaja en el arreglo
     * especificado, se devuelve allí. De lo contrario, se asigna un nuevo
     * arreglo con el tipo de tiempo de ejecución del arreglo especificado y el
     * tamaño de este Vector. Si el Vector encaja en el arreglo especificado con
     * espacio de sobra (es decir, el arreglo tiene más elementos que el
     * Vector), el elemento en el arreglo que sigue inmediatamente al final del
     * Vector se establece en nulo. (Esto es útil para determinar la longitud
     * del Vector solo si la persona que llama sabe que el Vector no contiene
     * ningún elemento nulo).
     *
     * @param <T> el tipo de elementos contenidos en este arreglo
     * @param arreglo el arreglo en la que se almacenarán los elementos del
     * Vector, si es lo suficientemente grande; de lo contrario, se asigna un
     * nuevo arreglo del mismo tipo de tiempo de ejecución para este fin.
     * @return un arreglo que contiene los elementos del Vector
     */
    @Override
    public <T> T[] aArreglo(T[] arreglo) {
        return this.listadoElementos.toArray(arreglo);
    }

    /**
     * Devuelve una representación de cadena de este Vector, que contiene la
     * representación de Cadena de cada elemento.
     *
     * @return una cadena de representación de esta colección
     */
    public String aCadena() {
        return this.listadoElementos.toString();
    }

    /**
     * Agrega el elemento especificado al final de este Vector.
     *
     * @param elemento elemento que se adjuntará a esta lista
     * @return verdadero (como se especifica por Collection.add(E))
     */
    @Override
    public boolean agregar(E elemento) {
        return this.listadoElementos.add(elemento);
    }

    /**
     * Inserta el elemento especificado en la posición especificada en este
     * Vector. Cambia el elemento actualmente en esa posición (si existe) y
     * cualquier elemento posterior a la derecha (agrega uno a sus índices).
     *
     * @param indice índice en el que se debe insertar el elemento especificado
     * @param elemento elemento a insertar
     */
    @Override
    public void agregar(int indice, E elemento) {
        this.listadoElementos.add(indice, elemento);
    }

    /**
     * Agrega el componente especificado al final de este vector, aumentando su
     * tamaño en uno. La capacidad de este vector aumenta si su tamaño es mayor
     * que su capacidad. Este método es idéntico en funcionalidad al agregar(E)
     * método (que es parte de la interfaz Lista).
     *
     * @param objeto el componente que se agregará
     */
    public void agregarElemento(E objeto) {
        this.listadoElementos.addElement(objeto);
    }

    /**
     * Agrega todos los elementos en la Colección especificada al final de este
     * Vector, en el orden en que son devueltos por el Iterador de la Colección
     * especificada. El comportamiento de esta operación no está definido si la
     * colección especificada se modifica mientras la operación está en
     * progreso. (Esto implica que el comportamiento de esta llamada no está
     * definido si la Colección especificada es este Vector, y este Vector no
     * está vacío).
     *
     * @param coleccion elementos que se insertarán en este Vector
     * @return verdadero si este Vector cambió como resultado de la llamada
     */
    @Override
    public boolean agregarTodo(Collection<? extends E> coleccion) {
        return this.listadoElementos.addAll(coleccion);
    }

    /**
     * Inserta todos los elementos en la Colección especificada en este Vector
     * en la posición especificada. Cambia el elemento actualmente en esa
     * posición (si existe) y cualquier elemento posterior a la derecha (aumenta
     * sus índices). Los nuevos elementos aparecerán en el Vector en el orden en
     * que son devueltos por el iterador de la Colección especificada.
     *
     * @param indice índice en el que insertar el primer elemento de la
     * colección especificada
     * @param coleccion elementos que se insertarán en este Vector
     * @return verdadero si este Vector cambió como resultado de la llamada
     */
    @Override
    public boolean agregarTodo(int indice, Collection<? extends E> coleccion) {
        return this.listadoElementos.addAll(indice, coleccion);
    }

    /**
     * Aumenta la capacidad de este vector, si es necesario, para garantizar que
     * pueda contener al menos el número de componentes especificado por el
     * argumento de capacidad mínima. Si la capacidad actual de este vector es
     * menor que capacidadMinima, entonces su capacidad aumenta al reemplazar su
     * matriz de datos internos, mantenidos en el campo datosElementos, por uno
     * más grande. El tamaño de la nueva matriz de datos será el tamaño antiguo
     * más incrementoCapacidad, a menos que el valor de incrementoCapacidad sea
     * ​​menor o igual a cero, en cuyo caso la nueva capacidad será el doble de
     * la anterior; pero si este nuevo tamaño es aún más pequeño que
     * capacidadMinima, entonces la nueva capacidad será capacidadMinima
     *
     * @param capacidadMinima la capacidad mínima deseada
     */
    public void asegurarCapacidad(int capacidadMinima) {
        this.listadoElementos.ensureCapacity(capacidadMinima);
    }

    /**
     * Devuelve la capacidad actual de este vector.
     *
     * @return la capacidad actual (la longitud de su arreglo de datos internos,
     * mantenido en el campo datosElementos de este vector)
     */
    public int capacidad() {
        return this.listadoElementos.capacity();
    }

    /**
     * Devuelve un clon de este vector. La copia contendrá una referencia a un
     * clon del arreglo de datos interna, no una referencia al vector de datos
     * internos originales de este objeto vector.
     *
     * @return un clon de este vector.
     */
    @Override
    public Object clonar() {
        return this.listadoElementos.clone();
    }

    /**
     * Devuelve el valor del código hash para este Vector.
     *
     * @return el valor del código hash para esta lista
     */
    @Override
    public int codigoHash() {
        return this.listadoElementos.hashCode();
    }

    /**
     * Copia los componentes de este vector en el arreglo especificado. El
     * elemento en el índice k en este vector se copia en el componente k de
     * unArreglo.
     *
     * @param unArreglo el arreglo en el que se copian los componentes
     */
    public void copiarEn(Object[] unArreglo) {
        this.listadoElementos.copyInto(unArreglo);
    }

    /**
     * Retiene solo los elementos en este Vector que están contenidos en la
     * Colección especificada. En otras palabras, elimina de este Vector todos
     * sus elementos que no están contenidos en la Colección especificada.
     *
     * @param coleccion una colección de elementos que se conservarán en este
     * Vector (se eliminan todos los demás elementos)
     * @return verdadero si este Vector cambió como resultado de la llamada
     */
    @Override
    public boolean conservarTodo(Collection<?> coleccion) {
        return this.listadoElementos.retainAll(coleccion);
    }

    /**
     * Devuelve truesi este vector contiene el elemento especificado. Más
     * formalmente, devuelve verdadero si y solo si este vector contiene al
     * menos un elemento etal que (objeto == null? E == null: objeto.equals (e))
     * .
     *
     * @param objeto elemento cuya presencia en este vector debe probarse
     * @return verdadero si este vector contiene el elemento especificado
     */
    public boolean contiene(Object objeto) {
        return this.listadoElementos.contains(objeto);
    }

    /**
     * Devuelve verdadero si esta lista contiene todos los elementos de la
     * colección especificada.
     *
     * @param coleccion colección que debe verificarse para contención en este
     * vector
     * @return verdadero si este vector contiene todos los elementos de la
     * colección especificada
     */
    @Override
    public boolean contieneTodo(Collection<?> coleccion) {
        return this.listadoElementos.containsAll(coleccion);
    }

    /**
     * Devuelve el componente en el índice especificado.
     *
     * @param indice un índice en este vector
     * @return el componente en el índice especificado
     */
    public E elementoEn(int indice) {
        return this.listadoElementos.elementAt(indice);
    }

    /**
     * Devuelve una enumeración de los componentes de este vector. El
     * Enumerationobjeto devuelto generará todos los elementos en este vector.
     * El primer elemento generado es el ítem en el índice 0, luego el ítem en
     * el índice 1, y así sucesivamente.
     *
     * @return una enumeración de los componentes de este vector
     */
    public Enumeration<E> elementos() {
        return this.listadoElementos.elements();
    }

    /**
     * Prueba si este vector no tiene componentes.
     *
     * @return verdadero si y solo si este vector no tiene componentes, es
     * decir, su tamaño es cero; falso de otra manera.
     */
    @Override
    public boolean estaVacia() {
        return this.listadoElementos.isEmpty();
    }

    /**
     * Reemplaza el elemento en la posición especificada en este Vector con el
     * elemento especificado.
     *
     * @param indice índice del elemento a reemplazar
     * @param elemento elemento que se almacenará en la posición especificada
     * @return el elemento previamente en la posición especificada
     */
    @Override
    public E establecer(int indice, E elemento) {
        return this.listadoElementos.set(indice, elemento);
    }

    /**
     * Establece el componente en el especificado indexde este vector para que
     * sea el objeto especificado. El componente anterior en esa posición se
     * descarta. El índice debe ser un valor mayor o igual que 0 y menor que el
     * tamaño actual del vector.
     *
     * Este método es idéntico en funcionalidad al set(int, E) método (que es
     * parte de la interfaz Lista). Tenga en cuenta que el setmétodo invierte el
     * orden de los parámetros para que coincida más con el uso del arreglo.
     * Tenga en cuenta también que el método establecer devuelve el valor
     * anterior que se almacenó en la posición especificada.
     *
     * @param objeto en qué se configurará el componente
     * @param indice el índice especificado
     */
    public void establecerElementoEn(E objeto, int indice) {
        this.listadoElementos.setElementAt(objeto, indice);
    }

    /**
     * Establece el tamaño de este vector. Si el nuevo tamaño es mayor que el
     * tamaño actual, nullse agregarán nuevos elementos al final del vector. Si
     * el nuevo tamaño es menor que el tamaño actual, todos los componentes del
     * índice newSizey mayores se descartan.
     *
     * @param nuevoTamanio el nuevo tamaño de este vector
     */
    public void establecerTamanio(int nuevoTamanio) {
        this.listadoElementos.setSize(nuevoTamanio);
    }

    /**
     * Compara el objeto especificado con este vector para la igualdad. Devuelve
     * verdadero si y solo si el objeto especificado también es una lista, ambas
     * listas tienen el mismo tamaño y todos los pares correspondientes de
     * elementos en las dos listas son iguales . (Dos elementos e1y e2son
     * iguales si (e1==null ? e2==null : e1.equals(e2))). En otras palabras, dos
     * listas se definen como iguales si contienen los mismos elementos en el
     * mismo orden.
     *
     * @param objeto El objeto a comparar por igualdad con este Vector
     * @return verdadero si el Objeto especificado es igual a este Vector
     */
    @Override
    public boolean igual(Object objeto) {
        return this.listadoElementos.equals(objeto);
    }

    /**
     * Devuelve el índice de la primera aparición del elemento especificado en
     * esta lista, o -1 si esta lista no contiene el elemento. Más formalmente,
     * devuelve el índice más bajo i tal que (objeto == null? Get (i) == null:
     * objeto.equals (get (i))) , o -1 si no hay tal índice.
     *
     * @param objeto elemento para buscar
     * @return el índice de la primera aparición del elemento especificado en
     * esta lista, o -1 si esta lista no contiene el elemento
     */
    @Override
    public int indiceDe(Object objeto) {
        return this.listadoElementos.indexOf(objeto);
    }

    /**
     * Devuelve el índice de la primera aparición del elemento especificado en
     * este vector, buscando hacia delante desde indice, o devuelve -1 si el
     * elemento no se encuentra. Más formalmente, devuelve el índice más bajo de
     * imodo que (i> = índice && (objeto == null? Get (i) == nulo: objeto.equals
     * (get (i)))) , o -1 si no hay tal índice .
     *
     * @param objeto elemento para buscar
     * @param indice índice para comenzar a buscar desde
     * @return el índice de la primera aparición del elemento en este vector en
     * posición indice más tarde en el vector; -1 si el elemento no se encuentra
     */
    public int indiceDe(Object objeto, int indice) {
        return this.listadoElementos.indexOf(objeto, indice);
    }

    /**
     * Inserta el objeto especificado como un componente en este vector en el
     * especificado indice. Cada componente en este vector con un índice mayor o
     * igual al especificado indice se desplaza hacia arriba para tener un
     * índice uno mayor que el valor que tenía previamente. El índice debe ser
     * un valor mayor o igual que, 0 y menor o igual que el tamaño actual del
     * vector. (Si el índice es igual al tamaño actual del vector, el nuevo
     * elemento se agrega al Vector).
     *
     * Este método es idéntico en funcionalidad al agregar int, E) método (que
     * es parte de la interfaz Lista). Tenga en cuenta que el método agregar
     * invierte el orden de los parámetros para que coincida más con el uso del
     * arreglo.
     *
     * @param objeto el componente para insertar
     * @param indice dónde insertar el nuevo componente
     */
    public void insertarElementoEn(E objeto, int indice) {
        this.listadoElementos.insertElementAt(objeto, indice);
    }

    /**
     * Devuelve un iterador sobre los elementos en esta lista en la secuencia
     * correcta.
     *
     * @return un iterador sobre los elementos en esta lista en la secuencia
     * correcta
     */
    /**
     * Devuelve un iterador sobre los elementos en esta lista en la secuencia
     * correcta.
     *
     * @return un iterador sobre los elementos en esta lista en la secuencia
     * correcta
     */
    @Override
    public Iterator<E> iterador() {
        return this.listadoElementos.iterator();
    }

    /**
     * Devuelve un iterador de lista sobre los elementos en esta lista (en la
     * secuencia correcta).
     *
     * @return un iterador de lista sobre los elementos en esta lista (en la
     * secuencia correcta)
     */
    @Override
    public ListIterator<E> iteradorLista() {
        return this.listadoElementos.listIterator();
    }

    /**
     * Devuelve un iterador de lista sobre los elementos en esta lista (en la
     * secuencia correcta), comenzando en la posición especificada en la lista.
     * El índice especificado indica el primer elemento que sería devuelto por
     * una llamada inicial al siguiente. Una llamada inicial previous devolvería el
     * elemento con el índice especificado menos uno.
     *
     * @param indice índice del primer elemento que se devolverá desde el
     * iterador de la lista (mediante una llamada al siguiente)
     * @return un iterador de lista sobre los elementos en esta lista (en la
     * secuencia correcta), comenzando en la posición especificada en la lista
     */
    @Override
    public ListIterator<E> iteradorLista(int indice) {
        return this.listadoElementos.listIterator(indice);
    }

    /**
     * Crea un IteradorSpl sobre los elementos en esta lista. Los
     * Spliteratorinformes Spliterator.SIZEDy Spliterator.ORDERED. Las
     * implementaciones deberían documentar el informe de valores
     * característicos adicionales.
     *
     * @return un IteradorSpl sobre los elementos en esta lista
     */
    @Override
    public Spliterator<E> iteradorSpl() {
        return this.listadoElementos.spliterator();
    }

    /**
     * Elimina todos los elementos de este Vector. El Vector estará vacío
     * después de que regrese esta llamada (a menos que arroje una excepción).
     */
    @Override
    public void limpiar() {
        this.listadoElementos.clear();
    }

    /**
     * Devuelve el elemento en la posición especificada en este Vector.
     *
     * @param indice índice del elemento a devolver
     * @return objeto en el índice especificado
     */
    @Override
    public E obtener(int indice) {
        return this.listadoElementos.get(indice);
    }

    /**
     * Ordena esta lista según el orden inducido por el especificado Comparator.
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
    @Override
    public void ordenar(Comparator<? super E> comparador) {
        this.listadoElementos.sort(comparador);
    }

    /**
     * Realiza la acción dada para cada elemento de la Iterable hasta que todos
     * los elementos hayan sido procesados ​​o la acción arroje una excepción. A
     * menos que la clase de implementación especifique lo contrario, las
     * acciones se realizan en el orden de iteración (si se especifica una orden
     * de iteración). Las excepciones lanzadas por la acción se transmiten a la
     * persona que llama.
     *
     * @param accion la acción a realizar para cada elemento
     */
    public void paraCada(Consumer<? super E> accion) {
        this.listadoElementos.forEach(accion);
    }

    /**
     * Devuelve el primer componente (el elemento en el índice 0) de este
     * vector.
     *
     * @return el primer componente de este vector
     */
    public E primerElemento() {
        return this.listadoElementos.firstElement();
    }

    /**
     * Recorta la capacidad de este vector para ser el tamaño actual del vector.
     * Si la capacidad de este vector es mayor que su tamaño actual, entonces la
     * capacidad se cambia para igualar el tamaño reemplazando su matriz de
     * datos interna, mantenida en el campo elementData, por una más pequeña.
     * Una aplicación puede usar esta operación para minimizar el almacenamiento
     * de un vector.
     */
    public void recortarATamanio() {
        this.listadoElementos.trimToSize();
    }

    /**
     * Reemplaza cada elemento de esta lista con el resultado de aplicar el
     * operador a ese elemento. Los errores o excepciones de tiempo de ejecución
     * lanzados por el operador se transmiten a la persona que llama.
     *
     * @param operador el operador para aplicar a cada elemento
     */
    @Override
    public void reemplazarTodo(UnaryOperator<E> operador) {
        this.listadoElementos.replaceAll(operador);
    }

    /**
     * Quita el elemento en la posición especificada en este Vector. Cambia
     * cualquier elemento posterior a la izquierda (resta uno de sus índices).
     * Devuelve el elemento que se eliminó del Vector.
     *
     * @param indice el índice del elemento a eliminar
     * @return elemento que se eliminó
     */
    @Override
    public E remover(int indice) {
        return this.listadoElementos.remove(indice);
    }

    /**
     * Elimina la primera aparición del elemento especificado en este Vector. Si
     * el Vector no contiene el elemento, no cambia. Más formalmente, elimina el
     * elemento con el índice más bajo i tal que (objeto==null ? get(i)==null :
     * objeto.equals(get(i)))(si tal elemento existe).
     *
     * @param objeto elemento que se eliminará de este Vector, si está presente
     * @return verdadero si el Vector contenía el elemento especificado
     */
    @Override
    public boolean remover(Object objeto) {
        return this.listadoElementos.remove(objeto);
    }

    /**
     * Elimina la primera aparición (más indexada) del argumento de este vector.
     * Si el objeto se encuentra en este vector, cada componente en el vector
     * con un índice mayor o igual al índice del objeto se desplaza hacia abajo
     * para tener un índice uno más pequeño que el valor que tenía previamente.
     * Este método es idéntico en funcionalidad al remover(Object)método (que es
     * parte de la interfaz Lista).
     *
     * @param objeto el componente que se eliminará
     * @return verdadero si el argumento era un componente de este vector; falso
     * de otra manera.
     */
    public boolean removerElemento(Object objeto) {
        return this.listadoElementos.removeElement(objeto);
    }

    /**
     * Elimina el componente en el índice especificado. Cada componente en este
     * vector con un índice mayor o igual al especificado indexse desplaza hacia
     * abajo para tener un índice uno más pequeño que el valor que tenía
     * previamente. El tamaño de este vector se reduce en 1. El índice debe ser
     * un valor mayor o igual que 0 y menor que el tamaño actual del vector.
     *
     * Este método es idéntico en funcionalidad al remove(int) método (que es
     * parte de la interfaz Lista). Tenga en cuenta que el removemétodo devuelve
     * el valor anterior que se almacenó en la posición especificada.
     *
     * @param indice el índice del objeto para eliminar
     */
    public void removerElementoEn(int indice) {
        this.listadoElementos.removeElementAt(indice);
    }

    /**
     * Elimina todos los elementos de esta colección que satisfacen el predicado
     * dado. Los errores o las excepciones de tiempo de ejecución lanzadas
     * durante la iteración o por el predicado se transmiten a la persona que
     * llama.
     *
     * @param filtro un predicado que devuelve trueelementos que se eliminarán
     * @return verdadero si se eliminó algún elemento
     */
    public boolean removerSi(Predicate<? super E> filtro) {
        return this.listadoElementos.removeIf(filtro);
    }

    /**
     * Elimina de este vector todos sus elementos que están contenidos en la
     * colección especificada (operación opcional).
     *
     * @param coleccion colección que contiene elementos para eliminar de este
     * vector
     * @return verdadero si este vector cambió como resultado de la llamada
     */
    @Override
    public boolean removerTodo(Collection<?> coleccion) {
        return this.listadoElementos.removeAll(coleccion);
    }

    /**
     * Elimina todos los componentes de este vector y establece su tamaño en
     * cero. Este método es idéntico en funcionalidad al limpiar() método (que
     * es parte de la interfaz Lista).
     */
    public void removerTodosLosElementos() {
        this.listadoElementos.removeAllElements();
    }

    /**
     * Devuelve una vista de la parte de esta lista entre el índice especificado
     * , inclusive, y toIndex , exclusivo. (Si fromIndex y toIndex son iguales,
     * la lista devuelta está vacía.) La lista devuelta está respaldada por esta
     * lista, por lo que los cambios no estructurales en la lista devuelta se
     * reflejan en esta lista, y viceversa. La lista devuelta admite todas las
     * operaciones de lista opcionales admitidas por esta lista. Este método
     * elimina la necesidad de operaciones de rango explícitas (del tipo que
     * comúnmente existe para las matrices). Cualquier operación que espera una
     * lista se puede usar como una operación de rango al pasar una vista
     * sublista en lugar de una lista completa. Por ejemplo, el siguiente
     * modismo elimina un rango de elementos de una lista:
     *
     *
     * lista.subLista(desde, hasta).limpiar();
     *
     * Se pueden construir expresiones idiomáticas similares para indexOf y
     * lastIndexOf , y todos los algoritmos de la clase Collections se pueden
     * aplicar a una subList. La semántica de la lista devuelta por este método
     * queda indefinida si la lista de respaldo (es decir, esta lista) se
     * modifica estructuralmente de cualquier manera que no sea a través de la
     * lista devuelta. (Las modificaciones estructurales son aquellas que
     * cambian el tamaño de esta lista o la perturban de tal manera que las
     * iteraciones en progreso pueden arrojar resultados incorrectos).
     *
     * @param desdeIndice punto final bajo (inclusive) de la sublista
     * @param hastaIndice punto final alto (exclusivo) de la sublista
     * @return una vista del rango especificado dentro de esta lista
     */
    @Override
    public List<E> subLista(int desdeIndice, int hastaIndice) {
        return this.listadoElementos.subList(desdeIndice, hastaIndice);
    }

    /**
     * Devuelve la cantidad de componentes en este vector.
     *
     * @return la cantidad de componentes en este vector
     */
    @Override
    public int tamanio() {
        return this.listadoElementos.size();
    }

    /**
     * Devuelve el último componente del vector.
     *
     * @return el último componente del vector, es decir, el componente en el
     * índice tamanio() - 1.
     */
    public E ultimoElemento() {
        return this.listadoElementos.lastElement();
    }

    /**
     * Devuelve el índice de la última aparición del elemento especificado en
     * esta lista, o -1 si esta lista no contiene el elemento. Más formalmente,
     * devuelve el índice más alto i tal que (objeto == null? Get (i) == null:
     * objeto.equals (get (i))) , o -1 si no hay tal índice.
     *
     * @param objeto elemento para buscar
     * @return el índice de la última aparición del elemento especificado en
     * este vector, o -1 si este vector no contiene el elemento
     */
    @Override
    public int ultimoIndiceDe(Object objeto) {
        return this.listadoElementos.lastIndexOf(objeto);
    }

    /**
     * Devuelve el índice de la última aparición del elemento especificado en
     * este vector, buscando hacia atrás desde indice, o devuelve -1 si el
     * elemento no se encuentra. Más formalmente, devuelve el índice más alto de
     * imodo que (i <= índice && (objeto == null? Get (i) == nulo: objeto.equals
     * (get (i)))) , o -1 si no hay dicho índice.
     *
     * @param objeto elemento para buscar
     * @param indice índice para comenzar a buscar hacia atrás desde
     * @return
     */
    public int ultimoIndiceDe(Object objeto, int indice) {
        return this.listadoElementos.lastIndexOf(objeto, indice);
    }

}
