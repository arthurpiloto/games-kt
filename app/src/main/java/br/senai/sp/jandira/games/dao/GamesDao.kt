package br.senai.sp.jandira.games.dao

import android.content.Context
import android.graphics.drawable.Drawable
import br.senai.sp.jandira.games.R
import br.senai.sp.jandira.games.model.Game

class GamesDao() {
    companion object {
        fun getGames(context: Context): List<Game> {
            val game1 = Game()
            game1.id = 1
            game1.imagem = context.getDrawable(R.drawable.street_fighter)
            game1.subtitulo = "Capcom" // context.getString(R.string.street_fighter_subtitle)
            game1.titulo = "Street Fighter" // context.getString(R.string.street_fighter_title)
            game1.descricao = "Street Fighter, popularly abbreviated to SF, is a popular fighting game series." // context.getString(R.string.street_fighter_description)

            val game2 = Game()
            game2.id = 2
            game2.imagem = context.getDrawable(R.drawable.ninja_turtles_ii)
            game2.subtitulo = "Konami" // context.getString(R.string.ninja_turtles_ii_subtitle)
            game2.titulo = "Ninja Turtles II" // context.getString(R.string.ninja_turtles_ii_title)
            game2.descricao = "Teenage Mutant Ninja Turtles: Shredder's Revenge is a beat 'em up video game developed by Tribute Games." // context.getString(R.string.ninja_turtles_ii_description)

            val games = listOf<Game>(game1, game2)
            return games
        }
    }
}