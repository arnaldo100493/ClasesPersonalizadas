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
import java.util.List;
import java.util.ListIterator;
import java.util.Spliterator;
import java.util.Vector;
import java.util.function.UnaryOperator;

/**
 *
 * @author FABAME
 */
public class ListaVector<E> implements Lista<E>, Serializable {

    private static final long serialVersionUID = 5663581639854647775L;

    private final Vector<E> listadoElementos;

    public ListaVector() {
        this.listadoElementos = new Vector<>();
    }

    /**
     * Devuelve un arreglo que contiene todos los elementos de esta lista en la
     * secuencia correcta (del primer al último elemento). El arreglo devuelta
     * será "seguro" ya que esta lista no mantiene ninguna referencia a ella.
     * (En otras palabras, este método debe asignar una nueva matriz). La
     * persona que llama es libre de modificar el vector devuelta.
     *
     * Este método actúa como puente entre las API basadas en arreglos y basados
     * en arreglos.
     *
     * @return un arreglo que contiene todos los elementos en esta lista en la
     * secuencia correcta
     */
    @Override
    public Object[] aArreglo() {
        return this.listadoElementos.toArray();
    }

    /**
     * Devuelve un arreglo que contiene todos los elementos de esta lista en la
     * secuencia correcta (del primer al último elemento); el tipo de tiempo de
     * ejecución de la arreglo devuelta es el del arreglo especificado. Si la
     * lista se ajusta al arreglo especificado, se devuelve allí. De lo
     * contrario, se asigna un nuevo arreglo con el tipo de tiempo de ejecución
     * del arreglo especificado y el tamaño de esta lista. Si la lista cabe en
     * el arreglo especificado con espacio de sobra (es decir, el arreglo tiene
     * más elementos que la lista), el elemento en el arreglo inmediatamente
     * después del final de la colección se establece en nulo . (Esto es útil
     * para determinar la longitud de la lista solo si la persona que llama sabe
     * que la lista no contiene ningún elemento nulo). Al igual que el
     * aArreglo()método, este método actúa como puente entre las API basadas en
     * matrices y las basadas en colecciones. Además, este método permite un
     * control preciso sobre el tipo de tiempo de ejecución del arreglo de
     * salida y, en determinadas circunstancias, puede utilizarse para ahorrar
     * costos de asignación.
     *
     * Supongamos que x se sabe que una lista solo contiene cadenas. El
     * siguiente código se puede usar para volcar la lista en un arreglo recién
     * asignado de String:
     *
     * String [] y = x.aArreglo (new String [0]); Tenga en cuenta que
     * aArreglo(new Object[0])es idéntica en función a aArreglo().
     *
     * @param <T> el tipo de elementos contenidos en este vector
     * @param arreglo el arreglo en la que se almacenarán los elementos de la
     * lista, si es lo suficientemente grande; de lo contrario, se asigna un
     * nuevo arreglo del mismo tipo de tiempo de ejecución para este fin
     * @return un arreglo que contiene los elementos de la lista
     */
    @Override
    public <T> T[] aArreglo(T[] arreglo) {
        return this.listadoElementos.toArray(arreglo);
    }

    /**
     * Agrega el elemento especificado al final de esta lista (operación
     * opcional). Las listas que admiten esta operación pueden imponer
     * limitaciones a los elementos que se pueden agregar a esta lista. En
     * particular, algunas listas rechazarán agregar elementos nulos, y otras
     * impondrán restricciones sobre el tipo de elementos que pueden agregarse.
     * Las clases de la lista deben especificar claramente en su documentación
     * cualquier restricción sobre qué elementos se pueden agregar.
     *
     * @param elemento elemento que se adjuntará a esta lista
     * @return verdadero (como se especifica por Collection.add(E))
     */
    @Override
    public boolean agregar(E elemento) {
        return this.listadoElementos.add(elemento);
    }

    /**
     * Inserta el elemento especificado en la posición especificada en esta
     * lista (operación opcional). Cambia el elemento actualmente en esa
     * posición (si existe) y cualquier elemento posterior a la derecha (agrega
     * uno a sus índices).
     *
     * @param indice índice en el que se debe insertar el elemento especificado
     * @param elemento elemento a insertar
     */
    @Override
    public void agregar(int indice, E elemento) {
        this.listadoElementos.add(indice, elemento);
    }

    /**
     * Agrega todos los elementos de la colección especificada al final de esta
     * lista, en el orden en que son devueltos por el iterador de la colección
     * especificada (operación opcional). El comportamiento de esta operación no
     * está definido si la colección especificada se modifica mientras la
     * operación está en progreso. (Tenga en cuenta que esto ocurrirá si la
     * colección especificada es esta lista y no está vacía).
     *
     * @param coleccion colección que contiene elementos para agregar a esta
     * lista
     * @return verdadero si esta lista cambió como resultado de la llamada
     */
    @Override
    public boolean agregarTodo(Collection<? extends E> coleccion) {
        return this.listadoElementos.addAll(coleccion);
    }

