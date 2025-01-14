
package principiileOOP.caloriesCounter;

public class ProductCatalog {

    Product[] products;
    int noOfProducts;

    public ProductCatalog() {
        this.products = new Product[100];
    }

    public boolean addProduct(Product product){
        Product foundProduct = getProductByName(product.name);
        if (foundProduct != null){
            return false;
        }
        this.products[noOfProducts] = product;
        this.noOfProducts++;
        return true;
    }

    public void printProducts(){
        for (int i = 0; i < noOfProducts; i++) {
            System.out.println(products[i].toString());
        }
    }

    public Product getProductByName (String name){
        int productIndex = getProductIndex(name);
        if (productIndex == -1){
            return null;
        }
        return products[productIndex];
    }
    public boolean deleteProduct(String name){
        //prima data gasesc pozitia produsului cu numele name
        int productIndex = getProductIndex(name);
        if (productIndex == -1){
            return false;
        }
        //apoi il sterg
        for (int i = productIndex; i < noOfProducts; i++) {
            products[i] = products[i+1];
        }
        this.noOfProducts--;
        return true;
    }
    public int getProductIndex(String productName){
        for (int i = 0; i < noOfProducts; i++) {
            if (productName.equals(products[i].name)){
                return i;
            }
        }
        return -1;
    }

    //afla toate produsele cu risc (peste 500 de calorii)

}
