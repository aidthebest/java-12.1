package manager;

import domain.Book;
import domain.Product;
import domain.Smartphone;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.ProductRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ProductManagerTest {
    private ProductManager manager = new ProductManager();
    private Book book1 = new Book(11, "WAR", 2500, "SomeBodyGuy");
    private Book book2 = new Book(49, "Peace", 1748, "AnotherGuy");
    private Book book3 = new Book(19, "HowTocook", 2500, "BadGuy");

    private Smartphone smart1 = new Smartphone(67, "C30", 17800, "Samsung");
    private Smartphone smart2 = new Smartphone(57, "3110", 74000, "Nokia");
    private Smartphone smart3 = new Smartphone(84, "11plus", 17800, "Apple");


    @BeforeEach
    public void setUp() {
//        manager.add(te);
        manager.add(book1);
        manager.add(book2);

        manager.add(smart1);
        manager.add(smart2);


        @Test
        public void shouldAddProduct () {
            manager.add(book3);
            manager.add(smart3);

            Product[] expected = {book1, book2, smart1, smart2, book3, smart3};
            Product[] actual = manager.getAll();
            Assertions.assertArrayEquals(actual, expected);
        }

        @Test
        public void shouldSearchBySmart () {
            manager.add(book3);
            manager.add(smart3);


            Product[] expected = {smart1};
            Product[] actual = manager.searhcyBy("Samsung");
            Assertions.assertArrayEquals(expected, actual);
        }

        @Test
        public void shouldSearchByBook () {
            manager.add(book3);
            manager.add(smart3);


            Product[] expected = {book3};
            Product[] actual = manager.searhcyBy("HowTocook");
            Assertions.assertArrayEquals(expected, actual);
        }

        @Test
        public void shouldSearchByBook2 () {
            manager.add(book3);
            manager.add(smart3);


            Product[] expected = {book1};
            Product[] actual = manager.searhcyBy("SomeBodyGuy");
            Assertions.assertArrayEquals(expected, actual);
        }

        @Test
        public void shouldSearchBySmart2 () {
            manager.add(book3);
            manager.add(smart3);


            Product[] expected = {smart2};
            Product[] actual = manager.searhcyBy("3110");
            Assertions.assertArrayEquals(expected, actual);
        }

        @Test
        public void shouldSearchByNoExist () {
            manager.add(book3);
            manager.add(smart3);


            Product[] expected = {};
            Product[] actual = manager.searhcyBy("17842");
            Assertions.assertArrayEquals(expected, actual);
        }

        @Test
        public void shouldSearchSome () {
            manager.add(book3);
            manager.add(smart3);

            Product[] expected = {book2, smart1, smart3};

            manager.searhcyBy("Peace");
            manager.searhcyBy("C30");
            manager.searhcyBy("Apple");

            Product[] actual = manager.getAll();

            Assertions.assertArrayEquals(expected, actual);
        }
    }
}


//        static class TestEnt extends Product {
//        public TestEnt(int id, String name, int price) {
//            super(id, name, price);
//        }
//    }
//
//    ;
//    TestEnt te = new TestEnt(777, "777", 777);

//    public ProductManager setUpPm0() {
//        ProductManager pm = new ProductManager();
//        return pm;
//    }
//
//    public ProductManager setUpPm1() {
//        ProductManager pm = new ProductManager();
//        pm.add(book2);
//        return pm;
//    }
//
//    public ProductManager setUpPm5() {
//        ProductManager pm = new ProductManager();
//        pm.add(te);
//        pm.add(book1);
//        pm.add(book2);
//        pm.add(smart1);
//        pm.add(smart2);
//        return pm;
//    }
//
//    @Test
//    public void megaTest() {
//        Map<String, Product[][]> expectMap = new HashMap();
//        ProductManager[] manMap = new ProductManager[3];
//        manMap[0] = setUpPm0();
//        manMap[1] = setUpPm1();
//        manMap[2] = setUpPm5();
//        expectMap.put("shouldAddProduct", new Product[][]{
//                {},
//                {book2},
//                {te, book1, book2, smart1, smart2}
//        });
//        expectMap.put("shouldSearchBySmart", new Product[][]{
//                {},
//                {},
//                {smart1}
//        });
//        expectMap.put("shouldSearchByBook", new Product[][]{
//                {},
//                {},
//                {book1}
//        });
//        expectMap.put("shouldSearchByBook2", new Product[][]{
//                {},
//                {},
//                {book1}
//        });
//        expectMap.put("shouldSearchBySmart2", new Product[][]{
//                {},
//                {},
//                {smart2}
//        });
//        expectMap.put("shouldSearchByNoExist", new Product[][]{
//                {},
//                {},
//                {}
//        });
//
//
//        for (int i = 0; i < manMap.length; i++) {
//            System.out.println("======>" + i + "<=======");
//            shouldAddProduct(manMap[i], expectMap.get("shouldAddProduct")[i]);
//            shouldSearchBySmart(manMap[i], expectMap.get("shouldSearchBySmart")[i]);
//            shouldSearchByBook(manMap[i], expectMap.get("shouldSearchByBook")[i]);
//            shouldSearchByBook2(manMap[i], expectMap.get("shouldSearchByBook2")[i]);
//            shouldSearchBySmart2(manMap[i], expectMap.get("shouldSearchBySmart2")[i]);
//            shouldSearchByNoExist(manMap[i], expectMap.get("shouldSearchByNoExist")[i]);
//        }
//    }
//    public void shouldAddProduct(ProductManager manager, Product[] expected) {
//
//        Product[] actual = manager.getAll();
//        Assertions.assertArrayEquals(actual, expected);
//    }
//
//    public void shouldSearchBySmart(ProductManager manager, Product[] expected) {
//      manager.add(book3);
//      manager.add(smart3);


//Product[] expected = {smart1};
//        Product[] actual = manager.searhcyBy("Samsung");
//        Assertions.assertArrayEquals(expected, actual);
//    }
//
//    public void shouldSearchByBook(ProductManager manager, Product[] expected) {
//    manager.add(book3);
//   manager.add(smart3);


//  Product[] expected = {book3};
//        Product[] actual = manager.searhcyBy("WAR");
//        Assertions.assertArrayEquals(expected, actual);
//    }
//
//    public void shouldSearchByBook2(ProductManager manager, Product[] expected) {
//   manager.add(book3);
//   manager.add(smart3);


//   Product[] expected = {book1};
//        Product[] actual = manager.searhcyBy("SomeBodyGuy");
//        Assertions.assertArrayEquals(expected, actual);
//    }

//    public void shouldSearchBySmart2(ProductManager manager, Product[] expected) {
//  manager.add(book3);
//  manager.add(smart3);


//  Product[] expected = {smart2};
//        Product[] actual = manager.searhcyBy("3110");
//        Assertions.assertArrayEquals(expected, actual);
//    }

//    public void shouldSearchByNoExist(ProductManager manager, Product[] expected) {
//   manager.add(book3);
//   manager.add(smart3);


// Product[] expected = {};
//        Product[] actual = manager.searhcyBy("17842");
//        Assertions.assertArrayEquals(expected, actual);
//    }



