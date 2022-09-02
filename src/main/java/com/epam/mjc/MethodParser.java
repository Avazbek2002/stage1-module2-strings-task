package com.epam.mjc;

import java.util.ArrayList;
import java.util.List;

public class MethodParser {

    /**
     * Parses string that represents a method signature and stores all it's members into a {@link MethodSignature} object.
     * signatureString is a java-like method signature with following parts:
     *      1. access modifier - optional, followed by space: ' '
     *      2. return type - followed by space: ' '
     *      3. method name
     *      4. arguments - surrounded with braces: '()' and separated by commas: ','
     * Each argument consists of argument type and argument name, separated by space: ' '.
     * Examples:
     *      accessModifier returnType methodName(argumentType1 argumentName1, argumentType2 argumentName2)
     *      private void log(String value)
     *      Vector3 distort(int x, int y, int z, float magnitude)
     *      public DateTime getCurrentDateTime()
     *
     * @param signatureString source string to parse
     * @return {@link MethodSignature} object filled with parsed values from source string
     */
    public MethodSignature parseFunction(String signatureString) {
        String[] tokens        = signatureString.split("[(), ]");
        String accessModifiers = "protectedprivatepublic";
        MethodSignature output;
        String accessModifier;
        String returnType;
        String methodName;
        List <MethodSignature.Argument> arguments = null;

        if (accessModifiers.contains(tokens[0])) {
            accessModifier = tokens[0];
            returnType     = tokens[1];
            methodName     = tokens[2];
            if (tokens.length > 3) {
                arguments = new ArrayList<>();
                for (int i = 3; i < tokens.length; i += 3) {
                    if (tokens[i].equals(""))
                        continue;

                    arguments.add(new MethodSignature.Argument(tokens[i], tokens[i + 1]));
                }
            }
            output = new MethodSignature(methodName, arguments);
            output.setReturnType(returnType);
            output.setAccessModifier(accessModifier);
        }

        else {
            returnType = tokens[0];
            methodName = tokens[1];
            if (tokens.length > 2) {
                arguments = new ArrayList<>();
                for (int i = 2; i < tokens.length; i += 3) {
                    if (tokens[i].equals(""))
                        continue;

                    arguments.add(new MethodSignature.Argument(tokens[i], tokens[i + 1]));
                }
            }
            output = new MethodSignature(methodName, arguments);
            output.setReturnType(returnType);
        }

        return output;
    }

    public static void testParse (String signature) {
        String[] tokens = signature.split("[(), ]");

        System.out.println(tokens.length);

    }

    /* public static void main (String[] args) {
        MethodSignature hello = parseFunction("public DateTime getCurrentDateTime()");
        System.out.println("Access Modifier: " + hello.getAccessModifier());
        System.out.println("Return Type: " + hello.getReturnType());
        System.out.println("Method Name: " + hello.getMethodName());
        if (hello.getArguments() != null) {
            for (MethodSignature.Argument argument : hello.getArguments()) {
                System.out.println("Argument Type: " + argument.getType() + "; Argument Name: " + argument.getName());
            }
        }
    }*/
}
