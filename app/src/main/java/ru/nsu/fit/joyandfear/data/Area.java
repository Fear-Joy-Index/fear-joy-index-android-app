package ru.nsu.fit.joyandfear.data;

import androidx.annotation.NonNull;
import androidx.room.*;

@Entity
public class Area {
    @PrimaryKey
    @NonNull
    public String uid;

    @ColumnInfo(name = "hash")
    public String hash;

    @ColumnInfo(name = "polygon")
    public String polygon;

    @ColumnInfo(name = "score")
    public Double score;
}