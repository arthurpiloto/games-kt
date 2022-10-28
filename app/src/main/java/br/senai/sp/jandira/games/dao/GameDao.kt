package br.senai.sp.jandira.games.dao

import androidx.room.*
import br.senai.sp.jandira.games.model.Game

@Dao
interface GameDao {
    @Insert
    fun save(game: Game): Long

    @Delete
    fun delete(game: Game): Int

    @Update
    fun update(game: Game): Int

    @Query("SELECT * FROM tbl_game ORDER BY titulo ASC")
    fun getAll(): List<Game>

    @Query("SELECT * FROM tbl_game WHERE id = :id")
    fun getContactById(id: Int): Game
}