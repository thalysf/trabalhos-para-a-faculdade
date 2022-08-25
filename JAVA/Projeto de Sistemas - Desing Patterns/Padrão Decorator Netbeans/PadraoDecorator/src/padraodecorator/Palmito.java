package padraodecorator;


public class Palmito extends PizzaDecorator{
    
    public Palmito(Pizza pizza) {
        super(pizza);
        this.nome = "Palmito";
        this.preco = 0.5;
    }
    
}
