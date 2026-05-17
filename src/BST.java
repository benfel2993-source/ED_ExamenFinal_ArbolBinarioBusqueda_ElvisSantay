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

        if (actual == null) {
            return new Nodo(valor);
        }

        if (valor < actual.valor) {
            actual.izquierda = insertarRec(actual.izquierda, valor);
        } else if (valor > actual.valor) {
            actual.derecha = insertarRec(actual.derecha, valor);
        }

        return actual;
    }

    // =========================
    // BUSCAR
    // =========================
    public boolean search(int valor) {
        return searchRec(raiz, valor);
    }

    private boolean searchRec(Nodo actual, int valor) {

        if (actual == null) return false;

        if (actual.valor == valor) return true;

        if (valor < actual.valor) {
            return searchRec(actual.izquierda, valor);
        } else {
            return searchRec(actual.derecha, valor);
        }
    }

    // =========================
    // ELIMINAR
    // =========================
    public void delete(int valor) {
        raiz = deleteRec(raiz, valor);
    }

    private Nodo deleteRec(Nodo actual, int valor) {

        if (actual == null) return null;

        if (valor < actual.valor) {
            actual.izquierda = deleteRec(actual.izquierda, valor);
        } else if (valor > actual.valor) {
            actual.derecha = deleteRec(actual.derecha, valor);
        } else {

            // CASO 1: sin hijos
            if (actual.izquierda == null && actual.derecha == null) {
                return null;
            }

            // CASO 2: un hijo
            if (actual.izquierda == null) {
                return actual.derecha;
            } else if (actual.derecha == null) {
                return actual.izquierda;
            }

            // CASO 3: dos hijos
            Nodo sucesor = findMin(actual.derecha);
            actual.valor = sucesor.valor;
            actual.derecha = deleteRec(actual.derecha, sucesor.valor);
        }

        return actual;
    }

    private Nodo findMin(Nodo nodo) {
        while (nodo.izquierda != null) {
            nodo = nodo.izquierda;
        }
        return nodo;
    }

    // =========================
    // RECORRIDOS
    // =========================

    // InOrder: Izquierda - Raíz - Derecha
    public void inOrder() {
        inOrderRec(raiz);
        System.out.println();
    }

    private void inOrderRec(Nodo actual) {
        if (actual != null) {
            inOrderRec(actual.izquierda);
            System.out.print(actual.valor + " ");
            inOrderRec(actual.derecha);
        }
    }

    // PreOrder: Raíz - Izquierda - Derecha
    public void preOrder() {
        preOrderRec(raiz);
        System.out.println();
    }

    private void preOrderRec(Nodo actual) {
        if (actual != null) {
            System.out.print(actual.valor + " ");
            preOrderRec(actual.izquierda);
            preOrderRec(actual.derecha);
        }
    }

    // PostOrder: Izquierda - Derecha - Raíz
    public void postOrder() {
        postOrderRec(raiz);
        System.out.println();
    }

    private void postOrderRec(Nodo actual) {
        if (actual != null) {
            postOrderRec(actual.izquierda);
            postOrderRec(actual.derecha);
            System.out.print(actual.valor + " ");
        }
    }
}