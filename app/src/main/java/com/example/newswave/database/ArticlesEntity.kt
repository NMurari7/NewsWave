package com.example.newswave.database

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "articles")
data class ArticleEntity(
    @PrimaryKey
    val title: String,
    val content: String?,
    val description: String?,
    val image: String?
)