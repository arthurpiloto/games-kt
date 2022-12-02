package br.senai.sp.jandira.games.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import br.senai.sp.jandira.games.R
import br.senai.sp.jandira.games.databinding.ActivityAddGameBinding
import br.senai.sp.jandira.games.model.Game
import br.senai.sp.jandira.games.repository.GameRepository

class AddGameActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddGameBinding
    lateinit var gameRepository: GameRepository
    lateinit var game: Game
    private var id = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddGameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        game = Game()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_signup, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.title == "Save") {
            if (save()) {
                return true
            }
            return false
        }
        return false
    }

    private fun validate(): Boolean {
        if (binding.editTextNewGameName.text.isEmpty()) {
            binding.editTextNewGameName.error = getString(R.string.game_name_error)
            return false
        } else if (binding.editTextNewGameDescription.text.isEmpty()) {
            binding.editTextNewGameDescription.error = getString(R.string.game_description_error)
            return false
        } else if (binding.editTextNewGameStudio.text.isEmpty()) {
            binding.editTextNewGameStudio.error = getString(R.string.game_studio_error)
            return false
        } else if (binding.editTextDate.text.isEmpty()) {
            binding.editTextDate.error = getString(R.string.game_release_error)
            return false
        }
        return true
    }

    private fun save(): Boolean {
        if (validate()) {
            game.nome = binding.editTextNewGameName.text.toString()
            game.descricao = binding.editTextNewGameDescription.text.toString()
            game.estudio = binding.editTextNewGameStudio.text.toString()

            if (binding.buttonFinishedNewGame.isChecked) {
                game.finalizado = true
            } else if (binding.buttonPlayingNewGame.isChecked) {
                game.finalizado = false
            }

            gameRepository = GameRepository(this)
            gameRepository.save(game)
            Toast.makeText(this, R.string.game_created, Toast.LENGTH_SHORT).show()
            finish()
        }
        return false
    }
}