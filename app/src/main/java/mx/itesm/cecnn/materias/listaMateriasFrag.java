package mx.itesm.cecnn.materias;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class listaMateriasFrag extends ListFragment {


    private Listener listener;

    public listaMateriasFrag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        String[] nombreMaterias= new String[Materia.materias.length];

        for(int i=0;i<nombreMaterias.length; i++){
            nombreMaterias[i]=Materia.materias[i].getNombre();
        }

        ArrayAdapter<String> adaptador=new ArrayAdapter<>(inflater.getContext(),
                android.R.layout.simple_list_item_1, nombreMaterias);
        setListAdapter(adaptador);

        return super.onCreateView(inflater,container,savedInstanceState);
    }

    public static interface Listener{
        void itemClicked(int posicion);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        listener = (Listener) context;

    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        listener.itemClicked(position);
    }
}
