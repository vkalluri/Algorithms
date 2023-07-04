package com.venkat.hackerrank;

class Superclass {
    public static void method() {
        System.out.println("Superclass method");
    }
}

class Subclass extends Superclass {
    public static void method() {
        System.out.println("Subclass method");
    }
}

public class Main {
    public static void main(String[] args) {
        Superclass obj1 = new Superclass();
        Superclass obj2 = new Subclass();
        
        obj1.method();  // Output: "Superclass method"
        obj2.method();  // Output: "Superclass method"
        
        // Even though obj2 is of type Superclass, the hidden method in the Subclass is not invoked.
        // The method called depends on the declared type of the reference variable.
        // This is known as static binding.
    }
}
