package com.mbaibakov;

public class Application {

    public static void main(String[] args) {
        StringGenerator stringGenerator = new StringGenerator();
        stringGenerator.generateAndPrintStringsBetweenFirstAndSecond("A", "AAB");
    }
}
