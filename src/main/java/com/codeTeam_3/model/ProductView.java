package com.codeTeam_3.model;

import java.math.BigDecimal;

public class ProductView {
    private int id;
    private String name;
    private BigDecimal price;
    private BigDecimal weight;
    private String category;           // nếu bạn đang đặt là categoryName
    private String productDescription; // bạn đang dùng tên này

    public ProductView(int id, String name, BigDecimal price, BigDecimal weight,
                       String category, String productDescription) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.weight = weight;
        this.category = category;
        this.productDescription = productDescription;
    }

    public ProductView() {
    }

    public ProductView(int id, String name, String description, double price, double weight, int categoryId) {
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public BigDecimal getPrice() { return price; }
    public BigDecimal getWeight() { return weight; }

    // alias để JSP dùng ${p.category}
    public String getCategory() { return category; }

    // alias để JSP dùng ${p.description}
    public String getDescription() { return productDescription; }

    // (tuỳ bạn: có thể vẫn giữ các getter gốc nếu đã dùng nơi khác)
    public String getProductDescription() { return productDescription; }
    public String getCategoryName() { return category; }

    public void setId(int id) {
    }

    public void setName(String name) {
    }

    public void setPrice(BigDecimal price) {
    }

    public void setWeight(double weight) {
    }

    public void setCategoryName(String categoryName) {
    }
}
