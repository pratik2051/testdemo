<h1>This repo contains solutions of no 1,2 ----- 6 questions </h1>
Develop a basic RESTful web service for a book management system using Servlets. The service should allow API users to perform the following operations:

1. Add New Books

Delete Existing Books

Update Existing Books

List All Registered Books

The book schema should include two simple properties:

Name

ISBN

Additionally, create a plain HTML webpage using JSP to demonstrate these operations. Keep the implementation straightforward and focused on functionality.
To use this we need following configuration in our machine
 a. Intellij idea for the development
 b. Mysql server for database, provide the credentials inside bookDAO.java
 c. java Jdk-17
 d. Apache Tomcat/9.0.98
 


2. API Documentation is on file API documentation

3. The refactored approach can be 
 ***************************************************************************
   function executeOperations() {

    const operations = [
        { operation: operation1, error: "operation1failed" },
        { operation: operation2, error: "operation2failed" },
        { operation: operation3, error: "operation3failed" },
        { operation: operation4, error: "operation4failed" },
    ];

    const failed = operations.find(({ operation }) => !pass(operation()));
    return failed ? failed.error : null;
}
 ****************************************************************************
4. To fix this issue, we need to explicitly set the array slot of the popped element to null in the pop() method. This ensures that the reference is cleared, allowing the garbage collector to reclaim the memory if there are no other references to the object.

************************* The corrected code *****************************
   
  </n> import java.util.Arrays;
  </n> import java.util.EmptyStackException;

    public class Stack {
    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public Stack() {
        elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(Object e) {
        ensureCapacity();
        elements[size++] = e;
    }

    public Object pop() {
        if (size == 0)
            throw new EmptyStackException();
        
        Object element = elements[--size]; // Decrement size and get the element
        elements[size] = null;            // Nullify the reference to prevent memory leaks
        return element;
    }

    private void ensureCapacity() {
        if (elements.length == size)
            elements = Arrays.copyOf(elements, 2 * size + 1);
    }
}
************************************************************************************************


 5.The output of the sql query
 ***********
 SELECT
   o.customer_number,
   order_number,
   o.status,
   customer_name
FROM orders o
RIGHT JOIN customers c
ON o.customer_number = c.customer_number
*************
 can be explained as follows
 
 Ram: Has two orders (order_number = 1 and 2), so both appear in the result.
 Hari: Has one order (order_number = 3), so it appears in the result.
 Rita: Has one order (order_number = 4), so it appears in the result.
 Tina: Has no orders, but since it’s a RIGHT JOIN, Tina still appears with NULL values for the columns from the     orders table.
 
 6. Here is the code snippet 
 
 ***************************************************************************************
 import org.junit.jupiter.api.Test;
 import static org.junit.jupiter.api.Assertions.*;

class RectangleTest {

    @Test
    void testValidDimensions() {
        assertEquals(20, perimeter(5, 5)); // Valid case
    }

    @Test
    void testUndefinedLength() {
        Exception exception = assertThrows(Exception.class, () -> perimeter(0, 5));
        assertEquals("Undefined", exception.getMessage());
    }

    @Test
    void testUndefinedBreadth() {
        Exception exception = assertThrows(Exception.class, () -> perimeter(5, 0));
        assertEquals("Undefined", exception.getMessage());
    }

    @Test
    void testLengthNotANumber() {
        Exception exception = assertThrows(Exception.class, () -> perimeter("five", 5));
        assertEquals("Not a number", exception.getMessage());
    }

    @Test
    void testBreadthNotANumber() {
        Exception exception = assertThrows(Exception.class, () -> perimeter(5, "five"));
        assertEquals("Not a number", exception.getMessage());
    }

    @Test
    void testNegativeLength() {
        Exception exception = assertThrows(Exception.class, () -> perimeter(-5, 5));
        assertEquals("dimension cannot be negative", exception.getMessage());
    }

    @Test
    void testNegativeBreadth() {
        Exception exception = assertThrows(Exception.class, () -> perimeter(5, -5));
        assertEquals("dimension cannot be negative", exception.getMessage());
    }

    
    private int perimeter(Object length, Object breadth) throws Exception {
        if (length == null || breadth == null || (length instanceof Integer && (Integer) length == 0) || (breadth instanceof Integer && (Integer) breadth == 0)) {
            throw new Exception("Undefined");
        }
        if (!(length instanceof Number)) {
            throw new Exception("Not a number");
        }
        if (!(breadth instanceof Number)) {
            throw new Exception("Not a number");
        }
        if ((int) length < 0 || (int) breadth < 0) {
            throw new Exception("dimension cannot be negative");
        }
        return 2 * ((int) length + (int) breadth);
    }
}
 
 ***************************************************************************************
