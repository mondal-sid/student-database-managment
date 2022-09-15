package com.sidd.java;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

;

public class IncludeInJSONProcessor {

    public void process(Object obj, Class clazz) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException {
        Field[] fields= clazz.getDeclaredFields();
        //System.out.println(fields.length);

        for(Field field : fields) {
            Annotation annotation = field.getAnnotation(IncludeInJSONString.class);
            if(annotation != null) {
                String name = field.getName();
                name = name.substring(0,1).toUpperCase()  + name.substring(1, name.length());
                //System.out.println(name);
                //Method method = clazz.getMethod("get" + name, null);
                Method method = clazz.getMethod("get" + name);
                System.out.println(method.invoke(obj));
            }
        }
    }
    
    public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException {
        Student s1 = new Student(01, "abc", "xy", "ab", "mn");
        Student s2 = new Student(02, "sss", "rrr", "ooo", "qq");

        List<Student> list = new ArrayList();
        list.add(s1);
        list.add(s2);
        
        IncludeInJSONProcessor obj = new IncludeInJSONProcessor();

        for(Student student : list)
            obj.process(student, Student.class);

    }
    
}
