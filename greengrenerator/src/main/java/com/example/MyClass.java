package com.example;

import org.greenrobot.greendao.generator.DaoGenerator;
import org.greenrobot.greendao.generator.Entity;
import org.greenrobot.greendao.generator.Property;
import org.greenrobot.greendao.generator.Schema;

public class MyClass {

    public static void main(String[] args){
        Schema schema=new Schema(10,"com.zhang.greendao.dao");//生成的包名
        Entity person=schema.addEntity("Person");  //className  生成class名字
        person.addIdProperty().autoincrement();
        person.addStringProperty("name").notNull();
        person.addIntProperty("age");
        Property personProperty=person.addLongProperty("fatherId").getProperty();

        Entity father=schema.addEntity("PersonFather");  //className  生成class名字
        Property property=father.addIdProperty().autoincrement().getProperty();
        father.addStringProperty("name").notNull();
        father.addIntProperty("age");

        //多对1
        person.addToMany(father,personProperty);

        try {
            new DaoGenerator().generateAll(schema,"greengrenerator/src");//保证目录存在
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
