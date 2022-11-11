package br.senai.sp.jandira.games.repository

import android.content.Context
import br.senai.sp.jandira.games.dao.console.ConsoleDb
import br.senai.sp.jandira.games.model.Console

class ConsoleRepository(context: Context) {
    private val db = ConsoleDb.getDataBase(context).consoleDao()

    fun save(console: Console): Long {
        return db.save(console)
    }

    fun update(console: Console): Int {
        return db.update(console)
    }

    fun delete(console: Console): Int {
        return db.delete(console)
    }

    fun getAll(): List<Console> {
        return db.getAll()
    }

    fun getConsoleById(id: Int): Console {
        return db.getConsoleById(id)
    }
}