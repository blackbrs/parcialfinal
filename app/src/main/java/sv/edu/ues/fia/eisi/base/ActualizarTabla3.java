package sv.edu.ues.fia.eisi.base;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import org.json.JSONObject;

public class ActualizarTabla3 extends AppCompatActivity implements Response.Listener<JSONObject>, Response.ErrorListener{
    EditText codigomateria;
    EditText carnet;
    EditText ciclo;
    EditText notafinal;
    RequestQueue request;
    JsonObjectRequest jsonObjectRequest;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actualizar_tabla3);
        codigomateria = (EditText) findViewById(R.id.Ecmateria);
        carnet = (EditText) findViewById(R.id.ECarnet);
        ciclo = (EditText) findViewById(R.id.ECiclo);
        notafinal = (EditText) findViewById(R.id.ENotafinal);
        request= Volley.newRequestQueue(getApplicationContext());
    }

    public void cargarWeb(View v){
        if(codigomateria.getText().toString().isEmpty() || carnet.getText().toString().isEmpty() || ciclo.getText().toString().isEmpty()|| notafinal.getText().toString().isEmpty() ){
            Toast.makeText(getApplicationContext(),"Debes llenar todos los campos ",Toast.LENGTH_LONG).show();
        }else{
            String url ="http://192.168.1.9/ws_nota_update.php?codmateria="+ codigomateria.getText().toString()+
                    "&carnet="+carnet.getText().toString()+
                    "&ciclo="+ciclo.getText().toString()+
                    "&notafinal="+notafinal.getText().toString();

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
        codigomateria.setText("");
        carnet.setText("");
        ciclo.setText("");
        notafinal.setText("");


    }
}
