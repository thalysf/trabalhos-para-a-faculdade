package padraodecorator;

public abstract class PizzaDecorator extends Pizza{
    private Pizza pizza;

    public PizzaDecorator(Pizza pizza) {
        this.pizza = pizza;
    }
    
    @Override
    public String getNome() {
        return String.format("%s, %s", pizza.getNome(), nome);
    }

    @Override
    public Double getPreco() {
        return pizza.getPreco() + preco; 
    } 
}
