package br.senai.sp.jandira.games.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.senai.sp.jandira.games.R
import br.senai.sp.jandira.games.adapter.GamesAdapter
import br.senai.sp.jandira.games.dao.game.GamesDao
import br.senai.sp.jandira.games.databinding.ActivityGameListBinding
import br.senai.sp.jandira.games.model.Usuario
import br.senai.sp.jandira.games.repository.UsuarioRepository

class GameListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGameListBinding
    lateinit var rvGames: RecyclerView
    lateinit var adapterGames: GamesAdapter
    private var id = 0
    lateinit var usuarioRepository: UsuarioRepository
    var usuario: Usuario? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGameListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        rvGames = findViewById(R.id.rv_games_rv)
        rvGames.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        adapterGames = GamesAdapter(this)
        adapterGames.updateGameList(GamesDao.getGames(this))

        rvGames.adapter = adapterGames

        loadProfile()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_game_list, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.title.toString() == "Add") {
            val openAddGameActivity = Intent(this, AddGameActivity::class.java)
            startActivity(openAddGameActivity)
            return true
        }
        return true
    }

    private fun loadProfile() {
        usuarioRepository = UsuarioRepository(this)

        id = intent.getIntExtra("id", 0)

        usuario = usuarioRepository.getUsuarioById(id)

        binding.textViewNameGame.text = usuario?.nome
        binding.textViewEmailGame.text = usuario?.email
        binding.textViewLevelGame.text = usuario?.nivel.toString()
    }
}