package com.byfrunze.sitostore.sitoStoreElementsOfProducts;


public class MyProduct {

    private int id;
    private String title;
    private String description;
    private String URL;
    private String image;
    private String brand;
    private String size;
    private String color;
    private int sex_id;
    private String sex;
    private int category_id;
    private String category;
    private String price;
    private String oldPrice;
    private String sale;

    public MyProduct(int id, String title, String description, String URL, String image, String brand, String size, String color, int sex_id, String sex, int category_id, String category, String price, String oldPrice, String sale) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.URL = URL;
        this.image = image;
        this.brand = brand;
        this.size = size;
        this.color = color;
        this.sex_id = sex_id;
        this.sex = sex;
        this.category_id = category_id;
        this.category = category;
        this.price = price;
        this.oldPrice = oldPrice;
        this.sale = sale;
    }

    public MyProduct(String title, String description, String URL, String image, String brand, String size, String color, String price, String oldPrice, String sale) {
        this.title = title;
        this.description = description;
        this.URL = URL;
        this.image = image;
        this.brand = brand;
        this.size = size;
        this.color = color;
        this.price = price;
        this.oldPrice = oldPrice;
        this.sale = sale;
    }

    public MyProduct(String title, String description, String URL, String image, String price, String oldPrice, String sale) {
        this.title = title;
        this.description = description;
        this.URL = URL;
        this.image = image;
        this.price = price;
        this.oldPrice = oldPrice;
        this.sale = sale;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getSex_id() {
        return sex_id;
    }

    public void setSex_id(int sex_id) {
        this.sex_id = sex_id;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getOldPrice() {
        return oldPrice;
    }

    public void setOldPrice(String oldPrice) {
        this.oldPrice = oldPrice;
    }

    public String getSale() {
        return sale;
    }

    public void setSale(String sale) {
        this.sale = sale;
    }
}
