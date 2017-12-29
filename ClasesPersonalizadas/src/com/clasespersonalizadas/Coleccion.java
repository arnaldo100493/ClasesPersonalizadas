/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clasespersonalizadas;

import java.util.Collection;
import java.util.Iterator;

/**
 *
 * @author FABAME
 */
/**
 * Interfaz para guardar y manipular elementos en una coleción.
 *
 * @param <E> el tipo de elementos contenidos en esta colección
 */
public interface Coleccion<E> {

    /**
     * Devuelve un arreglo que contiene todos los elementos de esta colección.
     * Si esta colección hace alguna garantía en cuanto a qué orden sus
     * elementos son devueltos por su iterador, este método debe devolver los
     * elementos en el mismo orden. El arreglo devuelto será "seguro" ya que
     * esta colección no mantiene referencias a este arreglo. (En otras
     * palabras, este método debe asignar un nuevo arreglo incluso si esta
     * colección está respaldada por un arreglo). La persona que llama es libre
     * de modificar el arreglo devuelto.
     *
     * Este método actúa como puente entre las API basadas en arreglos y basadas
     * en arreglos.
     *
     * @return un arreglo que contiene todos los elementos de esta colección
     */
    public Object[] aArreglo();

    /**
     * Devuelve un arreglo que contiene todos los elementos de esta colección;
     * el tipo de tiempo de ejecución del arreglo devuelto es el de del arreglo
     * especificado. Si la colección se ajusta a el arreglo especificado, se
     * devuelve allí. De lo contrario, se asigna un nuevo arreglo con el tipo de
     * tiempo de ejecución del arreglo especificada y el tamaño de esta
     * colección. Si esta colección se ajusta a el arreglo especificado con
     * espacio de sobra (es decir, el arreglo tiene más elementos que esta
     * colección), el elemento en el arreglo inmediatamente después del final de
     * la colección se establece en nulo . (Esto es útil para determinar la
     * longitud de esta colección solo si la persona que llama sabe que esta
     * colección no contiene ningún elemento nulo ).
     *
     * Si esta colección hace alguna garantía en cuanto a qué orden sus
     * elementos son devueltos por su iterador, este método debe devolver los
     * elementos en el mismo orden.
     *
     * Al igual que el método aArreglo(), este método actúa como puente entre
     * las API basadas en arreglos y las basadas en colecciones. Además, este
     * método permite un control preciso sobre el tipo de tiempo de ejecución de
     * la matriz de salida y, en determinadas circunstancias, puede utilizarse
     * para ahorrar costos de asignación.
     *
     * Supongamos que x es una colección conocida por contener solo cadenas. El
     * siguiente código se puede usar para volcar la colección en un arreglo
     * recientemente asignada de Cadena :
     *
     * String [] y = x.aArreglo (new String [0]); Tenga en cuenta que aArreglo
     * (new Object [0]) es idéntico en función a aArreglo () .
     *
     * @param <T> el tipo de elementos contenidos en este arreglo
     * @param arreglo el arreglo en la que se almacenarán los elementos de esta
     * colección, si es lo suficientemente grande; de lo contrario, se asigna
     * uno nuevo arreglo del mismo tipo de tiempo de ejecución para este fin.
     * @return un arreglo que contiene todos los elementos de esta colección
     */
    public <T> T[] aArreglo(T[] arreglo);

    /**
     * Se asegura de que esta colección contenga el elemento especificado
     * (operación opcional). Devuelve verdadero si esta colección cambió como
     * resultado de la llamada. (Devuelve falso si esta colección no permite
     * duplicados y ya contiene el elemento especificado). Las colecciones que
     * admiten esta operación pueden imponer limitaciones a los elementos que se
     * pueden agregar a esta colección. En particular, algunas colecciones se
     * negarán a agregar elementos nulos , y otras impondrán restricciones sobre
     * el tipo de elementos que pueden agregarse. Las clases de colección deben
     * especificar claramente en su documentación cualquier restricción sobre
     * qué elementos se pueden agregar.
     *
     * Si una colección se niega a agregar un elemento en particular por
     * cualquier motivo que no sea el que ya contiene el elemento, debe lanzar
     * una excepción (en lugar de devolver falso ). Esto preserva la invariante
     * de que una colección siempre contiene el elemento especificado después de
     * que esta llamada regrese.
     *
     * @param elemento elemento cuya presencia en esta colección debe
     * garantizarse
     * @return verdadero si esta colección cambió como resultado de la llamada
     */
    public boolean agregar(E elemento);

    /**
     * Agrega todos los elementos en la colección especificada a esta colección
     * (operación opcional). El comportamiento de esta operación no está
     * definido si la colección especificada se modifica mientras la operación
     * está en progreso. (Esto implica que el comportamiento de esta llamada no
     * está definido si la colección especificada es esta colección, y esta
     * colección no está vacía).
     *
     * @param coleccion colección que contiene elementos para agregar a esta
     * colección
     * @return verdadero si esta colección cambió como resultado de la llamada
     */
    public boolean agregarTodo(Collection<? extends E> coleccion);

