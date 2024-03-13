/*
 * Class analyzer using Java Reflection
 * Advanced Java Topics, Udemy course
 * Mario Ventura Burgos, february 2024
 * Practical case for a general class
*/

/*
 * This class has been coded just to practice,
 * based on the topics learnt in Udemy's course
 * "Advanced Java Topics"
 */

package udemytests;

// Imports
import api.ClothingProduct;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;

public class classAnalyzer {

    // Main method
    public static void main(String[] args) {
        // clearing screen to see a cleaner output
        clearScreen();

        // Introduction on testing class product
        System.out.println("---> CLASS ANALYZER\n");

        // Testing getters
        System.out.println("Testing getters:");
        testGetters(ClothingProduct.class);

        // testing setters
        System.out.println("Testing setters:");
        testSetters(ClothingProduct.class);
        System.out.println("\n\n\n");
    }

    //Clearing screen by just making line breaks (100 in total)
    private void clearScreen() {
        for(int i=0; i++; i<10) {
            for(int i=0; i++; i<10) {
                // Line break
                System.out.println("\n");
            }
        }
    }

    // testSetters method for testing setter methods on generic class
    public static void testSetters(Class<?> dataClass) {
        // Creating a list of all fields (setters)
        List<Field> fields = getAllFields(dataClass);
        // Iterating fields to check if the setters are correct
        for (Field field : fields) {
            // Generating setter names
            String setterName = "set" + capitalizeFirstLetter(field.getName());
            // Method object
            Method setterMethod = null;
            // try-catch to control known possible exceptions
            try {
                // Instantiate the method object
                setterMethod = dataClass.getMethod(setterName, field.getType());
            } catch (NoSuchMethodException e) {
                // Setter not found
                throw new IllegalStateException(String.format("Setter : %s not found", setterName));
            }
            // Checking if return types are correct (should be void, it's a setter)
            if (!setterMethod.getReturnType().equals(void.class)) {
                // Return type is not void
                throw new IllegalStateException(String.format("Setter method : %s has to return void", setterName));
            }
        }
    }

    // testGetters method for testing getter methods on generic class
    public static void testGetters(Class<?> dataClass) {
        //Creating an arrayList of fields
        List<Field> fields = getAllFields(dataClass);
        // Mapping the fields with the method name (call to mapMethodName)
        Map<String, Method> methodNameToMethod = mapMethodNameToMethod(dataClass);
        // Iterating the fields and capitalizing first letter
        for (Field field : fields) {
            // capitalizing
            String getterName = "get" + capitalizeFirstLetter(field.getName());
            // Checking for missing getter methods
            if (!methodNameToMethod.containsKey(getterName)) {
                // The key has not a getter method
                throw new IllegalStateException(String.format("Field : %s doesn't have a getter method", field.getName()));
            }
            // Creating method object based on the method's name
            Method getter = methodNameToMethod.get(getterName);
            // Checking if return type is correct (example: int != double despite it should work sometimes)
            if (!getter.getReturnType().equals(field.getType())) {
                // Return types are not the same
                throw new IllegalStateException(
                    // Message to the user
                        String.format("Getter method : %s() has return type %s but expected %s",
                                getter.getName(),
                                getter.getReturnType().getTypeName(),
                                field.getType().getTypeName()));
            }
            // Also checking if tyhe getter method has no parameters/argument
            if (getter.getParameterCount() > 0) {
                // Getter has an argument
                throw new IllegalStateException(String.format("Getter : %s has %d arguments", getterName));
            }
        }
    }

    // Method getAllFields wich allows us to obtain all fields of a given class (clazz)
    // We can get even the fields inherited by superclasses
    private static List<Field> getAllFields(Class<?> clazz) {
        // We start by checking if the given class is correct
        if (clazz == null || clazz.equals(Object.class)) {
            //Given class not corrrect
            return Collections.emptyList();
        }
        // Creating a list of clazz's fields
        Field[] currentClassFields = clazz.getDeclaredFields();
        // Obtaining inherited fields
        List<Field> inheritedFields = getAllFields(clazz.getSuperclass());
        // Creating an arrayList thjat will contain all the fields obtained
        List<Field> allFields = new ArrayList<>();
        // We add the all the fields to arrayList
        allFields.addAll(Arrays.asList(currentClassFields));
        allFields.addAll(inheritedFields);
        // Return the arrayList
        return allFields;
    }

    // This method will capitalize the first letter of a method or field
    private static String capitalizeFirstLetter(String fieldName) {
        // Given a string that represents a method or a field, we will return the same string
        // but with the first letter capitalized
        return fieldName.substring(0, 1).toUpperCase().concat(fieldName.substring(1));
    }

    // Methof Map to map the name of the methods of a class to method objects
    private static Map<String, Method> mapMethodNameToMethod(Class<?> dataClass) {
        // Generating a list of method objects of class Class<?>
        Method[] allMethods = dataClass.getMethods();
        // Creating a new map for storing all methods names and their method object
        Map<String, Method> nameToMethod = new HashMap<>();
        // For all method objects, we add them into the previous map
        for (Method method : allMethods) {
            nameToMethod.put(method.getName(), method);
        }

        // Returning the map created
        return nameToMethod;
    }
}
