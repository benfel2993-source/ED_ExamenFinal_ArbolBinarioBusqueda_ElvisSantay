public class Main {
    public static void main(String[] args) {

        BST arbol = new BST();

        // INSERT
        arbol.insert(50);
        arbol.insert(30);
        arbol.insert(70);
        arbol.insert(20);
        arbol.insert(40);
        arbol.insert(60);
        arbol.insert(80);

        // SEARCH
        System.out.println("Buscar 40: " + arbol.search(40));
        System.out.println("Buscar 100: " + arbol.search(100));

        // DELETE
        arbol.delete(20);
        arbol.delete(30);
        arbol.delete(50);

        // RECORRIDOS
        System.out.println("InOrder:");
        arbol.inOrder();

        System.out.println("PreOrder:");
        arbol.preOrder();

        System.out.println("PostOrder:");
        arbol.postOrder();

        System.out.println("Árbol completo funcionando");
    }
}