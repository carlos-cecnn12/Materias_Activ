package mx.itesm.cecnn.materias;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class detalleActiv extends AppCompatActivity {

    private materiaDetalleFrag fragMateriaDetalle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);
        fragMateriaDetalle = (materiaDetalleFrag) getSupportFragmentManager().findFragmentById(R.id.fragMateriaDetalle);
        fragMateriaDetalle.setIndice(getIntent().getIntExtra("POSICION",0));
    }


}
