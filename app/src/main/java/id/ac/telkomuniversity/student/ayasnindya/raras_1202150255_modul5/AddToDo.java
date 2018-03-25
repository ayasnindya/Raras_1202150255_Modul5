package id.ac.telkomuniversity.student.ayasnindya.raras_1202150255_modul5;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddToDo extends AppCompatActivity {
    //deklarasi variablenya
    EditText Nama, Deskripsi, Prioritas;
    database db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_to_do);
        //set title menjadi add to do
        setTitle("Add To Do");

        //mengakses id pada layoout
        Nama = (EditText) findViewById(R.id.editTodo);
        Deskripsi = (EditText) findViewById(R.id.editDesc);
        Prioritas = (EditText) findViewById(R.id.editPriority);
        db = new database(this);
    }

    @Override
    public void onBackPressed() {
        //intent dari add to do menuju list to do
        Intent intent = new Intent(AddToDo.this, ListToDo.class);
        startActivity(intent);
        this.finish();
    }

    //method yang dijalanan ketika tombol tambah to do di klik
    public void tambah(View view) {
        //apabila data todoname, deskripsi dan prioritas di isi,
        if (db.inputdata(new AddData(Nama.getText().toString(), Deskripsi.getText().toString(), Prioritas.getText().toString()))){
            //maka akan menampilkan toast bawha data berhasil di tambahkan ke dalam list
            Toast.makeText(this, "To Do List added!", Toast.LENGTH_SHORT).show();
            //berpindah dari add to do ke list to do
            startActivity(new Intent(AddToDo.this, ListToDo.class));
            //menutup aktivitas agar tidak kembali ke activity yang dijalankan setelah intent
            this.finish();
        }else {
            //apabila edit text kosong maka akan muncul toast bahwa tidak bisa menambah ke dalam list
            Toast.makeText(this, "Cannot add the list", Toast.LENGTH_SHORT).show();
            Nama.setText(null);
            Deskripsi.setText(null);
            Prioritas.setText(null);
        }
    }

}
