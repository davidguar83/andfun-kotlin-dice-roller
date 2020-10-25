/*
 * Copyright 2018, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class MainActivity : AppCompatActivity() {
//contenedor de imagen
    lateinit var diceImage: ImageView
// inicia el programa
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)//este metodo carga el layout que le indiquemos, activity_dos o el que esta ahora.

        val rollButton: Button = findViewById(R.id.mi_boton)//crea la variable rollbuton de tipo Button, findViewById= recoge del contenedor del layout con el id y nombre selecionado y nos lo mete en la variable antes declarada.
        rollButton.setOnClickListener {//cada vez que le demos al botton se iniciara un Listener,  aciendo llamar al metodo rollDice(), que hace que se genere un numero aleatotio y nos muestre una imagen segun el numero selecionado
            rollDice()//llama al metodo
        }
//mete en el objeto el contenedor que le indiquemos con findViewById. findViewById= sirve para encontrar con el nombres de id del layout,lo que queremos cargar. gracias a la id que tienen en el contenedor de los layout..
        diceImage = findViewById(R.id.imagen_dado) //mete en el objeto diceImage, lo que encuentre en el contenedor del layout con el id dice_image
    }
// metodo que hace que los dados tengan valores diferentes.
    private fun rollDice() {
        val randomInt = Random().nextInt(6) + 1//mete en la variable randomInt un nº aleatorio entre 1-6
        val drawableResource = when (randomInt) {//parecido al cause. almacena en la variable drawableResource el valor que tiene la variable randomInt y le asigna una imagen, de las que estan almacenadas en el directorio drawable, mediante el nombre de la imagen
            1 -> R.drawable.lisa_loser//en vez de salir el dado 1, sale lisa llamandote loser
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.actor_secundario//esta vez sale el actor secundario
        }

        diceImage.setImageResource(drawableResource)//la imagen que tengo en (drawableResource)le asigno  con setImageResource  a la imagen del contenedor diceImagen
    }
}
