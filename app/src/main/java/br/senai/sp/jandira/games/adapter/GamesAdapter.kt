package br.senai.sp.jandira.games.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.senai.sp.jandira.games.R
import br.senai.sp.jandira.games.model.Game

class GamesAdapter(val context: Context) : RecyclerView.Adapter<GamesAdapter.HolderGame>() {
    private var gamesList = listOf<Game>()

    fun updateGameList(games: List<Game>) {
        this.gamesList = games
        notifyDataSetChanged()
    }

    class HolderGame(view: View) : RecyclerView.ViewHolder(view) {
        val subtitleGame = view.findViewById<TextView>(R.id.text_view_subtitulo)
        val titleGame = view.findViewById<TextView>(R.id.text_view_titulo)
        val descriptionGame = view.findViewById<TextView>(R.id.text_view_descricao)

        fun bind(game: Game) {
            subtitleGame.text = game.estudio
            titleGame.text = game.nome
            descriptionGame.text = game.descricao
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HolderGame {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.holder_layout, parent, false)
        return HolderGame(view)
    }

    override fun onBindViewHolder(holder: HolderGame, position: Int) {
        holder.bind(gamesList.get(position))
    }

    override fun getItemCount(): Int {
        return gamesList.size
    }
}