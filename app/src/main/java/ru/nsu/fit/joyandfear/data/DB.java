package ru.nsu.fit.joyandfear.data;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Area.class, QueryDate.class}, version = 1)
public abstract class DB extends RoomDatabase {
    public abstract AreaDao areaDao();
    public abstract QueryDateDao queryDateDao();


}