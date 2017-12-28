package com.clasespersonalizadas;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author FABAME
 */
public abstract class LeerVariable {

    private static InputStreamReader isr = new InputStreamReader(System.in);
    private static BufferedReader br = new BufferedReader(isr);

    public LeerVariable() {

    }

    // Método para leer cadenas de texto con String
    public static String leerTextoString(String mensaje) {
        String textoString = "";
        try {
            System.out.println(mensaje);
            textoString = br.readLine();
        } catch (Exception ex) {
            System.out.println("Error" + ex);
        }

        return textoString;
    }

    // Método para leer números enteros con byte
    public static byte leerEnteroByte(String mensaje) {
        byte numeroByte = 0;
        try {
            System.out.println(mensaje);
            numeroByte = Byte.parseByte(br.readLine());
        } catch (Exception ex) {
            System.out.println("Error" + ex);
        }
        return numeroByte;
    }

    // Método para leer números enteros con short
    public static short leerEnteroShort(String mensaje) {
        short numeroShort = 0;
        try {
            System.out.println(mensaje);
            numeroShort = Short.parseShort(br.readLine());
        } catch (Exception ex) {
            System.out.println("Error" + ex);
        }
        return numeroShort;
    }

    // Método para leer números enteros con int
    public static int leerEnteroInt(String mensaje) {
        int numeroInt = 0;
        try {
            System.out.println(mensaje);
            numeroInt = Integer.parseInt(br.readLine());
        } catch (Exception ex) {
            System.out.println("Error" + ex);
        }
        return numeroInt;
    }

    // Método para leer números enteros con long
    public static long leerEnteroLong(String mensaje) {
        long numeroLong = 0;
        try {
            System.out.println(mensaje);
            numeroLong = Long.parseLong(br.readLine());
        } catch (Exception ex) {
            System.out.println("Error" + ex);
        }
        return numeroLong;
    }

    // Método para leer números decimales con float
    public static float leerDecimalFloat(String mensaje) {
        float numeroFloat = 0;
        try {
            System.out.println(mensaje);
            Float f = new Float(br.readLine());
            numeroFloat = f.floatValue();
        } catch (Exception ex) {
            System.out.println("Error" + ex);
        }
        return numeroFloat;
    }

    // Método para leer números decimales con double
    public static double leerDecimalDouble(String mensaje) {
        double numeroDouble = 0;
        try {
            System.out.println(mensaje);
            Double d = new Double(br.readLine());
            numeroDouble = d.doubleValue();
        } catch (Exception ex) {
            System.out.println("Error" + ex);
        }
        return numeroDouble;
    }

    // Método para leer datos lógicos con boolean
    public static boolean leerLogicoBoolean(String mensaje) {
        boolean estado = false;
        try {
            System.out.println(mensaje);
            estado = true;
        } catch (Exception ex) {
            System.out.println("Error" + ex);
        }
        return estado;
    }

    // Método para leer objetos con Object
    public static Object leerObjetoObject(String mensaje) {
        Object objeto = null;
        try {
            System.out.println(mensaje);
            objeto = (Object) br.readLine();
        } catch (Exception ex) {
            System.out.println("Error" + ex);
        }
        return objeto;
    }

}
