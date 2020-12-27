package ru.nsu.fit.joyandfear.data;

import androidx.annotation.NonNull;
import androidx.room.*;

@Entity
public class QueryDate {
    @PrimaryKey
    @NonNull
    public String query_uri;

    @ColumnInfo(name = "date")
    public Long timestamp;

    public QueryDate(String query_uri, Long timestamp) {
        this.query_uri = query_uri;
        this.timestamp = timestamp;
    }
}