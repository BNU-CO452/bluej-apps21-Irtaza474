import java.util.ArrayList;

/**
 * Manage the stock in a business.
 * The stock is described by zero or more Products.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StockList
{
    // A list of the products.
    private ArrayList<Product> stock;

    /**
     * Initialise the stock manager.
     */
    public StockList()
    {
        stock = new ArrayList<Product>();
    }

    /**
     * Add a product to the list.
     * @param item The product item to be added.
     */
    public void add(Product item)
    {
        stock.add(item);
    }
    
    public void remove(int productID)
    {
        Product product= findProduct(productID);
        String name= product.getName();
        stock.remove(product);
        System.out.println(name + " removed!");
    }
    
    /**
     * A method to buy a single quantity of the product
     */
    public void buyProduct(int productID)
    {
        buyProduct(productID, 1);
    }
    
    
    /**
     * Buy a quantity of a particular product.
     * Increase the quantity of the product by the given amount.
     * @param id The ID of the product.
     * @param amount The amount to increase the quantity by.
     */
    public void buyProduct(int productID, int amount)
    {
        Product product = findProduct(productID);
        product.increaseQuantity(amount);
    }
    
    /**
     * Find a product to match the product id,
     * if not found return null
     */
    public Product findProduct(int productID)
    {
        for(Product i: stock)
        {
            if(i.getID() == productID)
            {
                return i;
            }
        }
        return null;
    }
    
    
    /**
     * Sell one of the given product.
     * Show the before and after status of the product.
     * @param id The ID of the product being sold.
     */
    public void sellProduct(int productID, int quantity)
    {
        Product product = findProduct(productID);
        
        if(product != null) 
        {
            if(product.getQuantity() - quantity >= 0)
            {
                product.decreaseQuantity(quantity);
                // printout message
                System.out.println(product.getName()+ " Sold");
                
                //Advance Req: If inventory goes less than 0, auto re-stock
                if (product.getQuantity() <= 0)
                {
                    this.buyProduct(product.getID(), 10);
                    System.out.println("\n" + product.getName() + 
                                        " re-stocked to 10 units\n");
                }
            }
            else
            {
                // printout message
                System.out.println("Product Out of Stock");
            }
        }
        else
        {
            // printout message
            System.out.println("No such Product available");
        }
    }    

    
    /**
     * Locate a product with the given ID, and return how
     * many of this item are in stock. If the ID does not
     * match any product, return zero.
     * @param id The ID of the product.
     * @return The quantity of the given product in stock.
     */
    public int numberInStock(int productID)
    {
        Product product = this.findProduct(productID);
        if (product != null)
        {
            return product.getQuantity();
        }
        return 0;
    }
    
    /**
     * Locates a product by checking some specific term 
     * is present in that product e.g. "Samsung"
       @param phrase The phrase user wants to search amongst the product
     */
    public void findProductbyPhrase(String phrase)
    {
        for(Product i: stock)
        {
            if(i.getName().contains(phrase))
            {
                System.out.println(i);
            }
        }
    }
    
    
    /**
     * Locates products based on their quantity available.
     * Prints the products whose value dips down to a certain level.
     * @param level The specified level below which the 
     *        products should be printed
     */
    
    public void findProductUnderLevel(int level)
    {
        for(Product i: stock)
        {
            if(i.getQuantity() < level)
            {
                System.out.println(i);
            }
        }
    }
    
    
    /**
     * Print details of the given product. If found,
     * its name and stock quantity will be shown.
     * @param id The ID of the product to look for.
     */
    public void printProduct(int productID)
    {
        Product product = findProduct(productID);
        
        if(product != null) 
        {
            System.out.println(product.toString());
        }
    }
    
    
    
    /**
     * Print out each product in the stock
     * in the order they are in the stock list
     */
    public void print()
    {
        printHeading();
        
        for(Product product : stock)
        {
            System.out.println(product);
        }

        System.out.println();
    }
    
    public void printHeading()
    {
        System.out.println();
        System.out.println(" Irtaza's Stock List");
        System.out.println(" ====================");
        System.out.println();
    }
}