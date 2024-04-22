import java.util.Scanner;

class clsProduct 
{
    private int    productID;
    private string productName;
    private float  productPrice;

    // Parameterized Constructor for clsProduct
    public clsProduct (int productID, String productName, float productPrice)
    {
        this.productID    = Math.abs(productID);
        this.productName  = productName;
        this.productPrice = Math.abs(productPrice);
    }

    // get Product ID (Read Only Property)
    public int getProductID ()
    {
        return productID;
    }

    // set Product Name
    public void setProductName (string productName)
    {
        this.productName = productName;
    }

    // get Product Name
    public string getProductName ()
    {
        return productName;
    }

    // set Product Price 
    public void setProductPrice (float productPrice)
    {
        this.productPrice = productPrice;
    }

    // get Produt Price
    public float getProductPrice ()
    {
        return productPrice;
    }
}

class clsElectronicProduct extends clsProduct
{
    private string Brand ;
    private int warrantyPeriod ;
    
    public clsElectronicProduct (int ProductID, String ProductName, float ProductPrice, string Brand, int warrantyPeriod)
    {
        super(ProductID, ProductName, ProductPrice);
        this.Brand = Brand;
        this.warrantyPeriod = Math.abs(warrantyPeriod);
    }

    public void setBrand (string Brand)
    {
        this.Brand = Brand ;
    }

    public string getBrand ()
    {
        return Brand;
    }

    public void setWarrantyPeriod (int warrantyPeriod)
    {
        this.warrantyPeriod = warrantyPeriod; 
    }

    public int getWarrantyPeriod ()
    {
        return warrantyPeriod;
    }
}

class clsClothingProduct extends clsProduct 
{
    private string Size;
    private string Fabric;

    public clsClothingProduct(int ProductID, String productName, float ProductPrice, String Size, String Fabric)
    {
        super(ProductID, productName, ProductPrice);
        this.Size = Size;
        this.Fabric = Fabric;
    }

    public void setSize (string Size)
    {
        this.Size = Size;
    }

    public String getSize ()
    {
        return Size;
    }

    public void setFabric (string Fabric)
    {
        this.Fabric = Fabric;
    }

    public string getFabric ()
    {
        return Fabric;
    }
}

class  clsBookProduct extends clsProduct 
{
    private string Author;
    private string Publisher;

    public clsBookProduct (int ProductID, Sting ProductName, float ProductPrice, String Author, string Publisher)
    {
        super(ProductID, ProductName, ProductPrice);
        this.Author = Author;
        this.Publisher = Publisher;
    }

    public void setAuthor (string Author) 
    {
        this.Author = Author;
    }

    public string getAuthor ()
    {
        return Author;
    }

    public void setPublisher (string Publisher)
    {
        this.Publisher = Publisher;
    }

    public string getPublisher ()
    {
        return Publisher;
    }
}

class clsCustomer 
{
    private int    customerID;
    private String customerName;
    private String customerAdrress;

    public clsCustomer (int customerID, String customerName, String customerAdrress)
    {
        this.customerID      = Math.abs(customerID);
        this.customerName    = customerName;
        this.customerAdrress = customerAdrress;
    }

    public int getCustomerID ()
    {
        return customerID;
    }

    public void setCustomerName (String customerName)
    {
        this.customerName = customerName;
    }

    public String getCustomerName ()
    {
        return customerName;
    }

    public void setCustomerAdrress (String customerAdrress)
    {
        this.customerAdrress = customerAdrress;
    }

    public String getCustomerAdrress ()
    {
        return customerAdrress;
    }
}

class clsCart 
{
    private int customerID;
    private int nProducts;
    private Product[] products;

    private int generateOrderId() 
    {
        return (int) (Math.random() * 10000);
    }

    public clsCart(int customerID, int nProducts)
    {
        this.customerID = Math.abs(customerID);
        this.nProducts  = Math.abs(nProducts);
        this.products = new Product[nProducts]; 
    }

    public int getCustomerID ()
    {
        return this.customerID;
    }

    public void setnProducts (int nProducts)
    {
        this.nProducts = nProducts;
    }

    public int getnProduct ()
    {
        return nProducts;
    }

    public void setProducts(Product[] products) 
    {
        this.products = products;
    }

    public Product[] getProducts()
    {
        return products;
    }

    public void addProduct(Product product, int index) 
    {
        products[index] = product;
    }

    public void removeProduct(int index)
    {
        products[index] = null;
    }

    public double calculatePrice() 
    {
        double totalPrice = 0.0;
        for (Product product : products) 
        {
            if (product != null) 
            {
                totalPrice += product.getPrice();
            }
        }
        return totalPrice;
    }

    public void placeOrder() 
    {
        Order order = new Order(customerID, generateOrderId(), products);
        order.printOrderInfo();
    }

}

class clsOrder 
{
    private int customerID;
    private int orderID;
    private Product[] products;
    private double totalPrice;

    public Order(int customerID, int orderID, Product[] products) 
    {
        this.customerID = Math.abs(customerID);
        this.orderID = Math.abs(orderID);
        this.products = products;
        this.totalPrice = calculateTotalPrice();
    }

    public void printOrderInfo ()
    {
            System.out.println("Customer ID: " + customerID);
            System.out.println("Order ID: " + orderID);
            System.out.println("Products:");

            for (Product product : products) 
            {
                if (product != null) 
                {
                    System.out.println("- " + Product.getProductName() + ": $" + Product.getProductPrice());
                }
            }

            System.out.println("Total Price: $" + totalPrice);
    }

    private double calculateTotalPrice()
    {
        double totalPrice = 0.0;
        for (Product product : products)
        {
            if (product != null)
            {
                totalPrice += clsProduct.getProductPrice;
            }
        }
        return totalPrice;
    }

}

public class clsEcommerceSystem 
{
    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);

        clsElectronicProduct smartphone = new clsElectronicProduct(1, "smartphone", 599.9, "Samsung", 1);
        clsClothingProduct tShirt = new clsClothingProduct(2, "T-shirt", 19.99, "Medium", "Cotton");
        clsBookProduct oopBook = new clsBookProduct(3, "OOP", 39.99, "O'Reilly", "X Publications");

        System.out.println("Enter your customer ID: ");
        int customerId = input.nextInt();
        input.nextLine();

        System.out.println("Enter your customer Name: ");
        string customerName = input.nextLine();

        System.out.println("Enter your customer address:");
        String customerAddress = scanner.nextLine();

        clsCustomer customer = new Customer(customerId, customerName, customerAddress);

        System.out.println("How many products do you want to order?");
        int nProducts = scanner.nextInt();

        clsCart cart = new clsCartCart(customer.getCustomerID(), nProducts);

        for (int i = 0; i < nProducts; i++) 
        {
            System.out.println("Enter product type (1: Electronic, 2: Clothing, 3: Book):");
            int productType = scanner.nextInt();
            scanner.nextLine();

            switch (productType)
            {
                case 1:
                    cart.addProduct(smartphone, i);
                    break;

                case 2:
                    cart.addProduct(tShirt, i);
                    break;

                case 3:
                    cart.addProduct(oopBook, i);
                    break;

                default:
                    System.out.println("Invalid Enteries. Please try again.");
                    i--;
            }
        }

        System.out.println("Do you want to place an order? (yes/no)");
        String reply = scanner.next();

        if (reply == "yes") 
        {
            cart.placeOrder();
            clsOrder order = new clsOrder(cart.getCustomerID(), 12345, cart.getProducts());
            order.printOrderInfo();
        }
        else 
        {
            System.out.println("Thank you for visiting. Goodbye!");
        }
        input.close();
    }
}