public class Main1
{
    public static void main(String [] args)
    {
       Pizza basePizza = new Pizza(false);
        basePizza.addExtraToppings();
       basePizza.addExtraCheese();
        basePizza.takeAway();
        basePizza.getBill();



        DeluxPizza dp = new DeluxPizza( true);
        dp.getBill();;
    }
}