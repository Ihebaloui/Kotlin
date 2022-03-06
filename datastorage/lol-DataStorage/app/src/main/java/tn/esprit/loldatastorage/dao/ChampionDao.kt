package tn.esprit.loldatastorage.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import tn.esprit.leagueoflegendrecyclerview.data.Champion


//TODO 7 "Create the dao for the entity"
@Dao
interface ChampionDao {

    @Insert
    fun insert(c: Champion)

    @Delete
    fun delete(c: Champion)

    @Query("SELECT * FROM champion")    // champion esm el table
    fun getAll() : List<Champion>

}