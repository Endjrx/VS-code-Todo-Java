package manejar_texto;

public class Metodos {
    
    /*Punteros */
    private Nodo ptr_inicio;
    private NodoRegistros ptr_registro_inicio;
    private NodoRegistros ptr_registro_final;

    public Metodos () {

        this.ptr_inicio = null;
        this.ptr_registro_inicio = null;
        this.ptr_registro_final = null;

    }

    /*Metodo para agregar texto */
    public void insertarTexto (String texto) {

        Nodo nodo = new Nodo(texto);
        if (ptr_inicio == null) ptr_inicio = nodo;
        else {

            Nodo aux = ptr_inicio;
            while (true) {

                if (aux.getSiguiente() == null) break;
                aux = aux.getSiguiente();

            }

            aux.setSiguiente(nodo);

        }
        
    }


    /*Metodo para mostrar texto */
    public void mostrarTexto () {

        if (ptr_inicio == null) System.out.println("NO HAY TEXTO PARA MOSTRAR!!!");
        else {

            String aux = "";
            Nodo temp = ptr_inicio;

            while (temp != null) {

                aux += temp.getTexto();
                temp = temp.getSiguiente();

            }

            System.out.println("Texto ingresado: " + aux);
        }

    }



    /*Metodo para eliminar texto */
    public void eliminarTexto () {

        if (ptr_inicio == null) System.out.println("NO HAY TEXTO PARA ELIMINAR!!!");
        else {

            Nodo aux = ptr_inicio;
            Nodo temp = aux;

            while (true) {

                if (aux.getSiguiente() == null) {

                    /*Nodo registro auxiliar para almacenar el texto que tiene ultimo nodo de la lista de texto. */
                    NodoRegistros nodo = new NodoRegistros(aux.getTexto());
                    if (ptr_registro_inicio == null) ptr_registro_inicio = nodo;
                    else nodo.setSiguiente(ptr_registro_final);

                    ptr_registro_final = nodo;
                    
                    /*Eliminamos el dato de la lista. */
                    temp.setSiguiente(aux.getSiguiente());
                    break;

                }

                temp = aux;
                aux = aux.getSiguiente(); //Actualizamos el valor de aux para recorrer la lista.

            }


        }



    }


    /*Metodo para restablecer el texto */
    public void restablecerTexto () {

        if (ptr_registro_final == null) System.out.println("NO HAY DATOS EN EL HISTORIAL PARA RESTABLECER.");
        else {

            insertarTexto(ptr_registro_final.getTexto());
            ptr_registro_final = ptr_registro_final.getSiguiente();

        }

    }



}
