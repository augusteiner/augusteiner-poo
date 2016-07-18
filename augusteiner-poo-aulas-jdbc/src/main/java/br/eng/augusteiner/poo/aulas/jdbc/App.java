/*
 * MIT License
 *
 * Copyright (c) 2016 José Augusto & Juscelino Messias
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package br.eng.augusteiner.poo.aulas.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
public class App {

    public static void main(String[] args) throws Exception {

        Connection conn;
        PreparedStatement pStmt;
        Statement query;

        String db = "mysql";

        Properties connectionProps = new Properties();
        connectionProps.put("user", "root");
        connectionProps.put("password", "password");

        if (db.equals("mysql")) {

            Class.forName("com.mysql.jdbc.Driver").newInstance();

            conn = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:4040/dbteste?user=root&password=password&useSSL=false",
                connectionProps);
        } else /* if (db.equals("mongo")) */ {

            conn = DriverManager.getConnection(
                "jdbc:mongo://127.0.0.1:27017/teste;create=true",
                connectionProps);
        }

        System.out.println("Connected to database");

        pStmt = conn.prepareStatement("DESCRIBE aluno");

//        pStmt.setString(1, "abc");
        pStmt.execute();

        ResultSet rs1 = pStmt.getResultSet();

        rs1.first();

        Object r = rs1.getString(1);

        System.out.println(r);

        query = conn.createStatement();

        ResultSet rs2 = query.executeQuery("SELECT * FROM aluno");

        while (rs2.next()) {

            int id = rs2.getInt("idaluno");
            String nome = rs2.getString("nome");
            String endereco = rs2.getString("endereco");

            System.out.println(String.format("ID: %d, Nome: %s, Endereço: %s", id, nome, endereco));
        }

        /*CREATE TABLE `aluno` (
            `idaluno` int(10) unsigned NOT NULL AUTO_INCREMENT,
            `nome` varchar(45) DEFAULT NULL,
            `endereco` varchar(45) DEFAULT NULL,
            PRIMARY KEY (`idaluno`)
          ) ENGINE=InnoDB;*/

        pStmt = conn.prepareStatement("INSERT INTO aluno (nome, endereco) VALUES (?, ?)");

        pStmt.setString(1, "!@*&!*&#&!#");
        pStmt.setString(2, "R. dos Alfeneiros, 321");

        pStmt.execute();

        conn.close();
    }
}
