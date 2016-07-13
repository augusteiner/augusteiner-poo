
package poo.jdbc.exemplo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.bson.Document;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
public class App {

    /**
     * {@link https://bitbucket.org/dbschema/mongo-jdbc/src}
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {

        Connection conn;
        Statement stmt;

        Class.forName("com.dbschema.MongoJdbcDriver");

        conn = DriverManager.getConnection("jdbc:mongodb://127.0.0.1/db");

        stmt = conn.createStatement();
        stmt.executeQuery("db.alunos.insert({nome: '@augusteiner', endereco: 'R. das Camélias, 27'})");

        ResultSet rs = stmt.executeQuery("db.alunos.find()");

        while (rs.next()) {

            Document doc = (Document) rs.getObject(1);

            System.out.println(doc.get("nome"));
            System.out.println(doc.get("endereco"));
        }
    }
}
