public class Pizza
{
     private int price ;
     private Boolean veg;

     private int ExtraCheesePrice = 100;
     private int ExtraToppingsPrice = 150;
     private int backpackPrice = 20;
     private int basePizzaPrice;
     private boolean isExtraCheeseAdded =false;
     private boolean isExtraTopping =false;
     private boolean isOptedForTakeAway =false;





     public Pizza(Boolean veg)
     {
        this.veg = veg;

        if(this.veg)
        {
            this.price=300;
        }
        else
        {
            this.price=400;
        }

        basePizzaPrice = this.price;
     } 

     public void  addExtraCheese()
     {   isExtraCheeseAdded = true;
        this.price += ExtraCheesePrice; 
     }

     public void addExtraToppings()
     {   isExtraTopping = true;
         this.price +=ExtraToppingsPrice; 
     }

     public void takeAway()

     {     isOptedForTakeAway= true;
          this.price += backpackPrice;
     }

     public void getBill()
     {    
        String bill ="";
       System.out.println("Pizza"+basePizzaPrice);
       if(isExtraCheeseAdded)
       {
        bill += " Extra chees Added: " + ExtraCheesePrice;
       }




       if(isExtraTopping)
       {
        bill += " Extra topping Added: " + ExtraToppingsPrice;
       }




       if(isOptedForTakeAway)
       {
        bill += " takes away:  " + backpackPrice+ "\n";
       }

       bill = "Bill:"+this.price+"\n";
       System.out.println(bill);

     }
     
}