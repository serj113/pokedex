package com.serj113.pokedex.common.presentation

import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.font.FontWeight
import com.serj113.pokedex.core.model.Stat

object PokemonStatus {
  private const val MAX_HP = 300f
  private const val MAX_ATTACK = 300f
  private const val MAX_DEFENSE = 300f
  private const val MAX_SPECIAL_ATTACK = 300f
  private const val MAX_SPECIAL_DEFENSE = 300f
  private const val MAX_SPEED = 300f
  const val MAX_EXP = 1000f

  private const val HP = "HP"
  private const val ATTACK = "ATK"
  private const val DEFENSE = "DEF"
  private const val SPECIAL_ATTACK = "S.ATK"
  private const val SPECIAL_DEFENSE = "S.DEF"
  private const val SPEED = "SPD"

  fun getStatusProgress(stat: Stat): Float {
    val divider = when (stat.stat.name) {
      "hp" -> MAX_HP
      "attack" -> MAX_ATTACK
      "defense" -> MAX_DEFENSE
      "special-attack" -> MAX_SPECIAL_ATTACK
      "special-defense" -> MAX_SPECIAL_DEFENSE
      "speed" -> MAX_SPEED
      else -> 300f
    }
    return stat.baseStat / divider
  }

  fun getStatusAbbreviation(stat: Stat): String {
    return when (stat.stat.name) {
      "hp" -> HP
      "attack" -> ATTACK
      "defense" -> DEFENSE
      "special-attack" -> SPECIAL_ATTACK
      "special-defense" -> SPECIAL_DEFENSE
      "speed" -> SPEED
      else -> stat.stat.name.capitalize()
    }
  }

  fun getStatusFontWeight(stat: Stat): FontWeight {
    return when (stat.stat.name) {
      "hp", "attack", "defense", "speed" -> FontWeight.SemiBold
      "special-attack", "special-defense" -> FontWeight.ExtraBold
      else -> FontWeight.Medium
    }
  }
}