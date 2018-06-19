package sv.edu.ues.fia.eisi.base;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

public class InsertarTabla1 extends AppCompatActivity implements Response.Listener<JSONObject>, Response.ErrorListener {

EditText codmateria;
EditText nommateria;
EditText unidadesval;
    RequestQueue request;
    JsonObjectRequest jsonObjectRequest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertar_tabla1);
     codmateria = (EditText) findViewById(R.id.editCodemateria);
     nommateria = (EditText) findViewById(R.id.editNomMat);
     unidadesval = (EditText) findViewById(R.id.editval);
     request= Volley.newRequestQueue(getApplicationContext());
    }

    public void cargarWebServiceLocal(View v){
        if(codmateria.getText().toString().isEmpty() || nommateria.getText().toString().isEmpty() || unidadesval.getText().toString().isEmpty() ){
            Toast.makeText(getApplicationContext(),"Debes llenar todos los campos ",Toast.LENGTH_LONG).show();
        }else{
            String url ="http://ca14080.000webhostapp.com/ws_insertar_materia.php?codmateria="+ codmateria.getText().toString()+
                    "&nommateria="+nommateria.getText().toString()+
                    "&unidadesval="+unidadesval.getText().toString();

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
        codmateria.setText("");
        nommateria.setText("");
        unidadesval.setText("");


    }
}

