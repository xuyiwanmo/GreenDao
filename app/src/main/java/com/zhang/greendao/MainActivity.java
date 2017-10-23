package com.zhang.greendao;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.zhang.greendao.dao.DaoSession;
import com.zhang.greendao.dao.Person;
import com.zhang.greendao.dao.PersonDao;

import java.util.List;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        save();
        getPerson();
    }

    public void save() {
        DaoSession session = MyApp.getApp().getDaoSession();
        PersonDao dao=session.getPersonDao();
        Person person=new Person("张华",27);  //id自动增加
        dao.insert(person);
    }

    public void update(Person person){
        PersonDao dao=MyApp.getApp().getDaoSession().getPersonDao();
        dao.insertOrReplace(person);
    }

    public void delete(Person person){
        PersonDao dao=MyApp.getApp().getDaoSession().getPersonDao();
        dao.delete(person);
        dao.deleteAll();
    }

    public void getPerson() {
        PersonDao dao=MyApp.getApp().getDaoSession().getPersonDao();
        List<Person> list=dao.queryBuilder().list();
        for (Person person : list) {
            Log.i("zhang","person"+person.getId()+person.getName());
        }
    }
}
