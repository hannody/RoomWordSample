package com.abunayla.roomwordsample

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface WordDao {

    @Query("SELECT * from word_table ORDER BY WORD ASC")
    fun getAlphabetizedWords():LiveData<List<Word>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(word:Word)

    @Query("Delete FROM word_table")
    suspend fun deleteAll()

}