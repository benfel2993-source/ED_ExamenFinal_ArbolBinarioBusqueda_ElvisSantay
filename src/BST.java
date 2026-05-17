class BST {

    Nodo raiz;

    public BST() {
        raiz = null;
    }

    // =========================
    // INSERTAR
    // =========================
    public void insert(int valor) {
        raiz = insertarRec(raiz, valor);
    }

    private Nodo insertarRec(Nodo actual, int valor) {

        // Caso base: espacio vacío
        if (actual == null) {
            return new Nodo(valor);
        }

        // Ir a la izquierda
        if (valor < actual.valor) {
            actual.izquierda = insertarRec(actual.izquierda, valor);
        }

        // Ir a la derecha
        else if (valor > actual.valor) {
            actual.derecha = insertarRec(actual.derecha, valor);
        }

        // devolver nodo actualizado
        return actual;
    }
}