package br.senai.sp.jandira.games.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import br.senai.sp.jandira.games.R
import br.senai.sp.jandira.games.databinding.ActivitySignupBinding
import br.senai.sp.jandira.games.model.NiveisEnum
import br.senai.sp.jandira.games.model.Usuario
import br.senai.sp.jandira.games.repository.UsuarioRepository

class SignupActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignupBinding
    lateinit var usuarioRepository: UsuarioRepository
    lateinit var usuario: Usuario

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        usuario = Usuario()

        binding.gamerLevelSignup.text = getString(NiveisEnum.INICIANTE.res)

        binding.sliderSignup.addOnChangeListener { slider, value, fromUser ->
            binding.gamerLevelSignup.text = getSliderText(binding.sliderSignup.value.toInt())
        }
    }

    private fun getSliderText(position: Int): String {
        if (position <= 0) return getString(NiveisEnum.INICIANTE.res)
        if (position in 1..1) return getString(NiveisEnum.BASICO.res)
        if (position in 2..2) return getString(NiveisEnum.CASUAL.res)
        if (position in 3..3) return getString(NiveisEnum.AVANCADO.res)
        return getString(NiveisEnum.INICIANTE.res)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.title == "Save") {
            if (validate()) {
                usuario.nome = binding.editTextNameSignup.text.toString()
                usuario.cidade = binding.editTextCitySignup.text.toString()
                usuario.email = binding.editTextEmailSignup.text.toString()
                usuario.senha = binding.editTextPasswordSignup.text.toString()

                when(binding.sliderSignup.value.toInt()) {
                    0 -> usuario.nivel = NiveisEnum.INICIANTE
                    1 -> usuario.nivel = NiveisEnum.BASICO
                    2 -> usuario.nivel = NiveisEnum.CASUAL
                    3 -> usuario.nivel = NiveisEnum.AVANCADO
                }

                if (binding.buttonFemaleSignup.isChecked) {
                    usuario.sexo = 'F'
                } else {
                    usuario.sexo = 'M'
                }

                usuarioRepository = UsuarioRepository(this)
                usuarioRepository.save(usuario)
                Toast.makeText(this, R.string.user_created, Toast.LENGTH_SHORT).show()
                finish()
            } else {
                return false
            }
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
