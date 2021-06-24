package manager;

import domain.Book;
import domain.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import repository.ProductRepository;

public class ProductManagerTest {
    private ProductManager manager = new ProductManager();
    private Book book1 = new Book();
    @Test
    public void shouldAdd () {
        manager.add(book1);

        Product[] expected = Product[] {book1};
        Product[] actual = manager.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }





}

