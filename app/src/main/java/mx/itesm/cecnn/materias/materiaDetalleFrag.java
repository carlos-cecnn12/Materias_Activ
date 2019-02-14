package mx.itesm.cecnn.materias;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class materiaDetalleFrag extends Fragment {

    private int indice;

    public void setIndice(int indice) {
        this.indice = indice;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putInt("INDICE",indice);
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(savedInstanceState!=null){int tmp = savedInstanceState.getInt("INDICE",0);
        this.indice=tmp;
        }
    }

    public materiaDetalleFrag() {

    }

    @Override
    public void onStart() {
        super.onStart();
        View v = getView();
        if(v!=null){
            TextView tvTitulo = v.findViewById(R.id.tvTitulo);
            TextView tvDetalle = v.findViewById(R.id.tvDetalle);
            Materia materia = Materia.materias[indice];
            tvTitulo.setText(materia.getNombre());
            tvDetalle.setText(materia.getDescripcion());
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_materia_detalle, container, false);
    }

}
