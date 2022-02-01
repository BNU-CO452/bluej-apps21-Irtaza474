
/**
 * Demonstrate the StockManager and Product classes.
 * The demonstration becomes properly functional as
 * the StockManager class is completed.
 * 
 * @author David J. Barnes and Michael Kölling.
 * @version 2016.02.29
 */
public class StockDemo
{
    // The stock manager.
    private StockList stock;

    /**
     * Create a StockManager and populate it with at least
     * 10 sample products.
     */
    public StockDemo(StockList stock)
    {
        this.stock = stock;
        
        // Add at least 10 products, they must be unique to you
        // Make sure the ids are sequential numbers
        
        stock.add(new Product(101, "Samsung Galaxy S20"));
        stock.add(new Product(102, "Apple iPhone 12"));
        stock.add(new Product(103, "Google Pixel 4A"));
        stock.add(new Product(104, "Samsung Galaxy M21 2021"));
        stock.add(new Product(105, "OnePlus Nord CE"));
        stock.add(new Product(106, "Samsung Galaxy F42"));
        stock.add(new Product(107, "Xiaomi Redmi 7A"));
        stock.add(new Product(108, "Apple iPhone 13"));
        stock.add(new Product(109, "Apple iPhone SE"));
        stock.add(new Product(110, "Nokia 6.1"));
        
        
    }
    
    /**
     * Provide a demonstration of how the ProductList meets all
     * the user requirements by making a delivery of each product 
     * buying it in various amounts and then selling each
     * product by various amounts. Make sure all the requirements
     * have been demonstrated.
     */
    public void runDemo()
    {
        // Show details of all of the products before delivery.
        System.out.println("Listing of all products");
        stock.print();
        
        System.out.println("Purchasing the products for inventory");
        buyProducts();
        stock.print();        

        sellProducts();
        stock.print();  
        
        System.out.println("\nListing Products having specific phrase");
        stock.findProductbyPhrase("Samsung");
        
        System.out.println("\nListing Products under a specific level");
        stock.findProductUnderLevel(3);

        
    }
    
    private void buyProducts()
    {
        stock.buyProduct(101, 3);
        stock.buyProduct(102, 5);
        stock.buyProduct(103, 11);
        stock.buyProduct(104, 4);
        stock.buyProduct(105, 1);
        stock.buyProduct(106, 9);
        stock.buyProduct(107, 8);
        stock.buyProduct(108, 4);
        stock.buyProduct(109, 5);
        stock.buyProduct(110, 10);
    }

    private void sellProducts()
    {
        stock.sellProduct(101, 1);
        stock.sellProduct(102, 2);
        stock.sellProduct(103, 3);
        stock.sellProduct(104, 2);
        stock.sellProduct(105, 1);
        stock.sellProduct(106, 6);
        stock.sellProduct(107, 1);
        stock.sellProduct(108, 3);
        stock.sellProduct(109, 2);
        stock.sellProduct(110, 5);
        
    }    
}