package manager;

import domain.Book;
import domain.Product;
import domain.Smartphone;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class ProductManagerTest {
    private ProductManager manager = new ProductManager();
    private Book book1 = new Book(11, "WAR", 2500, "SomeBodyGuy");
    private Book book2 = new Book(49, "Peace", 1748, "AnotherGuy");
    private Book book3 = new Book(19, "HowTocook", 2500, "BadGuy");
    private Book book4 = new Book(22, "BeforeCook", 2500, "BadGuy");


    private Smartphone smart1 = new Smartphone(67, "C30", 17800, "Samsung");
    private Smartphone smart2 = new Smartphone(57, "3110", 74000, "Nokia");
    private Smartphone smart3 = new Smartphone(84, "11plus", 17800, "Apple");


//    @BeforeEach
//    public void setUp() {
//        manager.add(book1);
//        manager.add(book2);
//
//        manager.add(smart1);
//        manager.add(smart2);
//    }


    @Test
    public void shouldAddProduct() {
        manager.add(book1);
        manager.add(book2);
        manager.add(smart1);
        manager.add(smart2);
        manager.add(book3);
        manager.add(smart3);

        Product[] expected = {book1, book2, smart1, smart2, book3, smart3};
        Product[] actual = manager.getAll();
        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldSearchBySmart() {
        manager.add(book1);
        manager.add(book2);
        manager.add(smart1);
        manager.add(smart2);
        manager.add(book3);
        manager.add(smart3);


        Product[] expected = {smart1};
        Product[] actual = manager.searhcBy("Samsung");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByBook() {
        manager.add(book1);
        manager.add(book2);
        manager.add(smart1);
        manager.add(smart2);
        manager.add(book3);
        manager.add(smart3);


        Product[] expected = {book3};
        Product[] actual = manager.searhcBy("HowTocook");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByBook2() {
        manager.add(book1);
        manager.add(book2);
        manager.add(smart1);
        manager.add(smart2);
        manager.add(book3);
        manager.add(smart3);


        Product[] expected = {book1};
        Product[] actual = manager.searhcBy("SomeBodyGuy");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchBySmart2() {
        manager.add(book1);
        manager.add(book2);
        manager.add(smart1);
        manager.add(smart2);
        manager.add(book3);
        manager.add(smart3);


        Product[] expected = {smart2};
        Product[] actual = manager.searhcBy("3110");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByNoExist() {
        manager.add(book1);
        manager.add(book2);
        manager.add(smart1);
        manager.add(smart2);
        manager.add(book3);
        manager.add(smart3);


        Product[] expected = {};
        Product[] actual = manager.searhcBy("17842");
        Assertions.assertArrayEquals(expected, actual);
    }

//    @Test
//    public void shouldSearchSome() {
//        manager.add(book3);
//        manager.add(smart3);
//
//        Product[] expected = {book2, smart1, smart3};
////
//        Product[] a1 = {book2};
//        Product[] b1 = {smart1};
//        Product[] c1 = {smart3};

//        Product[][] expected = {a1, b1, c1};

//        Product[] actual = new Product[]{manager.searhcyBy("Peace"),
//                manager.searhcyBy("C30"), manager.searhcyBy("Apple")};

//        Product[] a = manager.searhcyBy("Peace");
//        Product[] b = manager.searhcyBy("C30");
//        Product[] c = manager.searhcyBy("Apple");

//        Product[][] actual = {a, b, c};

//        Assertions.assertArrayEquals(expected, actual);
//    }

    @Test
    public void shouldReturnOne() {
        manager.add(book1);
        Product[] expected = {book1};
        Product[] actual = manager.getAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldReturnNOthing() {

        Product[] expected = {};
        Product[] actual = manager.getAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldReturnTwo() {
        manager.add(book1);
        manager.add(book2);
        manager.add(smart1);
        manager.add(smart2);
        manager.add(book3);
        manager.add(smart3);
        manager.add(book4);

        Product[] expected = {book3, book4};
        Product[] actual = manager.searhcBy("BadGuy");
        Assertions.assertArrayEquals(expected, actual);
    }
}






