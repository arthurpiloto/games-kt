package br.senai.sp.jandira.games.model

import android.content.Context
import br.senai.sp.jandira.games.R

enum class NiveisEnum(val res: Int) {
    INICIANTE(R.string.begginer),
    BASICO(R.string.basic),
    CASUAL(R.string.casual),
    AVANCADO(R.string.advanced)
}