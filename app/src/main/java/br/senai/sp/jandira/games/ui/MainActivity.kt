package br.senai.sp.jandira.games.ui

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import br.senai.sp.jandira.games.R
import br.senai.sp.jandira.games.databinding.ActivityMainBinding
import br.senai.sp.jandira.games.model.Usuario
import br.senai.sp.jandira.games.repository.UsuarioRepository

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var usuarioRepository: UsuarioRepository
    var usuario: Usuario? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar!!.hide()

        binding.textSignup.setOnClickListener {
            val openSignUpActivity = Intent(this, SignupActivity::class.java)
            startActivity(openSignUpActivity)
        }

        binding.buttonLogin.setOnClickListener {
            if (login()) {
                usuarioRepository = UsuarioRepository(this)
                usuario = usuarioRepository.getUsuarioByEmail(binding.editTextEmail.text.toString())

                val openGameListActivity = Intent(this, GameListActivity::class.java)
                openGameListActivity.putExtra("id", usuario?.id)
                startActivity(openGameListActivity)
            }
        }
    }

    private fun login(): Boolean {
        if (validate()) {
            usuarioRepository = UsuarioRepository(this)
            usuario = usuarioRepository.getUsuarioByEmail(binding.editTextEmail.text.toString()) // retorna o usuario com o email digitado

            if (usuario === null) {
                Toast.makeText(this, R.string.email_notfound, Toast.LENGTH_SHORT).show()
                return false
            }
            if (binding.editTextPassword.text.toString() != usuario?.senha) {
                Toast.makeText(this, R.string.password_notfound, Toast.LENGTH_SHORT).show()
                return false
            }
            return true
        }
        return false
    }

    private fun validate(): Boolean {
        if (binding.editTextEmail.text.isEmpty()) {
            binding.editTextEmail.error = getString(R.string.email_error)
            return false
        }
        if (binding.editTextPassword.text.isEmpty()) {
            binding.editTextPassword.error = getString(R.string.password_error)
            return false
        }
        return true
    }
}