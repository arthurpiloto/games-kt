package br.senai.sp.jandira.games.model

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate

@Entity(tableName = "tbl_game")
class Game {
    @PrimaryKey(autoGenerate = true)
    var id = 0

//    var imagem: Bitmap? = null
    var estudio = ""
    var nome = ""
    var descricao = ""

    var finalizado: Boolean = false

//    @ColumnInfo(name = "ano_lancamento")
//    var anoLancamento: LocalDate? = null
}