package com.example.todolisttwo;

import android.content.Context;
import android.graphics.Paint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.example.todolisttwo.R.id.id_list_view;
import static com.example.todolisttwo.R.id.text_view;
import static com.example.todolisttwo.R.layout.fragment_to_do_list_list;


/**
 * A fragment representing a list of Items.
 */
public class ToDoListFragment extends Fragment {
//declare class variables

    List<String> toDoList;
    //ArrayAdapter arrayAdapter;
    EditText editText;
    private Object ListView;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ToDoListFragment() {
    }


    public static ToDoListFragment newInstance(int columnCount) {
        ToDoListFragment fragment = new ToDoListFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //View view = inflater.inflate(R.layout.fragment_to_do_list_list, container, false);
        View view = inflater.inflate(R.layout.fragment_to_do_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            recyclerView.setLayoutManager(new LinearLayoutManager(context));

           // recyclerView.setAdapter(new MyItemRecyclerViewAdapter(Arrays.asList(myContent)));
        }
        return view;
    }
    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //does code go here?
        Context context=getActivity();
        toDoList = new ArrayList<>();
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(context, fragment_to_do_list_list, toDoList);
                //This is what's fucking it up!
        // needs a view?
        //also could use view.findViewById() I think?
        ListView listView = (ListView) getView().findViewById(R.id.id_list_view);
        listView.setAdapter(arrayAdapter);



        /*listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                TextView textView = (TextView) view;
                textView.setPaintFlags(textView.getPaintFlags()| Paint.STRIKE_THRU_TEXT_FLAG);
            }
        });
     

        editText= editText.findViewById(R.id.textview_first);
    }

    public void addItemToList(View view) {
        toDoList.add(editText.getText().toString());
        arrayAdapter.notifyDataSetChanged();

        editText.setText("");*/
        view.findViewById(R.id.Add3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(ToDoListFragment.this)
                        .navigate(R.id.action_toDoListFragment_to_SecondFragment);
            }
       });
    }

}