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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class consultarMateria extends AppCompatActivity implements Response.Listener<JSONObject>, Response.ErrorListener  {
        EditText codigo;
        EditText nombre;
        EditText unidades;
    RequestQueue request;
    JsonObjectRequest jsonObjectRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar_materia);
        codigo = (EditText)findViewById(R.id.CodmateriaEdt);
        nombre = (EditText)findViewById(R.id.nombreEdt);
        unidades = (EditText)findViewById(R.id.unidadesEdt);
        request= Volley.newRequestQueue(getApplicationContext());
    }
    public void consultarWebServices(View v){
        String url= "https://ca14080.000webhostapp.com/ws_consultar.php?codmateria="+codigo.getText().toString();
        jsonObjectRequest=new JsonObjectRequest(Request.Method.GET,url,null,this,this);
        request.add(jsonObjectRequest);

    }


    @Override
    public void onResponse(JSONObject response) {
        Toast.makeText(getApplicationContext(),"Conexion y Consulta Exitosa",Toast.LENGTH_LONG).show();
        Materia e = new Materia();

        //JSONArray json=response.optJSONArray("carnet");
        JSONObject jsonObject= new JSONObject();

        jsonObject=response;
        e.setCodmateria(jsonObject.optString("CODMATERIA"));
        e.setNommateria(jsonObject.optString("NOMMATERIA"));
        e.setUnidadesval(jsonObject.optString("UNIDADESVAL"));


        nombre.setText(e.getNommateria());
        unidades.setText(e.getUnidadesval());


    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Toast.makeText(getApplicationContext(),"No se pudo Consultar, no se encontro el registro",Toast.LENGTH_LONG).show();


    }

}
