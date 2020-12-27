package ru.nsu.fit.joyandfear.data;

import androidx.room.*;

import java.util.List;

@Dao
public interface QueryDateDao {
    @Query("SELECT * FROM querydate")
    List<QueryDate> getAll();

    @Query("SELECT * FROM querydate WHERE query_uri IN (:userIds)")
    List<QueryDate> loadAllByIds(int[] userIds);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(QueryDate... queryDates);

    @Delete
    void delete(QueryDate queryDate);
}
