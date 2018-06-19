package sv.edu.ues.fia.eisi.base;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.android.volley.TimeoutError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;


public class EliminarTabla2 extends AppCompatActivity implements Response.Listener<JSONObject>, Response.ErrorListener {
    EditText Car;
    RequestQueue request;
    JsonObjectRequest jsonObjectRequest;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eliminar_tabla2);
        Car = (EditText) findViewById(R.id.Dcarnet);
        request= Volley.newRequestQueue(getApplicationContext());
    }

    public void eliminarEstu(View v){
        String url="http://ca14080.000webhostapp.com/ws_estudiante_eliminar.php?carnet="+Car.getText().toString();
        jsonObjectRequest= new JsonObjectRequest(Request.Method.GET, url,null,this,this);
        request.add(jsonObjectRequest);

    }

    @Override
    public void onResponse(JSONObject response) {
        Toast.makeText(getApplicationContext(),"Se ha eliminado exitosamente",Toast.LENGTH_LONG).show();
        Car.setText(" ");

    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Toast.makeText(getApplicationContext(),"No se puedo eliminar: "+error.toString(), Toast.LENGTH_LONG).show();

    }

}