    /**
     * Inserta todos los elementos en la colección especificada en esta lista en
     * la posición especificada (operación opcional). Cambia el elemento
     * actualmente en esa posición (si existe) y cualquier elemento posterior a
     * la derecha (aumenta sus índices). Los nuevos elementos aparecerán en esta
     * lista en el orden en que son devueltos por el iterador de la colección
     * especificada. El comportamiento de esta operación no está definido si la
     * colección especificada se modifica mientras la operación está en
     * progreso. (Tenga en cuenta que esto ocurrirá si la colección especificada
     * es esta lista y no está vacía).
     *
     * @param indice índice en el que insertar el primer elemento de la
     * colección especificada
     * @param coleccion colección que contiene elementos para agregar a esta
     * lista
     * @return verdadero si esta lista cambió como resultado de la llamada
     */
    @Override
    public boolean agregarTodo(int indice, Collection<? extends E> coleccion) {
        return this.listadoElementos.addAll(indice, coleccion);
    }

    /**
     * Devuelve una copia superficial de esta Lista. (Los elementos en sí mismos
     * no están clonados).
     *
     * @return una copia superficial de esta Lista.
     */
    @Override
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
    @Override
    public int codigoHash() {
        return this.listadoElementos.hashCode();
    }

    /**
     * Retiene solo los elementos en esta lista que están contenidos en la
     * colección especificada (operación opcional). En otras palabras, elimina
     * de esta lista todos sus elementos que no están contenidos en la colección
     * especificada.
     *
     * @param coleccion colección que contiene elementos para ser retenidos en
     * esta lista
     * @return verdadero si esta lista cambió como resultado de la llamada
     */
    @Override
    public boolean conservarTodo(Collection<?> coleccion) {
        return this.listadoElementos.retainAll(coleccion);
    }

    /**
     * Devuelve verdadero si esta lista contiene el elemento especificado. Más
     * formalmente, devuelve verdadero si y solo si esta lista contiene al menos
     * un elemento e tal que (objeto == null? E == null: objeto.equals (e)) .
     *
     * @param objeto elemento cuya presencia en esta lista debe probarse
     * @return verdadero si esta lista contiene el elemento especificado
     */
    @Override
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
    @Override
    public boolean contieneTodo(Collection<?> coleccion) {
        return this.listadoElementos.containsAll(coleccion);
    }

    /**
     * Devuelve verdadero si esta lista no contiene elementos.
     *
     * @return verdadero si esta lista no contiene elementos
     */
    @Override
    public boolean estaVacia() {
        return this.listadoElementos.isEmpty();
    }

    /**
     * Reemplaza el elemento en la posición especificada en esta lista con el
     * elemento especificado (operación opcional).
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
     * Devuelve un iterador sobre los elementos en esta lista en la secuencia
     * correcta.
     *
     * @return un iterador sobre los elementos en esta lista en la secuencia
     * correcta
     */
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
    @Override
    public boolean igual(Object objeto) {
        return this.listadoElementos.equals(objeto);
    }

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
     * una llamada inicial a next. Una llamada inicial previousdevolvería el
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
     * Elimina todos los elementos de esta lista (operación opcional). La lista
     * estará vacía después de que regrese esta llamada.
     */
    @Override
    public void limpiar() {
        this.listadoElementos.clear();
    }

    /**
     * Devuelve el elemento en la posición especificada en esta lista
     *
     * @param indice índice del elemento a devolver
     * @return el elemento en la posición especificada en esta lista
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
     * Quita el elemento en la posición especificada en esta lista (operación
     * opcional). Cambia cualquier elemento posterior a la izquierda (resta uno
     * de sus índices). Devuelve el elemento que se eliminó de la lista.
     *
     * @param indice el índice del elemento a eliminar
     * @return el elemento previamente en la posición especificada
     */
    @Override
    public E remover(int indice) {
        return this.listadoElementos.remove(indice);
    }

    /**
     * Elimina la primera aparición del elemento especificado de esta lista, si
     * está presente (operación opcional). Si esta lista no contiene el
     * elemento, no se modifica. Más formalmente, elimina el elemento con el
     * índice más bajo i tal que (object == null? Get (i) == null: object.equals
     * (get (i))) (si tal elemento existe). Devuelve true si esta lista contiene
     * el elemento especificado (o de manera equivalente, si esta lista cambió
     * como resultado de la llamada).
     *
     * @param objeto elemento que se eliminará de esta lista, si está presente
     * @return verdadero si esta lista contiene el elemento especificado
     */
    @Override
    public boolean remover(Object objeto) {
        return this.listadoElementos.remove(objeto);
    }

    /**
     * Elimina de esta lista todos sus elementos que están contenidos en la
     * colección especificada (operación opcional).
     *
     * @param coleccion colección que contiene elementos para eliminar de esta
     * lista
     * @return verdadero si esta lista cambió como resultado de la llamada
     */
    @Override
    public boolean removerTodo(Collection<?> coleccion) {
        return this.listadoElementos.removeAll(coleccion);
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
     * Devuelve la cantidad de elementos en esta lista. Si esta lista contiene
     * más de elementos Integer.MAX_VALUE , devuelve Integer.MAX_VALUE .
     *
     * @return la cantidad de elementos en esta lista
     */
    @Override
    public int tamanio() {
        return this.listadoElementos.size();
    }

    /**
     * Devuelve el índice de la última aparición del elemento especificado en
     * esta lista, o -1 si esta lista no contiene el elemento. Más formalmente,
     * devuelve el índice más alto i tal que (objeto == null? Get (i) == null:
     * objeto.equals (get (i))) , o -1 si no hay tal índice.
     *
     * @param objeto
     * @return
     */
    @Override
    public int ultimoIndiceDe(Object objeto) {
        return this.listadoElementos.lastIndexOf(objeto);
    }

}
