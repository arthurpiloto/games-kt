package br.senai.sp.jandira.games.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.senai.sp.jandira.games.model.Game

@Database(entities = [Game::class], version = 1)
abstract class GameDb: RoomDatabase() {
    abstract fun contactDao(): GameDao

    companion object {
        private lateinit var instance: GameDb

        fun getDataBase(context: Context): GameDb {
            if (!::instance.isInitialized) {
                instance = Room.databaseBuilder(context, GameDb::class.java, "db_games").allowMainThreadQueries().build()
            }
            return instance
        }
    }
}