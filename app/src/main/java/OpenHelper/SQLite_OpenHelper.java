package OpenHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SQLite_OpenHelper extends SQLiteOpenHelper{

    public SQLite_OpenHelper(@Nullable Context context, @Nullable String name,
                             @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query="create table usuarios(_ID integer primary key autoincrement," +
                "Nombres text, Apellidos text, Usuario text, Clave text);";
        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    //METODO ABRIR DB
    public void abrir () {
        this.getWritableDatabase();
    }

    //METODO CERRAR DB
    public void cerrar () {
        this.close();
    }

    //METODO INSERTAR REGISTROS EN TABLA USUARIOS
    public void insertarReg (String nom, String apell, String usu, String clav) {
        ContentValues valores=new ContentValues();
        valores.put("Nombres",nom);
        valores.put("Apellidos",apell);
        valores.put("Usuario",usu);
        valores.put("Clave",clav);
        this.getWritableDatabase().insert("usuarios", null, valores);
    }

    //METODO QUE VALIDA QUE EL USUARIO EXISTA
    public Cursor ConsultarUsuPas(String usu, String pas) throws SQLException{
        Cursor mcursor=null;
        mcursor=this.getWritableDatabase().query("usuarios", new String[]{"_ID",
            "Nombres", "Apellidos", "Usuario", "Clave"},"Usuario like '"+usu+"' " +
                "and Clave like '"+pas+"'", null, null, null, null);
        return mcursor;
    }
}
