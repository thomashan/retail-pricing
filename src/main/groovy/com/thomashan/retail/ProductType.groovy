package com.thomashan.retail

enum ProductType {
    GROCERY,
    ELECTRONIC

    static ProductType getRandom() {
        return ProductType.values()[new Random().nextInt(ProductType.values().size())]
    }
}
