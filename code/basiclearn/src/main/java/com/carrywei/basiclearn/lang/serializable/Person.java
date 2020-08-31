package com.carrywei.basiclearn.lang.serializable;


import java.io.*;

public class Person implements Serializable{

    private static final String FILE_PATH = "D://Test/javaobj";
    private String name;
//    private transient int age; // transient阻止序列化
    private int age;
    private static final long serialVersionUID = 1L;

    private final static void serialize(Person p) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH));
        oos.writeObject(p);
        oos.close();
    }

    private final static Person deserialize() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH));
        return (Person) ois.readObject();
    }

    private static Person cloneBySerialize(Person p) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(p);
        oos.close();

        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bais);
        return (Person) ois.readObject();
    }


    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    @Override
    public String toString() {
        return "Person:[name=" + name + ",age=" + age + "]";
    }

    public static void main(String[] args) throws Exception{
        Person p = new Person("wsw", 18);
        serialize(p);
        System.out.println(deserialize());

        Person p1 = new Person("wsw", 26);
        System.out.println(cloneBySerialize(p1));
    }
}
