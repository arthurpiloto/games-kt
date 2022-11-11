package br.senai.sp.jandira.games.repository

import android.content.Context
import br.senai.sp.jandira.games.dao.game.GameDb
import br.senai.sp.jandira.games.model.Game

class GameRepository(context: Context) {
    private val db = GameDb.getDataBase(context).gameDao()

    fun save(game: Game): Long {
        return db.save(game)
    }

    fun update(game: Game): Int {
        return db.update(game)
    }

    fun delete(game: Game): Int {
        return db.delete(game)
    }

    fun getAll(): List<Game> {
        return db.getAll()
    }

    fun getGameById(id: Int): Game {
        return db.getGameById(id)
    }
}