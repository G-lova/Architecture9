package org.example.seminar10.cache;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class ProductCache {
    private Map<Integer, Product> cache = new HashMap<>();

    /**
     * Получить продукт из кэша или основного списка.
     *
     * @param id           ID продукта.
     * @param productList Основной список продуктов.
     * @return Продукт из кэша или null, если продукт не найден.
     */
    public Product getProduct(int id, List<Product> productList) {
        if (cache.containsKey(id)) {
            return cache.get(id);
        } else {
            for (Product product : productList) {
                if (product.getId() == id) {
                    cache.put(id, product);
                    return product;
                }
            }
            return null;
        }
    }

    /**
     * Обновить информацию о продукте в кэше и основном списке.
     *
     * @param product      Обновленная информация о продукте.
     * @param productList Основной список продуктов.
     */
    public void updateProduct(Product product, List<Product> productList) {
        cache.put(product.getId(), product);
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId() == product.getId()) {
                productList.set(i, product);
                break;
            }
        }
    }
}
