package manager;

import domain.Book;
import domain.Product;
import domain.Smartphone;
import repository.ProductRepository;

public class ProductManager {
    private ProductRepository repository = new ProductRepository();

    public ProductManager(ProductRepository product) {
        repository = product;
    }

    public ProductManager() {
    }

    public void add(Product product) {
        repository.save(product);
    }

    public Product[] getAll() {
        return repository.findAll();
    }

    public Product[] searhcyBy(String text) {
        Product[] result = new Product[0];
        for (Product product : repository.findAll()) {
            if (matches(product, text)) {
                Product[] tmp = new Product[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = product;
                result = tmp;
            }
        }
        return result;
    }

    public boolean matches(Product product, String search) {
        if (product instanceof Book) {
            Book book = (Book) product;
            if ((book).getAuthor().contains(search)) {
                return true;
            }
            return product.getName().contains(search);
        }


        if (product instanceof Smartphone) {
            Smartphone smart = (Smartphone) product;
            if ((smart).getProducer().contains(search)) {
                return true;
            }
            return product.getName().contains(search);
        }
        return false;
    }
}


