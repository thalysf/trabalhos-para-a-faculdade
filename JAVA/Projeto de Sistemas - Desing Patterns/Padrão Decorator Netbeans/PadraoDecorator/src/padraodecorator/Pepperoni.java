package padraodecorator;

public class Pepperoni extends PizzaDecorator{
    
    public Pepperoni(Pizza pizza) {
        super(pizza);
        this.nome = "Pepperoni";
        this.preco = 4D;
    }
    
}
