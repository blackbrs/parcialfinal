package sv.edu.ues.fia.eisi.base;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;


import org.json.JSONObject;

public class ActualizarTabla2 extends AppCompatActivity implements Response.Listener<JSONObject>, Response.ErrorListener{
    EditText carnet;
    EditText apellido;
    EditText nombre;
    EditText sexo;
    EditText materias;
    RequestQueue request;
    JsonObjectRequest jsonObjectRequest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actualizar_tabla2);
        carnet = (EditText) findViewById(R.id.editCarnet);
        nombre= (EditText) findViewById(R.id.editNombre);
        apellido = (EditText) findViewById(R.id.editApellido);
        sexo = (EditText) findViewById(R.id.editSexo);
        materias = (EditText) findViewById(R.id.editMateriasGanadas);
        request= Volley.newRequestQueue(getApplicationContext());
    }
    public void cargarWebServiceLocal(View v){
        if(carnet.getText().toString().isEmpty() || nombre.getText().toString().isEmpty() || apellido.getText().toString().isEmpty() || sexo.getText().toString().isEmpty() || materias.getText().toString().isEmpty()){
            Toast.makeText(getApplicationContext(),"Debes llenar todos los campos ",Toast.LENGTH_LONG).show();
        }else{
            String url ="http://ca14080.000webhostapp.com/ws_update_estudiante.php?carnet="+ carnet.getText().toString()+
                    "&nombre="+nombre.getText().toString()+
                    "&apellido="+apellido.getText().toString()+
                    "&sexo="+sexo.getText().toString()+
                    "&matganadas="+materias.getText().toString();

            url=url.replace(" ","%20");
            jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,url,null,this,this);
            request.add(jsonObjectRequest);
        }
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Toast.makeText(getApplicationContext(),"No se puedo registrar, asegurate de llenar todos los campos y/o no introducir un usuario ya registrado", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onResponse(JSONObject response) {
        Toast.makeText(getApplicationContext(),"Se ha registrado exitosamente",Toast.LENGTH_LONG).show();
        apellido.setText("");
        sexo.setText("");
        nombre.setText("");
        carnet.setText("");
        materias.setText("");

    }

}
