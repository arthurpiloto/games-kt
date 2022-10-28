package br.senai.sp.jandira.games.repository

import android.content.Context
import br.senai.sp.jandira.games.dao.GameDb
import br.senai.sp.jandira.games.model.Game

class GameRepository(context: Context) {
    private val db = GameDb.getDataBase(context).contactDao()

    fun save(contact: Game): Long {
        return db.save(contact)
    }

    fun update(contact: Game): Int {
        return db.update(contact)
    }

    fun delete(contact: Game): Int {
        return db.delete(contact)
    }

    fun getAll(): List<Game> {
        return db.getAll()
    }

    fun getContactById(id: Int): Game {
        return db.getContactById(id)
    }
}