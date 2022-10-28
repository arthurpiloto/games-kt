package br.senai.sp.jandira.games.model

import android.graphics.drawable.Drawable
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tbl_game")
class Game {
    @PrimaryKey(autoGenerate = true)
    var id = 0

    var imagem: Drawable? = null
    var subtitulo = ""
    var titulo = ""
    var descricao = ""
}