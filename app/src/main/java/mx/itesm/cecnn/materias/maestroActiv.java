package mx.itesm.cecnn.materias;

import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class maestroActiv extends AppCompatActivity implements listaMateriasFrag.Listener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maestro);
    }


    @Override
    public void itemClicked(int posicion) {
        View v=findViewById(R.id.contenedor);
        if(v == null){
            Intent intDetalle = new Intent(this, detalleActiv.class);
            intDetalle.putExtra("POSICION",posicion);
            startActivity(intDetalle);
        }else{
            materiaDetalleFrag fragDetalle = new materiaDetalleFrag();
            fragDetalle.setIndice(posicion);
            FragmentTransaction transaccion = getSupportFragmentManager().beginTransaction();
            transaccion.replace(R.id.contenedor,fragDetalle);
            transaccion.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE);
            transaccion.addToBackStack(null);
            transaccion.commit();
        }
    }

}
