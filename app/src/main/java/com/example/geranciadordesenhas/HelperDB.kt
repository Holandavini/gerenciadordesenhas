package com.example.geranciadordesenhas

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class HelperDB (context: Context): SQLiteOpenHelper(context, NOME_BANCO, null, VERSAO_ATUAL){

    companion object {
        private val NOME_BANCO = "registros.db"
        private val VERSAO_ATUAL = 1
    }

    val nomeTabela = "senhas"
    val colunaId = "id"
    val colunaServico = "servico"
    val colunaUsuario = "usuario"
    val colunaSenha = "senha"
    val colunaAtualizado = "atualizado_em"
    val colunaCriada = "criada_em"
    val dropTable = "DROP TABLE IF EXISTS $nomeTabela"
    val createTable = "CREATE TABLE $nomeTabela (" +
            "$colunaId INTEGER NOT NULL," +
            "$colunaServico TEXT NOT NULL," +
            "$colunaUsuario TEXT NOT NULL," +
            "$colunaSenha TEXT NOT NULL," +
            "$colunaAtualizado DATETIME NOT NULL," +
            "$colunaCriada DATETIME NOT NULL," +
            "" +
            "PRIMARY KEY($colunaId AUTOINCREMENT)" + ")"

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(createTable)
    }


    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        if (oldVersion != newVersion) {
            db?.execSQL(dropTable)
            onCreate(db)
        }
    }

    fun registrarSenha(senha: Senha) {
        val db = writableDatabase ?: return
        val sql = "INSERT INTO $nomeTabela ($colunaServico, $colunaUsuario, $colunaSenha) VALUES (?,?,?)"
        val informacoes = arrayOf(senha.servico,senha.usuario,senha.senha)
        db.execSQL(sql, informacoes)
        db.close()
    }

    fun buscarSenha(busca: String){
        val db = readableDatabase ?: return
        //Finalizar querys
    }

}