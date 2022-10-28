package br.senai.sp.jandira.games.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import br.senai.sp.jandira.games.R
import br.senai.sp.jandira.games.databinding.ActivitySignupBinding

class SignupActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignupBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menu_signup_save) {
            validate()
            return true
        }
        return false
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_signup, menu)
        return true
    }

    private fun validate(): Boolean {
        if (binding.editTextEmailSignup.text.isEmpty()) {
            binding.editTextEmailSignup.error = getString(R.string.email_error)
            return false
        } else if (binding.editTextPasswordSignup.text.isEmpty()) {
            binding.editTextPasswordSignup.error = getString(R.string.password_error)
            return false
        } else if (binding.editTextNameSignup.text.isEmpty()) {
            binding.editTextNameSignup.error = getString(R.string.name_error)
            return false
        } else if (binding.editTextCitySignup.text.isEmpty()) {
            binding.editTextCitySignup.error = getString(R.string.city_error)
            return false
        } else if (binding.editTextBirthDateSignup.text.isEmpty()) {
            binding.editTextBirthDateSignup.error = getString(R.string.birth_date_error)
            return false
        }
        return true
    }
}
