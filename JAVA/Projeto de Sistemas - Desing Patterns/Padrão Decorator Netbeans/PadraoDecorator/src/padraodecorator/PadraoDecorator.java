package padraodecorator;

/** 
 * @authores thalys fabrete, alexandre borlini, pedro mariano, vitor zani.
 */
public abstract class PadraoDecorator {


    public static void main(String[] args) {
        Pizza pizza = new MolhoTomate();
        pizza = new Frango(pizza);
        pizza = new Palmito(pizza);
        pizza = new Pepperoni(pizza);
        pizza = new Queijo(pizza);
        System.out.println(String.format("Sua pizza: %s | Preço: R$ %.2f", pizza.getNome(), pizza.getPreco()));
    }
    
}
