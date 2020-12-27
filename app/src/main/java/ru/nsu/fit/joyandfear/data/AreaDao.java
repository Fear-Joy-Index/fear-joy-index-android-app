package ru.nsu.fit.joyandfear.data;

import android.database.Cursor;

import androidx.room.*;

import java.util.List;

@Dao
public interface AreaDao {
    @Query("SELECT * FROM area")
    Cursor getAll();

    @Query("SELECT * FROM area WHERE uid IN (:userIds)")
    Cursor loadAllByIds(int[] userIds);

    @Insert
    void insert(Area area);

    @Update
    int update(Area area);

    @Delete
    int delete(Area area);

    @Query("SELECT uid FROM area where hash = :hash")
    String uidByHash(String hash);
}
