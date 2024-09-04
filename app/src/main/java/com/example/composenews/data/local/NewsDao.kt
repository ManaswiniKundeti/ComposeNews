package com.example.composenews.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.example.composenews.domain.model.Article
import kotlinx.coroutines.flow.Flow
import retrofit2.http.Query

@Dao
interface NewsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(article: Article) // upsert does both insert and update if we use the conflict strategy as above

    @Delete
    suspend fun delete(article: Article)

    @androidx.room.Query("SELECT * FROM Article")
    fun getArticles(): Flow<List<Article>>

}