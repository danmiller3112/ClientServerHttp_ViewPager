package com.roll.clientserverhttp_viewpager;


import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.roll.clientserverhttp_viewpager.entities.User;
import com.roll.clientserverhttp_viewpager.model.HttpProvider;

import java.io.IOException;
import java.util.Random;

/**
 * Created by RDL on 05/03/2017.
 */

public class ViewPageFrag extends Fragment {

    private String title;

    public static ViewPageFrag newInstance(String title) {
        ViewPageFrag fragment = new ViewPageFrag();
        Bundle data = new Bundle();
        data.putString("TITLE", title);
        fragment.setArguments(data);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            title = getArguments().getString("TITLE", "Empty");
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.frag_viewpage, null);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        EditText titleTxt = (EditText) view.findViewById(R.id.view_name);
        titleTxt.setText(title);
    }


//    private EditText nameView, emailView, phoneView, descView;
//    private ProgressBar progressView;
//    private String userJson, token;
//    private String name, email, phone, desc;
//    private MenuItem editItem, saveItem;
//    private User user;
//    private Context context;
//
//    public static ViewPageFrag newInstance(String s) {
//        ViewPageFrag fragment = new ViewPageFrag();
//        Bundle data = new Bundle();
//        data.putString("USER", s);
//        fragment.setArguments(data);
//        return fragment;
//    }
//
////    @Override
////    public void onAttach(Activity activity) {
////        super.onAttach(activity);
////        listener = (CallbackListener) activity;
////    }
////
////    @Override
////    public void onAttach(Context context) {
////        super.onAttach(context);
////        if (context instanceof CallbackListener) {
////            listener = (CallbackListener) context;
////        } else {
////            throw new RuntimeException("Context must implements CallbackListener");
////        }
////    }
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        setHasOptionsMenu(true);
//        super.onCreate(savedInstanceState);
//    }
//
//    @Nullable
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        View view = inflater.inflate(R.layout.frag_viewpage, null);
//        return view;
//    }
//
//    @Override
//    public void onViewCreated(View view, Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//        nameView = (EditText) view.findViewById(R.id.view_name);
//        emailView = (EditText) view.findViewById(R.id.view_email);
//        phoneView = (EditText) view.findViewById(R.id.view_phone);
//        descView = (EditText) view.findViewById(R.id.view_desc);
//        progressView = (ProgressBar) view.findViewById(R.id.progress_view);
//
//        context = getActivity().getApplicationContext();
//
//        SharedPreferences sharedPreferences = context.getSharedPreferences("AUTH", Context.MODE_PRIVATE);
//        token = sharedPreferences.getString("TOKEN", "");
////        userJson = sharedPreferences.getString("USER", "");
//        if (getArguments() != null){
//            userJson = getArguments().getString("USER", "");
//        }
//        Gson gson = new Gson();
//        user = gson.fromJson(userJson, User.class);
//
//        nameView.setText(user.getFullName());
//        emailView.setText(user.getEmail());
//        phoneView.setText(user.getPhoneNumber());
//        descView.setText(user.getDescription());
//    }
//
//    @Override
//    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
//        inflater.inflate(R.menu.menu_view, menu);
//        editItem = menu.findItem(R.id.item_edit);
//        saveItem = menu.findItem(R.id.item_save);
//        saveItem.setVisible(false);
//        super.onCreateOptionsMenu(menu, inflater);
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
//            case R.id.item_edit:
//                editItem.setVisible(false);
//                saveItem.setVisible(true);
//                nameView.setEnabled(true);
//                emailView.setEnabled(true);
//                phoneView.setEnabled(true);
//                descView.setEnabled(true);
//                break;
//            case R.id.item_save:
//                phone = String.valueOf(phoneView.getText());
//                if ("".equals(phone)) {
//                    Toast.makeText(context, "Phone number is EMPTY!!!", Toast.LENGTH_LONG).show();
//                } else {
//                    editItem.setVisible(true);
//                    saveItem.setVisible(false);
//                    name = String.valueOf(nameView.getText());
//                    email = String.valueOf(emailView.getText());
//                    desc = String.valueOf(descView.getText());
//                    new SaveAsynkTask().execute();
//                }
//                break;
//        }
//        return super.onOptionsItemSelected(item);
//    }
//
//    class SaveAsynkTask extends AsyncTask<Void, Void, String> {
//
//        @Override
//        protected void onPreExecute() {
//            super.onPreExecute();
//            progressView.setVisibility(View.VISIBLE);
//            nameView.setEnabled(false);
//            emailView.setEnabled(false);
//            phoneView.setEnabled(false);
//            descView.setEnabled(false);
//        }
//
//        @Override
//        protected String doInBackground(Void... params) {
//            String result = "Edit OK!";
//            userJson = new Gson().toJson(new User(name, email, phone, desc, user.getContactId()));
//            try {
//                String jsonResponse = HttpProvider.getInstance().edit(token, userJson);
//            } catch (IOException e) {
//                e.printStackTrace();
//                result = "Connection ERROR!";
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//            return result;
//        }
//
//        @Override
//        protected void onPostExecute(String s) {
//            super.onPostExecute(s);
//            progressView.setVisibility(View.INVISIBLE);
//            Toast.makeText(context, s, Toast.LENGTH_SHORT).show();
//            if ("Edit OK!".equals(s)) {
////                listener.sameAction("SAVE_OK");
//            }
//        }
//    }
}
