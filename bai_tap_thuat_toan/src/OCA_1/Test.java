package OCA_1;
 class Product{
    double price;
}

public class Test {
    public static void main(String[] args) {
        Product product = new Product();
        product.price = 200;
        Double newPrice = 100D;
        System.out.println(product);
        updatePrice(product, newPrice);
        System.out.println(product);
        System.out.println(product.price + " : " + newPrice);
    }

    public static void updatePrice(Product product, Double price){
        price = price * 2;
//        product = new Product();
        product.price = product.price + price;
    }
}
