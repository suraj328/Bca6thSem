// Shape interface
interface Shape {
    void draw();
}

// Concrete Shape implementations
class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a square.");
    }
}

class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a circle.");
    }
}

// ShapeFactory interface
interface ShapeFactory {
    Shape createShape();
    Shape getShape();
}

// Concrete ShapeFactory implementations
class SquareFactory implements ShapeFactory {
    private Shape shape;

    @Override
    public Shape createShape() {
        shape = new Square();
        return shape;
    }

    @Override
    public Shape getShape() {
        return shape;
    }
}

class CircleFactory implements ShapeFactory {
    private Shape shape;

    @Override
    public Shape createShape() {
        shape = new Circle();
        return shape;
    }

    @Override
    public Shape getShape() {
        return shape;
    }
}

// Client code
public class FactoryMethod {
    public static void main(String[] args) {
        ShapeFactory factory = new SquareFactory();
        Shape shape = factory.createShape();
        shape.draw();

        // Get the created shape using the getter
        Shape retrievedShape = factory.getShape();
        retrievedShape.draw();

        factory = new CircleFactory();
        shape = factory.createShape();
        shape.draw();

        // Get the created shape using the getter
        retrievedShape = factory.getShape();
        retrievedShape.draw();
    }
}