    /**
     * Devuelve el valor del código hash para esta colección. Si bien la
     * interfaz de Colección no agrega ninguna estipulación al contrato general
     * para el método Object.hashCode , los programadores deben tener en cuenta
     * que cualquier clase que anule el método Object.equals también debe anular
     * el método Object.hashCode para satisfacer el contrato general del objeto.
     * método .hashCode . En particular, c1.equals (c2) implica que c1.hashCode
     * () == c2.hashCode () .
     *
     * @return el valor del código hash para esta colección
     */
    public int codigoHash();

    /**
     * Retiene solo los elementos en esta colección que están contenidos en la
     * colección especificada (operación opcional). En otras palabras, elimina
     * de esta colección todos sus elementos que no están contenidos en la
     * colección especificada.
     *
     * @param coleccion colección que contiene elementos para ser retenidos en
     * esta colección
     * @return verdadero si esta colección cambió como resultado de la llamada
     */
    public boolean conservarTodo(Collection<?> coleccion);

    /**
     * Devuelve verdadero si esta colección contiene el elemento especificado.
     * Más formalmente, devuelve verdadero si y solo si esta colección contiene
     * al menos un elemento e tal que (objeto == null? E == null: objeto.equals
     * (e))
     *
     * @param objeto elemento cuya presencia en esta colección debe probarse
     * @return verdadero si esta colección contiene el elemento especificado
     */
    public boolean contiene(Object objeto);

    /**
     * Devuelve verdadero si esta colección contiene todos los elementos en la
     * colección especificada.
     *
     * @param coleccion colección a verificar para contener en esta colección
     * @return verdadero si esta colección contiene todos los elementos en la
     * colección especificada
     */
    public boolean contieneTodo(Collection<?> coleccion);

    /**
     * Devuelve verdadero si esta colección no contiene elementos.
     *
     * @return verdadero si esta colección no contiene elementos
     */
    public boolean estaVacia();

    /**
     * Compara el objeto especificado con esta colección para la igualdad.
     * Mientras que la interfaz de Colección no agrega estipulaciones al
     * contrato general para Object.equals , los programadores que implementan
     * la interfaz de Colección "directamente" (en otras palabras, crean una
     * clase que es una Colección pero no es un Conjunto o una Lista ) deben
     * tener cuidado si eligen anular los Object.equals . No es necesario
     * hacerlo, y el curso de acción más simple es confiar en la implementación
     * de Object , pero el implementador puede desear implementar una
     * "comparación de valores" en lugar de la "comparación de referencia"
     * predeterminada. (La lista y el conjunto las interfaces requieren tales
     * comparaciones de valores.)
     *
     * El contrato general para el método Object.equals establece que los
     * iguales deben ser simétricos (en otras palabras, a.equals (b) si y solo
     * si b.equals (a) ). Los contratos para List.equals y Set.equals establecen
     * que las listas solo son iguales a otras listas y se establecen en otros
     * conjuntos. Por lo tanto, un método de igual a medida para una clase de
     * colección que implementa ni la interfaz List ni Set debe devolver false
     * cuando esta colección se compara con cualquier lista o conjunto. (Por la
     * misma lógica, no es posible escribir una clase que implemente
     * correctamente tanto el Conjunto como la Lista interfaces)
     *
     * @param objeto objeto a comparar por igualdad con esta colección
     * @return verdadero si el objeto especificado es igual a esta colección
     */
    public boolean igual(Object objeto);

    /**
     * Devuelve un iterador sobre los elementos en esta colección. No hay
     * garantías sobre el orden en que se devuelven los elementos (a menos que
     * esta colección sea una instancia de alguna clase que proporcione una
     * garantía).
     *
     * @return un iterador sobre los elementos de esta colección
     */
    public Iterator<E> iterador();

    /**
     * Elimina todos los elementos de esta colección (operación opcional). La
     * colección estará vacía después de que regrese este método.
     */
    public void limpiar();

    /**
     * Elimina una sola instancia del elemento especificado de esta colección,
     * si está presente (operación opcional). Más formalmente, elimina un
     * elemento e tal que (objeto == null? E == null: objeto.equals (e)) , si
     * esta colección contiene uno o más de tales elementos. Devuelve verdadero
     * si esta colección contenía el elemento especificado (o de manera
     * equivalente, si esta colección cambió como resultado de la llamada).
     *
     * @param objeto elemento que se eliminará de esta colección, si está
     * presente
     * @return verdadero si se eliminó un elemento como resultado de esta
     * llamada
     */
    public boolean remover(Object objeto);

    /**
     * Elimina todos los elementos de esta colección que también están
     * contenidos en la colección especificada (operación opcional). Después de
     * que esta llamada regrese, esta colección no contendrá elementos en común
     * con la colección especificada.
     *
     * @param coleccion colección que contiene elementos que se eliminarán de
     * esta colección
     * @return verdadero si esta colección cambió como resultado de la llamada
     */
    public boolean removerTodo(Collection<?> coleccion);

    /**
     * Devuelve la cantidad de elementos en esta colección. Si esta colección
     * contiene más de elementos Integer.MAX_VALUE , devuelve Integer.MAX_VALUE.
     *
     * @return la cantidad de elementos en esta colección
     */
    public int tamanio();

}
