package br.senai.sp.jandira.games.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.senai.sp.jandira.games.R
import br.senai.sp.jandira.games.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

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
            validate()
            val openGameListActivity = Intent(this, GameListActivity::class.java)
            startActivity(openGameListActivity)
        }
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