package edu.upc.dsa.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ObjectHelper {
    public static String[] getFields(Object entity) {

        Class theClass = entity.getClass();

        Field[] fields = theClass.getDeclaredFields();

        String[] sFields = new String[fields.length];
        int i=0;

        for (Field f: fields) sFields[i++]=f.getName();

        return sFields;

    }


    public static void setter(Object object, String property, Object value) throws InvocationTargetException, IllegalAccessException {
        // Method // invoke
        Object result = null;
        Class theClass = object.getClass();
        Method[] methods = theClass.getMethods();
        //Method setter = theClass.getMethod(property, String.class);

        for(Method method : methods){
            if(isSetter(method)){
                if(method.getName().toLowerCase().startsWith(property, 3))
                    method.invoke(object,value);
            }
        }
    }

    public static Object getter(Object object, String property) throws InvocationTargetException, IllegalAccessException {
        // Method // invoke

        Object result = null;
        Class theClass = object.getClass();
        Method[] methods = theClass.getMethods();   // method , todas las funciones de OBject

        for(Method method : methods){
            if(isGetter(method)){
                if(method.getName().toLowerCase().startsWith(property, 3)) // a partir de la palabra get busca la siguiente palabra que hay
                    result =method.invoke(object);                                  //por ejemplo getName pues encuentra name
            }
        }
        return result;
    }

    public static boolean isGetter(Method method){    //comprueba si es un get
        if(!method.getName().startsWith("get"))      return false;   // comparando las primeras letras
        if(method.getParameterTypes().length != 0)   return false;    // nos da 0 si la funcion no recibe parametro
        if(void.class.equals(method.getReturnType())) return false;
        return true;

    }
    public static boolean isSetter(Method method){
        if(!method.getName().startsWith("set")) return false;
        if(method.getParameterTypes().length != 1) return false;   // nos da 1 si la funcion si recibe parametro
        return true;
    }
}
