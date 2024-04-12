package mate.academy.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import mate.academy.model.Order;
import mate.academy.model.Product;

public class OrderServiceImpl implements OrderService {
    private static final Logger logger = LogManager.getLogManager()
            .getLogger(String.valueOf(OrderServiceImpl.class));

    @Override
    public Order completeOrder(Long userId) {
        logger.info("Method completeOrder was called. Params: userId= " + userId);
        List<Product> products = getAllProductsFromShoppingCart(userId);
        Order order = new Order(products, userId);
        // NOTE: In production ready code this order identifier should be generated by DB
        // For test purpose we simplify this and return dummy data
        order.setOrderId(1L);
        return order;
    }

    private List<Product> getAllProductsFromShoppingCart(Long userId) {
        // NOTE: In production ready code this method should fetch data from DB
        // For test purpose we simplify this method and return dummy data
        Product iphone = new Product("iPhone X", BigDecimal.valueOf(1199));
        Product macBook = new Product("MacBook Air 2020", BigDecimal.valueOf(1399));
        Product xiaomi = new Product("Xiaomi 12", BigDecimal.valueOf(499));
        List<Product> products = List.of(iphone, macBook, xiaomi);
        logger.info("Data was successfully fetched from DB");
        return products;
    }
}
